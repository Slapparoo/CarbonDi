
// primative
?unboxed = 0x1_100_100;

// object
?boxed1 = I64(unboxed);

// primative
?unboxed1 = boxed1.value;

// object
?boxed2 = boxed1;

// primative
?unboxed2 = boxed2.value;
i64 unboxed3 = boxed2.value;

// object
I64 boxed3 = I64(0b_1111_0001);

printf(`\n%s, %li, %li, %li\n`, boxed1.asStr, unboxed1, unboxed2, boxed3.value) ;

// object

?str1 = String( boxed1.asStr);
?str2 = String(`String2`);
?str3 = "String3";
printf(`\n%s\n%s\n%s\n`, str1.asStr, str2.asStr, str3.asStr) ;

testStrEqual(`str1`, `17826048`, str1.asStr);
testStrEqual(`boxed1`, `17826048`, boxed1.asStr);
testStrEqual(`boxed1.typename`, `i64`, boxed1.typename);
testi64Equal(`boxed1.datatype`, 9, boxed1.datatype);
testi64Equal(`boxed1.value`, 17826048, boxed1.value);

boxed1.value = 0b_1111_0011;
testi64Equal(`boxed1.value`, 0b_1111_0011, boxed1.value);