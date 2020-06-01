

class PlusEquals (Object) {
    properties {
        i64 value = 10;
    }

    void plus(i64 addVal) {
        value += addVal;
    }
}

?plusequals = PlusEquals();

plusequals.plus(5);

printf(`%li\n`, plusequals.value);