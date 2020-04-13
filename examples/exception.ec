// namespace std.library ;

// imports {
//     extern_c 'stdio.h' ;
//     std.library;
// }

try {
    @a = 10;
} catch (exception) {
    stdout.print($a);
}

try {
    @a = 10;
} finally {
    stdout.print($a);
}


try {
    @a = 10;
} catch (exception1, exception2) {
    stdout.print($a);
} finally {
    stdout.print($a);
}

try {
    @a = 10;
} catch (exception1) {
    stdout.print($a);
} catch (exception1) {
    stdout.print($a);
} finally {
    stdout.print($a);
}

try {
    @a = 10;
} catch (exception1) {
    stdout.print($a);
} catch (exception1) {
    stdout.print($a);
}