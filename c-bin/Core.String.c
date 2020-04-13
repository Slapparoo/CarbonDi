// String
#include "types.h"
#include "Core.String.h"
#include "Core.Object.h"
#include "Core.String.h"

pointer a73668288_asStr(num this){

__onEnter();/*class ec.lang.defs.expressions.ReturnExpr*/ return __exitReturn_pointer(((StringClassModel*)useObject(this)->classmodel)->get_value(this));
}


num a73668288_asString(num this){

__onEnter();/*class ec.lang.defs.expressions.ReturnExpr*/ return __exitReturn_ref(this);
}


pointer a73668288_getClassName(){
/*class ec.lang.defs.DirectStatement*/   return  "String";
}


pointer a73668288_getClassPackage(){
/*class ec.lang.defs.DirectStatement*/   return  "Core";
}


u64 a73668288_getObjectDatasize(){
/*class ec.lang.defs.DirectStatement*/   return  sizeof(String);
}









pointer a73668288_get_value(num _refId){
/*class ec.lang.defs.DirectStatement*/   return ((String*)useObject(_refId)->data)->value;
}


void a73668288_set_value(num _refId, pointer value){
/*class ec.lang.defs.DirectStatement*/ 
  ((String*)useObject(_refId)->data)->value = value;
}


void a73668288__free(num _refId) { Object_ref *object_ref = useObject(_refId);
}



num create_String() {
  String * _String = ec_calloc(sizeof(String), sizeof(char));
  return createObject(_String, getStringClassModel(), false);
}

pointer _StringClassModel = NULL;
pointer getStringClassModel() {
  if (_StringClassModel == NULL) {
    _StringClassModel = ec_malloc(sizeof(StringClassModel));
    registerClassModel(_StringClassModel);
    populateStringClassModel(_StringClassModel);
  }
  return _StringClassModel;
}


num create_String$1(/* param */pointer value) {
num this =  create_String();

((StringClassModel *)useObject(this)->classmodel)->set_value(this, value);
{

__onEnter();/*class ec.lang.defs.VariableDef*/ num len = /* functioncall 2 */strlen(value) + 1;
/*class ec.lang.defs.expressions.AssignExpr*/ /* AssignExpr */((StringClassModel*)useObject(this)->classmodel)->set_value(this, /* functioncall 3 */((StringClassModel*)useObject(this)->classmodel)->alloc(this, len));
/*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 */strcpy(((StringClassModel*)useObject(this)->classmodel)->get_value(this), value);

__onExit();}

return this;
}
num create_String$2(/* param */pointer value, pointer str2) {
num this =  create_String();

((StringClassModel *)useObject(this)->classmodel)->set_value(this, value);
{

__onEnter();/*class ec.lang.defs.VariableDef*/ num len = /* functioncall 2 */strlen(value) + /* functioncall 2 */strlen(str2) + 1;
/*class ec.lang.defs.expressions.AssignExpr*/ /* AssignExpr */((StringClassModel*)useObject(this)->classmodel)->set_value(this, /* functioncall 3 */((StringClassModel*)useObject(this)->classmodel)->alloc(this, len));
/*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 */strcpy(((StringClassModel*)useObject(this)->classmodel)->get_value(this), value);
/*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 */strcat(((StringClassModel*)useObject(this)->classmodel)->get_value(this), str2);

__onExit();}

return this;
}
void populateStringClassModel(pointer classModel) {
  populateObjectClassModel(classModel);
 populateObjectClassModel(classModel);
  StringClassModel* thisClassModel = (StringClassModel*)classModel;
  thisClassModel->parent = getObjectClassModel();
  thisClassModel->asStr = &a73668288_asStr;
  thisClassModel->asString = &a73668288_asString;
  thisClassModel->getClassName = &a73668288_getClassName;
  thisClassModel->getClassPackage = &a73668288_getClassPackage;
  thisClassModel->getObjectDatasize = &a73668288_getObjectDatasize;
  thisClassModel->get_value = &a73668288_get_value;
  thisClassModel->set_value = &a73668288_set_value;
  thisClassModel->free = &a73668288__free;
}

