package ec.lang;

import java.io.File;
import java.io.FileOutputStream;

import ec.lang.defs.ClassDef;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.Block_statementContext;
import ec.lang.model.ecParser.ExprContext;
import ec.lang.model.ecParser.Extended_exprContext;
import ec.lang.model.ecParser.ProgramContext;
import ec.lang.model.ecParser.Variable_definitionContext;

public class CWalker extends ecBaseListener {

    String dirname;
    String filename;    

    public CWalker(final String filename, final String dirname) {
        this.dirname = dirname;
        this.filename = filename;
    }

    @Override
    public void exitExpr(ExprContext ctx) {
        // if (ctx.xd == null) {
        //     System.out.println(ctx.start.getLine() + " (UndefinedExpr)");
        // } else {
        //     System.out.println(ctx.start.getLine() + " (exitExpr) " +ctx.xd.asCode());
        // }
        super.exitExpr(ctx);
    }

    @Override
    public void exitVariable_definition(Variable_definitionContext ctx) {
        // if (ctx.vd != null) {
        //     System.out.println(ctx.start.getLine() +  " (exitVariable_definition) " +ctx.vd.asCode());
        // }
        super.exitVariable_definition(ctx);
    }


    @Override
    public void exitProgram(ProgramContext ctx) {
        // TODO Auto-generated method stub

        // ctx.
        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);

        ctx.ff.name = fName;
        ctx.ff.filename = ""+(ctx.ff.namespace == null ? "Default" : ctx.ff.namespace) + "." + fName+ "_main";
        // ctx.ff.filename = fName+ "_main";

        String ffilename = dirname +"/"+ ctx.ff.filename;
        System.out.println("Filename: " + ffilename);
        
        ctx.ff.resolve_01();
        ctx.ff.validate_02();
        ctx.ff.prepare_03();

        // ctx.ff.prepare_03();

        try (FileOutputStream out = new FileOutputStream(ffilename + ".h")) {
            String header = ctx.ff.asHeader();

            out.write(header.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(ffilename + ".c")) {
            String code = ctx.ff.asCode();

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(ffilename + ".compile")) {
            String code = "gcc -g -c -I../c-lang-deps -o obj/"+ ctx.ff.filename +".o "+ctx.ff.filename+".c";

            code += "\ngcc -g -I../c-lang-deps ../c-lang-deps/types.o obj/*.o  -o "+ ctx.ff.filename +" "+ctx.ff.filename+".run.c";

            for (ClassDef classDef : ctx.ff.getClasses()) {
                code += "\ngcc -g -c -I../c-lang-deps -o obj/"+ classDef.getClassFQN() +".o "+classDef.getClassFQN()+".c";
            }

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try (FileOutputStream out = new FileOutputStream(ffilename + ".run.c")) {
            String code = "#include \""+ ctx.ff.filename +".h\"\n\nvoid main() { "+ctx.ff.mainName()+";}";


            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        

        super.exitProgram(ctx);
    }

    @Override
    public void exitBlock_statement(Block_statementContext ctx) {
        if (ctx.bd != null) {
            System.out.println(ctx.start.getLine() +  " (block) " +ctx.bd.asCode());
        }

        super.exitBlock_statement(ctx);
    }

    @Override
    public void exitExtended_expr(Extended_exprContext ctx) {
        super.exitExtended_expr(ctx);
    }



    @Override
    public void exitClass_definition(final ecParser.Class_definitionContext ctx) {
        // ctx.cd.name

        ctx.cd.filename = ctx.cd.getClassFQN();
        System.out.println("Filename: " + filename);
        ctx.cd.resolve_01();
        ctx.cd.validate_02();
        ctx.cd.prepare_03();

        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ctx.cd.filename + ".h")) {
            String header = ctx.cd.asHeader();

            out.write(header.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ctx.cd.filename + ".c")) {
            String code = ctx.cd.asCode();

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // @after {$cd.prepare_03(); System.out.println($cd.asCode());}

}