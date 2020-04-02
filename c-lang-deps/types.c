#include "types.h"

Object_ref *poorMansMap[PM_LIST_LENGTH];
num refStack[PM_LIST_LENGTH];
num refStackIndex = 0;
struct timespec __times_[PM_LIST_LENGTH];
num timesIndex = 0;

int _class_models_index = 0;
pointer _class_models[PM_LIST_LENGTH];


//typedef enum {_u32, _i32, _i64, _u64, _u16, _i16, _i8, _u8, _f32, _f64, _num, _f128, _f80, _pointer, _struct } primative_types;

Str primative_names[] = {"u32", "i32", "i64", "u64", "u16", "i16", "i8", "u8", "f32", "f64", "num", "f128", "f80", "boolean", "pointer", "struct", "Object"};


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
    error_println("requesting null object. %ld", ref);
    return 0;
  }

  Object_ref *object_ref = poorMansMap[ref];

  // inc ref counter
  object_ref->refCounter++;

  debug_println("%s::%s ref:%ld counter=%ld", object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref->refCounter);

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

  debug_println("Object returned, %s::%s ref:%ld counter=%ld", object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref->refCounter);

  if (object_ref->refCounter == 0) {
    // dereferenced deallocate etc
    // call the class destructor(s)
    if (object_ref->classmodel->close != NULL) {  
      object_ref->classmodel->close(ref);
    }
    object_ref->classmodel->free(ref);

    ClassModel *cm = object_ref->classmodel->parent;

    pointer l_free = object_ref->classmodel->free;
    while (cm) {
      // don't call the same free twice
      if (l_free != cm->free) {
        if (cm->close != NULL) {  
          cm->close(ref);
        }
        cm->free(ref);
      }
      l_free = cm->free;
      cm = cm->parent;
    }

    if (!object_ref->is_stack) {
      free(object_ref->data);
    }
    free(object_ref);
    poorMansMap[ref] = NULL;

    debug_println("freed %ld", ref);
  }
}

void __onEnter() {
  // [id, id, id, count, id, id, count, id, id, id, count]
  // or [id, id, id, 0, id, id, 0, id, id, id, 0, id]
  // push(0);
  refStack[refStackIndex++] = 0;
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
};


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

num __exitReturn_ref(num a) {
  // be sure to record the reference
  borrowOnReturnObject(a);
  __onExit();
  refStack[refStackIndex++] = a;
  return a;
}

void registerClassModel(pointer classmodel) {
  // debug_println("pointer %d, %p", _class_models_index, classmodel);
  _class_models[_class_models_index++] = classmodel;
}

/**
 * clean up he class model, so after this is run anything left in memory is a memory leak
 */
void __onFinalExit() {
  _class_models_index--;
  while (_class_models_index >= 0) {
    // debug_println("pointer %d, %p", _class_models_index, _class_models[_class_models_index]);
    free(_class_models[_class_models_index--]);
  }
}

num createObject(pointer object_data, ClassModel *class_model, boolean is_stack) {
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
    // bugger - in the future the map will be a proper one that can grwo etc...
    error_println("Out of memory Exception %ld", id);
    exit(1);
  }

  debug_println("%s::%s ref:%ld", class_model->package, class_model->name, id);

  struct Object_ref *ref = (Object_ref *)malloc(sizeof(struct Object_ref));
  __builtin_prefetch (ref, 1, 3);

  ref->data = object_data;
  ref->classmodel = class_model;
  ref->refCounter = 1;
  ref->is_stack = is_stack;

  // add to map
  poorMansMap[id] = ref;
  refStack[refStackIndex++] = id;

  return id;
}

/**
 * creats a mem copy of a string which will need to be freed
 */
Str returnStrCopy(Str str) {
  Str res = (Str)malloc(strlen(str)+1);
  strcpy(res, str);
  return res;
}

num Object_hashCode(num ref) {
  return (ref * 0xff3ff3ff3ff3ff13) >> 3;
}

boolean Object_equals(num ref, num other) {
  return ref == other;
} 


Str Object_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  sprintf(tmpBuffer, ANSI_GREEN "ref:%ld, ref*=%p, data*=%p, class*=%p, refCount=%ld" ANSI_DEFAULT, ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter);
  return tmpBuffer;
}

void Object_printTo(num ref, FILE *stream) {
  Object_ref *object_ref = useObject(ref);
  fprintf(stream, ANSI_GREEN
          "(Object_printTo) %s::%s ref:%ld, ref*=%p, data*=%p, class*=%p, "
          "refCount=%ld, is_stack=%s\n" ANSI_DEFAULT,
          object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter, object_ref->is_stack ? "true" : "false");
}

Str String_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  return ((String *)object_ref->data)->str;
}

void String_printTo(num ref, FILE *stream) {
  Object_ref *object_ref = useObject(ref);

  object_ref->classmodel->parent->printTo(ref, stream);
  fprintf(stream, ANSI_GREEN "(String_printTo) %s\n" ANSI_DEFAULT, ((String *)object_ref->data)->str);
}

void String_free(num ref) {
  Object_ref *object_ref = useObject(ref);
  // cast to our type
  String *string = (String *)object_ref->data;

  debug_println("%ld", ref);
  // other object variables referenced by type will need to be freed? have their
  // ref counter decremented
  free(string->str);
}

void Object_free(num ref) {
  debug_println("%ld", ref);
}

ObjectClassModel *_objectClassModel = NULL;
Str _ObjectName = NULL;
Str _PackageName = NULL;

ObjectClassModel *getObjectClassModel() {
  if (_objectClassModel == NULL) {
    _objectClassModel = malloc(sizeof(ObjectClassModel));
    registerClassModel(_objectClassModel);
    populateObjectClassModel(_objectClassModel);
  }
  return _objectClassModel;
}

void populateObjectClassModel(pointer _classModel) {
  ObjectClassModel *classModel = (ObjectClassModel *)_classModel;
  classModel->parent = NULL;
  classModel->name = "Object";
  classModel->package = "Core";
  classModel->asStr = &Object_asStr;
  classModel->asString = NULL;
  classModel->free = &Object_free;
  classModel->printTo = &Object_printTo;
  classModel->close = NULL;

  classModel->hashCode = &Object_hashCode;
  classModel->equals = &Object_equals;

}
/***
 * String
 */
StringClassModel *_stringClassModel = NULL;

void populateStringClassModel(pointer _classModel) {
  populateObjectClassModel(_classModel);

  StringClassModel *classModel = (StringClassModel *)_classModel;

  classModel->parent = getObjectClassModel();
  classModel->name = "String";
  classModel->package = "Core";
  classModel->asStr = &String_asStr;
  // classModel->asString = &String_asString;
  classModel->free = &String_free;
  classModel->printTo = &String_printTo;
}

StringClassModel *getStringClassModel() {
  if (_stringClassModel == NULL) {
    _stringClassModel = malloc(sizeof(StringClassModel));
    registerClassModel(_stringClassModel);
    populateStringClassModel(_stringClassModel);
  }
  return _stringClassModel;
}

num String_create(Str string) {
  String *_String = malloc(sizeof(String));
  // _String->len = strlen(string);
  // _String->str = malloc(_String->len + 1);
    num len = strlen(string) + 1;
  _String->str = malloc(len);

  strcpy(_String->str, string);
  return createObject(_String, (ClassModel *)getStringClassModel(), false);
}
