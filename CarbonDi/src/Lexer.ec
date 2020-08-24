
#include "TokenIds.ec"

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
public class Lex (Core.Object) {

    properties {
        i8 iChar0 = 0;
        i8 iChar1 = 0;
        i8 iChar2 = 0;

        u64 lineCount = 0;
        u64 lineIndex = 0;
        u64 index = 0;
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

    public u32 matchKeywordToken(u64 len, u64 ix) {
        // return Token(index - length, length, tokenId);
        // ?ix = token.offset - 2;
        return TOKEN_ID;
    }

    /* lex the content */
    public void lex(i8[] content) {
        ?currentToken = 0;
        ?thisToken = 0;
        Token token;
        ?roll = 0;
        ?tokenStart = 0;

        // addToken(5, 1030);

        loop (content.length) {
            forward(content[$a]);

            ?ix = $a;

            ?char0 = iChar0;
            ?char1 = iChar1;
            ?char2 = iChar2;

            // printf(`@%lu,%c@`, currentToken, char0);

            if (currentToken == CURRENTTOKEN_DOCCOMMENT) {
                if (char0 == KEYWORD_STAR && char1 == KEYWORD_DIV) { 
                    currentToken = 0;
                    thisToken = TOKEN_DOC_COMMENT;
                    roll = 1;
                }
            } else if (currentToken == CURRENTTOKEN_STARCOMMENT) {
                if (char0 == KEYWORD_STAR && char1 == KEYWORD_DIV) { 
                    currentToken = 0;
                    thisToken = TOKEN_BLOCK_COMMENT;
                    roll = 1;
                }
            } else if (currentToken == CURRENTTOKEN_LINECOMMENT) {
                // roll forward until EOL
                if (char0 == 10 || char0 == 13) { 
                    currentToken = 0;
                    thisToken = TOKEN_LINE_COMMENT;
                }
            } else if (currentToken == CURRENTTOKEN_SQSTRING) {
                // if it spans a line thats an error
                if (char0 == 10 || char0 == 13) { 
                    throwException (`[error] no string end (SQString).`);
                }

                if (char0 == 39) { 
                    currentToken = 0;
                    thisToken = TOKEN_SSTRING;
                }
            } else if (currentToken == CURRENTTOKEN_DQSTRING) {
                if (char0 == 10 || char0 == 13) { 
                    throwException (`[error] no string end (DQString).`);
                }

                if (char0 == 34) { 
                    currentToken = 0;
                    thisToken = TOKEN_DSTRING;
                }
            } else if (currentToken == CURRENTTOKEN_CSTRING) {
                // if it spans a line thats an error
                if (char0 == 10 || char0 == 13) { 
                    throwException (`[error] no string end. (CString)`);
                }

                if (char0 == 96) { 
                    currentToken = 0;
                    thisToken = TOKEN_CSTRING;
                }
            } else if (currentToken == CURRENTTOKEN_STRINGBLOCK) {
                printf(`@@st %lu@@`, currentToken);
                currentToken = 0;
            } else if (currentToken == CURRENTTOKEN_ID) {
                // printf(`%c`, char0);
                if (!isChar(char1)) {
                    // printf(` \n`);
                    currentToken = 0;
                    thisToken = TOKEN_ID;
                }
            } else if (currentToken == CURRENTTOKEN_NUM) {
                // resolve float, decimal
                // printf(`%c`, char0);
                if (char1 == KEYWORD_DOT) {
                    currentToken = CURRENTTOKEN_FLOAT;
                } else if (!Charactor.isNumber(char1)) {
                    // check for l at end?
                    // printf(` \n`);
                    currentToken = 0;
                    thisToken = TOKEN_NUM;
                }
            } else if (currentToken == CURRENTTOKEN_HEX) {
                // resolve hex
                // printf(`%c`, char0);
                if (!Charactor.isHex(char1)) {
                    // check for l at end?
                    // printf(` \n`);
                    currentToken = 0;
                    thisToken = TOKEN_HEX;
                }
            } else if (currentToken == CURRENTTOKEN_BIN) {
                // resolve binary
                // printf(`%c`, char0);
                if (!Charactor.isBinary(char1)) {
                    // check for l at end?
                    // printf(` \n`);
                    currentToken = 0;
                    thisToken = TOKEN_BINARY;
                }
            } else if (currentToken == CURRENTTOKEN_FLOAT) {
                // resolve hex, binary, float, decimal
                // printf(`%c`, char0);
                if (!Charactor.isFloat(char1)) {
                    // check for l at end?
                    // printf(` \n`);
                    currentToken = 0;
                    thisToken = TOKEN_FLOAT;
                }
            } else {
                if (currentToken != 0) {
                    throwException (`[error] currentToken != zero`);
                }
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
// #define KEYWORD_VAR_TYPE 	`?`
// #define KEYWORD_LBRACE      `{` 
// #define KEYWORD_RBRACE      `}` 
// #define KEYWORD_LPAREN      `(` 
// #define KEYWORD_RPAREN      `)` 
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
// #define KEYWORD_LBRACKET    `[` 
// #define KEYWORD_RBRACKET    `]` 
// #define KEYWORD_SEMI        `;` 
// #define KEYWORD_COLON       `:` 
// #define KEYWORD_CARET       `^` 
// #define KEYWORD_HASH        `#` 
// #define KEYWORD_COMMA       `,`
// #define KEYWORD_DOLLAR      `$` 
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

                        // printf(`ID=%c`, char0);

                        if (!Lex.isChar(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_ID;
                        }

                        break;
                    case '0' :
                        if (char1 == `B` || char1 == `b`) { // binary num
                            currentToken = CURRENTTOKEN_BIN;    
                            roll = 1;
                            // printf(`binary=`);
                        } else if (char1 == `X` || char1 == `x`) { // hex
                            currentToken = CURRENTTOKEN_HEX;    
                            roll = 1;
                            // printf(`hex=`);
                        } else if (char1 == KEYWORD_DOT) { // float
                            currentToken = CURRENTTOKEN_FLOAT;    
                            // printf(`float=%c`, char0);
                        } else {
                            currentToken = CURRENTTOKEN_NUM;

                            // check for 1 length
                            // valid 2nd char combinations
                            if (!Lex.is2ndNum(char1)) {
                                currentToken = 0;
                                thisToken = TOKEN_DECIMAL;
                            //     printf(`num=%c\n`, char0);
                            // } else {
                            //     printf(`num=%c`, char0);
                            }
                        }
                        break;
                    case '1'..'9' :
                        currentToken = CURRENTTOKEN_NUM;

                        // check for 1 length
                        // valid 2nd char combinations
                        if (!Lex.is2ndNum(char1)) {
                            currentToken = 0;
                            thisToken = TOKEN_DECIMAL;
                            // printf(`num=%c\n`, char0);
                        } else {
                            // printf(`num=%c`, char0);
                            break;
                        }
                    // default :
                    //     printf(`%c`, char0);      
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
                    thisToken = matchKeywordToken(tLen, ix);
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


?content = FileUtils.fileread("Lexer.ec");
// ?content = FileUtils.fileread("TokenIds.ec");
// ?output = DynamicArray(Boxing.i8_);
// ?tokenIds = DynamicArray(Boxing.u16_);

?lex = Lex();
// lex.content = content;

// printf(`(1) classname %s\n`, content.className());

lex.lex(content);
// lex.lex();

// doSomeLexing(content, output, tokenIds);

// ?len = output.endIndex - output.startIndex;

// printf(`\n%li %li %li %li %li`, output.startIndex, output.endIndex, output.length, content.length, len);

0b0_1_01;
0xaef54F;
0.234;
12;
1;
23423.343;
