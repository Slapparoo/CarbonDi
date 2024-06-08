#include "eccore.h"
#include <stdarg.h>


char tmpBuffer[1024];

// @TODO these stacks need to have one per thread
// @TODO get rid of the indirection and just have the pointer to the object?
Object_ref *poorMansMap[PM_LIST_LENGTH];
num refStack[PM_LIST_LENGTH];
u64 refStackIndex = 0;
#ifdef __SUPPORT_TIME_
struct timespec __times_[PM_LIST_LENGTH];
u64 timesIndex = 0;
#endif

i64 _class_models_index = 0;
pointer _class_models[PM_LIST_LENGTH];
ExceptionInformation  *exceptionInformation[20];
i64 exceptionInformationIndex=-1;

i64 inflightMemIndex = -1;
pointer _inflight_mem[INFLIGHT_MEMSIZE];
// memory allocations very basic map
num memoryAllocsId[PM_LIST_LENGTH];
pointer memoryAllocsPointer[PM_LIST_LENGTH];
pointer alloc_min = 0;
pointer alloc_max = 0;

i64 enterExitRatio = 0;

void printClassModels() {
  i64 cms = _class_models_index -1;
  while (cms >= 0) {
    debug_println("class models %ld %p", 
      cms, 
      _class_models[cms]);
    cms--;
  }
}

void updateMemoryAllocation(num ref, pointer oldp, pointer newp) {
  boolean found = false;
  for (u64 i = 0; i < PM_LIST_LENGTH; i++) {
    if (memoryAllocsPointer[i] == oldp) {
      memoryAllocsPointer[i] = newp;
      found = true;
      break;
    }
  }
  if (!found) {
    registerMemoryAllocation(ref, newp);
  }
}

void registerMemoryAllocation(num ref, pointer mem) {
  boolean registed = false;
  for (u64 i = 0; i < PM_LIST_LENGTH; i++) {
    if (memoryAllocsId[i] == 0) {
      memoryAllocsId[i] = ref;
      memoryAllocsPointer[i] = mem;
      registed = true;
      break;
    }
  }

  if (!registed) {
    throwException("Out of memory Exception [Memory Allocations register].");
  }
}

void freeMemoryAllocation(num ref) {
  for (u64 i = 0; i < PM_LIST_LENGTH; i++) {
    if (memoryAllocsId[i] == ref) {
      memoryAllocsId[i] = ref;
      ec_free(memoryAllocsPointer[i]);

      memoryAllocsId[i] = 0;
      memoryAllocsPointer[i] = NULL;

      debug_println("free %ld ", ref);
    }
  }
}


/**
 * used when variable or property is assgined a value
 */
void assignObject(num *var, num ref_id) {
  // release the old value
  // printf(ANSI_BLUE "[types.c] assignObject %ld, %ld\n" ANSI_DEFAULT, *var, ref_id);
  if (*var > 0) {
    returnObject(var[0]);
    *var = 0;
  }
  // assign the new
  if (ref_id > 0) {
    *var = ref_id;
    borrowObject(ref_id);
  }
  debug_println("var=%ld, id=%ld", *var, ref_id);
}

void borrowOnReturnObject(num ref) {
  Object_ref *object_ref = poorMansMap[ref];
  object_ref->refCounter++;
}

Object_ref *borrowObject(num ref) {
  // find object
  if (ref < 1) {
    throwException("Null pointer exception.");
    return 0;
  }

  Object_ref *object_ref = poorMansMap[ref];

  // inc ref counter
  object_ref->refCounter++;
  return object_ref;
}

/**
 * Called by returnObject if the ref counter == 0
 */
