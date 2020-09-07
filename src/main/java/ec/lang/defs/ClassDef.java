package ec.lang.defs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.FunctionCallExpr;

public class ClassDef extends StatementDef implements ContainerDef, Castable {

    private ClassName classname;
    private ClassName extendsclass;
    // private ExprDef purename;
    public Enums.Accessor acccessor = Accessor.PUBLIC;
    public Enums.ClassType classType;
    public boolean is_final;
    public boolean is_signature = false;
    public String namespace;
    public  List<VariableDef> variableDefs = new ArrayList<>();
    private List<FunctionDef> functionDefs = new ArrayList<>();
    private List<EncapsulationDef> encapsulationDefs = new ArrayList<>();
    private List<String> implementations = new ArrayList<>();
    private List<ConstructorDef> constructorDefs = new ArrayList<>();
    private List<String> generics = new ArrayList<>();
    

    public List<FunctionDef> getFunctionDefs() {
        return Collections.unmodifiableList(functionDefs);
    } 

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
    private boolean is_stub = false; // should be mutually exclusive with isClass

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
                // System.out.println("@@resolveProperty " + name);
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

        if (fd.getParameters().size() == 1 && !isVoid && !fd.is_static) {
            return fd;
        }

        if (fd.getParameters().size() == 0 && !isVoid && fd.is_static) {
            return fd;
        }

        if (fd.getParameters().size() == 2 && isVoid && !fd.is_static) {
            return fd;
        }

