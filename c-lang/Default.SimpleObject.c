// SimpleObject
#include "Default.SimpleObject.h"
#include "Core.Array.h"
#include "Core.Object.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Default.SimpleObject.h"
#include "types.h"

i64 a1909326430_constNumber() {

  __onEnter(); /*class ec.lang.defs.expressions.ReturnExpr*/
  return __exitReturn_i64(66);
}

pointer a1909326430_getClassName() { /*class ec.lang.defs.DirectStatement*/ return "SimpleObject"; }

pointer a1909326430_getClassPackage() { /*class ec.lang.defs.DirectStatement*/ return "Default"; }

u64 a1909326430_getObjectDatasize() { /*class ec.lang.defs.DirectStatement*/ return sizeof(SimpleObject); }

i64 a1909326430_get_count1(num _refId) {
  /*class ec.lang.defs.DirectStatement*/ return ((SimpleObject *)useObject(_refId)->data)->count1;
}

void a1909326430_set_count1(num _refId, i64 count1) {
  /*class ec.lang.defs.DirectStatement*/ ((SimpleObject *)useObject(_refId)->data)->count1 = count1;
}

i64 a1909326430_get_count3(num _refId) {
  /*class ec.lang.defs.DirectStatement*/ return ((SimpleObject *)useObject(_refId)->data)->count3;
}

void a1909326430_set_count3(num _refId, i64 count3) {
  /*class ec.lang.defs.DirectStatement*/ ((SimpleObject *)useObject(_refId)->data)->count3 = count3;
}

i64 a1909326430_get_count2() {
  /*class ec.lang.defs.DirectStatement*/ return ((SimpleObjectClassModel *)getSimpleObjectClassModel())->count2;
}

void a1909326430_set_count2(i64 count2) {
  /*class ec.lang.defs.DirectStatement*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->count2 = count2;
}

void a1909326430__free(num _refId) { Object_ref *object_ref = useObject(_refId); }

num create_SimpleObject() {
  SimpleObject *_SimpleObject = ec_calloc(sizeof(SimpleObject), sizeof(char));
  /*cdv1*/ ((SimpleObject *)_SimpleObject)->count1 = /* undefined */ 12;
  /*cdv1*/ ((SimpleObject *)_SimpleObject)->count3 = /* undefined */ 27;
  return createObject(_SimpleObject, getSimpleObjectClassModel(), false);
}

pointer _SimpleObjectClassModel = NULL;
pointer getSimpleObjectClassModel() {
  if (_SimpleObjectClassModel == NULL) {
    _SimpleObjectClassModel = ec_malloc(sizeof(SimpleObjectClassModel));
    registerClassModel(_SimpleObjectClassModel);
    populateSimpleObjectClassModel(_SimpleObjectClassModel);
  }
  return _SimpleObjectClassModel;
}

/* default constructor */
num create_SimpleObject$1(/* param */ i64 count1) {
  num this = create_SimpleObject();

  ((SimpleObjectClassModel *)useObject(this)->classmodel)->set_count1(this, count1);

  return this;
}
void populateSimpleObjectClassModel(pointer classModel) {
  populateObjectClassModel(classModel);
  populateObjectClassModel(classModel);
  SimpleObjectClassModel *thisClassModel = (SimpleObjectClassModel *)classModel;
  thisClassModel->parent = getObjectClassModel();
  thisClassModel->constNumber = a1909326430_constNumber;
  thisClassModel->getClassName = a1909326430_getClassName;
  thisClassModel->getClassPackage = a1909326430_getClassPackage;
  thisClassModel->getObjectDatasize = a1909326430_getObjectDatasize;
  thisClassModel->get_count1 = a1909326430_get_count1;
  thisClassModel->set_count1 = a1909326430_set_count1;
  thisClassModel->get_count3 = a1909326430_get_count3;
  thisClassModel->set_count3 = a1909326430_set_count3;
  thisClassModel->get_count2 = a1909326430_get_count2;
  thisClassModel->set_count2 = a1909326430_set_count2;
  /*cds1*/ thisClassModel->count2 = /* undefined */ 51;
  thisClassModel->free = a1909326430__free;
}
