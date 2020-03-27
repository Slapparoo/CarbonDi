namespace std.library ;


protected final class SimpleObject (Object) {
    (public, public) properties {
        (private, ) num count1;
        String package;
    }

    num length() {
        return 0b_111;
    }
}

// plan Comparable {
//     num compareTo(Comparable other);
// }

/*
plan Primative<T> {
    // (public, public) properties {
    //     T value;
    // }
}

public class Num is Comparable, Primative<num> {
#override     
    public num compareTo(Num other);
}
*/
public class AnotherSimpleClass (SimpleObject) is Comparable {
    (public, public) properties {
        String name;
    }

    // num compareTo(AnotherSimpleObject other) {
    //     return name - other.name;
    // };
}

class StillAnotherClass (AnotherSimpleClass) {
    // num compareTo(StillAnotherClass other) {
    //     return name - other.name;
    // };
}

void someFunction() {
    printf("someFunction.\n");    
}

i64 someFunction2() {
    num b = 10;
    num a = 5 + b;
    return 1 + 0b_1111 + a;
}

someFunction();

printf("Hello world %ld.\n", 0x_A0_FF + 0b_0001_0001);

String s1 = String_create("Hello EC");
SimpleObject simpleObject  = SimpleObject_create();

printf("Objects s1=%ld simpleObject=%ld.\n", s1, simpleObject);

AnotherSimpleClass_create();
StillAnotherClass_create();

s1.printTo(stdout);


num a = 10;
num b = someFunction2();

printf("numbers %ld %ld.\n", a, b);