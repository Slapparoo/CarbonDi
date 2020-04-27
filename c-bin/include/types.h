#ifndef __TYPES_H__
#define __TYPES_H__

#include "inttypes.h"


#ifdef __SUPPORT_QUADMATH_
#include "quadmath.h"
#endif

typedef int64_t i64;
typedef uint64_t u64;
typedef uint32_t u32;
typedef int32_t i32;
typedef uint16_t u16;
typedef int16_t i16;
typedef int8_t i8;
typedef uint8_t u8;
typedef uint8_t b8;

typedef float f32;
typedef double f64;

#define null ((void*)0)

typedef i64 num;
// maybe not so wise
typedef void* pointer;

#ifdef __SUPPORT_QUADMATH_
typedef __float128 f128;
typedef long double f80;
#endif

typedef enum { false, true } boolean;

#endif