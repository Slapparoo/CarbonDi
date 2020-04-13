package ec.lang.defs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ec.lang.defs.Enums.Accessor;

public class ClassDef extends StatementDef implements ContainerDef, Castable {

    public String name;
    public Enums.Accessor acccessor = Accessor.PUBLIC;
    public Enums.ClassType classType;
    public boolean is_final;
    public boolean is_signature = false;
    public String namespace;
    public List<VariableDef> variableDefs = new ArrayList<>();
    public List<FunctionDef> functionDefs = new ArrayList<>();
    public List<String> implementations = new ArrayList<>();
    public List<ConstructorDef> constructorDefs = new ArrayList<>();
    public List<String> generics = new ArrayList<>();
    public String extends_;

    public FileDef fileDef = null;
    public Accessor readAccessor = Accessor.PUBLIC;
    public Accessor writeAccessor = Accessor.PUBLIC;

    private Map<String, ConstructorDef> constructors = new HashMap<>();


    public List<VariableDef> properties = new ArrayList<>();

    public String filename;

    private BlockDef blockDef;

    public ClassDef parent = null;

    private String classVar = null;
    private boolean is_class = true;
    private boolean is_stub; // should be mutually exclusive with isClass

    public static class SortbySignature implements Comparator<FunctionDefBase> {
        // Used for sorting in ascending order of
        // roll number

        // only sort constructors - don't sort functions bad things might happen
        public int compare(FunctionDefBase a, FunctionDefBase b) {
            return a.getSignature().compareTo(b.getSignature());
        }
    }

    static SortbySignature SortbySignature = new SortbySignature();

    public VariableDef resolveProperty(String name) {
        for (VariableDef var : properties) {
            if (var.getName().equals(name)) {
                return var;
            }
        }
        return null;
    }

    /**
     * change to signature
     * @param name
     * @return
     */
    public FunctionDef resolveFunction(String name) {
        for (FunctionDef fd : functionDefs) {
            if (fd.name.equals(name)) {
                return fd;
            }
        }
        return null;
    }


    public String getNamespace() {
        if (namespace == null) {
            namespace = "Default";
        }
        return namespace;
    }

