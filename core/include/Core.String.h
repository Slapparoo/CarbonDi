// generated EC compiled source Core.String
#ifndef __C_2106303_STRING_H__
#define __C_2106303_STRING_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_String_or c_2106303_String_or; // forward declaration
#define __C_2106303_STRING_DATA_  \
 pointer value; \
 i32 hash;
#define __C_2106303_STRING_CLASS_  \
  num (*asString)(num);  \
  u64 (*length)(num);  \
  void (*println)(num);  \
  num (*appendStr)(num,pointer);  \
  num (*append)(num,num);  \
  num (*prependStr)(num,pointer);  \
  num (*prepend)(num,num);  \
  i64 (*compareStr)(num,pointer);  \
  boolean (*compareSubStr)(num,pointer,u64);  \
  i8 (*getChar)(num,u64);  \
  boolean (*isSubStr)(num,pointer,u64);  \
  i64 (*compare)(num,num);  \
  i64 (*findStr)(num,i64,pointer);  \
  i64 (*find)(num,i64,num);  \
  void (*trunc)(num,i64,i64);  \
  pointer (*get_value)(num);  \
  void (*set_value)(num,pointer);  \
  i32 (*get_hash)(num);  \
  void (*set_hash)(num,i32);
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

num create_c_2106303_String_1(/* param *//*va1*/pointer str);
num create_c_2106303_String_2(/* param *//*va1*/pointer str, /*va1*/boolean staticAlloc);
num create_c_2106303_String_3(/* param *//*va1*/pointer str, /*va1*/pointer str2);
num create_c_2106303_String_4(/* param *//*va1*/pointer str, /*va1*/u64 offset, /*va1*/u64 len);


#endif