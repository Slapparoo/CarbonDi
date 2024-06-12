// generated EC compiled source Core.Duo
#ifndef __C_2106303_DUO_H__
#define __C_2106303_DUO_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_Duo_or c_2106303_Duo_or; // forward declaration
#define __C_2106303_DUO_DATA_  \
 num one; \
 num two;
#define __C_2106303_DUO_CLASS_  \
  num (*get_one)(num);  \
  void (*set_one)(num,num);  \
  num (*get_two)(num);  \
  void (*set_two)(num,num);
typedef struct c_2106303_Duo_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_DUO_CLASS_
} c_2106303_Duo_cm;

typedef struct c_2106303_Duo {

__C_2106303_OBJECT_DATA_
__C_2106303_DUO_DATA_
} c_2106303_Duo;


pointer getc_2106303_Duo_cm();
void populatec_2106303_Duo_cm(pointer classModel);
num create_c_2106303_Duo();
/* default constructor */


#endif