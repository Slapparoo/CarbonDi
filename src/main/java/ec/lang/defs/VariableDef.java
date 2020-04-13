package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.TypeExpr;

public class VariableDef extends StatementDef {
    public Enums.Accessor accessor; 
    // public String accessor; 
    String debugValue;
    private String name;
    public TypeIdDef type = null;
    public ExprDef value;
    public TypeIdDef cast_to;
    public boolean is_reference;
    public boolean is_annoymous = false;
    public int indexSize = -1;
    public String arraySize;
    public boolean is_property = false;
    public boolean is_static = false;
    public Accessor readAccessor = Accessor.PUBLIC;
    public Accessor writeAccessor = Accessor.PUBLIC;


    public ExprDef assignValue; 
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
        assignValue = expr;
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


        if (is_property) {
            // constructor param - detemine type
            // find the class and match the name to a a property
            if (type == null) {
                throw new RuntimeException("parameter type has not been determined " + name);
            }            

        }

        if (assignValue != null) {
            if (assignValue instanceof TypeExpr) {
                ((TypeExpr)assignValue).isGet = true;
            }

            assignValue.containedInBlock = containedInBlock;
            assignValue.resolve_01();
        }


        if (type == null) {
            System.out.println("type == null " + name);
        }

        if (type.getName().equals("@")) {
            // equals something - so the type of the equals
            // System.out.println("@@resolve type " + name);
            if (assignValue == null) {
                throw new RuntimeException("type cannot be resolved for " + name);
            }

            if (assignValue.thisType != null) {
                type = new TypeIdDef(assignValue.thisType.getName());
                type.setIs_array(assignValue.thisType.isIs_array());
                type.setIs_boxed(assignValue.thisType.isIs_boxed());

                if (assignValue instanceof TypeExpr && type.isIs_array()) {
                    TypeExpr av = (TypeExpr) assignValue;
                    type.setIs_array(av.arrayIndex == null);
                }

                // System.out.println("@@VaribaleDef.resolved " + name + ", "  + type);
            } else {
                System.out.println("@@Not resolved " + name + ", " + assignValue.getClass() + " " + assignValue.toString());
            }
        }
        // System.out.println("\033[1;33m@@VaribaleDef.resolve " + name + ", type="+ printType() + "\033[0m" );
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
            // return type.asCode() + " " + getName() + "[ " + arraySize+ "]" + av;
            if (type.isPrimative()) {
                return "num " + getName() + " = create_Array$1(" + arraySize+ ", _"+type.asCode() + ", sizeof("+type.asCode() +"))";
            } else {
                return "num " + getName() + " = create_RefArray$1(" + arraySize+ ")";
            }
        } else {
            return type.asCode() + " " + getName() + av;
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
            throw new RuntimeException("Unknown type " + getName() + ", is_property=" + is_property + ", " );
        }

		return type.isPrimative();
	}

    @Override
    public String toString() {
        return "VariableDef ["+debugValue+" accessor=" + accessor + ", arraySize=" + arraySize + ", assignValue=" + assignValue
                + ", cast_to=" + cast_to + ", indexSize=" + indexSize + ", is_annoymous=" + is_annoymous
                + ", is_reference=" + is_reference + ", name=" + name + ", params=" + params + ", type=" + type
                + ", value=" + value + " line="+getLine()+" ]";
    }
}