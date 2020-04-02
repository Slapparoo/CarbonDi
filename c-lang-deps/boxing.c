#include "types.h"

Str Boxing_typename(num ref) {
    primative_types type = ((BoxingClassModel *)useObject(ref)->classmodel)->type(ref);
    return primative_names[type];
}

void populateBoxing_ClassModel(pointer _classModel, Str name, primative_types (*type)(num)) {
  populateObjectClassModel(_classModel);
  BoxingClassModel *classModel = (BoxingClassModel *)_classModel;

  classModel->parent = getObjectClassModel();
  classModel->name = name;
  classModel->package = "Core";
  classModel->type = type; 
  classModel->typename = Boxing_typename;
}

/**
 * Boolean
 * 
 * Boolean use the u8 classmodel because bool is a u8
 */ 
Boxingu8ClassModel *_boxing_b8_ClassModel;

b8 Boxing_b8_value(num ref) {
    return ((Boxingu8 *)useObject(ref)->data)->value;
}

Str Boxing_b8_asStr(num ref) {
    if (Boxing_b8_value(ref)) {
      return "true";
    } else {
      return "false";
    }
}

primative_types Boxing_b8_type(num ref) {
    return _b8;
}

void populateBoxing_b8_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxb8", Boxing_b8_type);
  ((Boxingu8ClassModel *)_classModel)->value = Boxing_b8_value;
  ((Boxingu8ClassModel *)_classModel)->asStr = Boxing_b8_asStr;
};

Boxingu8ClassModel *getBoxing_b8_ClassModel() {
  if (_boxing_b8_ClassModel == NULL) {
    _boxing_b8_ClassModel = malloc(sizeof(Boxingu8ClassModel));
    registerClassModel(_boxing_b8_ClassModel);
    populateBoxing_b8_ClassModel(_boxing_b8_ClassModel);
  }
  return _boxing_b8_ClassModel;
}

num Boxing_b8_create(boolean value) {
    Boxingu8 *_boxing = malloc(sizeof(Boxingu8));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_b8_ClassModel(), false);
}

/**
 * i8
 */
Boxingi8ClassModel *_boxing_i8_ClassModel;

i8 Boxing_i8_value(num ref) {
    return ((Boxingi8 *)useObject(ref)->data)->value;
}

Str Boxing_i8_asStr(num ref) {
    sprintf(tmpBuffer, "%i", Boxing_i8_value(ref));
    return tmpBuffer;
}

primative_types Boxing_i8_type(num ref) {
    return _i8;
}

void populateBoxing_i8_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxi8", Boxing_i8_type);
  ((Boxingi8ClassModel *)_classModel)->value = Boxing_i8_value;
  ((Boxingi8ClassModel *)_classModel)->asStr = Boxing_i8_asStr;
};

Boxingi8ClassModel *getBoxing_i8_ClassModel() {
  if (_boxing_i8_ClassModel == NULL) {
    _boxing_i8_ClassModel = malloc(sizeof(Boxingi8ClassModel));
    registerClassModel(_boxing_i8_ClassModel);
    populateBoxing_i8_ClassModel(_boxing_i8_ClassModel);
  }
  return _boxing_i8_ClassModel;
}

num Boxing_i8_create(i8 value) {
    Boxingi8 *_boxing = malloc(sizeof(Boxingi8));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_i8_ClassModel(), false);
}

/**
 * u8
 */
Boxingu8ClassModel *_boxing_u8_ClassModel;

u8 Boxing_u8_value(num ref) {
    return ((Boxingu8 *)useObject(ref)->data)->value;
}

Str Boxing_u8_asStr(num ref) {
    sprintf(tmpBuffer, "%u", Boxing_u8_value(ref));
    return tmpBuffer;
}

primative_types Boxing_u8_type(num ref) {
    return _u8;
}

void populateBoxing_u8_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxu8", Boxing_u8_type);
  ((Boxingu8ClassModel *)_classModel)->value = Boxing_u8_value;
  ((Boxingu8ClassModel *)_classModel)->asStr = Boxing_u8_asStr;
};

Boxingu8ClassModel *getBoxing_u8_ClassModel() {
  if (_boxing_u8_ClassModel == NULL) {
    _boxing_u8_ClassModel = malloc(sizeof(Boxingu8ClassModel));
    registerClassModel(_boxing_u8_ClassModel);
    populateBoxing_u8_ClassModel(_boxing_u8_ClassModel);
  }
  return _boxing_u8_ClassModel;
}

