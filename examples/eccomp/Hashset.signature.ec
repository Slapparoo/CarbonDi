// Default.Duo Signature compiled
/* imports {} */

public
class signature Default.Duo(Core.Object) {
  (public, public) properties {
    (public, public) Object one;
    (public, public) Object two;
    (public, public) pointer instanceName;
  }

  /* default constructor */

public
  static final pointer className();
public
  static final pointer classShortName();
public
  static final pointer classCName();
public
  static final pointer classPackage();
public
  static final u64 objectDatasize();
public
  pointer asStr();
public
  void printTo(pointer stream);
public
  pointer objectData();
public
  i32 hashCode();
public
  boolean equals(Object other);
  hidden final void free();
  hidden void release();
public
  final pointer alloc(u64 size);
public
  final pointer realloc(pointer ptr, u64 size);
} // Default.Hashset Signature compiled
/* imports {} */

public
class signature Default.Hashset(Core.Object) {
  (public, public) properties {
    (public, public) u64 items;
    (public, public) u64 size;
    (public, public) RefArray list;
    (public, public) boolean isInit;
    (public, public) pointer instanceName;
  }

  /* default constructor */
public
  Hashset(u64 size);

private
  void reHash(Object object);
private
  void startup();
public
  boolean contains(Object object);
public
  void add(Object object);
private
  void addNew(RefArray newlist, Object object);
public
  static final pointer className();
public
  static final pointer classShortName();
public
  static final pointer classCName();
public
  static final pointer classPackage();
public
  static final u64 objectDatasize();
public
  pointer asStr();
public
  void printTo(pointer stream);
public
  pointer objectData();
public
  i32 hashCode();
public
  boolean equals(Object other);
  hidden final void free();
  hidden void release();
public
  final pointer alloc(u64 size);
public
  final pointer realloc(pointer ptr, u64 size);
}