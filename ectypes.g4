grammar ectypes;

var_type
   : 'var'
   | '@'
   ;

builtin_types
   : builtin_objects
   | builtin_primatives
   ;

builtin_objects
   : 'String'
   ;

builtin_primatives   
   : 'u8'
   | 'char'
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
   | 'boolean' 
   | 'num' //i64/u64/f64 best derived
   | 'num.i' //i64
   | 'num.u'  //u64
   | 'num.f' //f64
   | 'num.u8'
   | 'num.i8'
   | 'num.u16'
   | 'num.i16'
   | 'num.u32'
   | 'num.i32'
   | 'num.f32'
   | 'num.u64'
   | 'num.i64'
   | 'num.f64'
   | 'num.f128'
   | 'num.f80'
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

operator_add
   : operator_plus
   | '-' 
   ;

operator_plus
   : '+'
   ;

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
keyword_else        : 'else' ;
keyword_loop        : 'loop' ;
keyword_public      : 'public' ;
keyword_private     : 'private' ;
keyword_protected   : 'protected' ;
keyword_imports     : 'imports' ;
keyword_is          : 'is' ;
keyword_with        : 'with' ;
keyword_in          : 'in' ;
keyword_try         : 'try' ;
keyword_catch       : 'catch' ;
keyword_finally     : 'finally' ;
keyword_throw       : 'throw' ;
keyword_throws      : 'throws' ;
keyword_asm_x64     : 'asm_x64' ;
keyword_break       : 'break' ;
keyword_continue    : 'continue' ;
keyword_switch      : 'switch' ;
keyword_case        : 'case' ;
keyword_default     : 'default' ;
keyword_return      : 'return' ;
keyword_return_add  : 'return.add' ;
keyword_union       : 'union' ;
keyword_static      : 'static' ;
keyword_final       : 'final' ;
keyword_void        : 'void' ;

keyword_object      : 'object' ;
keyword_enum        : 'enum' ;
keyword_plan        : 'plan' ;
keyword_class       : 'class' ;
keyword_properties  : 'properties' ;
keyword_stub        : 'stub' ;
keyword_function    : 'function' ;
keyword_type        : 'type' ;
keyword_array       : 'array' ;
keyword_map         : 'map' ;
keyword_lambda      : '=>' ;
keyword_true        : 'true' ;
keyword_false       : 'false' ;
keyword_this        : 'this' ;
keyword_super       : 'super' ;

// keyword_set         : 'set' ;
// keyword_get         : 'get' ;
keyword_extern      : 'extern' ;
keyword_extern_c    : 'extern_c' ;
keyword_namespace   : 'namespace' ;



type_range
   : RANGE
   ;

RANGE
   : ( NUM | ID | STRING ) '..' ( NUM | ID | STRING )
   ;

type_id : ID  { /* System.out.println($ID); */} ;

ID
   : LETTER ALPHA* ( '.' LETTER ALPHA*)*
   ;


type_anonymous : ANONYMOUS ;

ANONYMOUS
   : '$'[a-z]
   | '$'[a-z] '.' ID
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

type_string : STRING ;

eol : EOL ;

STRING
   : '"' (ESC_1 | SAFECODEPOINT | ['])+ '"'
   | ['] (ESC_2 | SAFECODEPOINT | ["])+ [']
   | ['][']['] .* [']['][']
   ;

fragment ESC_1
   : '\\' (["\\/bfnrt] | UNICODE)
   ;

fragment ESC_2
   : '\\' (['\\/bfnrt] | UNICODE)
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;

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