        if (fd.getParameters().size() == 1 && isVoid && fd.is_static) {
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


    public ConstructorDef resolveConstructor(FunctionCallExpr functionCallExpr) {
        for (ConstructorDef cd : constructorDefs) {
            if (cd.isCallable(null, functionCallExpr.params)) {
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

        // System.out.println("@@resolveclass " + this);
        if (extendsclass == null && !getFqn().equals("Core.Object") ) {
            setCastType("Core.Object");
        } 
        
        blockDef.isClass = true;

        if (blockDef == null) {
            return;
        }

        DefFactory.FUNCT_DEFS.add(new FunctionDef(classname.getShortName(), "create_" + getCName()));

        for (StatementDef statementDef : blockDef.statementDefs) {

            // System.out.println(this + " " +  statementDef.getClass());

            if (statementDef instanceof FunctionDef) {
                FunctionDef fd = (FunctionDef) statementDef;
                if (parent != null && parent.resolveFunction(fd.name) != null) {
                    fd.is_override = true;
                }
                functionDefs.add(fd);
                fd.classDef = this;

                // if (((FunctionDefBase)statementDef).getBlockDef() != null) {
                //     ((FunctionDefBase)statementDef).getBlockDef().isClass = true;
                //     ((FunctionDefBase)statementDef).getBlockDef().classDef = this;
                //     statementDef.containedInBlock = blockDef;
                //     System.out.println("@@class " + fd.name + " " + fd.getBlockDef().classDef);
                // }

            }

            if (statementDef instanceof EncapsulationDef) {
                encapsulationDefs.add((EncapsulationDef) statementDef);
                ((EncapsulationDef) statementDef).classDef = this;
            }

            if (statementDef instanceof ConstructorDef) {
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

        FunctionDef funct = SnippetFactory.addReturnFunction("className", "\""+getFqn()+"\"", new TypeIdDef("pointer"), true, true, true);
        funct.is_builtin = true;
        funct.classDef = this; functionDefs.add(funct);
        funct = SnippetFactory.addReturnFunction("classShortName", "\""+getShortname()+"\"", new TypeIdDef("pointer"), true, true, true);
        funct.is_builtin = true;
        funct.classDef = this; functionDefs.add(funct);
        funct = SnippetFactory.addReturnFunction("classCName", "\""+getCName()+"\"", new TypeIdDef("pointer"), true, true, true);
        funct.is_builtin = true;
        funct.classDef = this; functionDefs.add(funct);
        funct = SnippetFactory.addReturnFunction("classPackage", "\""+classname.getPackageName()+"\"", new TypeIdDef("pointer"), true, true, true);
        funct.is_builtin = true;
        funct.classDef = this; functionDefs.add(funct);
        funct = SnippetFactory.addReturnFunction("objectDatasize", "sizeof("+getCName()+")", new TypeIdDef("u64"), true, true, true);
        funct.is_builtin = true;
        funct.classDef = this; functionDefs.add(funct);

        // add all parent constructors
        // we assume that resolve is already run on the parent so it will already have
        // resolved all the constructors
        if (parent != null) {
            properties.addAll(parent.properties);
            // constructorDefs.addAll(parent.constructorDefs);

            for (ConstructorDef c : parent.constructorDefs) {
                try {
                    boolean exists = false;

                    for (ConstructorDef tc : constructorDefs) {
                        if (tc.isCallableVar(null, c.getParameters())) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        ConstructorDef nc = (ConstructorDef) c.clone();
                        nc.name = classname.getShortName();
                        nc.classDef = this;
                        nc.resolve_01();
    
                        constructorDefs.add(nc);
                    }
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }

            for (FunctionDef c : parent.functionDefs) {
                if (c.is_property) {
                    continue;
                }
                try {
                    boolean exists = false;
                    
                    for (FunctionDef tc : functionDefs) {
                        // if (tc.name.equals(nc.name)) {
                        if (tc.name.equals(c.name)) {
                            exists = true;

                            if (c.name.equals("release")) {
                                tc.accessor = Accessor.HIDDEN;
                            }
            
                            break;
                        }
                    }
                    if (!exists) {
                        FunctionDef nc = (FunctionDef) c.clone();
                        nc.classDef = this;
                        nc.containedInBlock = blockDef;
                        if (nc.getParameters().size() > 0) {
                            // why is this being removed? - because its the parent, and the object type is 
                            // for the parent, we want this object type
                            if (nc.getParameters().get(0).getName().equals("this") || nc.getParameters().get(0).getName().equals("_refId")) {
                                nc.getParameters().remove(0);
                            }
                        }
                        functionDefs.add(nc);
                        // nc.resolve_01();
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

            if (statementDef instanceof FunctionDef || statementDef instanceof EncapsulationDef) {
                if (((FunctionDefBase)statementDef).getBlockDef() != null) {
                    ((FunctionDefBase)statementDef).getBlockDef().isClass = true;
                    ((FunctionDefBase)statementDef).getBlockDef().classDef = this;
                    statementDef.containedInBlock = blockDef;
                }
            }

            if (statementDef.containedInBlock == null) {
                blockDef.classDef = this;
                statementDef.containedInBlock = blockDef;
            }

            statementDef.resolve_01();
        }

        for (FunctionDef fd : functionDefs) {
            if (!fd.isResolved()) {
                fd.resolve_01();
            }
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


        // mark override accessors as parent so they don't get created

        // generate the properties functions

        boolean optimise = true;
        for(VariableDef var : properties) {
            if (isParentProperty(var)) {
                continue;
            }

            EncapsulationDef overrideSetter = null;
            EncapsulationDef overrideGetter = null;
            EncapsulationDef hasOnChange = null;
            EncapsulationDef hasOnGet = null;
            for (EncapsulationDef encapsulationDef : encapsulationDefs) {
                if (encapsulationDef.getPropertyName().equals(var.getName())) {
                    if (encapsulationDef.hasGetter()) {
                        overrideGetter = encapsulationDef;
                    } else if (encapsulationDef.hasSetter()) {
                        overrideSetter = encapsulationDef;
                    } else if (encapsulationDef.isOnChange()) {
                        hasOnChange = encapsulationDef;
                    } else if (encapsulationDef.isOnGet()) {
                        hasOnGet = encapsulationDef;
                    }
                }
            }

            variableDefs.add(var);

            String body ="";
            String dataAccess = "";

            if (overrideGetter != null) {
                // overrideGetter.containedInBlock = funct.getBlockDef();
                overrideGetter.resolve_01();
                overrideGetter.prepare_03();
                overrideGetter.optimise_04();
            } else {
                dataAccess = SnippetFactory.dataModelStatement(getCName(), "this", var.is_static);
                body = dataAccess + "->"+var.getName();
            }

            FunctionDef funct = SnippetFactory.addReturnFunction("get_" + var.getName(), 
            body, 
            var.type, false, var.is_static, true
            );

            funct.classDef = this;
            if (overrideGetter != null) {
                funct.setBlockDef(overrideGetter.getBlockDef());
            } else {
                if (optimise) {
                    funct.getBlockDef().includeEntryExit = false;
                }
            }

            functionDefs.add(funct);


            funct.accessor = var.readAccessor;
            funct.is_property = true;
            // private FunctionDef addVoidFunction(String functionName, String body,  
            // boolean isOverride, boolean is_static, boolean is_final) {

            dataAccess = SnippetFactory.dataModelStatement(getCName(), "this", var.is_static);
            if (var.isPrimative()) {
                body = "/*cda1*/"+ dataAccess +"->"+var.getName() + " = a__a";
            } else {
                body = "/*cda2*/ assignObject(&"+dataAccess+"/*cda3*/->"+var.getName()+", a__a)";
            }
        
            FunctionDef setter = SnippetFactory.addVoidFunction("set_" + var.getName(), body, false, var.is_static, true);
            functionDefs.add(setter);

            if (overrideSetter != null) {
                overrideSetter.containedInBlock = funct.getBlockDef();
                overrideSetter.resolve_01();
                overrideSetter.prepare_03();
                overrideSetter.optimise_04();
                // overrideSetter.getBlockDef().statementDefs.add(0, new DirectStatement(body + ";\n"));
                setter.setBlockDef(overrideSetter.getBlockDef());
            }

            if (hasOnChange != null) {
                hasOnChange.containedInBlock = funct.getBlockDef();
                hasOnChange.resolve_01();
                hasOnChange.prepare_03();
                hasOnChange.optimise_04();
                setter.getBlockDef().statementDefs.add(0, hasOnChange.getBlockDef());
            }

            VariableDef param = new VariableDef();
            // param.setName("$a");
            param.type = var.type;

            setter.classDef = this;
            setter.addParameter(param);
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
        return super.validate_02();
    }

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

        // for(EncapsulationDef funct : encapsulationDefs) {
        //     if (!first) {
        //         res += "\n";
        //     }
        //     String n = funct.name;
        //     funct.name = getCName()+ funct.getFunctioname();
        //     res += funct.asCode();
        //     funct.name = n;
        //     first = false;
        // }


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

        // for(EncapsulationDef funct : encapsulationDefs) {
        //     res += "  \\\n  "+funct.getExpandedSignature() +";";
        // }

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

        // for(EncapsulationDeffor(EncapsulationDef funct : encapsulationDefs) {
        //     res += "\n  thisClassModel->"+ funct.name +" = "+ getCName() + funct.name +";";
        // }

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
        + "\n  num this = createObject(_"+getCName()+", get"+getCName()+"_cm(), false);"
        + populateDefaultValues()
        // + "\n  return createObject(_"+getCName()+", get"+getCName()+"_cm(), false);"
        + "\n  return this;"
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
        + (getFqn().equals("Core.Object") ?  "\n  thisClassModel->parent = null;" :  "\n  thisClassModel->parent = "+getObjectClassModel()+";")
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

                if (var.assignValue.expr != null) {
                    // "(("+name+"*)_"+getClassVar()+")->
                    res += "\n/*cdv1*/(("+getCName()+"*)_"+getCName()+")->"+ var.getName() +" = "+ var.assignValue.asCode() +";";
                    // TODO Arrays
                } else {
                    // call setter
                    String dataAccess = SnippetFactory.dataModelStatement(getCName(), "this", var.is_static);
                    if (var.isPrimative()) {
                        res += "/*pr1*/"+ dataAccess +"->"+var.getName() + " = "+ var.assignValue.asCode() + ";";
                    } else {
                        res += "/*pr2*/ assignObject(&"+dataAccess+"->"+var.getName()+", "+ var.assignValue.asCode()+");";
                    }                    
                    // res += "\n/*cdv1*/(("+getCName()+"*)_"+getCName()+")->"+ var.getName() +" = "+ var.assignValue.asCode() +";";
                }
            }
        }

        //(c_2106303_I64*)_c_2106303_I64->instanceName = c_2106303_I64className();
        res += "\n/*cdv1*/(("+getCName()+"*)_"+getCName()+")->instanceName = "+ getCName() +"className();";

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

    @Override
    public String asDoc() {
        String res = "class " + getFqn() 
        + (parent == null ? "" : " extends [" +  parent.getFqn()+ "]("+  parent.getFqn()+ ".md)" ) 
        + "\n===\n"
        + super.asDoc(); 

        int vars = 0;
        for (VariableDef var : properties ) {
            if (!var.is_static) {
                vars++;
            }
        }

        if (vars > 0) {
            res += "\n---\nProperties\n---\n"
            + "|type|name|read|write|value|comments|\n|--- |--- |--- |--- |--- |--- |\n";

            for (VariableDef var : properties ) {
                if (!var.is_static) {
                    res += var.asDoc();
                }
            }
        }

        vars = 0;
        for (VariableDef var : properties ) {
            if (var.is_static) {
                vars++;
            }
        }

        if (vars > 0) {
            res += "\n---\nStatic Properties\n---\n"
            + "|type|name|read|write|value|comments|\n|--- |--- |--- |--- |--- |--- |\n";

            for (VariableDef var : properties ) {
                if (var.is_static) {
                    res += var.asDoc();
                }
            }
        }


        res += "\n---\nConstructors\n---\n";

        for (ConstructorDef con : constructorDefs) {
            res += con.asDoc();
        }
        
        res += "\n---\nFunctions\n---\n";

        for (FunctionDefBase func : functionDefs) {
            if (func instanceof FunctionDef) {
                FunctionDef fn = (FunctionDef) func;
                if (!(fn.is_property || fn.is_parent || fn.is_builtin)) {
                    res += func.asDoc();
                }
            } else {
                res += func.asDoc();
            }
        }

        return res;
    }
}