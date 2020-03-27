EC lang
==

EC is a binary compilable general perpose computer language, it is based on the 'C fammily of langauges' syntax so anyone who is familier with C, C++, Java, C#, Pascal, JavaScript etc should be able to pick the langaue quite quickly. One of the design principals is that the language is low level enough that you can write an OS with it, but also general enough that is is highly productive and can be used for any general purpose task.

The langauge it self allows for a combination of procedual programming or OO programming.

Being binary compilable means that the performance should be comparable to other binary compilable langauges.

Being binary compilable means that it can use existing C libraries.

No pointers
--
Primatives are passed by by register or on the stack (as a copy) and Objects are passed by reference.

The reference is not a pointer it is a reference for the memory manager.

String is an object
```
boolean checkName(String name) {
    return name != null;
}
```

Array is an Object
```
boolean checkLength(u8[] nums) {
    return nums != null && nums.length > 0;
}
```

Same method with an annonymous parameter
```
boolean checkLength(u8[]) {
    return $a != null && $a.length > 0;
}
```

There is a default memory manager, but it can be replaced/integrated with a custom managment stratagy.

To update the value of a parameter inside a function a refernce is passed using the &

i.e
```
void addone(&num counter) {
    counter++;
}

// define variable as number the default type is i64, so count with be an i64
@counter = 10;

addOne(counter);

assert(counter == 0);
```

Default types
--
String for charator arrays 

i64 for numbers;

`@number = 10;`

number will be an i64 
<i>On a 64bit archtecture this is the way cpu's will deal with numbers the registers are 64bit when you push a value on the stack it will be 64bit (you can't push 32bits), so defining it as a smaller number like a 32bit is false economy (or a fools errand) as it will be moved from memory to cpu and vise versa, as a 64bit.</i>

change it with a cast or by defintion
`@number = (num.u8)10;`
`@number = (u8)10;`
`u8 number = 10;`

Primative types
--

the number indicate the number of bits so both i8 and u8 are 8bit numbers
u16 and i16 are 16bit numbers etc.
```
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
```
@number = 10;

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
```
num add(num, num) {
    return $a + $b;
}
```

Strings
--
<code style="color:orange">'asdkf;"asd'</code>
<code style="color:orange">"asdfs 'sadf"</code>
Multiline
<code style="color:orange">'''asld;
asdl;'''</code>

switch
--
switch includes range
```
switch(ch) {
    case 'a'..'z','A'..'Z','0'..'9' : ...; break;
    defaulf:
}
```

`if (value in 1..5) {...}`

class properties

get == read
set == write

Default accessors **public read** and **public write**

--
definition
[([read], [write])] properties {
    &nbsp;[([read], [write])] &lt;Type&gt; &lt;name&gt;;
}
example 

Using all defaults:
```
class Person {
    properties {
        String name;
    }
}
```
or
```
class Person {
    (,)properties {
        (,)String name;
    }
}

```

Specific accessors
```
class Person {
    (public, private) properties {
        (protected, protected) String name;
    }
}
```
With accessor and mutator overrides overides

<i>the idea behind this design is if a type has to change unless there is a major piece of code in the getter or setter then only the property definition needs to change and not the funtions

so in the following example if I defined the following property to count all the unique ip address on the internet, then after some time I realise there are more than 256 of them, I can change number to a u16. 
</i>

```
class Person {
    (public, private) properties {
        (protected, protected) u8 number;
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

Derived type
--
All types must be resolve able at compile time

@varname = value;
var varname = value;

i.e
@count = 10;
var count = 10;

loops
--
loop exit - break, return, return.add;
loop goto next iteration - continue;

4 loop types
* boolean `loop(true) {...}`
* number `loop(10) {...}`
* range `loop(10..20) {...}`
* iterator `loop(items) {...}`

**named param**
iterator `loop(items) item {...}`
range `loop(20..10) i {...}`

Loop return 
--
The $return is the type of the cast

Boolean loop, loop until true
```
@hasOne = (boolean)loop(items) {
    $return = $a.value;
}
```
num loop, loop for all
```
@count = (num)loop(items) {
    if ($a.value) {
        $return++;
    }
}
```
Array loop, loop for all
```
@subSet = (Item[])loop(items) {
    if ($a.value) {
        $return.add($a);
    }
}
```

and should it support?
`@hasOne = (boolean)loop(items) {$a.value;}`
// if true inc
`@count = (num)loop(items) {$a.value;}`
// if true add `$a` to result
`@subSet = (Item[])loop(items) {$a.value;}`

New class instances
---

The keyword new is not required

```
MyClass myClass();
@myClass = MyClass();
```

Comments
---
`/** Comments are markdown */` 
`/* standard text */` 
`//` line comment

Class Internals
---

Classes are all resolved at complie time and classes have all there parent properties merged into this class rather than a pointer to the parent class

The struct will have a specific order with the parent variables first

A static class function object tree will be constructed at compile time and loaded at runtime, this can also be used to introspection?

So an object in memory will just be it internal data

The Object reference table will contain a reference to the object type and the object data, the object type is where the function pointers are resolved from.

Static functions and non-oo functions will be access directly - constructors are static functions.


struct MyClassFunctionPointers {
    BaseClass super;
    // this classes function pointers and all parent classes function pointers rolled up
    void (*functionName)(ObjectReference, int) = &fun; 
    ...
    asString(ObjectReference);
    asHash(ObjectReference);
    equals(ObjectReference);

} ClassFunctionPointers;



