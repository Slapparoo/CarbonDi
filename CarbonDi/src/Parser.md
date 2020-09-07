Parser by example

takes input from the lexer, so th einput is a set of predefined tokens.

-- need recurson

---
Defintions 
`<text>` verbatim (not uses as a method parameter)
`<text>?` optional 

`${<typename>}` predefined type
`${<typename>}?` predefined type optional
`${<typename>}+` predefined type repeat 1 or many
`${<typename>}*` predefined type repeat 0 or many
`${<typename>:<variablename>}` predefined type as variable name
`${<typename>[char]:<variablename>}` predefined type as variable name as a list delimited by char
* a list won't end in the delimiter charactor so `DOTID = ${TOKEN_ID.}` 
** valid values name1.name2, name
** invalid name1.

or options 
`accesser = $[public, private, protected] ;`
returns a single token

Rule definaition is
`<rulename> (params)? = <rulecontent> ;`
eg
`DOTID = ${ID.}`
or
`parens(content) = ( ${content} );`
`block(statements) = { ${statements} };`

pass variables
`parens(content) = ( ${content} );`
eg used inside the rule content
`myotherrule = ${parens ( ${DOTID,:names} )};`
 * valid values `(name)`, `(name1.name2)` , `(name1, name2)`, `(name1, name1, name1.name2)` etc.. 

or
`myotherrule = ${block ( ${DOTID,:names} )};`
 * valid values `{name}`, `{name1.name2}` , `{name1, name2}`, `{name1, name1, name1.name2}` etc.. 

deintinitions then become tokens

every defintition gets a corrosponding factory method to create

The values can be summerised as Token, list of Tokens or boolean, Or an instance of another Token

Post Notation
```
? | optional | 0 or 1
+ | repreat | 1 or many
* | repreat | 0 o many
```
constants with ? will become boolean
repeats will become a list
lists becore a list
lists vs repeat a repeat is the same squence repeated
a list does not have the seperator after the last item
e.g.
```
import class.name1;
import class.name2;
```
is a repeat

call function 
```
functionName(parameter1, parameter2);
```
the parameters are a list


---
```
accesser = $[public, private, protected] ;
-- added by parser -- newAccesser(Token accesser);

DOTID = ${TOKEN_ID.}
-- added by parser -- newDOTID(List<TOKEN_ID> DOTIC);

functionSig = ${accesser}? static? final? ${DOTID:name} (${parameter,:parameters}?) ${throwsdef}?
;
-- added by parser -- newFunctionSig(Token accessor, boolean static, boolean final, Token name, List<parameter> parameters, Token throwsdef, Token functionBody);

functionDef = ${functionSig} {
    ${functionbody}?
};
-- added by parser -- newFunctionDef(functionSig, functionBody);

class = class ${accesser}? static? final? class ${DOTID:name} ${parens( ${DOTID,:extends} )}? {
    ${properties}?
    ${classStatements}?
};
-- added by parser -- newClass(accessor, static(boolean), final(boolean), name, extends(List<DOTID>), properties, classStatements);
```

Parser logic
* create token stream processor validator
* generate token ids for key words
* populate keywords map
* pass keywords to lexer
* generate class model
* generate code to parse and populate class model
* validation errors

Hand cranked processing code
* validate values
* lookup tables
* output formator (C but could be others)
