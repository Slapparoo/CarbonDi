namespace Core;

public class Core.Object {

    (public, private) properties {
      pointer instanceName;
    }

    public Object();

    public pointer asStr() {
       sprintf(tmpBuffer, `(%s::%s) id=%lu`, classPackage, className, this);
       return tmpBuffer;
    }

    public void printTo(pointer stream) {
      fprintf(stream, `%s`, asStr());
    }

    /**
    Exposes the underlying pointer to the data can be used for both read and writes, so some caution is advised.
    */
    public pointer objectData() {
      return External.core.Object_data(this);
    }

    public i32 hashCode() {
       return this;
    }

    public boolean equals(Object other) {
      return this == other;
    } 

    hidden final void free() {};
    hidden void release() {}; 

    public final pointer alloc(u64 size) {
      return External.core.Object_alloc(this, size);
    }

    public final pointer realloc(pointer ptr, u64 size) {
      return External.core.Object_realloc(this, ptr, size);
    }
}

public class Core.HashCode (Core.Object) {
    public static i32 calcFastHash(pointer p, u64 length) {
        i32 res = 0;

        loop (length) {
            if (length - $a > 4) {
                res += External.core.EC_GETVALUE_i32(p, $a);
                $a += 3;
            } else if (length - $a > 2) {
                res += External.core.EC_GETVALUE_i16(p, $a);
                $a += 1;
            } else {
                // for alpha - 31 (this only happens to the last ch in the array)
                res += External.core.EC_GETVALUE_i8(p, $a) - 31;
            }
        }

        return res;
    }
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
  // public static final pointer getClassName();
  // public static final pointer getClassPackage();
  // public static final u64 getObjectDatasize();
  // public final pointer getObjectData();
  // public pointer asStr();
  // public void printTo(pointer stream);
  // public String asString();
  // public i64 hashCode();
  // public boolean equals(Object other);
  // hidden final void free();
  // hidden void release();
  // public final pointer alloc(u64 size);
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
  // public static final pointer getClassName();
  // public static final pointer getClassPackage();
  // public static final u64 getObjectDatasize();
  public pointer get(u64 b);
  public void set(u64 b, pointer c);
  public u64 memsize();
  public pointer typename();
  // public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i32 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}


public class Core.String (Core.Object) {
    properties {
         (public, private) pointer value;
         (private, private) i32 hash;
    }


    /**
    * DefaULT
    */
    public String(pointer str) {
        i64 len = External.stdio.strlen(str) + 1;
        value = this.alloc(len);
        External.stdio.strcpy(value, str);
    }

    /**
    * for strings which are defined in code c will statically allocate
    * the memory for them
    */
    public String(pointer str, boolean staticAlloc) {
        if (staticAlloc) {
            value = str;
        } else {
            i64 len = External.stdio.strlen(str) + 1;
            value = this.alloc(len);
            External.stdio.strcpy(value, str);
        }
    }

    /**
    * String Concatenation
    */
    public String(pointer str, pointer str2) {
        i64 len = External.stdio.strlen(str) + External.stdio.strlen(str2) + 1;
        value = this.alloc(len);
        External.stdio.strcpy(value, str);
        External.stdio.strcat(value, str2);
    }

    /**
    create a new String which is a substring of another
    */
    public String(pointer str, u64 offset, u64 len) {
        value = this.alloc(len + 1);
        External.stdio.memcpy(value, str + offset, len);
    }

    private String();

    public String asString() {
        return this;
    }

    public u64 length() {
      return External.stdio.strlen(value);
    }

    public void println() {
        External.stdio.printf(`%s\n`, this.asStr());
    }

    public String appendStr(pointer str) {
        // i64 len = 0;
        i64 len = External.stdio.strlen(value) + External.stdio.strlen(str) + 1;
        value = this.realloc(value, len);
        External.stdio.strcat(value, str);

        return this;
    }

    public String append(String string) {
        appendStr(string.asStr());
        return this;
    }

    public String prependStr(pointer str4) {
        i64 len = External.stdio.strlen(value) + External.stdio.strlen(str4) + 1;
        value = realloc(value, len);
        External.stdio.memmove(
          EC_ADDRESS(
            EC_ARRAY(value, External.stdio.strlen(str4))), value, External.stdio.strlen(value) +1);
        External.stdio.memcpy(value, str4, External.stdio.strlen(str4));

        return this;
    }

    public String prepend(String string1) {
        prependStr(string1.asStr());

        return this;
    }

