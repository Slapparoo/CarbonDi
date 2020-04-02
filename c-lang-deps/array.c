#include "array.h"

/**
num Array_create(length, type, size)
class Array {
  ObjectClassModel* parent();
  char *name = "Array";
  char *package = "Core";
  char *asStr(id);
  void free(id);
  void printTo(id, stream);

  num length(id);
  num capacity(id);
  void *array(id);
  primative_types type(id);

  void* get(id, index);
  void set(id, index, void*);
} 

num RefArray_create(length)

Same as Array except special handling if get and set
- this probably shouldn't expose the 'naked' array as it could screw ref counting
*/

Str Array_asStr(num ref) {
  Array *array = (Array *)useObject(ref)->data;
  sprintf(tmpBuffer, "(Array) type=%d, length=%ld\n", array->type, array->length);
  return tmpBuffer;
}

void Array_printTo(num ref, FILE *stream) {
  Object_ref *object_ref = useObject(ref);

  object_ref->classmodel->parent->printTo(ref, stream);
  fprintf(stream, ANSI_GREEN "(Array_printTo) %s\n" ANSI_DEFAULT, Array_asStr(ref));
}

void Array_free(num ref) {
  debug_println("%ld", ref);

  Array *array = (Array *)useObject(ref)->data;

  if (array->managed) {
    free(array->array);
  }
}

primative_types Array_type(num ref) {
  return ((Array *)useObject(ref)->data)->type;
}

Str Array_typename(num ref) {
  return primative_names[(int)Array_type(ref)];
}

num Array_length(num ref) {
  return ((Array *)useObject(ref)->data)->length;
}

num Array_capacity(num ref) {
  return ((Array *)useObject(ref)->data)->capacity;
}

/**
 * Memory size in bytes
 */
num Array_memsize(num ref) {
  Array* ay = (Array *)useObject(ref)->data;
  return ay->capacity * ay->dataSize;
}

pointer Array_array(num ref) {
  return ((Array *)useObject(ref)->data)->array;
}

pointer Array_get(num ref, num index) {
  Array* ay = (Array *)useObject(ref)->data;
  u8 size = ay->dataSize;
  return &ay->array[size * index];
}

void Array_set(num ref, num index, pointer value) {
  // capacity/range check...
  Array* ay = (Array *)useObject(ref)->data;
  u8 size = ay->dataSize;

  switch (size) {
  case 1 : ((u8*)ay->array)[index] = *(u8*)value;
    break;
  case 2 : ((u16*)ay->array)[index] = *(u16*)value;
    break;
  case 4 : ((u32*)ay->array)[index] = *(u32*)value;
    break;
  case 8 : ((u64*)ay->array)[index] = *(u64*)value;
    break;
#ifdef __SUPPORT_QUADMATH_
  case 10 : ((f80*)ay->array)[index] = *(f80*)value;
    break;
  case 16 : ((f128*)ay->array)[index] = *(f128*)value;
    break;
#endif  
  default:
    // some sort of copy for complex
    break;
  }
}

ArrayClassModel *_arrayClassModel = NULL;

ArrayClassModel *getArrayClassModel() {
  if (_arrayClassModel == NULL) {
    _arrayClassModel = malloc(sizeof(ArrayClassModel));
    registerClassModel(_arrayClassModel);
    populateArrayClassModel(_arrayClassModel);
  }
  return _arrayClassModel;
}

/**
 * Unmanaged array
 * String?
 */ 
num Array_create_unmanaged(pointer array, num length, primative_types type, num dataSize) {

  Array *_Array = malloc(sizeof(Array));
  _Array->length = length;
  _Array->capacity = length;
  _Array->type = type;
  _Array->array = array;
  _Array->dataSize = dataSize;
  _Array->managed = false;

  return createObject(_Array, (ClassModel *)getArrayClassModel(), false);
}

num Array_create(num length, primative_types type, u8 dataSize) {

  // error on an unexpected size != 1,2,4,8,10,16
  // setjmp - jmplong

  Array *_Array = malloc(sizeof(Array));
  _Array->length = length;
  _Array->capacity = length;
  _Array->type = type;
  _Array->array = calloc(length,  dataSize);
  _Array->dataSize = dataSize;
  _Array->managed = true;

  return createObject(_Array, (ClassModel *)getArrayClassModel(), false);
}

void populateArrayClassModel(pointer _classModel) {
  populateObjectClassModel(_classModel);

  ArrayClassModel *classModel = (ArrayClassModel *)_classModel;

  classModel->parent = getObjectClassModel();
  classModel->name = "Array";
  classModel->package = "Core";
  classModel->asStr = &Array_asStr;
  classModel->free = &Array_free;
  classModel->printTo = &Array_printTo;

  classModel->length = &Array_length;
  classModel->capacity = &Array_capacity;
  classModel->array = &Array_array;
  classModel->type = &Array_type;
  classModel->memsize = &Array_memsize;
  classModel->typename = &Array_typename;

  classModel->get = &Array_get;
  classModel->set = &Array_set;
}

/**
 * RefArray Impl
 */

void RefArray_set(num ref, num index, num value) {
  num* array = (num*)((Array *)useObject(ref)->data)->array;
  assignObject(&array[index], value);
}

void RefArray_free(num ref) {
  // get is a pointer
  debug_println("ref=%ld", ref);

  Array * ay = (Array *)useObject(ref)->data;

  num* a = ay->array;
  num capacity = ay->capacity;

  while (capacity > 0) {
    num refid = a[--capacity];
    // debug_println("ref=%ld, capacity=%ld", ref, capacity);
    if (refid > 0) { 
      returnObject(refid);
    }
  }

  Array_free(ref);
}

RefArrayClassModel *_refArrayClassModel = NULL;

RefArrayClassModel *getRefArrayClassModel() {
  if (_refArrayClassModel == NULL) {
    _refArrayClassModel = malloc(sizeof(RefArrayClassModel));
    registerClassModel(_refArrayClassModel);
    populateRefArrayClassModel(_refArrayClassModel);
  }
  return _refArrayClassModel;
}

num RefArray_create(num length) {

  Array *_Array = malloc(sizeof(Array));
  _Array->length = length;
  _Array->capacity = length;
  _Array->type = _object;
  _Array->array = calloc(length,  sizeof(num));
  _Array->dataSize = sizeof(num);
  _Array->managed = true;

  return createObject(_Array, (ClassModel *)getRefArrayClassModel(), false);
}


void populateRefArrayClassModel(pointer _classModel) {
  populateObjectClassModel(_classModel);
  populateArrayClassModel(_classModel);

  RefArrayClassModel *classModel = (RefArrayClassModel *)_classModel;

  classModel->name = "RefArray";
  classModel->package = "Core";
  classModel->setObject = &RefArray_set;
  classModel->free = &RefArray_free;
}
