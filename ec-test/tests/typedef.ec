protected class test.SimpleObject1 (Core.Object) {
    properties {
        i64 number;
        String name;
    }

    SimpleObject1(=number, =name) {}

    i64 addNumber(i64 number2) {
        return number + number2 + this.number;
    }
}

?mySimpleObject = SimpleObject1(55, "Name");
testStrEqual(`mySimpleObject.name 1`, `Name`, mySimpleObject.name.asStr());
testi64Equal(`mySimpleObject.number 1`, 55, mySimpleObject.number);
mySimpleObject.name = "mySimpleObject message";
mySimpleObject.number = 10;
testi64Equal(`mySimpleObject.number 2`, 10, mySimpleObject.number);


pointer str1 = `yo`;
?name = "ma name";
printf(`mySimpleObject.name %s\n`, str1);
printf(`%s %s %s\n`, str1, mySimpleObject.name.asString().asStr(), name.asStr());

testStrEqual(`str1`, `yo`, str1);
testStrEqual(`name`, `ma name`, name.asStr());
testStrEqual(`mySimpleObject.name`, `mySimpleObject message`, mySimpleObject.name.asStr());
