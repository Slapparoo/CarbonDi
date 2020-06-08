class Core.DynamicArray extends [Core.Array](Core.Array.md)
===

---
Properties
---
|type|name|read|write|value|comments|
|--- |--- |--- |--- |--- |--- |
|u64|__startIndex__|public|public|||
|u64|__endIndex__|public|public|||
|pointer|__values__|public|public|||
|u64|__length__|public|public|||
|u64|__capacity__|public|public|||
|int|__dataType__|public|public|||
|u64|__dataSize__|public|public|||
|boolean|__managed__|public|public|||

---
Static Properties
---
|type|name|read|write|value|comments|
|--- |--- |--- |--- |--- |--- |
|u64|__initialSize__|public|public|8||
|u64|__growBy__|public|public|8||
|u64|__slideAmount__|public|public|4||

---
Constructors
---

__`public DynamicArray()`__
<div style="margin:1em">

</div>


__`public DynamicArray(int dataType,u64 dataSize)`__
<div style="margin:1em">

</div>


__`public DynamicArray(u64 capacity,int dataType,u64 dataSize)`__
<div style="margin:1em">

</div>


__`public DynamicArray(u64 capacity,int dataType,u64 dataSize,pointer values)`__
<div style="margin:1em">

</div>


---
Functions
---

__`public pointer getValue(u64 index)`__
<div style="margin:1em">

</div>


__`public void setValue(u64 index,pointer value)`__
<div style="margin:1em">

</div>


__`public void addTail(pointer value)`__
<div style="margin:1em">

</div>


__`public void addHead(pointer value)`__
<div style="margin:1em">

</div>


__`public void insert(u64 index,pointer value)`__
<div style="margin:1em">

</div>


__`public pointer removeHead()`__
<div style="margin:1em">

</div>


__`public pointer removeTail()`__
<div style="margin:1em">

</div>


__`public pointer remove(u64 index,pointer value)`__
<div style="margin:1em">

</div>


__`public pointer peekTail()`__
<div style="margin:1em">

</div>


__`public pointer peekHead()`__
<div style="margin:1em">

</div>


__`private void addCapacityHead()`__
<div style="margin:1em">

</div>


__`private void addCapacityTail()`__
<div style="margin:1em">

</div>


__`private void reduceCapacityHead()`__
<div style="margin:1em">

</div>


__`private void reduceCapacityTail()`__
<div style="margin:1em">

</div>


__`private void realignLeft()`__
<div style="margin:1em">

</div>


__`private void slideLeft()`__
<div style="margin:1em">

</div>


__`private void slideRight()`__
<div style="margin:1em">

</div>

