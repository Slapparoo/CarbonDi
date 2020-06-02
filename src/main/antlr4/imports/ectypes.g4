grammar ectypes;

var_type : '?' ;

builtin_primatives   
   : 'u8'
   | 'i8'
   | 'u16'
   | 'i16'
   | 'u32'
   | 'i32'
   | 'f32'
   | 'u64'
   | 'i64'
   | 'f64'
   | 'f128'
   | 'f80'
   | 'boolean' | 'b8'
   | 'num'
   | 'pointer'
   | keyword_function
   | 'int' // i32
   ;

builtin_values
   : 'null'
   | keyword_true
   | keyword_false
    ;


comparator 
   : '<' 
   | '>' 
   | '==' 
   | '>='
   | '<='
   | '!='
   | '==='
   | '&='
   | '~='
   | '||'
   | '&&'
   ;

assign 
   : keyword_equals
   | '+='
   | '*='
   | '/='
   | '-='
   | '%='
   ;

predicate 
   : '++' 
   | '--'
   ;

operator_mul
   : '*' 
   | '/'
   | '%' 
   ;

operator_add : ( operator_minus  | operator_plus );

operator_plus : '+';
operator_minus : '-';

keyword_ampersand
   : '&' 
   ;

operator_bin
   : keyword_ampersand
   | '|'
   ;

operator_shift
   : '>>' 
   | '<<'
   ;


accessor_type 
   : keyword_public 
   | keyword_private 
   | keyword_protected 
   | keyword_hidden
   ;

keyword_lbrace      : '{' ;
keyword_rbrace      : '}' ;
keyword_lparen      : '(' ;
keyword_rparen      : ')' ;
keyword_lbracket    : '[' ;
keyword_rbracket    : ']' ;
keyword_semi        : ';' ;
keyword_equals      : '=' ;   
keyword_comma       : ',' ;   

keyword_if          : 'if' ;
keyword_not         : '!' ;
keyword_else        : 'else' ;
keyword_loop        : 'loop' ;
keyword_public      : 'public' ;
keyword_private     : 'private' ;
keyword_protected   : 'protected' ;
keyword_hidden      : 'hidden' ;
keyword_imports     : 'imports' ;
keyword_is          : 'is' ;
keyword_with        : 'with' ;
keyword_in          : 'in' ;
keyword_try         : 'try' ;
keyword_catch       : 'catch' ;
keyword_finally     : 'finally' ;
// keyword_throw       : 'throw' ;
keyword_throws      : 'throws' ;
// keyword_asm_x64     : 'asm_x64' ;
keyword_break       : 'break' ;
keyword_continue    : 'continue' ;
keyword_switch      : 'switch' ;
keyword_case        : 'case' ;
keyword_default     : 'default' ;
keyword_return      : 'return' ;
keyword_return_add  : 'return.add' ;
// keyword_union       : 'union' ;
keyword_static      : 'static' ;
keyword_final       : 'final' ;
keyword_void        : 'void' ;

keyword_signature   : 'signature' ;
// keyword_object      : 'object' ;
keyword_enum        : 'enum' ;
keyword_plan        : 'plan' ;
keyword_class       : 'class' ;
keyword_properties  : 'properties' ;
keyword_stub        : 'stub' ;
keyword_function    : 'function' ;
// keyword_type        : 'type' ;
// keyword_array       : 'array' ;
// keyword_map         : 'map' ;
keyword_lambda      : '=>' ;
keyword_true        : 'true' ;
keyword_false       : 'false' ;
// keyword_this        : 'this' ;
// keyword_super       : 'super' ;

// keyword_set         : 'set' ;
// keyword_get         : 'get' ;
// keyword_extern      : 'extern' ;
// keyword_extern_c    : 'extern_c' ;
keyword_namespace   : 'namespace' ;
keyword_global   : 'global' ;



type_range
   : RANGE
   ;

RANGE
   : ( NUM | ID | STRING ) '..' ( NUM | ID | STRING )
   ;

base_ident :  ID | ANONYMOUS ;

ID
   : LETTER ALPHA* 
   ;


type_anonymous : ANONYMOUS ;

ANONYMOUS
   : '$'[a-z]
   ;

type_num : NUM;

NUM
   :  '-'? [1-9] (DIGIT)*
   | '0'
   | '0x' (HEX | '_')*
   | '0b' [0-1_]*
   ;

type_float : FLOAT;

FLOAT
   : '-'? (DIGIT)+ '.' (DIGIT)*
   | '-'? (DIGIT)* '.' (DIGIT)+
   | '-'? (DIGIT)* ('.' (DIGIT)+)? 'f'
   ;

type_string : STRING | CSTRING;

eol : EOL ;

STRING
   : '"' (ESC_1 | SAFECODEPOINT | ['])+ '"'
   | ['] (ESC_2 | SAFECODEPOINT | ["])+ [']
   | TRIPLE_SQ (.+?) TRIPLE_SQ
   ;

CSTRING
   : '`' ( ESC_1 | NOTBACKQUOTE)+ '`' ;

fragment ESC_1
   : '\\' (["\\/bfnrt] | UNICODE)
   ;

fragment TRIPLE_SQ : ['][']['] ;

fragment ESC_2
   : '\\' (['\\/bfnrt] | UNICODE)
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;

fragment NOTBACKQUOTE : ~ ["`\\\u0000-\u001F] ;


fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;

// fragment LETTER : [a-zA-Z\u0080-\u00FF_] 
fragment LETTER : [a-zA-Z_] 
   ;

fragment ALPHA : [a-zA-Z0-9_] 
   ;


fragment DIGIT  
   : [0-9_] 
   ;

BLOCK_COMMENT
	: '/*' .*? '*/' -> channel(HIDDEN)
	;

LINE_COMMENT
	: '//' ~[\r\n]* -> channel(HIDDEN)
	;

fragment EOL : [\n] ;  

WS
   : ([ \r\t\f] | EOL) -> skip
   ;
