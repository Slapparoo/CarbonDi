

class Default.MyString (Core.Object) {
    properties {
        (, private)pointer value;
    }

    /**
    * Default
    */
    MyString(pointer str1) {
        num len = strlen(str1) + 1;
        this.value = alloc(len);
        strcpy(value, str1);
    }

    /**
    * String Concatenation
    */
    MyString(pointer str2, pointer str3) {
        num len2 = strlen(str2) + strlen(str3) + 1;
        value = alloc(len2);
        strcpy(value, str2);
        strcat(value, str3);
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

testStrEqual(`stra`, `Str1`, stra.asStr());
testStrEqual(`strb`, `Str2a\" str2b`, strb.asStr());

// @str1 = MyString(`Str1`);
// @str2 = MyString(`Str2a\"`, ` str2b`);
// @strc = MyString(`Str2a\"`, ` str2b`).asStr();
