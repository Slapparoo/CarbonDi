ID=${TOKEN_ID} 
;

// comment = $[ ${linecomment}, ${blockcomment}, ${doccomment}]
// options = $[options..]
// token = token
// variable = ${id}
// value = $[ ${options}, ${token}, ${variable} ]+
//

// the end . is a repitition
DOTID = ${TOKEN_ID.} 
;
//-- added by parser -- newDOTID(List<TOKEN_ID> DOTIC);

// recursion
array = ${DOTID} [ $[ ${DOTID}, ${array} ] ]
;

accesser = $[public, private, protected] 
;
//-- added by parser -- newAccesser(Token accesser);

functionSig = ${accesser}? static? final? ${DOTID:name} (${parameter,:parameters}?) ${throwsdef}?
;
//-- added by parser -- newFunctionSig(Token accessor, boolean static, boolean final, Token name, List<parameter> parameters, Token throwsdef, Token functionBody);

functionDef = ${functionSig} {
    ${functionbody}?
}
;
//-- added by parser -- newFunctionDef(functionSig, functionBody);

class = class ${accesser}? static? final? class ${DOTID:name} ${parens( ${DOTID,:extends} )}? {
    ${properties}?
    ${classStatements}?
}
;

----------;
id = [  token ?  | ${ id [token] [ : id ] } [ ? | + | * ] | $[ token [, token] ] [ ? | + | * ] ]+ ;
;
134(id) 129(=) [ ]
;--------;

// can be identified by the ? or the TOKEN_ID
id =
    const ?                             // const, optional
    ${ token token : token } ? + *      // token, optional repeat, optional name
    $[ token comma token ] ? + *        // x number of comma delomited options, one can be selected
; 
need <eof>

id1 | id2 | id3

// token resolver sequencers ->

134 id 129 =  (134) token  (173) <optional>  (171) ;
134 129 
!0 173? 171

134 129 !0
    173
        171
    171 -> <eof> | reentrant

134 id 129 =  (178) Var{  (134) token  (134) token  (172) , varname= (134) toekn  (109) }  (173) <optional>  (101) 101  (105) 105  (171) ;
134 129 
178 !0 !0? (172 134)? 109  [173, 101, 105]? 171

134 129 !0
    !0
    172 134
109
    173
        171
    101
        171
    105
        171
    171    



134 id 129 =  (179) OptionsList[  (134) token  (134) token  (111) ]  (171) ;
134 129 
179 !0 !0 111 171

134 129 179 !0 !0 111 171

At what stage does it determine it is in a rule



