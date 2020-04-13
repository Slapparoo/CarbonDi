// generated EC compiled source
#ifndef __CORE_REFARRAY_H__
#define __CORE_REFARRAY_H__
#include "types.h"
#include "Core.Array.h"
/* includes */

// @TODO include class dependancies
#define __CORE_REFARRAY_DATA_ 
#define __CORE_REFARRAY_CLASS_  \
  void (*setObject)(num, u64, num);
typedef struct RefArrayClassModel {

__CORE_OBJECT_CLASS_

__CORE_ARRAY_CLASS_
__CORE_REFARRAY_CLASS_
} RefArrayClassModel;

typedef struct RefArray {

__CORE_OBJECT_DATA_

__CORE_ARRAY_DATA_
__CORE_REFARRAY_DATA_
} RefArray;
pointer getRefArrayClassModel();
void populateRefArrayClassModel(pointer classModel);
num create_RefArray();
num create_RefArray$1(u64 capacity);


#endif