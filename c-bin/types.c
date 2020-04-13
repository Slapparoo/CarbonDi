#include "types.h"
#include <stdarg.h>
#include "Core.Object.h"
#include "Core.String.h"

Object_ref *poorMansMap[PM_LIST_LENGTH];
num refStack[PM_LIST_LENGTH];
num refStackIndex = 0;
struct timespec __times_[PM_LIST_LENGTH];
num timesIndex = 0;

int _class_models_index = 0;
pointer _class_models[PM_LIST_LENGTH];
ExceptionInformation  *exceptionInformation[20];
int exceptionInformationIndex=-1;

int inflightMemIndex = -1;
pointer _inflight_mem[INFLIGHT_MEMSIZE];
// memory allocations very basic map
num memoryAllocsId[PM_LIST_LENGTH];
pointer memoryAllocsPointer[PM_LIST_LENGTH];

//typedef enum {_u32, _i32, _i64, _u64, _u16, _i16, _i8, _u8, _f32, _f64, _num, _f128, _f80, _pointer, _struct } primative_types;

pointer primative_names[] = {"u32", "i32", "i64", "u64", "u16", "i16", "i8", "u8", "f32", "f64", "num", "f128", "f80", "boolean", "pointer", "struct", "Object"};

void printClassModels() {
  int cms = _class_models_index -1;
  while (cms >= 0) {
    debug_println("class models %d %p", 
      cms, 
      _class_models[cms]);
    cms--;
  }
}

void registerMemoryAllocation(num ref, pointer mem) {
  boolean registed = false;
  for (int i = 0; i < PM_LIST_LENGTH; i++) {
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
  for (int i = 0; i < PM_LIST_LENGTH; i++) {
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

  // debug_println("%s::%s ref:%ld counter=%ld", object_ref->classmodel->getClassPackage(0), object_ref->classmodel->getClassName(0), ref, object_ref->refCounter);

  return object_ref;
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
    // dereferenced deallocate etc
    // call the class destructor(s)
    ObjectClassModel* thisObject = (ObjectClassModel*)object_ref->classmodel;

    if (thisObject->release != NULL) {  
      thisObject->release(ref);
    }
    thisObject->free(ref);

    ObjectClassModel *cm = (ObjectClassModel *)thisObject->parent;

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
      
      cm = (ObjectClassModel *)cm->parent;
    }

    freeMemoryAllocation(ref);

    if (!object_ref->is_stack) {
      ec_free(object_ref->data);
    }
    ec_free(object_ref);
    poorMansMap[ref] = NULL;

    debug_println("freed %ld", ref);
  }
}



void __onEnter() {
  // [id, id, id, count, id, id, count, id, id, id, count]
  // or [id, id, id, 0, id, id, 0, id, id, id, 0, id]
  // push(0);

  if (refStackIndex == PM_LIST_LENGTH) {
    throwException("Out of memory Exception [Reference stack space].");
  }

  refStack[refStackIndex++] = 0;

  if (timesIndex+1 >= PM_LIST_LENGTH) {
    throwException("Out of memory Exception [Timings stack space].");
  }

  clock_gettime(CLOCK_THREAD_CPUTIME_ID, &__times_[timesIndex++]);
  clock_gettime(CLOCK_MONOTONIC_RAW, &__times_[timesIndex++]);
};

#define TIME_MULTIPLIER 1E9

