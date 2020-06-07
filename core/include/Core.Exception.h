// generated EC compiled source Core.Exception
#ifndef __C_2106303_EXCEPTION_H__
#define __C_2106303_EXCEPTION_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_EXCEPTION_DATA_  \
 num message; \
 num root;
#define __C_2106303_EXCEPTION_CLASS_  \
  num (*get_message)(num);  \
  void (*set_message)(num,num);  \
  num (*get_root)(num);  \
  void (*set_root)(num,num);
typedef struct c_2106303_Exception_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_EXCEPTION_CLASS_
} c_2106303_Exception_cm;

typedef struct c_2106303_Exception {

__C_2106303_OBJECT_DATA_
__C_2106303_EXCEPTION_DATA_
} c_2106303_Exception;
pointer getc_2106303_Exception_cm();
void populatec_2106303_Exception_cm(pointer classModel);
num create_c_2106303_Exception();

num create_c_2106303_Exception_1(/* param *//*va1*/num root, /*va1*/num message);
num create_c_2106303_Exception_2(/* param *//*va1*/num message);


#endif