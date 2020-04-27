namespace Core;

public class signature Object {
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
}


class Core.String (Core.Object) {
    (public, private)properties {
        (public, private) pointer value;
    }

    /**
    * DefaULT
    */
    String(pointer str) {
        i64 len = strlen(str) + 1;
        value = alloc(len);
        strcpy(value, str);
    }

    /**
    * for strings which are defined in code c will statically allocate
    * the memory for them
    */
    String(pointer str, boolean staticAlloc) {
        if (staticAlloc) {
            value = str;
        } else {
            i64 len = strlen(str) + 1;
            value = alloc(len);
            strcpy(value, str);
        }
    }

    /**
    * String Concatenation
    */
    String(pointer str, pointer str2) {
        i64 len = strlen(str) + strlen(str2) + 1;
        value = alloc(len);
        strcpy(value, str);
        strcat(value, str2);
    }

    private String();

    pointer asStr() {
        return value;
    }

    String asString() {
        return this;
    }

    u64 length() {
      return strlen(value);
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

public class Core.DynamicArray (Core.Array){
    (public,public) properties {
        // pointer values;
        // u64 length;
        // u64 capacity;
        // int dataType;
        // u64 dataSize;
        // boolean managed;
        u64 startIndex;
        u64 endIndex;

        static u64 initialSize = 64;
        static u64 growBy = 64;
        static u64 slideAmount = 8;
    }

    // public DynamicArray(=capacity);

    public pointer getValue(u64 index)
    // ;
    {
        if (index >= length) {
            throwException(`[error] index array out of bounds`);
        }
        return get(startIndex + index);
    }

    public void setValue(u64 index, pointer value)
    // ;
    {
        if (index >= length) {
            throwException(`[error] index array out of bounds`);
        }
        set(startIndex + index, value);
    }

    public void addTail(pointer value)
    // ;
    {
        if (endIndex == capacity) {
            if (startIndex > slideAmount) {
                slideLeft();
            } else {
                addCapacityTail();
            }
        }
        length++;
        set(endIndex++, value);
    }

    public void addHead(pointer value)
    // ;
    {
        if (startIndex == 0) {
            if (endIndex < capacity - slideAmount) {
                slideRight();
            } else {
                addCapacityHead();
            }
        }
        length++;
        set(--startIndex, value);
    }

    public void insert(u64 index, pointer value)
    // ;
    {
        if (index > length) {
            throwException("[error] index array out of bounds");
        }

        if (index == startIndex) {
            return addHead(value);
        }

        if (index == endIndex) {
            return addTail(value);
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
            memmove(values[ix], values[index], (endIndex - index) * dataSize); 
        } else {
            // move head
            if (startIndex == 0) {
                addCapacityHead();
            }
            startIndex--;
            u64 ix = startIndex + 1;
            memmove(values[startIndex], values[ix], (index - startIndex) * dataSize); 
        }
        length++;
        set(index, value);
    }

    public pointer removeHead() 
    // ;
    {
        if (length == 0) {
            throwException("[error] index array out of bounds");
        }
        pointer res = get(startIndex++);
        length--;

        if (startIndex > growBy) {
            reduceCapacityHead();
        }

        return res;
    }
    
    public pointer removeTail() 
    // ;
    {
        if (length == 0) {
            throwException("[error] index array out of bounds");
        }
        pointer res = get(endIndex--);
        length--;

        if (endIndex + growBy < capacity) {
            reduceCapacityTail();
        }

        return res;
    }

    public pointer remove(u64 index, pointer value) 
    // ;
    {
        if (length == 0 || index < startIndex || index > endIndex ) {
            throwException("[error] index array out of bounds");
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
            memmove(values[index], values[ix], (endIndex - index) * dataSize); 
            endIndex--;
        } else {
            // move head
            u64 ix = startIndex +1;
            memmove(values[ix], values[startIndex], (index - startIndex) * dataSize); 
            startIndex++;
        }
        //@todo capicity check

        length--;
        return result;
    }

    public pointer peekTail() 
    // ;
    {
        if (length == 0) {
            throwException("[error] index array out of bounds");
        }
        return get(endIndex);
    }

    public pointer peekHead() 
    {
        if (length == 0) {
            throwException("[error] index array out of bounds");
        }
        return get(startIndex);
    }

    private void addCapacityHead() 
    // ;
    {
        // maybe slighty tricky
        // not great for large arrays
        values = realloc(values, (capacity + growBy) * dataSize);
        if (values == null) {
            throwException("[error] out of memory exception.");
        }

        capacity += growBy;
        // realign
        // dest, source, size
        memmove(values[growBy], values[0], length * dataSize); 
        startIndex += growBy;
        endIndex += growBy;
    }

    private void addCapacityTail() 
    // ;
    {
        values = realloc(values, (capacity + growBy) * dataSize);
        if (values == null) {
            throwException("[error] out of memory exception.");
        }

        capacity += growBy;
    }

    private void reduceCapacityHead() 
    // ;
    {
        realignLeft();
        values = realloc(values, (capacity - growBy) * dataSize);
        if (values == null) {
            throwException("[error] out of memory exception.");
        }

        capacity -= growBy;
    }

    private void reduceCapacityTail() 
    // ;
    {
        values = realloc(values, (capacity - growBy) * dataSize);
        if (values == null) {
            throwException("[error] out of memory exception.");
        }

        capacity -= growBy;
    }

    private void realignLeft() 
    // ;
    {
        // check if startIndex > slideAmount?
        // check Capacity?

        // realign left
        memmove(values[0], values[startIndex], length * dataSize); 
        startIndex = 0;
        endIndex = length;
    }


    private void slideLeft() 
    // ;
    {
        // check if startIndex > slideAmount?
        // check Capacity?
        
        // slide left - may still leave headroom
        // bounds check
        u64 newStart = 0;
        if (startIndex >= slideAmount) {
            newStart = startIndex - slideAmount;
        }
        memmove(values[newStart], values[startIndex], length * dataSize); 
        startIndex = newStart;
        endIndex = length;
    }

    private void slideRight() 
    // ;
    {
        // check if startIndex > slideAmount?
        // check Capacity?
        u64 newStart =  startIndex - (capacity - length);
        if (endIndex + slideAmount <= capacity) {
            newStart = startIndex + slideAmount;
        }

        memmove(values[newStart], values[startIndex], length * dataSize); 
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
