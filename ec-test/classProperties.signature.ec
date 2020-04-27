// Default.MyClass Signature compiled
/* imports {} */

public class signature Default.MyClass(Core.Object){
  (public,public) properties {
    (public,public) String name;
    (public,public) i64 value;
    (public,public) i64 value2;
  }

  /* default constructor */
  public MyClass(i64 value);

  public void myPrint();
  hidden void release();
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
  public final pointer alloc(u64 size);
}// Default.MySecondClass Signature compiled
/* imports {} */

public class signature Default.MySecondClass(Default.MyClass){
  (public,public) properties {
    (public,public) String name;
    (public,public) i64 value;
    (public,public) i64 value2;
  }

  /* default constructor */
  public MySecondClass(i64 value);
  public MySecondClass(i64 value, String name);

  hidden void release();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public void myPrint();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  public final pointer alloc(u64 size);
}// Default.MyOtherClass Signature compiled
/* imports {} */

public class signature Default.MyOtherClass(Core.Object){
  (public,public) properties {
    (public,public) MyClass myClass;
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
}