package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ec.lang.defs.expressions.AnnonymousExpr;
import ec.lang.defs.expressions.AssignExpr;
import ec.lang.defs.expressions.ConstExpr;
import ec.lang.defs.expressions.EndExpr;
import ec.lang.defs.expressions.FunctionCallExpr;
import ec.lang.defs.expressions.IncDecDef;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.OperationExpr;
import ec.lang.defs.expressions.ParenExpr;
import ec.lang.defs.expressions.ReturnExpr;
import ec.lang.defs.expressions.StringExpr;

public class DefFactory {

    public static final List<FileDef> FILE_DEFS = new ArrayList<>();
    public static final List<ClassDef> CLASS_DEFS = new ArrayList<>();
    public static final List<FunctionDef> FUNCT_DEFS = new ArrayList<>();
    public static final List<ConstructorDef> CONSTR_DEFS = new ArrayList<>();
    public static final List<VariableDef> VAR_DEFS = new ArrayList<>();

    public static ClassDef in_class = null;
    public static Stack<FileDef> in_file = new Stack<>();
    public static Stack<MultiTypeExpr> in_mMultiTypeExprs = new Stack<>();
    public static FunctionDefBase in_funct = null;
    public static FunctionDefBase in_funct_def = null;
    private static FunctionDefBase last_in_funct_def = null;

    public static FunctionCallExpr functionCallExpr = null;

    public static IfDef elseDef = null;

    public static List<ExprDef> currentExprBlock = new ArrayList<>();
    private static List<StatementDef> currentStatementBlock = null;
    private static Stack<ContainerDef> currentBlock = new Stack<>();

    public static BlockDef mainBlock;

    public static String castType;


    static {
        // main block;
        FUNCT_DEFS.add(new FunctionDef("String", "String"));
        FUNCT_DEFS.add(new FunctionDef("I64", "I64"));

        // CLASS_DEFS.add(new ClassDef());
    }

    public static void clear() {
        castType = null;
    }

    public static void addBlock(ContainerDef blockDef, String debug) {
        // System.out.println("(==>addBlock " + debug + ") " + blockDef);

        if (currentStatementBlock != null && currentStatementBlock.size() > 0) {
            // if the las statement is a container
            StatementDef st = currentStatementBlock.get(currentStatementBlock.size()-1);
            // System.out.println("(Statment) " + st.getClass() );
            if (st instanceof ContainerDef) {
                // System.out.println("(is container)");
                ((ContainerDef)st).setBlockDef((BlockDef)blockDef);
            }
        } 

        currentBlock.add(blockDef);
        currentStatementBlock = blockDef.getBlockDef().statementDefs;
    }

    public static BlockDef dropBlock() {
        currentBlock.remove(currentBlock.size() - 1);
        // System.out.println("(<==dropBlock) ");
        ContainerDef cont = currentBlock.get(currentBlock.size() - 1);
        BlockDef res = cont.getBlockDef();
        currentStatementBlock = res.statementDefs;
        // System.out.println("(<==dropBlock) " + currentBlock.size() + ", " + cont );
        return res;
    }

    public static void endFunctionDef() {
        last_in_funct_def = in_funct_def;
        in_funct_def = null;
        // dropBlock();
    }

    public static void startFunctImpl() {
        in_funct = last_in_funct_def;
    }

    public static ClassDef newClassDef() {
        // System.out.println("(newClassDef) ");
        ClassDef def = new ClassDef();
        CLASS_DEFS.add(def);
        addStatement(def);
        in_class = def;

        // set the block

        return def;
    }

    public static FileDef newFileDef() {
        FileDef def = new FileDef();
        FILE_DEFS.add(def);

        // need to pop at some stage
        in_file.add(def);
        def.setBlockDef(newBlockDef("file"));

        return def;
    }

    public static LoopDef newLoopDef() {
        LoopDef def = new LoopDef();
        def.loopOver = dropExpression();
        // def.loopOver = dropExpression();
        // System.out.println("#loopover " + def.loopOver);
        addStatement(def);
        // def.setBlockDef(newBlockDef("loop"));

        return def;
    }

    public static StatementDef newStatementDef(ExprDef statement) {
        StatementDef def = new StatementDef();
        def.statement = statement;
        //************************** */
        // dropExpression
        addStatement(def);
        return def;
    }

    public static StatementDef newStatementDef() {
        // System.out.println("(newStatementDef)");
        StatementDef def = new StatementDef();
        def.statement = dropExpression();
        addStatement(def);
        return def;
    }

    public static BlockDef newBlockDef(String debug) {
        BlockDef def = new BlockDef();
        addBlock(def, debug);
        return def;
    }

    public static ExprDef newExprDef() {
        ExprDef def = new ExprDef();
        addExpression(def);

        return def;
    }

