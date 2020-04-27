// Core::Object Signature compiled
/* imports {} */

public class signature Core.Object {

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
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
}// Core::String Signature compiled
/* imports {} */

public class signature Core.String(Core.Object){
  (public,public) properties {
    (public,public) pointer value;
  }

  hidden String();
  public String(pointer value);
  public String(pointer value, pointer str2);

  public pointer asStr();
  public String asString();
  public static final pointer getClassName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public final pointer getObjectData();
  public void printTo(pointer stream);
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}// Core::Array Signature compiled
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