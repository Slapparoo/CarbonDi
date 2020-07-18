
class MyException (Core.Exception) {}

try {
    int i = 0;
    printf(`Hello`);
} catch (Exception) {
    printf(`%s`, $a.message.asStr);
}

try {
    int i = 1;
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`1 %s\n`, `finally`);
}

printf(`in the gap\n`);

try {
    int i = 2;
    throw (MyException("MyException message"));
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`2 %s \n`, `finally`);
}


try {
    int i = 3;
    throw (Exception("Exception message"));
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`3 %s \n`, `finally`);
}


try {
    int i = 4;
    throw (Exception("Exception message"));
} catch (Exception, MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`4 %s \n`, `finally`);
}

try {
    int i = 5;
    throw (MyException("MyException message"));
} catch (Exception, MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`5 %s \n`, `finally`);
}

