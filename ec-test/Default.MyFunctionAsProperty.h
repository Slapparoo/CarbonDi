// generated EC compiled source Default.MyFunctionAsProperty
#ifndef __C_1085510111_MYFUNCTIONASPROPERTY_H__
#define __C_1085510111_MYFUNCTIONASPROPERTY_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_MYFUNCTIONASPROPERTY_DATA_  \
 num name;
#define __C_1085510111_MYFUNCTIONASPROPERTY_CLASS_  \
  void (*setName)(num,num);  \
  num (*getName)(num);  \
  num (*get_name)(num);  \
  void (*set_name)(num,num);
typedef struct c_1085510111_MyFunctionAsProperty_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_MYFUNCTIONASPROPERTY_CLASS_
} c_1085510111_MyFunctionAsProperty_cm;

typedef struct c_1085510111_MyFunctionAsProperty {

__C_2106303_OBJECT_DATA_
__C_1085510111_MYFUNCTIONASPROPERTY_DATA_
} c_1085510111_MyFunctionAsProperty;
pointer getc_1085510111_MyFunctionAsProperty_cm();
void populatec_1085510111_MyFunctionAsProperty_cm(pointer classModel);
num create_c_1085510111_MyFunctionAsProperty();
/* default constructor */


#endif