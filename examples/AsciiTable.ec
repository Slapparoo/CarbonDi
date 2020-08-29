/**
https://codegolf.stackexchange.com/questions/105998/recreate-the-ascii-table-as-an-ascii-table

print the ascii table ti std out
*/

?a=`Dec  Chr`;
?b=`-----------`;
printf(`%-11s|%-12s|%-11s\n-%s%s%s\n`, a ,a ,a, b, b, b);

printf(`%-5d%-6s| %-5d%-6c| %-5d%-5c\n`, 32, `Space`, 64, 64, 96, 96);
loop (33..62) {
    ?c = $a + 32;
    ?d = $a + 64;
    printf(`%-5d%-6c| %-5d%-6c| %-5d%-5c\n`, $a, $a, c, c, d, d);
}
printf(`%-5d%-6c| %-5d%-6c| %-5d%-5s\n`, 63, 63, 95, 95, 127, `DEL`);


