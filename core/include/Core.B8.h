// generated EC compiled source Core.B8
#ifndef __C_2106303_B8_H__
#define __C_2106303_B8_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_B8_or c_2106303_B8_or; // forward declaration
#define __C_2106303_B8_DATA_  \
 b8 value;
#define __C_2106303_B8_CLASS_  \
  b8 (*get_value)(num);  \
  void (*set_value)(num,b8);
typedef struct c_2106303_B8_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_B8_CLASS_
} c_2106303_B8_cm;

typedef struct c_2106303_B8 {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_B8_DATA_
} c_2106303_B8;


pointer getc_2106303_B8_cm();
void populatec_2106303_B8_cm(pointer classModel);
num create_c_2106303_B8();

num create_c_2106303_B8_1(/* param *//*va1*/b8 value);


#endif