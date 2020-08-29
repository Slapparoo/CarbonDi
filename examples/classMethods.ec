class Default.MyClass {
    properties {
        num value;
        String name;
    }

    int someValue() {
        return 0x3;
    }

    void myPrint() {
        printf(`value=%li, name=%s, someValue=%i\n`, value, name.asStr(), someValue());
        // printf(`someValue=%i\n`, someValue());

    }
}

class Default.MySecondClass(Default.MyClass) {
    int someValue() {
        return 0x4;
    }
}

?c1 = MyClass(); 
?number = c1.someValue();
c1.value = number;
c1.name = "ma_name";
c1.myPrint();

// ?c2 = MySecondClass(); 
// c2.value = 2;
// c2.name = "c1_name";
// c2.myPrint();



