

public class Core.StringBuilder (Core.Object) {
    properties {
        (private, private) DynamicArray buffer = DynamicArray(Boxing.i8_, 1);
    }

    public StringBuilder() {};

    void addString(String value) {
        addStr(value.asStr);
    }

    void addStr(pointer value) {
        int length = External.stdio.strlen(value);

        loop (length) {
            buffer.addTail($a);
        }
    }

    pointer asStr() {
        return buffer.values;
    }

    String asString() {
        return String(buffer.values);
    }
}

?stringBuilder = StringBuilder();

stringBuilder.addStr(`String 1`);
stringBuilder.addString("String 2");

External.stdio.println(`%s`, stringBuilder.asStr);