    public static ReturnExpr newReturnExpr(int typ) {
        ReturnExpr def = new ReturnExpr();
        if (typ == 1) {
            def.statement = dropExpression();
            // System.out.println("return type " + def.statement.getClass() + " " + def.statement.expr + " " + currentExprBlock);
        }
        
        addStatement(def);
        return def;
    }


    public static IncDecDef newIncDecDef() {
        IncDecDef def = new IncDecDef("");
        addExpression(def);

        return def;
    }

    public static IfDef newIfDef() {
        // System.out.println("newIfDef");
        IfDef def = new IfDef();
        addStatement(def);

        return def;
    }

    public static IfDef newElseDef() {
        elseDef = new IfDef();
        addStatement(elseDef);
        return elseDef;
    }

    public static ConstExpr newConstExpr(String value) {
        ConstExpr def = new ConstExpr(value);
        addExpression(def);
        return def;
    }

    public static ConstExpr newConstExpr(String value, String type) {
        ConstExpr def = new ConstExpr(value, type);
        addExpression(def);
        return def;
    }

    public static StringExpr newStringExpr(String value) {
        StringExpr def = new StringExpr(value);
        addExpression(def);
        return def;
    }
    

    public static AnnonymousExpr newAnnonymousExpr(String value) {
        AnnonymousExpr def = new AnnonymousExpr(value);
        System.out.println("@@newAnnonymousExpr " + value);
        addExpression(def);
        return def;
    }


    public static FunctionCallExpr newFunctionCallExpr() {
        functionCallExpr = new FunctionCallExpr();

        addExpression(functionCallExpr);
        return functionCallExpr;
    }

    public static ParenExpr newParenExpr() {
        ParenExpr def = new ParenExpr();
        def.enclosed = dropExpression();
        addExpression(def);
        return def;
    }

    public static OperationExpr newOperationExpr() {
        OperationExpr def = new OperationExpr();
        def.left = dropExpression();
        addExpression(def);
        return def;
    }

    static MultiTypeExpr multiTypeExpr = null;
    public static MultiTypeExpr newMultiTypeExpr() {
        if (multiTypeExpr == null) { 
            multiTypeExpr = new MultiTypeExpr();
            in_mMultiTypeExprs.push(multiTypeExpr);
        }
        
        return multiTypeExpr;
    }

    public static EndExpr newEndExpr() {
        // System.out.println("(EndExpr)");
        EndExpr def = new EndExpr();
        addExpression(def);

        return def;
    }

    static void addStatement(StatementDef def) {
        currentStatementBlock.add(def);

        if (def instanceof ClassDef) {
            // System.out.println("Adding class " + in_file.peek());
            in_file.peek().addClass((ClassDef)def);
            ((ClassDef)def).fileDef = in_file.peek();
        }
    }

    static int lastMt = 0;

    public static void addExpression(ExprDef def) {
        if (def instanceof FunctionCallExpr) {
            return;
        }

        if (def instanceof MultiTypeExpr) {
            int sig = def.hashCode();
            lastMt = sig;
        }


        if (currentExprBlock.size() > 0 && currentExprBlock.get(currentExprBlock.size() -1) == def) {
            throw new RuntimeException("What are you doing, why are you adding the same expr twice? " + def);
        }

        if (currentExprBlock != null) {
            currentExprBlock.add(def);
        }
    }

    public static void addExpression(ExprDef def, String line) {
        if (def instanceof MultiTypeExpr) {
            endMultiTypeExpr();
        }

        if (def instanceof MultiTypeExpr) {
            int sig = def.hashCode();
            if (sig == lastMt) {
                lastMt = sig;
                return;
            } 
            lastMt = sig;
        }

        def.setLine(line);
        if (currentExprBlock != null) {
            currentExprBlock.add(def);
        }
    }

    public static MultiTypeExpr endMultiTypeExpr() {
        // System.out.println("**endMultiTypeExpr " + multiTypeExpr + " " + in_mMultiTypeExprs.size());
        if (in_mMultiTypeExprs.size() == 0) {
            multiTypeExpr = null;
        } else {
            multiTypeExpr = in_mMultiTypeExprs.pop();
        }
        // return  multiTypeExpr == null ? newMultiTypeExpr() : multiTypeExpr;
        return newMultiTypeExpr();
    }


    public static void addNot(String hasnot) {
        if (hasnot == null || !hasnot.equals("!")) { 
            return;
        }

        if (currentExprBlock != null && currentExprBlock.size() > 0) {
             currentExprBlock.get(currentExprBlock.size() -1).hasNot = "!";
        }
    }


