public class Default.MyString (Core.Object) {
    (public, private)properties {
        (public, private) pointer value;
    }
    /**
    * DefaULT
    */
    public MyString(pointer str) {
        i64 len = strlen(str) + 1;
        value = alloc(len);
        strcpy(value, str);
    }

    /**
    * for strings which are defined in code c will statically allocate
    * the memory for them
    */
    public MyString(pointer str, boolean staticAlloc) {
        if (staticAlloc) {
            value = str;
        } else {
            i64 len = strlen(str) + 1;
            this.value = alloc(len);
            strcpy(value, str);
        }
    }

    /**
    * String Concatenation
    */
    public MyString(pointer str, pointer str2) {
        i64 len = strlen(str) + strlen(str2) + 1;
        value = alloc(len);
        strcpy(value, str);
        strcat(value, str2);
    }

    private MyString();

    public pointer asStr() {
        return value;
    }

    public MyString asString() {
        return this;
    }

    public u64 length() {
      return strlen(value);
    }

    public void println() {
        printf(`%s\n`, asStr());
    }

    public MyString appendStr(pointer str) {
        // i64 len = 0;
        i64 len = strlen(value) + strlen(str) + 1;
        value = realloc(value, len);
        strcat(value, str);

        return this;
    }

    public MyString append(String string) {
        appendStr(string.asStr());
        return this;
    }

    public MyString prependStr(pointer str4) {
        i64 len = strlen(value) + strlen(str4) + 1;
        value = realloc(value, len);
        memmove(EC_ADDRESS(EC_ARRAY(value, strlen(str4))), value, strlen(value) +1);
        memcpy(value, str4, strlen(str4));

        return this;
    }

    public MyString prepend(String string1) {
        prependStr(string1.asStr());

        return this;
    }

    public i64 compareStr(pointer str5) {
        i64 res = strcmp(value, str5);
        return res;
    }

    public i64 compare(String string5) {
        i64 res = strcmp(value, string5.asStr());
        return res;
    }

    public i64 findStr(i64 from, pointer str6) {
        pointer p = strstr(EC_ADDRESS(EC_ARRAY(value, from)), str6);

        if (p == null) {
            return -1;
        }
        i64 res = p - value;

        return res;
    }

    public i64 find(i64 from, String string6) {
        return findStr(from, string6.asStr());
    }

    /**
    Array with the offsets of all instances of the sub strings
    */
    // public i64[] findAll(pointer str7) {
    //     u64 capacity = 64;
    //     int datatype = 10;
    //     u64 datasize = 64;
    //     DynamicArray offsets = DynamicArray(capacity, datatype, datasize);

    //     i64 offset = findStr(0, str7);

    //     loop (offset > 0) {
    //         offsets.addHead(EC_ADDRESS(offset));
    //         offset = findStr(offset + 1, str7);
    //     }

    //     return offsets;
    // }

    public void trunc(i64 start, i64 end) {
        i64 len = strlen(value);
        if (start < 0) {
            throwException(`[string trunc] start is less than zero.`);
        }

        if (end < start) {
            throwException(`[string trunc] end is less than start.`);
        }

        if (start > len) {
            throwException(`[string trunc] start is after length of string.`);
        }

        if (end > len) {
            throwException(`[string trunc] end after length of string.`);
        }

        i64 newLen = end - start;
        memmove(value, EC_ADDRESS(EC_ARRAY(value, start)), newLen);
        value = realloc(value, newLen+1);
        EC_SETVALUE_i8(newLen, value, 0);
    }
}

?myString = MyString(`My String 1`, false);
myString.println();
myString.appendStr(`My String 2`);
myString.println();
myString.prependStr(`My String 3`);
myString.println();
myString.append("My String 4");
myString.println();
myString.prepend("My String 5");
myString.println();

i64 offset = myString.findStr(0, `String`);
i64 offset1 = myString.findStr(10, `String`);
i64 offset2 = myString.findStr(0, `My String 22`);
printf(`offset %li %li %li\n`, offset, offset1, offset2);

i64 offset3 = myString.find(0, "String");
i64 offset4 = myString.find(10, "String");
i64 offset5 = myString.find(0, "My String 22");
printf(`offset %li %li %li\n`, offset3, offset4, offset5);

?no64 = I64(64);
// printf(`no64 %s\n`, no64.asStr());

myString.append(" ");
myString.appendStr(no64.asStr());
myString.println();

myString.trunc(3, 9);
myString.println();

i64 cmp1 = myString.compareStr(`String`);
i64 cmp2 = myString.compareStr(`My String`);

printf(`cmp1 %li, cmp2 %li\n`, cmp1, cmp2);

i64 cmp3 = myString.compare("String");
i64 cmp4 = myString.compare("My String");

printf(`cmp3 %li, cmp4 %li\n`, cmp3, cmp4);