void __onExit() {
  // pop until 0
  debug_println("%ld", refStackIndex);

  num id = refStack[--refStackIndex];
  while (id > 0) {
    returnObject(id);
    id = refStack[--refStackIndex];
  }

  struct timespec et_id, et_raw;
  clock_gettime(CLOCK_THREAD_CPUTIME_ID, &et_id);
  clock_gettime(CLOCK_MONOTONIC_RAW, &et_raw);

  timesIndex--;
  u64 t_raw = ( et_raw.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_raw.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;
  timesIndex--;
  u64 t_id = ( et_id.tv_nsec - __times_[timesIndex].tv_nsec ) + ( et_id.tv_sec - __times_[timesIndex].tv_sec ) * TIME_MULTIPLIER;

  time_println("raw=%ld cpu=%ld", t_raw, t_id);
  debug_println("<--%s","");
};

void __unWindTo(num checkPoint) {
  // release all Ojbects after (x)
  // used during exception handleing

  debug_println("%ld", refStackIndex);

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

i64 __exitReturn_i64(i64 a) {
  __onExit();
  return a;
}

u64 __exitReturn_u64(u64 a) {
  __onExit();
  return a;
}
u32 __exitReturn_u32(u32 a) {
  __onExit();
  return a;
}
i32 __exitReturn_i32(i32 a) {
  __onExit();
  return a;
}
u16 __exitReturn_u16(u16 a) {
  __onExit();
  return a;
}
i16 __exitReturn_i16(i16 a) {
  __onExit();
  return a;
}
i8 __exitReturn_i8(i8 a) {
  __onExit();
  return a;
}
u8 __exitReturn_u8(u8 a) {
  __onExit();
  return a;
}
f32 __exitReturn_f32(f32 a) {
  __onExit();
  return a;
}
f64 __exitReturn_f64(f64 a) {
  __onExit();
  return a;
}
#ifdef __SUPPORT_QUADMATH_
f128 __exitReturn_f128(f128 a) {
  __onExit();
  return a;
}
f80 __exitReturn_f80(f80 a) {
  __onExit();
  return a;
}
#endif
boolean __exitReturn_boolean(boolean a) {
  __onExit();
  return a;
}
num __exitReturn_num(num a) {
  __onExit();
  return a;
}

int __exitReturn_int(int a) {
__onExit();
  return a;
}

pointer __exitReturn_pointer(pointer a) {
  __onExit();
  return a;
}


num __exitReturn_ref(num a) {
  // be sure to record the reference
  borrowOnReturnObject(a);
  __onExit();
  refStack[refStackIndex++] = a;
  return a;
}

void registerClassModel(pointer classmodel) {
  debug_println("pointer %d, %p", _class_models_index, classmodel);

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
    debug_println("free exceptionInformationIndex %d, %p", exceptionInformationIndex, exceptionInformation[exceptionInformationIndex]);
    ec_free(exceptionInformation[exceptionInformationIndex]);
    exceptionInformationIndex--;
  }

  _class_models_index--;
  while (_class_models_index >= 0) {
    debug_println("free class model %d, %s %p", 
      _class_models_index, 
      ((ObjectClassModel *)_class_models[_class_models_index])->getClassName(0),
      _class_models[_class_models_index]);
    ec_free(_class_models[_class_models_index]);
    _class_models_index--;
  }

  // free inflight memory
  while (inflightMemIndex >= 0) {
    ec_free(_inflight_mem[inflightMemIndex--]);
  }
}

/**
 * if is_stack is true the "data" memory for the object won't get freed on free, this is used where the 
 * data memory is managed else where
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

  debug_println("%s::%s ref:%ld", ((ObjectClassModel*)class_model)->getClassPackage(0), ((ObjectClassModel*)class_model)->getClassName(0), id);

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
    throwException("Out of memory Exception [Object allocation space].");
  }

  inflightMemIndex = -1;
  return id;
}

num Object_hashCode(num ref) {
  return (ref * 0xff3ff3ff3ff3ff13) >> 3;
}

boolean Object_equals(num ref, num other) {
  return ref == other;
} 


pointer Object_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  sprintf(tmpBuffer, ANSI_GREEN "ref:%ld, ref*=%p, data*=%p, class*=%p, refCount=%ld" ANSI_DEFAULT, ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter);
  return tmpBuffer;
}

void Object_printTo(num ref, pointer stream) {
  Object_ref *object_ref = useObject(ref);
  fprintf((FILE*)stream, ANSI_GREEN
          "(Object_printTo) %s::%s ref:%ld, ref*=%p, data*=%p, class*=%p, "
          "refCount=%ld, is_stack=%s\n" ANSI_DEFAULT,
          ((ObjectClassModel *)object_ref->classmodel)->getClassPackage(0), ((ObjectClassModel *)object_ref->classmodel)->getClassName(0), ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter, object_ref->is_stack ? "true" : "false");
}

pointer Object_getName(num ref) {
  return "Object";
}

pointer Object_getPackage(num ref) {
  return "Core";
}

pointer Object_alloc(num ref, u64 amount) {
  debug_println("alloc %ld %lud ", ref, amount);

  if (ref == 0) {
    throwException("Bad memory allocation request, invalid Id");
  }

  pointer res = ec_calloc(amount, 1);
  // resgiter ref as responsible
  registerMemoryAllocation(ref, res);
  return res;
}

void Object_free(num ref) {
  debug_println("%ld", ref);
}

ObjectClassModel *_objectClassModel = NULL;
// Str _ObjectName = NULL;
// Str _PackageName = NULL;

u64 Object_datasize(num id) {
  return 0;
}


pointer getObjectClassModel() {
  if (_objectClassModel == NULL) {
    _objectClassModel = ec_malloc(sizeof(ObjectClassModel));
    registerClassModel(_objectClassModel);
    populateObjectClassModel(_objectClassModel);
  }
  return _objectClassModel;
}

void populateObjectClassModel(pointer _classModel) {
  ObjectClassModel* classModel = (ObjectClassModel *)_classModel;
  classModel->parent = NULL;
  // classModel->name = "Object";
  // classModel->package = "Core";
  classModel->asStr = Object_asStr;
  classModel->asString = NULL;
  classModel->free = Object_free;
  classModel->printTo = Object_printTo;
  classModel->release = NULL;
  classModel->getClassName = Object_getName;
  classModel->getClassPackage = Object_getPackage;
  classModel->getObjectDatasize = Object_datasize;
  classModel->alloc = Object_alloc;
  
  classModel->hashCode = &Object_hashCode;
  classModel->equals = &Object_equals;
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


/**
 * this will need to evolve a bit - change to getting passed and exception
 */ 

void throwException(pointer message) {
  exceptionInformation[exceptionInformationIndex]->message = message;
  longjmp(exceptionInformation[exceptionInformationIndex]->buf, 1);
}

jmp_buf *catchException() {

  debug_println("sizeof jmp_buf %lu, ExceptionInformation %lu", sizeof(jmp_buf), sizeof(ExceptionInformation));

  exceptionInformationIndex++;
  ExceptionInformation *ei = ec_malloc(sizeof(ExceptionInformation));
  exceptionInformation[exceptionInformationIndex] = ei;
  ei->currentStack = __currentStackIndex();

  return &ei->buf;
}

void afterCatchException() {
  printf(ANSI_RED "Error : %s\n" ANSI_DEFAULT , exceptionInformation[exceptionInformationIndex]->message);
  __unWindTo(exceptionInformation[exceptionInformationIndex]->currentStack);
  debug_println("free exceptionInformationIndex %d, %p", exceptionInformationIndex, exceptionInformation[exceptionInformationIndex]);
  ec_free(exceptionInformation[exceptionInformationIndex]);
  exceptionInformationIndex--;
}

pointer ec_malloc(size_t size) {
  pointer res = malloc(size);
  if (res == NULL) {
    // if this gets throw the system is unstable and the application should be stopped
    throwException("Out of memory Exception [heap malloc].");
  } 

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
  inflightMemIndex++;
  if (inflightMemIndex >= INFLIGHT_MEMSIZE) {
    throwException("Out of memory Exception [inflight buffer].");
  }
  _inflight_mem[inflightMemIndex] = res;
  return res;
}

void ec_free(pointer p) {

  debug_println("%p", p);

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
