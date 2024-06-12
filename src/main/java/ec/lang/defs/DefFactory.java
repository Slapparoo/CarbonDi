package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ec.lang.defs.TryCatchDef.CatchBlock;
import ec.lang.defs.TryCatchDef.FinallyBlock;
import ec.lang.defs.TryCatchDef.TryBlock;
import ec.lang.defs.expressions.AnonymousExpr;
import ec.lang.defs.expressions.ArrayIndexExpr;
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
import ec.lang.defs.expressions.TypeExpr;

public class DefFactory {

    public static final List<FileDef> FILE_DEFS = new ArrayList<>();
    public static final List<ClassDef> CLASS_DEFS = new ArrayList<>();
    public static final List<FunctionDefBase> FUNCT_DEFS = new ArrayList<>();
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
    public static List<StatementDef> currentStatementBlock = null;
    public static Stack<ContainerDef> currentBlock = new Stack<>();
    private static Stack<TryCatchDef> currentTryCatch = new Stack<>();
    public static String castType;
    static int lastMt = 0;
    static MultiTypeExpr multiTypeExpr = null;
    private static SwitchDef switchDef;


    public static void clear() {
        castType = null;
    }

    public static <T extends ContainerDef> T addBlock(T blockDef, String debug) {
        if (currentStatementBlock != null && currentStatementBlock.size() > 0) {
            StatementDef st = currentStatementBlock.get(currentStatementBlock.size()-1);
            if (st instanceof ContainerDef) {
                if (blockDef instanceof BlockDef) {
                    ((ContainerDef)st).setBlockDef((BlockDef)blockDef);
                } else {
                    ((ContainerDef)st).setBlockDef(blockDef.getBlockDef());
                }
            }
        } 

        currentBlock.add(blockDef);
        currentStatementBlock = blockDef.getBlockDef().statementDefs;
        return blockDef;
    }

    public static BlockDef getCurrentBlock() {
        return currentBlock.peek().getBlockDef();
    }

    public static BlockDef dropBlock() {
        currentBlock.remove(currentBlock.size() - 1);
        ContainerDef cont = currentBlock.get(currentBlock.size() - 1);
        BlockDef res = cont.getBlockDef();
        currentStatementBlock = res.statementDefs;
        return res;
    }

    public static void endFunctionDef() {
        last_in_funct_def = in_funct_def;
        in_funct_def = null;
    }

    public static void startFunctImpl() {
        in_funct = last_in_funct_def;
    }

    public static ClassDef newClassDef() {
        ClassDef def = new ClassDef();
        CLASS_DEFS.add(def);
        addStatement(def);
        in_class = def;
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

        return addStatement(def);
    }

    public static StatementDef newStatementDef(ExprDef statement) {
        StatementDef def = new StatementDef();
        def.statement = statement;
        return addStatement(def);
    }

    public static StatementDef newStatementDef() {
        StatementDef def = new StatementDef();
        def.statement = dropExpression();
        return addStatement(def);
    }

    public static BlockDef newBlockDef(String debug) {
        return addBlock(new BlockDef(), debug);
    }

    public static ExprDef newExprDef() {
        return addExpression(new ExprDef());
    }

    public static ExprDef newExprDef(String expr) {
        return addExpression(new ExprDef(expr));
    }

    public static ReturnExpr newReturnExpr(int typ) {
        ReturnExpr def = new ReturnExpr();
        if (typ == 1) {
            def.statement = dropExpression();
        }
        return addStatement(def);
    }

    public static IncDecDef newIncDecDef() {
        return addExpression(new IncDecDef(""));
    }

    public static IfDef newIfDef() {
        return addStatement(new IfDef());
    }

    public static IfDef newElseDef() {
        elseDef = new IfDef();
        return addStatement(elseDef);
    }

    public static ConstExpr newConstExpr(String value) {
        return addExpression(new ConstExpr(value));
    }

    public static ConstExpr newConstExpr(String value, String type) {
        return addExpression(new ConstExpr(value, type));
    }

    public static StringExpr newStringExpr(String value) {
        return addExpression(new StringExpr(value));
    }

    public static AnonymousExpr newAnnonymousExpr(String value) {
        return addExpression(new AnonymousExpr(value));
    }

    public static FunctionCallExpr newFunctionCallExpr() {
        return new FunctionCallExpr();
    }

    public static ParenExpr newParenExpr() {
        return addExpression(new ParenExpr(dropExpression()));
    }

    public static OperationExpr newOperationExpr() {
        OperationExpr def = new OperationExpr();
        def.left = dropExpression();
        addExpression(def);
        return def;
    }

    public static void newMultiTypeExpr(String type) {
        multiTypeExpr = new MultiTypeExpr();
        multiTypeExpr.g4Type = type;
        in_mMultiTypeExprs.push(multiTypeExpr);
        addExpression(multiTypeExpr);
    }

