#include "eccore.h"

// c_2106303_Object_cm _objectClassModel;
// boolean _objectClassModel_init = false;;


// num Object_hashCode(num ref) {
//   return (ref * 0xff3ff3ff3ff3ff13) >> 3;
// }

// boolean Object_equals(num ref, num other) {
//   return ref == other;
// } 

// pointer Object_asStr(num ref) {
//   Object_ref *object_ref = useObject(ref);
//   sprintf(tmpBuffer, 
//     ANSI_GREEN "ref:%ld %s, ref*=%p, data*=%p, refCount=%ld" ANSI_DEFAULT, 
//     ref, ((c_2106303_Object_cm *)object_ref->classmodel)->getClassName(),
//       object_ref, object_ref->data, object_ref->refCounter);
//   return tmpBuffer;
// }

// void Object_printTo(num ref, pointer stream) {
//   Object_ref *object_ref = useObject(ref);
//   fprintf((FILE*)stream, ANSI_GREEN
//           "(Object_printTo) %s::%s ref:%ld, ref*=%p, data*=%p, class*=%p, "
//           "refCount=%ld, is_stack=%s\n" ANSI_DEFAULT,
//           ((c_2106303_Object_cm *)object_ref->classmodel)->getClassPackage(), ((c_2106303_Object_cm *)object_ref->classmodel)->getClassName(), ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter, object_ref->is_stack ? "true" : "false");
// }

// pointer Object_getShortName(num ref) {
//   return "Object";
// }

// pointer Object_getName(num ref) {
//   return "Core.Object";
// }

// pointer Object_getPackage(num ref) {
//   return "Core";
// }

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

pointer Object_realloc(num ref, pointer ptr, u64 amount) {
  debug_println("realloc %ld %p %lud ", ref, ptr, amount);

  if (ref == 0) {
    throwException("Bad memory allocation request, invalid Id, realloc");
  }

  pointer res = ec_realloc(ptr, amount);

  if (res != ptr) {
    updateMemoryAllocation(ref, ptr, res);
  }

  return res;
}

pointer Object_data(num ref) {
  return useObject(ref)->data;
}

void Object_free(num ref) {
  debug_println("%ld", ref);
}

// // ObjectClassModel *_objectClassModel = NULL;
// // Str _ObjectName = NULL;
// // Str _PackageName = NULL;

// u64 Object_datasize(num id) {
//   return 0;
// }


// pointer getObjectClassModel() {
//   if (!_objectClassModel_init) {
//     // _objectClassModel = ec_malloc(sizeof(ObjectClassModel));
//     registerClassModel(&_objectClassModel);
//     populatec_2106303_Object_cm(&_objectClassModel);
//     _objectClassModel_init = true;
//   }
//   return &_objectClassModel;
// }

// void populateObjectClassModel(pointer _classModel) {
//   c_2106303_Object_cm* classModel = (c_2106303_Object_cm *)_classModel;
//   classModel->parent = NULL;
//   // classModel->name = "Object";
//   // classModel->package = "Core";
//   classModel->asStr = Object_asStr;
//   classModel->asString = NULL;
//   classModel->free = Object_free;
//   classModel->printTo = Object_printTo;
//   classModel->release = NULL;
//   classModel->getClassName = Object_getName;
//   classModel->getClassShortName = Object_getShortName;
//   classModel->getClassPackage = Object_getPackage;
//   classModel->getObjectDatasize = Object_datasize;
//   classModel->alloc = Object_alloc;
//   classModel->realloc = Object_realloc;
  
//   classModel->hashCode = &Object_hashCode;
//   classModel->equals = &Object_equals;
// }

// pointer getc_2106303_Object_cm() {
//   return getObjectClassModel();
// }

// void populatec_2106303_Object_cm(pointer classModel) {
//   populateObjectClassModel(classModel);
// }


