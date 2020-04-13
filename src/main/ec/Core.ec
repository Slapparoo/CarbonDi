namespace Core;

public class Object {
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


// class String {
//     (public, private)properties {
//         (public, private) pointer value;
//     }

//     /**
//     * DefaULT
//     */
//     String(=value) {
//         num len = strlen(value) + 1;
//         this.value = alloc(len);
//         strcpy(this.value, value);
//     }

//     /**
//     * String Concatenation
//     */
//     String(=value, pointer str2) {
//         num len = strlen(value) + strlen(str2) + 1;
//         this.value = alloc(len);
//         strcpy(this.value, value);
//         strcat(this.value, str2);
//     }

//     hidden String();

//     pointer asStr() {
//         return value;
//     }

//     String asString() {
//         return this;
//     }
// }

// public class Exception {
//     (public, private) properties {
//         String message;
//     }
//     private Exception();
//     public Exception(=message);
// }


  // u64 (*length)(num); \
  // u64 (*capacity)(num); \
  // pointer (*array)(num); \
  // primative_types (*type)(num); \
  // pointer (*typename)(num); \
  // pointer (*get)(num, u64); \
  // void (*set)(num, u64, pointer); \
  // u64 (*memsize)(num); \
  // void (*setObject)(num, u64, num); 


  // pointer array;
  // u64 length;
  // u64 capacity;
  // primative_types type;
  // u64 dataSize;
  // boolean managed;


// public class Array {
//   (public, private) properties {
//     pointer values;
//     u64 length;
//     u64 capacity;
//     int dataType;
//     u64 dataSize;
//     // u64 memsize;
//     // pointer typename;
//     boolean managed;
//   }

//   hidden Array();
//   public Array(=capacity, =dataType, =dataSize) {
//     this.managed = true;
//   }
//   // unmanaged
//   public Array(=capacity, =dataType, =dataSize, =values) {
//     this.managed = false;
//   }

//   pointer get(u64 b) {return null;}

//   void set(u64 b, pointer c) {}
//   u64 memsize() {return capacity;}
//   pointer typename() {return `u8`;}
// }

// public class RefArray(Array) {
//   public RefArray(=length);
//   hidden RefArray(=capacity, =dataType, =dataSize);
//   hidden RefArray(=capacity, =dataType, =dataSize, =values);

//   void setObject(u64 index, num object) {}
// }

// public class DynamicArray (Array) {
//   pointer get(num b);
//   void set(num b, pointer c);
//   void setObject(num b, num c);
// }

// stub Boxing {
//    /* primative_types */
//   static int datatype();
//   static pointer typename(); 
// };

// /**
// * b8 otherwise known as boolean
// */

// final class B8 (Boxing) {
//   properties {
//     b8 value; 
//   }

//   private B8();

//   static int datatype() {
//     return _b8;
//   }

//   static pointer typename() {
//       return `b8`;
//   }

//   public B8(=value) {}

//   // pointer asStr() {
//   //   // if (this.value) {
//   //     return `true`;
//   //   // } else {
//   //   //   return `false`;
//   //   // }
//   // };
// };

// final class U8 (Boxing) {
//   properties {
//     u8 value; 
//   }

//   static int datatype() {
//       return _u8;
//   }

//   static pointer typename() {
//     return `u8`;
//   }

//   public U8(=value) {}

//   pointer asStr() {
//     sprintf(tmpbuffer, `%u`, this.value);
//     return tmpbuffer;      
//   }
// };

// final class I8 (Boxing) {
//   properties {
//     i8 value; 
//   }

//   public I8(=value) {}

//   static int datatype() {
//       return _u8;
//   }

//   static pointer typename() {
//     return `u8`;
//   }

//   pointer asStr() {
//     sprintf(tmpbuffer, `%i`, this.value);
//     return tmpbuffer;      
//   }
// };

// class I16 (Boxing) {
//   properties {
//     i16 value; 
//   }
// };

// class U16 (Boxing) {
//   properties {
//     u16 value; 
//   }
// };

// class I32 (Boxing) {
//   properties {
//     i32 value; 
//   }
// };

// class U32 (Boxing) {
//   properties {
//     u32 value; 
//   }
// };

// class F32 (Boxing) {
//   properties {
//     f32 value; 
//   }
// };

// class I64 (Boxing) {
//   properties {
//     i64 value; 
//   }
// };

// class U64 (Boxing) {
//   properties {
//     u64 value; 
//   }
// };

// class F64 (Boxing) {
//   properties {
//     f64 value; 
//   }
// };

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
