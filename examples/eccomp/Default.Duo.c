// Default.Duo
#include "Default.Duo.h"
#include "Core.Core_main.h"
#include "Default.Hashset.h"

/*fd1*/ pointer c_1085510111_DuoclassName() { return "Default.Duo"; }

/*fd1*/ pointer c_1085510111_DuoclassShortName() { return "Duo"; }

/*fd1*/ pointer c_1085510111_DuoclassCName() { return "c_1085510111_Duo"; }

/*fd1*/ pointer c_1085510111_DuoclassPackage() { return "Default"; }

/*fd1*/ u64 c_1085510111_DuoobjectDatasize() { return sizeof(c_1085510111_Duo); }

/*fd1*/ num c_1085510111_Duoget_one(num this) { return ((c_1085510111_Duo *)useObject(this)->data)->one; }

/*fd1*/ void c_1085510111_Duoset_one(num this, num a__a) { /*cda2*/
  assignObject(&((c_1085510111_Duo *)useObject(this)->data) /*cda3*/->one, a__a);
}

/*fd1*/ num c_1085510111_Duoget_two(num this) { return ((c_1085510111_Duo *)useObject(this)->data)->two; }

/*fd1*/ void c_1085510111_Duoset_two(num this, num a__a) { /*cda2*/
  assignObject(&((c_1085510111_Duo *)useObject(this)->data) /*cda3*/->two, a__a);
}

void c_1085510111_Duo_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_Duo *)object_ref->data)->one);
  returnObject(((c_1085510111_Duo *)object_ref->data)->two);
}

num create_c_1085510111_Duo() {
  c_1085510111_Duo *_c_1085510111_Duo = ec_calloc(sizeof(c_1085510111_Duo), sizeof(char));
  /*cdv1*/ ((c_1085510111_Duo *)_c_1085510111_Duo)->instanceName = c_1085510111_DuoclassName();
  return createObject(_c_1085510111_Duo, getc_1085510111_Duo_cm(), false);
}

c_1085510111_Duo_cm _c_1085510111_Duo_cm;
boolean _c_1085510111_Duo_init = false;
pointer getc_1085510111_Duo_cm() {
  if (!_c_1085510111_Duo_init) {
    registerClassModel(&_c_1085510111_Duo_cm);
    populatec_1085510111_Duo_cm(&_c_1085510111_Duo_cm);
    _c_1085510111_Duo_init = true;
  }
  return &_c_1085510111_Duo_cm;
}

/* default constructor */
void populatec_1085510111_Duo_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_Duo_cm *thisClassModel = (c_1085510111_Duo_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->className = c_1085510111_DuoclassName;
  thisClassModel->classShortName = c_1085510111_DuoclassShortName;
  thisClassModel->classCName = c_1085510111_DuoclassCName;
  thisClassModel->classPackage = c_1085510111_DuoclassPackage;
  thisClassModel->objectDatasize = c_1085510111_DuoobjectDatasize;
  thisClassModel->get_one = c_1085510111_Duoget_one;
  thisClassModel->set_one = c_1085510111_Duoset_one;
  thisClassModel->get_two = c_1085510111_Duoget_two;
  thisClassModel->set_two = c_1085510111_Duoset_two;
  thisClassModel->free = c_1085510111_Duo_free;
}
