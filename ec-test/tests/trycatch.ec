
class MyException (Core.Exception) {}

try {
    int i = 0;
    External.stdin.printf(`Hello`);
} catch (Exception) {
    External.stdin.printf(`%s`, $a.message.asStr);
}

try {
    int i = 1;
} catch (Exception) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} finally {
    External.stdin.printf(`1 %s\n`, `finally`);
}

External.stdin.printf(`in the gap\n`);

try {
    int i = 2;
    throw(MyException("MyException message"));
} catch (Exception) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} finally {
    External.stdin.printf(`2 %s \n`, `finally`);
}


try {
    int i = 3;
    throw(Exception("Exception message"));
} catch (Exception) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} finally {
    External.stdin.printf(`3 %s \n`, `finally`);
}

try {
    int i = 4;
    throw(Exception("Exception message"));
} catch (Exception, MyException) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} finally {
    External.stdin.printf(`4 %s \n`, `finally`);
}

try {
    int i = 5;
    throw(MyException("MyException message"));
} catch (Exception, MyException) {
    External.stdin.printf(`catch %s\n`, $a.message.asStr);
} finally {
    External.stdin.printf(`5 %s \n`, `finally`);
}
