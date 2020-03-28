package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ec.lang.defs.expressions.*;

public class DefFactory {

    public static final List<FileDef> FILE_DEFS = new ArrayList<>();
    public static final List<ClassDef> CLASS_DEFS = new ArrayList<>();
    public static final List<FunctionDef> FUNCT_DEFS = new ArrayList<>();
    public static final List<VariableDef> VAR_DEFS = new ArrayList<>();

    public static ClassDef in_class = null;
    public static Stack<FileDef> in_file = new Stack<>();
    public static FunctionDef in_funct = null;
    public static FunctionDef in_funct_def = null;
    private static FunctionDef last_in_funct_def = null;

    private static List<ExprDef> currentExprBlock = new ArrayList<>();
    private static List<StatementDef> currentStatementBlock = null;
    private static Stack<ContainerDef> currentBlock = new Stack<>();
    // public static ContainerDef containerDef = null;

    public static BlockDef mainBlock;

    public static String castType;


    static {
        // main block;
        FUNCT_DEFS.add(new FunctionDef("String", "String"));
        
    }

    public static void clear() {
        castType = null;
    }

    public static void addBlock(ContainerDef blockDef, String debug) {
        System.out.println("(==>addBlock " + debug + ") " + blockDef);

        if (currentStatementBlock != null && currentStatementBlock.size() > 0) {
            // if the las statement is a container
            StatementDef st = currentStatementBlock.get(currentStatementBlock.size()-1);
            System.out.println("(Statment) " + st.getClass() );
            if (st instanceof ContainerDef) {
                System.out.println("(is container)");
                ((ContainerDef)st).setBlockDef((BlockDef)blockDef);
            }
        } 

        currentBlock.add(blockDef);
        currentStatementBlock = blockDef.getBlockDef().statementDefs;
    }

    public static BlockDef dropBlock() {
        System.out.println("(<==dropBlock) " +currentBlock.remove(currentBlock.size() - 1));
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
        System.out.println("(newClassDef)");
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
        System.out.println("#loopover " + def.loopOver);
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
        System.out.println("newIfDef");
        IfDef def = new IfDef();
        addStatement(def);

        return def;
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


    public static AnnonymousExpr newAnnonymousExpr(String value) {
        AnnonymousExpr def = new AnnonymousExpr(value);
        addExpression(def);
        return def;
    }


    public static FunctionCallExpr newFunctionCallExpr() {
        FunctionCallExpr def = new FunctionCallExpr();
        addExpression(def);
        return def;
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

    public static TypeExpr newTypeExpr(String value) {
        TypeExpr def = new TypeExpr(value);
        addExpression(def);
        return def;
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
            System.out.println("Adding class " + in_file.peek());
            in_file.peek().addClass((ClassDef)def);
        }
    }

    public static void addExpression(ExprDef def) {
        System.out.println("**AddExpression " + def.getClass().getName() + " " + def.asCode());
        if (currentExprBlock != null) {
            currentExprBlock.add(def);
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

        addStatement(def);
        VAR_DEFS.add(def);

        return def;
    }

    public static void newAssignExpr(String assignLeft, String assignOperator) {
        AssignExpr def = new AssignExpr(assignLeft, assignOperator, dropExpression());
        addStatement(def);
    }


    /**
     * Lookup all the known classes
     * @param extends_
     * @param classDef
     * @return
     */
	public static ClassDef resolveClass(String extends_, ClassDef classDef) {

        for (ClassDef claz : CLASS_DEFS) {
            if (claz.name.equals(extends_)) {
                return claz;
            }
        }

		return null;
	}

	public static VariableDef resolveVariable(String string) {
        // fish around in the varible defs until we find a matching one
        System.out.println("@@DefFactory.resolveVariable " + string + " : " + VAR_DEFS);
        for (VariableDef variableDef : VAR_DEFS) {
            if (variableDef.getName().equals(string)) {
                return variableDef;
            }
        }

		return null;
	}

	public static ClassDef resolveClass(String name) {
        System.out.println("@@DefFactory.resolveClass " + name + " : " + CLASS_DEFS);
        for (ClassDef classDef : CLASS_DEFS) {
            if (classDef.name.equals(name)) {
                return classDef;
            }
        }
		return null;
	}
}