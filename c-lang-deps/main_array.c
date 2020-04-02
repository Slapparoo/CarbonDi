#include "array.h"

void ti8() {
  printf("ti8\n");
  __onEnter();
  // t1 i8
  num bananas = Array_create(10, _i8, sizeof(i8));
  printf("length=%ld\n", getArrayClassModel()->length(bananas));
  printf("capacity=%ld\n", getArrayClassModel()->capacity(bananas));
  printf("type=%d\n", getArrayClassModel()->type(bananas));
  printf("memsize=%ld\n", getArrayClassModel()->memsize(bananas));
  printf("typename=%s\n", getArrayClassModel()->typename(bananas));

  i8 *_bannans = ((Array *)useObject(bananas)->data)->array;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  i8 val = 20;

  getArrayClassModel()->set(bananas, 0, &val);
  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", ((i8*)getArrayClassModel()->get(bananas, 0))[0]);

  __onExit();

}

void tu16() {
  printf("tu16\n");
  __onEnter();
  // t1 i8
  num bananas = Array_create(10, _u16, sizeof(u16));
  printf("length=%ld\n", getArrayClassModel()->length(bananas));
  printf("capacity=%ld\n", getArrayClassModel()->capacity(bananas));
  printf("type=%d\n", getArrayClassModel()->type(bananas));
  printf("memsize=%ld\n", getArrayClassModel()->memsize(bananas));
  printf("typename=%s\n", getArrayClassModel()->typename(bananas));

  u16 *_bannans = ((Array *)useObject(bananas)->data)->array;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  u16 val = 20;

  getArrayClassModel()->set(bananas, 0, &val);
  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", ((u16*)getArrayClassModel()->get(bananas, 0))[0]);

  __onExit();
}

void ti32() {
  printf("ti32\n");
  __onEnter();
  // t1 i32
  num bananas = Array_create(10, _i32, sizeof(i32));
  printf("length=%ld\n", getArrayClassModel()->length(bananas));
  printf("capacity=%ld\n", getArrayClassModel()->capacity(bananas));
  printf("type=%d\n", getArrayClassModel()->type(bananas));
  printf("memsize=%ld\n", getArrayClassModel()->memsize(bananas));
  printf("typename=%s\n", getArrayClassModel()->typename(bananas));

  i32 *_bannans = ((Array *)useObject(bananas)->data)->array;
  _bannans[0] = 10;

  printf("_bannans[0]=%d\n", _bannans[0]);
  *(i32*)getArrayClassModel()->get(bananas, 0) = 30;
  
  printf("_bannans[0]=%d\n", _bannans[0]);

  printf("_bannans[0]=%d\n", *((i32*)getArrayClassModel()->get(bananas, 0)));

  __onExit();
}

void tf64() {
  printf("tf64\n");
  __onEnter();
  // t1 i32
  num bananas = Array_create(10, _f64, sizeof(f64));
  printf("length=%ld\n", getArrayClassModel()->length(bananas));
  printf("capacity=%ld\n", getArrayClassModel()->capacity(bananas));
  printf("type=%d\n", getArrayClassModel()->type(bananas));
  printf("memsize=%ld\n", getArrayClassModel()->memsize(bananas));
  printf("typename=%s\n", getArrayClassModel()->typename(bananas));

  f64 *_bannans = ((Array *)useObject(bananas)->data)->array;
  _bannans[0] = 10.10;

  printf("_bannans[0]=%f\n", _bannans[0]);
  f64 val = 23.32;

  getArrayClassModel()->set(bananas, 0, &val);
  printf("_bannans[0]=%f\n", _bannans[0]);

  f64 v2 = *((f64*)getArrayClassModel()->get(bananas, 0));

  printf("_bannans[0]=%f\n", *((f64*)getArrayClassModel()->get(bananas, 0)));
  __onExit();
}

void tString() {
  printf("tString\n");
  __onEnter();
  // t1 i32
  num bananas = RefArray_create(10);
  printf("length=%ld\n", getRefArrayClassModel()->length(bananas));
  printf("capacity=%ld\n", getRefArrayClassModel()->capacity(bananas));
  printf("type=%d\n", getRefArrayClassModel()->type(bananas));
  printf("typename=%s\n", getArrayClassModel()->typename(bananas));

  num *_bannans = ((Array *)useObject(bananas)->data)->array;

  num val = String_create("hello");
  num val2 = String_create("hello2");
  num val3 = String_create("hello2");
  
  // printf("_bannans[0]=%ld\n", _bannans[0]);

  getRefArrayClassModel()->setObject(bananas, 0, val);
  getRefArrayClassModel()->setObject(bananas, 1, val2);
  printf("_bannans[0]=%ld\n", _bannans[0]);
  printf("_bannans[1]=%ld\n", _bannans[1]);
  getRefArrayClassModel()->setObject(bananas, 1, val3);
  printf("_bannans[1]=%ld\n", _bannans[1]);


  num apples = RefArray_create(10);
  getRefArrayClassModel()->setObject(apples, 1, val2);
  getRefArrayClassModel()->setObject(bananas, 2, apples);

  // num v2 = *((num*)getArrayClassModel()->get(bananas, 0));

  printf("_bannans[0]=%ld\n", *((num*)getRefArrayClassModel()->get(bananas, 0)));
  printf("_bannans[1]=%ld\n", *((num*)getRefArrayClassModel()->get(bananas, 1)));
  __onExit();
}

void tunmanaged(pointer name) {
  __onEnter();
  // t1 i32
  num a = Array_create_unmanaged(name, 9, _i8, 1);
  printf("tunmanaged\n");
  printf("length=%ld\n", getRefArrayClassModel()->length(a));
  printf("capacity=%ld\n", getRefArrayClassModel()->capacity(a));
  printf("type=%d\n", getRefArrayClassModel()->type(a));
  printf("typename=%s\n", getArrayClassModel()->typename(a));


  printf("unmanaged %s\n", getArrayClassModel()->array(a));
  printf("size %ld\n", getArrayClassModel()->memsize(a));
  __onExit();
}

int main() {

  char * name = "the name";
  
  ti8();
  tu16();
  ti32();
  tf64();
  tunmanaged(name);
  tString();
  __onFinalExit();
  return 0;
}
