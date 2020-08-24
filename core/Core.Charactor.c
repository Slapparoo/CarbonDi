// Core.Charactor
#include "Core.Core_main.h"
#include "Core.Charactor.h"
#include "Core.Object.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
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
#include "Core.DynamicArray.h"

/*fd1*/boolean c_2106303_CharactorisLetter(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :
case 71 :
case 72 :
case 73 :
case 74 :
case 75 :
case 76 :
case 77 :
case 78 :
case 79 :
case 80 :
case 81 :
case 82 :
case 83 :
case 84 :
case 85 :
case 86 :
case 87 :
case 88 :
case 89 :
case 90 :

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :
case 103 :
case 104 :
case 105 :
case 106 :
case 107 :
case 108 :
case 109 :
case 110 :
case 111 :
case 112 :
case 113 :
case 114 :
case 115 :
case 116 :
case 117 :
case 118 :
case 119 :
case 120 :
case 121 :
case 122 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisAlpha(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 32 :

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :
case 71 :
case 72 :
case 73 :
case 74 :
case 75 :
case 76 :
case 77 :
case 78 :
case 79 :
case 80 :
case 81 :
case 82 :
case 83 :
case 84 :
case 85 :
case 86 :
case 87 :
case 88 :
case 89 :
case 90 :

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :
case 103 :
case 104 :
case 105 :
case 106 :
case 107 :
case 108 :
case 109 :
case 110 :
case 111 :
case 112 :
case 113 :
case 114 :
case 115 :
case 116 :
case 117 :
case 118 :
case 119 :
case 120 :
case 121 :
case 122 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisUpper(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :
case 71 :
case 72 :
case 73 :
case 74 :
case 75 :
case 76 :
case 77 :
case 78 :
case 79 :
case 80 :
case 81 :
case 82 :
case 83 :
case 84 :
case 85 :
case 86 :
case 87 :
case 88 :
case 89 :
case 90 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisLower(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :
case 103 :
case 104 :
case 105 :
case 106 :
case 107 :
case 108 :
case 109 :
case 110 :
case 111 :
case 112 :
case 113 :
case 114 :
case 115 :
case 116 :
case 117 :
case 118 :
case 119 :
case 120 :
case 121 :
case 122 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisAlphaNumeric(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 32 :

case 48 :
case 49 :
case 50 :
case 51 :
case 52 :
case 53 :
case 54 :
case 55 :
case 56 :
case 57 :

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :
case 71 :
case 72 :
case 73 :
case 74 :
case 75 :
case 76 :
case 77 :
case 78 :
case 79 :
case 80 :
case 81 :
case 82 :
case 83 :
case 84 :
case 85 :
case 86 :
case 87 :
case 88 :
case 89 :
case 90 :

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :
case 103 :
case 104 :
case 105 :
case 106 :
case 107 :
case 108 :
case 109 :
case 110 :
case 111 :
case 112 :
case 113 :
case 114 :
case 115 :
case 116 :
case 117 :
case 118 :
case 119 :
case 120 :
case 121 :
case 122 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisLetterorNumber(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 48 :
case 49 :
case 50 :
case 51 :
case 52 :
case 53 :
case 54 :
case 55 :
case 56 :
case 57 :

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :
case 71 :
case 72 :
case 73 :
case 74 :
case 75 :
case 76 :
case 77 :
case 78 :
case 79 :
case 80 :
case 81 :
case 82 :
case 83 :
case 84 :
case 85 :
case 86 :
case 87 :
case 88 :
case 89 :
case 90 :

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :
case 103 :
case 104 :
case 105 :
case 106 :
case 107 :
case 108 :
case 109 :
case 110 :
case 111 :
case 112 :
case 113 :
case 114 :
case 115 :
case 116 :
case 117 :
case 118 :
case 119 :
case 120 :
case 121 :
case 122 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisNumber(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 48 :
case 49 :
case 50 :
case 51 :
case 52 :
case 53 :
case 54 :
case 55 :
case 56 :
case 57 :

case 95 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisFloat(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 48 :
case 49 :
case 50 :
case 51 :
case 52 :
case 53 :
case 54 :
case 55 :
case 56 :
case 57 :

case 95 :

case 46 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisHex(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 48 :
case 49 :
case 50 :
case 51 :
case 52 :
case 53 :
case 54 :
case 55 :
case 56 :
case 57 :

case 97 :
case 98 :
case 99 :
case 100 :
case 101 :
case 102 :

case 65 :
case 66 :
case 67 :
case 68 :
case 69 :
case 70 :

case 95 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_CharactorisBinary(i8 chr){

u64 entry__ = __onEnter();/*va1*/boolean res = false;

switch (/*te8*/chr) {

case 48 :
case 49 :

case 95 :/*Ax6*//*te8*/res/*te8*/=true;

}
return __exitReturn_i64_un(/*te8*/res, entry__);
}


/*fd1*/pointer c_2106303_CharactorclassName(){
  return  "Core.Charactor";
}


/*fd1*/pointer c_2106303_CharactorclassShortName(){
  return  "Charactor";
}


/*fd1*/pointer c_2106303_CharactorclassCName(){
  return  "c_2106303_Charactor";
}


/*fd1*/pointer c_2106303_CharactorclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_CharactorobjectDatasize(){
  return  sizeof(c_2106303_Charactor);
}











void c_2106303_Charactor_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Charactor() {
  c_2106303_Charactor * _c_2106303_Charactor = ec_calloc(sizeof(c_2106303_Charactor), sizeof(char));
  return createObject(_c_2106303_Charactor, getc_2106303_Charactor_cm(), false);
}

c_2106303_Charactor_cm _c_2106303_Charactor_cm;
boolean _c_2106303_Charactor_init = false;
pointer getc_2106303_Charactor_cm() {
  if (!_c_2106303_Charactor_init) {
    registerClassModel(&_c_2106303_Charactor_cm);
    populatec_2106303_Charactor_cm(&_c_2106303_Charactor_cm);
    _c_2106303_Charactor_init = true;
  }
  return &_c_2106303_Charactor_cm;
}


/* default constructor */
void populatec_2106303_Charactor_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Charactor_cm* thisClassModel = (c_2106303_Charactor_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->isLetter = c_2106303_CharactorisLetter;
  thisClassModel->isAlpha = c_2106303_CharactorisAlpha;
  thisClassModel->isUpper = c_2106303_CharactorisUpper;
  thisClassModel->isLower = c_2106303_CharactorisLower;
  thisClassModel->isAlphaNumeric = c_2106303_CharactorisAlphaNumeric;
  thisClassModel->isLetterorNumber = c_2106303_CharactorisLetterorNumber;
  thisClassModel->isNumber = c_2106303_CharactorisNumber;
  thisClassModel->isFloat = c_2106303_CharactorisFloat;
  thisClassModel->isHex = c_2106303_CharactorisHex;
  thisClassModel->isBinary = c_2106303_CharactorisBinary;
  thisClassModel->className = c_2106303_CharactorclassName;
  thisClassModel->classShortName = c_2106303_CharactorclassShortName;
  thisClassModel->classCName = c_2106303_CharactorclassCName;
  thisClassModel->classPackage = c_2106303_CharactorclassPackage;
  thisClassModel->objectDatasize = c_2106303_CharactorobjectDatasize;
  thisClassModel->free = c_2106303_Charactor_free;
}

