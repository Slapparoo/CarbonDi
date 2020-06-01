namespace Core;

public class signature Core.Object {
    public Object();

    public final pointer getObjectData() {
      return null;
    }

    public pointer asStr() {
       sprintf(getTmpBuffer(), `(%s::%s) id=%lu`, getClassPackage(), getClassName(), this);
       return getTmpBuffer();
    }

    public void printTo(pointer stream) {
      fprintf(stream, `%s`, asStr());
    }

    public String asString() {
      return Object_asString(this);
    }

    public i64 hashCode() {
       return (this * 0xff3ff3ff3ff3ff13) >> 3;
    }

    public boolean equals(Object other) {
      return this == other;
    } 

    hidden final void free() {};
    hidden void release() {}; 
    public final pointer alloc(u64 size) {
      return Object_alloc(this, size);
    }

    public final pointer realloc(pointer ptr, u64 size) {
      return Object_realloc(this, ptr, size);
    }

}

public class Core.String (Core.Object) {
    (public, private)properties {
        (public, private) pointer value;
    }

    /**
    * DefaULT
    */
    String(pointer str) {
        i64 len = External.stdio.strlen(str) + 1;
        value = this.alloc(len);
        External.stdio.strcpy(value, str);
    }

    /**
    * for strings which are defined in code c will statically allocate
    * the memory for them
    */
    String(pointer str, boolean staticAlloc) {
        if (staticAlloc) {
            value = str;
        } else {
            i64 len = External.stdio.strlen(str) + 1;
            this.value = this.alloc(len);
            External.stdio.strcpy(value, str);
        }
    }

    /**
    * String Concatenation
    */
    String(pointer str, pointer str2) {
        i64 len = External.stdio.strlen(str) + External.stdio.strlen(str2) + 1;
        this.value = this.alloc(len);
        External.stdio.strcpy(value, str);
        External.stdio.strcat(value, str2);
    }

    private String();

    // public pointer asStr() {
    //     return value;
    // }

    public String asString() {
        return this;
    }

    public u64 length() {
      return External.stdio.strlen(value);
    }

    public void appendStr(pointer str) {
        i64 len = External.stdio.strlen(value) + External.stdio.strlen(str) + 1;
        this.value = realloc(value, len);
        External.stdio.strcat(value, str);
    }

    public void appendString(String str) {
      appendStr(str.asStr());
    }
}

public class Core.Exception (Core.Object) {
    (public, private) properties {
        String message;
        Exception root;
    }
    private Exception();
    public Exception(=message);
    public Exception(=root, =message);
}

public class signature Core.Array(Core.Object){
  (public,public) properties {
    (public,public) pointer values;
    (public,public) u64 length;
    (public,public) u64 capacity;
    (public,public) int dataType;
    (public,public) u64 dataSize;
    (public,public) boolean managed;
  }

  private Array();
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
}// Core::RefArray Signature compiled
/* imports {} */

public class signature Core.RefArray(Core.Array){
  // (public,public) properties {
  //   (public,public) pointer values;
  //   (public,public) u64 length;
  //   (public,public) u64 capacity;
  //   (public,public) int dataType;
  //   (public,public) u64 dataSize;
  //   (public,public) boolean managed;
  // }

  /* default constructor */
  public RefArray(u64 length);
  hidden RefArray(u64 capacity, int dataType, u64 dataSize);
  hidden RefArray(u64 capacity, int dataType, u64 dataSize, pointer values);

  public void setObject(u64 index, num object);
  public static final pointer getClassName();
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

// public class DynamicArray (Array) {
//   pointer get(num b);
//   void set(num b, pointer c);
//   void setObject(num b, num c);
// }

public class Core.Boxing (Core.Object) {
   /* primative_types */
  (public, private) properties {
    static int b8_ = 1; 
    static int i8_ = 2; 
    static int u8_ = 3; 
    static int i16_ = 4; 
    static int u16_ = 5; 
    static int i32_ = 6; 
    static int u32_ = 7; 
    static int f32_ = 8; 
    static int i64_ = 9; 
    static int u64_ = 10; 
    static int f64_ = 11; 
    static int pointer_ = 12; 
  }
}


public class Core.BaseBoxing (Core.Object) {
  static int datatype() { return 0; }
  static pointer typename() {return `undefined`;} 
}



/**
* b8 otherwise known as boolean
*/

public final class Core.B8 (Core.BaseBoxing) {
  (public, public) properties {
    b8 value; 
  }

  private B8();

  public static int datatype() {
    return Boxing.b8_;
  }

  public static pointer typename() {
      return `b8`;
  }

  public B8(=value);

