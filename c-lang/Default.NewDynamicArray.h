// generated EC compiled source Default.NewDynamicArray
#ifndef __C_1085510111_NEWDYNAMICARRAY_H__
#define __C_1085510111_NEWDYNAMICARRAY_H__
#include "Core.Core_main.h"
#include "Core.Array.h"
/* includes */

// @TODO include class dependancies
#define __C_1085510111_NEWDYNAMICARRAY_DATA_  \
 u64 startIndex; \
 u64 endIndex;
#define __C_1085510111_NEWDYNAMICARRAY_CLASS_  \
  pointer (*getValue)(num, u64);  \
  void (*setValue)(num, u64, pointer);  \
  void (*addTail)(num, pointer);  \
  void (*addHead)(num, pointer);  \
  void (*insert)(num, u64, pointer);  \
  pointer (*removeHead)(num);  \
  pointer (*removeTail)(num);  \
  pointer (*remove)(num, u64, pointer);  \
  pointer (*peekTail)(num);  \
  pointer (*peekHead)(num);  \
  void (*addCapacityHead)(num);  \
  void (*addCapacityTail)(num);  \
  void (*reduceCapacityHead)(num);  \
  void (*reduceCapacityTail)(num);  \
  void (*realignLeft)(num);  \
  void (*slideLeft)(num);  \
  void (*slideRight)(num);  \
  u64 (*get_startIndex)(num);  \
  void (*set_startIndex)(num, u64);  \
  u64 (*get_endIndex)(num);  \
  void (*set_endIndex)(num, u64);  \
  u64 (*get_initialSize)();  \
  void (*set_initialSize)(u64);  \
  u64 (*get_growBy)();  \
  void (*set_growBy)(u64);  \
  u64 (*get_slideAmount)();  \
  void (*set_slideAmount)(u64);  \
  u64 initialSize;  \
  u64 growBy;  \
  u64 slideAmount;
typedef struct c_1085510111_NewDynamicArray_cm {

__C_2106303_OBJECT_CLASS_

__C_2106303_ARRAY_CLASS_
__C_1085510111_NEWDYNAMICARRAY_CLASS_
} c_1085510111_NewDynamicArray_cm;

typedef struct c_1085510111_NewDynamicArray {

__C_2106303_OBJECT_DATA_

__C_2106303_ARRAY_DATA_
__C_1085510111_NEWDYNAMICARRAY_DATA_
} c_1085510111_NewDynamicArray;
pointer getc_1085510111_NewDynamicArray_cm();
void populatec_1085510111_NewDynamicArray_cm(pointer classModel);
num create_c_1085510111_NewDynamicArray();
/* default constructor */
num create_c_1085510111_NewDynamicArray$1(/* param *//*va1*/int dataType, /*va1*/u64 dataSize);
num create_c_1085510111_NewDynamicArray$2(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize);
num create_c_1085510111_NewDynamicArray$3(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize, /*va1*/pointer values);


#endif