num Boxing_u8_create(u8 value) {
    Boxingu8 *_boxing = malloc(sizeof(Boxingu8));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_u8_ClassModel(), false);
}

/**
 * i16
 */
Boxingi16ClassModel *_boxing_i16_ClassModel;

i16 Boxing_i16_value(num ref) {
    return ((Boxingi16 *)useObject(ref)->data)->value;
}

Str Boxing_i16_asStr(num ref) {
    sprintf(tmpBuffer, "%i", Boxing_i16_value(ref));
    return tmpBuffer;
}

primative_types Boxing_i16_type(num ref) {
    return _i16;
}

void populateBoxing_i16_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxi16", Boxing_i16_type);
  ((Boxingi16ClassModel *)_classModel)->value = Boxing_i16_value;
  ((Boxingi16ClassModel *)_classModel)->asStr = Boxing_i16_asStr;
};

Boxingi16ClassModel *getBoxing_i16_ClassModel() {
  if (_boxing_i16_ClassModel == NULL) {
    _boxing_i16_ClassModel = malloc(sizeof(Boxingi16ClassModel));
    registerClassModel(_boxing_i16_ClassModel);
    populateBoxing_i16_ClassModel(_boxing_i16_ClassModel);
  }
  return _boxing_i16_ClassModel;
}

num Boxing_i16_create(i16 value) {
    Boxingi16 *_boxing = malloc(sizeof(Boxingi16));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_i16_ClassModel(), false);
}

/**
 * u16
 */
Boxingu16ClassModel *_boxing_u16_ClassModel;

u16 Boxing_u16_value(num ref) {
    return ((Boxingu16 *)useObject(ref)->data)->value;
}

Str Boxing_u16_asStr(num ref) {
    sprintf(tmpBuffer, "%i", Boxing_u16_value(ref));
    return tmpBuffer;
}

primative_types Boxing_u16_type(num ref) {
    return _u16;
}

void populateBoxing_u16_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxu16", Boxing_u16_type);
  ((Boxingu16ClassModel *)_classModel)->value = Boxing_u16_value;
  ((Boxingu16ClassModel *)_classModel)->asStr = Boxing_u16_asStr;
};

Boxingu16ClassModel *getBoxing_u16_ClassModel() {
  if (_boxing_u16_ClassModel == NULL) {
    _boxing_u16_ClassModel = malloc(sizeof(Boxingu16ClassModel));
    registerClassModel(_boxing_u16_ClassModel);
    populateBoxing_u16_ClassModel(_boxing_u16_ClassModel);
  }
  return _boxing_u16_ClassModel;
}

num Boxing_u16_create(u16 value) {
    Boxingu16 *_boxing = malloc(sizeof(Boxingu16));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_u16_ClassModel(), false);
}

/**
 * u32
 */
Boxingu32ClassModel *_boxing_u32_ClassModel;

u32 Boxing_u32_value(num ref) {
    return ((Boxingu32 *)useObject(ref)->data)->value;
}

Str Boxing_u32_asStr(num ref) {
    sprintf(tmpBuffer, "%u", Boxing_u32_value(ref));
    return tmpBuffer;
}

primative_types Boxing_u32_type(num ref) {
    return _u32;
}

void populateBoxing_u32_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxu32", Boxing_u32_type);
  ((Boxingu32ClassModel *)_classModel)->value = Boxing_u32_value;
  ((Boxingu32ClassModel *)_classModel)->asStr = Boxing_u32_asStr;
};

Boxingu32ClassModel *getBoxing_u32_ClassModel() {
  if (_boxing_u32_ClassModel == NULL) {
    _boxing_u32_ClassModel = malloc(sizeof(Boxingu32ClassModel));
    registerClassModel(_boxing_u32_ClassModel);
    populateBoxing_u32_ClassModel(_boxing_u32_ClassModel);
  }
  return _boxing_u32_ClassModel;
}

num Boxing_u32_create(u32 value) {
    Boxingu32 *_boxing = malloc(sizeof(Boxingu32));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_u32_ClassModel(), false);
}

/**
 * i32
 */
Boxingi32ClassModel *_boxing_i32_ClassModel;

i32 Boxing_i32_value(num ref) {
    return ((Boxingi32 *)useObject(ref)->data)->value;
}

Str Boxing_i32_asStr(num ref) {
    sprintf(tmpBuffer, "%i", Boxing_i32_value(ref));
    return tmpBuffer;
}

