#ifndef __CORE_SUPPORT_H__
#define __CORE_SUPPORT_H__

#include "types.h"
#include <setjmp.h>

#ifdef __SUPPORT_QUADMATH_
#include <quadmath.h>
#endif

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#ifdef __SUPPORT_TIME_
#include <time.h>
#endif
#include "core_object.h"

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

#define PM_LIST_LENGTH 1024
#define INFLIGHT_MEMSIZE 10

// 
// #define EC_ARRAY(index, array, type) *(type*)array[index]
#define EC_ARRAY(index, array) array[index]

#define EC_ARRAY_ADDRESS(index, array) &array[index]

#define EC_SETVALUE(index, array, value, datatype) *(datatype*)&array[index] = value
#define EC_SETVALUE_b8(index, array, value) EC_SETVALUE(index, array, value, b8)
#define EC_SETVALUE_i8(index, array, value) EC_SETVALUE(index, array, value, i8)
#define EC_SETVALUE_u8(index, array, value) EC_SETVALUE(index, array, value, u8)
#define EC_SETVALUE_i16(index, array, value) EC_SETVALUE(index, array, value, i16)
#define EC_SETVALUE_u16(index, array, value) EC_SETVALUE(index, array, value, u16)
#define EC_SETVALUE_i32(index, array, value) EC_SETVALUE(index, array, value, i32)
#define EC_SETVALUE_u32(index, array, value) EC_SETVALUE(index, array, value, u32)
#define EC_SETVALUE_f32(index, array, value) EC_SETVALUE(index, array, value, f32)
#define EC_SETVALUE_i64(index, array, value) EC_SETVALUE(index, array, value, i64)
#define EC_SETVALUE_u64(index, array, value) EC_SETVALUE(index, array, value, u64)
#define EC_SETVALUE_f64(index, array, value) EC_SETVALUE(index, array, value, f64)
#define EC_SETVALUE_int(index, array, value) EC_SETVALUE(index, array, value, int)
#define EC_SETVALUE_num(index, array, value) EC_SETVALUE(index, array, value, num)

#define EC_VALUE(ptrvalue, datatype) *(datatype*)ptrvalue
#define EC_VALUE_i64(ptrvalue) *(i64*)ptrvalue
#define EC_VALUE_u64(ptrvalue) *(u64*)ptrvalue
#define EC_VALUE_f64(ptrvalue) *(f64*)ptrvalue
#define EC_VALUE_i32(ptrvalue) *(i32*)ptrvalue
#define EC_VALUE_u32(ptrvalue) *(u32*)ptrvalue
#define EC_VALUE_f32(ptrvalue) *(f32*)ptrvalue
#define EC_VALUE_i16(ptrvalue) *(i16*)ptrvalue
#define EC_VALUE_u16(ptrvalue) *(u16*)ptrvalue
#define EC_VALUE_i8(ptrvalue) *(i8*)ptrvalue
#define EC_VALUE_u8(ptrvalue) *(u8*)ptrvalue
#define EC_VALUE_b8(ptrvalue) *(b8*)ptrvalue
#define EC_VALUE_NUM(ptrvalue) *(num*)ptrvalue
#define EC_VALUE_INT(ptrvalue) *(int*)ptrvalue

#define EC_ADDRESS(value) &value
#define EC_FUNCTION(type, function, params) (type)(*function)(params)


#ifndef PRINT_DEBUG
#define PRINT_DEBUG 0
#endif

#define debug_println(fmt, ...) \
        do { if (PRINT_DEBUG) fprintf(stdout, ANSI_BLUE "(DEBUG)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)
//#define PRINT_TIMES
#ifdef __SUPPORT_TIME_
#ifndef PRINT_TIME
#define PRINT_TIME 0
#endif

#define time_println(fmt, ...) \
        do { if (PRINT_TIME) fprintf(stdout, ANSI_MAGENTA "(TIME)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)
#endif

#ifndef PRINT_ERROR
#define PRINT_ERROR 1
#endif

#define error_println(fmt, ...) \
        do { if (PRINT_ERROR) fprintf(stdout, ANSI_RED "(ERROR)[%s:%d]%s(): " fmt "\n" ANSI_DEFAULT, __FILE__, \
                                __LINE__, __func__, __VA_ARGS__); } while (0)

char tmpBuffer[1024];

typedef num ObjectRef;

typedef struct ExceptionInformation {
  jmp_buf buf;
  u64 currentStack;
  pointer message;  // exception object
  num exception;
  pointer classCName;
  num callStack; // DynamicArray Str
  // stacktrace
} ExceptionInformation;

// typedef struct ObjectClassModel ObjectClassModel;

typedef struct Object_ref {
  pointer data;
  pointer classmodel;
  i64 refCounter;
  boolean is_stack;
} Object_ref;

u64 __onEnter();
void __onExit();
void __unWindTo(u64);
void __onFinalExit();
num __currentStackIndex();

void registerClassModel(pointer);
void registerMemoryAllocation(num ref, pointer mem);
void updateMemoryAllocation(num ref, pointer oldp, pointer newp);

void assignObject(num *var, num ref_id);
Object_ref *borrowObject(num ref);
// used in destructors
Object_ref *useObject(num ref);
void returnObject(num ref);
num createObject(pointer object_data, pointer class_model, boolean is_stack);


//*** <==
i64 __exitReturn_i64_un(i64 a, u64 checkPoint);
u64 __exitReturn_u64_un(u64 a, u64 checkPoint);
u32 __exitReturn_u32_un(u32 a, u64 checkPoint);
i32 __exitReturn_i32_un(i32 a, u64 checkPoint);
u16 __exitReturn_u16_un(u16 a, u64 checkPoint);
i16 __exitReturn_i16_un(i16 a, u64 checkPoint);
i8 __exitReturn_i8_un(i8 a, u64 checkPoint);
u8 __exitReturn_u8_un(u8 a, u64 checkPoint);
f32 __exitReturn_f32_un(f32 a, u64 checkPoint);
f64 __exitReturn_f64_un(f64 a, u64 checkPoint);
#ifdef __SUPPORT_QUADMATH_
f128 __exitReturn_f128_un(f128 a, u64 checkPoint);
f80 __exitReturn_f80_un(f80 a, u64 checkPoint);
#endif
boolean __exitReturn_boolean_un(boolean a, u64 checkPoint);
num __exitReturn_num_un(num a, u64 checkPoint);
int __exitReturn_int_un(int a, u64 checkPoint);
pointer __exitReturn_pointer_un(pointer a, u64 checkPoint);
num __exitReturn_ref_un(num a, u64 checkPoint);
void __exitReturn_void_un(u64 checkPoint);

//***


extern ExceptionInformation  *exceptionInformation[];

void throwException(pointer message);
jmp_buf* catchException();
void afterCatchException();

void throw(num exception);
void newThrowException(num exception);
jmp_buf *newCatchException(pointer cname);
i64 getExceptionIndex();
void cleanExceptionIndex(i64 index);
num getException();
void newAfterCatchException();

pointer ec_malloc(size_t size);
pointer ec_calloc(size_t length, size_t size);
void ec_free(pointer p);
pointer ec_realloc(pointer ptr, size_t size);

pointer Object_alloc(num, u64);
void print_log(int count, ...);
// void printClassModels();

pointer getTmpBuffer();

void test(int expr, pointer message);
void testi64Equal(pointer message, i64 expected, i64 actual);
void testStrEqual(pointer message, pointer expected, pointer actual);

#endif