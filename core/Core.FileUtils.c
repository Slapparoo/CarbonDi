// Core.FileUtils
#include "Core.Core_main.h"
#include "Core.FileUtils.h"
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
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"

/*fd1*/u64 c_2106303_FileUtilsfilesize(pointer fp){

u64 entry__ = __onEnter();/*va1*/int prev = /*fc2 null */ftell(/*te8*/fp);
/*st*/ /*fc2 null */fseek(/*te8*/fp, 0, /*te8*/SEEK_END);
/*va1*/int sz = /*fc2 null */ftell(/*te8*/fp);
/*st*/ /*fc2 null */fseek(/*te8*/fp, /*te8*/prev, /*te8*/SEEK_SET);
return __exitReturn_int_un(/*te8*/sz, entry__);
}


/*fd1*/num c_2106303_FileUtilsfileread(num filename){

u64 entry__ = __onEnter();/*va1*/pointer fp = /*fc2 null */fopen(/* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/filename)->classmodel)->asStr(/*te8*/filename), "r");
if (/*oxa*//*te8*/fp == /*oxb*/null) {

__onEnter();/*st*/ /*fc2 null */throwException("[openfile] error opening file.");

__onExit();}

/*va1*/u64 size = /*fc4*/ ((c_2106303_FileUtils_cm*)getc_2106303_FileUtils_cm())->filesize(/*te8*/fp);
/*va1*/u64 szp1 = /*oxa*//*te8*/size + /*oxb*/1;
num buffer = create_c_2106303_Array_1(szp1, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i8_, sizeof(i8));
/*va1*/num result = /*fc2 null */fread(/*te14a*/((c_2106303_Array_cm*)useObject(/*te8*/buffer)->classmodel)->get_values(/*te8*/buffer), 1, /*te8*/size, /*te8*/fp);
/*st*/ /*fc2 null */fclose(/*te8*/fp);
if (/*oxa*//*te8*/result != /*oxb*//*te8*/size) {

__onEnter();/*st*/ /*fc2 null */throwException("[readfile] error reading file.");

__onExit();}

/*rx1*/ return __exitReturn_ref_un(/*te8*/buffer, entry__);
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
  return createObject(_c_2106303_FileUtils, getc_2106303_FileUtils_cm(), false);
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
  thisClassModel->filesize = c_2106303_FileUtilsfilesize;
  thisClassModel->fileread = c_2106303_FileUtilsfileread;
  thisClassModel->className = c_2106303_FileUtilsclassName;
  thisClassModel->classShortName = c_2106303_FileUtilsclassShortName;
  thisClassModel->classCName = c_2106303_FileUtilsclassCName;
  thisClassModel->classPackage = c_2106303_FileUtilsclassPackage;
  thisClassModel->objectDatasize = c_2106303_FileUtilsobjectDatasize;
  thisClassModel->free = c_2106303_FileUtils_free;
}

