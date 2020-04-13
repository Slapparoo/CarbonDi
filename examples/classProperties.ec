/**

The release method is called when an object is destroyed, this is where you would put
code to release and hardware, or resources which are "unmanaged".

*/
class MyClass {
    properties {
        i64 value = 0b_1111;
        String name;
    }

    MyClass(=value) {
        printf(`create %s %ld\n`, this.getClassName(), this.value);
    }

    void myPrint() {
        printf(`value=%ld, name=%s\n`, this.value, name.asStr());
    }

    void release() {
        printf(`release %s %ld\n`, this.getClassName(), this.value);
    }
}

class MySecondClass(MyClass) {
    MySecondClass(=value, =name) {
        printf(`create %s\n`, this.getClassName());
    }

    void release() {
        printf(`release (override) %s %ld\n`, this.getClassName(), this.value);
    }
}

class MyOtherClass {
    properties {
        MyClass myClass;
    }
}

String getAString() {
    return "the new name";
}

@c1 = MyClass();
c1.name = getAString();
c1.myPrint();
@mySecondClass = MySecondClass(100, "the name");
mySecondClass.myPrint();

// -------

@myOtherClass = MyOtherClass();

loop (10) {
    @myClass = MyClass();
    myClass.value = $a;
    myOtherClass.myClass = myClass;

    printf(`loop %ld.\n`, $a);
}
throwException(`its gome to shit.`);
printf(`After loop.\n`);

MyClass(55);
MySecondClass(56);

printf(`At end.\n`);


