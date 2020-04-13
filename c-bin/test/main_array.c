#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"

void ti8() {
  printf("ti8\n");
  __onEnter();
  // t1 i8
  num bananas = create_Array$1(10, _i8, sizeof(i8));
  ArrayClassModel* acm = (ArrayClassModel*)getArrayClassModel();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  i8 *_bannans = ((Array *)useObject(bananas)->data)->values;
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
  num bananas = create_Array$1(10, _u16, sizeof(u16));
  ArrayClassModel* acm = (ArrayClassModel*)getArrayClassModel();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  u16 *_bannans = ((Array *)useObject(bananas)->data)->values;
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
  num bananas = create_Array$1(10, _i32, sizeof(i32));
  ArrayClassModel* acm = (ArrayClassModel*)getArrayClassModel();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  i32 *_bannans = ((Array *)useObject(bananas)->data)->values;
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
  num bananas = create_Array$1(100, _f64, sizeof(f64));

  ArrayClassModel* acm = (ArrayClassModel*)getArrayClassModel();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));
  printf("asStr=%s\n", acm->asStr(bananas));

  f64 *_bannans = ((Array *)useObject(bananas)->data)->values;
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
  num bananas = create_RefArray$1(10);
  RefArrayClassModel* acm = (RefArrayClassModel*)getRefArrayClassModel();
  printf("length=%ld\n", acm->get_length(bananas));
  printf("capacity=%ld\n", acm->get_capacity(bananas));
  printf("type=%d\n", acm->get_dataType(bananas));
  printf("memsize=%ld\n", acm->memsize(bananas));
  printf("typename=%s\n", acm->typename(bananas));

  num *_bannans = ((Array *)useObject(bananas)->data)->values;

  num val = create_String$1("hello");
  num val2 = create_String$1("hello2");
  num val3 = create_String$1("hello2");

  // printf("_bannans[0]=%ld\n", _bannans[0]);

  acm->setObject(bananas, 0, val);
  acm->setObject(bananas, 1, val2);
  printf("_bannans[0]=%ld\n", _bannans[0]);
  printf("_bannans[1]=%ld\n", _bannans[1]);
  acm->setObject(bananas, 1, val3);
  printf("_bannans[1]=%ld\n", _bannans[1]);

  num apples = create_RefArray$1(10);
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
  num a = create_Array$2(9, _i8, 1, name);
  printf("tunmanaged\n");
  RefArrayClassModel* acm = (RefArrayClassModel*)getRefArrayClassModel();
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
