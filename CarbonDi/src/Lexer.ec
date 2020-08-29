

public class Token (Core.Object) {
    properties {
        u64 offset;
        u64 length;
        u32 type;
    }

    public Token(=offset, =length, =type) {
        // printf(`Token(%lu, %lu, %u)`, offset, length, type);
    }

    public void printDetail() {
        printf(`Token(%lu, %lu, %u)`, offset, length, type);
    }
}

/**
    Lexer
*/
public class Lexer (Core.Object) {

    properties {
        i8 iChar0 = 0;
        i8 iChar1 = 0;
        i8 iChar2 = 0;

        u64 lineCount = 0;
        u64 lineIndex = 0;
        u64 index = 0;

        Hashmap specialWordsmap;
    }

    void loadSpecialWords () {
        if (specialWordsmap != 0) {
            return;
        }

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

        specialWordsmap = specialWords;
    }


    public void forward(i8 ch) {
        iChar0 = iChar1;
        iChar1 = iChar2;
        iChar2 = ch;
        index++;

        switch (ch) {
            case '\n' : // <CR>
            case '\r' : // <LF>
                lineCount++;
                lineIndex=0;
        }
    }

    public void printToken(Token token, i8[] content) {
        ?ix = token.offset;
        token.printDetail();
        loop (token.length) {
            ?off = $a + ix;
            printf(`%c`, content[off]);
        }
    }

    public Token createToken(u64 length, u32 tokenId) {
        return Token(index - length - 2, length, tokenId);
    }

    public static boolean isWhitespace(i8 ch) {
        ?isWs = false;
        switch (ch) {
            case ' ' :
            case 10 :
            case 13 :
            case 7 :
            case 9 :
            case 0 :
            isWs = true;
        }
        return isWs;
    }

    /**
      check for valid char continuation
    */
    public static boolean isChar(i8 ch) {
        ?isChar = false;
        switch (ch) {
            case 'a'..'z' :
            case 'A'..'Z' :
            case '0'..'9' :
            case '_' :
            isChar = true;
        }
        return isChar;
    }

    /**
      check for valid number continuation on 2nd char 
    */
    public static boolean is2ndNum(i8 ch) {
        ?isNum = false;
        switch (ch) {
            case '0'..'9' :
            case '_' :
                isNum = true;
        }
        return isNum;
    }

    public u32 matchKeywordToken(i8[] content, u64 len, u64 ix) {
        String subString = String(content.values, ix - len - 1, len);

        // printf(`substring %s, `, subString.asStr);

        // String subString = "return";
        ?sp = specialWordsmap;
        U32 tokenType = sp.get(subString);
        

        if (tokenType != 0) {
            printf(`found token %s:%i `, subString.asStr, tokenType.value);
        }

        return TOKEN_ID;
    }

