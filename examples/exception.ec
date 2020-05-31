// namespace std.library ;

// imports {
//     extern_c 'stdio.h' ;
//     std.library;
// }

try {
    ?a = 10;
} catch (exception) {
    External.stdio.printf(`%s`, $a);
}

try {
    ?a = 10;
} finally {
    External.stdio.printf(`%s`, $a);
}


try {
    ?a = 10;
} catch (exception1, exception2) {
    External.stdio.printf(`%s`, $a);
} finally {
    External.stdio.printf(`%li`, a);
}

try {
    ?a = 10;
} catch (exception1) {
    External.stdio.printf(`%s`, $a);
} catch (exception1) {
    External.stdio.printf(`%s`, $a);
} finally {
    External.stdio.printf(`%li`, a);
}

try {
    ?a = 10;
} catch (exception1) {
    External.stdio.printf(`%s`, $a);
} catch (exception1) {
    External.stdio.printf(`%s`, $a);
}