    public static void addCaseStatement() {
        CaseStatement def = new CaseStatement();
        ExprDef exprDef = dropExpression();

        def.setExprDef(exprDef);
        switchDef.addCaseStatement(def);
        addBlock(def, "switch");
    }

    public static void endCaseStatement() {
        dropBlock();
    }

    public static EndExpr newEndExpr() {
        return addExpression(new EndExpr());
    }

    static <T extends StatementDef> T addStatement(T def) {
        currentStatementBlock.add(def);

        if (def instanceof ClassDef) {
            in_file.peek().addClass((ClassDef)def);
            ((ClassDef)def).fileDef = in_file.peek();
        }
        return def;
    }

    public static <T extends ExprDef> T addExpression(T def) {
        if (currentExprBlock.size() > 0 && currentExprBlock.get(currentExprBlock.size() -1) == def) {
            throw new RuntimeException("What are you doing, why are you adding the same expr twice? " + def);
        }

        if (currentExprBlock != null) {
            currentExprBlock.add(def);
        }
        return def;
    }

    public static void addExpression(ExprDef def, String line) {
        def.setLine(line);
        if (currentExprBlock != null) {
            currentExprBlock.add(def);
        }
    }

    public static void endMultiTypeExpr() {
        if (in_mMultiTypeExprs.size() == 0) {
            multiTypeExpr = null;
        } else {
            in_mMultiTypeExprs.pop();

            if (in_mMultiTypeExprs.size() > 0) {
                multiTypeExpr = in_mMultiTypeExprs.peek();
            } else {
                multiTypeExpr = null;
            }
        }
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
            return currentExprBlock.remove(currentExprBlock.size() -1);
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

        return addStatement(def);
    }

    public static ConstructorDef newConstructorDef() {
        ConstructorDef def = new ConstructorDef();

        CONSTR_DEFS.add(def);
        in_funct_def = def;

        return addStatement(def);
    }

    public static EncapsulationDef newEncapsulationDef() {
        EncapsulationDef def = new EncapsulationDef();

        FUNCT_DEFS.add(def);
        in_funct_def = def;

        return addStatement(def);
    }

    public static VariableDef newParamDef() {
        VariableDef def = new VariableDef();
        in_funct_def.addParameter(def);
        return def;
    }

    public static VariableDef newVarDef() {
        VariableDef def = new VariableDef();
        VAR_DEFS.add(def);

        return addStatement(def);
    }

    public static void addExpr(TypeExpr exprDef, String linenumber) {
        if (exprDef instanceof ArrayIndexExpr) {
            ExprDef ix = ((ArrayIndexExpr)exprDef).arrayIndex ;
            if (ix instanceof MultiTypeExpr) {
                endMultiTypeExpr();
                newMultiTypeExpr("ArrayIndex");
            }
        }

        multiTypeExpr.addExpr(exprDef, linenumber);
    }

    public static void addExpr(ExprDef exprDef, String linenumber) {
        multiTypeExpr.addExpr(exprDef, linenumber);
    }

    public static AssignExpr newAssignExpr(String assignOperator) {
        ExprDef right = dropExpression();
        ExprDef left = dropExpression();

        if (left instanceof FunctionCallExpr) {
            left = dropExpression();
        }

        AssignExpr def = new AssignExpr(left, assignOperator, right);
        addStatement(def);
        return def;
    }

    public static SwitchDef newSwitchStatement() {
        ExprDef expr = dropExpression();

        if (expr instanceof FunctionCallExpr) {
            expr = dropExpression();
        }

        switchDef = new SwitchDef(expr);
        addStatement(switchDef);

        return switchDef;
    }

    // array
    public static void newAssignExpr(String assignLeft, String indexValue, String assignOperator) {
        addStatement(new AssignExpr(assignLeft, indexValue, assignOperator, dropExpression()));
    }

    public static void newFinallyDef() {
        addBlock(currentTryCatch.peek().addFinally(), "finally");
    }

    public static void newTryBlockDef() {
        addBlock(currentTryCatch.peek().addTry(), "try");
    }

    public static CatchBlock newCatchDef() {
        return addBlock(currentTryCatch.peek().addCatch(), "catch");
    }

    public static TryCatchDef newTryCatchDef() {
        TryCatchDef tryCatchDef = new TryCatchDef();
        addStatement(tryCatchDef);
        addBlock(tryCatchDef, "trycatch");
        currentTryCatch.push(tryCatchDef);

        return tryCatchDef;
    }

    public static void endTryCatch() {
        currentTryCatch.pop();
        dropBlock();
    }

	public static VariableDef resolveVariable(String string) {
        // fish around in the varible defs until we find a matching one
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
    
    public static FunctionDefBase resolveFunction(String name) {
        for (FunctionDefBase fd : FUNCT_DEFS) {
            if (fd.classDef == null) {
                if (fd.name.equals(name)) {
                    return fd;
                }
            }
        }

        return null;
    }
}