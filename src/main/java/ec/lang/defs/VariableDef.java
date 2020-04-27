package ec.lang.defs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.TypeExpr;

public class VariableDef extends StatementDef {
    String debugValue;

    private String name;
    public TypeIdDef type = null;
    public TypeIdDef cast_to;

    public boolean is_annoymous = false;
    public int indexSize = -1;
    public String arraySize;

    // public boolean is_property = false;
    public boolean is_static = false;
    public Accessor readAccessor = Accessor.PUBLIC;
    public Accessor writeAccessor = Accessor.PUBLIC;
    public boolean isParam = false;

    public ClassDef classDef = null;

    public boolean equalsParam = false;

    public ExprDef assignValue; 

    // for class member functions which can be used as a property
    public FunctionDef functionDef = null;

    public static Set<String> VAR_CHARS = new HashSet();

    static {
        // VAR_CHARS.add("@");
        // VAR_CHARS.add("~");
        VAR_CHARS.add("?");
        // VAR_CHARS.add("$");
    }

    // used for constructors
    public List<ExprDef> params = new ArrayList<>();

    public String printType() {
        return "thisType " + (type == null ? "(undefined)" : type.toString()) + printAssignType();
    }

    public String printAssignType() {
        return " assignType " + (assignValue == null ? "(undefined)" : (assignValue + " " + assignValue.printType()));
    }


    public void setValues(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line, String assignable, ExprDef expr) {
        assignValue = expr;
        this.setValues(accessor, name, type, isArray, castTo, size, reference, line);
        // System.out.println("@@Assign line = " + line);
    }

    public void setValues2(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line, String assignable, ExprDef expr, String isStatic) {
        this.is_static = isStatic != null && isStatic.equals("static");
        if (assignable != null) {
            assignValue = expr;
        }
        this.setValues(accessor, name, type, isArray, castTo, size, reference, line);
    }

    public void setValues(String accessor, String name, String type, 
        boolean isArray, String castTo, String size, String reference, String line
        ) {

            // System.out.println("@@Var " + "accessor=" + accessor +", name=" + name +", type=" + type +" ,isArray=" 
            // + isArray +", castTo=" + castTo +", size=" + size +", reference=" + reference +", line=" + line + ", assignValue="+ assignValue);

        this.name = name;
        //**************** reference */
        this.type = new TypeIdDef(type);
        this.debugValue = accessor;

        this.type.setIs_array(isArray);
        if (castTo != null) {
            this.cast_to = new TypeIdDef(castTo);
        }

        if (size != null) {
            if (size.matches("[0-9_]")) {
                indexSize = Integer.parseInt(size.replace("_", ""));
                arraySize = Integer.toString(indexSize);
            } else {
                // const value
                arraySize = size;
            }
            
        }

        this.setLine(line);
        // System.out.println("@@vardef " + name + " " + toString());
    }

