package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class TryCatchDef extends StatementDef implements ContainerDef {
    public int stage = 0;
    private BlockDef blockDef = new BlockDef();

    public abstract class ExceptionBlock extends StatementDef implements ContainerDef {
        private BlockDef blockDef = new BlockDef();

        @Override
        public List<VariableDef> getVariableDefs() {
            return getBlockDef().getVariableDefs();
        }

        @Override
        public BlockDef getBlockDef() {
            return blockDef;
        }

        @Override
        public void setBlockDef(BlockDef blockDef) {
            this.blockDef = blockDef;
        }

        @Override
        public void resolve_01() {
            super.resolve_01();
            getBlockDef().resolve_01();
        }

        @Override
        public boolean validate_02() {
            if (!super.validate_02()) {
                return false;
            }
            return getBlockDef().validate_02();
        }

        @Override
        public void prepare_03() {
            super.prepare_03();
            getBlockDef().prepare_03();
        }

        @Override
        public String asCode() {
            return getBlockDef().asCode();
        }
    }

    public class FinallyBlock extends ExceptionBlock {
    }

    public class TryBlock extends ExceptionBlock {
    }


    public class CatchBlock extends ExceptionBlock {
        List<String> expns = new ArrayList<>();

        public void addException(String exptn) {
            expns.add(exptn);
        }

        @Override
        public void resolve_01() {
            // for (String ex : expns) {
            VariableDef v = getBlockDef().addAnnoymous(new TypeIdDef("Exception"));    
            v.assignValue = new ExprDef("getException();");
            getBlockDef().statementDefs.add(0, v);

            for (String expn : expns) {
                ClassDef classDef = DefFactory.resolveClass(expn);

                if (classDef == null) {
                    throw new RuntimeException("Exception class not found " + expn);
                }
            }
            
            super.resolve_01();
        }

        @Override
        public String asCode() {

            // Instance of checks
            String res = "";

            for (String expn : expns) {
                // if (setjmp(*newCatchException("c_2106303_Exception"))) {
                if (res.length() > 0) {
                    res += " else ";
                }

                ClassDef classDef = DefFactory.resolveClass(expn);

                res += "if (setjmp(*newCatchException(\""+ classDef.getCName() +"\"))) ";
                // @TODO extract into a function block
                res += super.asCode();
            }

            return res;
        }
    }

    private List<CatchBlock> catchBlocks = new ArrayList<>();
    private TryBlock tryBlock;
    private FinallyBlock finallyBlock;

    @Override
    public List<VariableDef> getVariableDefs() {
        return tryBlock.getBlockDef().getVariableDefs();
    }

    @Override
    public BlockDef getBlockDef() {
        return blockDef;
    }

    @Override
    public void setBlockDef(BlockDef blockDef) {
        // if (stage == 0) {

        // } else if () {

        // } else {

        // }
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
        blockDef.containedInBlock = containedInBlock;
        blockDef.resolve_01();

        tryBlock.containedInBlock = containedInBlock;
        tryBlock.resolve_01();

        for (CatchBlock catchBlock : catchBlocks) {
            catchBlock.containedInBlock = containedInBlock;
            catchBlock.resolve_01();
        }

        if (finallyBlock != null) {
            finallyBlock.containedInBlock = containedInBlock;
            finallyBlock.resolve_01();
        }
    }

    @Override
    public boolean validate_02() {
        blockDef.validate_02();
        tryBlock.validate_02();

        for (CatchBlock catchBlock : catchBlocks) {
            catchBlock.validate_02();
        }

        if (finallyBlock != null) {
            finallyBlock.validate_02();
        }
        // TODO
        return true;
    }
    
    @Override
    public void prepare_03() {
        tryBlock.prepare_03();
        tryBlock.prepare_03();

        for (CatchBlock catchBlock : catchBlocks) {
            catchBlock.prepare_03();
        }

        if (finallyBlock != null) {
            finallyBlock.prepare_03();
        }
    }

    public CatchBlock addCatch() {
        CatchBlock catchBlock = new CatchBlock();
        catchBlocks.add(catchBlock);

        return catchBlock;
    }

    public TryBlock addTry() {
        tryBlock = new TryBlock();
        // tryBlock.setBlockDef(blockDef);
        return tryBlock;
    }

    public FinallyBlock addFinally() {
        finallyBlock = new FinallyBlock();
        // finallyBlock.setBlockDef(blockDef);
        return finallyBlock;
    }

    @Override
    public String asCode() {

        // push to exception stack
        // run code
        // pop from exception stack 
        // on exception clean up statck

        int unq = getBlockDef().getNextinternalUnique();
        String res = "i64 __exceptionIndex"+unq+" = getExceptionIndex();"; // blockDef.asCode();


        for (CatchBlock catchBlock : catchBlocks) {
            res += "/*cb1*/";
            res += catchBlock.asCode();
            res += " else ";
        }

        res += "/*tb1*/";
        res += tryBlock.asCode();


        // @TODo this won't get called when there is an exception which is not caught by this block
        if (finallyBlock != null) {
            res += "/*fb1*/";
            res += finallyBlock.asCode();
        }

        res += "cleanExceptionIndex(__exceptionIndex"+unq+");";

        return res;
    }
}