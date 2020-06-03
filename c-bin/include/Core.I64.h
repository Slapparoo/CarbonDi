// generated EC compiled source Core.I64
#ifndef __C_2106303_I64_H__
#define __C_2106303_I64_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_I64_DATA_  \
 i64 value;
#define __C_2106303_I64_CLASS_  \
  i64 (*get_value)(num);  \
  void (*set_value)(num, i64);
typedef struct c_2106303_I64_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_I64_CLASS_
} c_2106303_I64_cm;

typedef struct c_2106303_I64 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_I64_DATA_
} c_2106303_I64;
pointer getc_2106303_I64_cm();
void populatec_2106303_I64_cm(pointer classModel);
num create_c_2106303_I64();
/* default constructor */
num create_c_2106303_I64_1(/* param *//*va1*/i64 value);


#endif