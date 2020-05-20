
/**
All singing all dancing Dynamic array can be used as 
* stack
* queue
* list
* buffer
* lifo
* fifo

*/

public class Default.NewDynamicArray (Core.Array){
    (public,public) properties {
        u64 startIndex;
        u64 endIndex;

        static u64 initialSize = 8;
        static u64 growBy = 8;
        static u64 slideAmount = 4;
    }

    public NewDynamicArray(=dataType, =dataSize) {
        capacity = initialSize;
        values = alloc(capacity * dataSize);
        startIndex = initialSize /2;
        endIndex = startIndex;
        length = 0;
    }

    public void size(u64 newszie) {
        // resize
    }

    public pointer getValue(u64 index) {
        debug_println(`add %s`, `here`);
        if (index >= capacity) {
            throwException(`[error] index array out of bounds`);
        }
        return get(index);
    }

    public void setValue(u64 index, pointer value) {
        debug_println(`add %lu, %lu`, index, capacity);
        if (index >= capacity) {
            throwException(`[error] index array out of bounds`);
        }
        set(index, value);
    }

    public void addTail(pointer value) {
        debug_println(`add %s`, `here`);
        if (endIndex == capacity) {
            if (startIndex > slideAmount) {
                slideLeft();
            } else {
                addCapacityTail();
            }
        }
        length++;
        setValue(endIndex++, value);
    }

    public void addHead(pointer value) {
        debug_println(`add %s`, `here`);
        if (startIndex == 0) {
            if (endIndex < capacity - slideAmount) {
                slideRight();
            } else {
                addCapacityHead();
            }
        }
        length++;
        setValue(--startIndex, value);
    }

    public void insert(u64 index, pointer value) {
        debug_println(`insert %lu`, index);
        if (index > length) {
            throwException(`[error] index array out of bounds`);
        }

        if (index == startIndex) {
            addHead(value);
            return;
        }

        if (index == endIndex) {
            addTail(value);
            return;
        }

        // move left or move right
        if (index - startIndex > endIndex - index) {
            // closer to the end
            // check capacity   
            if (endIndex + 1 == capacity) {
                addCapacityTail();
            }         
            
            // move tail
            // dest, source, size
            endIndex++;
            u64 ix = index + 1;
            memmove(EC_ADDRESS(EC_ARRAY(ix, values)), EC_ADDRESS(EC_ARRAY(index, values)), (endIndex - index) * dataSize); 
        } else {
            // move head
            if (startIndex == 0) {
                addCapacityHead();
            }
            startIndex--;
            u64 ix = startIndex + 1;
            memmove(EC_ADDRESS(EC_ARRAY(startIndex, values)), EC_ADDRESS(EC_ARRAY(ix, values)), (index - startIndex) * dataSize); 
        }
        length++;
        set(index, value);
    }

    public pointer removeHead() {
        debug_println(`remove %lu`, startIndex);
        if (length == 0) {
            throwException(`[error] index array out of bounds`);
        }
        if (startIndex >= endIndex) {
            throwException(`[error] index array out of bounds index overlap.`);
        }

        if (capacity - length > growBy + slideAmount) {
            reduceCapacityHead();
        }

        length--;
        return get(startIndex++);
    }
    
    public pointer removeTail() {
        debug_println(`remove endIndex=%lu, length=%lu, capacity=%lu`, endIndex, length, capacity);
        if (length == 0) {
            throwException(`[error] index array out of bounds`);
        }
        if (startIndex >= endIndex) {
            throwException(`[error] index array out of bounds index overlap.`);
        }


        pointer res = get(--endIndex);
        length--;

        if (capacity - length > growBy + slideAmount) {
            reduceCapacityTail();
        }

        return res;
    }

    public pointer remove(u64 index, pointer value) {
        debug_println(`remove %s`, `here`);
        if (length == 0 || index < startIndex || index > endIndex ) {
            throwException(`[error] index array out of bounds`);
        }

        if (index == startIndex) {
            return removeHead();
        }

        if (index == endIndex) {
            return removeTail();
        }

        pointer result = get(index);

        // move left or move right
        if (index - startIndex > endIndex - index) {
            // move tail
            u64 ix = index +1;
            memmove(EC_ADDRESS(EC_ARRAY(index, values)), EC_ADDRESS(EC_ARRAY(ix, values)), (endIndex - index) * dataSize); 
            endIndex--;
        } else {
            // move head
            u64 ix = startIndex +1;
            memmove(EC_ADDRESS(EC_ARRAY(ix, values)), EC_ADDRESS(EC_ARRAY(startIndex, values)), (index - startIndex) * dataSize); 
            startIndex++;
        }
        //@todo capicity check

        length--;
        return result;
    }

