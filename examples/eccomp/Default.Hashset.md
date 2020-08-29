class Default.Hashset extends [Core.Object](Core.Object.md)
===
hash map store, relitively light weight implementation don't expect to much from it.
---
Properties
---
|type|name|read|write|value|comments|
|--- |--- |--- |--- |--- |--- |
|u64|__items__|public|public|0||
|u64|__size__|public|public|256||
|RefArray|__list__|public|public|||
|boolean|__isInit__|public|public|false||
|pointer|__instanceName__|public|public|||

---
Constructors
---

__`public Hashset()`__
<div style="margin:1em">

</div>


__`public Hashset(u64 size)`__
<div style="margin:1em">

</div>


---
Functions
---

__`private void reHash(Object object)`__
<div style="margin:1em">

</div>


__`private void startup()`__
<div style="margin:1em">

</div>


__`public boolean contains(Object object)`__
<div style="margin:1em">

</div>


__`public void add(Object object)`__
<div style="margin:1em">

</div>


__`private void addNew(RefArray newlist,Object object)`__
<div style="margin:1em">

</div>

