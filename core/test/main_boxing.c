#include "Core.Core_main.h"

void tboolean() {
  __onEnter();
  b8 val = true;
  num boxed = create_c_2106303_B8_1(val);

  Object_ref* objRef = (Object_ref *)useObject(boxed);
  c_2106303_B8_cm *cm =  objRef->classmodel;

  printf("boolean value=%d", val);
  printf(", value=%d", ((c_2106303_B8*)objRef->data)->value);
  printf(", getClassName=%s", cm->className());
  printf(", datatype=%d", cm->datatype());
  printf(", typename=%s", cm->typename());
  printf(", asStr=%s\n", cm->asStr(boxed));

  ((c_2106303_B8*)objRef->data)->value = false;

  printf("boolean value=%d", val);
  printf(", value=%d", ((c_2106303_B8*)objRef->data)->value);
  printf(", getClassName=%s", cm->className(boxed));
  printf(", datatype=%d", cm->datatype(boxed));
  printf(", typename=%s", cm->typename(boxed));
  printf(", asStr=%s\n", cm->asStr(boxed));

  __onExit();
}

void tu8() {
  __onEnter();
  u8 val = 255;
  num boxed = create_c_2106303_U8_1(val);

  Object_ref* objRef = (Object_ref *)useObject(boxed);
  c_2106303_U8_cm *cm =  objRef->classmodel;

  printf("u8 value=%d", val);
  printf(", value=%d", ((c_2106303_U8*)objRef->data)->value);
  printf(", getClassName=%s", cm->className(boxed));
  printf(", datatype=%d", cm->datatype(boxed));
  printf(", typename=%s", cm->typename(boxed));
  printf(", asStr=%s\n", cm->asStr(boxed));

  val = 75;
  u8* valuep = &((c_2106303_U8*)objRef->data)->value;

  *valuep = val;

  printf("u8 value=%d", val);
  printf(", value=%d", ((c_2106303_U8*)objRef->data)->value);
  printf(", getClassName=%s", cm->className(boxed));
  printf(", datatype=%d", cm->datatype(boxed));
  printf(", typename=%s", cm->typename(boxed));
  printf(", asStr=%s\n", cm->asStr(boxed));

  __onExit();
}

void tpointer() {
  __onEnter();
  pointer val = "Pointer to a string";
  num boxed = create_c_2106303_Pointer_1(val);

  Object_ref* objRef = (Object_ref *)useObject(boxed);
  c_2106303_Pointer_cm *cm =  objRef->classmodel;

  printf("Pointer value=%p", val);
  printf(", value=%p", ((c_2106303_Pointer*)objRef->data)->value);
  printf(", getClassName=%s", cm->className(boxed));
  printf(", datatype=%d", cm->datatype(boxed));
  printf(", typename=%s", cm->typename(boxed));
  printf(", asStr=%s\n", cm->asStr(boxed));

  val = "Pointer to another string";
  pointer* valuep = &((c_2106303_Pointer*)objRef->data)->value;

  *valuep = val;

  printf("Pointer value=%p", val);
  printf(", value=%p", ((c_2106303_Pointer*)objRef->data)->value);
  printf(", getClassName=%s", cm->className(boxed));
  printf(", datatype=%d", cm->datatype(boxed));
  printf(", typename=%s", cm->typename(boxed));
  printf(", asStr=%s\n", cm->asStr(boxed));

  __onExit();
}

