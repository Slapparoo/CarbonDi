#ifndef __TYPES_H__
#define __TYPES_H__

#include "inttypes.h"

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

typedef i64 num;
typedef char *Str;
// maybe not so wise
typedef void* pointer;

#ifdef __SUPPORT_QUADMATH_
typedef __float128 f128;
typedef long double f80;
#endif


typedef enum { false, true } boolean;
typedef enum {_u32 = 0, _i32, _i64, _u64, _u16, _i16, _i8, _u8, _f32, _f64, _num, _f128, _f80, _b8, _pointer, _struct, _object } primative_types;

extern Str primative_names[];
char tmpBuffer[1024];

typedef num ObjectRef;

#define __STANDARDCLASS_DATA_              
  // num ref_id;


typedef struct String {
  __STANDARDCLASS_DATA_
  Str str;
} String;

Str String_asStr(num);


#define __STANDARDCLASS_MODEL_             \
  ObjectClassModel *parent;                \
  Str name;                             \
  Str package;                          \
  Str (*asStr)(num ref);                   \
  void (*printTo)(num ref, FILE * stream); \
  void (*free)(num ref);                   \
  void (*close)(num ref);                  \
  num (*asString)(num ref);             \
  num (*hashCode)(num ref);                \
  boolean (*equals)(num ref, num other); 

typedef struct ObjectClassModel ObjectClassModel;

typedef struct ObjectClassModel {
  __STANDARDCLASS_MODEL_
} ClassModel;

#define __ARRAYCLASS_MODEL_  num (*length)(num); \
  num (*capacity)(num); \
  pointer (*array)(num); \
  primative_types (*type)(num); \
  Str (*typename)(num); \
  pointer (*get)(num, num); \
  void (*set)(num, num, pointer); \
  num (*memsize)(num); \
  void (*setObject)(num, num, num); 

#define __BOXINGCLASS_MODEL_ \
  primative_types (*type)(num); \
  Str (*typename)(num); 
  
#define __BOXING_u8_CLASS_MODEL_ \
  u8 (*value)(num); 

#define __BOXING_i8_CLASS_MODEL_ \
  i8 (*value)(num); 

#define __BOXING_u16_CLASS_MODEL_ \
  u16 (*value)(num); 

#define __BOXING_i16_CLASS_MODEL_ \
  i16 (*value)(num); 

#define __BOXING_u32_CLASS_MODEL_ \
  u32 (*value)(num); 

#define __BOXING_i32_CLASS_MODEL_ \
  i32 (*value)(num); 

#define __BOXING_f32_CLASS_MODEL_ \
  f32 (*value)(num); 

#define __BOXING_u64_CLASS_MODEL_ \
  u64 (*value)(num); 

#define __BOXING_i64_CLASS_MODEL_ \
  i64 (*value)(num); 

#define __BOXING_f64_CLASS_MODEL_ \
  f64 (*value)(num); 

#ifdef __SUPPORT_QUADMATH_
#define __BOXING_80_CLASS_MODEL_ \
  f80 (*value)(num); 

#define __BOXING_128_CLASS_MODEL_ \
  f128 (*value)(num); 
#endif

typedef struct Array {
  __STANDARDCLASS_DATA_
  pointer array;
  num length;
  num capacity;
  primative_types type;
  num dataSize;
  boolean managed;
} Array;


typedef struct ArrayClassModel {
  __STANDARDCLASS_MODEL_
  __ARRAYCLASS_MODEL_
  // <-- specific order
} ArrayClassModel;

typedef struct RefArrayClassModel {
  __STANDARDCLASS_MODEL_
  __ARRAYCLASS_MODEL_
} RefArrayClassModel;


typedef struct StringClassModel {
  __STANDARDCLASS_MODEL_
  // <-- specific order
  num (*length)(num);
  boolean (*contains)(num, num);
  num (*subString)(num, num, num);
  // return an Array if i8
  num (*geti8)(num);
  num (*toUpper)(num);
  num (*toLower)(num);
  num (*concat)(num, num);
} StringClassModel;

typedef struct BoxingClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
} BoxingClassModel;

typedef struct Boxingu8ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_u8_CLASS_MODEL_
} Boxingu8ClassModel;

typedef struct Boxingi8ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_i8_CLASS_MODEL_
} Boxingi8ClassModel;

typedef struct Boxingu16ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_u16_CLASS_MODEL_
} Boxingu16ClassModel;

typedef struct Boxingi16ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_i16_CLASS_MODEL_
} Boxingi16ClassModel;

typedef struct Boxingu32ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_u32_CLASS_MODEL_
} Boxingu32ClassModel;

typedef struct Boxingi32ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_i32_CLASS_MODEL_
} Boxingi32ClassModel;

typedef struct Boxingf32ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_f32_CLASS_MODEL_
} Boxingf32ClassModel;

typedef struct Boxingu64ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_u64_CLASS_MODEL_
} Boxingu64ClassModel;

typedef struct Boxingi64ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_i64_CLASS_MODEL_
} Boxingi64ClassModel;

typedef struct Boxingf64ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_f64_CLASS_MODEL_
} Boxingf64ClassModel;

#ifdef __SUPPORT_QUADMATH_

typedef struct Boxing80ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_80_CLASS_MODEL_
} Boxing80ClassModel;

typedef struct Boxing128ClassModel {
  __STANDARDCLASS_MODEL_
  __BOXINGCLASS_MODEL_
  __BOXING_128_CLASS_MODEL_
} Boxing128ClassModel;

#endif

typedef struct Boxingu8 {
  __STANDARDCLASS_DATA_
  u8 value;
} Boxingu8;

typedef struct Boxingi8 {
  __STANDARDCLASS_DATA_
  i8 value;
} Boxingi8;