    public pointer peekTail() {
        debug_println(`peek %s`, `here`);
        if (length == 0) {
            throwException(`[error] index array out of bounds`);
        }
        return get(endIndex);
    }

    public pointer peekHead() {
        debug_println(`peek %s`, `here`);
        if (length == 0) {
            throwException(`[error] index array out of bounds`);
        }
        return get(startIndex);
    }

    private void addCapacityHead() {
        debug_println(`grow %s`, `here`);
        // maybe slighty tricky
        // not great for large arrays
        values = realloc(values, (capacity + growBy) * dataSize);
        if (values == null) {
            throwException(`[error] out of memory exception.`);
        }

        capacity += growBy;
        // realign
        // dest, source, size
        memmove(EC_ADDRESS(EC_ARRAY(growBy, values)), EC_ADDRESS(EC_ARRAY(0, values)), length * dataSize); 
        startIndex += growBy;
        endIndex += growBy;
    }

    private void addCapacityTail() {
        debug_println(`grow %s`, `here`);
        values = realloc(values, (capacity + growBy) * dataSize);
        if (values == null) {
            throwException(`[error] out of memory exception.`);
        }

        capacity += growBy;
    }

    private void reduceCapacityHead() {
        if (capacity <= initialSize) {
            return;
        }

        realignLeft();
        u64 oldCapacity = capacity;
        u64 requestAmount = (capacity - growBy) * dataSize;

        values = realloc(values, requestAmount);
        if (values == null) {
            throwException(`[error] out of memory exception.`);
        }

        capacity -= growBy;

        debug_println(`shrink length=%lu, requestedAmount=%lu, oldCapacity=%lu, capacity=%lu`, 
             length, requestAmount, oldCapacity, capacity);

    }

    private void reduceCapacityTail() {
        debug_println(`shrink %s`, `here`);
        values = realloc(values, (capacity - growBy) * dataSize);
        if (values == null) {
            throwException(`[error] out of memory exception.`);
        }

        capacity -= growBy;
    }

    private void realignLeft() {
        debug_println(`align %s`, `here`);
        // check if startIndex > slideAmount?
        // check Capacity?
        pointer dest = EC_ADDRESS(EC_ARRAY(0, values));
        pointer source = EC_ADDRESS(EC_ARRAY(startIndex, values));
        u64 amount = length * dataSize;

        debug_println(`align %p == %p, %p, amount=%lu, length=%lu, dataSize=%lu, capacity=%lu`, 
            dest, values, source, amount, length, dataSize, capacity);

        // realign left
        memmove(values, source, amount); 
        startIndex = 0;
        endIndex = length;
    }


    private void slideLeft() {
        debug_println(`slide %s`, `here`);
        // check if startIndex > slideAmount?
        // check Capacity?
        
        // slide left - may still leave headroom
        // bounds check
        u64 newStart = 0;
        if (startIndex+1 >= slideAmount) {
            newStart = startIndex - slideAmount;
        }
        memmove(EC_ADDRESS(EC_ARRAY(newStart, values)), EC_ADDRESS(EC_ARRAY(startIndex, values)), length * dataSize); 
        startIndex = newStart;
        endIndex = startIndex + length;
    }

    private void slideRight() {
        debug_println(`slide %s`, `here`);
        // check if startIndex > slideAmount?
        // check Capacity?
        u64 newStart =  startIndex - (capacity - length);
        if (endIndex + slideAmount <= capacity) {
            newStart = startIndex + slideAmount;
        }

        memmove(EC_ADDRESS(EC_ARRAY(newStart, values)), EC_ADDRESS(EC_ARRAY(startIndex, values)), length * dataSize); 
        startIndex = newStart;
        endIndex = newStart + length;
    }
}

debug_println(`start %s`, `here`);
// i8[10] numbers;
u64 n = 1;
i8 a = 50;
?myArray = NewDynamicArray(Boxing.i8_, n);
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
    debug_println(`remove loop %lu %i`, $a, EC_VALUE_i8(b));
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
    debug_println(`remove loop %lu %i`, $a, EC_VALUE_i8(b));
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
    debug_println(`remove loop %lu %i`, $a, EC_VALUE_i8(b));
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
    debug_println(`remove loop %lu %i`, $a, EC_VALUE_i8(b));
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
    debug_println(`remove loop %lu %i`, $a, EC_VALUE_i8(b));
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