primative_types Boxing_i32_type(num ref) {
    return _i32;
}

void populateBoxing_i32_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxi32", Boxing_i32_type);
  ((Boxingi32ClassModel *)_classModel)->value = Boxing_i32_value;
  ((Boxingi32ClassModel *)_classModel)->asStr = Boxing_i32_asStr;
};

Boxingi32ClassModel *getBoxing_i32_ClassModel() {
  if (_boxing_i32_ClassModel == NULL) {
    _boxing_i32_ClassModel = malloc(sizeof(Boxingi32ClassModel));
    registerClassModel(_boxing_i32_ClassModel);
    populateBoxing_i32_ClassModel(_boxing_i32_ClassModel);
  }
  return _boxing_i32_ClassModel;
}

num Boxing_i32_create(i32 value) {
    Boxingi32 *_boxing = malloc(sizeof(Boxingi32));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_i32_ClassModel(), false);
}

/**
 * f32
 */
Boxingf32ClassModel *_boxing_f32_ClassModel;

f32 Boxing_f32_value(num ref) {
    return ((Boxingf32 *)useObject(ref)->data)->value;
}

Str Boxing_f32_asStr(num ref) {
    sprintf(tmpBuffer, "%f", Boxing_f32_value(ref));
    return tmpBuffer;
}

primative_types Boxing_f32_type(num ref) {
    return _f32;
}

void populateBoxing_f32_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxf32", Boxing_f32_type);
  ((Boxingf32ClassModel *)_classModel)->value = Boxing_f32_value;
  ((Boxingf32ClassModel *)_classModel)->asStr = Boxing_f32_asStr;
};

Boxingf32ClassModel *getBoxing_f32_ClassModel() {
  if (_boxing_f32_ClassModel == NULL) {
    _boxing_f32_ClassModel = malloc(sizeof(Boxingf32ClassModel));
    registerClassModel(_boxing_f32_ClassModel);
    populateBoxing_f32_ClassModel(_boxing_f32_ClassModel);
  }
  return _boxing_f32_ClassModel;
}

num Boxing_f32_create(f32 value) {
    Boxingf32 *_boxing = malloc(sizeof(Boxingf32));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_f32_ClassModel(), false);
}

/**
 * i64
 */
Boxingi64ClassModel *_boxing_i64_ClassModel;

i64 Boxing_i64_value(num ref) {
    return ((Boxingi64 *)useObject(ref)->data)->value;
}

Str Boxing_i64_asStr(num ref) {
    sprintf(tmpBuffer, "%li", Boxing_i64_value(ref));
    return tmpBuffer;
}

primative_types Boxing_i64_type(num ref) {
    return _i64;
}

void populateBoxing_i64_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxi64", Boxing_i64_type);
  ((Boxingi64ClassModel *)_classModel)->value = Boxing_i64_value;
  ((Boxingi64ClassModel *)_classModel)->asStr = Boxing_i64_asStr;
};

Boxingi64ClassModel *getBoxing_i64_ClassModel() {
  if (_boxing_i64_ClassModel == NULL) {
    _boxing_i64_ClassModel = malloc(sizeof(Boxingi64ClassModel));
    registerClassModel(_boxing_i64_ClassModel);
    populateBoxing_i64_ClassModel(_boxing_i64_ClassModel);
  }
  return _boxing_i64_ClassModel;
}

num Boxing_i64_create(i64 value) {
    Boxingi64 *_boxing = malloc(sizeof(Boxingi64));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_i64_ClassModel(), false);
}

/**
 * u64
 */
Boxingu64ClassModel *_boxing_u64_ClassModel;

u64 Boxing_u64_value(num ref) {
    return ((Boxingu64 *)useObject(ref)->data)->value;
}

Str Boxing_u64_asStr(num ref) {
    sprintf(tmpBuffer, "%lui", Boxing_u64_value(ref));
    return tmpBuffer;
}

primative_types Boxing_u64_type(num ref) {
    return _u64;
}

void populateBoxing_u64_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxu64", Boxing_u64_type);
  ((Boxingu64ClassModel *)_classModel)->value = Boxing_u64_value;
  ((Boxingu64ClassModel *)_classModel)->asStr = Boxing_u64_asStr;
};

Boxingu64ClassModel *getBoxing_u64_ClassModel() {
  if (_boxing_u64_ClassModel == NULL) {
    _boxing_u64_ClassModel = malloc(sizeof(Boxingu64ClassModel));
    registerClassModel(_boxing_u64_ClassModel);
    populateBoxing_u64_ClassModel(_boxing_u64_ClassModel);
  }
  return _boxing_u64_ClassModel;
}