typedef struct Boxingu16 {
  __STANDARDCLASS_DATA_
  u16 value;
} Boxingu16;

typedef struct Boxingi16 {
  __STANDARDCLASS_DATA_
  i16 value;
} Boxingi16;

typedef struct Boxingu32 {
  __STANDARDCLASS_DATA_
  u32 value;
} Boxingu32;

typedef struct Boxingi32 {
  __STANDARDCLASS_DATA_
  i32 value;
} Boxingi32;

typedef struct Boxingf32 {
  __STANDARDCLASS_DATA_
  f32 value;
} Boxingf32;

typedef struct Boxingu64 {
  __STANDARDCLASS_DATA_
  u64 value;
} Boxingu64;

typedef struct Boxingi64 {
  __STANDARDCLASS_DATA_
  i64 value;
} Boxingi64;

typedef struct Boxingf64 {
  __STANDARDCLASS_DATA_
  f64 value;
} Boxingf64;

#ifdef __SUPPORT_QUADMATH_

typedef struct Boxing80 {
  __STANDARDCLASS_DATA_
  f80 value;
} Boxing80;

typedef struct Boxing128 {
  __STANDARDCLASS_DATA_
  f128 value;
} Boxing128;

#endif

typedef struct Object_ref {
  pointer data;
  ClassModel *classmodel;
  i64 refCounter;
  boolean is_stack;
} Object_ref;

void __onEnter();
void __onExit();
void __onFinalExit();

ObjectClassModel *getObjectClassModel();
void registerClassModel(pointer);

void populateObjectClassModel(pointer);

void assignObject(num *var, num ref_id);
Object_ref *borrowObject(num ref);

// used in destructors
Object_ref *useObject(num ref);
void returnObject(num ref);
num createObject(pointer object_data, ClassModel *class_model, boolean is_stack);

void populateStringClassModel(pointer _classModel);
StringClassModel *getStringClassModel();
num String_create(Str string);


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

void populateArrayClassModel(pointer _classModel);
ArrayClassModel *getArrayClassModel();

num Array_create(num length, primative_types type, u8 dataSize);
num Array_create_unmanaged(pointer array, num length, primative_types type, num dataSize);

/**
 * RefArray
 */

void populateRefArrayClassModel(pointer _classModel);
RefArrayClassModel *getRefArrayClassModel();
num RefArray_create(num length);

/**
 * Boxing 
 */

void populateBoxing_b8_ClassModel(pointer _classModel);
Boxingu8ClassModel *getBoxing_b8_ClassModel();
num Boxing_b8_create(boolean value);

void populateBoxing_i8_ClassModel(pointer _classModel);
Boxingi8ClassModel *getBoxing_i8_ClassModel();
num Boxing_i8_create(i8 value);

void populateBoxing_u8_ClassModel(pointer _classModel);
Boxingu8ClassModel *getBoxing_u8_ClassModel();
num Boxing_u8_create(u8 value);

void populateBoxing_u16_ClassModel(pointer _classModel);
Boxingu16ClassModel *getBoxing_u16_ClassModel();
num Boxing_u16_create(u16 value);

void populateBoxing_i16_ClassModel(pointer _classModel);
Boxingi16ClassModel *getBoxing_i16_ClassModel();
num Boxing_i16_create(i16 value);

void populateBoxing_u32_ClassModel(pointer _classModel);
Boxingu32ClassModel *getBoxing_u32_ClassModel();
num Boxing_u32_create(u32 value);

void populateBoxing_i32_ClassModel(pointer _classModel);
Boxingi32ClassModel *getBoxing_i32_ClassModel();
num Boxing_i32_create(i32 value);

void populateBoxing_f32_ClassModel(pointer _classModel);
Boxingf32ClassModel *getBoxing_f32_ClassModel();
num Boxing_f32_create(f32 value);

void populateBoxing_i64_ClassModel(pointer _classModel);
Boxingi64ClassModel *getBoxing_i64_ClassModel();
num Boxing_i64_create(i64 value);

void populateBoxing_u64_ClassModel(pointer _classModel);
Boxingu64ClassModel *getBoxing_u64_ClassModel();
num Boxing_u64_create(u64 value);

void populateBoxing_f64_ClassModel(pointer _classModel);
Boxingf64ClassModel *getBoxing_f64_ClassModel();
num Boxing_f64_create(f64 value);

extern ArrayClassModel *_arrayClassModel;
extern RefArrayClassModel *_refArrayClassModel;
extern Boxingu8ClassModel *_boxing_b8_ClassModel;
extern Boxingi8ClassModel *_boxing_i8_ClassModel;
extern Boxingi16ClassModel *_boxing_i16_ClassModel;
extern Boxingi32ClassModel *_boxing_i32_ClassModel;
extern Boxingi64ClassModel *_boxing_i64_ClassModel;
extern Boxingu8ClassModel *_boxing_u8_ClassModel;
extern Boxingu16ClassModel *_boxing_u16_ClassModel;
extern Boxingu32ClassModel *_boxing_u32_ClassModel;
extern Boxingu64ClassModel *_boxing_u64_ClassModel;
extern Boxingf32ClassModel *_boxing_f32_ClassModel;
extern Boxingf64ClassModel *_boxing_f64_ClassModel;

#ifdef __SUPPORT_QUADMATH_
void populateBoxing_f80_ClassModel(pointer _classModel);
BoxingClassModel *getBoxing_f80_ClassModel();
num Boxing_f80_create(f80 value);

void populateBoxing_f128_ClassModel(pointer _classModel);
BoxingClassModel *getBoxing_f128_ClassModel();
num Boxing_f120_create(f128 value);

extern BoxingClassModel *_boxing_80_ClassModel;
extern BoxingClassModel *_boxing_128_ClassModel;
#endif

#endif