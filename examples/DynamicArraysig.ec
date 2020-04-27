
/**
All singing all dancing Dynamic array can be used as 
* stack
* queue
* list
* buffer
* lifo
* fifo

*/

public class signature Core.DynamicArray (Core.Array){
    (public,public) properties {
        pointer values;
        u64 length;
        u64 capacity;
        int dataType;
        u64 dataSize;
        boolean managed;
        u64 startIndex;
        u64 endIndex;

        static u64 initialSize = 64;
        static u64 growBy = 64;
        static u64 slideAmount = 8;
    }

    public pointer getValue(u64 index)
    ;

    public void setValue(u64 index, pointer value)
    ;
    public void addTail(pointer value)
    ;

    public void addHead(pointer value)
    ;

    public void insert(u64 index, pointer value)
    ;

    public pointer removeHead() 
    ;
    
    public pointer removeTail() 
    ;

    public pointer remove(u64 index, pointer value) 
    ;

    public pointer peekTail();
    public pointer peekHead();
    private void addCapacityHead() 
    ;

    private void addCapacityTail() 
    ;

    private void reduceCapacityHead() 
    ;

    private void reduceCapacityTail() 
    ;

    private void realignLeft() 
    ;


    private void slideLeft() 
    ;

    private void slideRight() 
    ;
}