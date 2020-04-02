
num[] getNumbers(num howMany) {
    i8[10] result;        
    return result;
}

num[] getOtherNumbers() {
    i8[10] result;        
    @otherNos = result;
    return otherNos;
}



i8[10] numbers;

@anarray i8[10];
@anarray2 = i8[10];
// numbers[0] = 'S';
// numbers[1] = 't';
// numbers[2] = 'r';
// numbers[3] = 'i';
// numbers[4] = 'n';
// numbers[5] = 'g';
// numbers[6] = 0;

@otherNumbers = numbers;
otherNumbers[0] = 'S';

@moreNumbers = getNumbers(3);
@someMoreNumbers = getOtherNumbers();

// @anumber =  numbers[0];
// printf("numbers=%s \n", numbers.array());

// loop(6) {
//     printf("numbers[%ld]=%c \n", $a, numbers[$a]);
// }

// String[2] names;
// names[0] = String("Some name");
// names[1] = String("Another name");
// @aname = names[1];

// printf("%s %d\n", aname.asStr(), anumber);