    @Override
    public void resolve_01() {
        super.resolve_01();

        if (containedInBlock != null && type == null) {
            VariableDef var = containedInBlock.resolveVariable(name);

            if (var == null) {
                throw new RuntimeException("Variable not declared in contained block " + name + " "  + params);
            }
            if (var != this) {
                // throw new RuntimeException("duplicate variable declared " + name + " " + getLine());
                System.out.println("duplicate variable declared " + name + " " + getLine());
            }
        }

        if (classDef != null) {
            // constructor param - detemine type
            // find the class and match the name to a a property
            if (type == null) {
                throw new RuntimeException("parameter type has not been determined " + name + " " + getLine() + " " + containedInBlock);
            }            

        }

        if (assignValue != null) {
            if (assignValue instanceof MultiTypeExpr) {
                ((MultiTypeExpr)assignValue).setIsGet(true);
            }

            if (assignValue instanceof TypeExpr) {
                ((TypeExpr)assignValue).setIsGet(true);
            }

            assignValue.containedInBlock = containedInBlock;
            assignValue.resolve_01();
        }


        if (type == null) {
            System.out.println("type == null " + name);
        }

        if (VAR_CHARS.contains(type.getName())) {
            // equals something - so the type of the equals
            // System.out.println("@@resolve type " + name);
            if (assignValue == null) {
                throw new RuntimeException("type cannot be resolved for " + name);
            }

            if (assignValue.thisType != null) {
                // System.out.println("@@assignValue " + name + " " + assignValue.thisType);
                type = new TypeIdDef(assignValue.thisType.getName());
                type.setIs_array(assignValue.thisType.isIs_array());
                type.setIs_boxed(assignValue.thisType.isIs_boxed());
                type.setObjectType(assignValue.thisType.getObjectType());

                if (assignValue instanceof MultiTypeExpr && type.isIs_array()) {
                    MultiTypeExpr av = (MultiTypeExpr) assignValue;
                    // this is ambiguous - nad doesn't always work
                    type.setIs_array(av.arrayIndex != null);
                    System.out.println("@@assignValue " + name + " " + type);
                }
            } else {
                System.out.println("@@Not resolved " + name + ", " + assignValue.getClass() + " " + assignValue.toString());
            }
        }

        if (type.isIs_array() && type.getObjectType() == null) {
            if (type.isPrimative()) {
                type.setObjectType("Array");
            } else {
                type.setObjectType("RefArray");
            }
        }

        if (!type.isPrimative()) {
            classDef = DefFactory.resolveClass(type.getName());
        }

        if (classDef == null && !type.isPrimative()) {
            System.out.println("[warn] no class type for variable " + name);

        }

    }

    public void setCastTo(String castTo) {
        cast_to = new TypeIdDef(castTo);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            is_annoymous = true;
            name = "a" + FileDef.getNextValueNumber();
        }
        return name;
    }
       
    public String asHeader() {

        // if (!is_static) {
        //     return "";
        // }
        if (type.isIs_array()) {
            return "num " + getName();
        } else {
            return type.asCode() + " " + getName();
        }
    }

    public String asCode() {
        if (type == null) {
            return "(incomplete) " + getName();
        }

        String aa = (assignValue == null ? ";" : assignValue.asCode());
        String av = (aa.trim().equals(";") ? "" : " = " + aa);

        if (type.isIs_array()) {

            if (arraySize == null) {
                // assign from another array
                return "num " + getName() + av;
            }

            if (type.getObjectType() == null) {
                throw new RuntimeException("Array type unknown " + getName() + " " + type);
            }

            if (type.getObjectType().equals("Array")) {

                if (arraySize.length() == 0)  {
                    type.setObjectType("DynamicArray");
                    return "num " + getName() + " = create_c_2106303_NewDynamicArray$1(" 
                    + "((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->"
                    + type.asCode() + "_, sizeof("+type.asCode() +"))";
                }


                return "num " + getName() + " = create_c_2106303_Array$1(" 
                    + arraySize
                    + ", ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->"
                    + type.asCode() + "_, sizeof("+type.asCode() +"))";

            } else if (type.getObjectType().equals("RefArray")) {
                return "num " + getName() + " = create_c_2106303_RefArray$1(" + arraySize+ ")";
            } 

            return "num " + getName() + " = create_c_2106303_"+type.getObjectType()+"$1(" + arraySize+ ", _"+type.asCode() + ", sizeof("+type.asCode() +"))";
        } else {
            return "/*va1*/"+ type.asCode() + " " + getName() + av;
        }
    }

    @Override
    public String asSignature() {
        return "("+readAccessor+","+writeAccessor+") "  
        + (is_static ? " static " : "")
        + type.asSignature() + " " + getName() + ";";
    }

    public String asParameterSignature() {
        return type.asSignature() + " " + getName();
        
    }


	public boolean isPrimative() {
        if (type == null) {
            throw new RuntimeException("Unknown type " + getName() + ", classdef=" + classDef + ", " );
        }

		return type.isPrimative();
	}

    @Override
    public String toString() {
        return "VariableDef ["+debugValue+" arraySize=" + arraySize + ", assignValue=" + assignValue
                + ", cast_to=" + cast_to + ", indexSize=" + indexSize + ", is_annoymous=" + is_annoymous
                + ", name=" + name + ", params=" + params + ", type=" + type + " line="+getLine()+" ]";
    }
}