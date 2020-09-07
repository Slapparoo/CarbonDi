
#ifndef __BONDI_TOKENIDS__
#define __BONDI_TOKENIDS__
 
#define CURRENTTOKEN_LINECOMMENT 1
#define CURRENTTOKEN_STARCOMMENT 2
#define CURRENTTOKEN_DOCCOMMENT  3
#define CURRENTTOKEN_CSTRING     4
#define CURRENTTOKEN_SQSTRING    5
#define CURRENTTOKEN_DQSTRING    6
#define CURRENTTOKEN_STRINGBLOCK 7

#define CURRENTTOKEN_ID          8
#define CURRENTTOKEN_NUM         9
#define CURRENTTOKEN_HEX         10
#define CURRENTTOKEN_BIN         11
#define CURRENTTOKEN_FLOAT       12

// #define TOKEN_PLUS          101  // +
// #define TOKEN_MINUS         102  // -
// #define TOKEN_DIV           103  // /
// #define TOKEN_MOD           104  // %
// #define TOKEN_STAR          105  // *
// #define TOKEN_LPAREN        106  // (
// #define TOKEN_RPAREN        107  // ) 
// #define TOKEN_LBRACE	    108  // {
// #define TOKEN_RBRACE	    109  // }
// #define TOKEN_LBRACKET	    110  // [
// #define TOKEN_RBRACKET	    111  // ]
// #define TOKEN_PLUSPLUS	    112  // ++
// #define TOKEN_MINUSMINUS	113  // --
// #define TOKEN_PLUSEQUAL	    114  // +=
// #define TOKEN_MINUDEQUAL	115  // -=
// #define TOKEN_STAREQUAL	    116  // *=
// #define TOKEN_DIVEQUAL	    117  // /=
// #define TOKEN_MODEQUAL	    118  // %=
// #define TOKEN_LT	        119  // <
// #define TOKEN_GT	        120  // >
// #define TOKEN_EQUALEQUAL	121  // ===
// #define TOKEN_LTE	        122  // <=
// #define TOKEN_GTE	        123  // >=
// #define TOKEN_AND	        125  // &
// #define TOKEN_OR	        126  // |
// #define TOKEN_ANDAND	    127  // &&
// #define TOKEN_OROR	        128  // ||
// #define TOKEN_ASSIGN        129  // =
// #define TOKEN_NOT	        130  // !
// #define TOKEN_NEQ	        131  // !=
// #define TOKEN_ID	        134  // [a..zA..Z][a..zA..Z_0..9]+
// #define TOKEN_NUMBER	    135  // [0..9_]+
// #define TOKEN_DSTRING	    136  // "..."
// #define TOKEN_CSTRING	    137  // `...`
// #define TOKEN_WS	        138  // [\n\r\t\b ]
// #define TOKEN_EOL	        139  // [\n\r]
// #define TOKEN_LINE_COMMENT	140  // //...
// #define TOKEN_BLOCK_COMMENT	141  // /*...*/
// #define TOKEN_DOC_COMMENT	142  // /**...*/
// #define TOKEN_PRECOMPILER	143  // #...
// #define TOKEN_DIGIT	        144  // [0..9]
// #define TOKEN_ALPHA	        145  // [a..zA..Z0..9_]
// #define TOKEN_LETTER	    146  // [a..zA..Z]
// #define TOKEN_SAFECODEPOINT	147  // 
// #define TOKEN_NOTBACKQUOTE	148  //
// #define TOKEN_HEX	        149  // 0x[0..9a..fA..F_]+
// #define TOKEN_TRIPLE_SQ	    150  // '''
// #define TOKEN_ESC_1	        152  //
// #define TOKEN_ESC_2	        153  //
// #define TOKEN_FLOAT	        154  // [:DIGIT:]?.[:DIGIT:]+
// #define TOKEN_NUM	        155  // [:BINARY:]|[:HEX:]|[:DECIMAL:]
// #define TOKEN_ANONYMOUS	    156  // $[a..z]
// #define TOKEN_RANGE	        157  // ([:ID:]|[:NUM:])..([:ID:]|[:NUM:])
// #define TOKEN_SSTRING	    158  // '...'
// #define TOKEN_BSTRING	    139  // [:TRIPLE_SQ:]...[:TRIPLE_SQ:]
// #define TOKEN_EQUAL  	    140  // ==
// #define TOKEN_LAMBDA  	    141  // =>
// #define TOKEN_BINARY  	    142  // 0b[0..1_]+
// #define TOKEN_DECIMAL  	    143  // [0..9_]+
// #define TOKEN_SHL     	    144  // <<
// #define TOKEN_SHR  	        143  // >>
// #define TOKEN_AEQ  	        145  // &=
// #define TOKEN_XEQ  	        146  // ~=
// #define TOKEN_OEQ  	        147  // |=
// #define TOKEN_XOR  	        148  // ~

