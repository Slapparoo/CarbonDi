#include "Core.Core_main.h"


void ti8() {
  printf("ti8\n");
  __onEnter();
  // t1 i8
  num bananas = create_c_2106303_Array_1(10, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  c_2106303_Array_cm* acm = (c_2106303_Array_cm*)getc_2106303_Array_cm();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  printf("print_log ");
  print_log(1, bananas);

  i8 *_bannans = ((c_2106303_Array *)useObject(bananas)->data)->values;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  i8 val = 20;

  acm->set(bananas, 0, &val);
  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", ((i8 *)acm->get(bananas, 0))[0]);

  __onExit();
}

void tu16() {
  printf("tu16\n");
  __onEnter();
  // t1 i8
  num bananas = create_c_2106303_Array_1(10, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->u16_, sizeof(u16));
  c_2106303_Array_cm* acm = (c_2106303_Array_cm*)getc_2106303_Array_cm();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  u16 *_bannans = ((c_2106303_Array *)useObject(bananas)->data)->values;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  u16 val = 20;

  acm->set(bananas, 0, &val);
  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", ((u16 *)acm->get(bananas, 0))[0]);

  __onExit();
}

void ti32() {
  printf("ti32\n");
  __onEnter();
  // t1 i32
  num bananas = create_c_2106303_Array_1(10, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i32_, sizeof(i32));
  c_2106303_Array_cm* acm = (c_2106303_Array_cm*)getc_2106303_Array_cm();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  i32 *_bannans = ((c_2106303_Array *)useObject(bananas)->data)->values;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  *(i32 *)acm->get(bananas, 0) = 30;

  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", *((i32 *)acm->get(bananas, 0)));

  __onExit();
}

void tf64() {
  printf("tf64\n");
  __onEnter();
  // t1 i32
  

  num bananas = create_c_2106303_Array_1(100, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->f64_, sizeof(f64));

  c_2106303_Array_cm* acm = (c_2106303_Array_cm*)getc_2106303_Array_cm();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));
  printf("asStr=%s\n", acm->asStr(bananas));

  f64 *_bannans = ((c_2106303_Array *)useObject(bananas)->data)->values;
  _bannans[0] = 10.10;

  printf("_bannans[0]=%f\n", _bannans[0]);
  f64 val = 23.32;

  acm->set(bananas, 0, &val);
  printf("_bannans[0]=%f\n", _bannans[0]);

  f64 v2 = *((f64 *)acm->get(bananas, 0));

  printf("_bannans[0]=%f\n", *((f64 *)acm->get(bananas, 0)));
  __onExit();
}

void tString() {
  printf("tString\n");
  __onEnter();
  // t1 i32
  num bananas = create_c_2106303_RefArray_1(10);
  c_2106303_RefArray_cm* acm = (c_2106303_RefArray_cm*)getc_2106303_RefArray_cm();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  num *_bannans = ((c_2106303_RefArray *)useObject(bananas)->data)->values;

  num val = create_c_2106303_String_2("hello", true);
  num val2 = create_c_2106303_String_2("hello2", true);
  num val3 = create_c_2106303_String_2("hello2", true);


  print_log(4, val, val2, val3, 0);

  // printf("_bannans[0]=%ld\n", _bannans[0]);

  acm->setObject(bananas, 0, val);
  acm->setObject(bananas, 1, val2);
  printf("_bannans[0]=%ld\n", _bannans[0]);
  printf("_bannans[1]=%ld\n", _bannans[1]);
  acm->setObject(bananas, 1, val3);
  printf("_bannans[1]=%ld\n", _bannans[1]);

  num apples = create_c_2106303_RefArray_1(10);
  acm->setObject(apples, 1, val2);
  acm->setObject(bananas, 2, apples);

  // num v2 = *((num*)getArrayClassModel()->get(bananas, 0));

  printf("_bannans[0]=%ld\n", *((num *)acm->get(bananas, 0)));
  printf("_bannans[1]=%ld\n", *((num *)acm->get(bananas, 1)));
  __onExit();
}

void tunmanaged(pointer name) {
  __onEnter();
  // t1 i32
  num a = create_c_2106303_Array_2(strlen(name)+1, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i8_, 1, name);
  printf("tunmanaged\n");
  c_2106303_Array_cm* acm = (c_2106303_Array_cm*)getc_2106303_Array_cm();
  printf("length=%ld\n", acm->get_length(a));
  printf("capacity=%ld\n", acm->get_capacity(a));
  printf("type=%d\n", acm->get_dataType(a));
  printf("memsize=%ld\n", acm->memsize(a));
  printf("typename=%s\n", acm->typename(a));

  printf("unmanaged %s\n", acm->get_values(a));
  printf("size %ld\n", acm->memsize(a));
  printf("asStr=%s\n", acm->asStr(a));
  __onExit();
}

int main() {
  if (!setjmp(*catchException())) {
    char *name = "the name";

    ti8();
    tu16();
    ti32();
    tf64();
    tunmanaged(name);
    tString();
  } else {
    afterCatchException();
  }

  __onFinalExit();
  return 0;
}
