#include "TokenIds.ec"
#include "Lexer.ec"

Hashmap getSpecialWords () {
    ?specialWords = Hashmap();

    specialWords.put(KEYWORD_U8, U32(TOKEN_ID_U8));
    specialWords.put(KEYWORD_I8, U32(TOKEN_ID_I8));
    specialWords.put(KEYWORD_B8, U32(TOKEN_ID_B8));
    specialWords.put(KEYWORD_IF, U32(TOKEN_ID_IF));
    specialWords.put(KEYWORD_IS, U32(TOKEN_ID_IS));
    specialWords.put(KEYWORD_IN, U32(TOKEN_ID_IN));
    specialWords.put(KEYWORD_U16, U32(TOKEN_ID_U16));
    specialWords.put(KEYWORD_I16, U32(TOKEN_ID_I16));
    specialWords.put(KEYWORD_U32, U32(TOKEN_ID_U32));
    specialWords.put(KEYWORD_I32, U32(TOKEN_ID_I32));
    specialWords.put(KEYWORD_F32, U32(TOKEN_ID_F32));
    specialWords.put(KEYWORD_U64, U32(TOKEN_ID_U64));
    specialWords.put(KEYWORD_I64, U32(TOKEN_ID_I64));
    specialWords.put(KEYWORD_F64, U32(TOKEN_ID_F64));
    specialWords.put(KEYWORD_F80, U32(TOKEN_ID_F80));
    specialWords.put(KEYWORD_NUM, U32(TOKEN_ID_NUM));
    specialWords.put(KEYWORD_INT, U32(TOKEN_ID_INT));
    specialWords.put(KEYWORD_TRY, U32(TOKEN_ID_TRY));
    specialWords.put(KEYWORD_F128, U32(TOKEN_ID_F128));
    specialWords.put(KEYWORD_NULL, U32(TOKEN_ID_NULL));
    specialWords.put(KEYWORD_ELSE, U32(TOKEN_ID_ELSE));
    specialWords.put(KEYWORD_LOOP, U32(TOKEN_ID_LOOP));
    specialWords.put(KEYWORD_WITH, U32(TOKEN_ID_WITH));
    specialWords.put(KEYWORD_CASE, U32(TOKEN_ID_CASE));
    specialWords.put(KEYWORD_VOID, U32(TOKEN_ID_VOID));
    specialWords.put(KEYWORD_ENUM, U32(TOKEN_ID_ENUM));
    specialWords.put(KEYWORD_PLAN, U32(TOKEN_ID_PLAN));
    specialWords.put(KEYWORD_STUB, U32(TOKEN_ID_STUB));
    specialWords.put(KEYWORD_TRUE, U32(TOKEN_ID_TRUE));
    specialWords.put(KEYWORD_BOOLEAN, U32(TOKEN_ID_BOOLEAN));
    specialWords.put(KEYWORD_POINTER, U32(TOKEN_ID_POINTER));
    specialWords.put(KEYWORD_PUBLIC, U32(TOKEN_ID_PUBLIC));
    specialWords.put(KEYWORD_PRIVATE, U32(TOKEN_ID_PRIVATE));
    specialWords.put(KEYWORD_PROTECTED, U32(TOKEN_ID_PROTECTED));
    specialWords.put(KEYWORD_HIDDEN, U32(TOKEN_ID_HIDDEN));
    specialWords.put(KEYWORD_IMPORTS, U32(TOKEN_ID_IMPORTS));
    specialWords.put(KEYWORD_CATCH, U32(TOKEN_ID_CATCH));
    specialWords.put(KEYWORD_FINALLY, U32(TOKEN_ID_FINALLY));
    specialWords.put(KEYWORD_THROWS, U32(TOKEN_ID_THROWS));
    specialWords.put(KEYWORD_BREAK, U32(TOKEN_ID_BREAK));
    specialWords.put(KEYWORD_CONTINUE, U32(TOKEN_ID_CONTINUE));
    specialWords.put(KEYWORD_SWITCH, U32(TOKEN_ID_SWITCH));
    specialWords.put(KEYWORD_DEFAULT, U32(TOKEN_ID_DEFAULT));
    specialWords.put(KEYWORD_RETURN, U32(TOKEN_ID_RETURN));
    specialWords.put(KEYWORD_RETURN_ADD, U32(TOKEN_ID_RETURN_ADD));
    specialWords.put(KEYWORD_STATIC, U32(TOKEN_ID_STATIC));
    specialWords.put(KEYWORD_FINAL, U32(TOKEN_ID_FINAL));
    specialWords.put(KEYWORD_SIGNATURE, U32(TOKEN_ID_SIGNATURE));
    specialWords.put(KEYWORD_CLASS, U32(TOKEN_ID_CLASS));
    specialWords.put(KEYWORD_PROPERTIES, U32(TOKEN_ID_PROPERTIES));
    specialWords.put(KEYWORD_FUNCTION, U32(TOKEN_ID_FUNCTION));
    specialWords.put(KEYWORD_FALSE, U32(TOKEN_ID_FALSE));

    return specialWords;
}

?content = FileUtils.fileread("Lexer.ec");
?lex = Lexer();
lex.lex(content, getSpecialWords());

String str1 = String(content.values);
printf(`matched? %c\n`, str1.getChar(2));
printf(`matched? %i\n`, str1.isSubStr(`public`, 2));

?myU32 = U32(20);
printf(`%s %i\n`, myU32.asStr, myU32.value);