#define TOKEN_PLUS          101
#define TOKEN_MINUS         102
#define TOKEN_DIV           103
#define TOKEN_MOD           104
#define TOKEN_STAR          105
#define TOKEN_LPAREN        106
#define TOKEN_RPAREN        107
#define TOKEN_LBRACE	    108
#define TOKEN_RBRACE	    109
#define TOKEN_LBRACKET	    110
#define TOKEN_RBRACKET	    111
#define TOKEN_PLUSPLUS	    112
#define TOKEN_MINUSMINUS	113
#define TOKEN_PLUSEQUAL	    114
#define TOKEN_MINUSEQUAL	115
#define TOKEN_STAREQUAL	    116
#define TOKEN_DIVEQUAL	    117
#define TOKEN_MODEQUAL	    118
#define TOKEN_LT	        119
#define TOKEN_GT	        120
#define TOKEN_EQUALEQUAL	121
#define TOKEN_LTE	        122
#define TOKEN_GTE	        123
#define TOKEN_AND	        125
#define TOKEN_OR	        126
#define TOKEN_ANDAND	    127
#define TOKEN_OROR	        128
#define TOKEN_ASSIGN        129
#define TOKEN_NOT	        130
#define TOKEN_NEQ	        131
#define TOKEN_ID	        134
#define TOKEN_NUMBER	    135
#define TOKEN_DSTRING	    136
#define TOKEN_CSTRING	    137
#define TOKEN_WS	        138
#define TOKEN_EOL	        139
#define TOKEN_LINE_COMMENT	140
#define TOKEN_BLOCK_COMMENT	141
#define TOKEN_DOC_COMMENT	142
#define TOKEN_PRECOMPILER	143
#define TOKEN_DIGIT	        144
#define TOKEN_ALPHA	        145
#define TOKEN_LETTER	    146
#define TOKEN_SAFECODEPOINT	147
#define TOKEN_NOTBACKQUOTE	148
#define TOKEN_HEX	        149
#define TOKEN_TRIPLE_SQ	    150
#define TOKEN_ESC_1	        152
#define TOKEN_ESC_2	        153
#define TOKEN_FLOAT	        154
#define TOKEN_NUM	        155
#define TOKEN_ANONYMOUS	    156
#define TOKEN_RANGE	        157
#define TOKEN_SSTRING	    158
#define TOKEN_BSTRING	    159
#define TOKEN_EQUAL  	    160
#define TOKEN_LAMBDA  	    161
#define TOKEN_BINARY  	    162
#define TOKEN_DECIMAL  	    163
#define TOKEN_SHL     	    164
#define TOKEN_SHR  	        163
#define TOKEN_AEQ  	        165
#define TOKEN_XEQ  	        166
#define TOKEN_OEQ  	        167
#define TOKEN_XOR  	        168
#define TOKEN_DOT  	        169
#define TOKEN_DOTDOT        170
#define TOKEN_SEMI          171
#define TOKEN_COLON         172
#define TOKEN_QUESTION      173
#define TOKEN_HASH          174
#define TOKEN_CARET         175
#define TOKEN_DOLLAR        176
#define TOKEN_COMMA         177
#define TOKEN_DOLLARBRACE   178
#define TOKEN_DOLLARBRACKET 179
#define TOKEN_BRACESTAR     180
#define TOKEN_BRACEPLUS     181
#define TOKEN_BRACEQUESTION 182


