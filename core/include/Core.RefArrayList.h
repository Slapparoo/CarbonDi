// generated EC compiled source Core.RefArrayList
#ifndef __C_2106303_REFARRAYLIST_H__
#define __C_2106303_REFARRAYLIST_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
typedef struct c_2106303_RefArrayList_or c_2106303_RefArrayList_or; // forward declaration
#define __C_2106303_REFARRAYLIST_DATA_  \
 num list; \
 u64 ralsize; \
 boolean isInit;
#define __C_2106303_REFARRAYLIST_CLASS_  \
  void (*startup)(num);  \
  void (*growList)(num);  \
  void (*add)(num,num);  \
  num (*get)(num,u64);  \
  num (*get_list)(num);  \
  void (*set_list)(num,num);  \
  u64 (*get_ralsize)(num);  \
  void (*set_ralsize)(num,u64);  \
  boolean (*get_isInit)(num);  \
  void (*set_isInit)(num,boolean);  \
  u64 (*get_growBy)();  \
  void (*set_growBy)(u64);  \
  u64 growBy;
typedef struct c_2106303_RefArrayList_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_REFARRAYLIST_CLASS_
} c_2106303_RefArrayList_cm;

typedef struct c_2106303_RefArrayList {

__C_2106303_OBJECT_DATA_
__C_2106303_REFARRAYLIST_DATA_
} c_2106303_RefArrayList;


pointer getc_2106303_RefArrayList_cm();
void populatec_2106303_RefArrayList_cm(pointer classModel);
num create_c_2106303_RefArrayList();
/* default constructor */


#endif