

class Default.MyString (Core.Object) {
    properties {
        (, private)pointer value;
    }

    /**
    * Default
    */
    MyString(pointer str1) {
        num len = External.stdio.strlen(str1) + 1;
        this.value = alloc(len);
        External.stdio.strcpy(value, str1);
    }

    /**
    * String Concatenation
    */
    MyString(pointer str2, pointer str3) {
        num len2 = External.stdio.strlen(str2) + External.stdio.strlen(str3) + 1;
        value = alloc(len2);
        External.stdio.strcpy(value, str2);
        External.stdio.strcat(value, str3);
    }

    private MyString();

    pointer asStr() {
        return value;
    }

    String asString() {
        return this;
    }
}

?stra = MyString(`Str1`);
?strb = MyString(`Str2a\"`, ` str2b`);

printf(`%s, %s\n`, stra.asStr(), strb.asStr());

?expected = `Str2a\" str2b`;

testStrEqual(`stra`, `Str1`, stra.asStr());
testStrEqual(`strb`, expected, strb.asStr());
