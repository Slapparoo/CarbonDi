// Core.Pointer
#include "Core.Core_main.h"
#include "Core.Pointer.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Boxing.h"
#include "Core.BaseBoxing.h"
#include "Core.B8.h"
#include "Core.U8.h"
#include "Core.I8.h"
#include "Core.I16.h"
#include "Core.U16.h"
#include "Core.I32.h"
#include "Core.U32.h"
#include "Core.F32.h"
#include "Core.I64.h"
#include "Core.U64.h"
#include "Core.F64.h"
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/int c_2106303_Pointerdatatype(){

u64 entry__ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_pointer_(), entry__);
}


/*fd1*/pointer c_2106303_Pointertypename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("pointer", entry__);
}


/*fd1*/pointer c_2106303_PointerasStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%p", /*te14a*/((c_2106303_Pointer_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/pointer c_2106303_PointerclassName(){
  return  "Core.Pointer";
}


/*fd1*/pointer c_2106303_PointerclassShortName(){
  return  "Pointer";
}


/*fd1*/pointer c_2106303_PointerclassCName(){
  return  "c_2106303_Pointer";
}


/*fd1*/pointer c_2106303_PointerclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_PointerobjectDatasize(){
  return  sizeof(c_2106303_Pointer);
}










/*fd1*/pointer c_2106303_Pointerget_value(num this){
  return  ((c_2106303_Pointer*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_Pointerset_value(num this, pointer a__a){
/*cda1*/((c_2106303_Pointer*)useObject(this)->data)->value = a__a;
}


void c_2106303_Pointer_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Pointer() {
  c_2106303_Pointer * _c_2106303_Pointer = ec_calloc(sizeof(c_2106303_Pointer), sizeof(char));
/*cdv1*/((c_2106303_Pointer*)_c_2106303_Pointer)->instanceName = c_2106303_PointerclassName();
  return createObject(_c_2106303_Pointer, getc_2106303_Pointer_cm(), false);
}

c_2106303_Pointer_cm _c_2106303_Pointer_cm;
boolean _c_2106303_Pointer_init = false;
pointer getc_2106303_Pointer_cm() {
  if (!_c_2106303_Pointer_init) {
    registerClassModel(&_c_2106303_Pointer_cm);
    populatec_2106303_Pointer_cm(&_c_2106303_Pointer_cm);
    _c_2106303_Pointer_init = true;
  }
  return &_c_2106303_Pointer_cm;
}


/* default constructor */
num create_c_2106303_Pointer_1(/* param *//*va1*/pointer value) {
num this =  create_c_2106303_Pointer();

((c_2106303_Pointer_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_Pointer_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_Pointer_cm* thisClassModel = (c_2106303_Pointer_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_Pointerdatatype;
  thisClassModel->typename = c_2106303_Pointertypename;
  thisClassModel->asStr = c_2106303_PointerasStr;
  thisClassModel->className = c_2106303_PointerclassName;
  thisClassModel->classShortName = c_2106303_PointerclassShortName;
  thisClassModel->classCName = c_2106303_PointerclassCName;
  thisClassModel->classPackage = c_2106303_PointerclassPackage;
  thisClassModel->objectDatasize = c_2106303_PointerobjectDatasize;
  thisClassModel->get_value = c_2106303_Pointerget_value;
  thisClassModel->set_value = c_2106303_Pointerset_value;
  thisClassModel->free = c_2106303_Pointer_free;
}

