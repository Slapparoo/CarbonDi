#ifndef __TYPES_H__
#define __TYPES_H__

#include "inttypes.h"

#ifdef __SUPPORT_QUADMATH_
#include "quadmath.h"
#endif
#include "stdio.h"
#include "stdlib.h"
#include "string.h"

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

typedef u8 *Str;
typedef enum { false, true } boolean;

typedef num ObjectRef;

typedef struct String {
  Str str;
  num len;
} String;

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


#endif