/*
void ti8() {
  __onEnter();
  i8 val = -127;
  num boxed = Boxing_i8_create(val);

  Boxingi8ClassModel *boxingi8ClassModel = (Boxingi8ClassModel *)useObject(boxed)->classmodel;
  Boxingi8 *boxing = (Boxingi8 *)useObject(boxed)->data;

  printf("i8 value=%i", val);
  printf(", value=%i", boxing->value);
  printf(", name=%s", boxingi8ClassModel->className(boxed));
  printf(", type=%d", boxingi8ClassModel->type(boxed));
  printf(", typename=%s", boxingi8ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingi8ClassModel->asStr(boxed));

  __onExit();
}

void ti16() {
  __onEnter();
  i16 val = -32768;
  num boxed = Boxing_i16_create(val);

  Boxingi16ClassModel *boxingi16ClassModel = (Boxingi16ClassModel *)useObject(boxed)->classmodel;
  Boxingi16 *boxing = (Boxingi16 *)useObject(boxed)->data;

  printf("i16 value=%d", val);
  printf(", value=%d", boxing->value);
  printf(", name=%s", boxingi16ClassModel->className(boxed));
  printf(", type=%d", boxingi16ClassModel->type(boxed));
  printf(", typename=%s", boxingi16ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingi16ClassModel->asStr(boxed));

  __onExit();
}

void tu16() {
  __onEnter();
  u16 val = 65535;
  num boxed = Boxing_u16_create(val);

  Boxingu16ClassModel *boxingu16ClassModel = (Boxingu16ClassModel *)useObject(boxed)->classmodel;
  Boxingu16 *boxing = (Boxingu16 *)useObject(boxed)->data;

  printf("u16 value=%d", val);
  printf(", value=%d", boxing->value);
  printf(", name=%s", boxingu16ClassModel->className(boxed));
  printf(", type=%d", boxingu16ClassModel->type(boxed));
  printf(", typename=%s", boxingu16ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingu16ClassModel->asStr(boxed));

  __onExit();
}

void tu32() {
  __onEnter();
  u32 val = 65536;
  num boxed = Boxing_u32_create(val);

  Boxingu32ClassModel *boxingu32ClassModel = (Boxingu32ClassModel *)useObject(boxed)->classmodel;
  Boxingu32 *boxing = (Boxingu32 *)useObject(boxed)->data;

  printf("u32 value=%u", val);
  printf(", value=%u", boxing->value);
  printf(", name=%s", boxingu32ClassModel->className(boxed));
  printf(", type=%d", boxingu32ClassModel->type(boxed));
  printf(", typename=%s", boxingu32ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingu32ClassModel->asStr(boxed));

  __onExit();
}

void ti32() {
  __onEnter();
  i32 val = -65536;
  num boxed = Boxing_i32_create(val);

  Boxingi32ClassModel *boxingi32ClassModel = (Boxingi32ClassModel *)useObject(boxed)->classmodel;
  Boxingi32 *boxing = (Boxingi32 *)useObject(boxed)->data;

  printf("i32 value=%i", val);
  printf(", value=%i", boxing->value);
  printf(", name=%s", boxingi32ClassModel->className(boxed));
  printf(", type=%d", boxingi32ClassModel->type(boxed));
  printf(", typename=%s", boxingi32ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingi32ClassModel->asStr(boxed));

  __onExit();
}

void tf32() {
  __onEnter();
  f32 val = -65536.78;
  num boxed = Boxing_f32_create(val);

  Boxingf32ClassModel *boxingf32ClassModel = (Boxingf32ClassModel *)useObject(boxed)->classmodel;
  Boxingf32 *boxing = (Boxingf32 *)useObject(boxed)->data;

  printf("f32 value=%f", val);
  printf(", value=%f", boxing->value);
  printf(", name=%s", boxingf32ClassModel->className(boxed));
  printf(", type=%d", boxingf32ClassModel->type(boxed));
  printf(", typename=%s", boxingf32ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingf32ClassModel->asStr(boxed));

  __onExit();
}
// 64

void tu64() {
  __onEnter();
  u64 val = 65536;
  num boxed = Boxing_u64_create(val);

  Boxingu64ClassModel *boxingu64ClassModel = (Boxingu64ClassModel *)useObject(boxed)->classmodel;
  Boxingu64 *boxing = (Boxingu64 *)useObject(boxed)->data;

  printf("u64 value=%lu", val);
  printf(", value=%lu", boxing->value);
  printf(", name=%s", boxingu64ClassModel->className(boxed));
  printf(", type=%d", boxingu64ClassModel->type(boxed));
  printf(", typename=%s", boxingu64ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingu64ClassModel->asStr(boxed));

  __onExit();
}

void ti64() {
  __onEnter();
  i64 val = -65536;
  num boxed = Boxing_i64_create(val);

  Boxingi64ClassModel *boxingi64ClassModel = (Boxingi64ClassModel *)useObject(boxed)->classmodel;
  Boxingi64 *boxing = (Boxingi64 *)useObject(boxed)->data;

  printf("i64 value=%li", val);
  printf(", value=%li", boxing->value);
  printf(", name=%s", boxingi64ClassModel->className(boxed));
  printf(", type=%d", boxingi64ClassModel->type(boxed));
  printf(", typename=%s", boxingi64ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingi64ClassModel->asStr(boxed));

  __onExit();
}

void tf64() {
  __onEnter();
  f64 val = -65536.78;
  num boxed = Boxing_f64_create(val);

  Boxingf64ClassModel *boxingf64ClassModel = (Boxingf64ClassModel *)useObject(boxed)->classmodel;
  Boxingf64 *boxing = (Boxingf64 *)useObject(boxed)->data;

  printf("f64 value=%f", val);
  printf(", value=%f", boxing->value);
  printf(", name=%s", boxingf64ClassModel->className(boxed));
  printf(", type=%d", boxingf64ClassModel->type(boxed));
  printf(", typename=%s", boxingf64ClassModel->typename(boxed));
  printf(", asStr=%s\n", boxingf64ClassModel->asStr(boxed));

  __onExit();
}

void somefunction2() {
  __onEnter();
  printf("somefunction2\n");
  Boxing_f64_create(1000);

  __onExit();
}

num otheri64;

void somefunction1() {
  __onEnter();
  otheri64 = Boxing_f64_create(1001);

  printf("somefunction1\n");
  somefunction2();

  num id = String_create("String 1");
  printf("a string %s\n", getStringClassModel()->asStr(id));
  __onExit();
}
*/
int main() {

    // somefunction1();
    tboolean();
    tu8();
    tpointer();
    // ti8();
    // // ti16();
    // tu16();
    // tu32();
    // ti32();
    // tf32();

    // tu64();
    // ti64();
    // tf64();

  __onFinalExit();
}