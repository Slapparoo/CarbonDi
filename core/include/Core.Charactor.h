// generated EC compiled source Core.Charactor
#ifndef __C_2106303_CHARACTOR_H__
#define __C_2106303_CHARACTOR_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_CHARACTOR_DATA_ 
#define __C_2106303_CHARACTOR_CLASS_  \
  boolean (*isLetter)(i8);  \
  boolean (*isAlpha)(i8);  \
  boolean (*isUpper)(i8);  \
  boolean (*isLower)(i8);  \
  boolean (*isAlphaNumeric)(i8);  \
  boolean (*isLetterorNumber)(i8);  \
  boolean (*isNumber)(i8);  \
  boolean (*isFloat)(i8);  \
  boolean (*isHex)(i8);  \
  boolean (*isBinary)(i8);
typedef struct c_2106303_Charactor_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_CHARACTOR_CLASS_
} c_2106303_Charactor_cm;

typedef struct c_2106303_Charactor {

__C_2106303_OBJECT_DATA_
__C_2106303_CHARACTOR_DATA_
} c_2106303_Charactor;
pointer getc_2106303_Charactor_cm();
void populatec_2106303_Charactor_cm(pointer classModel);
num create_c_2106303_Charactor();
/* default constructor */


#endif