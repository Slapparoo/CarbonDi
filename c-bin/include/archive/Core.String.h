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

__C_2106303_OBJECT_CLASS_
__CORE_STRING_CLASS_
} StringClassModel;

#define c_2106303_String_cm StringClassModel
#define create_c_2106303_String create_String

typedef struct String {

__C_2106303_OBJECT_DATA_
__CORE_STRING_DATA_
} String;
pointer getStringClassModel();
void populateStringClassModel(pointer classModel);
num create_String();
num create_String$1(/* param */pointer value);
num create_String$2(/* param */pointer value, pointer str2);


#endif