  public pointer asStr() {
    if (value) {
      return `true`;
    } else {
      return `false`;
    }
  };
}

public final class Core.U8 (Core.BaseBoxing) {
  (public, public) properties {
    u8 value; 
  }

  public static int datatype() {
    return Boxing.u8_;
  }

  public static pointer typename() {
    return `u8`;
  }

  public U8(=value);

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%u`, value);
    return getTmpBuffer();      
  }
}

public final class Core.I8 (Core.BaseBoxing) {
  (public, public) properties {
    i8 value; 
  }

  public I8(=value) {}

  public static int datatype() {
    return Boxing.i8_;
  }

  public static pointer typename() {
    return `i8`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%i`, value);
    return getTmpBuffer();      
  }
}

public final class Core.I16 (Core.BaseBoxing) {
  (public, public) properties {
    i16 value; 
  }

  public I16(=value) {}

  public static int datatype() {
    return Boxing.i16_;
  }

  public static pointer typename() {
    return `i16`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%i`, value);
    return getTmpBuffer();      
  }
}

public final class Core.U16 (Core.BaseBoxing) {
  (public, public) properties {
    u16 value; 
  }

  public U16(=value) {}

  public static int datatype() {
    return Boxing.u16_;
  }

  public static pointer typename() {
    return `u16`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%u`, value);
    return getTmpBuffer();      
  }
}

public final class Core.I32 (Core.BaseBoxing) {
  (public, public) properties {
    i32 value; 
  }

  public I32(=value) {}

  public static int datatype() {
    return Boxing.i32_;
  }

  public static pointer typename() {
    return `i32`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%i`, value);
    return getTmpBuffer();      
  }
}

public final class Core.U32 (Core.BaseBoxing) {
  (public, public) properties {
    u32 value; 
  }

  public U32(=value) {}

  public static int datatype() {
    return Boxing.u32_;
  }

  public static pointer typename() {
    return `u32`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%u`, value);
    return getTmpBuffer();      
  }
}

public final class Core.F32 (Core.BaseBoxing) {
  (public, public) properties {
    f32 value; 
  }

  public F32(=value) {}

  public static int datatype() {
    return Boxing.f32_;
  }

  public static pointer typename() {
    return `f32`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%f`, value);
    return getTmpBuffer();      
  }
}

public final class Core.I64 (Core.BaseBoxing) {
  (public, public) properties {
    i64 value; 
  }

  public I64(=value) {}

  public static int datatype() {
    return Boxing.i64_;
  }

  public static pointer typename() {
    return `i64`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%li`, value);
    return getTmpBuffer();      
  }
}

public final class Core.U64 (Core.BaseBoxing) {
  (public, public) properties {
    u64 value; 
  }

  public U64(=value) {}

  public static int datatype() {
    return Boxing.u64_;
  }

  public static pointer typename() {
    return `u64`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%lu`, value);
    return getTmpBuffer();      
  }
}

public final class Core.F64 (Core.BaseBoxing) {
  (public, public) properties {
    f64 value; 
  }

  public F64(=value) {}

  public static int datatype() {
    return Boxing.f64_;
  }

  public static pointer typename() {
    return `f64`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%lf`, value);
    return getTmpBuffer();      
  }
}

public final class Core.Pointer (Core.BaseBoxing) {
  (public, public) properties {
    pointer value; 
  }

  public Pointer(=value) {}

  public static int datatype() {
    return Boxing.pointer_;
  }

  public static pointer typename() {
    return `pointer`;
  }

  public pointer asStr() {
    sprintf(getTmpBuffer(), `%p`, value);
    return getTmpBuffer();      
  }
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



/**
All singing all dancing Dynamic array can be used as 
* stack
* queue
* list
* buffer
* lifo
* fifo

*/

public class Core.NewDynamicArray (Core.Array){
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

// public final class Core.Observer (Core.Object) {
//   (public, public) properties {
//     u64 key; 
//     u64 event;
//   }

//   public void handleEvent() {

//   }
// }

// public final class Core.Observerable (Core.Object) {
//   (public, public) properties {
//     u64 key; 
//     // u64 event;
//     Observer[] listeners;
//   }

//   public onEvent(u64 event) {
//     loop(listeners) {
//       if ($a.event == event) {
//         $a.handleEvent();
//       }
//     }
//   }

// }

// Observe(myI8, value, Event.afterSet);


// // class F80 (Boxing) {
// //   properties {
// // //    f80 value; 
// //   }
// // };

// // /* Signature */
// // class F128 (Boxing) {
// //   properties {
// // //    f128 value; 
// //   }
// // };
