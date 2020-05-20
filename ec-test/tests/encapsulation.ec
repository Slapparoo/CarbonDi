protected class Default.Encapsulation (Core.Object) {
    properties {
        i64 count1;
        i64 count2;
    }

    Encapsulation(=count1, =count2);

    /**
    replace the setter method, the anonymous variable $a 
    is the new pased in value. 

    $a is the type of the property
    */
    count2.set {
        count2 = $a + count1;
    }

    /**
    replace the getter method, the getter must have a return, and must return
    the property's type.
    */
    count2.get {
        return count2 + 5;
    }

    /**
    as the function has no params and returns a value it gets
    treated as a readonly property.
    */
    i64 count3() {
        return count2 + count2;
    }

    void printMe() {
        printf(`count1=%li, count2=%li, count3=%li`, count1, count2, count3);
        // printf(`count1=%li`, count1);

    }
}

?encapsulation = Encapsulation(100, 100);
encapsulation.printMe();

External.stdio.testi64Equal(`count1`, 100, encapsulation.count1);
External.stdio.testi64Equal(`count2`, 205, encapsulation.count2);
External.stdio.testi64Equal(`count3`, 410, encapsulation.count3);