    /**
    return 0 if the strings are equal 
    negative if the ASCII value of the first unmatched character is less than the second.
    positive if the ASCII value of the first unmatched character is greater than the second.

    */
    public i64 compareStr(pointer str5) {
        i64 res = External.stdio.strcmp(value, str5);
        return res;
    }

    /**
      Compare this string to a 'substring' in other
    */
    public boolean compareSubStr(pointer str6, u64 offset) {
        ?l = length();
        pointer str2 = EC_ADDRESS(EC_ARRAY(str6, offset));

        ?matched = true;
        loop (l) {
          if (External.core.EC_GETVALUE_i8(str2, l) != External.core.EC_GETVALUE_i8(value, l)) {
            matched = false;
          }
        }
        
        return matched;
    }

    public i8 getChar(u64 offset) {
      if (offset > length()) {
        throwException(`[error] String.getChar offset out of bounds.`);
      }
      return External.core.EC_GETVALUE_i8(value, offset);
    }

    // public i8[] asArray() {
    //   // Array(u64 capacity, int dataType, u64 dataSize, pointer values);
    //   return Array(length(), Boxing.i8_, 1, value);
    // }

    /**
      is the passed string matched at the given offset 
    */
    public boolean isSubStr(pointer str7, u64 offset) {
        ?l = External.stdio.strlen(str7);
        pointer str2 = EC_ADDRESS(EC_ARRAY(value, offset));

        loop (l) {
          if (External.core.EC_GETVALUE_i8(str7, $a) != External.core.EC_GETVALUE_i8(str2, $a)) {
            return false;
          }
        }
        
        return true;
    }


    public i64 compare(String string5) {
        i64 res = External.stdio.strcmp(value, string5.asStr());
        return res;
    }

    public i64 findStr(i64 from, pointer str6) {
        pointer p = External.stdio.strstr(EC_ADDRESS(EC_ARRAY(value, from)), str6);

        if (p == null) {
            return -1;
        }
        i64 res = p - value;

        return res;
    }

    public i64 find(i64 from, String string6) {
        return findStr(from, string6.asStr());
    }

    public boolean equals(String other) {
      if (this == other) {
        return true;
      }

      return !External.stdio.strcmp(value, other.value);
    } 


    /**
    Array with the offsets of all instances of the sub strings
    */
    // public i64[] findAll(pointer str7) {
    //     int datatype = 10;
    //     DynamicArray offsets = DynamicArray(64, datatype, 8);

    //     ?offset = findStr(0, str7);

    //     printf(`loop %li\n`, offset);

    //     loop (offset > 0) {
    //         printf(`loop %li`, offset);
    //         offsets.addHead(EC_ADDRESS(offset));
    //         offset = findStr(offset + 1, str7);
    //     }
    //     // offsets.addHead(str7);
    //     printf(`%s %li\n`, offsets.asStr, offsets.length);


    //     return offsets;
    // }

    public void trunc(i64 start, i64 end) {
        i64 len = External.stdio.strlen(value);
        if (start < 0) {
            throwException(`[string trunc] start is less than zero.`);
        }

        if (end < start) {
            throwException(`[string trunc] end is less than start.`);
        }

        if (start > len) {
            throwException(`[string trunc] start is after length of string.`);
        }

        if (end > len) {
            throwException(`[string trunc] end after length of string.`);
        }

        i64 newLen = end - start;
        External.stdio.memmove(value, EC_ADDRESS(EC_ARRAY(value, start)), newLen);
        value = realloc(value, newLen+1);
        EC_SETVALUE_i8(newLen, value, 0);
    }

    public pointer asStr() {
        return value;
    }

