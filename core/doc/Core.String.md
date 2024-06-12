class Core.String extends [Core.Object](Core.Object.md)
===

---
Properties
---
|type|name|getter|setter|value|comments|
|--- |--- |--- |--- |--- |--- |
|pointer|__value__|public|public|||
|i32|__hash__|public|public|||
|pointer|__instanceName__|public|public|||

---
Constructors
---

__`private String()`__
<div style="margin:1em">

</div>


__`public String(pointer str)`__
<div style="margin:1em">

</div>


__`public String(pointer str,boolean staticAlloc)`__
<div style="margin:1em">

</div>


__`public String(pointer str,pointer str2)`__
<div style="margin:1em">

</div>


__`public String(pointer str,u64 offset,u64 len)`__
<div style="margin:1em">

</div>


---
Functions
---

__`public String asString()`__
<div style="margin:1em">

</div>


__`public u64 length()`__
<div style="margin:1em">

</div>


__`public void println()`__
<div style="margin:1em">

</div>


__`public String appendStr(pointer str)`__
<div style="margin:1em">

</div>


__`public String append(String string)`__
<div style="margin:1em">

</div>


__`public String prependStr(pointer str4)`__
<div style="margin:1em">

</div>


__`public String prepend(String string1)`__
<div style="margin:1em">

</div>


__`public i64 compareStr(pointer str5)`__
<div style="margin:1em">

</div>


__`public boolean compareSubStr(pointer str6,u64 offset)`__
<div style="margin:1em">

</div>


__`public i8 getChar(u64 offset)`__
<div style="margin:1em">

</div>


__`public boolean isSubStr(pointer str7,u64 offset)`__
<div style="margin:1em">

</div>


__`public i64 compare(String string5)`__
<div style="margin:1em">

</div>


__`public i64 findStr(i64 from,pointer str6)`__
<div style="margin:1em">

</div>


__`public i64 find(i64 from,String string6)`__
<div style="margin:1em">

</div>


__`(override) public boolean equals(String other)`__
<div style="margin:1em">

</div>


__`public void trunc(i64 start,i64 end)`__
<div style="margin:1em">

</div>


__`(override) public pointer asStr()`__
<div style="margin:1em">

</div>


__`(override) public i32 hashCode()`__
<div style="margin:1em">

</div>

