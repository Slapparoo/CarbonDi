// Default.Hashset
#include "Default.Hashset.h"
#include "Core.Core_main.h"
#include "Default.Duo.h"

/*fd1*/ void c_1085510111_HashsetreHash(num this, num object) {
  c_1085510111_Hashset_cm *cm = ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel);
  u64 entry__ = __onEnter(); /*va1*/
  u64 oldSize = cm->get_size(/*te8*/ this);
  num oldlist = cm->get_list(/*te8*/ this);
  ((c_1085510111_Hashset *)useObject(/*te8*/ this)->data)->size += 512;
  num newlist = /*cd1*/ create_c_2106303_RefArray_1(cm->get_size(/*te8*/ this));
  cm->set_items(/*te8*/ this, 0);

  for (num a__a = 0; a__a < /*te8*/ oldSize; a__a++) {

    __onEnter(); /*va1*/
    i64 ix = /*te8*/ a__a;
    /*va1*/ num item =
        /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(oldlist, /*te8*/ ix));
    if (/*oxa*/ /*te8*/ item != /*oxb*/ 0) {

      __onEnter();
      if (/*oxa*/ /*te14a*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->get_instanceName(/*te8*/ item) ==
          /*oxb*/ /*te141*/ ((c_1085510111_Duo_cm *)getc_1085510111_Duo_cm())->className()) {

        __onEnter(); /*va1*/
        num d = /*te8*/ item;
        /*st*/ /*fc3*/ ((c_1085510111_Hashset_cm *)useObject(this)->classmodel)
            ->addNew(this, /*te8*/ newlist,
                     /*te14a*/
                     ((c_1085510111_Duo_cm *)useObject(/*te8*/ d)->classmodel)->get_one(/*te8*/ d));
        /*st*/ /*fc3*/ ((c_1085510111_Hashset_cm *)useObject(this)->classmodel)
            ->addNew(this, /*te8*/ newlist,
                     /*te14a*/
                     ((c_1085510111_Duo_cm *)useObject(/*te8*/ d)->classmodel)->get_two(/*te8*/ d));

        __onExit();
      }

      /* else? */ else {

        __onEnter(); /*st*/ /*fc3*/
        ((c_1085510111_Hashset_cm *)useObject(this)->classmodel)->addNew(this, /*te8*/ newlist, /*te8*/ item);

        __onExit();
      }

      __onExit();
    }

    __onExit();
  }

  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(this)->classmodel)->addNew(this, /*te8*/ newlist, /*te8*/ object);
  /*Ax3*/ /*te14b*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->set_list(/*te8*/ this, /*te8*/ newlist);

  __onExit();
}

/*fd1*/ void c_1085510111_Hashsetstartup(num this) {

  u64 entry__ = __onEnter();
  if (/*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_isInit(/*te8*/ this)) {

    __onEnter();
    return __exitReturn_void_un(entry__);
  }

  if (/*oxa*/ /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_size(/*te8*/ this) < /*oxb*/ 256) {

    __onEnter(); /*Ax5*/ /*te14b*/
    ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->set_size(/*te8*/ this, 256);

    __onExit();
  }

  /*Ax3*/ /*te14b*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_list(
          /*te8*/ this, /*cd1*/ create_c_2106303_RefArray_1(
              /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_size(/*te8*/ this)));
  /*Ax5*/ /*te14b*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->set_isInit(/*te8*/ this, true);

  __onExit();
}

/*fd1*/ boolean c_1085510111_Hashsetcontains(num this, num object) {

  u64 entry__ = __onEnter();
  if (!/*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_isInit(/*te8*/ this)) {

    __onEnter();
    return __exitReturn_boolean_un(false, entry__);
  }

  /*va1*/ i32 index =
      /*oxa*/ /* switch from fc5 to te4*/ ((c_2106303_Object_cm *)useObject(/*te8*/ object)->classmodel)->hashCode(/*te8*/ object) %
      /*oxb*/ /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_size(/*te8*/ this);
  /*va1*/ num tempList =
      /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_list(/*te8*/ this);
  /*va1*/ num item =
      /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(tempList, /*te8*/ index));
  if (/*oxa*/ /*te8*/ item == /*oxb*/ 0) {

    __onEnter();
    return __exitReturn_boolean_un(false, entry__);
  }

  else if (/* switch from fc5 to te4*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->equals(/*te8*/ item, /*te8*/ object)) {

    __onEnter();
    return __exitReturn_boolean_un(true, entry__);
  }

  return __exitReturn_boolean_un(false, entry__);
}

