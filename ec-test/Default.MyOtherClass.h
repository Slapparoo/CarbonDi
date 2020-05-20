// generated EC compiled source Default.MyOtherClass
#ifndef __C_1085510111_MYOTHERCLASS_H__
#define __C_1085510111_MYOTHERCLASS_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_MYOTHERCLASS_DATA_  \
 num myClass;
#define __C_1085510111_MYOTHERCLASS_CLASS_  \
  num (*get_myClass)(num);  \
  void (*set_myClass)(num,num);
typedef struct c_1085510111_MyOtherClass_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_MYOTHERCLASS_CLASS_
} c_1085510111_MyOtherClass_cm;

typedef struct c_1085510111_MyOtherClass {

__C_2106303_OBJECT_DATA_
__C_1085510111_MYOTHERCLASS_DATA_
} c_1085510111_MyOtherClass;
pointer getc_1085510111_MyOtherClass_cm();
void populatec_1085510111_MyOtherClass_cm(pointer classModel);
num create_c_1085510111_MyOtherClass();
/* default constructor */


#endif