protected class test.Class1 (Core.Object) {
    properties {
        i64 count1;
        i64 count2;
    }

    Class1(=count1) {}

    static i64 constNumber() {
        return 10;
    }
}

protected final class test.Class2 (test.Class1) {
    properties {
        String package;
    }

    Class2(=count1, =package) {}

    i64 length() {
        return 0b_111;
    }

    void myPrint() {
        printf(`(%s::%s) package=%s, count1=%ld, length=%ld, datasize=%ld\n`, 
            getClassPackage(), getClassName(), package.asStr(), count1, length(), getObjectDatasize());
    }

    i64 addto(i64 amount) {
        return amount + count1;
    }
}

?mySimpleObject = Class2(55);
mySimpleObject.package = "mySimpleObject";
mySimpleObject.myPrint();
mySimpleObject.package.asStr();

