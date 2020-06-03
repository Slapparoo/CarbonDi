// generated EC compiled source Core.F64
#ifndef __C_2106303_F64_H__
#define __C_2106303_F64_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_F64_DATA_  \
 f64 value;
#define __C_2106303_F64_CLASS_  \
  f64 (*get_value)(num);  \
  void (*set_value)(num, f64);
typedef struct c_2106303_F64_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_F64_CLASS_
} c_2106303_F64_cm;

typedef struct c_2106303_F64 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_F64_DATA_
} c_2106303_F64;
pointer getc_2106303_F64_cm();
void populatec_2106303_F64_cm(pointer classModel);
num create_c_2106303_F64();
/* default constructor */
num create_c_2106303_F64_1(/* param *//*va1*/f64 value);


#endif