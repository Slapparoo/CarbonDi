package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class ClassDef extends StatementDef implements ContainerDef, Castable {

    public String name;
    public Enums.Accessor acccessor;
    public Enums.ClassType classType;
    public boolean is_final;
    public String namespace;
    public List<VariableDef> variableDefs = new ArrayList<>();
    public List<FunctionDef> functionDefs = new ArrayList<>();
    public List<FunctionDef> constructors = new ArrayList<>();
    public List<String> implementations = new ArrayList<>();
    public List<String> generics = new ArrayList<>();
    public String extends_;

    public List<VariableDef> properties = new ArrayList<>();

    public String filename;

    private BlockDef blockDef;

    private ClassDef parent = null;

    private String classVar = null;
    private boolean isClass;
    private boolean isStub; // should be mutually exclusive with isClass


    @Override
    public void resolve_01() {
        System.out.println("@@ClassDef.resolve " + name);

        if (blockDef == null) {
            return;
        }

        DefFactory.FUNCT_DEFS.add(new FunctionDef(name, name+ "_create"));

        for (StatementDef statementDef : blockDef.statementDefs) {
            if (statementDef.getClass().equals(FunctionDef.class)) {
                System.out.println("*function " + statementDef);
                functionDefs.add((FunctionDef)statementDef);
                ((FunctionDef)statementDef).classDef = this;
            }   
        }

        // remove functions and variables from main block
        blockDef.statementDefs.removeAll(functionDefs);

        // resolve extends to the parentClass
        parent = DefFactory.resolveClass(extends_, this);
    }

    public void setValues(String name, String isFinal, String isClass, String isStub) {
        this.name = name;
        this.is_final = isFinal != null;
        this.isClass = isClass == null;
        this.isStub = isStub == null;
    }


    @Override
    public void prepare_03() {
        // loop through the children
        for(VariableDef var : variableDefs) {
            var.prepare_03();
        }

        for (FunctionDef funct : functionDefs) {
            funct.classDef = this;
            funct.prepare_03();
        }

        // change all the function sigs

        // generate the properties functions
        for(VariableDef var : properties) {
            variableDefs.add(var);

            FunctionDef getter = new FunctionDef();
            // getter.name = getClassVar() + "_get_" + var.getName();
            getter.name = "get_" + var.getName();
            getter.accessor = var.accessor;
            getter.returnType = var.type;
            getter.setBlockDef(new BlockDef());

            getter.getBlockDef().statementDefs.add(new DirectStatement("\n  Object_ref *object_ref = useObject(_refId);"));
            getter.getBlockDef().statementDefs.add(new DirectStatement("  return (("+getClassVar()+"*)object_ref->data)->"+var.getName()+";"));

            VariableDef param = new VariableDef();
            param.setName("_refId");
            param.type = new TypeIdDef("i64");
            getter.parameters.add(param);

            addFunction(getter);

            FunctionDef setter = new FunctionDef();
            setter.name = "set_" + var.getName();
            // setter.name = getClassVar() + "_set_" + var.getName();
            setter.parameters.add(param);
            setter.parameters.add(var);
            setter.accessor = var.accessor;
            setter.returnType = new TypeIdDef("void");
            setter.setBlockDef(new BlockDef());

            if (!var.isPrimative()) {
                setter.getBlockDef().statementDefs.add(new DirectStatement("borrowObject("+var.getName()+");"));
            }

            setter.getBlockDef().statementDefs.add(new DirectStatement("\n  Object_ref *object_ref = useObject(_refId);"));
            setter.getBlockDef().statementDefs.add(new DirectStatement("  (("+getClassVar()+"*)object_ref->data)->" + var.getName() + " = " + var.getName() +";" ));
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
            // classVar = name + FileDef.getNextValueNumber();
            classVar = name;
        }
        return classVar;
    };

    public String getClassFQN() {
        return getNamespace() +"."+getClassVar();
    }

    public String getClassFQNHash() {
        return "a"+Math.abs(getClassFQN().hashCode())+ "_";
    }

    public String getFreeMethod() {
        // every property that is not primative calls returnObject(id);
        // because of the flat model there is no need to mine into parents
        String res = "void " + getClassFQNHash() + "_free(num _refId) {"
        + " Object_ref *object_ref = useObject(_refId);";

        for (VariableDef variableDef : properties) {
            if (!variableDef.isPrimative()) {
                res += "\n  returnObject((("+getClassVar()+"*)object_ref->data)->"+variableDef.getName()+");";
            }
        }
        return res + "\n}";
    }


    public String asHeader() {
        return "// generated EC compiled source"
        +"\n#ifndef __"+getClassFQN().toUpperCase().replace('.','_')+"_H__"
        + "\n#define __"+getClassFQN().toUpperCase().replace('.','_') +"_H__"
        + "\n#include \"types.h\""
        + getParentIncludes()
        + getDependancies()
        // @TODO include class dependancies
        + "\n\n// @TODO include class dependancies\n"
        // content here
        + createDataModel()
        + createClassMethodsHeader()
        + "typedef struct " + getClassVar() + " {\n"
        // type lookup information is in the reference table (the same meory reference table)
        + getParentDataModel()
        + getDataModelName() + "\n} " + getClassVar() +";"
        + "\n"+getClassVar() +"ClassModel* get" +getClassVar() +"ClassModel();"
        + "\nvoid populate" +getClassVar() +"ClassModel(void* classModel);"
        + "\ni64 "+getClassVar() +"_create();"
        + "\n\n"
        + "\n#endif";
        
    }

    private String getDependancies() {
        return "\n/* inlcudes */";
    }

    private String getParentIncludes() {
        if (parent == null) {
            return "";
        }
        return "\n#include \"" + parent.filename + ".h\"";
    }

    private String getDataModelName() {
        return ("__"+getClassFQN().replace('.', '_') +"_Data_").toUpperCase();
    }

    private String getClassStructName() {
        return 
            ("__"+getClassFQN().replace('.', '_') +"_Class_").toUpperCase();
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
            String n = funct.name;
            funct.name = getClassFQNHash()+ funct.name;
            res += funct.asCode();
            funct.name = n;
            first = false;
        }

        res += "\n" + getFreeMethod() + "\n";

        return res;
    }

    private String createDataModel() {
        String res = "#define " + getDataModelName() + " ";

        for(VariableDef var : variableDefs) {
            res += " \\\n " + var.asCode() + ";";
        }

        return res;
    }

    private String createClassMethods() {
        // @TODO get parent classes

        /*
            i64 (*length)(i64);
         */

        String res = "#define " + getClassStructName();

        for(FunctionDef funct : functionDefs) {
            res += "  \\\n  "+funct.asClassModelDef() +";";
        }
        return res;
    }

    private String populateClassMethods() {
        String res = "";
        for(FunctionDef funct : functionDefs) {
            res += "\n  thisClassModel->"+ funct.name +" = &"+ getClassFQNHash() + funct.name +";";
        }

        res += "\n  thisClassModel->free = &"+ getClassFQNHash() +"_free;";
        return res;

    }

    public String getNamespace() {
        return (namespace == null ? "Default" : namespace);
    }

    private String createClassMethodsHeader() {
        return "\n" + createClassMethods()
        
            + "\ntypedef struct "+ getClassVar() +"ClassModel {"
            +"\n __STANDARDCLASS_MODEL_"
            + "\n" + getParentClassModel()
            + getClassStructName()
            +"\n} "+ getClassVar() +"ClassModel;\n\n";
    }

    private String getParentDataModel() {
        if (parent == null) {
            return "";
        };

        return parent.getParentDataModel() + "\n" + parent.getDataModelName() + "\n"; 
    }


    private String getParentClassModel() {
        if (parent == null) {
            return "";
        };

        return parent.getParentClassModel() + "\n" + parent.getClassStructName() + "\n"; 
    }

    private String createInitMethod() {
        return  ""
        + "\ni64 "+getClassVar()+"_create() {"
        + "\n  "+getClassVar()+" * _"+getClassVar()+" = malloc(sizeof("+getClassVar()+"));"
        + "\n  return createObject(_"+getClassVar()+", (ClassModel*)get"+getClassVar()+"ClassModel(), false);"
        + "\n}\n"
        + "\n"+getClassVar()+"ClassModel* _"+getClassVar() +"ClassModel = NULL;"
        + "\n"+getClassVar() +"ClassModel* get" +getClassVar() +"ClassModel() {"
        + "\n  if (_"+getClassVar()+"ClassModel == NULL) {"
        + "\n    _"+getClassVar()+"ClassModel = malloc(sizeof("+getClassVar()+"ClassModel));"
        // + "\n          _"+getClassVar()+"Name = malloc(6);"
        // + "\n          strcpy(_"+getClassVar()+"Name, \""+getClassVar()+"\");"
        + "\n    populate"+getClassVar()+"ClassModel(_"+getClassVar()+"ClassModel);"
        + "\n  }"
        + "\n  return _"+getClassVar()+"ClassModel;"
        + "\n}\n"
        + "\nvoid populate"+getClassVar()+"ClassModel(void* classModel) {"
        + "\n // @TODO need to use the parent class model"
        + "\n  populateObjectClassModel(classModel);"
        + "\n "+ getPopulateParent()
        + "\n  "+getClassVar()+"ClassModel* thisClassModel = ("+getClassVar()+"ClassModel*)classModel;"
        // this will need to change to the parent class
        + "\n  thisClassModel->parent = getObjectClassModel();"
        + "\n  thisClassModel->name = \""+getClassVar()+"\";" 
        + "\n  thisClassModel->package = \""+getNamespace()+"\";"
        + populateClassMethods() 
        + "\n // @TODO populate class methods"
        + "\n // @TODO populate class overrides"
        + "\n}\n\n";
    }

    private String getPopulateParent() {
        if (extends_ == null) return "";
        return "populate"+extends_+"ClassModel(classModel);";
    }

    public String asCode() {
        /* struct classVar {
            int value;
        }
        */
        return  "// " + name + "\n"
            + "#include \"types.h\""
            + "\n#include \""+ getClassFQN()+ ".h\""
            +"\n\n"+ functionsAsCode()
            + "\n\n" + createInitMethod();
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        System.out.println("*ClassDef setBlock " + blockDef);
        this.blockDef = blockDef;
    }

    @Override
    public void setCastType(String casttype) {
        this.extends_ = casttype;
    }

}