    /* lex the content */
    public void lex(i8[] content) {
        loadSpecialWords();
        ?currentToken = 0;
        ?thisToken = 0;
        Token token;
        ?roll = 0;
        ?tokenStart = 0;

        loop (content.length) {
            forward(content[$a]);

            ?ix = $a;

            ?char0 = iChar0;
            ?char1 = iChar1;
            ?char2 = iChar2;

            // nested switch not working
            if (currentToken != 0) {
                switch (currentToken) {
                    case CURRENTTOKEN_DOCCOMMENT :
                        if (char0 == KEYWORD_STAR && char1 == KEYWORD_DIV) { 
                            currentToken = 0;
                            thisToken = TOKEN_DOC_COMMENT;
                            roll = 1;
                        }
                        break;
                     case CURRENTTOKEN_STARCOMMENT :
                        if (char0 == KEYWORD_STAR && char1 == KEYWORD_DIV) { 
                            currentToken = 0;
                            thisToken = TOKEN_BLOCK_COMMENT;
                            roll = 1;
                        }
                        break;
                    case CURRENTTOKEN_LINECOMMENT :
                        // roll forward until EOL
                        if (char0 == 10 || char0 == 13) { 
                            currentToken = 0;
                            thisToken = TOKEN_LINE_COMMENT;
                        }
                        break;
                    case CURRENTTOKEN_SQSTRING :
                        // if it spans a line thats an error
                        if (char0 == 10 || char0 == 13) { 
                            throwException (`[error] no string end (SQString).`);
                        }

                        if (char0 == 39) { 
                            currentToken = 0;
                            thisToken = TOKEN_SSTRING;
                        }
                        break;
                    case CURRENTTOKEN_DQSTRING :
                        if (char0 == 10 || char0 == 13) { 
                            throwException (`[error] no string end (DQString).`);
                        }

                        if (char0 == 34) { 
                            currentToken = 0;
                            thisToken = TOKEN_DSTRING;
                        }
                        break;
                    case CURRENTTOKEN_CSTRING :
                        // if it spans a line thats an error
                        if (char0 == 10 || char0 == 13) { 
                            throwException (`[error] no string end. (CString)`);
                        }

                        if (char0 == 96) { 
                            currentToken = 0;
                            thisToken = TOKEN_CSTRING;
                        }
                        break;
                    case CURRENTTOKEN_STRINGBLOCK :
                        printf(`@@st %lu@@`, currentToken);
                        currentToken = 0;
                        break;
                    case CURRENTTOKEN_ID :
                        if (!Lexer.isChar(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_ID;
                        }
                        break;
                    case CURRENTTOKEN_NUM :
                        // resolve float, decimal
                        if (char1 == KEYWORD_DOT) {
                            currentToken = CURRENTTOKEN_FLOAT;
                        } else if (!Charactor.isNumber(char1)) {
                            // check for l at end?
                            currentToken = 0;
                            thisToken = TOKEN_NUM;
                        }
                        break;
                    case CURRENTTOKEN_HEX :
                        // resolve hex
                        if (!Charactor.isHex(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_HEX;
                        }
                        break;
                    case CURRENTTOKEN_BIN :
                        // resolve binary
                        if (!Charactor.isBinary(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_BINARY;
                        }
                        break;
                    case CURRENTTOKEN_FLOAT :
                        // resolve float
                        if (!Charactor.isFloat(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_FLOAT;
                        }
                        break;
                    } 
                }
            else  {
                tokenStart = $a;                
                switch (char0) {
                    case KEYWORD_DIV :
                        if (char1 == KEYWORD_DIV) {
                            currentToken = CURRENTTOKEN_LINECOMMENT;
                        } else if (char1 == KEYWORD_STAR) {
                            if (char2 == KEYWORD_STAR) {
                                currentToken = CURRENTTOKEN_DOCCOMMENT;
                            } else {
                                currentToken = CURRENTTOKEN_STARCOMMENT;
                            }
                        } else {
                            // is div
                            // token = div
                        }
                        break;
                    // comment = true;
                    case 34 : // "
                        currentToken = CURRENTTOKEN_DQSTRING;
                        break;    
                    case 96 : // `
                        currentToken = CURRENTTOKEN_CSTRING;
                        break;    
                    case 39 : // '
                        if (char1 == 39 && char2 == 39) {
                            currentToken = CURRENTTOKEN_STRINGBLOCK;
                        } else {
                            currentToken = CURRENTTOKEN_SQSTRING;
                        }
                        break;  
                    // length 2 special
                    // length 3 special
                    // special tokens +=-*&^%$#@!~(){}[]:;<>,.?
                    // compound special
                    case KEYWORD_EQUAL : 
                        if (char1 == KEYWORD_EQUAL) { 
                            if (char2 == KEYWORD_EQUAL) { //===
                                roll = 2;
                                thisToken = TOKEN_EQUALEQUAL;
                            } else { //==
                                roll = 1;
                                thisToken = TOKEN_EQUAL;
                            }
                        } else if (char1 == KEYWORD_GT) { //=>
                            roll = 1;
                            thisToken = TOKEN_LAMBDA;
                        } else {
                            thisToken = TOKEN_ASSIGN;
                        }
                        
                        break;
                    case KEYWORD_GT :
                        if (char1 == KEYWORD_EQUAL) { //>=
                            thisToken = TOKEN_GTE;
                            roll = 1;
                        } else if (char1 == KEYWORD_GT) { //>>
                            thisToken = TOKEN_SHR;
                            roll = 1;
                        } else  {
                            thisToken = TOKEN_GT;
                        }
                        break;
                    case KEYWORD_LT :
                        if (char1 == KEYWORD_EQUAL) { //<=
                            thisToken = TOKEN_LTE;
                            roll = 1;
                        } else if (char1 == KEYWORD_LT) { //<<
                            thisToken = TOKEN_SHL;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_LT;
                        }
                        break;
                    case KEYWORD_NOT :
                        if (char1 == KEYWORD_EQUAL) { //!=
                            thisToken = TOKEN_NEQ;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_NOT;
                        }
                        break;
                    case KEYWORD_AND :
                        if (char1 == KEYWORD_EQUAL) { //&=
                            thisToken = TOKEN_AEQ;
                            roll = 1;
                        } else if (char1 == KEYWORD_AND) { //&&
                            thisToken = TOKEN_ANDAND;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_AND;
                        }
                        break;
                    case KEYWORD_TILDE :
                        if (char1 == KEYWORD_EQUAL) { //~=
                            thisToken = TOKEN_XEQ;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_XOR;
                        }
                        break;
                    case KEYWORD_OR :
                        if (char1 == KEYWORD_EQUAL) { //|=
                            thisToken = TOKEN_OEQ;
                            roll = 1;
                        } else if (char1 == KEYWORD_OR) { //||
                            thisToken = TOKEN_OROR;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_OR;
                        }
                        break;
                    case KEYWORD_PLUS :
                        if (char1 == KEYWORD_EQUAL) { //+=
                            thisToken = TOKEN_PLUSEQUAL;
                            roll = 1;
                        } else if (char1 == KEYWORD_PLUS) { //++
                            thisToken = TOKEN_PLUSPLUS;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_PLUS;
                        }
                        break;
                    case KEYWORD_STAR :
                        if (char1 == KEYWORD_EQUAL) { //*=
                            thisToken = TOKEN_STAREQUAL;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_STAR;
                        }
                        break;
                    case KEYWORD_MINUS :
                        if (char1 == KEYWORD_EQUAL) { //-=
                            thisToken = TOKEN_MINUSEQUAL;
                            roll = 1;
                        } else if (char1 == KEYWORD_MINUS) { //--
                            thisToken = TOKEN_MINUSMINUS;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_MINUS;
                        }
                        break;
                    case KEYWORD_MOD :
                        if (char1 == KEYWORD_EQUAL) { //%=
                            thisToken = TOKEN_MODEQUAL;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_MOD;
                        }
                        break;
                    case KEYWORD_DOT :
                        if (char1 == KEYWORD_DOT) { //..
                            thisToken = TOKEN_DOTDOT;
                            roll = 1;
                        } else {
                            thisToken = TOKEN_DOT;
                        }
                        break;
                    // 1 length special
                    case KEYWORD_VAR_TYPE :
                        thisToken = TOKEN_QUESTION;
                        break;
                    case KEYWORD_LBRACE :
                        thisToken = TOKEN_LBRACE;
                        break;
                    case KEYWORD_RBRACE :
                        thisToken = TOKEN_RBRACE;
                        break;
                    case KEYWORD_LPAREN :
                        thisToken = TOKEN_LPAREN;
                        break;
                    case KEYWORD_RPAREN :
                        thisToken = TOKEN_RPAREN;
                        break;
                    case KEYWORD_LBRACKET :
                        thisToken = TOKEN_LBRACKET;
                        break;
                    case KEYWORD_RBRACKET :
                        thisToken = KEYWORD_RBRACKET;
                        break;
                    case KEYWORD_SEMI :
                        thisToken = TOKEN_SEMI;
                        break;
                    case KEYWORD_COLON :
                        thisToken = TOKEN_COLON;
                        break;
                    case KEYWORD_CARET :
                        thisToken = TOKEN_CARET;
                        break;
                    case KEYWORD_HASH :
                        thisToken = TOKEN_HASH;
                        break;
                    case KEYWORD_COMMA :
                        thisToken = TOKEN_COMMA;
                        break;
                    case KEYWORD_DOLLAR :
                        thisToken = TOKEN_DOLLAR;
                        break;
                    case 'a'..'z' :
                    case 'A'..'Z' :
                        currentToken = CURRENTTOKEN_ID;
                        if (!Lexer.isChar(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_ID;
                        }

                        break;
                    case '0' :
                        if (char1 == `B` || char1 == `b`) { // binary num
                            currentToken = CURRENTTOKEN_BIN;    
                            roll = 1;
                        } else if (char1 == `X` || char1 == `x`) { // hex
                            currentToken = CURRENTTOKEN_HEX;    
                            roll = 1;
                        } else if (char1 == KEYWORD_DOT) { // float
                            currentToken = CURRENTTOKEN_FLOAT;    
                        } else {
                            currentToken = CURRENTTOKEN_NUM;

                            // check for 1 length
                            // valid 2nd char combinations
                            if (!Lexer.is2ndNum(char1)) {
                                currentToken = 0;
                                thisToken = TOKEN_DECIMAL;
                            }
                        }
                        break;
                    case '1'..'9' :
                        currentToken = CURRENTTOKEN_NUM;
                        // check for 1 length
                        // valid 2nd char combinations
                        if (!Lexer.is2ndNum(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_DECIMAL;
                        }
                        break;
                    default :
                        if (!Lexer.isWhitespace(char0)) {
                            printf(`%c (%lu) [%lu:%lu]`, char0, index, lineCount, lineIndex);  
                            throwException(`[error] unexpected charactor.`);
                        }
                }
            }

            loop (roll) {
                ix++;
                forward(content[ix]);
            }
            $a += roll;
            roll = 0;

            if (thisToken != 0) {
                ?tLen = ix - tokenStart + 1;

                if (thisToken == TOKEN_ID) {
                    // convert ID tokens to keyword tokens
                    thisToken = matchKeywordToken(content, tLen, ix);
                }
                
                ?tk = createToken(tLen, thisToken);

                if (thisToken == TOKEN_ID || thisToken == TOKEN_HEX || thisToken == TOKEN_BINARY || thisToken == TOKEN_CSTRING) {
                    printToken(tk, content);
                    printf(`--\n`);
                }
                thisToken = 0;
            }
        }

        printf(`\nlinecount=%lu\n`, lineCount);
    }
}


