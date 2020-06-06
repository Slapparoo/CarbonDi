// Core.BaseBoxing
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
#include "Core.Object.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.Boxing.h"
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
#include "Core.Pointer.h"
#include "Core.DynamicArray.h"

/*fd1*/int c_2106303_BaseBoxingdatatype(){

u64 entry__ = __onEnter();return __exitReturn_i64_un(0, entry__);
}


/*fd1*/pointer c_2106303_BaseBoxingtypename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("undefined", entry__);
}


/*fd1*/pointer c_2106303_BaseBoxinggetClassName(){
  return  "Core.BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxinggetClassShortName(){
  return  "BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxinggetClassCName(){
  return  "c_2106303_BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxinggetClassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_BaseBoxinggetObjectDatasize(){
  return  sizeof(c_2106303_BaseBoxing);
}












void c_2106303_BaseBoxing_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_BaseBoxing() {
  c_2106303_BaseBoxing * _c_2106303_BaseBoxing = ec_calloc(sizeof(c_2106303_BaseBoxing), sizeof(char));
  return createObject(_c_2106303_BaseBoxing, getc_2106303_BaseBoxing_cm(), false);
}

c_2106303_BaseBoxing_cm _c_2106303_BaseBoxing_cm;
boolean _c_2106303_BaseBoxing_init = false;
pointer getc_2106303_BaseBoxing_cm() {
  if (!_c_2106303_BaseBoxing_init) {
    registerClassModel(&_c_2106303_BaseBoxing_cm);
    populatec_2106303_BaseBoxing_cm(&_c_2106303_BaseBoxing_cm);
    _c_2106303_BaseBoxing_init = true;
  }
  return &_c_2106303_BaseBoxing_cm;
}


/* default constructor */
void populatec_2106303_BaseBoxing_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_BaseBoxing_cm* thisClassModel = (c_2106303_BaseBoxing_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->datatype = c_2106303_BaseBoxingdatatype;
  thisClassModel->typename = c_2106303_BaseBoxingtypename;
  thisClassModel->getClassName = c_2106303_BaseBoxinggetClassName;
  thisClassModel->getClassShortName = c_2106303_BaseBoxinggetClassShortName;
  thisClassModel->getClassCName = c_2106303_BaseBoxinggetClassCName;
  thisClassModel->getClassPackage = c_2106303_BaseBoxinggetClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_BaseBoxinggetObjectDatasize;
  thisClassModel->free = c_2106303_BaseBoxing_free;
}

