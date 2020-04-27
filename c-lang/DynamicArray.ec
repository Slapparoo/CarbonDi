// Core.Object Signature compiled
/* imports {} */

public class signature Core.Object{

  /* default constructor */

  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
}// Core.String Signature compiled
/* imports {} */

public class signature Core.String(Core.Object){
  (public,public) properties {
    (public,public) pointer value;
  }

  private String();
  public String(pointer str);
  public String(pointer str, boolean staticAlloc);
  public String(pointer str, pointer str2);

  public pointer asStr();
  public String asString();
  public u64 length();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.Exception Signature compiled
/* imports {} */

public class signature Core.Exception(Core.Object){
  (public,public) properties {
    (public,public) String message;
    (public,public) Exception root;
  }

  private Exception();
  public Exception(Exception root, String message);
  public Exception(String message);

  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.Array Signature compiled
/* imports {} */

public class signature Core.Array(Core.Object){
  (public,public) properties {
    (public,public) pointer values;
    (public,public) u64 length;
    (public,public) u64 capacity;
    (public,public) int dataType;
    (public,public) u64 dataSize;
    (public,public) boolean managed;
  }

  hidden Array();
  public Array(u64 capacity, int dataType, u64 dataSize);
  public Array(u64 capacity, int dataType, u64 dataSize, pointer values);

  public pointer get(u64 b);
  public void set(u64 b, pointer c);
  public u64 memsize();
  public pointer typename();
  public static final pointer getClassName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
}// Core.RefArray Signature compiled
/* imports {} */

public class signature Core.RefArray(Core.Array){
  (public,public) properties {
    (public,public) pointer values;
    (public,public) u64 length;
    (public,public) u64 capacity;
    (public,public) int dataType;
    (public,public) u64 dataSize;
    (public,public) boolean managed;
  }

  /* default constructor */
  public RefArray(u64 length);
  hidden RefArray(u64 capacity, int dataType, u64 dataSize);
  hidden RefArray(u64 capacity, int dataType, u64 dataSize, pointer values);

  public void setObject(u64 index, num object);
  public pointer get(u64 b);
  public void set(u64 b, pointer c);
  public u64 memsize();
  public pointer typename();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
}// Core.Boxing Signature compiled
/* imports {} */

public class signature Core.Boxing(Core.Object){
  (public,public) properties {
    (public,public)  static int b8_;
    (public,public)  static int i8_;
    (public,public)  static int u8_;
    (public,public)  static int i16_;
    (public,public)  static int u16_;
    (public,public)  static int i32_;
    (public,public)  static int u32_;
    (public,public)  static int f32_;
    (public,public)  static int i64_;
    (public,public)  static int u64_;
    (public,public)  static int f64_;
    (public,public)  static int pointer_;
  }

  /* default constructor */

  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.BaseBoxing Signature compiled
/* imports {} */

public class signature Core.BaseBoxing(Core.Object){

  /* default constructor */

  public static int datatype();
  public static pointer typename();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.B8 Signature compiled
/* imports {} */

public final class signature Core.B8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) b8 value;
  }

  private B8();
  public B8(b8 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.U8 Signature compiled
/* imports {} */

public final class signature Core.U8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u8 value;
  }

  /* default constructor */
  public U8(u8 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.I8 Signature compiled
/* imports {} */

public final class signature Core.I8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i8 value;
  }

  /* default constructor */
  public I8(i8 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.I16 Signature compiled
/* imports {} */

public final class signature Core.I16(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i16 value;
  }

  /* default constructor */
  public I16(i16 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.U16 Signature compiled
/* imports {} */

public final class signature Core.U16(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u16 value;
  }

  /* default constructor */
  public U16(u16 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.I32 Signature compiled
/* imports {} */

public final class signature Core.I32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i32 value;
  }

  /* default constructor */
  public I32(i32 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.U32 Signature compiled
/* imports {} */

public final class signature Core.U32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u32 value;
  }

  /* default constructor */
  public U32(u32 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.F32 Signature compiled
/* imports {} */

public final class signature Core.F32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) f32 value;
  }

  /* default constructor */
  public F32(f32 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.I64 Signature compiled
/* imports {} */

public final class signature Core.I64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i64 value;
  }

  /* default constructor */
  public I64(i64 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.U64 Signature compiled
/* imports {} */

public final class signature Core.U64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u64 value;
  }

  /* default constructor */
  public U64(u64 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.F64 Signature compiled
/* imports {} */

public final class signature Core.F64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) f64 value;
  }

  /* default constructor */
  public F64(f64 value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core.Pointer Signature compiled
/* imports {} */

public final class signature Core.Pointer(Core.BaseBoxing){
  (public,public) properties {
    (public,public) pointer value;
  }

  /* default constructor */
  public Pointer(pointer value);

  public static int datatype();
  public static pointer typename();
  public pointer asStr();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}

public class signature Core.DynamicArray(Core.Array){
  (public,public) properties {
    (public,public) u64 startIndex;
    (public,public) u64 endIndex;
    (public,public)  static u64 initialSize;
    (public,public)  static u64 growBy;
    (public,public)  static u64 slideAmount;
    (public,public) pointer values;
    (public,public) u64 length;
    (public,public) u64 capacity;
    (public,public) int dataType;
    (public,public) u64 dataSize;
    (public,public) boolean managed;
  }

  /* default constructor */
  public DynamicArray(u64 capacity, int dataType, u64 dataSize);
  public DynamicArray(u64 capacity, int dataType, u64 dataSize, pointer values);

  public pointer getValue(u64 index);
  public void setValue(u64 index, pointer value);
  public void addTail(pointer value);
  public void addHead(pointer value);
  public void insert(u64 index, pointer value);
  public pointer removeHead();
  public pointer removeTail();
  public pointer remove(u64 index, pointer value);
  public pointer peekTail();
  public pointer peekHead();
  private void addCapacityHead();
  private void addCapacityTail();
  private void reduceCapacityHead();
  private void reduceCapacityTail();
  private void realignLeft();
  private void slideLeft();
  private void slideRight();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public pointer get(u64 b);
  public void set(u64 b, pointer c);
  public u64 memsize();
  public pointer typename();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}
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
