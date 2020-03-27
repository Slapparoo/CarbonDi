#include "types.h"

Object_ref *poorMansMap[PM_LIST_LENGTH];
num refStack[PM_LIST_LENGTH];
num refStackIndex = 0;

/**
 * used when variable or property is assgined a value
 */
void assignObject(num *var, num ref_id) {
  // release the old value
  if (var[0] > 1) {
    returnObject(var[0]);
    var[0] = 0;
  }
  // assign the new
  if (ref_id > 1) {
    var[0] = ref_id;
    borrowObject(ref_id);
  }
}

Object_ref *borrowObject(num ref) {
  // find object
  Object_ref *object_ref = poorMansMap[ref];

  // inc ref counter
  object_ref->refCounter++;

  // debug -->
  printf("Object borrow, %s::%s ref:%ld counter=%ld\n", object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref->refCounter);
  // <--

  // return
  return object_ref;
}

// used in destructors
Object_ref *useObject(num ref) { return poorMansMap[ref]; }

void returnObject(num ref) {
  if (ref < 1) {
    printf("(returnObject(ref:%ld)) attempting to return invalid Object\n", ref);
    return;
  }

  Object_ref *object_ref = poorMansMap[ref];
  // inc ref counter
  object_ref->refCounter--;

  printf("Object returned, %s::%s ref:%ld counter=%ld\n", object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref->refCounter);

  if (object_ref->refCounter == 0) {
    // dereferenced deallocate etc
    // call the class destructor(s)

    object_ref->classmodel->free(ref);
    ClassModel *cm = object_ref->classmodel->parent;

    void *l_free = object_ref->classmodel->free;
    while (cm) {
      // don't call the same free twice
      if (l_free != cm->free) {
        cm->free(ref);
      }
      l_free = cm->free;
      cm = cm->parent;
    }

    if (!object_ref->is_stack) {
      free(object_ref->data);
    }
    free(object_ref);
    poorMansMap[ref] = NULL;

    printf("freed %ld\n", ref);
    // *ref = -1;
  }
}

/**
 * create an unallocated object
 */
// i64 createObject(i64 size, ClassModel *class_model) {
//   return createObject(malloc(size), class_model);
// }

void __onEnter() {
  // [id, id, id, count, id, id, count, id, id, id, count]
  // or [id, id, id, 0, id, id, 0, id, id, id, 0, id]
  // push(0);
  refStack[refStackIndex++] = 0;
};

void __onExit() {
  // pop until 0
  num id = refStack[--refStackIndex];
  while (id != 0) {
    returnObject(id);
    id = refStack[--refStackIndex];
  }
};

num createObject(void *object_data, ClassModel *class_model, boolean is_stack) {
  // load the class model into cache read-only
  __builtin_prefetch (class_model, 0, 3);
  __builtin_prefetch (object_data, 1, 3);

  num id = -1;
  for (int i = 1; i < PM_LIST_LENGTH; i++) {
    if (poorMansMap[i] == NULL) {
      id = i;
      break;
    }
  }

  // bounds check
  if (id < 1) {
    // bugger - in the future the map will be a proper one that can grwo etc...
    printf("Out of memory Exception");
    exit(1);
  }

  printf("create object, %s::%s ref:%ld \n", class_model->package, class_model->name, id);

  struct Object_ref *ref = (Object_ref *)malloc(sizeof(struct Object_ref));
  __builtin_prefetch (ref, 1, 3);

  ref->data = object_data;
  ref->classmodel = class_model;
  ref->refCounter = 1;
  ref->is_stack = is_stack;

  // add to map
  poorMansMap[id] = ref;
  refStack[refStackIndex++] = id;
  // return
  return id;
}

/**
 * creats a mem copy of a string which will need to be freed
 */
Str returnStrCopy(Str str) {
  Str res = (Str)malloc(strlen(str)+1);
  strcpy(res, str);
  return res;
}

u8 tmpBuffer[1024];

Str Object_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  sprintf(tmpBuffer, "ref:%ld, ref*=%p, data*=%p, class*=%p, refCount=%ld", ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter);
  return tmpBuffer;
}

void Object_printTo(num ref, FILE *stream) {
  Object_ref *object_ref = useObject(ref);
  fprintf(stream,
          "(Object_printTo) %s::%s ref:%ld, ref*=%p, data*=%p, class*=%p, "
          "refCount=%ld, is_stack=%s\n",
          object_ref->classmodel->package, object_ref->classmodel->name, ref, object_ref, object_ref->data, object_ref->classmodel, object_ref->refCounter, object_ref->is_stack ? "true" : "false");
}

Str String_asStr(num ref) {
  Object_ref *object_ref = useObject(ref);
  return ((String *)object_ref->data)->str;
}

void String_printTo(num ref, FILE *stream) {
  Object_ref *object_ref = useObject(ref);

  object_ref->classmodel->parent->printTo(ref, stream);
  fprintf(stream, "(String_printTo) %s\n", ((String *)object_ref->data)->str);
}
/*
String *newString(Str str) {
  struct String *string = (String *)malloc(sizeof(struct String));
  string->str = (Str)malloc(strlen(str));
  strcpy(string->str, str);
  string->len = strlen(str);
}
*/
void String_free(num ref) {
  Object_ref *object_ref = useObject(ref);
  // cast to our type
  String *string = (String *)object_ref->data;

  printf("String_free\n");
  // other object variables referenced by type will need to be freed? have their
  // ref counter decremented
  free(string->str);
}

void Object_free(num ref) {
  // Object_ref *object_ref = useObject(ref);
  printf("Object_free\n");
}

// void startScope() {
//   //
// }

// void endScope() {
//   // dereference temps
//   // returnObject(&id2,...);
// }

ObjectClassModel *_objectClassModel = NULL;
Str _ObjectName = NULL;
Str _PackageName = NULL;

ObjectClassModel *getObjectClassModel() {
  if (_objectClassModel == NULL) {
    _objectClassModel = malloc(sizeof(ObjectClassModel));
    _ObjectName = malloc(7);
    strcpy(_ObjectName, "Object");
    _PackageName = malloc(5);
    strcpy(_PackageName, "Core");

    populateObjectClassModel(_objectClassModel);
  }
  return _objectClassModel;
}

void populateObjectClassModel(void *_classModel) {
  ObjectClassModel *classModel = (ObjectClassModel *)_classModel;
  classModel->parent = NULL;
  classModel->name = _ObjectName;
  classModel->package = _PackageName;
  classModel->asStr = &Object_asStr;
  classModel->asString = NULL;
  classModel->free = &Object_free;
  classModel->printTo = &Object_printTo;
}

/***
 * String
 */
StringClassModel *_stringClassModel = NULL;

void populateStringClassModel(void *_classModel) {
  populateObjectClassModel(_classModel);

  StringClassModel *classModel = (StringClassModel *)_classModel;

  classModel->parent = getObjectClassModel();
  classModel->name = "String";
  classModel->package = "Core";
  classModel->asStr = &String_asStr;
  // classModel->asString = &String_asString;
  classModel->free = &String_free;
  classModel->printTo = &String_printTo;
}

StringClassModel *getStringClassModel() {
  if (_stringClassModel == NULL) {
    _stringClassModel = malloc(sizeof(StringClassModel));
    populateStringClassModel(_stringClassModel);
  }
  return _stringClassModel;
}

i64 String_create(Str string) {
  String *_String = malloc(sizeof(String));
  _String->len = strlen(string);
  _String->str = malloc(_String->len + 1);
  strcpy(_String->str, string);
  return createObject(_String, (ClassModel *)getStringClassModel(), false);
}
