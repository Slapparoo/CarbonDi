
class MyException (Core.Exception) {}

try {
    int i = 0;
    printf(`Hello\n`);
} catch (Exception) {
    printf(`%s`, $a.message.asStr);
}

try {
    int i = 1;
    printf(`Hello 1 no exception -> finally\n`);
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`1 %s\n`, `finally`);
}

try {
    int i = 2;
    printf(`Hello 2 throw MyException -> finally\n`);
    throw(MyException("MyException message"));
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`2 %s \n`, `finally`);
}


try {
    int i = 3;
    printf(`Hello 3 throw Exception -> finally\n`);
    throw(Exception("Exception message"));
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
} catch (MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`3 %s \n`, `finally`);
}

try {
    int i = 4;
    printf(`Hello 4 throw Exception -> finally\n`);
    throw(Exception("Exception message"));
} catch (Exception, MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`4 %s \n`, `finally`);
}

try {
    int i = 5;
    printf(`Hello 5 throw MyException -> finally\n`);
    throw(MyException("MyException message"));
} catch (Exception, MyException) {
    printf(`catch %s\n`, $a.message.asStr);
} finally {
    printf(`5 %s \n`, `finally`);
}

try {
    int i = 6;
    printf(`Hello 6 throw MyException\n`);
    throw(MyException("MyException message"));
} catch (Exception, MyException) {
    printf(`catch %s\n`, $a.message.asStr);
}

/*

to resolve this have 
* just one exception type which internally stores the subtype
* an unconditional finally block that always catch (an maybe rethrows)
  * a switch statement to handle sub types
  * insert any declared finally
  * somehow manage catch rethrows and secondary exceptions
  * maybe use labels and jmps

*/


// this is where the 1st error is exceptions arn't inheritied
try {
    int i = 7;
    printf(`Hello 7 throw MyException catch Exception\n`);
    throw(MyException("MyException message"));
} catch (Exception) {
    printf(`catch %s\n`, $a.message.asStr);
}


// this is where the 2nd error is finally inn't called if no catch
try {
    int i = 8;
    printf(`Hello 8 throw MyException no catch but finally\n`);
    throw(MyException("MyException message"));
} finally {
    printf(`8 %s \n`, `finally`);
}

printf(`end\n`);
