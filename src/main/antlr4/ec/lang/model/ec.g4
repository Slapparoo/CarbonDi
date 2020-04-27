grammar ec;

import ectypes;

@header {
// package ec.lang.model;
import ec.lang.defs.*;
import ec.lang.defs.expressions.*;
}


program locals [FileDef ff = DefFactory.newFileDef()]
   : namespace_definition? imports_definition? statement +
   ;

statement locals[StatementDef st]
   : function_definition 
   | function_implementation
   // | plan_definition
   | class_definition
   | if_definition
   | block_statement
   | loop_definition
   | exception_block_definition
   | extended_expr  ';' { EndExpr xd = DefFactory.newEndExpr();}
   | ';' {EndExpr xd = DefFactory.newEndExpr();}
   ;

block_statement locals[BlockDef bd = DefFactory.newBlockDef("block")]
   : keyword_lbrace statement* keyword_rbrace {DefFactory.dropBlock();}
   ;   

paren_expr 
   :  keyword_lparen expr {DefFactory.newParenExpr();} keyword_rparen 
   ;

if_definition locals[IfDef id = DefFactory.newIfDef()]
   : keyword_if paren_expr 
      {$id.condition = DefFactory.dropExpression(); } 
      block_statement 
      (keyword_else keyword_if 
      { $id.addElseIf(DefFactory.newElseDef());} 
      paren_expr { DefFactory.elseDef.condition = DefFactory.dropExpression();} block_statement )* 
      (keyword_else 
      {$id.elseDef = DefFactory.newIfDef();} block_statement)?
   ;

paren_range 
   : keyword_lparen type_range  {DefFactory.addExpression(new RangeExpr($type_range.text));} keyword_rparen 
   ;

loop_definition locals[LoopDef ld]
   : keyword_loop ( paren_expr | paren_range ) {DefFactory.newLoopDef();} block_statement 
   ;

// used with return for single or return.add for multiple
return_loop_definition
   : cast_type loop_definition
   ;

expr locals[ExprDef xd]
   : nt=keyword_not? ( 
      assignable_from 
   | type_num { $xd = DefFactory.newConstExpr($type_num.text); } 
   | type_string {DefFactory.newStringExpr($type_string.text);}
   // | type_anonymous { $xd = DefFactory.newAnnonymousExpr($type_anonymous.text); } 
   | type_float { $xd = DefFactory.newConstExpr($type_float.text, "float"); } 
   | builtin_values { $xd = DefFactory.newConstExpr($builtin_values.text, "builtin"); } 
   | paren_expr 
   | array_values
   ) { DefFactory.addNot($nt.text);}
   | expr { $xd = DefFactory.newOperationExpr();} comparator {$xd.expr = $comparator.text; } expr {((OperationExpr)$xd).right = DefFactory.dropExpression(); }
   | {$xd = DefFactory.newIncDecDef();} assignable_to { ((IncDecDef)$xd).expression = DefFactory.dropExpression(); } predicate {((IncDecDef)$xd).suffix = $predicate.text; }
   | {$xd = DefFactory.newIncDecDef();} predicate {((IncDecDef)$xd).prefix = $predicate.text; } assignable_to { ((IncDecDef)$xd).expression = DefFactory.dropExpression(); }
   | type_string operator_plus type_string
   | expr { $xd = DefFactory.newOperationExpr();} operator_mul {$xd.expr = $operator_mul.text; } expr {((OperationExpr)$xd).right = DefFactory.dropExpression(); }
   | expr { $xd = DefFactory.newOperationExpr();} operator_add {$xd.expr = $operator_add.text; } expr {((OperationExpr)$xd).right = DefFactory.dropExpression();}
   | expr { $xd = DefFactory.newOperationExpr();} operator_bin {$xd.expr = $operator_bin.text; } expr {((OperationExpr)$xd).right = DefFactory.dropExpression();}
   | expr { $xd = DefFactory.newOperationExpr();} operator_shift {$xd.expr = $operator_shift.text; } expr {((OperationExpr)$xd).right = DefFactory.dropExpression();}
   ;

extended_expr locals [StatementDef xe]
   : expr { $xe=DefFactory.newStatementDef(); }
   | keyword_return  expr  {$xe = DefFactory.newReturnExpr(1);} 
   | keyword_return  {$xe = DefFactory.newReturnExpr(0);} 
   | variable_definition
   | keyword_return_add '(' ( expr | builtin_values | assignable_value ) ')'
   // needs cast
   | assignable_to {DefFactory.endMultiTypeExpr();} aa=assign ( expr | assignable_value ) {DefFactory.newAssignExpr($aa.text);}
   ;

