namespace std.library ;

imports {
    extern_c 'stdio.h' ;
    std.library;
}

loop(1) {
    stdout.print($a);
}

loop(1) a {
    stdout.print(a);
}

loop(1..2) {
    stdout.print($a);
}

loop(2..1) {
    stdout.print($a);
}


loop(-1) {
    stdout.print($a);
}

loop(items) {
    stdout.print($a.name);
}

@sublist = (Item[])loop(items) {
    return.add($a);
};

@nameslist = (String[])loop(items) {
    return.add($a.name);
};

// this will need to return null if none found
@firstMatch = (String)loop(items) {
    if ($a.isValid) {
        return $a.name;
    }
};

// this will keep going while false or break on true
@hasMatch = (boolean)loop(items) {
    return $a.isValid;
};

if (hasMatch) {
    print('valid\n');
}


