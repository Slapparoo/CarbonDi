package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class FunctionDef extends ExprDef implements ContainerDef {
    public ClassDef classDef; // null or value
    public FileDef fileDef; // probably never null?
    public String name;
    public List<String> exceptions = new ArrayList<>();
    public List<VariableDef> parameters = new ArrayList<>();
    public TypeIdDef returnType;
    public BlockDef content;
    public Enums.Accessor accessor;
    public boolean is_static;
    public boolean is_final;

    public FunctionDef() {
    }

    public String asHeader() {
        return "";
    }

    @Override
    public void prepare_03() {
        if (classDef != null) {

            VariableDef param = new VariableDef();
            param.setName("this");
            param.type = new TypeIdDef(classDef.getClassVar());
            parameters.add(0, param);

            // function gets renamed
            name = classDef.getClassVar() + "_" + name;
        }
    }

    private String paramsAsCode() {
        String res = "";
        boolean first = true;

        // the first param is the class object

        for(VariableDef param : parameters) {
            if (!first) {
                res += ", ";
            }
            res += param.asCode();
            first = false;
        }
        return res;
    }

    private String contentAsCode() {
        if (classDef == null) {
            return "{" + (content == null ? "" : content.asCode()) +"}\n" ;
        } else {
            if (classDef.classType == Enums.ClassType.PLAN) {
                return "";
            } else {
                // this. will need to be added
                return "{" + (content == null ? "" : content.asCode()) +"}\n" ;
            }
        }
        // return "";
    }

    public String asCode() {
        return returnType.asCode() + (returnType.is_array ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ")" + contentAsCode() ;
    }


    @Override
    public String toString() {
        return "FunctionDef [accessor=" + accessor + ", content=" + content + ", exceptions="
                + exceptions + ", is_final=" + is_final + ", is_static=" + is_static + ", name=" + name
                + ", parameters=" + parameters + ", returnType=" + returnType + "]" ;
    }

    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return parameters;
    }
}
