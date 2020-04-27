// generated EC compiled source test.Class1
#ifndef __C_3556498_CLASS1_H__
#define __C_3556498_CLASS1_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_3556498_CLASS1_DATA_  \
 i64 count1; \
 i64 count2;
#define __C_3556498_CLASS1_CLASS_  \
  i64 (*constNumber)();  \
  i64 (*get_count1)(num);  \
  void (*set_count1)(num, i64);  \
  i64 (*get_count2)(num);  \
  void (*set_count2)(num, i64);
typedef struct c_3556498_Class1_cm {

__C_2106303_OBJECT_CLASS_
__C_3556498_CLASS1_CLASS_
} c_3556498_Class1_cm;

typedef struct c_3556498_Class1 {

__C_2106303_OBJECT_DATA_
__C_3556498_CLASS1_DATA_
} c_3556498_Class1;
pointer getc_3556498_Class1_cm();
void populatec_3556498_Class1_cm(pointer classModel);
num create_c_3556498_Class1();
/* default constructor */
num create_c_3556498_Class1$1(/* param *//*va1*/i64 count1);


#endif