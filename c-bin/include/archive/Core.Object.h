// generated EC compiled source
#ifndef __CORE_OBJECT_H__
#define __CORE_OBJECT_H__
#include "types.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_OBJECT_DATA_ 
#define __C_2106303_OBJECT_CLASS_  \
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
  pointer (*getClassCName)();  \
  pointer (*getClassPackage)();  \
  u64 (*getObjectDatasize)();
typedef struct ObjectClassModel {
__C_2106303_OBJECT_CLASS_
} ObjectClassModel;

typedef struct Object {
__C_2106303_OBJECT_DATA_
} Object;
pointer getObjectClassModel();
void populateObjectClassModel(pointer classModel);
num create_Object();


pointer getc_2106303_Object_cm();
void populatec_2106303_Object_cm(pointer classModel);

/* default constructor */


#endif