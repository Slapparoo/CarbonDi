// Core.Object Signature compiled
/* imports {} */

public class signature Core.Object{
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
}// Core.HashCode Signature compiled
/* imports {} */

public class signature Core.HashCode(Core.Object){
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static i32 calcFastHash(pointer p, u64 length);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
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
    (public,public) pointer instanceName;
  }

  private Array();
  public Array(u64 capacity, int dataType, u64 dataSize);
  public Array(u64 capacity, int dataType, u64 dataSize, pointer values);

public pointer get(u64 b);
public void set(u64 b, pointer c);
public u64 memsize();
public pointer typename();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
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
    (public,public) pointer instanceName;
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
public pointer asStr();
public void printTo(pointer stream);
public String asString();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer objectData();
public final pointer realloc(pointer ptr, u64 size);
}// Core.String Signature compiled
/* imports {} */

public class signature Core.String(Core.Object){
  (public,public) properties {
    (public,public) pointer value;
    (public,public) i32 hash;
    (public,public) pointer instanceName;
  }

  private String();
  public String(pointer str);
  public String(pointer str, boolean staticAlloc);
  public String(pointer str, pointer str2);
  public String(pointer str, u64 offset, u64 len);

public String asString();
public u64 length();
public void println();
public String appendStr(pointer str);
public String append(String string);
public String prependStr(pointer str4);
public String prepend(String string1);
public i64 compareStr(pointer str5);
public boolean compareSubStr(pointer str6, u64 offset);
public i8 getChar(u64 offset);
public boolean isSubStr(pointer str7, u64 offset);
public i64 compare(String string5);
public i64 findStr(i64 from, pointer str6);
public i64 find(i64 from, String string6);
public boolean equals(String other);
public void trunc(i64 start, i64 end);
public pointer asStr();
public i32 hashCode();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Exception Signature compiled
/* imports {} */

public class signature Core.Exception(Core.Object){
  (public,public) properties {
    (public,public) String message;
    (public,public) Exception root;
    (public,public) pointer instanceName;
  }

  private Exception();
  public Exception(Exception root, String message);
  public Exception(String message);

public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
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
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static i32 getSizeBytes(i32 type);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.BaseBoxing Signature compiled
/* imports {} */

public class signature Core.BaseBoxing(Core.Object){
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static int datatype();
public static pointer typename();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.B8 Signature compiled
/* imports {} */

public final class signature Core.B8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) b8 value;
    (public,public) pointer instanceName;
  }

  private B8();
  public B8(b8 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.U8 Signature compiled
/* imports {} */

public final class signature Core.U8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u8 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public U8(u8 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.I8 Signature compiled
/* imports {} */

public final class signature Core.I8(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i8 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public I8(i8 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.I16 Signature compiled
/* imports {} */

public final class signature Core.I16(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i16 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public I16(i16 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.U16 Signature compiled
/* imports {} */

public final class signature Core.U16(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u16 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public U16(u16 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.I32 Signature compiled
/* imports {} */

public final class signature Core.I32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i32 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public I32(i32 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.U32 Signature compiled
/* imports {} */

public final class signature Core.U32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u32 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public U32(u32 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.F32 Signature compiled
/* imports {} */

public final class signature Core.F32(Core.BaseBoxing){
  (public,public) properties {
    (public,public) f32 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public F32(f32 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.I64 Signature compiled
/* imports {} */

public final class signature Core.I64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) i64 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public I64(i64 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.U64 Signature compiled
/* imports {} */

public final class signature Core.U64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) u64 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public U64(u64 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.F64 Signature compiled
/* imports {} */

public final class signature Core.F64(Core.BaseBoxing){
  (public,public) properties {
    (public,public) f64 value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public F64(f64 value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Pointer Signature compiled
/* imports {} */

public final class signature Core.Pointer(Core.BaseBoxing){
  (public,public) properties {
    (public,public) pointer value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public Pointer(pointer value);

public static int datatype();
public static pointer typename();
public pointer asStr();
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.FileUtils Signature compiled
/* imports {} */

public final class signature Core.FileUtils(Core.Object){
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static u64 filesize(pointer fp);
public static i8[] fileread(String filename);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Charactor Signature compiled
/* imports {} */

public final class signature Core.Charactor(Core.Object){
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static boolean isLetter(i8 chr);
public static boolean isAlpha(i8 chr);
public static boolean isUpper(i8 chr);
public static boolean isLower(i8 chr);
public static boolean isAlphaNumeric(i8 chr);
public static boolean isLetterorNumber(i8 chr);
public static boolean isNumber(i8 chr);
public static boolean isFloat(i8 chr);
public static boolean isHex(i8 chr);
public static boolean isBinary(i8 chr);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.DynamicArray Signature compiled
/* imports {} */

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
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public DynamicArray(int dataType);
  public DynamicArray(int dataType, u64 dataSize);
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
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer get(u64 b);
public void set(u64 b, pointer c);
public u64 memsize();
public pointer typename();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.RefArrayList Signature compiled
/* imports {} */

public class signature Core.RefArrayList(Core.Object){
  (public,public) properties {
    (public,public) RefArray list;
    (public,public) u64 ralsize;
    (public,public) boolean isInit;
    (public,public)  static u64 growBy;
    (public,public) pointer instanceName;
  }

  /* default constructor */

private void startup();
private void growList();
public void add(Object object);
public Object get(u64 index);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Duo Signature compiled
/* imports {} */

public class signature Core.Duo(Core.Object){
  (public,public) properties {
    (public,public) Object one;
    (public,public) Object two;
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Hashset Signature compiled
/* imports {} */

public class signature Core.Hashset(Core.Object){
  (public,public) properties {
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.MapDuo Signature compiled
/* imports {} */

public class signature Core.MapDuo(Core.Object){
  (public,public) properties {
    (public,public) Object oneKey;
    (public,public) Object twoKey;
    (public,public) Object oneValue;
    (public,public) Object twoValue;
    (public,public) pointer instanceName;
  }

  /* default constructor */

public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.MapEntry Signature compiled
/* imports {} */

public class signature Core.MapEntry(Core.Object){
  (public,public) properties {
    (public,public) Object key;
    (public,public) Object value;
    (public,public) pointer instanceName;
  }

  /* default constructor */
  public MapEntry(Object key, Object value);

public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}// Core.Hashmap Signature compiled
/* imports {} */

public class signature Core.Hashmap(Core.Object){
  (public,public) properties {
    (public,public) boolean isInitm;
    (public,public) u64 hmitems;
    (public,public) u64 hmsize;
    (public,public) RefArray hmlist;
    (public,public) pointer instanceName;
  }

  /* default constructor */

private void reHash(Object key, Object value);
public void startuphm();
public Object get(Object object);
private void internalPut(RefArray refArray, Object key, Object value);
public void put(Object key, Object value);
public static final pointer className();
public static final pointer classShortName();
public static final pointer classCName();
public static final pointer classPackage();
public static final u64 objectDatasize();
public pointer asStr();
public void printTo(pointer stream);
public pointer objectData();
public i32 hashCode();
public boolean equals(Object other);
hidden final void free();
hidden void release();
public final pointer alloc(u64 size);
public final pointer realloc(pointer ptr, u64 size);
}