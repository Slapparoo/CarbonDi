// generated EC compiled source Core.U32
#ifndef __C_2106303_U32_H__
#define __C_2106303_U32_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_U32_or c_2106303_U32_or; // forward declaration
#define __C_2106303_U32_DATA_  \
 u32 value;
#define __C_2106303_U32_CLASS_  \
  u32 (*get_value)(num);  \
  void (*set_value)(num,u32);
typedef struct c_2106303_U32_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_U32_CLASS_
} c_2106303_U32_cm;

typedef struct c_2106303_U32 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_U32_DATA_
} c_2106303_U32;


pointer getc_2106303_U32_cm();
void populatec_2106303_U32_cm(pointer classModel);
num create_c_2106303_U32();
/* default constructor */
num create_c_2106303_U32_1(/* param *//*va1*/u32 value);


#endif