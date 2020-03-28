namespace std.library ;

@start = 5;
@end = 10;

// num ary1[20];
// zero based
loop(10) { printf("loop1 %ld\n", $a);}
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