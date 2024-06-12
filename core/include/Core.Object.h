// generated EC compiled source Core.Object
#ifndef __C_2106303_OBJECT_H__
#define __C_2106303_OBJECT_H__
#include "Core.Core_main.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_Object_or c_2106303_Object_or; // forward declaration
#define __C_2106303_OBJECT_DATA_  \
 pointer instanceName;
#define __C_2106303_OBJECT_CLASS_  \
pointer *parent;  \
  pointer (*asStr)(num);  \
  void (*printTo)(num,pointer);  \
  pointer (*objectData)(num);  \
  i32 (*hashCode)(num);  \
  boolean (*equals)(num,num);  \
  void (*free)(num);  \
  void (*release)(num);  \
  pointer (*alloc)(num,u64);  \
  pointer (*realloc)(num,pointer,u64);  \
  pointer (*className)();  \
  pointer (*classShortName)();  \
  pointer (*classCName)();  \
  pointer (*classPackage)();  \
  u64 (*objectDatasize)();  \
  pointer (*get_instanceName)(num);  \
  void (*set_instanceName)(num,pointer);
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