// Core.HashCode
#include "Core.Core_main.h"
#include "Core.HashCode.h"
#include "Core.Object.h"
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
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/i32 c_2106303_HashCodecalcFastHash(pointer p, u64 length){

u64 entry__ = __onEnter();/*va1*/i32 res = 0;

for (num a__a = 0; a__a < /*te8*/length; a__a++){
if (/*oxa*//*te8*/length - /*oxb*//*oxa*//*te8*/a__a > /*oxb*/4) {
/*Ax7*//*te8*/res/*te8*/+=/*fc2 null */EC_GETVALUE_i32(/*te8*/p, /*te8*/a__a);
/*Ax7*//*te8*/a__a/*te8*/+=3;
}

 else if (/*oxa*//*te8*/length - /*oxb*//*oxa*//*te8*/a__a > /*oxb*/2) {
/*Ax7*//*te8*/res/*te8*/+=/*fc2 null */EC_GETVALUE_i16(/*te8*/p, /*te8*/a__a);
/*Ax7*//*te8*/a__a/*te8*/+=1;
}

/* else? */ else {
/*Ax7*//*te8*/res/*te8*/+=/*oxa*//*fc2 null */EC_GETVALUE_i8(/*te8*/p, /*te8*/a__a) - /*oxb*/31;
}

}

return __exitReturn_i32_un(/*te8*/res, entry__);
}


/*fd1*/pointer c_2106303_HashCodeclassName(){
  return  "Core.HashCode";
}


/*fd1*/pointer c_2106303_HashCodeclassShortName(){
  return  "HashCode";
}


/*fd1*/pointer c_2106303_HashCodeclassCName(){
  return  "c_2106303_HashCode";
}


/*fd1*/pointer c_2106303_HashCodeclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_HashCodeobjectDatasize(){
  return  sizeof(c_2106303_HashCode);
}











void c_2106303_HashCode_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_HashCode() {
  c_2106303_HashCode * _c_2106303_HashCode = ec_calloc(sizeof(c_2106303_HashCode), sizeof(char));
  num this = createObject(_c_2106303_HashCode, getc_2106303_HashCode_cm(), false);
/*cdv2 Core.ObjectCore.HashCode */((c_2106303_HashCode*)_c_2106303_HashCode)->instanceName = c_2106303_HashCodeclassName();
  return this;
}

c_2106303_HashCode_cm _c_2106303_HashCode_cm;
boolean _c_2106303_HashCode_init = false;
pointer getc_2106303_HashCode_cm() {
  if (!_c_2106303_HashCode_init) {
    registerClassModel(&_c_2106303_HashCode_cm);
    populatec_2106303_HashCode_cm(&_c_2106303_HashCode_cm);
    _c_2106303_HashCode_init = true;
  }
  return &_c_2106303_HashCode_cm;
}


/* default constructor */
void populatec_2106303_HashCode_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_HashCode_cm* thisClassModel = (c_2106303_HashCode_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
 /*cds2*/ thisClassModel->calcFastHash = c_2106303_HashCodecalcFastHash;
 /*cds2*/ thisClassModel->className = c_2106303_HashCodeclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_HashCodeclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_HashCodeclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_HashCodeclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_HashCodeobjectDatasize;
  thisClassModel->free = c_2106303_HashCode_free;
}

