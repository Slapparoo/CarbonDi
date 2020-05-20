// test.Class1 Signature compiled
/* imports {} */

public class signature test.Class1(Core.Object){
  (public,public) properties {
    (public,public) i64 count1;
    (public,public) i64 count2;
  }

  /* default constructor */
  public Class1(i64 count1);

public static i64 constNumber();
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
}// test.Class2 Signature compiled
/* imports {} */

public final class signature test.Class2(test.Class1){
  (public,public) properties {
    (public,public) String package;
    (public,public) i64 count1;
    (public,public) i64 count2;
  }

  /* default constructor */
  public Class2(i64 count1);
  public Class2(i64 count1, String package);

public i64 length();
public void myPrint();
public i64 addto(i64 amount);
public static final pointer getClassName();
public static final pointer getClassShortName();
public static final pointer getClassCName();
public static final pointer getClassPackage();
public static final u64 getObjectDatasize();
public static i64 constNumber();
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