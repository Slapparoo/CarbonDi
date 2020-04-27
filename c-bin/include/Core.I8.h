// generated EC compiled source Core.I8
#ifndef __C_2106303_I8_H__
#define __C_2106303_I8_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_I8_DATA_  \
 i8 value;
#define __C_2106303_I8_CLASS_  \
  i8 (*get_value)(num);  \
  void (*set_value)(num, i8);
typedef struct c_2106303_I8_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_I8_CLASS_
} c_2106303_I8_cm;

typedef struct c_2106303_I8 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_I8_DATA_
} c_2106303_I8;
pointer getc_2106303_I8_cm();
void populatec_2106303_I8_cm(pointer classModel);
num create_c_2106303_I8();
/* default constructor */
num create_c_2106303_I8$1(/* param *//*va1*/i8 value);


#endif