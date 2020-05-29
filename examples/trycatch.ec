
try {
    External.stdin.println(`Hello`);
} catch (Exception) {
    External.stdin.println(`%s`, $a.message);
}

/*
addTry(Exception);
...
if (Exception) {
...
} 
removeTry();

// on catch remove head of stack
*/


