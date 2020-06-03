// generated EC compiled source Core.Array
#ifndef __C_2106303_ARRAY_H__
#define __C_2106303_ARRAY_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_ARRAY_DATA_  \
 pointer values; \
 u64 length; \
 u64 capacity; \
 int dataType; \
 u64 dataSize; \
 boolean managed;
#define __C_2106303_ARRAY_CLASS_  \
  pointer (*get)(num, u64);  \
  void (*set)(num, u64, pointer);  \
  u64 (*memsize)(num);  \
  pointer (*typename)(num);  \
  pointer (*get_values)(num);  \
  void (*set_values)(num, pointer);  \
  u64 (*get_length)(num);  \
  void (*set_length)(num, u64);  \
  u64 (*get_capacity)(num);  \
  void (*set_capacity)(num, u64);  \
  int (*get_dataType)(num);  \
  void (*set_dataType)(num, int);  \
  u64 (*get_dataSize)(num);  \
  void (*set_dataSize)(num, u64);  \
  boolean (*get_managed)(num);  \
  void (*set_managed)(num, boolean);
typedef struct c_2106303_Array_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_ARRAY_CLASS_
} c_2106303_Array_cm;

typedef struct c_2106303_Array {

__C_2106303_OBJECT_DATA_
__C_2106303_ARRAY_DATA_
} c_2106303_Array;
pointer getc_2106303_Array_cm();
void populatec_2106303_Array_cm(pointer classModel);
num create_c_2106303_Array();

num create_c_2106303_Array_1(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize);
num create_c_2106303_Array_2(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize, /*va1*/pointer values);


#endif