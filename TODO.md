loop returns
loop types
cast
`<property>.raw` for internal use of properties

use the single big header for build
version stuff


function definitions
`int External.stdio.printf(pointer, ...);`

function implmentations
`    String.myThing = () {}`
    
*definition*
```
int sort(int[] list, int compare(int, int)) {
    ...
    compare(list[a], list[b]);
}
```
*implmentation*
```
sort(array, (a, b) {return a-b;});
sort(array, () {return $a-$b;});
```

C style params array
Exception stack trace
Core.External = static methods, with direct calls
ternary asdas? asd : asd;
onchange, onvalidate, onget to array (wsomehow write code not generate code)
inline class
inline function
DynamicArray
threads
imports
constructor params polluting in global varibales
constructor functions
track pointers/pointer to pointers so they can be changed or remove exposing them
auto expand to String on printf if %s
super
unit tests / framework
precompiler
instanceof implements -> parents
primative compatability check
(defect) internal block is not output
enum
create object with a passed array - so it doen't alllocate its own data
line numbers - $statement.start
casting

memcopy - data pointer and size - expose array
use Array for string etc - expose array
multi parameter methods (Array?)  last param - Type name..., functionmame(String names...)
auto boxing

init array values - with auto boxing
std print
generics
json
optimise_04
v2 class static constructors (String.new(Pointer)), - which accept their struct data -mem read, file read etc
fix finally block is it gets called when an exception is thrown that is not caught in its catch block

initialise struct type defs - with defined values or default null value
StructType blah = {1, 4, ""};

on the fly binary data structure, suitable for copy to c-struct

** done **
exceptions Stack per type or one stack of handlers and you rifle though until found
inherit constructors
constructor overrides
hashcode, equals
boxing
auto string
Add boxing for all types
auto string  @value = "String value"; - custom print(Object values...)
constructor assign values, use the setters not direct access
expose data size of object
class signatures for compiled classes - compiled bundles
output class signatures ecs files
user useobject->classmodel not getCLassNameClassModel
safe memory allocate
where do main line methods get declared? declare them as public
if
operands
basic langauge support library in ec - String, Exception, Array, Boxing
re-factor types.h, re-implement string, use string
bundle all 'Core'/package ec's into a single 'library' file
functions as properties getter and setter
class unique names, Constructor unique names
class static properties, 
validate_01
prepare_01
(defect) parent constructors in header RefArray
switch @ for ?
property function overrides, accessors
getters setters onset? event
oberserver for properties (async message queue)
observer implementation
switch
Other base lang features, loop swicth, if etc....