/*fd1*/ void c_1085510111_Hashsetadd(num this, num object) {

  u64 entry__ = __onEnter();
  c_1085510111_Hashset_cm *cm = (c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel;

  if (!/*te14a*/ cm->get_isInit(/*te8*/ this)) {
    cm->startup(this);
  }

  i32 index = cm->hashCode(/*te8*/ object) %
              /*oxb*/ /*te14a*/ cm->get_size(/*te8*/ this);
  num tempList = cm->get_list(/*te8*/ this);
  num item =
      /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(tempList, /*te8*/ index));
  if (/*oxa*/ /*te8*/ item == /*oxb*/ 0) {

    __onEnter(); /*Ax3*/
    ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/ index, /*te8*/ object);
    /*st*/ /*te15a*/ ((c_1085510111_Hashset *)useObject(/*te8*/ this)->data)->items++;
    return __exitReturn_void_un(entry__);
  }

  else if (/* switch from fc5 to te4*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->equals(/*te8*/ item, /*te8*/ object)) {

    __onEnter();
    return __exitReturn_void_un(entry__);
  }

  else if (/*oxa*/ /*te14a*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->get_instanceName(/*te8*/ item) ==
           /*oxb*/ /*te141*/ ((c_1085510111_Duo_cm *)getc_1085510111_Duo_cm())->className()) {

    __onEnter(); /*va1*/
    num duo = /*te8*/ item;
    if (/*oxa*/ /*oxa*/ /*oxa*/ /*te14a*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->get_one(/*te8*/ duo) == /*oxb*/ /*te8*/ object ||
        /*oxb*/ /*te14a*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->get_two(/*te8*/ duo) == /*oxb*/ /*te8*/ object) {

      __onEnter();
      return __exitReturn_void_un(entry__);
    }

    /*st*/ /*fc3*/ cm->reHash(this, /*te8*/ object);

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*va1*/
    num duo = /*cd1*/ create_c_1085510111_Duo();
    /*Ax2*/ /*te14b*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->set_one(/*te8*/ duo, /*te8*/ item);
    /*Ax2*/ /*te14b*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->set_two(/*te8*/ duo, /*te8*/ object);
    /*Ax3*/ ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/ index, /*te8*/ duo);
    /*st*/ /*te15a*/ ((c_1085510111_Hashset *)useObject(/*te8*/ this)->data)->items++;

    __onExit();
  }

  __onExit();
}

/*fd1*/ void c_1085510111_HashsetaddNew(num this, num newlist, num object) {

  u64 entry__ = __onEnter(); /*va1*/
  i32 index =
      /*oxa*/ /* switch from fc5 to te4*/ ((c_2106303_Object_cm *)useObject(/*te8*/ object)->classmodel)->hashCode(/*te8*/ object) %
      /*oxb*/ /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ this)->classmodel)->get_size(/*te8*/ this);
  /*va1*/ num tempList = /*te8*/ newlist;
  /*va1*/ num item =
      /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(tempList, /*te8*/ index));
  if (/*oxa*/ /*te8*/ item == /*oxb*/ 0) {

    __onEnter(); /*Ax3*/
    ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/ index, /*te8*/ object);
    /*st*/ /*te15a*/ ((c_1085510111_Hashset *)useObject(/*te8*/ this)->data)->items++;
    return __exitReturn_void_un(entry__);
  }

  else if (/* switch from fc5 to te4*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->equals(/*te8*/ item, /*te8*/ object)) {

    __onEnter();
    return __exitReturn_void_un(entry__);
  }

  else if (/*oxa*/ /*te14a*/ ((c_2106303_Object_cm *)useObject(/*te8*/ item)->classmodel)->get_instanceName(/*te8*/ item) ==
           /*oxb*/ /*te141*/ ((c_1085510111_Duo_cm *)getc_1085510111_Duo_cm())->className()) {

    __onEnter(); /*va1*/
    num duo = /*te8*/ item;
    if (/*oxa*/ /*oxa*/ /*oxa*/ /*te14a*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->get_one(/*te8*/ duo) == /*oxb*/ /*te8*/ object ||
        /*oxb*/ /*te14a*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->get_two(/*te8*/ duo) == /*oxb*/ /*te8*/ object) {

      __onEnter();
      return __exitReturn_void_un(entry__);
    }

    /*st*/ /*fc2 null */ throwException("Reentrant hashset resize.");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*va1*/
    num duo = /*cd1*/ create_c_1085510111_Duo();
    /*Ax2*/ /*te14b*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->set_one(/*te8*/ duo, /*te8*/ item);
    /*Ax2*/ /*te14b*/ ((c_1085510111_Duo_cm *)useObject(/*te8*/ duo)->classmodel)->set_two(/*te8*/ duo, /*te8*/ object);
    /*Ax3*/ ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/ index, /*te8*/ duo);
    /*st*/ /*te15a*/ ((c_1085510111_Hashset *)useObject(/*te8*/ this)->data)->items++;

    __onExit();
  }

  __onExit();
}

/*fd1*/ pointer c_1085510111_HashsetclassName() { return "Default.Hashset"; }

/*fd1*/ pointer c_1085510111_HashsetclassShortName() { return "Hashset"; }

