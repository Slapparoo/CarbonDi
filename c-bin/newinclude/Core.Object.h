// generated EC compiled source Core.Object
#ifndef __C_2106303_OBJECT_H__
#define __C_2106303_OBJECT_H__
#include "Core.Core_main.h"
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
  pointer (*getClassShortName)();  \
  pointer (*getClassCName)();  \
  pointer (*getClassPackage)();  \
  u64 (*getObjectDatasize)();
typedef struct c_2106303_Object_cm {
__C_2106303_OBJECT_CLASS_
} c_2106303_Object_cm;

typedef struct c_2106303_Object {
__C_2106303_OBJECT_DATA_
} c_2106303_Object;
pointer getc_2106303_Object_cm();
void populatec_2106303_Object_cm(pointer classModel);
num create_c_2106303_Object();
/* default constructor */


#endif