package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.expressions.TypeExpr;

public class VariableDef extends StatementDef {
    public Enums.Accessor accessor; 
    // public String accessor; 
    String debugValue;
    private String name;
    public TypeIdDef type;
    public ExprDef value;
    public TypeIdDef cast_to;
    public boolean is_reference;
    public boolean is_annoymous = false;
    public int indexSize = -1;
    public String arraySize;

    public ExprDef assignValue; 
    // used for constructors
    public List<ExprDef> params = new ArrayList<>();

    public String printType() {
        return "thisType " + (type == null ? "(undefined)" : type.toString()) + printAssignType();
    }

    public String printAssignType() {
        return " assignType " + (assignValue == null ? "(undefined)" : (assignValue + " " + assignValue.printType()));
    }

    public void setValues(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line) {
        this.name = name;
        //**************** reference */
        this.type = new TypeIdDef(type);
        this.debugValue = accessor;

        this.type.is_array = isArray;
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

        this.line = line;
        System.out.println("@@vardef " + name + " " + toString());
    }

    @Override
    public void resolve_01() {
        super.resolve_01();

        if (assignValue != null) {
            if (assignValue instanceof TypeExpr) {
                ((TypeExpr)assignValue).isGet = true;
            }

            assignValue.containedInBlock = containedInBlock;
            assignValue.resolve_01();
        }

        if (type.name.equals("@")) {
            // equals something - so the type of the equals
            // System.out.println("@@resolve type " + name);
            if (assignValue == null) {
                throw new RuntimeException("type cannot be resolved for " + name);
            }

            if (assignValue.thisType != null) {
                type = new TypeIdDef(assignValue.thisType.name);
                type.is_array = assignValue.thisType.is_array;

                if (assignValue instanceof TypeExpr && type.is_array) {
                    TypeExpr av = (TypeExpr) assignValue;
                    type.is_array = av.arrayIndex == null;
                }

                // System.out.println("@@VaribaleDef.resolved " + name + ", "  + type);
            } else {
                System.out.println("@@Not resolved " + name + ", " + assignValue.getClass() + " " + assignValue.toString());
            }
        }
        System.out.println("\033[1;33m@@VaribaleDef.resolve " + name + ", type="+ printType() + "\033[0m" );
    }

    public void setCastTo(String castTo) {
        cast_to = new TypeIdDef(castTo);
    }

    public void setValues(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line, String assignable, ExprDef expr) {
        this.setValues(accessor, name, type, isArray, castTo, size, reference, line);
        assignValue = expr;
        // System.out.println("@@Assign = " + expr);
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
        return "";
    }

    public String asCode() {
        if (type == null) {
            return "(incomplete) " + getName();
        }
        String aa = (assignValue == null ? ";" : assignValue.asCode());
        String av = (aa.trim().equals(";") ? "" : " = " + aa);

        // System.out.println("@@VariableDef.asCode " + aa + ", " + av);

        if (type.is_array) {
            System.out.println("@@VariableDef.asCode Array " + aa + ", " + av);

            if (arraySize == null) {
                // assign from another array
                return "num " + getName() + av;
            }
            // return type.asCode() + " " + getName() + "[ " + arraySize+ "]" + av;
            if (type.isPrimative()) {
                return "num " + getName() + " = Array_create(" + arraySize+ ", _"+type.asCode() + ", sizeof("+type.asCode() +"))";
            } else {
                return "num " + getName() + " = RefArray_create(" + arraySize+ ")";
            }
        } else {
            return type.asCode() + " " + getName() + av;
        }
    }

	public boolean isPrimative() {
		return type.isPrimative();
	}

    @Override
    public String toString() {
        return "VariableDef ["+debugValue+" accessor=" + accessor + ", arraySize=" + arraySize + ", assignValue=" + assignValue
                + ", cast_to=" + cast_to + ", indexSize=" + indexSize + ", is_annoymous=" + is_annoymous
                + ", is_reference=" + is_reference + ", name=" + name + ", params=" + params + ", type=" + type
                + ", value=" + value + "]";
    }
}