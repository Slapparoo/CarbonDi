// generated EC compiled source
#ifndef __CORE_STRING_H__
#define __CORE_STRING_H__
#include "types.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __CORE_STRING_DATA_  \
 pointer value;
#define __CORE_STRING_CLASS_  \
  pointer (*get_value)(num);  \
  void (*set_value)(num, pointer);
typedef struct StringClassModel {

__CORE_OBJECT_CLASS_
__CORE_STRING_CLASS_
} StringClassModel;

typedef struct String {

__CORE_OBJECT_DATA_
__CORE_STRING_DATA_
} String;
pointer getStringClassModel();
void populateStringClassModel(pointer classModel);
num create_String();
num create_String$1(/* param */pointer value);
num create_String$2(/* param */pointer value, pointer str2);


#endif