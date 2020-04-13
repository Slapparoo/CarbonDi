@str1 = `string`;
@str2 = "string";
@str3 = 'string';
@str3a = '"string';
@str4 = '''
"string"
\n then some \t
''';

@str4a = '''
"string"
\n then some \t
''';


pointer getfunction() {
    return `string`;
}

printf(`a string %s\n`, getfunction());
printf(`Str4 %s\n`, str4.asStr());
printf(`Str1 %s\n`, str1);