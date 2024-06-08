#include "eccore.h"

typedef enum {
  _b8 = 1, 
  _i8 = 2, 
  _u8 = 3, 
  _i16 = 4, 
  _u16 = 5, 
  _i32 = 6, 
  _u32 = 7,   
  _f32 = 8,   
  _i64 = 9, 
  _u64 = 10, 
  _f64 = 11, 
  _f128 = 12, 
  _f80 = 13, 
  _num = 14, 
  _pointer = 15, 
  _struct = 16, 
  _object =17 
  } primative_types;


pointer primative_names[] = {"boolean", "i8", "u8", "i16", "u16", "i32", "u32", "f32", "i64", "u64", "f64", "f128", "f80", "num", "pointer", "struct", "Object"};
// #include "Core.Array.h"
// #include "Core.RefArray.h"

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
  c_2106303_Array *array = (c_2106303_Array *)object_ref->data;
  sprintf(tmpBuffer, "(Array) type=%d, length=%ld, datasize=%lu", array->dataType, array->length, ((c_2106303_Array_cm*)object_ref->classmodel)->objectDatasize(ref));
  return tmpBuffer;
}

void Array_printTo(num ref, pointer stream) {
  Object_ref *object_ref = useObject(ref);

  ((c_2106303_Object_cm*)((c_2106303_Array_cm*)object_ref->classmodel)->parent)->printTo(ref, stream);
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
  return ((c_2106303_Array *)useObject(ref)->data)->dataType;
}

void Array_set_datatype(num ref, int dataType) {
  ((c_2106303_Array *)useObject(ref)->data)->dataType = dataType;
}

void Array_set_dataSize(num ref, u64 dataSize) {
  ((c_2106303_Array *)useObject(ref)->data)->dataSize = dataSize;
}

u64 Array_get_dataSize(num ref) {
  return ((c_2106303_Array *)useObject(ref)->data)->dataSize;
}

void Array_set_capacity(num ref, u64 capacity) {
  ((c_2106303_Array *)useObject(ref)->data)->capacity = capacity;
}

void Array_set_values(num ref, pointer values) {
  ((c_2106303_Array *)useObject(ref)->data)->values = values;
}

void Array_set_length(num ref, u64 length) {
  ((c_2106303_Array *)useObject(ref)->data)->length = length;
}


pointer Array_typename(num ref) {
  return primative_names[(int)Array_type(ref)];
}

u64 Array_length(num ref) {
  return ((c_2106303_Array *)useObject(ref)->data)->length;
}

u64 Array_capacity(num ref) {
  return ((c_2106303_Array *)useObject(ref)->data)->capacity;
}

/**
 * Memory size in bytes
 */
u64 Array_memsize(num ref) {
  c_2106303_Array* ay = (c_2106303_Array *)useObject(ref)->data;
  return ay->capacity * ay->dataSize;
}

pointer Array_values(num ref) {
  return ((c_2106303_Array *)useObject(ref)->data)->values;
}

pointer Array_get(num ref, u64 index) {
  c_2106303_Array* ay = (c_2106303_Array *)useObject(ref)->data;
  if (index >= ay->capacity) {
    throwException("Array out of bounds exception");
  }

  u8 size = ay->dataSize;
  u64 offset = size * index;
  pointer res = ay->values + offset;

  // printf("Array index %lu, %p, offset %lu\n", index, res, offset);

  return res;
}

void Array_set(num ref, u64 index, pointer value) {
  c_2106303_Array* ay = (c_2106303_Array *)useObject(ref)->data;
  if (index >= ay->capacity) {
    throwException("Array out of bounds exception");
  }

  // // capacity/range check...
  u8 size = ay->dataSize;
  pointer arrayValue = Array_get(ref, index);


  switch (size) {
  case 1 : *(u8*)arrayValue = *(u8*)value;
    break;
  case 2 : *(u16*)arrayValue = *(u16*)value;
    break;
  case 4 : *(u32*)arrayValue = *(u32*)value;
    break;
  case 8 : *(u64*)arrayValue = *(u64*)value;
    break;
#ifdef __SUPPORT_QUADMATH_
  case 10 : *(f80*)arrayValue = *(f80*)value;
    break;
  case 16 : *(f128*)arrayValue = *(f128*)value;
    break;
#endif  
  default:
    // some sort of copy for complex
    break;
  }
}

c_2106303_Array_cm _arrayClassModel;
boolean _arrayClassModel_init = false;

pointer getc_2106303_Array_cm() {
  if (!_arrayClassModel_init) {
    registerClassModel(&_arrayClassModel);
    populatec_2106303_Array_cm(&_arrayClassModel);
  }
  return &_arrayClassModel;
}

u64 Array_getObjectDatasize(num id) {
  c_2106303_Array* ay = (c_2106303_Array *)useObject(id)->data;
  if (!ay->managed) {
    return sizeof(c_2106303_Array);
  }
  return sizeof(c_2106303_Array) + (ay->capacity * ay->dataSize);
}

