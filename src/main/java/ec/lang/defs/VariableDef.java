package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.expressions.TypeExpr;

public class VariableDef extends StatementDef {
    public Enums.Accessor accessor; 
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

    public void setValues(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line) {
        this.name = name;
        //**************** reference */
        this.type = new TypeIdDef(type);

        this.type.is_array = isArray;
        if (castTo != null) {
            this.cast_to = new TypeIdDef(castTo);
        }

        if (size != null) {
            if (size.matches("[0-9_]")) {
                indexSize = Integer.parseInt(size.replace("_", ""));
            } else {
                // const value
                arraySize = size;
            }
            
        }

        this.line = line;
    }

    @Override
    public void resolve_01() {
        System.out.println("@@VaribaleDef.resolve " + name + ", type="+ type);
        super.resolve_01();

        if (assignValue != null) {
            if (assignValue instanceof TypeExpr) {
                ((TypeExpr)assignValue).isGet = true;
            }


            assignValue.resolve_01();
        }

        if (type.name.equals("@")) {
            // equals something - so the type of the equals
            System.out.println("@@resolve type " + name);
            if (assignValue == null) {
                throw new RuntimeException("type cannot be resolved for " + name);
            }

            if (assignValue.thisType != null) {
                type = assignValue.thisType;
                System.out.println("@@VaribaleDef.resolved " + name + ", "  + type);
            } else {
                System.out.println("@@Not resolved " + name + ", " + assignValue.getClass());
            }
        }
    }

    public void setCastTo(String castTo) {
        cast_to = new TypeIdDef(castTo);
    }

    public void setValues(String accessor, String name, String type, boolean isArray, String castTo, String size, String reference, String line, String assignable, ExprDef expr) {
        this.setValues(accessor, name, type, isArray, castTo, size, reference, line);
        assignValue = expr;
        System.out.println("@@Assign = " + expr);
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

        return type.asCode() + " " + getName() + (type.is_array ? "[" + (indexSize > 0 ? ""+indexSize : "")+ "]" : "") 
            + (assignValue == null ? "" : " = " + assignValue.asCode());
    }

    @Override
    public String toString() {
        return "VariableDef [accessor=" + accessor + ", cast_to=" + cast_to + ", is_reference=" + is_reference
                + ", name=" + getName() + ", type=" + type + ", value=" + value + "]";
    }

	public boolean isPrimative() {
		return type.isPrimative();
	}
}