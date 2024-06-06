CarbonDi lang
==

CarbonDi is a binary compilable general purpose computer language, it is based on the 'C family of langauges' syntax so anyone who is familier with C, C++, Java, C#, Pascal, JavaScript etc should be able to pick the langauge quite quickly. One of the design principals is that the language is low level enough that you can write an OS with it, but also general enough that is is highly productive and can be used for any general purpose task.

The langauge it self allows for a combination of procedual programming or OO programming.

Being binary compilable means that the performance should be comparable to other binary compilable langauges.

The compiler generates 'C' source code which means that it can use existing C libraries and then get compiled by an existing C compiler.

The language uses a mix of primative types and Objects.


Current status
--
This prototype was created to demonstrate the viability of the langauge.
* non optimised, even with optimisation performance may not be as good as other binary compilable langauges.
* a bit rough around the edges, some short cuts were made to push through and create the proto type.


Type Naming
--
As it is binary compilable primative type names include the number of bits the represent and the type the represent i for integer, u for unsigned, f for float:
```
b8 - boolean
i8 - 8 bit integer (also char as defined by C)
u8 - 8 bit unsigned
i16, u16 - 16 bit
i32, u32, f32 - 32 bit
i64, u64, f64 - 64 bit
f80 - 80 bit float (where available)
f128 - 128 bit float (where available)
```

Strong types
--
variables can either be defined directly or with auto typing. ? is similar to var or auto in other languages

`?number = 10;`
is the same as
`num number = 10;`

Main not required
--
a source file doesn not require a main method or similar
e.g a file contain just will compile and print hello world!
`printf(`Hello world!\n`);`


Some pointers
--
One of the fundamental ideas behind CarbonDi is that you do not have to deal will pointers, so it manages memory allocation and deallocation, and objects are based by reference

The reference is not a pointer it is a reference for the memory manager.

String is an object
```javascript
boolean checkName(String name) {
    return name != null;
}
```

Array is an Object
```javascript
boolean checkLength(u8[] nums) {
    return nums != null && nums.length > 0;
}
```

Same method with an annonymous parameter
```javascript
boolean checkLength(u8[]) {
    return $a != null && $a.length > 0;
}
```

There is a default memory manager, but it can be replaced/integrated with a custom management stratagy.

i.e
__remove this__ use boxing and pass the corrosponding Object wrapper
***
```javascript
void addone(&num counter) {
    counter++;
}

// define variable as number the default type is i64, so count with be an i64
?counter = 10;

addOne(counter);

assert(counter == 0);
```

Default types
--
String for charator arrays 

i64 for numbers;

`?number = 10;`

number will be an i64 
<i>On a 64bit archtecture this is the way cpu's will deal with numbers the registers are 64bit when you push a value on the stack it will be 64bit (you can't push 32bits), so defining it as a smaller number like a 32bit is false economy (or a fools errand) as it will be moved from memory to cpu and vise versa, as a 64bit.</i>

change it with a cast or by defintion
`?number = (num.u8)10;`
`?number = (u8)10;`
`u8 number = 10;`

Primative types
--

the number indicate the number of bits so both i8 and u8 are 8bit numbers
u16 and i16 are 16bit numbers etc.
```javascript
num = i64;
num.i = i64;
num.u = u64;
num.f = f64;

num.u8 = u8; (char)
num.u16 = u16;
num.u32 = u32;
num.u64 = u64;

num.i8 = i8; 
num.i16 = i16; 
num.i32 = i32; 
num.i64 = i64; 

num.f32 = f32; 
num.f64 = f64; 
num.f80 = f80;
num.f128 = f128;
```
**boolean**
`true|false`

Primative number types can be treated as a boolean for conditional logic, except for a loop where it will require an explicit cast. 
`0 == false`
`non 0 == true`

i.e 
```javascript
?number = 10;

if (number) {... in this case this will be executed}
if (!number) {... doesn't get executed}

loop(number) {... will loop 10 times}

loop((boolean)number) {... will loop until number changes to 0}
```

**Integer types**
Support - numbers
i8, i16, i32, i64

**unsigned**
support numbers 0 and greater
u8, u16, u32, u64

**float**
Support decimal numbers
f32, f64
on supported architecture
f80, f128

Arrays
--
Arrays have language support and the built in array is a contiguous block of memory

Additional array types can be defined to support different stragies if the Array plan is implemented then langauge support will be resolved at compile time

An array can be defined to point to a specific memory localation

array pointing to a specific address / direct memory access
`u32 a[300] :0xA000000;`
`u32 a[] :0xA000000;`

dynamic pointer
`u64 a[buffer_length] : buffer;`
`u64 a[] : buffer;`


Code only in blocks for loop and if
--

`if (condition) {...}`
`loop(condition) {...}`

strongly typed
--
All types must be resoved at compile time.

annonymous params
--
methods and loops can have annonymous params starting with `$` and going from `a..z` i.e
`$a, $b, $c`
```javascript
num add(num, num) {
    return $a + $b;
}
```

Strings
--

Strings internaly are a String Object which is a wrapper for a C style zero terminated char *

There is also the option to declare a C style zero terminated char* directly using the \` quotes

<code style="color:orange">'asdkf;"asd'</code>
<code style="color:orange">"asdfs 'sadf"</code>
Multiline
<code style="color:orange">'''asld;
asdl;'''</code>

A C Style zer terminated String
\`String value\`
```javascript
External.stdio.printf(`print this %lu`, value);
```

switch
--
switch includes range
```javascript
switch(ch) {
    case 'a'..'z','A'..'Z','0'..'9' : ...; break;
    defaulf:
}
```

`if (value in 1..5) {...}`

class properties
--
Default accessors **public get** and **public set**

All class properties a wrapped with accessors and mutators by default. and sit in the **properties** section of the class definition.

definition
[([get], [set])] properties {
    &nbsp;[([set], [set])] &lt;Type&gt; &lt;name&gt;;
}
example 

Using all defaults:
```javascript
class Person {
    properties {  // public get, public set
        String name;
    }
}
```
or
```javascript
class Person {
    (,)properties {  //  public get, public set
        (,)String name; // public get, public set
    }
}

