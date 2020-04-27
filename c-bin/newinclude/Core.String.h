// generated EC compiled source Core.String
#ifndef __C_2106303_STRING_H__
#define __C_2106303_STRING_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_STRING_DATA_  \
 pointer value;
#define __C_2106303_STRING_CLASS_  \
  u64 (*length)(num);  \
  pointer (*get_value)(num);  \
  void (*set_value)(num, pointer);
typedef struct c_2106303_String_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_STRING_CLASS_
} c_2106303_String_cm;

typedef struct c_2106303_String {

__C_2106303_OBJECT_DATA_
__C_2106303_STRING_DATA_
} c_2106303_String;
pointer getc_2106303_String_cm();
void populatec_2106303_String_cm(pointer classModel);
num create_c_2106303_String();

num create_c_2106303_String$1(/* param *//*va1*/pointer str);
num create_c_2106303_String$2(/* param *//*va1*/pointer str, /*va1*/boolean staticAlloc);
num create_c_2106303_String$3(/* param *//*va1*/pointer str, /*va1*/pointer str2);


#endif