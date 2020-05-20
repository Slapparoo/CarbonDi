// generated EC compiled source test.Class2
#ifndef __C_3556498_CLASS2_H__
#define __C_3556498_CLASS2_H__
#include "Core.Core_main.h"
#include "test.Class1.h"
/* includes */

// @TODO include class dependancies
#define __C_3556498_CLASS2_DATA_  \
 num package;
#define __C_3556498_CLASS2_CLASS_  \
  i64 (*length)(num);  \
  void (*myPrint)(num);  \
  i64 (*addto)(num,i64);  \
  num (*get_package)(num);  \
  void (*set_package)(num,num);
typedef struct c_3556498_Class2_cm {

__C_2106303_OBJECT_CLASS_

__C_3556498_CLASS1_CLASS_
__C_3556498_CLASS2_CLASS_
} c_3556498_Class2_cm;

typedef struct c_3556498_Class2 {

__C_2106303_OBJECT_DATA_

__C_3556498_CLASS1_DATA_
__C_3556498_CLASS2_DATA_
} c_3556498_Class2;
pointer getc_3556498_Class2_cm();
void populatec_3556498_Class2_cm(pointer classModel);
num create_c_3556498_Class2();
/* default constructor */
num create_c_3556498_Class2$1(/* param *//*va1*/i64 count1);
num create_c_3556498_Class2$2(/* param *//*va1*/i64 count1, /*va1*/num package);


#endif