```

Specific accessors
```javascript
class Person {
    (public, private) properties {  // the class defaults are now set to public get, private set
        (protected, protected) String name; // this methods has overridden the class default with protected get, protected set 
    }
}
```
With accessor and mutator overrides overides

<i>the idea behind this design is if a type has to change unless there is a major piece of code in the getter or setter then only the property definition needs to change and not the funtions

so in the following example if I defined the following property to count all the unique ip address on the internet, then after some time I realise there are more than 256 of them, I can change number to a u16. 
</i>

```javascript
class Person {
    (public, private) properties {   // the class defaults are now set to public get, private set
        (protected, protected) u8 number;  // this methods has overridden the class default with protected get, protected set 
    }

    // not required
    get number {
        return name;
    }

    // not required
    set number {
        name = $a;
    }
}
```

class constructors
--
A constructor can be defined with parameters to set properties directly with `=<property name>` so in the following example, a constructor will be created with a parameter of the same type as the property `size` and set the value of size when the class is called.

```javascript
class AlphaRefArray {
    properties {
        u64 size = 1;
    }

    AlphaRefArray(=size);
    ...
}
```

Derived type
--
All types must be resolve able at compile time

?varname = value;
var varname = value;

i.e
?count = 10;
var count = 10;

loops
--
loop exit - break, return, return.add;
loop goto next iteration - continue;

4 loop types
* boolean `loop(true) {...}` while(boolean)
* number `loop(10) {...}` 0 -> 9
* range `loop(10..20) {...}` 10 -> 20
* iterator `loop(items) {...}` iterate a list

* number `loop(-10) {...}` count down from 10 to 0

**named param**
iterator `loop(items) item {...}`
range `loop(20..10) i {...}`

Loop return 
--
The $return is the type of the cast

Boolean loop, loop until true
```javascript
?hasOne = (boolean)loop(items) {
    $return = $a.value;
}
```
num loop, loop for all
```javascript
?count = (num)loop(items) {
    if ($a.value) {
        $return++;
    }
}
```
Array loop, loop for all
```javascript
?subSet = (Item[])loop(items) {
    if ($a.value) {
        $return.add($a);
    }
}
```

and should it support?
`?hasOne = (boolean)loop(items) {$a.value;}`
// if true inc
`?count = (num)loop(items) {$a.value;}`
// if true add `$a` to result
`?subSet = (Item[])loop(items) {$a.value;}`

New class instances
---

The keyword new is not required

```javascript
MyClass myClass();
?myClass = MyClass();
```

Comments
---
`/** Comments are markdown */` 
`/* standard text */` 
`//` line comment

Functions
---

Usage model

The variable type is function, but the method description also needs to be defined

`function x;` is invalid as there is no function definition

the definition is <return_type>([parameters..])

Multi parameter definition
.. is any Object (not primative)
int.. is any number of int
Object.. == ..
String.. any number of String

As parameters can be annoymous (they must be typed but naming is optional)

so void(int, int, int) with create a function definiton that accepts 3 int parameters and returns nothing, 
the implementaion can use annonymous params where in the function body \$a is the first param, \$b is the second etc.. up to \$z

```javascript
() {
    $a + $b + $c;
}
```
or
```javascript
(a, b, c) {
    a + b + c;
}
```

```javascript
function x := void(int, int, int) = (a,b,c) {}
?x := void(int, int, int) = (a,b,c) {}
?x := void(int, int, int);
x = (a,b,c) {}
function x := void(int, int, int) = (){$a, $b, $c}


int getValues(function x := int(int));

?x = getValues((a) {return a;});
?x = getValues(() {return $a;});
mlClass.newname = (a) {this.name = a;};
```

Using 'External' c functions
---
External is not really the right word, the compiler generates C code, all C functions an libraries are that are available at compile time can be referenced.

External function calls are not validated to the EC compiler they are validated by the C compiler. (this may have to change in the future).

Using external may lead to resource leaks, so ensure you manage resources related to external calls.

This gives the option to include exsiting or new C Libraries.

Don't confuse C with C++.

The convention is
`External.<c header>.<function and parameters>`

The `#include` for the C header file will be generated

i.e
```javascript
int res = External.stdio.printf(`hello world!`);
i64 value = External.stdlib.atol(`1001`);
```

To prototype an external function use standard function prototyping.
```javascript
function External.stdio.printf := int(pointer, ..);
```

try, catch, finally
---
Exception blocks are supported


Class Internals
---

Classes are all resolved at complie time and classes have all there parent properties merged into this class rather than a pointer to the parent class

The struct will have a specific order with the parent variables first

A static class function object tree will be constructed at compile time and loaded at runtime, this can also be used to introspection?

So an object in memory will just be it internal data

The Object reference table will contain a reference to the object type and the object data, the object type is where the function pointers are resolved from.

Static functions and non-oo functions will be access directly - constructors are static functions.

what the result would look like in C
```javascript
struct MyClassFunctionPointers {
    BaseClass super;
    // this classes function pointers and all parent classes function pointers rolled up
    void (*functionName)(ObjectReference, int) = &fun; 
    ...
    asString(ObjectReference);
    asHash(ObjectReference);
    equals(ObjectReference);

} ClassFunctionPointers;
```