void freeObject(num ref, Object_ref *object_ref) {
    // dereferenced deallocate etc
    // call the class destructor(s)
    c_2106303_Object_cm* thisObject = (c_2106303_Object_cm*)object_ref->classmodel;

    if (thisObject->release != NULL) {  
      thisObject->release(ref);
    }
    thisObject->free(ref);

    c_2106303_Object_cm *cm = (c_2106303_Object_cm *)thisObject->parent;

    pointer l_free = thisObject->free;
    pointer l_release = thisObject->release;
    while (cm) {
      // don't call the same free twice
      if (l_free != cm->free) {
        // cm->free(ref);
        l_free = cm->free;
      }

      if (cm->release != NULL && l_release != cm->release) {  
        cm->release(ref);
        l_release = cm->release;
      }
      
      cm = (c_2106303_Object_cm *)cm->parent;
    }

    freeMemoryAllocation(ref);

    if (!object_ref->is_stack) {
      ec_free(object_ref->data);
    }
    ec_free(object_ref);
    poorMansMap[ref] = NULL;

    debug_println("freed %ld", ref);
}

// used in destructors
Object_ref *useObject(num ref) { return poorMansMap[ref]; }

void returnObject(num ref) {
  if (ref < 1) {
    debug_println("ref:%ld attempting to return invalid Object", ref);
    return;
  }

  Object_ref *object_ref = poorMansMap[ref];
  // inc ref counter
  object_ref->refCounter--;

  // debug_println("Object returned, %s::%s ref:%ld counter=%ld", object_ref->classmodel->getClassPackage(0), object_ref->classmodel->getClassName(0), ref, object_ref->refCounter);

  if (object_ref->refCounter == 0) {
    freeObject(ref, object_ref);
  }
}



u64 __onEnter() {
  enterExitRatio++;
  u64 res = refStackIndex;
  // [id, id, id, count, id, id, count, id, id, id, count]
  // or [id, id, id, 0, id, id, 0, id, id, id, 0, id]
  // push(0);

  if (refStackIndex == PM_LIST_LENGTH) {
    throwException("Out of memory Exception [Reference stack space].");
  }

  refStack[refStackIndex++] = 0;

  // debug_println("timesIndex=%lu", timesIndex);
#ifdef __SUPPORT_TIME_  
  if (timesIndex+1 >= PM_LIST_LENGTH) {
    throwException("Out of memory Exception [Timings stack space].");
  }
#ifdef PRINT_TIMES  
  clock_gettime(CLOCK_THREAD_CPUTIME_ID, &__times_[timesIndex++]);
  clock_gettime(CLOCK_MONOTONIC_RAW, &__times_[timesIndex++]);
#endif  
#endif
  return res;
};

#define TIME_MULTIPLIER 1E9