u64 RefArray_getObjectDatasize(num id) {
  c_2106303_RefArray* ay = (c_2106303_RefArray *)useObject(id)->data;
  if (!ay->managed) {
    return sizeof(c_2106303_RefArray);
  }
  return sizeof(c_2106303_RefArray) + (ay->capacity * ay->dataSize);
}


/**
 * Unmanaged array
 * String?
 */ 
// num Array_create_unmanaged(pointer array, u64 length, primative_types type, u64 dataSize) {
num create_c_2106303_Array_2(u64 capacity, int dataType, u64 dataSize, pointer values) {
  c_2106303_Array *_Array = ec_malloc(sizeof(c_2106303_Array));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = dataType;
  _Array->values = values;
  _Array->dataSize = dataSize;
  _Array->managed = false;

  return createObject(_Array, getc_2106303_Array_cm(), false);
}

num create_c_2106303_Array_1(u64 capacity, int dataType, u64 dataSize) {

  // error on an unexpected size != 1,2,4,8,10,16
  // setjmp - jmplong
  switch(dataSize) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 8:
    case 10:
    case 16: break;
    default: throwException("Expecting dataSize to be one of [1,2,4,8,10,16].");
  }

  c_2106303_Array* _Array = ec_malloc(sizeof(c_2106303_Array));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = dataType;
  _Array->dataSize = dataSize;
  _Array->managed = true;

  num id = createObject(_Array, getc_2106303_Array_cm(), false);
  _Array->values = ((c_2106303_Array_cm*)getc_2106303_Array_cm())->alloc(id, capacity * dataSize);

  return id;
}

void populatec_2106303_Array_cm(pointer _classModel) {
  populatec_2106303_Object_cm(_classModel);

  c_2106303_Array_cm *classModel = (c_2106303_Array_cm *)_classModel;

  classModel->parent = getc_2106303_Object_cm();
  classModel->alloc = Object_alloc;
  classModel->free = Object_free;
  // classModel->name = "Array";
  // classModel->package = "Core";
  classModel->asStr = Array_asStr;
  // classModel->free = Array_free;
  classModel->printTo = Array_printTo;

  classModel->get_length = Array_length;
  classModel->get_capacity = Array_capacity;
  classModel->get_values = Array_values;
  classModel->get_dataType = Array_type;
  classModel->set_dataType = Array_set_datatype;
  classModel->set_dataSize = Array_set_dataSize;
  classModel->get_dataSize = Array_get_dataSize;
  classModel->memsize = Array_memsize;
  classModel->set_capacity = Array_set_capacity;
  classModel->set_values = Array_set_values;
  classModel->set_length = Array_set_length;
  
  classModel->typename = Array_typename;

  classModel->get = Array_get;
  classModel->set = Array_set;
  classModel->objectDatasize=Array_getObjectDatasize;
}

/**
 * RefArray Impl
 */

void RefArray_set(num ref, u64 index, num value) {
  c_2106303_Array* ay = (c_2106303_Array *)useObject(ref)->data;
  if (index >= ay->length) {
    throwException("Array out of bounds exception");
  }
  num* array = (num*)((c_2106303_RefArray *)useObject(ref)->data)->values;
  assignObject(&array[index], value);
}

void RefArray_free(num ref) {
  // get is a pointer
  debug_println("ref=%ld", ref);

  c_2106303_Array * ay = (c_2106303_Array *)useObject(ref)->data;

  num* a = ay->values;
  num capacity = ay->capacity;

  while (capacity > 0) {
    num refid = a[--capacity];
    if (refid > 0) { 
      returnObject(refid);
    }
  }
}

c_2106303_RefArray_cm _refArrayClassModel;
boolean _refArrayClassModel_init = false;

pointer getc_2106303_RefArray_cm() {
  if (!_refArrayClassModel_init) {
    registerClassModel(&_refArrayClassModel);
    populatec_2106303_RefArray_cm(&_refArrayClassModel);
    _refArrayClassModel_init = true;
  }
  return &_refArrayClassModel;
}

num create_c_2106303_RefArray_1(u64 capacity) {

  c_2106303_RefArray *_Array = ec_malloc(sizeof(c_2106303_RefArray));
  _Array->length = capacity;
  _Array->capacity = capacity;
  _Array->dataType = _object;
  _Array->dataSize = sizeof(num);
  _Array->managed = true;

  num id = createObject(_Array, getc_2106303_RefArray_cm(), false);
  _Array->values = ((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->alloc(id, capacity * sizeof(num));

  return id;
}


void populatec_2106303_RefArray_cm(pointer _classModel) {
  // populateObjectClassModel(_classModel);
  populatec_2106303_Array_cm(_classModel);

  c_2106303_RefArray_cm *classModel = (c_2106303_RefArray_cm *)_classModel;

  // classModel->name = "RefArray";
  // classModel->package = "Core";
  classModel->objectDatasize= RefArray_getObjectDatasize;
  classModel->setObject = RefArray_set;
  classModel->free = RefArray_free;
}
