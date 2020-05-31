class MyClass {
    properties {
        num value;
        String name;
    }

    num someValue() {
        return 0x3;
    }
}

?c1 = MyClass(); 
?number = c1.someValue();
?myNumber = 10;
?myFloat = 10.2;
?myBool = true;

?s1 = String(`My String`);
