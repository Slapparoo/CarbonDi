// Core.Boxing
#include "Core.Core_main.h"
#include "Core.Boxing.h"
#include "Core.Object.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
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

/*fd1*/i32 c_2106303_BoxinggetSizeBytes(i32 type){

u64 entry__ = __onEnter();if (/*oxa*//*oxa*//*oxa*//*oxa*//*oxa*//*te8*/type == /*oxb*/1 || /*oxb*//*te8*/type == /*oxb*/2 || /*oxb*//*te8*/type == /*oxb*/3) {

__onEnter();return __exitReturn_i64_un(1, entry__);
}

 else if (/*oxa*//*oxa*//*oxa*//*te8*/type == /*oxb*/4 || /*oxb*//*te8*/type == /*oxb*/5) {

__onEnter();return __exitReturn_i64_un(2, entry__);
}

 else if (/*oxa*//*oxa*//*oxa*//*oxa*//*oxa*//*te8*/type == /*oxb*/6 || /*oxb*//*te8*/type == /*oxb*/7 || /*oxb*//*te8*/type == /*oxb*/8) {

__onEnter();return __exitReturn_i64_un(4, entry__);
}

 else if (/*oxa*//*oxa*//*oxa*//*oxa*//*oxa*//*te8*/type == /*oxb*/9 || /*oxb*//*te8*/type == /*oxb*/10 || /*oxb*//*te8*/type == /*oxb*/11) {

__onEnter();return __exitReturn_i64_un(8, entry__);
}

return __exitReturn_i64_un(0, entry__);
}


/*fd1*/pointer c_2106303_BoxingclassName(){
  return  "Core.Boxing";
}


/*fd1*/pointer c_2106303_BoxingclassShortName(){
  return  "Boxing";
}


/*fd1*/pointer c_2106303_BoxingclassCName(){
  return  "c_2106303_Boxing";
}


/*fd1*/pointer c_2106303_BoxingclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_BoxingobjectDatasize(){
  return  sizeof(c_2106303_Boxing);
}











/*fd1*/int c_2106303_Boxingget_b8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->b8_;
}


/*fd1*/void c_2106303_Boxingset_b8_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->b8_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_i8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i8_;
}


/*fd1*/void c_2106303_Boxingset_i8_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i8_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_u8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u8_;
}


/*fd1*/void c_2106303_Boxingset_u8_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u8_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_i16_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i16_;
}


/*fd1*/void c_2106303_Boxingset_i16_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i16_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_u16_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u16_;
}


/*fd1*/void c_2106303_Boxingset_u16_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u16_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_i32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i32_;
}


/*fd1*/void c_2106303_Boxingset_i32_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i32_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_u32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u32_;
}


/*fd1*/void c_2106303_Boxingset_u32_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u32_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_f32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f32_;
}


/*fd1*/void c_2106303_Boxingset_f32_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f32_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_i64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i64_;
}


/*fd1*/void c_2106303_Boxingset_i64_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i64_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_u64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u64_;
}


/*fd1*/void c_2106303_Boxingset_u64_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u64_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_f64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f64_;
}


/*fd1*/void c_2106303_Boxingset_f64_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f64_ = a__a;
}


/*fd1*/int c_2106303_Boxingget_pointer_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->pointer_;
}


/*fd1*/void c_2106303_Boxingset_pointer_(int a__a){
/*cda1*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->pointer_ = a__a;
}


void c_2106303_Boxing_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Boxing() {
  c_2106303_Boxing * _c_2106303_Boxing = ec_calloc(sizeof(c_2106303_Boxing), sizeof(char));
  return createObject(_c_2106303_Boxing, getc_2106303_Boxing_cm(), false);
}

c_2106303_Boxing_cm _c_2106303_Boxing_cm;
boolean _c_2106303_Boxing_init = false;
pointer getc_2106303_Boxing_cm() {
  if (!_c_2106303_Boxing_init) {
    registerClassModel(&_c_2106303_Boxing_cm);
    populatec_2106303_Boxing_cm(&_c_2106303_Boxing_cm);
    _c_2106303_Boxing_init = true;
  }
  return &_c_2106303_Boxing_cm;
}


/* default constructor */
void populatec_2106303_Boxing_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Boxing_cm* thisClassModel = (c_2106303_Boxing_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->getSizeBytes = c_2106303_BoxinggetSizeBytes;
  thisClassModel->className = c_2106303_BoxingclassName;
  thisClassModel->classShortName = c_2106303_BoxingclassShortName;
  thisClassModel->classCName = c_2106303_BoxingclassCName;
  thisClassModel->classPackage = c_2106303_BoxingclassPackage;
  thisClassModel->objectDatasize = c_2106303_BoxingobjectDatasize;
  thisClassModel->get_b8_ = c_2106303_Boxingget_b8_;
  thisClassModel->set_b8_ = c_2106303_Boxingset_b8_;
  thisClassModel->get_i8_ = c_2106303_Boxingget_i8_;
  thisClassModel->set_i8_ = c_2106303_Boxingset_i8_;
  thisClassModel->get_u8_ = c_2106303_Boxingget_u8_;
  thisClassModel->set_u8_ = c_2106303_Boxingset_u8_;
  thisClassModel->get_i16_ = c_2106303_Boxingget_i16_;
  thisClassModel->set_i16_ = c_2106303_Boxingset_i16_;
  thisClassModel->get_u16_ = c_2106303_Boxingget_u16_;
  thisClassModel->set_u16_ = c_2106303_Boxingset_u16_;
  thisClassModel->get_i32_ = c_2106303_Boxingget_i32_;
  thisClassModel->set_i32_ = c_2106303_Boxingset_i32_;
  thisClassModel->get_u32_ = c_2106303_Boxingget_u32_;
  thisClassModel->set_u32_ = c_2106303_Boxingset_u32_;
  thisClassModel->get_f32_ = c_2106303_Boxingget_f32_;
  thisClassModel->set_f32_ = c_2106303_Boxingset_f32_;
  thisClassModel->get_i64_ = c_2106303_Boxingget_i64_;
  thisClassModel->set_i64_ = c_2106303_Boxingset_i64_;
  thisClassModel->get_u64_ = c_2106303_Boxingget_u64_;
  thisClassModel->set_u64_ = c_2106303_Boxingset_u64_;
  thisClassModel->get_f64_ = c_2106303_Boxingget_f64_;
  thisClassModel->set_f64_ = c_2106303_Boxingset_f64_;
  thisClassModel->get_pointer_ = c_2106303_Boxingget_pointer_;
  thisClassModel->set_pointer_ = c_2106303_Boxingset_pointer_;
/*cds1*/thisClassModel->b8_ = 1;
/*cds1*/thisClassModel->i8_ = 2;
/*cds1*/thisClassModel->u8_ = 3;
/*cds1*/thisClassModel->i16_ = 4;
/*cds1*/thisClassModel->u16_ = 5;
/*cds1*/thisClassModel->i32_ = 6;
/*cds1*/thisClassModel->u32_ = 7;
/*cds1*/thisClassModel->f32_ = 8;
/*cds1*/thisClassModel->i64_ = 9;
/*cds1*/thisClassModel->u64_ = 10;
/*cds1*/thisClassModel->f64_ = 11;
/*cds1*/thisClassModel->pointer_ = 12;
  thisClassModel->free = c_2106303_Boxing_free;
}