// special words
#define TOKEN_ID_U8	        200
#define TOKEN_ID_I8	        201
#define TOKEN_ID_B8	        202
#define TOKEN_ID_IF         203
#define TOKEN_ID_IS         204
#define TOKEN_ID_IN         205
#define TOKEN_ID_U16	    206
#define TOKEN_ID_I16	    207
#define TOKEN_ID_U32	    208
#define TOKEN_ID_I32	    209
#define TOKEN_ID_F32	    210
#define TOKEN_ID_U64	    211
#define TOKEN_ID_I64	    212
#define TOKEN_ID_F64	    213
#define TOKEN_ID_F80	    214
#define TOKEN_ID_NUM	    215
#define TOKEN_ID_INT	    216
#define TOKEN_ID_TRY        217
#define TOKEN_ID_F128	    218
#define TOKEN_ID_NULL	    219
#define TOKEN_ID_ELSE       220
#define TOKEN_ID_LOOP       221
#define TOKEN_ID_WITH       222
#define TOKEN_ID_CASE       223
#define TOKEN_ID_VOID       224
#define TOKEN_ID_ENUM       225
#define TOKEN_ID_PLAN       226
#define TOKEN_ID_STUB       227
#define TOKEN_ID_TRUE       228
#define TOKEN_ID_BOOLEAN	229
#define TOKEN_ID_POINTER	230
#define TOKEN_ID_PUBLIC     231
#define TOKEN_ID_PRIVATE    232
#define TOKEN_ID_PROTECTED  233
#define TOKEN_ID_HIDDEN     234
#define TOKEN_ID_IMPORTS    235
#define TOKEN_ID_CATCH      236
#define TOKEN_ID_FINALLY    237
#define TOKEN_ID_THROWS     238
#define TOKEN_ID_BREAK      239
#define TOKEN_ID_CONTINUE   240
#define TOKEN_ID_SWITCH     241
#define TOKEN_ID_DEFAULT    242
#define TOKEN_ID_RETURN     243
#define TOKEN_ID_RETURN_ADD 244
#define TOKEN_ID_STATIC     245
#define TOKEN_ID_FINAL      246
#define TOKEN_ID_SIGNATURE  247
#define TOKEN_ID_CLASS      248
#define TOKEN_ID_PROPERTIES 249
#define TOKEN_ID_FUNCTION   250
#define TOKEN_ID_FALSE      251



// Length 1 compound
#define KEYWORD_STAR 		`*` 
#define KEYWORD_DIV 		`/`
#define KEYWORD_MOD 		`%` 
#define KEYWORD_PLUS 		`+`
#define KEYWORD_MINUS 		`-`
#define KEYWORD_AND 		`&` 
#define KEYWORD_OR 			`|`
#define KEYWORD_LT 			`<` 
#define KEYWORD_GT 			`>` 
#define KEYWORD_EQUAL       `=`
#define KEYWORD_NOT         `!` 
#define KEYWORD_TILDE       `~` 
#define KEYWORD_DOT         `.` 

// 1 length only
#define KEYWORD_VAR_TYPE 	`?`
#define KEYWORD_QUESTION 	`?`
#define KEYWORD_LBRACE      `{` 
#define KEYWORD_RBRACE      `}` 
#define KEYWORD_LPAREN      `(` 
#define KEYWORD_RPAREN      `)` 
#define KEYWORD_LBRACKET    `[` 
#define KEYWORD_RBRACKET    `]` 
#define KEYWORD_SEMI        `;` 
#define KEYWORD_COMMA       `,`
#define KEYWORD_COLON       `:` 
#define KEYWORD_CARET       `^` 
#define KEYWORD_HASH        `#` 
#define KEYWORD_DOLLAR      `$` 

