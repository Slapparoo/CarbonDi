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

pointer c_2106303_BoxinggetClassName(){
  return  "Core.Boxing";
}


pointer c_2106303_BoxinggetClassShortName(){
  return  "Boxing";
}


pointer c_2106303_BoxinggetClassCName(){
  return  "c_2106303_Boxing";
}


pointer c_2106303_BoxinggetClassPackage(){
  return  "Core";
}


u64 c_2106303_BoxinggetObjectDatasize(){
  return  sizeof(c_2106303_Boxing);
}











int c_2106303_Boxingget_b8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->b8_;
}


void c_2106303_Boxingset_b8_(int b8_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->b8_ = b8_;
}


int c_2106303_Boxingget_i8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i8_;
}


void c_2106303_Boxingset_i8_(int i8_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i8_ = i8_;
}


int c_2106303_Boxingget_u8_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u8_;
}


void c_2106303_Boxingset_u8_(int u8_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u8_ = u8_;
}


int c_2106303_Boxingget_i16_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i16_;
}


void c_2106303_Boxingset_i16_(int i16_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i16_ = i16_;
}


int c_2106303_Boxingget_u16_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u16_;
}


void c_2106303_Boxingset_u16_(int u16_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u16_ = u16_;
}


int c_2106303_Boxingget_i32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i32_;
}


void c_2106303_Boxingset_i32_(int i32_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i32_ = i32_;
}


int c_2106303_Boxingget_u32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u32_;
}


void c_2106303_Boxingset_u32_(int u32_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u32_ = u32_;
}


int c_2106303_Boxingget_f32_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f32_;
}


void c_2106303_Boxingset_f32_(int f32_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f32_ = f32_;
}


int c_2106303_Boxingget_i64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i64_;
}


void c_2106303_Boxingset_i64_(int i64_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i64_ = i64_;
}


int c_2106303_Boxingget_u64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u64_;
}


void c_2106303_Boxingset_u64_(int u64_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->u64_ = u64_;
}


int c_2106303_Boxingget_f64_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f64_;
}


void c_2106303_Boxingset_f64_(int f64_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->f64_ = f64_;
}


int c_2106303_Boxingget_pointer_(){
  return  ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->pointer_;
}


void c_2106303_Boxingset_pointer_(int pointer_){
((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->pointer_ = pointer_;
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
  thisClassModel->getClassName = c_2106303_BoxinggetClassName;
  thisClassModel->getClassShortName = c_2106303_BoxinggetClassShortName;
  thisClassModel->getClassCName = c_2106303_BoxinggetClassCName;
  thisClassModel->getClassPackage = c_2106303_BoxinggetClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_BoxinggetObjectDatasize;
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

