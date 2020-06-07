// generated EC compiled source Core.U16
#ifndef __C_2106303_U16_H__
#define __C_2106303_U16_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_U16_DATA_  \
 u16 value;
#define __C_2106303_U16_CLASS_  \
  u16 (*get_value)(num);  \
  void (*set_value)(num,u16);
typedef struct c_2106303_U16_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_U16_CLASS_
} c_2106303_U16_cm;

typedef struct c_2106303_U16 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_U16_DATA_
} c_2106303_U16;
pointer getc_2106303_U16_cm();
void populatec_2106303_U16_cm(pointer classModel);
num create_c_2106303_U16();
/* default constructor */
num create_c_2106303_U16_1(/* param *//*va1*/u16 value);


#endif