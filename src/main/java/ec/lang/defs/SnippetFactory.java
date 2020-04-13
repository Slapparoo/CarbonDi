package ec.lang.defs;

public class SnippetFactory {

    public static String classModelStatement(String className, String varname, boolean isStatic) {
        if (TypeIdDef.isPrimative(className)) {
            throw new RuntimeException("Not a class type " + className + ", " + varname);
        }
        if (isStatic) {
            return "((" + className + "ClassModel*)get" + className + "ClassModel())";
        }

        return "((" + className + "ClassModel*)useObject(" + varname + ")->classmodel)";
    }

}