    public static ExprDef dropExpression() {
        if (currentExprBlock != null && currentExprBlock.size() > 0) {
            ExprDef res = currentExprBlock.remove(currentExprBlock.size() -1);

            // System.out.println("@@dropExpression " + res.getClass() + " " + res.expr);

            if (res instanceof MultiTypeExpr) {
                endMultiTypeExpr();
            }
            return res;
        }

        return null;
    }

    public static void endClassBlock() {
        in_class = null;
        dropBlock();
    }


    public static FunctionDef newFunctDef() {
        FunctionDef def = new FunctionDef();
        FUNCT_DEFS.add(def);
        in_funct_def = def;

        addStatement(def);

        return def;
    }

    public static ConstructorDef newConstructorDef() {
        ConstructorDef def = new ConstructorDef();

        CONSTR_DEFS.add(def);
        // FUNCT_DEFS.add(def);
        in_funct_def = def;

        addStatement(def);

        return def;
    }


    public static VariableDef newParamDef() {
        VariableDef def = new VariableDef();

        // addStatement(def);
        // VAR_DEFS.add(def);
        in_funct_def.parameters.add(def);

        return def;
    }

    public static VariableDef newVarDef() {
        VariableDef def = new VariableDef();

        // System.out.println("##Factory add var def " + def);

        addStatement(def);
        VAR_DEFS.add(def);

        return def;
    }

    public static void newAssignExpr(String assignOperator) {
        // System.out.println("@@newAssignExpr");
        ExprDef right = dropExpression();
        ExprDef left = dropExpression();

        if (left instanceof FunctionCallExpr) {
            left = dropExpression();
        }

        AssignExpr def = new AssignExpr(left, assignOperator, right);
        addStatement(def);
    }


    // public static void newAssignExpr(String assignLeft, String assignOperator) {
    //     AssignExpr def = new AssignExpr(assignLeft, assignOperator, dropExpression());
    //     addStatement(def);
    // }

    // array
    public static void newAssignExpr(String assignLeft, String indexValue, String assignOperator) {
        AssignExpr def = new AssignExpr(assignLeft, indexValue, assignOperator, dropExpression());
        addStatement(def);
    }

    /**
     * Lookup all the known classes
     * @param extends_
     * @param classDef
     * @return
     */
	// public static ClassDef resolveClass(String extends_, ClassDef classDef) {

    //     for (ClassDef claz : CLASS_DEFS) {
    //         if (claz.getFqn().equals(extends_)) {
    //             return claz;
    //         }
    //     }

	// 	return null;
	// }

	public static VariableDef resolveVariable(String string) {
        // fish around in the varible defs until we find a matching one
        // System.out.println("@@DefFactory.resolveVariable " + string + " : " + VAR_DEFS);
        for (VariableDef variableDef : VAR_DEFS) {
            if (variableDef.getName().equals(string)) {
                return variableDef;
            }
        }

		return null;
	}

    public static ClassDef resolveClass(TypeIdDef typeIdDef) {
        if (typeIdDef.isIs_array()) {
            return resolveClass("Core.Array");
        }
        return resolveClass(typeIdDef.getName());
    }

	public static ClassDef resolveClass(String name) {
        // if (!name.contains(".")) {
        //     System.out.println("[warn] resolveClass by shortname " + name);
        // }

        for (ClassDef classDef : CLASS_DEFS) {
            if (classDef.getShortname().equals(name)) {
                return classDef;
            }
        }

        for (ClassDef classDef : CLASS_DEFS) {
            if (classDef.getFqn().equals(name)) {
                return classDef;
            }
        }

        for (ClassDef classDef : CLASS_DEFS) {
            if (classDef.getCName().equals(name)) {
                return classDef;
            }
        }

        // System.out.println("[warn] can't resolveClass by shortname " + name + " : " + CLASS_DEFS) ;
        // throw new RuntimeException("[warn] can't resolveClass by shortname " + name);

		return null;
    }
    
	public static VariableDef resolveProperty(VariableDef classvar, String name) {
        if (classvar == null) {
            return null;
        }

        ClassDef cd = resolveClass(classvar.type.getName());

        if (cd != null) {
            return cd.resolveProperty(name);
        }
        return null;
	}

	public static FunctionDef resolveFunction(VariableDef classvar, String name) {
        if (classvar == null) {
            return null;
        }

        return resolveFunction(classvar.type, name);
        // ClassDef cd = resolveClass(classvar.type.getName());

        // if (cd != null) {
        //     return cd.resolveFunction(name);
        // }
        // return null;
	}

    public static FunctionDef resolveFunction(TypeIdDef typeIdDef, String name) {
        if (typeIdDef == null) {
            return null;
        }

        ClassDef cd = resolveClass(typeIdDef.getName());

        if (cd != null) {
            return cd.resolveFunction(name);
        }
        return null;
	}

}