package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class ClassDef extends BaseDef implements ContainerDef {

    public String name;
    public Enums.Accessor acccessor;
    public Enums.ClassType classType;
    public boolean is_final;
    public String namespace;
    public List<VariableDef> variableDefs = new ArrayList<>();
    public List<FunctionDef> functionDefs = new ArrayList<>();
    public List<FunctionDef> constructors = new ArrayList<>();
    public List<String> implementations = new ArrayList<>();

    public List<VariableDef> properties = new ArrayList<>();

    private ClassDef parent = null;

    private String classVar = null;

    @Override
    public void prepare_03() {
        // loop through the children
        for(VariableDef var : variableDefs) {
            var.prepare_03();
        }

        for (FunctionDef funct : functionDefs) {
            funct.prepare_03();
        }

        // change all the function sigs

        // generate the properties functions
        for(VariableDef var : properties) {
            variableDefs.add(var);

            FunctionDef getter = new FunctionDef();
            getter.name = getClassVar() + "_get_" + var.getName();
            getter.accessor = var.accessor;
            getter.returnType = var.type;
            getter.content = new BlockDef();
            getter.content.exprDefs.add(new DirectExpr("\n  return this." + var.getName() + ";"));

            VariableDef param = new VariableDef();
            param.setName("this");
            param.type = new TypeIdDef(getClassVar());
            getter.parameters.add(param);

            addFunction(getter);

            FunctionDef setter = new FunctionDef();
            setter.name = getClassVar() + "_set_" + var.getName();
            setter.parameters.add(param);
            setter.parameters.add(var);
            setter.accessor = var.accessor;
            setter.returnType = new TypeIdDef("void");
            setter.content = new BlockDef();
            setter.content.exprDefs.add(new DirectExpr("\n  this." + var.getName() + " = " + var.getName() +";" ));
            addFunction(setter);
        }



        super.prepare_03();
    }

    @Override
    public boolean validate_02() {
        // TODO Auto-generated method stub
        return super.validate_02();
    }

    public String getClassVar() {
        if (classVar == null) {
            classVar = name + FileDef.getNextValueNumber();
        }
        return classVar;
    };

    public String asHeader() {
        return "";
    }

    public void addFunction(FunctionDef functionDef) {
        functionDefs.add(functionDef);
        functionDef.classDef = this;
    }

    public void addVariable(VariableDef variableDef) {
        variableDefs.add(variableDef);
    }

    public void addProperty(VariableDef variableDef) {
        properties.add(variableDef);
    }

    private String functionsAsCode() {
        String res = "";
        boolean first = true;

        for(FunctionDef funct : functionDefs) {
            if (!first) {
                res += "\n";
            }
            res += funct.asCode();
            first = false;
        }
        return res;
    }

    private String createStruct() {
        String res = "";

        for(VariableDef var : variableDefs) {
            res += "  " + var.asCode() + ";\n";
        }

        return res;
    }

    public String asCode() {
        /* struct classVar {
            int value;
        }
        */
        return  "// " + name + "\n"
            + "#include \"types.h\"\n\n"
            + "typedef struct " + getClassVar() + " {\n"
            // type lookup information is in the reference table (the same meory reference table)
            + createStruct() + "} " + getClassVar() +";"
            +"\n\n"+ functionsAsCode();
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }
}