class Core.DynamicArray extends [Core.Array](Core.Array.md)
===
All singing all dancing Dynamic array can be used as 
* stack
* queue
* list
* buffer
* lifo
* fifo
---
Properties
---
|type|name|read|write|value|comments|
|--- |--- |--- |--- |--- |--- |
|u64|__startIndex__|public|public||Used internally to maintain the          current position|
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

`public DynamicArray()`
<div style="margin:1em">

</div>


`public DynamicArray(int dataType,u64 dataSize)`
<div style="margin:1em">

</div>


`public DynamicArray(u64 capacity,int dataType,u64 dataSize)`
<div style="margin:1em">

</div>


`public DynamicArray(u64 capacity,int dataType,u64 dataSize,pointer values)`
<div style="margin:1em">

</div>


---
Functions
---

`public pointer getValue(u64 index)`
<div style="margin:1em">

return a pointer to the array content</div>


`public void setValue(u64 index,pointer value)`
<div style="margin:1em">

Used internaly to set a value for arrays use:
    ```myarray[0] = value;```</div>


`public void addTail(pointer value)`
<div style="margin:1em">

</div>


`public void addHead(pointer value)`
<div style="margin:1em">

</div>


`public void insert(u64 index,pointer value)`
<div style="margin:1em">

</div>


`public pointer removeHead()`
<div style="margin:1em">

</div>


`public pointer removeTail()`
<div style="margin:1em">

</div>


`public pointer remove(u64 index,pointer value)`
<div style="margin:1em">

</div>


`public pointer peekTail()`
<div style="margin:1em">

</div>


`public pointer peekHead()`
<div style="margin:1em">

</div>


`private void addCapacityHead()`
<div style="margin:1em">

</div>


`private void addCapacityTail()`
<div style="margin:1em">

</div>


`private void reduceCapacityHead()`
<div style="margin:1em">

</div>


`private void reduceCapacityTail()`
<div style="margin:1em">

</div>


`private void realignLeft()`
<div style="margin:1em">

</div>


`private void slideLeft()`
<div style="margin:1em">

</div>


`private void slideRight()`
<div style="margin:1em">

</div>

