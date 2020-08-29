// generated EC compiled source Core.HashCode
#ifndef __C_2106303_HASHCODE_H__
#define __C_2106303_HASHCODE_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_HASHCODE_DATA_ 
#define __C_2106303_HASHCODE_CLASS_  \
  i32 (*calcFastHash)(pointer,u64);
typedef struct c_2106303_HashCode_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_HASHCODE_CLASS_
} c_2106303_HashCode_cm;

typedef struct c_2106303_HashCode {

__C_2106303_OBJECT_DATA_
__C_2106303_HASHCODE_DATA_
} c_2106303_HashCode;
pointer getc_2106303_HashCode_cm();
void populatec_2106303_HashCode_cm(pointer classModel);
num create_c_2106303_HashCode();
/* default constructor */


#endif