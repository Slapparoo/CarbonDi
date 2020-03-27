#include "std.library.Array.h"
#include "std.library.Fruit.h"
#include "std.library.SomeFruit.h"

int main() {
  i64 banana = Fruit_create();
  i64 apple = Fruit_create();

  getFruitClassModel()->set_name(apple, String_create("Apple"));
  getStringClassModel()->printTo(getFruitClassModel()->get_name(apple), stdout);

  i64 someFruit = SomeFruit_create();

  getSomeFruitClassModel()->set_apple(someFruit, apple);
  getSomeFruitClassModel()->set_banana(someFruit, banana);
  getSomeFruitClassModel()->printTo(someFruit, stdout);

  getFruitClassModel()->printTo(banana, stdout);

  returnObject(banana);
  i64 n = getFruitClassModel()->get_name(apple);
  returnObject(n);

  returnObject(apple);
  returnObject(someFruit);

  return 0;
}
