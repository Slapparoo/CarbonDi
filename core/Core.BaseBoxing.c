// Core.BaseBoxing
#include "Core.Core_main.h"
#include "Core.BaseBoxing.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.Exception.h"
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
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/int c_2106303_BaseBoxingdatatype(){

u64 entry__ = __onEnter();return __exitReturn_i64_un(0, entry__);
}


/*fd1*/pointer c_2106303_BaseBoxingtypename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("undefined", entry__);
}


/*fd1*/pointer c_2106303_BaseBoxingclassName(){
  return  "Core.BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxingclassShortName(){
  return  "BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxingclassCName(){
  return  "c_2106303_BaseBoxing";
}


/*fd1*/pointer c_2106303_BaseBoxingclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_BaseBoxingobjectDatasize(){
  return  sizeof(c_2106303_BaseBoxing);
}











void c_2106303_BaseBoxing_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_BaseBoxing() {
  c_2106303_BaseBoxing * _c_2106303_BaseBoxing = ec_calloc(sizeof(c_2106303_BaseBoxing), sizeof(char));
  num this = createObject(_c_2106303_BaseBoxing, getc_2106303_BaseBoxing_cm(), false);
/*cdv2 Core.ObjectCore.BaseBoxing */((c_2106303_BaseBoxing*)_c_2106303_BaseBoxing)->instanceName = c_2106303_BaseBoxingclassName();
  return this;
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
 /*cds2*/ thisClassModel->datatype = c_2106303_BaseBoxingdatatype;
 /*cds2*/ thisClassModel->typename = c_2106303_BaseBoxingtypename;
 /*cds2*/ thisClassModel->className = c_2106303_BaseBoxingclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_BaseBoxingclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_BaseBoxingclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_BaseBoxingclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_BaseBoxingobjectDatasize;
  thisClassModel->free = c_2106303_BaseBoxing_free;
}