// can't end in function call
// assignable_to
assignable_to locals [MultiTypeExpr type_id_list = DefFactory.newMultiTypeExpr()] 
   :   ( assignable_from '.')?
   ( idn=base_ident {$type_id_list.addExpr(new TypeExpr($idn.text), $idn.start.toString());} 
   | idn=base_ident 
      keyword_lbracket asv=array_index keyword_rbracket 
        {$type_id_list.addExpr(new ArrayIndexExpr($idn.text, DefFactory.dropExpression(), $asv.text), $idn.start.toString()); } 
      )
      
        { DefFactory.addExpression($type_id_list, $type_id_list.getLine());} ;

array_index : assignable_from | type_num  { DefFactory.newConstExpr($type_num.text); }  ;

// can't contain a function call or array
pure_type locals [MultiTypeExpr type_id_list = DefFactory.newMultiTypeExpr()] 
   :  idn=base_ident {$type_id_list.addExpr(new TypeExpr($idn.text), $idn.start.toString());} 
   ('.' pure_type )*   { DefFactory.addExpression($type_id_list, $type_id_list.getLine());};

// can end with function call
assignable_from locals [MultiTypeExpr type_id_list = DefFactory.newMultiTypeExpr()] 
   :  
   ( idn=base_ident {$type_id_list.addExpr(new TypeExpr($idn.text), $idn.start.toString());} 
     | function_call   
     | idn=base_ident 
     keyword_lbracket asv=array_index keyword_rbracket
       {$type_id_list.addExpr(new ArrayIndexExpr($idn.text, DefFactory.dropExpression(), $asv.text), $idn.start.toString()); } 
   ) ('.' assignable_from )*  { DefFactory.addExpression($type_id_list, $type_id_list.getLine());} ;

function_call locals [FunctionCallExpr fc = DefFactory.newFunctionCallExpr()]
   :  
   base_ident {$fc.setName($base_ident.text);} 
      keyword_lparen ( expr {$fc.params.add(DefFactory.dropExpression());} 
       ( keyword_comma expr {$fc.params.add(DefFactory.dropExpression());} )*)? keyword_rparen
      { 
        $assignable_from::type_id_list = DefFactory.newMultiTypeExpr();   
        $assignable_from::type_id_list.addExpr($fc, $base_ident.start.toString()); 
      }       
   ;

function_definition 
   : function_description keyword_semi
   ;

function_implementation 
   : function_description {DefFactory.startFunctImpl();} block_statement {DefFactory.in_funct = null;}
   ;

constructor_definition locals[ConstructorDef cd = DefFactory.newConstructorDef()] :   

      accessor_type? 
         {$cd.accessor = Enums.AccessorTypes.get($accessor_type.text);} 
      keyword_final? 
         {$cd.is_final = $keyword_final.text != null;} 
      base_ident  
         {$cd.name = $base_ident.text;} 
      keyword_lparen ( 
      ( parameter_definition | constructor_parameter ) ( 
         
      keyword_comma 
      ( parameter_definition | constructor_parameter )
        
        )* )? 
      keyword_rparen ( 
      keyword_throws 
      pure_type 
      (
      keyword_comma 
      pure_type 
      )*)?
      ( block_statement | ';' )
;

function_description locals[FunctionDef fd = DefFactory.newFunctDef()]
   : 
      accessor_type? 
         {$fd.accessor = Enums.AccessorTypes.get($accessor_type.text);} 
      keyword_static? 
         {$fd.setIsStatic($keyword_static.text != null);} 
      keyword_final? 
         {$fd.is_final = $keyword_final.text != null;} 
      function_return_type 
         {$fd.returnType = new TypeIdDef($function_return_type.text);} 
      base_ident  
         {$fd.name = $base_ident.text;} 
      keyword_lparen ( 
      parameter_definition ( 
         
      keyword_comma 
      parameter_definition 
        
        )* )? 
      keyword_rparen ( 
      keyword_throws 
      pure_type { $fd.exceptions.add($pure_type.text);  }  (
      keyword_comma 
      pure_type { $fd.exceptions.add($pure_type.text); }  )*)? 
   ;
