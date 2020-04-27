package ec.lang.defs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ec.lang.defs.Enums.Accessor;

public class ClassDef extends StatementDef implements ContainerDef, Castable {

    private ClassName classname;
    private ClassName extendsclass;
    // private ExprDef purename;
    public Enums.Accessor acccessor = Accessor.PUBLIC;
    public Enums.ClassType classType;
    public boolean is_final;
    public boolean is_signature = false;
    public String namespace;
    private  List<VariableDef> variableDefs = new ArrayList<>();
    private List<FunctionDef> functionDefs = new ArrayList<>();
    private List<String> implementations = new ArrayList<>();
    private List<ConstructorDef> constructorDefs = new ArrayList<>();
    private List<String> generics = new ArrayList<>();
    

    public FileDef fileDef = null;
    public Accessor readAccessor = Accessor.PUBLIC;
    public Accessor writeAccessor = Accessor.PUBLIC;

    private Map<String, ConstructorDef> constructors = new HashMap<>();


    public List<VariableDef> properties = new ArrayList<>();
    public List<VariableDef> allProperties = new ArrayList<>();


    private BlockDef blockDef;

    public ClassDef parent = null;

    // private String classVar = null;
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

        // System.out.println("@@resolveProperty " + name + " " + properties);
        for (VariableDef var : properties) {
            if (var.getName().equals(name)) {
                return var;
            }
        }
        return null;
    }


    /**
     * If it has no params and returns a value it can be resolved as a getter
     * if it has 1 param and returns void it can be resolved as a setter
     * @param name
     * @return
     */
    public FunctionDef resolveFunctionAsProperty(String name) {
        FunctionDef fd = resolveFunction(name);
        if (fd == null) {
            return null;
        }

        boolean isVoid = fd.returnType.getName().equals("void");

        if (fd.parameters.size() == 1 && !isVoid && !fd.is_static) {
            return fd;
        }

        if (fd.parameters.size() == 0 && !isVoid && fd.is_static) {
            return fd;
        }

        if (fd.parameters.size() == 2 && isVoid && !fd.is_static) {
            return fd;
        }

        if (fd.parameters.size() == 1 && isVoid && fd.is_static) {
            return fd;
        }

        return null;
    }



    // is this required?
    public VariableDef resolveVariable(String name) {
        System.out.println("@@classdef.resolveVariable " + name );
        for (VariableDef var : variableDefs) {
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

    public ConstructorDef resolveConstructor(String signature) {
        for (ConstructorDef cd : constructorDefs) {
            if (signature.equals(cd.getSignature())) {
                return cd;
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

    public void addImplementation(String implmentation) {
        implementations.add(implmentation);
    }


    public void addGenerics(String generic) {
        generics.add(generic);
    }

    @Override
    public void resolve_01() {
        if (extendsclass == null && !getFqn().equals("Core.Object") ) {
            setCastType("Core.Object");
        } 
        
        blockDef.isClass = true;

        if (blockDef == null) {
            return;
        }

        DefFactory.FUNCT_DEFS.add(new FunctionDef(classname.getShortName(), "create_" + getCName()));

        for (StatementDef statementDef : blockDef.statementDefs) {
            if (statementDef.getClass().equals(FunctionDef.class)) {
                // System.out.println("*function " + statementDef);
                functionDefs.add((FunctionDef) statementDef);
                ((FunctionDef) statementDef).classDef = this;
            }
            if (statementDef.getClass().equals(ConstructorDef.class)) {
                ConstructorDef cd = (ConstructorDef) statementDef;
                if (!cd.name.equals(classname.getShortName())) {
                    throw new RuntimeException("Invalid constructor name in class " + classname + ", " + cd.name +", " + cd.asDebug());
                }
                constructorDefs.add((ConstructorDef) statementDef);
                ((ConstructorDef) statementDef).classDef = this;
            }
        }

        // default constructor
        ConstructorDef defaultConstructor = new ConstructorDef(classname.getShortName()) {
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

        defaultConstructor.classDef = this;
        constructorDefs.add(defaultConstructor);

        for (VariableDef variableDef : properties) {
            // variableDef.is_property = true;
            variableDef.classDef = this;
        }

        addReturnFunction("getClassName", "\""+getFqn()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getClassShortName", "\""+getShortname()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getClassCName", "\""+getCName()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getClassPackage", "\""+classname.getPackageName()+"\"", new TypeIdDef("pointer"), true, true, true);
        addReturnFunction("getObjectDatasize", "sizeof("+getCName()+")", new TypeIdDef("u64"), true, true, true);

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
                    nc.name = classname.getShortName();
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

            if (statementDef.containedInBlock == null) {
                blockDef.classDef = this;
                statementDef.containedInBlock = blockDef;
            }

            statementDef.resolve_01();
        }

        Collections.sort(constructorDefs, SortbySignature); 

        for (ConstructorDef c : constructorDefs) {
            if (c.name.equals(classname.getShortName())) {
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

        for (VariableDef variableDef : properties) {
            variableDef.containedInBlock = getBlockDef();
            variableDef.classDef = this;
            variableDef.resolve_01();
        }
    }

    public class ClassName {
        String fqn;

        ClassName(String fqn) {
            this.fqn = fqn;
        }

        String getFqn() {
            return fqn;
        }

        String getShortName() {
            return fqn.substring(fqn.lastIndexOf('.') +1);
        }

        String getPackageName() {
            return fqn.substring(0, fqn.lastIndexOf('.'));
        }

        // Shortened predictable fqn
        String getCName() {
            return "c_" + Math.abs(getPackageName().hashCode()) + "_" + getShortName();
        }

        @Override
        public String toString() {
            return getFqn();
        }
    }


    public void setName(String pure_name) {
        if (pure_name.contains(".")) {
            this.classname = new ClassName(pure_name);
        } else {
            if (namespace == null) {
                namespace = "Default";
            }

            this.classname = new ClassName(namespace + "." + pure_name);
        }
    }

    public void setValues(String isFinal, String isClass, String isStub, String isSig) {
        this.is_final = isFinal != null;
        this.is_class = isClass != null;
        this.is_stub = isStub != null;
        this.is_signature = isSig != null;
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
            param.setName("this");
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

        boolean optimise = true;
        for(VariableDef var : properties) {

            if (isParentProperty(var)) {
                continue;
            }
            variableDefs.add(var);

            String body ="";

            if (optimise) {
                if (var.is_static) {
                    body = "(("+getCName()+"_cm*)get"+getCName()+"_cm())->"+var.getName();
                } else {
                    body = "(("+getCName()+"*)useObject(this)->data)->"+var.getName();
                }
            } else {
                if (var.is_static) {
                    body = "(("+getCName()+"_cm*)get"+getCName()+"_cm())->"+var.getName();
                } else {
                    body = "(("+getCName()+"*)useObject(this)->data)->"+var.getName();
                }
            }

            FunctionDef funct = addReturnFunction("get_" + var.getName(), 
            body, 
            var.type, false, var.is_static, true
            );

            if (optimise) {
                funct.getBlockDef().includeEntryExit = false;
            }

            funct.accessor = var.readAccessor;
            funct.is_property = true;
            // private FunctionDef addVoidFunction(String functionName, String body,  
            // boolean isOverride, boolean is_static, boolean is_final) {

            if (var.is_static) {
                if (var.isPrimative()) {
                    // TODO use snippit factory
                    body = "(("+getCName()+"_cm*)get"+getCName()+"_cm())->"+var.getName() + " = " + var.getName();
                } else {
                    body = "assignObject(&(("+getCName()+"_cm*)get"+getCName()+"_cm())->"+var.getName()+", "+var.getName()+")";
                }
            } else {
                if (var.isPrimative()) {
                    body = "(("+getCName()+"*)useObject(this)->data)->" + var.getName() + " = " + var.getName();
                } else {
                    body = "assignObject(&(("+getCName()+"*)useObject(this)->data)->" + var.getName()+", "+var.getName()+")";
                }
            }
    
    
            FunctionDef setter = addVoidFunction("set_" + var.getName(), body, false, var.is_static, true);

            setter.parameters.add(var);
            setter.accessor = var.writeAccessor;
            setter.is_property = true;

            if (var.type == null) {
                throw new RuntimeException("Unknown type " + classname +" "+ var.getName());
            }
        }

        super.prepare_03();
    }

    @Override
    public boolean validate_02() {
        // TODO Auto-generated method stub
        return super.validate_02();
    }


    // public String getClassFQN() {
    //     return getNamespace() +"."+getClassVar();
    // }

    // public String getClassFQNHash() {
    //     return "a"+Math.abs(getClassFQN().hashCode())+ "_";
    // }

    public String getFreeMethod() {
        // every property that is not primative calls returnObject(id);
        // because of the flat model there is no need to mine into parents
        String res = "void " + getCName()+ "_free(num this) {"
        + " Object_ref *object_ref = useObject(this);";

        for (VariableDef variableDef : properties) {
            if (!variableDef.isPrimative()) {
                res += "\n  returnObject((("+getCName()+"*)object_ref->data)->"+variableDef.getName()+");";
            }
        }
        return res + "\n}";
    }


    public String asHeader() {
        return "// generated EC compiled source " + classname
        +"\n#ifndef __"+getCName().toUpperCase().replace('.','_')+"_H__"
        + "\n#define __"+getCName().toUpperCase().replace('.','_') +"_H__"
        + "\n#include \"Core.Core_main.h\""
        + getParentIncludes()
        + getDependancies()
        // @TODO include class dependancies
        + "\n\n// @TODO include class dependancies\n"
        // content here
        + createDataModel()
        + createClassMethodsHeader()
        + "typedef struct " + getCName()+ " {\n"
        // type lookup information is in the reference table (the same meory reference table)
        + getParentDataModel()
        + getDataModelName() + "\n} " + getCName() +";"
        + "\npointer get" +getCName()+"_cm();"
        + "\nvoid populate" +getCName()+"_cm(pointer classModel);"
        + "\nnum create_"+getCName()+"();"
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
        return "\n#include \"" + extendsclass.getFqn() + ".h\"";
    }

    private String getDataModelName() {
        return ("__"+getCName().replace('.', '_') +"_Data_").toUpperCase();
    }

    private String getClassStructName() {
        return 
            ("__"+getCName().replace('.', '_') +"_Class_").toUpperCase();
    }


    public void addFunction(FunctionDef functionDef) {
        functionDefs.add(functionDef);
        functionDef.classDef = this;
    }

    public void addVariable(VariableDef variableDef) {
        variableDefs.add(variableDef);
    }

    public void addProperty(VariableDef variableDef) {
        // System.out.println("@@ClassDef add " + classname.getFqn() + " " + variableDef);
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
            funct.name = getCName()+ funct.name;
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
        res += (getFqn().equals("Core.Object") ? "  \\\npointer *parent;" : "");
        for(FunctionDef funct : functionDefs) {
            if ((funct.is_override || funct.is_parent) && !getFqn().equals("Core.Object")) {
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
                res += "\n  thisClassModel->"+ funct.name +" = "+ getCName() + funct.name +";";
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

        res += "\n  thisClassModel->free = "+ getCName() +"_free;";
        return res;

    }

    private String createClassMethodsHeader() {
        return "\n" + createClassModelHeader()
            + "\ntypedef struct "+ getCName()+"_cm {"
            + "\n" + getParentClassModel()
            + getClassStructName()
            +"\n} "+ getCName()+"_cm;\n\n"
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
        + "\nnum create_"+getCName()+"() {"
        + "\n  "+getCName()+" * _"+getCName()+" = ec_calloc(sizeof("+getCName()+"), sizeof(char));"
        + populateDefaultValues()
        + "\n  return createObject(_"+getCName()+", get"+getCName()+"_cm(), false);"
        + "\n}\n"
        + "\n"+getCName()+"_cm _"+getCName()+"_cm;"
        + "\nboolean _"+getCName()+"_init = false;"
        + "\npointer get" +getCName()+"_cm() {"
        + "\n  if (!_"+getCName()+"_init) {"
        // + "\n    _"+getCName()+"_cm = ec_malloc(sizeof("+getCName()+"_cm));"
        + "\n    registerClassModel(&_"+getCName()+"_cm);"
        + "\n    populate"+getCName()+"_cm(&_"+getCName()+"_cm);"
        + "\n    _"+getCName()+"_init = true;"
        + "\n  }"
        + "\n  return &_"+getCName()+"_cm;"
        + "\n}\n"
        + "\n"+ createConstructorsCode()
        + "\nvoid populate"+getCName()+"_cm(pointer classModel) {"
        // @todo fix this
        // + "\n  populateObjectClassModel(classModel);"
        + "\n "+ getPopulateParent()
        + "\n  "+getCName()+"_cm* thisClassModel = ("+getCName()+"_cm*)classModel;"
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

            if (var.assignValue != null && var.assignValue.expr != null) {
                // "(("+name+"*)_"+getClassVar()+")->
                res += "\n/*cdv1*/(("+getCName()+"*)_"+getCName()+")->"+ var.getName() +" = "+ var.assignValue.asCode() +";";
                // TODO Arrays
            }
        }

        return res;
    }

    private String getObjectClassModel() {
        if (parent != null) {
            
            return "get"+extendsclass.getCName()+"_cm()";
        }
        return "getc_2106303_Object_cm()";
    }

    private String getPopulateParent() {
        if (extendsclass == null) return "";
        return "populate"+extendsclass.getCName()+"_cm(classModel);";
    }

    public String getContainedClassesAsCode() {
        String res = "";

        for (ClassDef classDef : fileDef.getClasses()) {
            if (classDef.classname != null && !classDef.getFqn().equals(getFqn())) {
                res += "\n#include \"" + classDef.getFqn() + ".h\""; 
            }
        } 
        return res;
    }

    public String asCode() {
        /* struct classVar {
            int value;
        }
        */
        return  "// " + getFqn()+ "\n"
            + "#include \"Core.Core_main.h\""
            + "\n#include \""+ getFqn()+ ".h\""
            + getContainedClassesAsCode()
            +"\n\n"+ functionsAsCode()
            + "\n\n" + createInitMethod();
    }

    @Override
    public String asSignature() {
        return  "// "+getFqn() + " Signature compiled"
            // + "\nnamespace "+ getNamespace()+";"
            + "\n/* imports {} */\n"
            + "\n" + acccessor
            + (is_final ? " final" : "")
            + (is_class ? " class" : " stub")
            + " signature " + getFqn()
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
            return "(" + extendsclass.getFqn() + ")";
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
        if (casttype.contains(".")) {
            extendsclass = new ClassName(casttype);
        } else {
            ClassDef cd = DefFactory.resolveClass(casttype);
            if (cd == null) {
                throw new RuntimeException("Can't resolve parent class " + casttype + " for " + classname);
            }
            extendsclass = cd.extendsclass;
        }

        if (extendsclass == null) {
            extendsclass = new ClassName("Core.Object");
        }

        parent = DefFactory.resolveClass(extendsclass.getFqn());
        if (parent == null) {
            throw new RuntimeException("Can't resolve parent class " + extendsclass + " for " + classname);
        }
    }

    public List<ConstructorDef> getConstructorDefs() {
        return constructorDefs;
    }

    public String getShortname() {
        return classname.getShortName();
    }

    public String getClassPackage() {
        return classname.getPackageName();
    }

    public String getFqn() {
        return classname.getFqn();
    }

    public String getCName() {
        return classname.getCName();
    }

    @Override
    public String toString() {
        return getFqn();
    }
}