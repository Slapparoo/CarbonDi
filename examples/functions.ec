

String getName(String value) {
    return value;
}

String getAName() {
    return String("A name");
}

void printName(String value) {
    printf("name=%s", value.asStr());
}

@name2 = getAName();

loop (10) {
    @name = getName(String("Ma Name"));
    printf("l=%ld ", $a);
    printName(name);
}

printName(name2);

