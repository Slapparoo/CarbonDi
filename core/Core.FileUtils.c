// Core.FileUtils
#include "Core.Core_main.h"
#include "Core.FileUtils.h"
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
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/u64 c_2106303_FileUtilsfilesize(pointer fp){

u64 entry__ = __onEnter();/*va1*/int prev = /*fc2 null */ftell(fp);
/*st*/ /*fc2 null */fseek(fp, 0, SEEK_END);
/*va1*/int sz = /*fc2 null */ftell(fp);
/*st*/ /*fc2 null */fseek(fp, prev, SEEK_SET);
return __exitReturn_int_un(sz, entry__);
}


/*fd1*/num c_2106303_FileUtilsfileread(num filename){

u64 entry__ = __onEnter();/*va1*/pointer fp = /*fc2 null */fopen(/* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(filename)->classmodel)->asStr(filename), "r");
if (/*oxa*/fp == /*oxb*/null) {
/*st*/ /*fc2 null */throwException("[openfile] error opening file.");
}

/*va1*/u64 size = /*fc4*/ ((c_2106303_FileUtils_cm*)getc_2106303_FileUtils_cm())->filesize(fp);
/*va1*/u64 szp1 = /*oxa*/size + /*oxb*/1;
num buffer = create_c_2106303_Array_1(szp1, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i8_, sizeof(i8));
/*va1*/num result = /*fc2 null */fread(/*te14a*/((c_2106303_Array_cm*)useObject(buffer)->classmodel)->get_values(buffer), 1, size, fp);
/*st*/ /*fc2 null */fclose(fp);
if (/*oxa*/result != /*oxb*/size) {
/*st*/ /*fc2 null */throwException("[readfile] error reading file.");
}

/*rx1*/ return __exitReturn_ref_un(buffer, entry__);
}


/*fd1*/pointer c_2106303_FileUtilsclassName(){
  return  "Core.FileUtils";
}


/*fd1*/pointer c_2106303_FileUtilsclassShortName(){
  return  "FileUtils";
}


/*fd1*/pointer c_2106303_FileUtilsclassCName(){
  return  "c_2106303_FileUtils";
}


/*fd1*/pointer c_2106303_FileUtilsclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_FileUtilsobjectDatasize(){
  return  sizeof(c_2106303_FileUtils);
}











void c_2106303_FileUtils_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_FileUtils() {
  c_2106303_FileUtils * _c_2106303_FileUtils = ec_calloc(sizeof(c_2106303_FileUtils), sizeof(char));
  num this = createObject(_c_2106303_FileUtils, getc_2106303_FileUtils_cm(), false);
/*cdv2 Core.ObjectCore.FileUtils */((c_2106303_FileUtils*)_c_2106303_FileUtils)->instanceName = c_2106303_FileUtilsclassName();
  return this;
}

c_2106303_FileUtils_cm _c_2106303_FileUtils_cm;
boolean _c_2106303_FileUtils_init = false;
pointer getc_2106303_FileUtils_cm() {
  if (!_c_2106303_FileUtils_init) {
    registerClassModel(&_c_2106303_FileUtils_cm);
    populatec_2106303_FileUtils_cm(&_c_2106303_FileUtils_cm);
    _c_2106303_FileUtils_init = true;
  }
  return &_c_2106303_FileUtils_cm;
}


/* default constructor */
void populatec_2106303_FileUtils_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_FileUtils_cm* thisClassModel = (c_2106303_FileUtils_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
 /*cds2*/ thisClassModel->filesize = c_2106303_FileUtilsfilesize;
 /*cds2*/ thisClassModel->fileread = c_2106303_FileUtilsfileread;
 /*cds2*/ thisClassModel->className = c_2106303_FileUtilsclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_FileUtilsclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_FileUtilsclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_FileUtilsclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_FileUtilsobjectDatasize;
  thisClassModel->free = c_2106303_FileUtils_free;
}

