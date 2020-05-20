// generated EC compiled source Default.Encapsulation
#ifndef __C_1085510111_ENCAPSULATION_H__
#define __C_1085510111_ENCAPSULATION_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_ENCAPSULATION_DATA_  \
 i64 count1; \
 i64 count2;
#define __C_1085510111_ENCAPSULATION_CLASS_  \
  i64 (*count3)(num);  \
  void (*printMe)(num);  \
  i64 (*get_count1)(num);  \
  void (*set_count1)(num,i64);  \
  i64 (*get_count2)(num);  \
  void (*set_count2)(num,i64);
typedef struct c_1085510111_Encapsulation_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_ENCAPSULATION_CLASS_
} c_1085510111_Encapsulation_cm;

typedef struct c_1085510111_Encapsulation {

__C_2106303_OBJECT_DATA_
__C_1085510111_ENCAPSULATION_DATA_
} c_1085510111_Encapsulation;
pointer getc_1085510111_Encapsulation_cm();
void populatec_1085510111_Encapsulation_cm(pointer classModel);
num create_c_1085510111_Encapsulation();
/* default constructor */
num create_c_1085510111_Encapsulation$1(/* param *//*va1*/i64 count1, /*va1*/i64 count2);


#endif