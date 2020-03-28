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

typedef float f32;
typedef double f64;

typedef i64 num;

#ifdef __SUPPORT_QUADMATH_
typedef __float128 f128;
typedef long double f80;
#endif

typedef char *Str;
typedef enum { false, true } boolean;

typedef num ObjectRef;

typedef struct String {
  Str str;
  num len;
} String;

Str String_asStr(num);

#define __STANDARDCLASS_MODEL_             \
  ObjectClassModel *parent;                \
  Str name;                                \
  Str package;                             \
  Str (*asStr)(num ref);                   \
  void (*printTo)(num ref, FILE * stream); \
  void (*free)(num ref);                   \
  String (*asString)(num ref);

typedef struct ObjectClassModel ObjectClassModel;

typedef struct ObjectClassModel {
  __STANDARDCLASS_MODEL_
} ClassModel;

typedef struct StringClassModel {
  __STANDARDCLASS_MODEL_
  // <-- specific order
  num (*length)(num);
  boolean (*contains)(num, num);
  num (*subString)(num, num, num);
  num (*toUpper)(num);
  num (*toLower)(num);
  num (*concat)(num, num);

} StringClassModel;

typedef struct Object_ref {
  void *data;
  ClassModel *classmodel;
  i64 refCounter;
  boolean is_stack;
} Object_ref;

#define PM_LIST_LENGTH 1000

void __onEnter();
void __onExit();

ObjectClassModel *getObjectClassModel();

void populateObjectClassModel(void *);

void assignObject(num *var, num ref_id);
Object_ref *borrowObject(num ref);

// used in destructors
Object_ref *useObject(num ref);
void returnObject(num ref);
num createObject(void *object_data, ClassModel *class_model, boolean is_stack);

void populateStringClassModel(void *_classModel);
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



#endif