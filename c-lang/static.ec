// Core::Object Signature compiled
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
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
}// Core::String Signature compiled
/* imports {} */

public class signature Core.String(Object){
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

public class signature Core.Array(Object){
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

public class signature Core.RefArray(Array){
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
}protected class SimpleObject {
    properties {
        i64 count1 = 12;
        i64 count3 = 27;
        static i64 count2 = 51;
    }

    SimpleObject(=count1) {}

    static i64 constNumber() {
        return 66;
    }
}

@simpleObject = SimpleObject(11);
printf(`count1(11)=%li, count2(51)=%li, count3(27)=%li, constNumber(66)=%li\n`, simpleObject.count1, simpleObject.count2, simpleObject.count3, SimpleObject.constNumber());

testi64Equal(`simpleObject.count1 1`, 11, simpleObject.count1);
testi64Equal(`simpleObject.count2 1`, 51, simpleObject.count2);
testi64Equal(`simpleObject.count3 1`, 27, simpleObject.count3);
testi64Equal(`simpleObject.constNumber() 1`, 66, simpleObject.constNumber());

simpleObject.count1 = 99;
SimpleObject.count2 = 33;

printf(`count1(99)=%li, count2(33)=%li, count3(33)=%li, constNumber(66)=%li\n`, simpleObject.count1, simpleObject.count2, simpleObject.count3, SimpleObject.constNumber());

testi64Equal(`simpleObject.count1 2`, 99, simpleObject.count1);
testi64Equal(`simpleObject.count2 2`, 33, simpleObject.count2);
testi64Equal(`simpleObject.count3 2`, 27, simpleObject.count3);
testi64Equal(`simpleObject.constNumber() 2`, 66, simpleObject.constNumber());


testi64Equal(`SimpleObject.count2 3`, 33, SimpleObject.count2);
testi64Equal(`SimpleObject.constNumber() 3`, 66, SimpleObject.constNumber());