    @Override
    public void resolve_01() {
        int i = name.lastIndexOf('.');
        if (i > 0) {
            namespace = name.substring(0, i);
            name = name.substring(i+1);
            classVar = name;

            filename = namespace + "." + name;
        }

        // System.out.println("@@ClassDef.resolve " + name);
        if (extends_ == null && !name.equals("Object") ) {
            extends_ = "Object";
        } 

        // resolve extends to the parentClass
        parent = DefFactory.resolveClass(extends_, this);

        blockDef.isClass = true;

        if (blockDef == null) {
            return;
        }

        DefFactory.FUNCT_DEFS.add(new FunctionDef(name, "create_" + name));

        for (StatementDef statementDef : blockDef.statementDefs) {
            if (statementDef.getClass().equals(FunctionDef.class)) {
                // System.out.println("*function " + statementDef);
                functionDefs.add((FunctionDef) statementDef);
                ((FunctionDef) statementDef).classDef = this;
            }
            if (statementDef.getClass().equals(ConstructorDef.class)) {
                ConstructorDef cd = (ConstructorDef) statementDef;
                if (!cd.name.equals(name)) {
                    throw new RuntimeException("Invalid constructor name in class " + name + ", " + cd.name);
                }
                constructorDefs.add((ConstructorDef) statementDef);
                ((ConstructorDef) statementDef).classDef = this;
            }
        }

        // default constructor
        ConstructorDef defaultConstructor = new ConstructorDef(name) {
            @Override
            public String asCode() {
                return "/* default constructor */";
            }

            @Override
            public String asHeader() {
                return "/* default constructor */";
            }

            @Override
            public String asSignature() {
                return "/* default constructor */";
            }

        };

        constructorDefs.add(defaultConstructor);

        for (VariableDef variableDef : properties) {
            variableDef.is_property = true;
        }

        addReturnFunction("getClassName", "\""+getClassVar()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getClassPackage", "\""+getNamespace()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getObjectDatasize", "sizeof("+getClassVar()+")", new TypeIdDef("u64"), true, true, true);

        // add all parent constructors
        // we assume that resolce isready run on the parent so it will already have
        // resolced all teh constructors
        if (parent != null) {
            properties.addAll(parent.properties);
            // constructorDefs.addAll(parent.constructorDefs);

            for (ConstructorDef c : parent.constructorDefs) {
                ConstructorDef nc;
                try {
                    nc = (ConstructorDef) c.clone();
                    nc.name = name;
                    nc.classDef = this;
                    boolean exists = false;
                    nc.resolve_01();
                    for (ConstructorDef tc : constructorDefs) {
                        if (tc.getSignature().equals(nc.getSignature())) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        constructorDefs.add(nc);
                    }
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }

            for (FunctionDef c : parent.functionDefs) {
                FunctionDef nc;

                if (c.is_property) {
                    continue;
                }
                try {
                    nc = (FunctionDef) c.clone();
                    nc.classDef = this;
                    boolean exists = false;
                    nc.is_parent = true;
                    if (nc.parameters.size() > 0) {

                        if (nc.parameters.get(0).getName().equals("this") || nc.parameters.get(0).getName().equals("_refId")) {
                            nc.parameters.remove(0);
                        }
                    }
                    
                    for (FunctionDef tc : functionDefs) {
                        // if (tc.name.equals(nc.name)) {
                        if (tc.name.equals(nc.name)) {
                            exists = true;

                            if (c.name.equals("release")) {
                                tc.accessor = Accessor.HIDDEN;
                            }
            
                            break;
                        }
                    }
                    if (!exists) {
                        functionDefs.add(nc);
                        nc.resolve_01();
                    }
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }


        }
        blockDef.isClass = true;
        for (StatementDef statementDef : blockDef.statementDefs) {
            if (statementDef instanceof BlockDef) {
                ((BlockDef)statementDef).isClass = true;
                ((BlockDef)statementDef).classDef = this;
            }

            if (statementDef instanceof FunctionDef) {
                if (((FunctionDef)statementDef).getBlockDef() != null) {
                    ((FunctionDef)statementDef).getBlockDef().isClass = true;
                    ((FunctionDef)statementDef).getBlockDef().classDef = this;
                }
            }

            statementDef.resolve_01();
        }

        Collections.sort(constructorDefs, SortbySignature); 

        for (ConstructorDef c : constructorDefs) {
            if (c.name.equals(name)) {
                constructors.put(c.getSignature(), c);
            }
            
        }

        // find the constructor with the lowest priverledge level
        for (ConstructorDef c : constructorDefs) {
            ConstructorDef uc = constructors.get(c.getSignature());
            if (uc == null) {
                continue;
            }
            
            if (uc != c) {
                if (c.accessor.ordinal() < uc.accessor.ordinal()) {
                    constructors.put(c.getSignature(), c);
                }
            }
        }
        
        // remove functions and variables from main block
        blockDef.statementDefs.removeAll(functionDefs);
        blockDef.statementDefs.removeAll(constructorDefs);

        // remove extra constructors
        List<ConstructorDef> tmpl = new ArrayList<>();
        for (ConstructorDef c : constructorDefs) {
            if (!constructors.containsValue(c)) {
                tmpl.add(c);
            }
        }
        constructorDefs.removeAll(tmpl);

        int index = 0;
        for (ConstructorDef c : constructorDefs) {
            if (!Accessor.HIDDEN.equals(c.accessor)) { 
                c.indexNumber = index++;
            }
        }

    }

    public void setValues(String name, String isFinal, String isClass, String isStub, String isSig) {
        this.name = name;
        this.is_final = isFinal != null;
        this.is_class = isClass != null;
        this.is_stub = isStub != null;

        this.is_signature = isSig != null;

        // System.out.println("@@newclass " + name);
    }


    private FunctionDef addReturnFunction(String functionName, String returnvalue, TypeIdDef returnType,  boolean isOverride, boolean is_static, boolean is_final) {
        return addFunction(functionName,
            new DirectStatement("  return  "+returnvalue+";"),
            returnType, isOverride, is_static, is_final
            );
    }

    private FunctionDef addVoidFunction(String functionName, String body,  
        boolean isOverride, boolean is_static, boolean is_final) {
        return addFunction(functionName, 
            new DirectStatement(body+";"),
            new TypeIdDef("void"), isOverride, is_static, is_final
            );
    }

    private FunctionDef addFunction(String functionName, DirectStatement body, 
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
            param.setName("_refId");
            param.type = new TypeIdDef("num");
            funct.parameters.add(param);
        }
        funct.is_override = isOverride;
        functionDefs.add(funct);
        return funct;
    }


    @Override
    public void prepare_03() {

        // most of this needs to move to resolve

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

            if (isParentProperty(var)) {
                continue;
            }
            variableDefs.add(var);

            String body ="";
            if (var.is_static) {
                body = "(("+getClassVar()+"ClassModel*)get"+getClassVar()+"ClassModel())->"+var.getName();
            } else {
                body = "(("+getClassVar()+"*)useObject(_refId)->data)->"+var.getName();
            }

            FunctionDef funct = addReturnFunction("get_" + var.getName(), 
            body, 
            var.type, false, var.is_static, true
            );

            funct.accessor = var.readAccessor;
            funct.is_property = true;
            // private FunctionDef addVoidFunction(String functionName, String body,  
            // boolean isOverride, boolean is_static, boolean is_final) {

            if (var.is_static) {
                if (var.isPrimative()) {
                    // TODO use snippit factory
                    body = "(("+getClassVar()+"ClassModel*)get"+getClassVar()+"ClassModel())->"+var.getName() + " = " + var.getName();
                } else {
                    body = "assignObject(&(("+getClassVar()+"ClassModel*)get"+getClassVar()+"ClassModel())->"+var.getName()+", "+var.getName()+")";
                }
            } else {
                if (var.isPrimative()) {
                    body = "(("+getClassVar()+"*)useObject(_refId)->data)->" + var.getName() + " = " + var.getName();
                } else {
                    body = "assignObject(&(("+getClassVar()+"*)useObject(_refId)->data)->" + var.getName()+", "+var.getName()+")";
                }
            }
    
    
            FunctionDef setter =addVoidFunction("set_" + var.getName(), body, false, var.is_static, true);

            setter.parameters.add(var);
            setter.accessor = var.writeAccessor;
            setter.is_property = true;

            if (var.type == null) {
                throw new RuntimeException("Unknown type " + namespace+"::"+name +"."+ var.getName());
            }
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
        + "\npointer get" +getClassVar() +"ClassModel();"
        + "\nvoid populate" +getClassVar() +"ClassModel(pointer classModel);"
        + "\nnum create_"+getClassVar() +"();"
        + createConstructorsHeader()
        + "\n\n"
        + "\n#endif";
        
    }

    private String getDependancies() {
        return "\n/* includes */";
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

    public boolean isParentProperty(VariableDef var) {
        if (parent != null) {
            for (VariableDef variableDef : parent.properties) {
                if (var == variableDef || variableDef.getName().equals(var.getName()) ) {
                    return true;
                }
            }
        }

        return false;

    }

    private String createDataModel() {
        String res = "#define " + getDataModelName() + " ";


        for(VariableDef var : variableDefs) {
            if (!(isParentProperty(var) || var.is_static)) {
                res += " \\\n " + var.asHeader() + ";";
            }
        }

        return res;
    }

    private String createClassModelHeader() {
        String res = "#define " + getClassStructName();
        res += (name.equals("Object") ? "  \\\npointer *parent;" : "");
        for(FunctionDef funct : functionDefs) {
            if ((funct.is_override || funct.is_parent) && !name.equals("Object")) {
                continue;
            }
            res += "  \\\n  "+funct.getExpandedSignature() +";";
        }

        for(VariableDef var : variableDefs) {
            if (!var.is_static ) {
                continue;
            }
            res += "  \\\n  "+var.asHeader() +";";
        }

        return res;
    }

    private String populateClassMethods() {
        String res = "";
        for(FunctionDef funct : functionDefs) {
            if (!funct.is_parent) {
                res += "\n  thisClassModel->"+ funct.name +" = "+ getClassFQNHash() + funct.name +";";
            }
        }

        for(VariableDef var : variableDefs) {
            if (isParentProperty(var) || !var.is_static) {
                continue;
            }
            if (var.assignValue != null) {
                res += "\n/*cds1*/thisClassModel->"+ var.getName() +" = "+ var.assignValue.asCode() +";";
            }
        }

        res += "\n  thisClassModel->free = "+ getClassFQNHash() +"_free;";
        return res;

    }

    private String createClassMethodsHeader() {
        return "\n" + createClassModelHeader()
            + "\ntypedef struct "+ getClassVar() +"ClassModel {"
            + "\n" + getParentClassModel()
            + getClassStructName()
            +"\n} "+ getClassVar() +"ClassModel;\n\n"
            ;
    }

    private String createConstructorsHeader() {
        String res = "";
        for (ConstructorDef constructorDef : constructorDefs) {
            if (!Accessor.HIDDEN.equals(constructorDef.accessor)) { 
                res += "\n"+constructorDef.asHeader();
            }
        }
        return res;
    }

    private String createConstructorsCode() {
        String res = "";
        for (ConstructorDef constructorDef : constructorDefs) {
            if (!Accessor.HIDDEN.equals(constructorDef.accessor)) { 
                res += "\n"+constructorDef.asCode();
            }
        }
        return res;
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
        + "\nnum create_"+getClassVar()+"() {"
        + "\n  "+getClassVar()+" * _"+getClassVar()+" = ec_calloc(sizeof("+getClassVar()+"), sizeof(char));"
        + populateDefaultValues()
        + "\n  return createObject(_"+getClassVar()+", get"+getClassVar()+"ClassModel(), false);"
        + "\n}\n"
        + "\npointer _"+getClassVar() +"ClassModel = NULL;"
        + "\npointer get" +getClassVar() +"ClassModel() {"
        + "\n  if (_"+getClassVar()+"ClassModel == NULL) {"
        + "\n    _"+getClassVar()+"ClassModel = ec_malloc(sizeof("+getClassVar()+"ClassModel));"
        + "\n    registerClassModel(_"+getClassVar()+"ClassModel);"
        + "\n    populate"+getClassVar()+"ClassModel(_"+getClassVar()+"ClassModel);"
        + "\n  }"
        + "\n  return _"+getClassVar()+"ClassModel;"
        + "\n}\n"
        + "\n"+ createConstructorsCode()
        + "\nvoid populate"+getClassVar()+"ClassModel(pointer classModel) {"
        + "\n  populateObjectClassModel(classModel);"
        + "\n "+ getPopulateParent()
        + "\n  "+getClassVar()+"ClassModel* thisClassModel = ("+getClassVar()+"ClassModel*)classModel;"
        + "\n  thisClassModel->parent = "+getObjectClassModel()+";"
        + populateClassMethods() 
        + "\n}\n\n";
    }

    private String populateDefaultValues() {
        String res = "";
        for(VariableDef var : variableDefs) {
            if (var.is_static) {
                continue;
            }

            if (var.assignValue != null) {
                // "(("+name+"*)_"+getClassVar()+")->
                res += "\n/*cdv1*/(("+name+"*)_"+getClassVar()+")->"+ var.getName() +" = "+ var.assignValue.asCode() +";";
                // TODO Arrays
            }
        }

        return res;
    }

    private String getObjectClassModel() {
        if (parent != null) {
            return "get"+parent.name +"ClassModel()";
        }
        return "getObjectClassModel()";
    }

    private String getPopulateParent() {
        if (extends_ == null) return "";
        return "populate"+extends_+"ClassModel(classModel);";
    }

    public String getContainedClassesAsCode() {
        String res = "";

        for (ClassDef classDef : fileDef.getClasses()) {
            if (classDef.filename != null && !classDef.filename.equals(name)) {
                res += "\n#include \"" + classDef.filename + ".h\""; 
            }
        } 
        return res;
    }

    public String asCode() {
        /* struct classVar {
            int value;
        }
        */
        return  "// " + name + "\n"
            + "#include \"types.h\""
            + "\n#include \""+ getClassFQN()+ ".h\""
            + getContainedClassesAsCode()
            +"\n\n"+ functionsAsCode()
            + "\n\n" + createInitMethod();
    }

    @Override
    public String asSignature() {
        return  "// "+namespace + "::" + name + " Signature compiled"
            // + "\nnamespace "+ getNamespace()+";"
            + "\n/* imports {} */\n"
            + "\n" + acccessor
            + (is_final ? " final" : "")
            + (is_class ? " class" : " stub")
            + " signature " + getNamespace() + "." + name
            + instanceofAsSignature()
            +"{\n"
            + propertiesAsSignature()
            + functionsAsSignature()
            + "\n}";
    }



    private String propertiesAsSignature() {
        if (properties.size() == 0) {
            return "";
        }

        String res = "  ("+readAccessor+","+writeAccessor+") properties {" ;

        for (VariableDef prop : properties) {
            res += "\n    " + prop.asSignature();
        }

        return res + "\n  }\n";
    }

    private String functionsAsSignature() {
        String res = "";

        for (ConstructorDef constructorDef : constructorDefs) {
            res += "\n  " + constructorDef.asSignature();
        }

        if (res.length() > 0) {
            res += "\n";
        }

        for (FunctionDef functionDef : functionDefs) {
            res += functionDef.asSignature();
        }

        return res;
    }

    private String instanceofAsSignature() {
        if (parent != null) {
            return "(" + parent.name + ")";
        }
        return "";
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        // System.out.println("*ClassDef setBlock " + blockDef);
        this.blockDef = blockDef;
    }

    @Override
    public void setCastType(String casttype) {
        this.extends_ = casttype;
    }

}