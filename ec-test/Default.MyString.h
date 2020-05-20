// generated EC compiled source Default.MyString
#ifndef __C_1085510111_MYSTRING_H__
#define __C_1085510111_MYSTRING_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_MYSTRING_DATA_  \
 pointer value;
#define __C_1085510111_MYSTRING_CLASS_  \
  pointer (*get_value)(num);  \
  void (*set_value)(num,pointer);
typedef struct c_1085510111_MyString_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_MYSTRING_CLASS_
} c_1085510111_MyString_cm;

typedef struct c_1085510111_MyString {

__C_2106303_OBJECT_DATA_
__C_1085510111_MYSTRING_DATA_
} c_1085510111_MyString;
pointer getc_1085510111_MyString_cm();
void populatec_1085510111_MyString_cm(pointer classModel);
num create_c_1085510111_MyString();

num create_c_1085510111_MyString$1(/* param *//*va1*/pointer str1);
num create_c_1085510111_MyString$2(/* param *//*va1*/pointer str2, /*va1*/pointer str3);


#endif