// generated EC compiled source Core.Boxing
#ifndef __C_2106303_BOXING_H__
#define __C_2106303_BOXING_H__
#include "Core.Core_main.h"
#include "Core.Object.h"
/* includes */

// @TODO include class dependancies
#define __C_2106303_BOXING_DATA_ 
#define __C_2106303_BOXING_CLASS_  \
  int (*get_b8_)();  \
  void (*set_b8_)(int);  \
  int (*get_i8_)();  \
  void (*set_i8_)(int);  \
  int (*get_u8_)();  \
  void (*set_u8_)(int);  \
  int (*get_i16_)();  \
  void (*set_i16_)(int);  \
  int (*get_u16_)();  \
  void (*set_u16_)(int);  \
  int (*get_i32_)();  \
  void (*set_i32_)(int);  \
  int (*get_u32_)();  \
  void (*set_u32_)(int);  \
  int (*get_f32_)();  \
  void (*set_f32_)(int);  \
  int (*get_i64_)();  \
  void (*set_i64_)(int);  \
  int (*get_u64_)();  \
  void (*set_u64_)(int);  \
  int (*get_f64_)();  \
  void (*set_f64_)(int);  \
  int (*get_pointer_)();  \
  void (*set_pointer_)(int);  \
  int b8_;  \
  int i8_;  \
  int u8_;  \
  int i16_;  \
  int u16_;  \
  int i32_;  \
  int u32_;  \
  int f32_;  \
  int i64_;  \
  int u64_;  \
  int f64_;  \
  int pointer_;
typedef struct c_2106303_Boxing_cm {

__C_2106303_OBJECT_CLASS_
__C_2106303_BOXING_CLASS_
} c_2106303_Boxing_cm;

typedef struct c_2106303_Boxing {

__C_2106303_OBJECT_DATA_
__C_2106303_BOXING_DATA_
} c_2106303_Boxing;
pointer getc_2106303_Boxing_cm();
void populatec_2106303_Boxing_cm(pointer classModel);
num create_c_2106303_Boxing();
/* default constructor */


#endif