grammar ec;

import ectypes;

@header {
package ec.lang.gen;
import ec.lang.defs.*;
}


program locals [FileDef ff = DefFactory.newFileDef()]
   : namespace_definition? imports_definition? statement +
   ;

statement
   : function_definition 
   | function_implementation
   | plan_definition
   | class_definition
   | if_definition
   | block_statement
   | type_definition
   | union_definition
   | loop_definition
   | exception_block_definition
   | extended_expr ';'
   | ';'
   ;

block_statement
   : keyword_lbrace statement* keyword_rbrace
   ;   

paren_expr 
   :  keyword_lparen expr keyword_rparen 
   ;

if_definition
   : keyword_if paren_expr statement
   | keyword_if paren_expr statement keyword_else statement
   ;

paren_range 
   : keyword_lparen type_range keyword_rparen 
   ;


loop_definition
   : keyword_loop ( paren_expr | paren_range ) type_id? statement
   ;

// used with return for single or return.add for multiple
return_loop_definition
   : cast_type loop_definition
   ;

expr
   : ( type_id | type_num | type_string | type_anonymous | type_float )
   | paren_expr
   | type_id predicate 
   | predicate type_id
   | expr comparator expr 
   | type_string operator_plus type_string
   | expr operator_mul expr 
   | expr operator_add expr 
   | expr operator_bin expr 
   | expr operator_shift expr 
   | array_values
   ;

extended_expr
   : expr
   | keyword_return  ( expr | builtin_values )
   | keyword_return_add '(' ( expr | builtin_values ) ')'
   | variable_definition
   | type_id assign ( expr | assignable_value ) 
   ;

function_call
   : type_id keyword_lparen ( expr ( keyword_comma expr)*)? keyword_rparen
   ;

function_definition 
   : function_description keyword_semi
   ;

function_implementation 
   : function_description {DefFactory.startFunctImpl();} block_statement {DefFactory.in_funct = null;}
   ;

function_description locals[FunctionDef fd = DefFactory.newFunctDef()]
   : 
      accessor_type? 
         {$fd.accessor = Enums.AccessorTypes.get($accessor_type.text);} 
      keyword_static? 
         {$fd.is_static = $keyword_static.text != null;} 
      keyword_final? 
         {$fd.is_final = $keyword_final.text != null;} 
      function_return_type 
         {$fd.returnType = new TypeIdDef($function_return_type.text);} 
      function_name  
         {$fd.name = $function_name.text;} 
      keyword_lparen ( 
      parameter_definition ( 
         
      keyword_comma 
      parameter_definition 
        
        )* )? 
      keyword_rparen ( 
      keyword_throws 
      type_id { $fd.exceptions.add($type_id.text); }  (
      keyword_comma 
      type_id { $fd.exceptions.add($type_id.text); }  )*)? {DefFactory.endFunctionDef();}
   ;

function_name :  type_id | 'get' | 'set' ;   

function_return_type : keyword_void | type_id | builtin_types ;   

variable_definition
   : ( type_id | builtin_types | var_type) type_id keyword_lbracket type_num? keyword_rbracket
   // array looking at specif memory address
   | ( builtin_types ) type_id keyword_lbracket ( type_num | type_id)? keyword_rbracket ':' ( type_num | type_id )
   | ( type_id | builtin_types ) keyword_lbracket type_num? keyword_rbracket type_id 
   | ( type_id | builtin_types | var_type ) type_id keyword_lbracket keyword_rbracket (keyword_equals cast_type? ( type_id | array_values ))?
   | ( type_id | builtin_types ) keyword_lbracket keyword_rbracket type_id (keyword_equals cast_type? ( type_id | array_values ))?
   | ( type_id | builtin_types | var_type ) type_id ( keyword_equals cast_type? ( assignable_value | expr ))?
   ;

cast_type
   : keyword_lparen parameter_data_type keyword_rparen
   ;

parameter_definition locals[VariableDef fp = DefFactory.newVarDef()]
   : parameter_data_type { $fp.type = new TypeIdDef($parameter_data_type.text); } type_id { $fp.setName($type_id.text);  $fp.type.is_array=true;} keyword_lbracket keyword_rbracket (keyword_equals cast_type? (type_id | array_values ))?  
   | parameter_data_type { $fp.type = new TypeIdDef($parameter_data_type.text); } keyword_lbracket keyword_rbracket type_id { $fp.setName($type_id.text); $fp.type.is_array=true;} (keyword_equals cast_type? (type_id | array_values ))?  
   | parameter_data_type { $fp.type = new TypeIdDef($parameter_data_type.text); } type_id { $fp.setName($type_id.text); } (keyword_equals cast_type? assignable_value )? 
   | type_id { $fp.type = new TypeIdDef($type_id.text);} {System.out.println($fp);}
   // array , =
   | keyword_ampersand? { $fp.is_reference =$keyword_ampersand.text != null; } builtin_primatives { $fp.type = new TypeIdDef($builtin_primatives.text); } type_id? { $fp.setName($type_id.text); } 
   ;

