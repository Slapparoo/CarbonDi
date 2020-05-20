

// the net result from the following 3 statements is the same
?content1 i8[10];
i8 content2[10];
?content3 = i8[10];

i8[] getNumbers(num howMany) {
    ?result i8[howMany];        
    return result;
}

i8[] getOtherNumbers() {
    ?result2 i8[10];        
    ?otherNos = result2;
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

?otherNumbers = numbers;
otherNumbers[0] = `S`;
printf(`Othernumbers %s\n`, otherNumbers.values );
testi64Equal(`otherNumbers`, 10, otherNumbers.length);

// ?secondArray = [1,2,3,4,5];
// printf(`secondArray 1 %ld\n`, secondArray[0]);

?moreNumbers = getNumbers(3);
testi64Equal(`moreNumbers`, 3, moreNumbers.length);


?someMoreNumbers = getOtherNumbers();
?anumber =  numbers[0];

?values = numbers.values;

String[2] names;
names[0] = "Some name";
names[1] = "Another name";

testStrEqual(`names[0]`, `Some name`, names[0].asStr());
testStrEqual(`names[1]`, `Another name`, names[1].asStr());
testStrEqual(`numbers`, `String\n`, numbers.values);
testStrEqual(`numbers`, `String\n`, values);