void __onExit() {
  // pop until 0
  enterExitRatio--;
  // debug_println("%ld, enterExitRatio=%ld", refStackIndex, enterExitRatio);

  num id = refStack[--refStackIndex];
  while (id > 0) {
    returnObject(id);
    id = refStack[--refStackIndex];
  }
#ifdef PRINT_TIMES  
  struct timespec et_id, et_raw;

  clock_gettime(CLOCK_THREAD_CPUTIME_ID, &et_id);
  clock_gettime(CLOCK_MONOTONIC_RAW, &et_raw);

  timesIndex--;
  u64 t_raw = ( et_raw.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_raw.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;
  timesIndex--;
  u64 t_id = ( et_id.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_id.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;

  time_println("raw=%ld cpu=%ld", t_raw, t_id);
#endif  
  // debug_println("<--%s","");
};

void __unWindTo(u64 checkPoint) {
  // release all Ojbects after (x)
  // used during exception handleing

#ifdef PRINT_TIMES  
  struct timespec et_id, et_raw;

  clock_gettime(CLOCK_THREAD_CPUTIME_ID, &et_id);
  clock_gettime(CLOCK_MONOTONIC_RAW, &et_raw);

  timesIndex--;
  u64 t_raw = ( et_raw.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_raw.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;
  timesIndex--;
  u64 t_id = ( et_id.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_id.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;

  time_println("raw=%ld cpu=%ld", t_raw, t_id);
#endif  


  enterExitRatio--;
  debug_println("currentIndex=%lu, unwindto=%lu, enterExitRatio=%li", refStackIndex, checkPoint, enterExitRatio);

  if (checkPoint == refStackIndex) {
    return;
  }

  while (--refStackIndex > checkPoint) {
    num  id = refStack[refStackIndex];
    if (id) {
      returnObject(id);
    }
  }
};

num __currentStackIndex() {
  return refStackIndex;
}

//*********
i64 __exitReturn_i64_un(i64 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}

u64 __exitReturn_u64_un(u64 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}


u32 __exitReturn_u32_un(u32 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}

i32 __exitReturn_i32_un(i32 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
u16 __exitReturn_u16_un(u16 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
i16 __exitReturn_i16_un(i16 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
i8 __exitReturn_i8_un(i8 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
u8 __exitReturn_u8_un(u8 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
f32 __exitReturn_f32_un(f32 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
f64 __exitReturn_f64_un(f64 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
#ifdef __SUPPORT_QUADMATH_
f128 __exitReturn_f128_un(f128 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
f80 __exitReturn_f80_un(f80 a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
#endif
boolean __exitReturn_boolean_un(boolean a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}
num __exitReturn_num_un(num a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}

int __exitReturn_int_un(int a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}

pointer __exitReturn_pointer_un(pointer a, u64 checkPoint) {
  __unWindTo(checkPoint);
  return a;
}

num __exitReturn_ref_un(num a, u64 checkPoint) {
  // increase the ref counter, unwind the stack, then put back on stack
  // so it does'nt get freed
  borrowOnReturnObject(a);
  __unWindTo(checkPoint);
  refStack[refStackIndex++] = a;
  return a;
}

void __exitReturn_void_un(u64 checkPoint) {
  __unWindTo(checkPoint);
}


// //**************** old -->

// i64 __exitReturn_i64(i64 a) {
//   __onExit();
//   return a;
// }

// u64 __exitReturn_u64(u64 a) {
//   __onExit();
//   return a;
// }


// u32 __exitReturn_u32(u32 a) {
//   __onExit();
//   return a;
// }

// i32 __exitReturn_i32(i32 a) {
//   __onExit();
//   return a;
// }
// u16 __exitReturn_u16(u16 a) {
//   __onExit();
//   return a;
// }
// i16 __exitReturn_i16(i16 a) {
//   __onExit();
//   return a;
// }
// i8 __exitReturn_i8(i8 a) {
//   __onExit();
//   return a;
// }
// u8 __exitReturn_u8(u8 a) {
//   __onExit();
//   return a;
// }
// f32 __exitReturn_f32(f32 a) {
//   __onExit();
//   return a;
// }
// f64 __exitReturn_f64(f64 a) {
//   __onExit();
//   return a;
// }
// #ifdef __SUPPORT_QUADMATH_
// f128 __exitReturn_f128(f128 a) {
//   __onExit();
//   return a;
// }
// f80 __exitReturn_f80(f80 a) {
//   __onExit();
//   return a;
// }
// #endif
// boolean __exitReturn_boolean(boolean a) {
//   __onExit();
//   return a;
// }
// num __exitReturn_num(num a) {
//   __onExit();
//   return a;
// }

// int __exitReturn_int(int a) {
// __onExit();
//   return a;
// }

// pointer __exitReturn_pointer(pointer a) {
//   __onExit();
//   return a;
// }


// num __exitReturn_ref(num a) {
//   // be sure to record the reference
//   borrowOnReturnObject(a);
//   __onExit();
//   refStack[refStackIndex++] = a;
//   return a;
// }


//************* <--
void registerClassModel(pointer classmodel) {
  debug_println("pointer %ld, %p, %i", _class_models_index, classmodel, PM_LIST_LENGTH);

  if (_class_models_index == PM_LIST_LENGTH) {
    // free(classmodel);
    throwException("Out of memory Exception [Class model space].");
  }

  _class_models[_class_models_index++] = classmodel;
}

/**
 * clean up he class model, so after this is run anything left in memory is a memory leak
 * 
 * this is important so when you run valgrind there should be no memory still allocated
 */
void __onFinalExit() {
  // release exceptionstack;
  while (exceptionInformationIndex >= 0) {
    // debug_println("free exceptionInformationIndex %ld, %p", exceptionInformationIndex, exceptionInformation[exceptionInformationIndex]);
    ec_free(exceptionInformation[exceptionInformationIndex]);
    exceptionInformationIndex--;
  }

  // free inflight memory
  while (inflightMemIndex >= 0) {
    ec_free(_inflight_mem[inflightMemIndex--]);
  }
}

/**
 * if is_stack is true the "data" memory for the object won't get freed on free, this is used where the 
 * data memory is managed else where, or the memory has been statically allocated
 */ 
num createObject(pointer object_data, pointer class_model, boolean is_stack) {
  // load the class model into cache read-only
  __builtin_prefetch (class_model, 0, 3);
  __builtin_prefetch (object_data, 1, 3);

  num id = -1;
  for (int i = 1; i < PM_LIST_LENGTH; i++) {
    if (poorMansMap[i] == NULL) {
      id = i;
      break;
    }
  }

  // bounds check
  if (id < 1) {
    // free the object_data - this gets interesting as part of the constructor has run
    // but the object isn't registered yet
    // the program is most probaly in an unstable state now and can't continue and will need to error exit.
    // this is also the second allocation space error thrown

    throwException("Out of memory Exception [Object allocation space] (2).");
  }

  // debug_println("%s::%s ref:%ld", ((c_2106303_Object_cm*)class_model)->getClassPackage(0), ((c_2106303_Object_cm*)class_model)->getClassName(0), id);

  struct Object_ref *ref = (Object_ref *)ec_malloc(sizeof(struct Object_ref));

  __builtin_prefetch (ref, 1, 3);

  ref->data = object_data;
  ref->classmodel = class_model;
  ref->refCounter = 1;
  ref->is_stack = is_stack;

  // add to map
  poorMansMap[id] = ref;
  refStack[refStackIndex++] = id;

  if (id == PM_LIST_LENGTH -1) {

    // grow

    throwException("Out of memory Exception [Object allocation space].");
  }

  inflightMemIndex = -1;
  return id;
}

void print_log(int count, ...) {

  va_list valist;

  va_start(valist, count);

    for ( int i = 0; i < count; i++ ) {
        num refId = va_arg(valist, num);
        if (i == 0) {
          if (refId < 1) {
            printf("null");
          } else {
            printf( "%s", ((c_2106303_Object_cm*)useObject(refId)->classmodel)->asStr(refId));
          }
        } else {
          if (refId < 1) {
            printf(", null");
          } else {
            printf( ", %s", ((c_2106303_Object_cm*)useObject(refId)->classmodel)->asStr(refId));
          }
        }
    }

    va_end(valist);
    printf("\n");
}

char* dynamic_sprintf(char const *msg, i64 errorno) {
    // snprintf returns the length of the string

    // asprintf?
    size_t needed = snprintf(NULL, 0, "%s: %s (%ld)", msg, strerror(errorno), errorno) + 1;
    char  *buffer = ec_malloc(needed);
    // should this also be snprintf?
    sprintf(buffer, "%s: %s (%ld)", msg, strerror(errorno), errorno);
    return buffer;
}

pointer getTmpBuffer() {
  return tmpBuffer;
}

void test(int expr, pointer message) {
  if (!expr) {
    throwException(message);
  }
}

void testi64Equal(pointer message, i64 expected, i64 actual) {
  if (expected != actual) {
    sprintf(tmpBuffer, "(test failed) %s, %li != %li ", message, expected, actual);
    throwException(tmpBuffer);
  }
}

void testStrEqual(pointer message, pointer expected, pointer actual) {
  if (expected != actual) {
    int res = strcmp(expected, actual);

    if (res) {
      sprintf(tmpBuffer, "(test failed) Strings not equal %s, %d, '%s' != '%s'", message, res, expected, actual);
      throwException(tmpBuffer);
    }
  }
}

// ********** Old Exception ==>

/**
 * this will need to evolve a bit - change to getting passed and exception
 */ 
void throwException(pointer message) {
  exceptionInformation[exceptionInformationIndex]->message = message;
  longjmp(exceptionInformation[exceptionInformationIndex]->buf, 1);
}

jmp_buf *catchException() {

  // debug_println("sizeof jmp_buf %lu, ExceptionInformation %lu", sizeof(jmp_buf), sizeof(ExceptionInformation));

  exceptionInformationIndex++;
  ExceptionInformation *ei = ec_malloc(sizeof(ExceptionInformation));
  exceptionInformation[exceptionInformationIndex] = ei;
  ei->currentStack = __currentStackIndex();
  ei->classCName = NULL;
  ei->exception = 0;


  return &ei->buf;
}

void afterCatchException() {
  ExceptionInformation *ei = exceptionInformation[exceptionInformationIndex];
  printf(ANSI_RED "Error : %s\n" ANSI_DEFAULT , ei->message);

  // debug_println("exceptionInformation %p, %lu, %p", ei->buf, ei->currentStack, ei->message);

  __unWindTo(ei->currentStack);
  // debug_println("free exceptionInformationIndex %ld, %p", exceptionInformationIndex, ei);
  ec_free(ei);
  exceptionInformationIndex--;
}

// ********** <== Old Exception

// ********** new Exception ==>

/**
 * @TODO there needs to be a stack per thread
 * 
 * 
 * Called by Throw
 */
void throw(num exception) {
  newThrowException(exception);
}

void newThrowException(num exception) {
  // borrow the object so the ref counter is incremented
  pointer cname = ((c_2106303_Object_cm*)borrowObject(exception)->classmodel)->classCName();
  debug_println("ExceptionInformation %s", cname);

  // iterate through until the exception is matched
  int i = exceptionInformationIndex;

  while (i > 0) {
    debug_println("loop %i %s %i", i, exceptionInformation[i]->classCName, strcmp(exceptionInformation[i]->classCName, cname));
    if (!strcmp(exceptionInformation[i]->classCName, cname)) {
      exceptionInformationIndex = i;
      exceptionInformation[i]->exception = exception;
      longjmp(exceptionInformation[i]->buf, 1);
    }
    ec_free(exceptionInformation[i]);
    i--;
  }

  // catch not found, call the default exception handler
  exceptionInformationIndex = 0;
  exceptionInformation[exceptionInformationIndex]->exception = exception;
  longjmp(exceptionInformation[exceptionInformationIndex]->buf, 1);
}

/**
 * Exceptions are stored in a stack, set up the catchs
 */ 
jmp_buf *newCatchException(pointer cname) {
  exceptionInformationIndex++;
  ExceptionInformation *ei = ec_malloc(sizeof(ExceptionInformation));
  exceptionInformation[exceptionInformationIndex] = ei;
  ei->currentStack = __currentStackIndex();
  ei->classCName = cname;
  ei->exception = 0;

  debug_println("sizeof jmp_buf %lu, ExceptionInformation %lu cname %s, index=%li", sizeof(jmp_buf), sizeof(ExceptionInformation), cname, exceptionInformationIndex);
  return &ei->buf;
}

num getException() {
  return exceptionInformation[exceptionInformationIndex]->exception;
}

/**
 * pops the catch off the exception stack - because it does an unwind you can cut in at any offset
 */ 
void newAfterCatchException() {
  ExceptionInformation *ei = exceptionInformation[exceptionInformationIndex];
  // printf(ANSI_RED "Error : %s\n" ANSI_DEFAULT , ei->message);

  if (ei->classCName == NULL) {
    debug_println("exceptionInformation %p, %lu, index=%li", ei->buf, ei->currentStack, exceptionInformationIndex);
  } else {
    debug_println("exceptionInformation %p, %lu, %s index=%li", ei->buf, ei->currentStack, ei->classCName, exceptionInformationIndex);
  }

  if (ei->exception != 0) {
    returnObject(ei->exception);
  }

  __unWindTo(ei->currentStack);
  // debug_println("free exceptionInformationIndex %ld, %p", exceptionInformationIndex, ei);
  ec_free(ei);
  exceptionInformationIndex--;
}

/**
 * clean the stack to index
 */
void cleanExceptionIndex(i64 index) {
  // debug_println("orIndex=%li, index=%li", index, exceptionInformationIndex);
  while (exceptionInformationIndex > index +1 && exceptionInformationIndex > 0) {
    debug_println("orIndex=%li, index=%li", index, exceptionInformationIndex);
    ExceptionInformation *ei = exceptionInformation[exceptionInformationIndex];
    if (ei->exception != 0) {
      returnObject(ei->exception);
    }
    ec_free(ei);
    exceptionInformationIndex--;
  }

  newAfterCatchException();
}

i64 getExceptionIndex() {
  return exceptionInformationIndex;
}

// ********** <== new exception

pointer ec_malloc(size_t size) {
  pointer res = malloc(size);
  if (res == NULL) {
    // if this gets throw the system is unstable and the application should be stopped
    throwException("Out of memory Exception [heap malloc].");
  } 

  // Maintain the alloc min max
  if (alloc_min == 0) {
    alloc_min = res;
  }

  if (res > alloc_max) {
    alloc_max = res;
  } 
  
  if (res < alloc_min) {
    alloc_min = res;
  }

  debug_println(" %p, min=%p, max=%p ", res, alloc_min, alloc_max);

  inflightMemIndex++;
  if (inflightMemIndex >= INFLIGHT_MEMSIZE) {
    throwException("Out of memory Exception [inflight buffer].");
  }
  _inflight_mem[inflightMemIndex] = res;
  return res;
}

pointer ec_calloc(size_t length, size_t size) {
  pointer res = calloc(length, size);
  if (res == NULL) {
    // if this gets throw the system is unstable and the application should be stopped
    throwException("Out of memory Exception [heap calloc].");
  } 

  // Maintain the alloc min max
  if (alloc_min == 0) {
    alloc_min = res;
  }

  if (res > alloc_max) {
    alloc_max = res;
  } 
  
  if (res < alloc_min) {
    alloc_min = res;
  }

  debug_println(" %p, min=%p, max=%p ", res, alloc_min, alloc_max);

  inflightMemIndex++;
  if (inflightMemIndex >= INFLIGHT_MEMSIZE) {
    throwException("Out of memory Exception [inflight buffer].");
  }
  _inflight_mem[inflightMemIndex] = res;
  return res;
}


pointer ec_realloc(pointer ptr, size_t size) {

  if (ptr < alloc_min || ptr > alloc_max) {
    // probably a static allocation
    return ec_malloc(size);
  }

  pointer res = realloc(ptr, size);
  if (res == NULL) {
    // if this gets throw the system is unstable and the application should be stopped
    throwException("Out of memory Exception [heap realloc].");
  } 

  // Maintain the alloc min max
  if (alloc_min == 0) {
    alloc_min = res;
  }

  if (res > alloc_max) {
    alloc_max = res;
  } 
  
  if (res < alloc_min) {
    alloc_min = res;
  }

  return res;
}


void ec_free(pointer p) {

  debug_println("%p", p);

  if (p < alloc_min || p > alloc_max) {
    // probably a static allocation

    debug_println("not freed %p, min=%p, max=%p ", p, alloc_min, alloc_max);
    return;
  }

  if (p == NULL) {
    return;
  }
  free(p);

  for (int i = 0; i < INFLIGHT_MEMSIZE; i++) {
    if (_inflight_mem[i] == p) {
      _inflight_mem[i] = NULL;
    }
  }
}
