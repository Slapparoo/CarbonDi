?myTrue = true;
?myFalse = false;
?myi64 = 10;
?myf64 = 10.10;

int i = 20;
int ii = -20;

printf(`myTrue %i\n`, myTrue);
printf(`myFalse %i\n`, myFalse);

printf(`myi64 %li\n`, myi64);
printf(`myf64 %lf\n`, myf64);

?myTrueOjb = B8(myTrue);
?myTrueOjb2 = B8(i);
?myFalseOjb = B8(myFalse);
?myInt2 = I32(ii);

printf(`myTrueObj %s\n`, myTrueOjb.asStr);
printf(`myTrueObj2 %s\n`, myTrueOjb2.asStr);
printf(`myfalseObj %s\n`, myFalseOjb.asStr);
printf(`myInt2 %s\n`, myInt2.asStr);

?myf64Obj = F64(myf64);
printf(`myf64Obj %s\n`, myf64Obj.asStr);

?myf64Obj2 = F64(myi64);
printf(`myf64Obj2 %s\n`, myf64Obj2.asStr);

