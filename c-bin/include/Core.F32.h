// generated EC compiled source Core.F32
#ifndef __C_2106303_F32_H__
#define __C_2106303_F32_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_F32_DATA_  \
 f32 value;
#define __C_2106303_F32_CLASS_  \
  f32 (*get_value)(num);  \
  void (*set_value)(num,f32);
typedef struct c_2106303_F32_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_F32_CLASS_
} c_2106303_F32_cm;

typedef struct c_2106303_F32 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_F32_DATA_
} c_2106303_F32;
pointer getc_2106303_F32_cm();
void populatec_2106303_F32_cm(pointer classModel);
num create_c_2106303_F32();
/* default constructor */
num create_c_2106303_F32_1(/* param *//*va1*/f32 value);


#endif