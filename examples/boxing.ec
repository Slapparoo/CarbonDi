
// primative
@unboxed = 0x1_100_100;

// object
@boxed1 = I64(unboxed);

// primative
@unboxed1 = boxed1.value();

// object
@boxed2 = boxed1;

// primative
@unboxed2 = boxed2.value();
i64 unboxed3 = boxed2.value();

// object
I64 boxed3 = I64(0b_1111_0001);

printf("\n%s, %li, %li, %li\n", boxed1.asStr(), unboxed1, unboxed2, boxed3.value()) ;

// object
@str1 = String( boxed1.asStr());
printf("\n%s\n\n", str1.asStr()) ;

@numbers Object[6];
numbers[5] = String("value");

loop (5) {
    numbers[$a] = I64($a);
}

loop (6) {
    @b = numbers[$a];
    printf("%s\n", b.asStr()) ;
}

@str2 = "String 2";