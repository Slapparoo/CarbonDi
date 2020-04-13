// generated EC compiled source
#ifndef __CORE_OBJECT_H__
#define __CORE_OBJECT_H__
#include "types.h"
/* includes */

// @TODO include class dependancies
#define __CORE_OBJECT_DATA_ 
#define __CORE_OBJECT_CLASS_  \
pointer *parent;  \
  pointer (*getObjectData)(num);  \
  pointer (*asStr)(num);  \
  void (*printTo)(num, pointer);  \
  num (*asString)(num);  \
  i64 (*hashCode)(num);  \
  boolean (*equals)(num, num);  \
  void (*free)(num);  \
  void (*release)(num);  \
  pointer (*alloc)(num, u64);  \
  pointer (*getClassName)();  \
  pointer (*getClassPackage)();  \
  u64 (*getObjectDatasize)();
typedef struct ObjectClassModel {
__CORE_OBJECT_CLASS_
} ObjectClassModel;

typedef struct Object {
__CORE_OBJECT_DATA_
} Object;
pointer getObjectClassModel();
void populateObjectClassModel(pointer classModel);
num create_Object();

/* default constructor */


#endif