class MyString {
    properties {
        (, private)pointer value;
    }

    /**
    * DefaULT
    */
    MyString(pointer str1) {
        num len = strlen(str1) + 1;
        value = alloc(len);
        strcpy(value, str1);
    }

    /**
    * String Concatenation
    */
    MyString(pointer str1, pointer str2) {
        num len = strlen(str1) + strlen(str2) + 1;
        value = alloc(len);
        strcpy(value, str1);
        strcat(value, str2);
    }

    private MyString();

    pointer asStr() {
        return value;
    }

    String asString() {
        return this;
    }
}

// num testStrEqual(pointer a, pointer b, pointer c);

?stra = MyString(`Str1`);
?strb = MyString(`Str2a\"`, ` str2b`);

printf(`%s, %s\n`, stra.asStr(), strb.asStr());

testStrEqual(`stra`, `Str1`, stra.asStr());
testStrEqual(`strb`, `Str2a\" str2b`, strb.asStr());

// ?str1 = MyString(`Str1`);
// ?str2 = MyString(`Str2a\"`, ` str2b`);
// ?strc = MyString(`Str2a\"`, ` str2b`).asStr();


// testStrEqual(`stra`, `Str1`, str1.asStr());
// testStrEqual(`strb`, `Str2a\" str2b`, str2.asStr());
