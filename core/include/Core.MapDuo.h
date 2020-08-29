// generated EC compiled source Core.MapDuo
#ifndef __C_2106303_MAPDUO_H__
#define __C_2106303_MAPDUO_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_MAPDUO_DATA_  \
 num oneKey; \
 num twoKey; \
 num oneValue; \
 num twoValue;
#define __C_2106303_MAPDUO_CLASS_  \
  num (*get_oneKey)(num);  \
  void (*set_oneKey)(num,num);  \
  num (*get_twoKey)(num);  \
  void (*set_twoKey)(num,num);  \
  num (*get_oneValue)(num);  \
  void (*set_oneValue)(num,num);  \
  num (*get_twoValue)(num);  \
  void (*set_twoValue)(num,num);
typedef struct c_2106303_MapDuo_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_MAPDUO_CLASS_
} c_2106303_MapDuo_cm;

typedef struct c_2106303_MapDuo {

__C_2106303_OBJECT_DATA_
__C_2106303_MAPDUO_DATA_
} c_2106303_MapDuo;
pointer getc_2106303_MapDuo_cm();
void populatec_2106303_MapDuo_cm(pointer classModel);
num create_c_2106303_MapDuo();
/* default constructor */


#endif