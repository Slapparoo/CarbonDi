// Core.Hashset
#include "Core.Core_main.h"
#include "Core.Hashset.h"
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
#include "Core.Pointer.h"
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.Duo.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/pointer c_2106303_HashsetclassName(){
  return  "Core.Hashset";
}


/*fd1*/pointer c_2106303_HashsetclassShortName(){
  return  "Hashset";
}


/*fd1*/pointer c_2106303_HashsetclassCName(){
  return  "c_2106303_Hashset";
}


/*fd1*/pointer c_2106303_HashsetclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_HashsetobjectDatasize(){
  return  sizeof(c_2106303_Hashset);
}











void c_2106303_Hashset_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Hashset() {
  c_2106303_Hashset * _c_2106303_Hashset = ec_calloc(sizeof(c_2106303_Hashset), sizeof(char));
/*cdv1*/((c_2106303_Hashset*)_c_2106303_Hashset)->instanceName = c_2106303_HashsetclassName();
  return createObject(_c_2106303_Hashset, getc_2106303_Hashset_cm(), false);
}

c_2106303_Hashset_cm _c_2106303_Hashset_cm;
boolean _c_2106303_Hashset_init = false;
pointer getc_2106303_Hashset_cm() {
  if (!_c_2106303_Hashset_init) {
    registerClassModel(&_c_2106303_Hashset_cm);
    populatec_2106303_Hashset_cm(&_c_2106303_Hashset_cm);
    _c_2106303_Hashset_init = true;
  }
  return &_c_2106303_Hashset_cm;
}


/* default constructor */
void populatec_2106303_Hashset_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Hashset_cm* thisClassModel = (c_2106303_Hashset_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->className = c_2106303_HashsetclassName;
  thisClassModel->classShortName = c_2106303_HashsetclassShortName;
  thisClassModel->classCName = c_2106303_HashsetclassCName;
  thisClassModel->classPackage = c_2106303_HashsetclassPackage;
  thisClassModel->objectDatasize = c_2106303_HashsetobjectDatasize;
  thisClassModel->free = c_2106303_Hashset_free;
}

