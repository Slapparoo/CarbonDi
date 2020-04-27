// Default.NewDynamicArray Signature compiled
/* imports {} */

public class signature Default.NewDynamicArray(Core.Array){
  (public,public) properties {
    (public,public) u64 startIndex;
    (public,public) u64 endIndex;
    (public,public)  static u64 initialSize;
    (public,public)  static u64 growBy;
    (public,public)  static u64 slideAmount;
    (public,public) pointer values;
    (public,public) u64 length;
    (public,public) u64 capacity;
    (public,public) int dataType;
    (public,public) u64 dataSize;
    (public,public) boolean managed;
  }

  /* default constructor */
  public NewDynamicArray(int dataType, u64 dataSize);
  public NewDynamicArray(u64 capacity, int dataType, u64 dataSize);
  public NewDynamicArray(u64 capacity, int dataType, u64 dataSize, pointer values);

  public pointer getValue(u64 index);
  public void setValue(u64 index, pointer value);
  public void addTail(pointer value);
  public void addHead(pointer value);
  public void insert(u64 index, pointer value);
  public pointer removeHead();
  public pointer removeTail();
  public pointer remove(u64 index, pointer value);
  public pointer peekTail();
  public pointer peekHead();
  private void addCapacityHead();
  private void addCapacityTail();
  private void reduceCapacityHead();
  private void reduceCapacityTail();
  private void realignLeft();
  private void slideLeft();
  private void slideRight();
  public static final pointer getClassName();
  public static final pointer getClassShortName();
  public static final pointer getClassCName();
  public static final pointer getClassPackage();
  public static final u64 getObjectDatasize();
  public pointer get(u64 b);
  public void set(u64 b, pointer c);
  public u64 memsize();
  public pointer typename();
  public final pointer getObjectData();
  public pointer asStr();
  public void printTo(pointer stream);
  public String asString();
  public i64 hashCode();
  public boolean equals(Object other);
  hidden final void free();
  hidden void release();
  public final pointer alloc(u64 size);
}