    public i32 hashCode() {
      if (hash) {
        return hash;
      }
      hash = HashCode.calcFastHash(value, length);
      return hash;
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

  public static i32 getSizeBytes(i32 type) {
    if (type == 1 || type == 2 || type == 3) {
      return 1;
    } else if (type == 4 || type == 5) {
      return 2;
    } else if (type == 6 || type == 7 || type == 8) {
      return 4;
    } else if (type == 9 || type == 10 || type == 11) {
      return 8;
    }

    return 0;
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
    sprintf(tmpBuffer, `%u`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%i`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%i`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%u`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%i`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%u`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%f`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%li`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%lu`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%lf`, value);
    return tmpBuffer;      
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
    sprintf(tmpBuffer, `%p`, value);
    return tmpBuffer;      
  }
}

public final class Core.FileUtils (Core.Object) {

  public static u64 filesize(pointer fp){
      int prev = External.stdio.ftell(fp);
      External.stdio.fseek(fp, 0, External.stdio.SEEK_END);
      int sz = External.stdio.ftell(fp);
      External.stdio.fseek(fp, prev, External.stdio.SEEK_SET); //go back to where we were
      return sz;
  }

  public static i8[] fileread(String filename) { 
      pointer fp = External.stdio.fopen(filename.asStr(), `'r'`);
      if (fp == null) {
          External.core.throwException(`[openfile] error opening file.`);
      }
      ?size = filesize(fp);
      ?szp1 = size+1;
      ?buffer = i8[szp1]; // +1 so we can have a null terminated str
      ?result = External.stdio.fread(buffer.values, 1, size, fp);

      External.stdio.fclose(fp);

      if (result != size) {
          External.core.throwException(`[readfile] error reading file.`);
      }

      return buffer;
  }

}


public final class Core.Charactor (Core.Object) {

    public static boolean isLetter(i8 chr) {
        ?res = false;
        switch (chr) {
            case 'A'..'Z' :
            case 'a'..'z' :
                res = true;
        }

        return res;
    }

    public static boolean isAlpha(i8 chr) {
        ?res = false;
        switch (chr) {
            case ' ':
            case 'A'..'Z' :
            case 'a'..'z' :
                res = true;
        }

        return res;
    }

    public static boolean isUpper(i8 chr) {
        ?res = false;
        switch (chr) {
            case 'A'..'Z' :
                res = true;
        }

        return res;
    }

    public static boolean isLower(i8 chr) {
        ?res = false;
        switch (chr) {
            case 'a'..'z' :
                res = true;
        }

        return res;
    }

    public static boolean isAlphaNumeric(i8 chr) {
        ?res = false;
        switch (chr) {
            case ' ':
            case '0'..'9' :
            case 'A'..'Z' :
            case 'a'..'z' :
                res = true;
        }

        return res;
    }

    public static boolean isLetterorNumber(i8 chr) {
        ?res = false;
        switch (chr) {
            case '0'..'9' :
            case 'A'..'Z' :
            case 'a'..'z' :
                res = true;
        }

        return res;
    }

    public static boolean isNumber(i8 chr) {
        ?res = false;
        switch (chr) {
            case '0'..'9' :
            case '_' :
                res = true;
        }

        return res;
    }

    public static boolean isFloat(i8 chr) {
        ?res = false;
        switch (chr) {
            case '0'..'9' :
            case '_' :
            case '.' :
                res = true;
        }

        return res;
    }

    public static boolean isHex(i8 chr) {
        ?res = false;
        switch (chr) {
            case '0'..'9' :
            case 'a'..'f' :
            case 'A'..'F' :
            case '_' :
                res = true;
        }

        return res;
    }

    public static boolean isBinary(i8 chr) {
        ?res = false;
        switch (chr) {
            case '0'..'1' :
            case '_' :
                res = true;
        }

        return res;
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

public class Core.DynamicArray (Core.Array){
    (public,public) properties {
        /** Used internally to maintain the 
        current position */
        u64 startIndex;
        u64 endIndex;

        static u64 initialSize = 8;
        static u64 growBy = 8;
        static u64 slideAmount = 4;
        
    }

    public DynamicArray(=dataType) {
        capacity = initialSize;
        dataSize = Boxing.getSizeBytes(dataType);
        values = alloc(capacity * dataSize);
        startIndex = initialSize /2;
        endIndex = startIndex;
        length = 0;
    }

    public DynamicArray(=dataType, =dataSize) {
        capacity = initialSize;
        values = alloc(capacity * dataSize);
        startIndex = initialSize /2;
        endIndex = startIndex;
        length = 0;
    }

    /** return a pointer to the array content */
    public pointer getValue(u64 index) {
        debug_println(`add %s`, `here`);
        if (index >= capacity) {
            throwException(`[error] index array out of bounds`);
        }
        return get(index);
    }

    /** Used internaly to set a value for arrays use:
    ```myarray[0] = value;```
    */
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
            External.stdio.memmove(EC_ADDRESS(
              EC_ARRAY(ix, values)), EC_ADDRESS(
                EC_ARRAY(index, values)), (endIndex - index) * dataSize); 
        } else {
            // move head
            if (startIndex == 0) {
                addCapacityHead();
            }
            startIndex--;
            u64 ix = startIndex + 1;
            External.stdio.memmove(EC_ADDRESS(
              EC_ARRAY(startIndex, values)), 
              EC_ADDRESS(EC_ARRAY(ix, values)), (index - startIndex) * dataSize); 
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


        pointer res1 = get(--endIndex);
        length--;

        if (capacity - length > growBy + slideAmount) {
            reduceCapacityTail();
        }

        return res1;
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
            External.stdio.memmove(EC_ADDRESS(
              EC_ARRAY(index, values)), 
              EC_ADDRESS(EC_ARRAY(ix, values)), (endIndex - index) * dataSize); 
            endIndex--;
        } else {
            // move head
            u64 ix = startIndex +1;
            External.stdio.memmove(
              EC_ADDRESS(
                EC_ARRAY(ix, values)), 
                EC_ADDRESS(
                  EC_ARRAY(startIndex, values)), (index - startIndex) * dataSize); 
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
        External.stdio.memmove(
          EC_ADDRESS(
            EC_ARRAY(growBy, values)), 
            EC_ADDRESS(
              EC_ARRAY(0, values)), length * dataSize); 
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
        External.stdio.memmove(values, source, amount); 
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
        External.stdio.memmove(
          EC_ADDRESS(
            EC_ARRAY(newStart, values)), 
            EC_ADDRESS(
              EC_ARRAY(startIndex, values)), length * dataSize); 
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

        External.stdio.memmove(
          EC_ADDRESS(
            EC_ARRAY(newStart, values)), 
            EC_ADDRESS(
              EC_ARRAY(startIndex, values)), length * dataSize); 
        startIndex = newStart;
        endIndex = newStart + length;
    }
}


class Core.RefArrayList (Core.Object) {
    (private, private) properties {
        RefArray list;
        (public,) u64 ralsize;
        boolean isInit = false;

        static u64 growBy = 256;
    }

    private void startup() {
        if (isInit) {
            return;
        }
        isInit = true;
        list = RefArray(growBy);
    }

    private void growList() {
        ?tempList = list;
        ?newList = RefArray(tempList.length + growBy);

        loop (tempList.length) {
            ?ix = $a;
            newList[ix] = tempList[ix];
        }

        list = newList;
    }

    public void add(Object object) {
        startup();
        ?tempList = list;

        if (tempList.length == ralsize) {
            growList();
            // tempList = list;
        }

        ?tempList2 = list;

        tempList2[ralsize] = object;
        ralsize++;
    }

    public Object get(u64 index) {
        ?tempList = list;
        Object o = tempList[index];
        return o;
    }
}



public class Core.Duo (Core.Object) {
    properties {
        Object one;
        Object two;
    }
}

/**
    hash map store, relitively light weight implementation don't expect to much from it.
*/
// public class Core.Hashset (Core.Object) {

//     (private, private) properties {
//         u64 hsitems = 0;
//         RefArray hslist;
//         boolean isInit = false;
//         u64 hssize = 256;
//     }

//     // public Hashset(=hssize);

//     private void reHash(Object object) {
//         ?oldSize = hssize;
//         ?oldlist = hslist;

//         hssize += 512;
//         ?newlist = RefArray(hssize);

//         hsitems = 0;
//         loop (oldSize) {
//             ?ix = $a;  
//             Object item = oldlist[ix];

//             if (item != 0) {
//                 if (item.instanceName == Duo.className) {
//                     Duo d = item;
//                     addNew(newlist, d.one);
//                     addNew(newlist, d.two);
//                 } else {
//                     addNew(newlist, item);
//                 }
//             }
//         }

//         addNew(newlist, object);

//         hslist = newlist;
//     }

//     private void startup() {
//         if (isInit) {
//             return;
//         }

//         // 256 *4 = 1kb
//         if (hssize < 256) {
//             hssize = 256;
//         }

//         hslist = RefArray(hssize);
//         isInit = true;
//     }

//     public boolean contains(Object object) {
//         if (!isInit) {
//             return false;
//         }

//         i32 index = object.hashCode() % hssize;

//         ?tempList = hslist;
//         Object item = tempList[index];

//         if (item == 0) {
//             return false;
//         } else if (item.equals(object)) {
//             return true;        
//         }
//         return false;
//     }

//     public void add(Object object) {
//         if (!isInit) {
//             startup();
//         }

//         i32 index = object.hashCode() % hssize;

//         ?tempList = hslist;
//         Object item = tempList[index];

//         if (item == 0) {
//             tempList[index] = object;
//             hsitems++;
//             return;
//         } else if (item.equals(object)) {
//             return;
//         } else if (item.instanceName == Duo.className) {
//             Duo duo = item; 
//             if (duo.one == object || duo.two == object) {
//                 return;
//             }
//             reHash(object);
//         } else {
//             ?duo = Duo();
//             duo.one = item;
//             duo.two = object;
//             tempList[index] = duo;
//             hsitems++;
//         }
//     }

//     private void addNew(RefArray newlist, Object object) {
//         i32 index = object.hashCode() % hssize;

//         ?tempList = newlist;
//         Object item = tempList[index];

//         if (item == 0) {
//             tempList[index] = object;
//             hsitems++;
//             return;
//         } else if (item.equals(object)) {
//             return;
//         } else if (item.instanceName == Duo.className) {
            
//             Duo duo = item; 
//             if (duo.one == object || duo.two == object) {
//                 return;
//             }
//             throwException(`Reentrant hashset resize.`);

//         } else {
//             ?duo = Duo();
//             duo.one = item;
//             duo.two = object;
//             tempList[index] = duo;
//             hsitems++;
//         }
//     }
// };

class Core.Hashset {}


public class Core.MapDuo (Core.Object) {
    properties {
        Object oneKey;
        Object twoKey;
        Object oneValue;
        Object twoValue;
    }
}


public class Core.MapEntry (Core.Object) {
    properties {
        Object key;
        Object value;
    }

    public MapEntry(=key, =value);
}


/**
    hash map store
*/
public class Core.Hashmap (Core.Object) {

    properties {
        boolean isInitm = false;
        u64 hmitems = 0;
        u64 hmsize = 1024;
        RefArray hmlist;
    }

    // public Hashmap(=hmsize);

    private void reHash(Object key, Object value) {
        ?oldSize = hmsize;
        ?oldlist = this.hmlist;

        hmsize += 512;
        ?newlist = RefArray(hmsize);

        hmitems = 0;
        loop (oldSize) {
            ?ix = $a;  
            Object item = oldlist[ix];

            if (item != 0) {
                if (item.instanceName == MapDuo.className) {
                    MapDuo d = item;
                    internalPut(newlist, d.oneKey, d.oneValue);
                    internalPut(newlist, d.twoKey, d.twoValue);
                } else {
                    MapEntry e = item;
                    internalPut(newlist, e.key, e.value);
                }
            }
        }

        internalPut(newlist, key, value);

        this.hmlist = newlist;
        // printf(`items=%lu size=%lu\n`, items, size);
    }

    public void startuphm() {
        if (this.isInitm) {
            return;
        }
        // 256 *4 = 1kb
        if (hmsize < 256) {
            hmsize = 256;
        }

        this.hmlist = RefArray(hmsize);
        this.isInitm = true;
    }

    public Object get(Object object) {
        if (!this.isInitm) {
            return 0;
        }
        i32 index = object.hashCode() % hmsize;

        ?tempList = this.hmlist;
        MapEntry item = tempList[index];

        if (item == 0) {
            return 0;
        } else if (item.instanceName == MapDuo.className) {
            MapDuo duo = item; 
            if (duo.oneKey.equals(object)) {
                return duo.oneValue;
            } else if(duo.twoKey.equals(object)) {
                return duo.twoValue;
            }
        } else if (item.instanceName == MapEntry.className) {
            MapEntry e = item;
            if (e.key.equals(object)) {
                return e.value;        
            }
        }
        return 0;
    }

    private void internalPut(RefArray refArray, Object key, Object value) {
        i32 index = key.hashCode() % hmsize;

        ?tempList = refArray;
        Object item = tempList[index];

        if (item == 0) {
            tempList[index] = MapEntry(key, value);
            hmitems++;
            return;
        } else if (item.instanceName == MapDuo.className) {
            MapDuo duo = item; 
            if (duo.oneKey.equals(key)) {
                duo.oneValue = value;
                return;
            } else if(duo.twoKey.equals(key)) {
                duo.twoValue = value;
                return;
            }

            // only allow 2 key collisions
            reHash(key, value);
            return;
        } else if (item.instanceName == MapEntry.className) {
            MapEntry entry = item;
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            } else {
                ?duo = MapDuo();
                duo.oneKey = entry.key;
                duo.oneValue = entry.value;
                duo.twoKey = key;
                duo.twoValue = value;
                tempList[index] = duo;
                hmitems++;
                return;
            }
        }
        throwException(`you shouldnt be here.`);
    }

    /**
    Unconditional put
    */
    public void put(Object key, Object value) {
        if (!this.isInitm) {
            startuphm();
        }

        internalPut(this.hmlist, key, value);
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