/*fd1*/ pointer c_1085510111_HashsetclassCName() { return "c_1085510111_Hashset"; }

/*fd1*/ pointer c_1085510111_HashsetclassPackage() { return "Default"; }

/*fd1*/ u64 c_1085510111_HashsetobjectDatasize() { return sizeof(c_1085510111_Hashset); }

/*fd1*/ u64 c_1085510111_Hashsetget_items(num this) { return ((c_1085510111_Hashset *)useObject(this)->data)->items; }

/*fd1*/ void c_1085510111_Hashsetset_items(num this, u64 a__a) { /*cda1*/
  ((c_1085510111_Hashset *)useObject(this)->data)->items = a__a;
}

/*fd1*/ u64 c_1085510111_Hashsetget_size(num this) { return ((c_1085510111_Hashset *)useObject(this)->data)->size; }

/*fd1*/ void c_1085510111_Hashsetset_size(num this, u64 a__a) { /*cda1*/
  ((c_1085510111_Hashset *)useObject(this)->data)->size = a__a;
}

/*fd1*/ num c_1085510111_Hashsetget_list(num this) { return ((c_1085510111_Hashset *)useObject(this)->data)->list; }

/*fd1*/ void c_1085510111_Hashsetset_list(num this, num a__a) { /*cda2*/
  assignObject(&((c_1085510111_Hashset *)useObject(this)->data) /*cda3*/->list, a__a);
}

/*fd1*/ boolean c_1085510111_Hashsetget_isInit(num this) { return ((c_1085510111_Hashset *)useObject(this)->data)->isInit; }

/*fd1*/ void c_1085510111_Hashsetset_isInit(num this, boolean a__a) { /*cda1*/
  ((c_1085510111_Hashset *)useObject(this)->data)->isInit = a__a;
}

void c_1085510111_Hashset_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_Hashset *)object_ref->data)->list);
}

num create_c_1085510111_Hashset() {
  c_1085510111_Hashset *_c_1085510111_Hashset = ec_calloc(sizeof(c_1085510111_Hashset), sizeof(char));
  /*cdv1*/ ((c_1085510111_Hashset *)_c_1085510111_Hashset)->items = 0;
  /*cdv1*/ ((c_1085510111_Hashset *)_c_1085510111_Hashset)->size = 256;
  /*cdv1*/ ((c_1085510111_Hashset *)_c_1085510111_Hashset)->isInit = false;
  /*cdv1*/ ((c_1085510111_Hashset *)_c_1085510111_Hashset)->instanceName = c_1085510111_HashsetclassName();
  return createObject(_c_1085510111_Hashset, getc_1085510111_Hashset_cm(), false);
}

c_1085510111_Hashset_cm _c_1085510111_Hashset_cm;
boolean _c_1085510111_Hashset_init = false;
pointer getc_1085510111_Hashset_cm() {
  if (!_c_1085510111_Hashset_init) {
    registerClassModel(&_c_1085510111_Hashset_cm);
    populatec_1085510111_Hashset_cm(&_c_1085510111_Hashset_cm);
    _c_1085510111_Hashset_init = true;
  }
  return &_c_1085510111_Hashset_cm;
}

/* default constructor */
num create_c_1085510111_Hashset_1(/* param */ /*va1*/ u64 size) {
  num this = create_c_1085510111_Hashset();

  ((c_1085510111_Hashset_cm *)useObject(this)->classmodel)->set_size(this, size);

  return this;
}
void populatec_1085510111_Hashset_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_Hashset_cm *thisClassModel = (c_1085510111_Hashset_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->reHash = c_1085510111_HashsetreHash;
  thisClassModel->startup = c_1085510111_Hashsetstartup;
  thisClassModel->contains = c_1085510111_Hashsetcontains;
  thisClassModel->add = c_1085510111_Hashsetadd;
  thisClassModel->addNew = c_1085510111_HashsetaddNew;
  thisClassModel->className = c_1085510111_HashsetclassName;
  thisClassModel->classShortName = c_1085510111_HashsetclassShortName;
  thisClassModel->classCName = c_1085510111_HashsetclassCName;
  thisClassModel->classPackage = c_1085510111_HashsetclassPackage;
  thisClassModel->objectDatasize = c_1085510111_HashsetobjectDatasize;
  thisClassModel->get_items = c_1085510111_Hashsetget_items;
  thisClassModel->set_items = c_1085510111_Hashsetset_items;
  thisClassModel->get_size = c_1085510111_Hashsetget_size;
  thisClassModel->set_size = c_1085510111_Hashsetset_size;
  thisClassModel->get_list = c_1085510111_Hashsetget_list;
  thisClassModel->set_list = c_1085510111_Hashsetset_list;
  thisClassModel->get_isInit = c_1085510111_Hashsetget_isInit;
  thisClassModel->set_isInit = c_1085510111_Hashsetset_isInit;
  thisClassModel->free = c_1085510111_Hashset_free;
}
