// generated EC compiled source Core.RefArray
#ifndef __C_2106303_REFARRAY_H__
#define __C_2106303_REFARRAY_H__
#include "Core.Core_main.h"
#include "Core.Array.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_REFARRAY_DATA_ 
#define __C_2106303_REFARRAY_CLASS_  \
  void (*setObject)(num, u64, num);
typedef struct c_2106303_RefArray_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_ARRAY_CLASS_
__C_2106303_REFARRAY_CLASS_
} c_2106303_RefArray_cm;

typedef struct c_2106303_RefArray {

__C_2106303_OBJECT_DATA_

__C_2106303_ARRAY_DATA_
__C_2106303_REFARRAY_DATA_
} c_2106303_RefArray;
pointer getc_2106303_RefArray_cm();
void populatec_2106303_RefArray_cm(pointer classModel);
num create_c_2106303_RefArray();
/* default constructor */
num create_c_2106303_RefArray_1(/* param *//*va1*/u64 length);


#endif