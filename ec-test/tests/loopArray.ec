i8[10] numbers;

numbers[0b_0] = `s`;
numbers[1] = `t`;
numbers[2] = `r`;
numbers[3] = `i`;
numbers[4] = `n`;
numbers[5] = `g`;
numbers[6] = `\n`;

printf(`numbers %s`, numbers.values);
u64 len = External.stdio.strlen(numbers.values);
testi64Equal(`numbers length 1`, 7, len);


loop (numbers) {
    if ($a > 20) {
        printf(`loop %u %c\n`, $a, $a);
    }
    $a = 0;
}

printf(`numbers %s\n`, numbers.values);

u64 len2 = External.stdio.strlen(numbers.values);
testi64Equal(`numbers length 2`, 0, len2);

printf(`numbers %u\n`, numbers.capacity);
printf(`numbers %s\n`, numbers.typename);
// printf(`numbers %s\n`, numbers.class);


