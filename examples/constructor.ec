

class MyString {
    properties {
        (, private)pointer value;
    }

    /**
    * DefaULT
    */
    MyString(=value) {
        num len = strlen(value) + 1;
        this.value = alloc(len);
        strcpy(this.value, value);
    }

    /**
    * String Concatenation
    */
    MyString(=value, pointer str2) {
        num len = strlen(value) + strlen(str2) + 1;
        this.value = alloc(len);
        strcpy(this.value, value);
        strcat(this.value, str2);
    }

    private MyString();

    pointer asStr() {
        return value;
    }

    String asString() {
        return this;
    }
}

@str1 = MyString(`Str1`);
@str2 = MyString(`Str1\"`, ` str2`);

printf(`%s, %s\n`, str1.asStr(), str2.asStr());
