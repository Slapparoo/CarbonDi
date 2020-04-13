#ifndef __TYPES_H__
#define __TYPES_H__

#include "inttypes.h"
#include <setjmp.h>

#ifdef __SUPPORT_QUADMATH_
#include "quadmath.h"
#endif
#include "stdio.h"
#include "stdlib.h"
#include "string.h"

#include "time.h"

// ansi console colours
#define ANSI_RED "\033[0;31m"
#define ANSI_BOLD_RED "\033[1;31m"
#define ANSI_GREEN "\033[0;32m"
#define ANSI_BOLD_GREEN "\033[1;32m"
#define ANSI_YELLOW "\033[0;33m"
#define ANSI_BOLD_YELLOW "\033[1;33m"
#define ANSI_BLUE "\033[0;34m"
#define ANSI_BOLD_BLUE "\033[1;34m"
#define ANSI_MAGENTA "\033[0;35m"
#define ANSI_BOLD_MAGENTA "\033[1;35m"
#define ANSI_CYAN "\033[0;36m"
#define ANSI_BOLD_CYAN "\033[1;36m"
#define ANSI_WHITE "\033[0;37m"
#define ANSI_BOLD_WHITE "\033[1;37m"
#define ANSI_DEFAULT "\033[0m"

#define PM_LIST_LENGTH 1000
#define INFLIGHT_MEMSIZE 10

#ifndef PRINT_DEBUG
#define PRINT_DEBUG 0
#endif

#define debug_println(fmt, ...) \
        do { if (PRINT_DEBUG) fprintf(stdout, ANSI_BLUE "(DEBUG)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)

#ifndef PRINT_TIME
#define PRINT_TIME 0
#endif

#define time_println(fmt, ...) \
        do { if (PRINT_TIME) fprintf(stdout, ANSI_MAGENTA "(TIME)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)

#ifndef PRINT_ERROR
#define PRINT_ERROR 1
#endif

#define error_println(fmt, ...) \
        do { if (PRINT_ERROR) fprintf(stdout, ANSI_RED "(ERROR)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)


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
// typedef char *Str;
// maybe not so wise
typedef void* pointer;

#ifdef __SUPPORT_QUADMATH_
typedef __float128 f128;
typedef long double f80;
#endif


typedef enum { false, true } boolean;
typedef enum {_u32 = 0, _i32, _i64, _u64, _u16, _i16, _i8, _u8, _f32, _f64, _num, _f128, _f80, _b8, _pointer, _struct, _object } primative_types;

extern pointer primative_names[];
char tmpBuffer[1024];

typedef num ObjectRef;


typedef struct ExceptionInformation {
  jmp_buf buf;
  num currentStack;
  pointer message;  // exception object
  // stacktrace
} ExceptionInformation;

// typedef struct ObjectClassModel ObjectClassModel;

typedef struct Object_ref {
  pointer data;
  pointer classmodel;
  i64 refCounter;
  boolean is_stack;
} Object_ref;

void __onEnter();
void __onExit();
void __unWindTo(num);
void __onFinalExit();
num __currentStackIndex();

void registerClassModel(pointer);


void assignObject(num *var, num ref_id);
Object_ref *borrowObject(num ref);
// used in destructors
Object_ref *useObject(num ref);
void returnObject(num ref);
num createObject(pointer object_data, pointer class_model, boolean is_stack);

// Arrays ?
i64 __exitReturn_i64(i64);
u64 __exitReturn_u64(u64);
u32 __exitReturn_u32(u32);
i32 __exitReturn_i32(i32);
u16 __exitReturn_u16(u16);
i16 __exitReturn_i16(i16);
i8 __exitReturn_i8(i8);
u8 __exitReturn_u8(u8);
f32 __exitReturn_f32(f32);
f64 __exitReturn_f64(f64);
#ifdef __SUPPORT_QUADMATH_
f128 __exitReturn_f128(f128);
f80 __exitReturn_f80(f80);
#endif
boolean __exitReturn_boolean(boolean);
num __exitReturn_num(num);
num __exitReturn_ref(num);
int __exitReturn_int(int);
pointer __exitReturn_pointer(pointer);

extern ExceptionInformation  *exceptionInformation[];

void throwException(pointer message);
jmp_buf* catchException();
void afterCatchException();

pointer ec_malloc(size_t size);
pointer ec_calloc(size_t length, size_t size);
void ec_free(pointer p);

pointer Object_alloc(num, u64);
// void printClassModels();

pointer getTmpBuffer();

void test(int expr, pointer message);
void testi64Equal(pointer message, i64 expected, i64 actual);
#endif