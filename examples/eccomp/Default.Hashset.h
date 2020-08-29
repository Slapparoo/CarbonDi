// generated EC compiled source Default.Hashset
#ifndef __C_1085510111_HASHSET_H__
#define __C_1085510111_HASHSET_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_HASHSET_DATA_  \
 u64 items; \
 u64 size; \
 num list; \
 boolean isInit;
#define __C_1085510111_HASHSET_CLASS_  \
  void (*reHash)(num,num);  \
  void (*startup)(num);  \
  boolean (*contains)(num,num);  \
  void (*add)(num,num);  \
  void (*addNew)(num,num,num);  \
  u64 (*get_items)(num);  \
  void (*set_items)(num,u64);  \
  u64 (*get_size)(num);  \
  void (*set_size)(num,u64);  \
  num (*get_list)(num);  \
  void (*set_list)(num,num);  \
  boolean (*get_isInit)(num);  \
  void (*set_isInit)(num,boolean);
typedef struct c_1085510111_Hashset_cm {

__C_2106303_OBJECT_CLASS_
__C_1085510111_HASHSET_CLASS_
} c_1085510111_Hashset_cm;

typedef struct c_1085510111_Hashset {

__C_2106303_OBJECT_DATA_
__C_1085510111_HASHSET_DATA_
} c_1085510111_Hashset;
pointer getc_1085510111_Hashset_cm();
void populatec_1085510111_Hashset_cm(pointer classModel);
num create_c_1085510111_Hashset();
/* default constructor */
num create_c_1085510111_Hashset_1(/* param *//*va1*/u64 size);


#endif