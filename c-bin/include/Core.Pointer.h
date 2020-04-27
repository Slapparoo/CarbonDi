// generated EC compiled source Core.Pointer
#ifndef __C_2106303_POINTER_H__
#define __C_2106303_POINTER_H__
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_POINTER_DATA_  \
 pointer value;
#define __C_2106303_POINTER_CLASS_  \
  pointer (*get_value)(num);  \
  void (*set_value)(num, pointer);
typedef struct c_2106303_Pointer_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_BASEBOXING_CLASS_
__C_2106303_POINTER_CLASS_
} c_2106303_Pointer_cm;

typedef struct c_2106303_Pointer {

__C_2106303_OBJECT_DATA_

__C_2106303_BASEBOXING_DATA_
__C_2106303_POINTER_DATA_
} c_2106303_Pointer;
pointer getc_2106303_Pointer_cm();
void populatec_2106303_Pointer_cm(pointer classModel);
num create_c_2106303_Pointer();
/* default constructor */
num create_c_2106303_Pointer$1(/* param *//*va1*/pointer value);


#endif