class MyClass {
    properties {
        num value = 0b_1111;
        String name;
    }
    void printSomeStuff() {
        printf("Some Stuff\n");
    }
}

class MySecondClass(MyClass) {}

class MyOtherClass {
    properties {
        MyClass myClass;
    }
}

String getAString() {
    return String("the new name");
}

@c1 = MyClass();
c1.name = getAString();
c1.printSomeStuff();
@mySecondClass = MySecondClass();
c1.value = 0b_1010;
mySecondClass.value = c1.value;

printf("c1.value %ld\n", c1.value);
printf("mySecondClass.value %ld\n", mySecondClass.value);

@c2 = MyOtherClass();

c2.set_myClass(c1);

@c3 = c2.myClass;
@number = c1.value;
@number2 = c3.value;

// @number3 = c2.myClass.value;

@s1 = String("the name");
@s2 = getAString();
s2.printTo(stdout);
c1.name = s1;
@name = c1.name;

name.printTo(stdout);
c3.printTo(stdout);

printf("number %ld, %ld %s\n", number, number2, name.asStr());

