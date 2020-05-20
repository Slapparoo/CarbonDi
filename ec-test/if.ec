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
}?always = true;
?never = false;
?sometimes = 10;
?sometimesfloat = 10.10;


boolean isTrue() {
    return true;
}

boolean isFalse() {
    return false;
}

if (always) {
    External.stdio.printf(`always (good)\n`);
} else {
    External.stdio.printf(`always (bad)\n`);
}

if (sometimes || always) {
    External.stdio.printf(`sometimes (good) \n`);
} else {
    External.stdio.printf(`sometimes (bad)\n`);
}

if (never) {
    External.stdio.printf(`never (bad)\n`);
} else {
    External.stdio.printf(`never (good)\n`);
}

if (isTrue()) {
    External.stdio.printf(`tis true (good)\n`);
} else {
    External.stdio.printf(`tis true (bad)\n`);
}

if (isFalse()) {
    External.stdio.printf(`tis false (bad)\n`);
} else {
    External.stdio.printf(`tis false (good)\n`);
}

if (isTrue() && true) {
    External.stdio.printf(`tis true to (good)\n`);
} else {
    External.stdio.printf(`tis true to (bad)\n`);
}

if (isTrue() && false) {
    External.stdio.printf(`tis false to (bad)\n`);
} else {
    External.stdio.printf(`tis false to (good)\n`);
}


if (!isTrue()) {
    External.stdio.printf(`if else !true (bad)\n`);
} else if (isFalse()) {
    External.stdio.printf(`if else false (bad)\n`);
} else {
    External.stdio.printf(`if else (good)\n`);
}


External.stdio.printf(`end\n`);