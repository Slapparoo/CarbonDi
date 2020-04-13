// generated EC compiled source
#ifndef __CORE_ARRAY_H__
#define __CORE_ARRAY_H__
#include "types.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __CORE_ARRAY_DATA_  \
 pointer values; \
 u64 length; \
 u64 capacity; \
 int dataType; \
 u64 dataSize; \
 boolean managed;
#define __CORE_ARRAY_CLASS_  \
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
typedef struct ArrayClassModel {

__CORE_OBJECT_CLASS_
__CORE_ARRAY_CLASS_
} ArrayClassModel;

typedef struct Array {

__CORE_OBJECT_DATA_
__CORE_ARRAY_DATA_
} Array;
pointer getArrayClassModel();
void populateArrayClassModel(pointer classModel);
num create_Array();

/* default constructor */
num create_Array$1(/* param */u64 capacity, int dataType, u64 dataSize);
num create_Array$2(/* param */u64 capacity, int dataType, u64 dataSize, pointer values);


#endif