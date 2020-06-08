
/**
All singing all dancing Dynamic array can be used as 
* stack
* queue
* list
* buffer
* lifo
* fifo

*/

debug_println(`start %s`, `here`);
// i8[10] numbers;
u64 n = 1;
i8 a = 50;
?myArray = DynamicArray(Boxing.i8_, n);
pointer myValue = EC_ADDRESS(a);

a++;

// myArray.addHead(myValue);

loop (100) {
    myArray.addHead = myValue;
    a++;
    debug_println(`loop %i`, a);
}

printf(`after addHead capacity=%lu\n`, myArray.capacity);

i8 b = 0;

loop (-100) {
    pointer b = myArray.removeHead();
    a++;
    debug_println(`remove loop %lu %i`, $a, External.core.EC_VALUE_i8(b));
}

printf(`after removehdead capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addTail = myValue;
    a++;
    debug_println(`loop %i`, a);
}

printf(`after addtail capacity=%lu\n`, myArray.capacity);

loop (-100) {
    pointer b = myArray.removeTail();
    a++;
    debug_println(`remove loop %lu %i`, $a, External.core.EC_VALUE_i8(b));
}

printf(`after remove tail capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addHead = myValue;
    a++;
    debug_println(`loop %i`, a);
}

printf(`after addHead capacity=%lu\n`, myArray.capacity);

loop (-100) {
    pointer b = myArray.removeTail();
    a++;
    debug_println(`remove loop %lu %i`, $a, External.core.EC_VALUE_i8(b));
}

printf(`after remove tail capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addHead = myValue;
    a++;
    debug_println(`loop %i`, a);
}

printf(`after addHead capacity=%lu\n`, myArray.capacity);


loop (-100) {
    pointer b = myArray.removeTail();
    a++;
    debug_println(`remove loop %lu %i`, $a, External.core.EC_VALUE_i8(b));
}

printf(`after remove tail capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addTail = myValue;
    a++;
    debug_println(`loop %i`, a);
}

printf(`after addTail capacity=%lu\n`, myArray.capacity);


loop (-100) {
    pointer b = myArray.removeHead();
    a++;
    debug_println(`remove loop %lu %i`, $a, External.core.EC_VALUE_i8(b));
}

printf(`after remove head capacity=%lu\n`, myArray.capacity);

loop (50) {
    myArray.addTail = myValue;
    a++;
}

loop (100) {
    myArray.addTail = myValue;
    pointer b = myArray.removeHead();
    a++;
}

printf(`after remove head capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addHead = myValue;
    pointer b = myArray.removeTail();
    a++;
}

printf(`after remove head capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addTail = myValue;
    pointer b = myArray.removeTail();
    a++;
}

printf(`after remove head capacity=%lu\n`, myArray.capacity);

loop (100) {
    myArray.addHead = myValue;
    pointer b = myArray.removeHead();
    a++;
}

printf(`after remove head capacity=%lu\n`, myArray.capacity);

loop (myArray) {
    printf(`loop=%p\n`, $a);
}
