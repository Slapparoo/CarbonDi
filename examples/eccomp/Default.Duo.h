// generated EC compiled source Default.Duo
#ifndef __C_1085510111_DUO_H__
#define __C_1085510111_DUO_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_DUO_DATA_  \
 num one; \
 num two;
#define __C_1085510111_DUO_CLASS_  \
  num (*get_one)(num);  \
  void (*set_one)(num,num);  \
  num (*get_two)(num);  \
  void (*set_two)(num,num);
typedef struct c_1085510111_Duo_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_DUO_CLASS_
} c_1085510111_Duo_cm;

typedef struct c_1085510111_Duo {

__C_2106303_OBJECT_DATA_
__C_1085510111_DUO_DATA_
} c_1085510111_Duo;
pointer getc_1085510111_Duo_cm();
void populatec_1085510111_Duo_cm(pointer classModel);
num create_c_1085510111_Duo();
/* default constructor */


#endif