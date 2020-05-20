final class myI8 {
  properties {
    i8 value; 
  }

  public myI8(=value) {}

  static int datatype() {
      return 1;
  }

  static i8 max() {
      return 127;
  }

  static i8 min() {
      return -128;
  }

  static pointer typename() {
    return `u8`;
  }

  pointer summaryStr() {
    sprintf(getTmpBuffer(), `(%s::%s) datatype=%i, typename=%s, range=%i..%i, value=%i`, this.getPackage(), this.getName(), this.datatype(), this.typename(), this.min(), this.max(), this.value);
    return getTmpBuffer();      
  }

  pointer myasStr() {
    sprintf(getTmpBuffer(), `%i`, this.value);
    return getTmpBuffer();      
  }
};

i8 value = 12;
i8 value2 = 129;
?number1 = myI8(value);
?number2 = myI8(value2);

External.stdio.printf(`number1=%s\n`, number1.myasStr());
External.stdio.printf(`%s\n`, number1.summaryStr());
External.stdio.printf(`%s\n`, number2.summaryStr());
