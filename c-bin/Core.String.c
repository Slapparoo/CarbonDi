// Core.String
#include "Core.String.h"
#include "Core.Array.h"
#include "Core.B8.h"
#include "Core.BaseBoxing.h"
#include "Core.Boxing.h"
#include "Core.Core_main.h"
#include "Core.Exception.h"
#include "Core.F32.h"
#include "Core.F64.h"
#include "Core.I16.h"
#include "Core.I32.h"
#include "Core.I64.h"
#include "Core.I8.h"
#include "Core.Object.h"
#include "Core.Pointer.h"
#include "Core.RefArray.h"
#include "Core.U16.h"
#include "Core.U32.h"
#include "Core.U64.h"
#include "Core.U8.h"

pointer c_2106303_StringasStr(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_pointer_un(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this), entry$);
}

num c_2106303_StringasString(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_ref_un(this, entry$);
}

u64 c_2106303_Stringlength(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_u64_un(strlen(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this)), entry$);
}

pointer c_2106303_StringgetClassName() { return "Core.String"; }

pointer c_2106303_StringgetClassShortName() { return "String"; }

pointer c_2106303_StringgetClassCName() { return "c_2106303_String"; }

pointer c_2106303_StringgetClassPackage() { return "Core"; }

u64 c_2106303_StringgetObjectDatasize() { return sizeof(c_2106303_String); }

pointer c_2106303_Stringget_value(num this) { return ((c_2106303_String *)useObject(this)->data)->value; }

void c_2106303_Stringset_value(num this, pointer value) { ((c_2106303_String *)useObject(this)->data)->value = value; }

void c_2106303_String_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_2106303_String() {
  c_2106303_String *_c_2106303_String = ec_calloc(sizeof(c_2106303_String), sizeof(char));
  return createObject(_c_2106303_String, getc_2106303_String_cm(), false);
}

c_2106303_String_cm _c_2106303_String_cm;
boolean _c_2106303_String_init = false;
pointer getc_2106303_String_cm() {
  if (!_c_2106303_String_init) {
    registerClassModel(&_c_2106303_String_cm);
    populatec_2106303_String_cm(&_c_2106303_String_cm);
    _c_2106303_String_init = true;
  }
  return &_c_2106303_String_cm;
}

num create_c_2106303_String$1(pointer str) {
  num this = create_c_2106303_String();

  {

    __onEnter();
    i64 len = strlen(str) + 1;
    ((c_2106303_String_cm *)useObject(this)->classmodel)
        ->set_value(this, ((c_2106303_String_cm *)useObject(this)->classmodel)->alloc(this, len));
    strcpy(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this), str);

    __onExit();
  }

  return this;
}

num create_c_2106303_String$2(pointer str, boolean staticAlloc) {
    num this = create_c_2106303_String();
    if (staticAlloc) {
      ((c_2106303_String_cm *)useObject(this)->classmodel)->set_value(this, str);
    } else {
      i64 len = strlen(str) + 1;
      ((c_2106303_String_cm *)useObject(this)->classmodel)
          ->set_value(this, ((c_2106303_String_cm *)useObject(this)->classmodel)->alloc(this, len));
      strcpy(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this), str);
    }

  return this;
}
num create_c_2106303_String$3(pointer str, pointer str2) {
  num this = create_c_2106303_String();

  {

    __onEnter();
    i64 len = strlen(str) + strlen(str2) + 1;
    ((c_2106303_String_cm *)useObject(this)->classmodel)
        ->set_value(this, ((c_2106303_String_cm *)useObject(this)->classmodel)->alloc(this, len));
    strcpy(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this), str);
    strcat(((c_2106303_String_cm *)useObject(this)->classmodel)->get_value(this), str2);

    __onExit();
  }

  return this;
}
void populatec_2106303_String_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_2106303_String_cm *thisClassModel = (c_2106303_String_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->asStr = c_2106303_StringasStr;
  thisClassModel->asString = c_2106303_StringasString;
  thisClassModel->length = c_2106303_Stringlength;
  thisClassModel->getClassName = c_2106303_StringgetClassName;
  thisClassModel->getClassShortName = c_2106303_StringgetClassShortName;
  thisClassModel->getClassCName = c_2106303_StringgetClassCName;
  thisClassModel->getClassPackage = c_2106303_StringgetClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_StringgetObjectDatasize;
  thisClassModel->get_value = c_2106303_Stringget_value;
  thisClassModel->set_value = c_2106303_Stringset_value;
  thisClassModel->free = c_2106303_String_free;
}