num Boxing_u64_create(u64 value) {
    Boxingu64 *_boxing = malloc(sizeof(Boxingu64));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_u64_ClassModel(), false);
}

/**
 * f64
 */
Boxingf64ClassModel *_boxing_f64_ClassModel;

f64 Boxing_f64_value(num ref) {
    return ((Boxingf64 *)useObject(ref)->data)->value;
}

Str Boxing_f64_asStr(num ref) {
    sprintf(tmpBuffer, "%lf", Boxing_f64_value(ref));
    return tmpBuffer;
}

primative_types Boxing_f64_type(num ref) {
    return _f64;
}

void populateBoxing_f64_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxf64", Boxing_f64_type);
  ((Boxingf64ClassModel *)_classModel)->value = Boxing_f64_value;
  ((Boxingf64ClassModel *)_classModel)->asStr = Boxing_f64_asStr;
};

Boxingf64ClassModel *getBoxing_f64_ClassModel() {
  if (_boxing_f64_ClassModel == NULL) {
    _boxing_f64_ClassModel = malloc(sizeof(Boxingf64ClassModel));
    registerClassModel(_boxing_f64_ClassModel);
    populateBoxing_f64_ClassModel(_boxing_f64_ClassModel);
  }
  return _boxing_f64_ClassModel;
}

num Boxing_f64_create(f64 value) {
    Boxingf64 *_boxing = malloc(sizeof(Boxingf64));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_f64_ClassModel(), false);
}

/**
 * f80
 */
#ifdef __SUPPORT_QUADMATH_

Boxingf80ClassModel *_boxing_f80_ClassModel;

f80 Boxing_f80_value(num ref) {
    return ((Boxing80 *)useObject(ref)->data)->value;
}

Str Boxing_f80_asStr(num ref) {
    sprintf(tmpBuffer, "%lf", Boxing_f80_value(ref));
    return tmpBuffer;
}

primative_types Boxing_f80_type(num ref) {
    return _f80;
}

void populateBoxing_f80_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxf80", Boxing_f80_type);
  ((Boxingf80ClassModel *)_classModel)->value = Boxing_f80_value;
  ((Boxingf80ClassModel *)_classModel)->asStr = Boxing_f80_asStr;
};

Boxingf80ClassModel *getBoxing_f80_ClassModel() {
  if (_boxing_f80_ClassModel == NULL) {
    _boxing_f80_ClassModel = malloc(sizeof(Boxingf80ClassModel));
    registerClassModel(_boxing_f80_ClassModel);
    populateBoxing_f80_ClassModel(_boxing_f80_ClassModel);
  }
  return _boxing_f80_ClassModel;
}

num Boxing_f80_create(f80 value) {
    Boxing80 *_boxing = malloc(sizeof(Boxing80));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_f80_ClassModel(), false);
}

/**
 * f128
 */
Boxingf128ClassModel *_boxing_f128_ClassModel;

f128 Boxing_f128_value(num ref) {
    return ((Boxing128 *)useObject(ref)->data)->value;
}

Str Boxing_f128_asStr(num ref) {
    sprintf(tmpBuffer, "%lf", Boxing_f128_value(ref));
    return tmpBuffer;
}

primative_types Boxing_f128_type(num ref) {
    return _f128;
}

void populateBoxing_f128_ClassModel(pointer _classModel) {
  populateBoxing_ClassModel(_classModel, "Boxf128", Boxing_f128_type);
  ((Boxingf128ClassModel *)_classModel)->value = Boxing_f128_value;
  ((Boxingf128ClassModel *)_classModel)->asStr = Boxing_f128_asStr;
};

Boxingf128ClassModel *getBoxing_f128_ClassModel() {
  if (_boxing_f128_ClassModel == NULL) {
    _boxing_f128_ClassModel = malloc(sizeof(Boxingf128ClassModel));
    registerClassModel(_boxing_f128_ClassModel);
    populateBoxing_f128_ClassModel(_boxing_f128_ClassModel);
  }
  return _boxing_f128_ClassModel;
}

num Boxing_f128_create(f128 value) {
    Boxing128 *_boxing = malloc(sizeof(Boxing128));
    _boxing->value = value;
    return createObject(_boxing, (ClassModel *)getBoxing_f128_ClassModel(), false);
}

#endif