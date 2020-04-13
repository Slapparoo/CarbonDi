#include "Core.Array.h"
#include "Core.RefArray.h"

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

pointer Array_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  Array *array = (Array *)object_ref->data;
  sprintf(tmpBuffer, "(Array) type=%d, length=%ld, datasize=%lu", array->dataType, array->length, ((ArrayClassModel*)object_ref->classmodel)->getObjectDatasize(ref));
  return tmpBuffer;
}

void Array_printTo(num ref, pointer stream) {
  Object_ref *object_ref = useObject(ref);

  ((ObjectClassModel*)((ArrayClassModel*)object_ref->classmodel)->parent)->printTo(ref, stream);
  fprintf(stream, ANSI_GREEN "(Array_printTo) %s\n" ANSI_DEFAULT, Array_asStr(ref));
}

// void Array_free(num ref) {
//   debug_println("%ld", ref);

//   Array *array = (Array *)useObject(ref)->data;

//   if (array->managed) {
//     ec_free(array->array);
//   }
// }

int Array_type(num ref) {
  return ((Array *)useObject(ref)->data)->dataType;
}

pointer Array_typename(num ref) {
  return primative_names[(int)Array_type(ref)];
}

u64 Array_length(num ref) {
  return ((Array *)useObject(ref)->data)->length;
}

u64 Array_capacity(num ref) {
  return ((Array *)useObject(ref)->data)->capacity;
}

/**
 * Memory size in bytes
 */
u64 Array_memsize(num ref) {
  Array* ay = (Array *)useObject(ref)->data;
  return ay->capacity * ay->dataSize;
}

pointer Array_values(num ref) {
  return ((Array *)useObject(ref)->data)->values;
}

pointer Array_get(num ref, u64 index) {
  Array* ay = (Array *)useObject(ref)->data;
  if (index >= ay->length) {
    throwException("Array out of bounds exception");
  }

  u8 size = ay->dataSize;
  return &ay->values[size * index];
}

void Array_set(num ref, u64 index, pointer value) {
  Array* ay = (Array *)useObject(ref)->data;
  if (index >= ay->length) {
    throwException("Array out of bounds exception");
  }

  // capacity/range check...
  u8 size = ay->dataSize;

  switch (size) {
  case 1 : ((u8*)ay->values)[index] = *(u8*)value;
    break;
  case 2 : ((u16*)ay->values)[index] = *(u16*)value;
    break;
  case 4 : ((u32*)ay->values)[index] = *(u32*)value;
    break;
  case 8 : ((u64*)ay->values)[index] = *(u64*)value;
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

pointer getArrayClassModel() {
  if (_arrayClassModel == NULL) {
    _arrayClassModel = ec_malloc(sizeof(ArrayClassModel));
    registerClassModel(_arrayClassModel);
    populateArrayClassModel(_arrayClassModel);
  }
  return _arrayClassModel;
}

u64 Array_getDatasize(num id) {
  Array* ay = (Array *)useObject(id)->data;
  if (!ay->managed) {
    return sizeof(Array);
  }
  return sizeof(Array) + (ay->capacity * ay->dataSize);
}


/**
 * Unmanaged array
 * String?
 */ 
// num Array_create_unmanaged(pointer array, u64 length, primative_types type, u64 dataSize) {
num create_Array$2(u64 capacity, int dataType, u64 dataSize, pointer values) {
  Array *_Array = ec_malloc(sizeof(Array));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = dataType;
  _Array->values = values;
  _Array->dataSize = dataSize;
  _Array->managed = false;

  return createObject(_Array, getArrayClassModel(), false);
}

num create_Array$1(u64 capacity, int dataType, u64 dataSize) {

  // error on an unexpected size != 1,2,4,8,10,16
  // setjmp - jmplong

  Array* _Array = ec_malloc(sizeof(Array));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = dataType;
  _Array->dataSize = dataSize;
  _Array->managed = true;

  num id = createObject(_Array, getArrayClassModel(), false);
  _Array->values = ((ArrayClassModel*)getArrayClassModel())->alloc(id, capacity * dataSize);

  return id;
}

void populateArrayClassModel(pointer _classModel) {
  populateObjectClassModel(_classModel);

  ArrayClassModel *classModel = (ArrayClassModel *)_classModel;

  classModel->parent = getObjectClassModel();
  // classModel->name = "Array";
  // classModel->package = "Core";
  classModel->asStr = Array_asStr;
  // classModel->free = Array_free;
  classModel->printTo = Array_printTo;

  classModel->get_length = Array_length;
  classModel->get_capacity = Array_capacity;
  classModel->get_values = Array_values;
  classModel->get_dataType = Array_type;
  classModel->memsize = Array_memsize;
  classModel->typename = Array_typename;

  classModel->get = Array_get;
  classModel->set = Array_set;
  classModel->getObjectDatasize=Array_getDatasize;
}

/**
 * RefArray Impl
 */

void RefArray_set(num ref, u64 index, num value) {
  Array* ay = (Array *)useObject(ref)->data;
  if (index >= ay->length) {
    throwException("Array out of bounds exception");
  }
  num* array = (num*)((Array *)useObject(ref)->data)->values;
  assignObject(&array[index], value);
}

void RefArray_free(num ref) {
  // get is a pointer
  debug_println("ref=%ld", ref);

  Array * ay = (Array *)useObject(ref)->data;

  num* a = ay->values;
  num capacity = ay->capacity;

  while (capacity > 0) {
    num refid = a[--capacity];
    // debug_println("ref=%ld, capacity=%ld", ref, capacity);
    if (refid > 0) { 
      returnObject(refid);
    }
  }

  // Array_free(ref);
}

RefArrayClassModel *_refArrayClassModel = NULL;

pointer getRefArrayClassModel() {
  if (_refArrayClassModel == NULL) {
    _refArrayClassModel = ec_malloc(sizeof(RefArrayClassModel));
    registerClassModel(_refArrayClassModel);
    populateRefArrayClassModel(_refArrayClassModel);
  }
  return _refArrayClassModel;
}

num create_RefArray$1(u64 capacity) {

  Array *_Array = ec_malloc(sizeof(Array));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = _object;
  _Array->dataSize = sizeof(num);
  _Array->managed = true;

  num id = createObject(_Array, getRefArrayClassModel(), false);
  _Array->values = ((RefArrayClassModel*)getRefArrayClassModel())->alloc(id, capacity * sizeof(num));

  return id;
}


void populateRefArrayClassModel(pointer _classModel) {
  populateObjectClassModel(_classModel);
  populateArrayClassModel(_classModel);

  RefArrayClassModel *classModel = (RefArrayClassModel *)_classModel;

  // classModel->name = "RefArray";
  // classModel->package = "Core";
  classModel->setObject = &RefArray_set;
  classModel->free = &RefArray_free;
}
