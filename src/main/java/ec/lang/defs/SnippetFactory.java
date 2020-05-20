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


    public static FunctionDef addReturnFunction(String functionName, String returnvalue, TypeIdDef returnType,  boolean isOverride, boolean is_static, boolean is_final) {
        return addFunction(functionName,
            new DirectStatement("  return  "+returnvalue+";"),
            returnType, isOverride, is_static, is_final
            );
    }

    public static FunctionDef addVoidFunction(String functionName, String body,  
        boolean isOverride, boolean is_static, boolean is_final) {
        return addFunction(functionName, 
            new DirectStatement(body+";"),
            new TypeIdDef("void"), isOverride, is_static, is_final
            );
    }

    public static FunctionDef addFunction(String functionName, DirectStatement body, 
        TypeIdDef returnType,  boolean isOverride, boolean is_static, boolean is_final) {
        FunctionDef funct = new FunctionDef();
        funct.name = functionName;
        funct.accessor = Enums.Accessor.PUBLIC;
        funct.returnType = returnType;
        funct.setBlockDef(new BlockDef());
        funct.getBlockDef().includeEntryExit = false;
        funct.getBlockDef().statementDefs.add(body);
        funct.is_static = is_static;
        funct.is_final = is_final;

        if (!is_static) {
            VariableDef param = new VariableDef();
            param.setName("this");
            param.type = new TypeIdDef("num");
            funct.addParameter(param);
        }
        funct.is_override = isOverride;
        // functionDefs.add(funct);
        return funct;
    }


}