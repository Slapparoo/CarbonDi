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
    External.stdio.printf(`always (good)\n`);
} else {
    External.stdio.printf(`always (bad)\n`);
}

if (sometimes || always) {
    External.stdio.printf(`sometimes (good) \n`);
} else {
    External.stdio.printf(`sometimes (bad)\n`);
}

if (never) {
    External.stdio.printf(`never (bad)\n`);
} else {
    External.stdio.printf(`never (good)\n`);
}

if (isTrue()) {
    External.stdio.printf(`tis true (good)\n`);
} else {
    External.stdio.printf(`tis true (bad)\n`);
}

if (isFalse()) {
    External.stdio.printf(`tis false (bad)\n`);
} else {
    External.stdio.printf(`tis false (good)\n`);
}

if (isTrue() && true) {
    External.stdio.printf(`tis true to (good)\n`);
} else {
    External.stdio.printf(`tis true to (bad)\n`);
}

if (isTrue() && false) {
    External.stdio.printf(`tis false to (bad)\n`);
} else {
    External.stdio.printf(`tis false to (good)\n`);
}


if (!isTrue()) {
    External.stdio.printf(`if else !true (bad)\n`);
} else if (isFalse()) {
    External.stdio.printf(`if else false (bad)\n`);
} else {
    External.stdio.printf(`if else (good)\n`);
}


External.stdio.printf(`end\n`);