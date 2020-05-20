package ec.lang.defs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.lang.defs.Enums.Accessor;

public class EncapsulationDef extends FunctionDefBase implements Cloneable {
    private String getorset = null;
    private String propertyName = "";
    // private boolean isGetter = true;
    // private boolean isOverride = true;
    public TypeIdDef returnType;

    public static final Set<String> OPERATIONS = new HashSet<>();

    static {
        // some how make this extensible
        // overrides
        OPERATIONS.add("get");
        OPERATIONS.add("set");

        // events
        OPERATIONS.add("onGet");
        OPERATIONS.add("onChange");
        OPERATIONS.add("validate");

        // thread operations
        OPERATIONS.add("onStart");
        OPERATIONS.add("onComplete");
        OPERATIONS.add("onWait");
        OPERATIONS.add("onError");
        OPERATIONS.add("onException");
        OPERATIONS.add("onTimeout");
    }

    public String getFunctioname() {
        return getorset+ "_" + propertyName; 
    }

    public boolean hasGetter() {
        return getorset.equals("get");
    }

    public boolean hasSetter() {
        return getorset.equals("set");
    }

    public boolean isOnChange() {
        return getorset.equals("onChange");
    }

    public boolean isOnGet() {
        return getorset.equals("onGet");
    }

    public boolean isValidate() {
        return getorset.equals("validate");
    }

    public String getPropertyName() {
        return propertyName;
    }

    public EncapsulationDef() {
        accessor = Accessor.PUBLIC;
    }

    public EncapsulationDef(String name) {
        setName(name);
        accessor = Accessor.PUBLIC;
    }

    public void setName(String name) {
        this.name = name;
        String[] tokens = name.split("\\.");
        // does this belong in validate or resolve?
        if (tokens.length == 2) {
            getorset = tokens[1];
            propertyName = tokens[0];
        } else {
            throw new RuntimeException("Unexception token " + name + " expected <property_name>.<get|set>");
        }
    }

    public String getSignature() {
        return (returnType.getName().equals("void") ? "void" : returnType.asCode())  
        + (returnType.isIs_array() ? "*" : "")  
        + " (*"+ name + ")(" + getParamsSignature() + ")";
    }

    public String getExpandedSignature() {
        return (returnType.getName().equals("void") ? "void" : returnType.asSignature()) 
        + " (*"+ getExpandedName() + ")(" + getParamsSignatureAsCode() + ")";
    }


    public String asSignature() {

        return "\n  " + accessor + " " 
        + (is_static ? "static " : "")
        + (is_final ? "final " : "")
        + (returnType.getName().equals("void") ? "void" : returnType.asSignature()) + " " +name+"("+ paramsAsSignature() +");";
    }



    private String paramsAsSignature() {
        String res = "";
        return res;
    }


    public String asHeader() {
        return "";
    }

    // String getBlockasCode() {
    //     getBlockDef().functionBlock = true;

    //     return getBlockDef().asCode();
    // }

    public String asCode() {
        // getBlockDef().functionBlock = true;
        // return "/*enc1*/"+  (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "[]" : "")  
        //     + " "+ name + "(" + paramsAsCode() + ")" 
        //     + contentAsCode() ;
        return contentAsCode();
    }

    @Override
    public void resolve_01() {
        super.resolve_01();

        if (getorset == null) {
            throw new RuntimeException("It looks like the setName method wasn't called first " + name);
        }

        if (!OPERATIONS.contains(getorset)) {
            throw new RuntimeException("Unexpected encapsulation value " + getorset + ", " + name + " excepted one of " + OPERATIONS);
        }

        if (classDef == null) {
            throw new RuntimeException("encapsulation override must have a class " + name);
        }

        if (getBlockDef() == null) { 
            throw new RuntimeException("Unexpected encapsulation error block == null " + name);
        }

        VariableDef thisProperty  = classDef.resolveProperty(propertyName);

        if (thisProperty == null) {
            throw new RuntimeException("Can't resolve property " + propertyName + " for class " + classDef.getFqn());
        }
        
        is_static = thisProperty.is_static;
        if (!is_static) {
            VariableDef def_this = new VariableDef();
            def_this.setName("this");
            def_this.type = new TypeIdDef(classDef.getShortname());
            addParameter(def_this);
            getBlockDef().addVariable(def_this);
        }

        if (getorset.equals("set")) {
            VariableDef def_this = new VariableDef();
            def_this = new VariableDef();
            def_this.setName("$a");
            def_this.type = thisProperty.type;
            getBlockDef().addVariable(def_this);
            addParameter(def_this);
            returnType = new TypeIdDef("void");
        } else if (getorset.equals("get")) {
            returnType = thisProperty.type;
        } else if (getorset.equals("onget")) {
            returnType = new TypeIdDef("void");
        } else if (getorset.equals("validate")) {
            // $a error messages
            // VariableDef def_this = new VariableDef();
            // def_this = new VariableDef();
            // def_this.setName("$a");
            // def_this.type = thisProperty.type;
            // getBlockDef().addVariable(def_this);
            // parameters.add(def_this);
            returnType = new TypeIdDef("void");
        } else if (getorset.equals("onChange")) {
            VariableDef def_this = new VariableDef();
            def_this = new VariableDef();
            def_this.setName("$a");
            def_this.type = thisProperty.type;
            getBlockDef().addVariable(def_this);
            addParameter(def_this);
            returnType = new TypeIdDef("void");
        }


        getBlockDef().directAccess.add(propertyName);
        getBlockDef().resolve_01();

        name = getorset + "_" + propertyName;
    }


    @Override
    public void prepare_03() {
    }

    // private String paramsAsCode() {
    //     String res = "/* param */";
    //     boolean first = true;

    //     // the first param is the class object
    //     for(VariableDef param : getParameters()) {
    //         if (!first) {
    //             res += ", ";
    //         }
    //         res += param.asCode();
    //         first = false;
    //     }
    //     return res;
    // }

    private String contentAsCode() {
        if (classDef.classType == Enums.ClassType.PLAN) {
            return "";
        } else {
            return getBlockDef().asCode() +"\n" ;
        }
    }

    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return getParameters();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }

    @Override
    public String toString() {
        return "EncapsulationDef [getorset=" + getorset + ", propertyName=" + propertyName + "] " + classDef + ", " + getBlockDef();
    }

    @Override
    public String asEcSignature() {
        return null;
    }
}
