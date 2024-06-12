// generated EC compiled source Core.MapEntry
#ifndef __C_2106303_MAPENTRY_H__
#define __C_2106303_MAPENTRY_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_MapEntry_or c_2106303_MapEntry_or; // forward declaration
#define __C_2106303_MAPENTRY_DATA_  \
 num key; \
 num value;
#define __C_2106303_MAPENTRY_CLASS_  \
  num (*get_key)(num);  \
  void (*set_key)(num,num);  \
  num (*get_value)(num);  \
  void (*set_value)(num,num);
typedef struct c_2106303_MapEntry_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_MAPENTRY_CLASS_
} c_2106303_MapEntry_cm;

typedef struct c_2106303_MapEntry {

__C_2106303_OBJECT_DATA_
__C_2106303_MAPENTRY_DATA_
} c_2106303_MapEntry;


pointer getc_2106303_MapEntry_cm();
void populatec_2106303_MapEntry_cm(pointer classModel);
num create_c_2106303_MapEntry();
/* default constructor */
num create_c_2106303_MapEntry_1(/* param *//*va1*/num key, /*va1*/num value);


#endif