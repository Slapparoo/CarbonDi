// Default::SimpleObject Signature compiled
/* imports {} */

public class signature Default.SimpleObject(Object){
  (public,public) properties {
    (public,public) i64 count1;
    (public,public) i64 count3;
    (public,public)  static i64 count2;
  }

  /* default constructor */
  public SimpleObject(i64 count1);

  public static i64 constNumber();
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
}