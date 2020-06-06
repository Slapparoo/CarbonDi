// generated EC compiled source Core.I32
#ifndef __C_2106303_I32_H__
#define __C_2106303_I32_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_I32_DATA_  \
 i32 value;
#define __C_2106303_I32_CLASS_  \
  i32 (*get_value)(num);  \
  void (*set_value)(num,i32);
typedef struct c_2106303_I32_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_I32_CLASS_
} c_2106303_I32_cm;

typedef struct c_2106303_I32 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_I32_DATA_
} c_2106303_I32;
pointer getc_2106303_I32_cm();
void populatec_2106303_I32_cm(pointer classModel);
num create_c_2106303_I32();
/* default constructor */
num create_c_2106303_I32_1(/* param *//*va1*/i32 value);


#endif