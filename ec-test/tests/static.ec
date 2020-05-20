protected class Default.SimpleObject (Core.Object) {
    properties {
        i64 count1 = 12;
        static i64 count2 = 51;
        i64 count3 = 27;
    }

    SimpleObject(=count1) {}

    static i64 constNumber() {
        return 66;
    }
}

?simpleObject = SimpleObject(11);
External.stdio.printf(`count1(11)=%li, count2(51)=%li, count3(27)=%li, constNumber(66)=%li\n`, simpleObject.count1, simpleObject.count2, simpleObject.count3, SimpleObject.constNumber());

External.core.testi64Equal(`simpleObject.count1 1`, 11, simpleObject.count1);
External.core.testi64Equal(`simpleObject.count2 1`, 51, simpleObject.count2);
External.core.testi64Equal(`simpleObject.count3 1`, 27, simpleObject.count3);
External.core.testi64Equal(`simpleObject.constNumber() 1`, 66, simpleObject.constNumber());
External.core.testi64Equal(`simpleObject.constNumber() 1`, 66, SimpleObject.constNumber());

simpleObject.count1 = 99;
SimpleObject.count2 = 33;

External.stdio.printf(`count1(99)=%li, count2(33)=%li, count3(33)=%li, constNumber(66)=%li\n`, simpleObject.count1, simpleObject.count2, simpleObject.count3, SimpleObject.constNumber());

External.core.testi64Equal(`simpleObject.count1 2`, 99, simpleObject.count1);
External.core.testi64Equal(`simpleObject.count2 2`, 33, simpleObject.count2);
External.core.testi64Equal(`simpleObject.count3 2`, 27, simpleObject.count3);
External.core.testi64Equal(`simpleObject.constNumber() 2`, 66, simpleObject.constNumber());


External.core.testi64Equal(`SimpleObject.count2 3`, 33, SimpleObject.count2);
External.core.testi64Equal(`SimpleObject.constNumber() 3`, 66, SimpleObject.constNumber());
