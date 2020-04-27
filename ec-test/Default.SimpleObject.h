// generated EC compiled source Default.SimpleObject
#ifndef __C_1085510111_SIMPLEOBJECT_H__
#define __C_1085510111_SIMPLEOBJECT_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_SIMPLEOBJECT_DATA_  \
 i64 count1; \
 i64 count3;
#define __C_1085510111_SIMPLEOBJECT_CLASS_  \
  i64 (*constNumber)();  \
  i64 (*get_count1)(num);  \
  void (*set_count1)(num, i64);  \
  i64 (*get_count2)();  \
  void (*set_count2)(i64);  \
  i64 (*get_count3)(num);  \
  void (*set_count3)(num, i64);  \
  i64 count2;
typedef struct c_1085510111_SimpleObject_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_SIMPLEOBJECT_CLASS_
} c_1085510111_SimpleObject_cm;

typedef struct c_1085510111_SimpleObject {

__C_2106303_OBJECT_DATA_
__C_1085510111_SIMPLEOBJECT_DATA_
} c_1085510111_SimpleObject;
pointer getc_1085510111_SimpleObject_cm();
void populatec_1085510111_SimpleObject_cm(pointer classModel);
num create_c_1085510111_SimpleObject();
/* default constructor */
num create_c_1085510111_SimpleObject$1(/* param *//*va1*/i64 count1);


#endif