@always = true;
@never = false;
@sometimes = 10;
@sometimesfloat = 10.10;


boolean isTrue() {
    return true;
}

boolean isFalse() {
    return false;
}


if (always) {
    printf(`always\n`);
}

if (sometimes || always) {
    printf(`sometimes\n`);
}

if (never) {
    printf(`never\n`);
}

if (isTrue()) {
    printf(`tis true\n`);
}

if (isFalse()) {
    printf(`tis false\n`);
}

if (isTrue() && true) {
    printf(`tis true to\n`);
}

if (isTrue() && false) {
    printf(`tis true to\n`);
} else {
    printf(`tis false to\n`);
}


if (!isTrue()) {
    printf(`if else !true\n`);
} else if (isFalse()) {
    printf(`if else false\n`);
} else {
    printf(`if else\n`);
}


printf(`end\n`);