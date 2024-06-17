Parser by example

takes input from the lexer, so the input is a set of predefined tokens.

-- need recurson

**Defintions**  
**r1.** `<text>` verbatim (not used as a method parameter)
> `static` does an exact word match against the word static  

**r2.** `<text>?` optional  
> `static?` the word static is checked fort but not required    

**r3.** `${<typename>}` predefined type  
> `${statements}`  

**r4.** `${<typename>}?` predefined type optional\
**r5.** `${<typename>}+` predefined type repeat 1 or many\
**r6.** `${<typename>}*` predefined type repeat 0 or many\
**r7.** `${<typename>:<variablename>}` predefined type as variable name\
**r8.** `${<typename>[char]:<variablename>}` or `${<typename>[char]}` predefined type as variable name as a list delimited by SPECIAL char\
* a list won't end in the delimiter charactor so `DOTID = ${TOKEN_ID.}`  
  * valid values name1.name2, name\
  * invalid name1.  

**r9.** or options `accesser = $[public, private, protected] ;` returns a single token  
**r10.** Rule definition is  
`<rulename> (params)? = <rulecontent> ;`  
eg  
`DOTID = ${ID.}` - using r8  
or  
`parens(content) = ( ${content} );` creates a rule called parens, which takes the parameter content and which has a definition of r1.`(` r3.`${content}` r1.`)`  
`block(statements) = { ${statements} };` creates a rule called block, which takes the parameter statements and which has a definition of r1.`{` r3.`${statements}` r1.`}`  

**pass variables**
`parens(content) = ( ${content} );`  
eg used inside the rule content  
`myotherrule = ${parens ( ${DOTID,:names} )};`  
* valid values `(name)`, `(name1.name2)` , `(name1, name2)`, `(name1, name1, name1.name2)` etc..  

or  
`myotherrule = ${block ( ${DOTID,:names} )};`  
* valid values `{name}`, `{name1.name2}` , `{name1, name2}`, `{name1, name1, name1.name2}` etc..  

definitions then become tokens\
\
every defintition gets a corrosponding factory method to create\
\
The values can be summerised as Token, list of Tokens or boolean, Or an instance of another Token  
**End of line**
;
**Post Notation**
```
? | optional | 0 or 1
+ | repreat | 1 or many
* | repreat | 0 o many
```
constants with ? will become boolean\
repeats will become a list\
lists become a list\
lists vs repeat a repeat is the same squence repeated\
a list does not have the seperator after the last item\
e.g.\
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

**Parser logic**
* create token stream processor validator
* generate token ids for key words
* populate keywords map
* pass keywords to lexer
* generate class model
* generate code to parse and populate class model
* validation errors

**Hand cranked processing code**
* validate values
* lookup tables
* output formator (C but could be others)
