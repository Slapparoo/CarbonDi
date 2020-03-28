namespace std.library ;

protected final class SimpleObject (Object) {
    properties {
        num count1;
        String package;
    }

    void myPrint() {
        printf("(SimpleObject) package=%s, count1=%ld, length=%ld\n", String_asStr(this.package), this.count1, this.length());
    }

    num length() {
        return 0b_111;
    }

    num addto(num amount) {
        return amount + this.count1;
    }
}


@simpleObject = SimpleObject();
simpleObject.length();
simpleObject.package = String("Simple String");
simpleObject.count1 = 0x_01;
@count = 4 + simpleObject.addto(5);
simpleObject.count1 = 10 + simpleObject.addto(5) + count;

simpleObject.myPrint();

