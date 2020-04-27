// test.SimpleObject1 Signature compiled
/* imports {} */

public class signature test.SimpleObject1(Core.Object){
  (public,public) properties {
    (public,public) i64 number;
    (public,public) String name;
  }

  /* default constructor */
  public SimpleObject1(i64 number, String name);

  public i64 addNumber(i64 number2);
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