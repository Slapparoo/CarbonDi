protected class Default.Encapsulation (Core.Object) {
    properties {
        i64 count1;
        i64 count2;
        static i64 count3 = 5;
    }

    Encapsulation(=count1, =count2);

    /**
    replace the setter method, the anonymouse variable $a 
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

    count3.get {
        return count3 + 5;
    }

    count1.onChange {
        printf(`count1 onChange new=%li, existing=%li\n`, $a, count1);
    }

    // not implemnted
    count3.onGet {
        printf(`count3 onGet =%li\n`, count3);
    }

    count3.validate {
        printf(`count3 validate %li\n`, count3);
    }

    void printMe() {
        printf(`count1=%li, count2=%li, count3=%li\n`, count1, count2, count3);
    }
}

?encapsulation = Encapsulation(100, 100);
encapsulation.printMe();

encapsulation.count1 = 77;

testi64Equal(`count1`, 77, encapsulation.count1);
testi64Equal(`count2`, 205, encapsulation.count2);  // 100 + 100 + 5
testi64Equal(`count3`, 10, encapsulation.count3);