parameter_data_type : ( type_id | builtin_types ) ( keyword_lbracket keyword_rbracket )? ;

array_values
   : keyword_lbracket ( assignable_value  ( keyword_comma assignable_value  )* )? keyword_rbracket
   | function_call
   ;

class_definition locals[ClassDef cd = DefFactory.newClassDef()]
@after {$cd.prepare_03(); System.out.println($cd.asCode());}
   : accessor_type? keyword_final? keyword_static? ( keyword_class | keyword_stub ) type_id {$cd.name = $type_id.text;} ( '<' type_id (keyword_comma type_id)*  '>')?  ( keyword_lparen type_id (keyword_comma type_id)* keyword_rparen )? keyword_lbrace class_body* keyword_rbrace  {DefFactory.in_class = null;}
   ;

class_body
// properties def + getters & setters
   :  property_accessor? keyword_properties property_body
   | statement
   | accessor_definition
   ;

property_accessor
   : keyword_lparen accessor_type? keyword_comma accessor_type? keyword_rparen 
   ;

property_body 
   : keyword_lbrace property_definition+ keyword_rbrace
   ;   

property_definition locals[VariableDef vd = new VariableDef()]
   // (,) String name
   
   : { $class_definition::cd.addProperty($vd); } property_definition_type type_id keyword_semi 
   // (,) String name = 'name'
   | { $class_definition::cd.addProperty($vd); } property_definition_type type_id (keyword_equals cast_type? assignable_value )? keyword_semi
   // (,) String [4] names
   | { $class_definition::cd.addProperty($vd); } property_definition_type keyword_lbracket type_num? keyword_rbracket type_id keyword_semi
   // (,) String names[] = ( the.names | ['name1', 'name2'] )
   | { $class_definition::cd.addProperty($vd); } property_definition_type type_id keyword_lbracket keyword_rbracket (keyword_equals cast_type? (type_id | array_values ))? keyword_semi
   // (,) String[] names = ( the.names | ['name1', 'name2'] )
   | { $class_definition::cd.addProperty($vd); } property_definition_type keyword_lbracket keyword_rbracket type_id (keyword_equals cast_type? (type_id | array_values ))? keyword_semi
   ;   

property_definition_type
   : property_accessor? ( type_id {$property_definition::vd.type = new TypeIdDef($type_id.text);} | builtin_types {$property_definition::vd.type = new TypeIdDef($builtin_types.text);} )
   ;

// a little lose in definition
accessor_definition 
   :  ( 'get' | 'set' )  ( type_id | 'get' | 'set' )  block_statement 
   ;

plan_definition
   : accessor_type? keyword_final? keyword_plan type_id ( '<' type_id (keyword_comma type_id)*  '>')?  ( keyword_lparen type_id (keyword_comma type_id)* keyword_rparen )* keyword_lbrace plan_body keyword_rbrace
   ;

plan_body
   :  function_definition+
   ;

type_definition
   : keyword_type type_id keyword_lbrace (variable_definition keyword_semi)* keyword_rbrace 
   ;

union_definition
   : keyword_union type_id keyword_lbrace (type_id | builtin_types (keyword_lbracket type_num keyword_rbracket)? keyword_semi)+ keyword_rbrace 
   ;

exception_block_definition
   : keyword_try block_statement catch_block_definition*  ( keyword_finally block_statement)?
   ;

catch_block_definition
   : keyword_catch  keyword_lparen type_id (keyword_comma type_id)* keyword_rparen  block_statement
   ;

imports_definition
   : keyword_imports keyword_lbrace ( keyword_extern_c? ( ( type_string | type_id ) keyword_semi ) )+ keyword_rbrace
   ;

namespace_definition
   : keyword_namespace type_id keyword_semi    
   | keyword_namespace type_id ';' 
   ;   

// array?
assignable_value
   : type_id | type_string | type_num | builtin_values | function_call | type_float | type_anonymous | return_loop_definition
   | json_obj
   ;

boolean_expr
   : keyword_true | keyword_false | type_num | type_id
   // there are others
   ;

loop_parameter
   : indexable_type | boolean_expr
   ;

// can be used to index an array or for loops
indexable_type
   : type_range | type_id | type_num | function_call | type_anonymous
   ;
   
json_obj
   : keyword_lbrace (json_pair (keyword_comma json_pair)*)? keyword_rbrace
   ;

json_pair
   : type_string ':' json_value
   ;

json_array
   : keyword_lbracket (json_value (keyword_comma json_value)*)? keyword_rbracket  
   ;

json_value
   : type_string
   | type_num
   | json_obj
   | json_array
   | builtin_values
   ;
