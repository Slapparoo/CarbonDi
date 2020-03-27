

class MyClass {
    properties {
        num value;
        String name;
    }

    num someValue() {
        return 0x3;
    }
}

MyClass c1 = MyClass_create(); 
@number = c1.someValue();
c1.set_value(number);
String name = String_create("ma name");
c1.set_name(name);
c1.printTo(stdout);

printf("c1.value %ld\n", c1.get_value());

name.printTo(stdout);