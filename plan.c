// Array
#include "types.h"

typedef struct Array0 {
  String a1;
  String a2;
} Array0;

String Array0_get_a1(Array0 this){
  return this.a1;
}

void Array0_set_a1(Array0 this, String a1){
  this.a1 = a1;
}

String Array0_get_a2(Array0 this){
  return this.a2;
}

void Array0_set_a2(Array0 this, String a2){
  this.a2 = a2;
}

