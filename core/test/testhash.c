#include "types.h"


num hashCode(num ref) {
  return (ref * 0xff3ff3ff3ff3ff13) >> 3;
}


int main() {
    for (int i = 1; i < 100; i += 10) {
        printf("%d %ld %ld\n", i, hashCode(i), hashCode(i) % 10L);
    }

    for (int i = 1; i < 10; i += 1) {
        printf("%d %ld %ld\n", i, hashCode(i), hashCode(i) % 10L);
    }

}