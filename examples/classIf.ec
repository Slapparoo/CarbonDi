class ClassIf {
    properties {
        String name;
    }

    ClassIf(pointer str, boolean value) {
        if (value) {
            printf(`Str %s\n`, str);
            name = String(str);
        }
    }
}