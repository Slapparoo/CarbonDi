
num[] getNumbers(num howMany) {
    // @TODO doesn't work
    i8[10] result;        
    return result;
}

num[] getOtherNumbers() {
    i8[10] result;        
    ?otherNos = result;
    return otherNos;
}

i8[10] numbers;

?anarray i8[10];
?anarray2 = i8[10];
numbers[0b_0] = `s`;
numbers[1] = `t`;
numbers[2] = `r`;
numbers[3] = `i`;
numbers[4] = `n`;
numbers[5] = `g`;
numbers[6] = `\n`;

// out of bounds check
// numbers[10] = `\n`;
// numbers[11] = `\n`;

try {
    numbers[10] = `\n`;
} catch (Exception) {
    printf(`Exception\n`) ;
    if ($a == 0) {
        printf(`Exception is null??? - this is bad\n`) ;
    } else {
        printf(`catch %s\n`, $a.message.asStr);
    }
}


?otherNumbers = numbers;
otherNumbers[0] = `S`;

// printf(`Othernumbers %s\n`, otherNumbers.values );

?moreNumbers = getNumbers(3);
?someMoreNumbers = getOtherNumbers();
?anumber =  numbers[0];

?values2 = numbers.values;

String[2] names;
names[0] = "Some name";
names[1] = "Another name";

testStrEqual(`names[0]`, `Some name`, names[0].asStr());
testStrEqual(`names[1]`, `Another name`, names[1].asStr());
testStrEqual(`numbers`, `String\n`, numbers.values);
testStrEqual(`numbers`, `String\n`, values2);




