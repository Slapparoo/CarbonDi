// generated EC compiled source Core.BaseBoxing
#ifndef __C_2106303_BASEBOXING_H__
#define __C_2106303_BASEBOXING_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_BASEBOXING_DATA_ 
#define __C_2106303_BASEBOXING_CLASS_  \
  int (*datatype)();  \
  pointer (*typename)();
typedef struct c_2106303_BaseBoxing_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_BASEBOXING_CLASS_
} c_2106303_BaseBoxing_cm;

typedef struct c_2106303_BaseBoxing {

__C_2106303_OBJECT_DATA_
__C_2106303_BASEBOXING_DATA_
} c_2106303_BaseBoxing;
pointer getc_2106303_BaseBoxing_cm();
void populatec_2106303_BaseBoxing_cm(pointer classModel);
num create_c_2106303_BaseBoxing();
/* default constructor */


#endif