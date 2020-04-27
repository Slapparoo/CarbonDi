package ec.lang.defs;

public class SnippetFactory {

    public static String classModelStatement(String className, String varname, boolean isStatic) {
        if (TypeIdDef.isPrimative(className)) {
            throw new RuntimeException("Not a class type " + className + ", " + varname);
        }

        ClassDef cd = DefFactory.resolveClass(className);

        if (cd == null) {
            throw new RuntimeException("Class cannot be resolved " + className );
        }

        if (isStatic) {
            return "((" + cd.getCName() + "_cm*)get" + cd.getCName() + "_cm())";
        }

        return "((" + cd.getCName() + "_cm*)useObject(" + varname + ")->classmodel)";
    }


// #define __USE_THIS_CM ((c_2106303_DynamicArray_cm *)useObject(this)->classmodel)
// #define __USE_THIS_D ((c_2106303_DynamicArray *)useObject(this)->data)
// #define __USE_THIS_S ((c_2106303_DynamicArray_cm *)getc_2106303_DynamicArray_cm())

    public static String dataModelStatement(String className, String varname, boolean isStatic) {
        if (TypeIdDef.isPrimative(className)) {
            throw new RuntimeException("Not a class type " + className + ", " + varname);
        }

        ClassDef cd = DefFactory.resolveClass(className);

        if (cd == null) {
            throw new RuntimeException("Class cannot be resolved " + className );
        }

        // ((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->growBy;
        if (isStatic) {
            return "((" + cd.getCName() + "_cm*)get" + cd.getCName() + "_cm())";
        }

        //((c_2106303_DynamicArray *)useObject(this)->data)
        return "((" + cd.getCName() + "*)useObject(" + varname + ")->data)";
    }

}