variable_definition locals[VariableDef vd = DefFactory.newVarDef()]

   : ti1=builtin_or_type_or_var nm=base_ident keyword_lbracket tn2=type_num? keyword_rbracket  
      {$vd.setValues("rule1", $nm.text, $ti1.text, true, null, $tn2.text, null, null);}
   // array looking at specif memory address
   | ti=builtin_primatives nm=base_ident keyword_lbracket tn=num_or_type? keyword_rbracket ':' ra=num_or_type 
      {$vd.setValues("rule4", $nm.text, $ti.text, true, null, $tn.text, $ra.text, null);}
   | ti2=builtin_or_type keyword_lbracket tn2=type_num? keyword_rbracket nm=base_ident                   
      {$vd.setValues("rule5", $nm.text, $ti2.text, true, null, $tn2.text, null, null);}
   | ti1=builtin_or_type_or_var nm=base_ident keyword_lbracket keyword_rbracket (keyword_equals ct=cast_type? ( as=assignable_from | array_values ))?
      {$vd.setValues("rule6", $nm.text, $ti1.text, true, $ct.text, null, null, null, $as.text, null);}
   | ti2=builtin_or_type keyword_lbracket keyword_rbracket nm=base_ident (keyword_equals ct=cast_type? ( as=assignable_from | array_values ))?
      {$vd.setValues("rule7", $nm.text, $ti2.text, true, $ct.text, null, null, null, $as.text, null);}
   | ti1=builtin_or_type_or_var nm=base_ident ( keyword_equals ct=cast_type? ( as1=assignable_value | ex=expr ))?
      {$vd.setValues("rule8", $nm.text, $ti1.text, false, $ct.text, null, null, null, $as1.text, DefFactory.dropExpression());}
   | var_type nm=base_ident  keyword_equals? ti2=builtin_or_type keyword_lbracket tn2=type_num keyword_rbracket  
      {$vd.setValues("rule2", $nm.text, $ti2.text, true, null, $tn2.text, null, null);}
   ;

/** convenience stuff */
num_or_type: (type_num | pure_type {DefFactory.dropExpression();}  );
builtin_or_type: (builtin_primatives | pure_type {DefFactory.dropExpression();}  );
builtin_or_type_or_var: var_type | builtin_or_type ;
function_return_type : (keyword_void | pure_type {DefFactory.dropExpression();} | builtin_primatives) ( keyword_lbracket keyword_rbracket )? ;   
parameter_data_type : ( pure_type {DefFactory.dropExpression();}  | builtin_primatives ) ( keyword_lbracket keyword_rbracket )? ;

cast_type 
   : keyword_lparen parameter_data_type {DefFactory.castType = $parameter_data_type.text;} keyword_rparen
   ;

constructor_parameter locals[VariableDef vd = DefFactory.newParamDef()]
   : keyword_equals base_ident {$vd.setName($base_ident.text); $vd.equalsParam=true; } ;

parameter_definition locals[VariableDef vd = DefFactory.newParamDef()]
   : ti2=builtin_or_type nm=base_ident keyword_lbracket keyword_rbracket (keyword_equals ct=cast_type? (as=assignable_from | array_values ))?  
      {$vd.setValues(null, $nm.text, $ti2.text, true, $ct.text, null, null, $nm.start.toString(), $as.text, null);}
   | ti2=builtin_or_type keyword_lbracket keyword_rbracket nm=base_ident (keyword_equals ct=cast_type? (as=assignable_from | array_values ))?  
      {$vd.setValues(null, $nm.text, $ti2.text, true, $ct.text, null, null, $nm.start.toString(), $as.text, null);}
   | ti2=builtin_or_type nm=base_ident (keyword_equals ct=cast_type? as1=assignable_value )? 
      {$vd.setValues(null, $nm.text, $ti2.text, false, $ct.text, null, null, $nm.start.toString(), $as1.text, null);}
   | ti2=builtin_or_type keyword_lbracket keyword_rbracket nm=base_ident (keyword_equals ct=cast_type? as1=assignable_value )? 
      {$vd.setValues(null, $nm.text, $ti2.text, true, $ct.text, null, null, $nm.start.toString(), $as1.text, null);}
   | keyword_ampersand? builtin_primatives nm=base_ident?  
   ;

array_values
// @todo create array_values class
   : keyword_lbracket ( assignable_value  ( keyword_comma assignable_value  )* )? keyword_rbracket
   | function_call
   ;

class_definition locals[ClassDef cd = DefFactory.newClassDef()]

