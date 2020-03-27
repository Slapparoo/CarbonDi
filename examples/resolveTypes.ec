class MyClass {
    properties {
        num value;
        String name;
    }

    num someValue() {
        return 0x3;
    }
}

@c1 = MyClass(); 
@number = c1.someValue();
@myNumber = 10;
@myFloat = 10.2;
@myBool = true;

@s1 = String("My String");
s1.printTo(stdout);

c1.set_value(myNumber);
c1.set_name(s1);

@s2 = c1.get_name();

printf("s2\n"); 
s2.printTo(stdout);

printf("c1.value %ld, number %ld\n", c1.get_value(), number); 