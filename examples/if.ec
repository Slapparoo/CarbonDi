?always = true;
?never = false;
?sometimes = 10;
?sometimesfloat = 10.10;


boolean isTrue() {
    return true;
}

boolean isFalse() {
    return false;
}

if (always) {
    printf(`always (good)\n`);
} else {
    printf(`always (bad)\n`);
}

if (sometimes || always) {
    printf(`sometimes (good) \n`);
} else {
    printf(`sometimes (bad)\n`);
}

if (never) {
    printf(`never (bad)\n`);
} else {
    printf(`never (good)\n`);
}

if (isTrue()) {
    printf(`tis true (good)\n`);
} else {
    printf(`tis true (bad)\n`);
}

if (isFalse()) {
    printf(`tis false (bad)\n`);
} else {
    printf(`tis false (good)\n`);
}

if (isTrue() && true) {
    printf(`tis true to (good)\n`);
} else {
    printf(`tis true to (bad)\n`);
}

if (isTrue() && false) {
    printf(`tis false to (bad)\n`);
} else {
    printf(`tis false to (good)\n`);
}


if (!isTrue()) {
    printf(`if else !true (bad)\n`);
} else if (isFalse()) {
    printf(`if else false (bad)\n`);
} else {
    printf(`if else (good)\n`);
}


printf(`%s\n`,`end`);