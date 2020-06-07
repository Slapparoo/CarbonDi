/**

The release method is called when an object is destroyed, this is where you would put
code to release and hardware, or resources which are "unmanaged".

*/
class Default.MyClass (Core.Object) {
    properties {
        String name;
        i64 value = 0b_1111;
        i64 value2 = 0b_1111;
        
    }
    MyClass(=value) {
        printf(`create %s %ld\n`, className, value);
    }
    void myPrint() {
        // printf(`value=, name=%s\n`, name.asStr());
        printf(`value=%ld, name=%s\n`, value, name.asStr());
    }
    void release() {
        printf(`release %s %ld\n`, className, value);
    }
}

class Default.MySecondClass(Default.MyClass) {
    MySecondClass(=value, =name) {
        printf(`create %s\n`, className);
    }

    void release() {
        printf(`release (override) %s %ld\n`, className, value);
    }
}

class Default.MyOtherClass {
    properties {
        MyClass myClass;
    }
}

String getAString() {
    return "the new name";
}

?c1 = MyClass();
c1.name = getAString();
c1.myPrint();
?mySecondClass = MySecondClass(100, "the name");
mySecondClass.myPrint();

// // -------

?myOtherClass = MyOtherClass();

loop (10) {
    ?myClass = MyClass();
    myClass.value = $a;
    myOtherClass.myClass = myClass;

    printf(`loop %ld.\n`, $a);
}
// throwException(`its gome to shit.`);
// printf(`After loop.\n`);

// MyClass(55);
// MySecondClass(56);

// printf(`At end.\n`);


