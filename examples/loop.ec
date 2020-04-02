//namespace std.library ;

@myArray i8[10];
loop(myArray.length() - 1) { 
   myArray[$a] = 'a' + $a;
   printf("%c, %d, %ld\n", myArray[$a], myArray[$a], $a);
}
printf("%s\n", myArray.array());

// reverse order
loop((myArray.length() - 1) * -1) { 
   myArray[$a] = 'i' - $a;
   printf("%2c, %4d, %4ld \n", myArray[$a], myArray[$a], $a);
}
printf("%s\n", myArray.array());


@start = 5;
@end = 10;

i8 justReturn(i8 param) {
   return param;
}

myArray[0] = 'a';

loop(9) { 
   myArray[$a] = 'c' + $a;
   printf("%c, %d, %d\n", justReturn(myArray[$a]), myArray[$a], justReturn(myArray[$a]) ) ;
}

printf("%s\n", myArray.array());

@myArray2 = myArray;
printf("%s\n", myArray2.array());

loop(end) { printf("loop4 %ld\n", $a);}
loop(-5) { 
   printf("loop5 %ld\n", $a); 
   break;
}

// range inclusive
loop(1..2) { printf("loop2 %ld\n", $a);}
loop(2..1) { printf("loop2a %ld\n", $a);}
loop(start..end) { printf("loop3 %ld\n", $a);}
loop(end..start) { printf("loop3a %ld\n", $a);}

printf("hashcode %ld\n", myArray.hashCode());
printf("equals %d\n", myArray.equals(myArray2));
printf("equals %d\n", myArray.equals(100));



// @sum = (num)loop(10) {
//    $b += $a; 
//    printf("loop6 %ld\n", $a);
// };

// @sum = (num)loop(10) {
//    $return.add($a); 
//    printf("loop6 %ld\n", $a);
// };

// @sum = 0;
// loop(10) {
//    sum += $a; 
//    printf("loop6 %ld\n", $a);
// };


// array
// loop(items) {
//     stdout.print($a.name);
// }

// @sublist = (Item[])loop(items) {
// //    $return.add($a);
// };

// @nameslist = (String[])loop(items) {
//     return.add($a.name);
// };

// // this will need to return null if none found
// @firstMatch = (String)loop(items) {
//     if ($a.isValid) {
//         return $a.name;
//     }
//     if ($a.isValid > 0) {
//         return $a.name;
//     }
// };

// // this will keep going while false or break on true
// @hasMatch = (boolean)loop(items) {
//     return $a.isValid;
// };

// if (hasMatch) {
//     print('valid\n');
// }

// {
//     @a[] = 10 * (i + 4);
// }

// {
//     num b = 10 * (i + 4);
// }
// {
//     return 2;
//     if (1) { 
//         return res;
//     }
    
// }

// void method(i64 param1) {
//     return param1;
// }

// num[] x; 
// num[1] x; 
// pastries[] x; 
// pastries[1] x; 
// num i = 2 + 2;

