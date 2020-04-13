#include "Default.static_main.h"

void static_615452379_main() {

  __onEnter(); /*class ec.lang.defs.VariableDef*/
  num simpleObject = create_SimpleObject$1(11);
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ printf(
      "count1(11)=%li, count2(51)=%li, count3(27)=%li, constNumber(66)=%li\n",
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count1(simpleObject),
      /*te6*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->get_count2(),
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count3(simpleObject),
      /* functioncall 4 */ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->constNumber());
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count1 1", 11,
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count1(simpleObject));
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count2 1", 51, /*te6*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->get_count2());
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count3 1", 27,
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count3(simpleObject));
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.constNumber() 1", 66,
      /* functioncall 2 null */
      ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->constNumber(simpleObject));
  /*class ec.lang.defs.expressions.AssignExpr*/ /* AssignExpr array */ /*te6b*/ (
      (SimpleObjectClassModel *)useObject(simpleObject)->classmodel)
      ->set_count1(simpleObject, 99);
  /*class ec.lang.defs.expressions.AssignExpr*/ /* AssignExpr array */ /*te13*/ (
      (SimpleObjectClassModel *)getSimpleObjectClassModel())
      ->set_count2(33);
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ printf(
      "count1(99)=%li, count2(33)=%li, count3(33)=%li, constNumber(66)=%li\n",
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count1(simpleObject),
      /*te6*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->get_count2(),
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count3(simpleObject),
      /* functioncall 4 */ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->constNumber());
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count1 2", 99,
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count1(simpleObject));
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count2 2", 33, /*te6*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->get_count2());
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.count3 2", 27,
      /*te6a*/ ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->get_count3(simpleObject));
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "simpleObject.constNumber() 2", 66,
      /* functioncall 2 null */
      ((SimpleObjectClassModel *)useObject(simpleObject)->classmodel)->constNumber(simpleObject));
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "SimpleObject.count2 3", 33, /*te12*/ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->get_count2());
  /*class ec.lang.defs.StatementDef*/ /**(Statement)*/ /* functioncall 2 null */ testi64Equal(
      "SimpleObject.constNumber() 3", 66,
      /* functioncall 4 */ ((SimpleObjectClassModel *)getSimpleObjectClassModel())->constNumber());

  __onExit();
}
