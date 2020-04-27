// generated EC compiled source Default.MyClass
#ifndef __C_1085510111_MYCLASS_H__
#define __C_1085510111_MYCLASS_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_MYCLASS_DATA_  \
 num name; \
 i64 value; \
 i64 value2;
#define __C_1085510111_MYCLASS_CLASS_  \
  void (*myPrint)(num);  \
  num (*get_name)(num);  \
  void (*set_name)(num, num);  \
  i64 (*get_value)(num);  \
  void (*set_value)(num, i64);  \
  i64 (*get_value2)(num);  \
  void (*set_value2)(num, i64);
typedef struct c_1085510111_MyClass_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_MYCLASS_CLASS_
} c_1085510111_MyClass_cm;

typedef struct c_1085510111_MyClass {

__C_2106303_OBJECT_DATA_
__C_1085510111_MYCLASS_DATA_
} c_1085510111_MyClass;
pointer getc_1085510111_MyClass_cm();
void populatec_1085510111_MyClass_cm(pointer classModel);
num create_c_1085510111_MyClass();
/* default constructor */
num create_c_1085510111_MyClass$1(/* param *//*va1*/i64 value);


#endif