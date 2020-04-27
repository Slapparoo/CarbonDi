protected class Default.SimpleObject1 (Core.Object) {
    properties {
        i64 count1;
        i64 count2;
    }

    SimpleObject1(=count1) {}

    static i64 constNumber() {
        return 10;
    }
}

protected final class Default.SimpleObject (Default.SimpleObject1) {
    properties {
        String package;
    }

    SimpleObject(=count1, =package) {}

    void myPrint() {
        printf(`(%s::%s) package=%s, count1=%ld, length=%ld, datasize=%ld\n`, 
            getClassPackage(), getClassName(), package.asStr(), count1, length(), getObjectDatasize());
    }

    i64 length() {
        // nonvar = 10;
        return 0b_111;
    }

    i64 addto(i64 amount) {
        return amount + count1;
    }
}

?mySimpleObject = SimpleObject(55);
mySimpleObject.package = "mySimpleObject";
mySimpleObject.myPrint();

// mySimpleObject;
mySimpleObject.package;
mySimpleObject.package.asStr();
mySimpleObject.package.asString().asStr();

printf(`mySimpleObject.package.asString().asStr() %s\n`, mySimpleObject.package.asString().asStr());
testStrEqual(`mySimpleObject.package.asString().asStr()`, mySimpleObject.package.asString().asStr(), `mySimpleObject`);

// @simpleObject = SimpleObject(23489, "Simple String Init");
// simpleObject.myPrint();

// testi64Equal(`SimpleObject1.constNumber()`, 10, SimpleObject1.constNumber());
// testi64Equal(`simpleObject.count1`, 23489, simpleObject.count1);
// testi64Equal(`mySimpleObject.count1`, 55, mySimpleObject.count1);

// testStrEqual(`mySimpleObject.package`, mySimpleObject.package.asStr(), `mySimpleObject`);


// simpleObject.count1 = 0x_01;
// @count = 4 + simpleObject.addto(5);
// simpleObject.count1 = 10 + simpleObject.addto(5) + count;

// @aNum = simpleObject.constNumber();

// simpleObject.myPrint();