// public final static class NewObject<T> (Object) is Comparable, Polymorphable, Readable
   : accessor=accessor_type? isFinal=keyword_final?  ( isClass=keyword_class | isStub=keyword_stub ) isSig=keyword_signature? 
   name=pure_type {$cd.setName($name.text);}
   ( '<' pure_type {$cd.addGenerics($pure_type.text);} (keyword_comma pure_type {$cd.addGenerics($pure_type.text);} )*  '>')? 
   ( '(' xx=pure_type { $cd.setCastType($xx.text); } ')' )?   ( keyword_is pure_type {$cd.addImplementation($pure_type.text); } 
   ( keyword_comma pure_type {$cd.addImplementation($pure_type.text);  } )*)? class_block 
   { $cd.setValues($isFinal.text, $isClass.text, $isStub.text, $isSig.text); }
   ;

class_block locals[BlockDef bd = DefFactory.newBlockDef("class")]
   : keyword_lbrace  (property_accessor? keyword_properties property_body)? class_body* keyword_rbrace  {DefFactory.endClassBlock();}
   ;

class_body
   : function_implementation
   | function_definition
   // | accessor_definition
   | constructor_definition
   | ';'
   ;

property_accessor
   : keyword_lparen accessor_type? keyword_comma accessor_type? keyword_rparen 
   ;

property_body 
   : keyword_lbrace property_definition+ keyword_rbrace
   ;   

property_definition locals[VariableDef vd = new VariableDef()]
   // (,) String name
   // (,) String name = 'name'

   : { $class_definition::cd.addProperty($vd); } 
      property_accessor? st=keyword_static? ti2=builtin_or_type nm=base_ident (keyword_equals ct=cast_type? as1=assignable_value )? keyword_semi 
      {$vd.setValues2("prop1", $nm.text, $ti2.text, false, $ct.text, null, null, $nm.start.toString(), $as1.text, DefFactory.dropExpression(), $st.text);}   
   // (,) String [4] names
   | { $class_definition::cd.addProperty($vd); } property_definition_type keyword_lbracket type_num? keyword_rbracket base_ident {$vd.setName($base_ident.text);} keyword_semi
   // (,) String names[] = ( the.names | ['name1', 'name2'] )
   | { $class_definition::cd.addProperty($vd); } property_definition_type base_ident {$vd.setName($base_ident.text);} keyword_lbracket keyword_rbracket (keyword_equals (cast_type { $vd.setCastTo(DefFactory.castType); } )? (assignable_from | array_values ))? keyword_semi
   // (,) String[] names = ( the.names | ['name1', 'name2'] )
   | { $class_definition::cd.addProperty($vd); } property_definition_type keyword_lbracket keyword_rbracket base_ident {$vd.setName($base_ident.text);} (keyword_equals (cast_type { $vd.setCastTo(DefFactory.castType); } )? (assignable_from | array_values ))? keyword_semi
   ;   

property_definition_type
   : property_accessor? st=keyword_static?  builtin_or_type {$property_definition::vd.type = new TypeIdDef($builtin_or_type.text);}
   ;

plan_body
   : (property_accessor? keyword_properties property_body)?  function_definition+
   ;

exception_block_definition
   : keyword_try block_statement catch_block_definition*  ( keyword_finally block_statement)?
   ;

catch_block_definition
   : keyword_catch  keyword_lparen pure_type (keyword_comma pure_type)* keyword_rparen  block_statement
   ;

imports_definition
   : keyword_imports keyword_lbrace ( ( ( type_string {$program::ff.importsDef.imports.add($type_string.text);} | pure_type {$program::ff.importsDef.imports.add($pure_type.text);} ) keyword_semi ) )+ keyword_rbrace
   ;

namespace_definition
   : keyword_namespace pure_type {$program::ff.namespace = $pure_type.text; System.out.println("**namespace " + $pure_type.text); } keyword_semi    
   ;   

// array? is this just an expr?
assignable_value 
   : assignable_from 
   | type_string {DefFactory.addExpression(new StringExpr($type_string.text));}
   | (keyword_lparen castas=pure_type keyword_rparen)? type_num {DefFactory.addExpression(new ConstExpr($type_num.text, $castas.text));}
   | builtin_values {DefFactory.addExpression(new ConstExpr($builtin_values.text));}
   // | function_call 
   | type_float {DefFactory.addExpression(new ConstExpr($type_float.text, "float"));}
   // | type_anonymous {DefFactory.addExpression(new AnnonymousExpr($type_anonymous.text));} 
   | return_loop_definition
   | json_obj
   ;

boolean_expr
   : keyword_true | keyword_false | type_num | assignable_from
   ;

loop_parameter
   : indexable_type | boolean_expr
   ;

// can be used to index an array or for loops
indexable_type
   : type_range | assignable_from | type_num  
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
