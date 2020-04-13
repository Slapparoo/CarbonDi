// generated EC compiled source
#ifndef __DEFAULT_SIMPLEOBJECT_H__
#define __DEFAULT_SIMPLEOBJECT_H__
#include "types.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __DEFAULT_SIMPLEOBJECT_DATA_  \
 i64 count1; \
 i64 count3;
#define __DEFAULT_SIMPLEOBJECT_CLASS_  \
  i64 (*constNumber)();  \
  i64 (*get_count1)(num);  \
  void (*set_count1)(num, i64);  \
  i64 (*get_count3)(num);  \
  void (*set_count3)(num, i64);  \
  i64 (*get_count2)();  \
  void (*set_count2)(i64);  \
  i64 count2;
typedef struct SimpleObjectClassModel {

__CORE_OBJECT_CLASS_
__DEFAULT_SIMPLEOBJECT_CLASS_
} SimpleObjectClassModel;

typedef struct SimpleObject {

__CORE_OBJECT_DATA_
__DEFAULT_SIMPLEOBJECT_DATA_
} SimpleObject;
pointer getSimpleObjectClassModel();
void populateSimpleObjectClassModel(pointer classModel);
num create_SimpleObject();
/* default constructor */
num create_SimpleObject$1(/* param */i64 count1);


#endif