// length 2 special
#define KEYWORD_EQ 			'==' 
#define KEYWORD_LAMBDA      '=>'  
#define KEYWORD_SHIFTR 		'>>' 
#define KEYWORD_GTE 		'>='
#define KEYWORD_SHIFTL 		'<<'
#define KEYWORD_LTE 		'<='
#define KEYWORD_NEQ 		'!='
#define KEYWORD_ANDEQ 		'&='
#define KEYWORD_XOREQ 		'~='
#define KEYWORD_OROR 		'||'
#define KEYWORD_OREQ 		'|='
#define KEYWORD_ANDAND 		'&&'
#define KEYWORD_PLUSPLUS 	'++' 
#define KEYWORD_PLUSEQ 		'+='
#define KEYWORD_STAREQ 		'*='
#define KEYWORD_DIVEQ 		'/='
#define KEYWORD_MINUSEQ 	'-='
#define KEYWORD_MINUSMINUS 	'--'
#define KEYWORD_MODEQ 		'%='
#define KEYWORD_DOTDOT      '..' 


#define KEYWORD_U8 			'u8'
#define KEYWORD_I8 			'i8'
#define KEYWORD_B8 			'b8'
#define KEYWORD_IF          'if' 
#define KEYWORD_IS          'is' 
#define KEYWORD_IN          'in' 

// length 3
#define KEYWORD_EQEQ 		'==='

#define KEYWORD_U16 		'u16'
#define KEYWORD_I16 		'i16'
#define KEYWORD_U32 		'u32'
#define KEYWORD_I32 		'i32'
#define KEYWORD_F32 		'f32'
#define KEYWORD_U64 		'u64'
#define KEYWORD_I64 		'i64'
#define KEYWORD_F64 		'f64'
#define KEYWORD_F80 		'f80'
#define KEYWORD_NUM 		'num'
#define KEYWORD_INT 		'int' // i32
#define KEYWORD_TRY         'try' 

// length 4
#define KEYWORD_F128 		'f128'
#define KEYWORD_NULL 		'null'
#define KEYWORD_ELSE        'else' 
#define KEYWORD_LOOP        'loop' 
#define KEYWORD_WITH        'with' 
#define KEYWORD_CASE        'case' 
#define KEYWORD_VOID        'void' 
#define KEYWORD_ENUM        'enum' 
#define KEYWORD_PLAN        'plan' 
#define KEYWORD_STUB        'stub' 
#define KEYWORD_TRUE        'true' 


// length 4+
#define KEYWORD_BOOLEAN 	'boolean'
#define KEYWORD_POINTER 	'pointer'
#define KEYWORD_PUBLIC      'public' 
#define KEYWORD_PRIVATE     'private' 
#define KEYWORD_PROTECTED   'protected' 
#define KEYWORD_HIDDEN      'hidden' 
#define KEYWORD_IMPORTS     'imports' 
#define KEYWORD_CATCH       'catch' 
#define KEYWORD_FINALLY     'finally' 
//#define KEYWORD_// keyword_throw       'throw' 
#define KEYWORD_THROWS      'throws' 
//#define KEYWORD_// keyword_asm_x64     'asm_x64' 
#define KEYWORD_BREAK       'break' 
#define KEYWORD_CONTINUE    'continue' 
#define KEYWORD_SWITCH      'switch' 
#define KEYWORD_DEFAULT     'default' 
#define KEYWORD_RETURN      'return' 
#define KEYWORD_RETURN_ADD  'return.add' 
//#define KEYWORD_// keyword_union       'union' 
#define KEYWORD_STATIC      'static' 
#define KEYWORD_FINAL       'final' 
#define KEYWORD_SIGNATURE   'signature' 
//#define KEYWORD_// keyword_object      'object' 
#define KEYWORD_CLASS       'class' 
#define KEYWORD_PROPERTIES  'properties' 
#define KEYWORD_FUNCTION    'function' 
//#define KEYWORD_// keyword_type        'type' 
//#define KEYWORD_// keyword_array       'array' 
//#define KEYWORD_// keyword_map         'map' 
#define KEYWORD_FALSE       'false' 



public class Lexer.Token (Core.Object) {
    properties {
        u64 offset;
        // u64 length;
        u32 type;
        String value;
    }

    public Token(=offset, =type, =value) {
        // printf(`Token(%lu, %lu, %u)`, offset, length, type);
    }

    public void printDetail() {
        if (value == 0) {
            printf(`Token(%lu, %u)`, offset, type);
        } else {
            ?v = value;
            printf(`Token(%lu, %u, %s)`, offset, type, v.asStr);
        }
    }
}



#endif


