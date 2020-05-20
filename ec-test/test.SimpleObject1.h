// generated EC compiled source test.SimpleObject1
#ifndef __C_3556498_SIMPLEOBJECT1_H__
#define __C_3556498_SIMPLEOBJECT1_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_3556498_SIMPLEOBJECT1_DATA_  \
 i64 number; \
 num name;
#define __C_3556498_SIMPLEOBJECT1_CLASS_  \
  i64 (*addNumber)(num,i64);  \
  i64 (*get_number)(num);  \
  void (*set_number)(num,i64);  \
  num (*get_name)(num);  \
  void (*set_name)(num,num);
typedef struct c_3556498_SimpleObject1_cm {

__C_2106303_OBJECT_CLASS_
__C_3556498_SIMPLEOBJECT1_CLASS_
} c_3556498_SimpleObject1_cm;

typedef struct c_3556498_SimpleObject1 {

__C_2106303_OBJECT_DATA_
__C_3556498_SIMPLEOBJECT1_DATA_
} c_3556498_SimpleObject1;
pointer getc_3556498_SimpleObject1_cm();
void populatec_3556498_SimpleObject1_cm(pointer classModel);
num create_c_3556498_SimpleObject1();
/* default constructor */
num create_c_3556498_SimpleObject1$1(/* param *//*va1*/i64 number, /*va1*/num name);


#endif