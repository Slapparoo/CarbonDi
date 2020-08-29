// generated EC compiled source Core.Hashmap
#ifndef __C_2106303_HASHMAP_H__
#define __C_2106303_HASHMAP_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_HASHMAP_DATA_  \
 boolean isInitm; \
 u64 hmitems; \
 u64 hmsize; \
 num hmlist;
#define __C_2106303_HASHMAP_CLASS_  \
  void (*reHash)(num,num,num);  \
  void (*startuphm)(num);  \
  num (*get)(num,num);  \
  void (*internalPut)(num,num,num,num);  \
  void (*put)(num,num,num);  \
  boolean (*get_isInitm)(num);  \
  void (*set_isInitm)(num,boolean);  \
  u64 (*get_hmitems)(num);  \
  void (*set_hmitems)(num,u64);  \
  u64 (*get_hmsize)(num);  \
  void (*set_hmsize)(num,u64);  \
  num (*get_hmlist)(num);  \
  void (*set_hmlist)(num,num);
typedef struct c_2106303_Hashmap_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_HASHMAP_CLASS_
} c_2106303_Hashmap_cm;

typedef struct c_2106303_Hashmap {

__C_2106303_OBJECT_DATA_
__C_2106303_HASHMAP_DATA_
} c_2106303_Hashmap;
pointer getc_2106303_Hashmap_cm();
void populatec_2106303_Hashmap_cm(pointer classModel);
num create_c_2106303_Hashmap();
/* default constructor */


#endif