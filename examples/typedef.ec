public class signature Core.Object {
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
}

public class signature Core.String(Core.Object){
  (public,public) properties {
    (public,public) pointer value;
  }

  hidden String();
  public String(pointer value);
  // public String(pointer value, pointer str2);

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


protected class Default.SimpleObject1 (Core.Object) {
    properties {
        i64 number;
        String name;
    }

    SimpleObject1(=number, =name) {}

    // static i64 constNumber() {
    //     return 10;
    // }

    i64 addNumber(i64 number2) {
        return number + number2 + this.number;
    }
}

@mySimpleObject = SimpleObject1(55, "Name");
testStrEqual(`mySimpleObject.name 1`, `Name`, mySimpleObject.name.asStr());
testi64Equal(`mySimpleObject.number 1`, 55, mySimpleObject.number);
mySimpleObject.name = "mySimpleObject message";
mySimpleObject.number = 10;
testi64Equal(`mySimpleObject.number 2`, 10, mySimpleObject.number);


pointer str1 = `yo`;
@name = "ma name";
printf(`mySimpleObject.name %s\n`, str1);
printf(`%s %s %s\n`, str1, mySimpleObject.name.asString().asStr(), name.asStr());

testStrEqual(`str1`, `yo`, str1);
testStrEqual(`name`, `ma name`, name.asStr());
testStrEqual(`mySimpleObject.name`, `mySimpleObject message`, mySimpleObject.name.asStr());
