#include "stdio.h"


/**
 * full duplication
 */
typedef struct Class_a {
    int val_a;
    int val_b;
} Class_a;

typedef struct Class_b {
    int val_a;
    int val_b;
    int val_c;
    int val_d;
} Class_b;

union Class_ab {
    Class_b a;
    Class_a b;
};

int main() {
    Class_a class_a = {1, 2};
    Class_ab class_b = {1, 2, 3, 4};
    printf("hello. a %d %d \n", class_a.val_a, class_a.val_b);
    // printf("hello. b %d %d \n", class_b.val_a, class_b.val_b);
    printf("hello. b %d %d %d %d\n", ((Class_ab)class_b)a.val_a, class_b.val_b, class_b.val_c, class_b.val_d);
    return 0;
}