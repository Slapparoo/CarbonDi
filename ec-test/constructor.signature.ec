// Default.MyString Signature compiled
/* imports {} */

public class signature Default.MyString(Core.Object){
  (public,public) properties {
    (public,public) pointer value;
  }

  private MyString();
  public MyString(pointer str1);
  public MyString(pointer str2, pointer str3);

  public pointer asStr();
  public String asString();
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
}