package ec.lang;

import java.io.File;
import java.io.FileOutputStream;

import ec.lang.defs.ClassDef;
import ec.lang.model.ecParser.*;
import ec.lang.model.*;

public class CWalker extends ecBaseListener {

    String dirname;
    String filename;    
    FileOutputStream ecOutputStream;

    public CWalker(final String filename, final String dirname) throws Exception {
        this.dirname = dirname;
        this.filename = filename;


        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);
        // String nsname = "";

        i = fName.lastIndexOf('.');
        if (i > 0) {
            // nsname = fName.substring(0, i);
            fName = fName.substring(i+1);
        }

        String ffilename =  fName + ".signature";
        

        if (!ffilename.equals("signature.signature")) {
            System.out.println("signature Filename: " + dirname +"/"+ ffilename + ", " + dirname + "/" +  filename );
            ecOutputStream = new FileOutputStream(dirname +"/"+ffilename + ".ec");
        }
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        // TODO Auto-generated method stub

        // ctx.
        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);
        // String nsname = "";

        i = fName.lastIndexOf('.');
        if (i > 0) {
            // nsname = fName.substring(0, i);
            fName = fName.substring(i+1);
        }

        ctx.ff.name = fName;
        ctx.ff.filename = ""+(ctx.ff.namespace == null ? "Default" : ctx.ff.namespace) + "." + fName+ "_main";
        // ctx.ff.filename = fName+ "_main";

        String ffilename =  ctx.ff.filename;
        System.out.println("Filename: " + dirname +"/"+ ffilename);
        
        ctx.ff.resolve_01();
        ctx.ff.validate_02();
        ctx.ff.prepare_03();

        // ctx.ff.prepare_03();

        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ffilename + ".h")) {
            String header = ctx.ff.asHeader();

            out.write(header.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ffilename + ".c")) {
            String code = ctx.ff.asCode();

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ffilename + ".compile")) {

            String code = "";

            String params = "-std=gnu17 -O3 -g";

            for (ClassDef classDef : ctx.ff.getClasses()) {
                if (!classDef.is_signature) {
                    code += "\nclang "+params+" -c -I../c-bin/include -o obj/"+ classDef.getFqn() +".o "+classDef.getFqn()+".c";
                    // code += "\nclang "+params+" -c -I../c-lang-deps -o obj/"+ classDef.getClassFQN() +".o "+classDef.getClassFQN()+".c";
                    code += "\nclang-format -style=file -i "+classDef.getFqn()+".c";
                }
            }
            code += "\nclang "+params+" -c -I../c-bin/include -o obj/"+ ffilename +".o "+ffilename+".c";
            // code += "\nclang "+params+" -c -I../c-lang-deps -o obj/"+ ffilename +".o "+ffilename+".c";
            code += "\nclang-format -style=file -i "+ffilename+".c";

            code += "\nclang "+params+" -I../c-bin/include ../c-bin/obj/*.o obj/*.o  -o "+ ffilename +" "+ffilename+".run.c";
            // code += "\nclang "+params+" -I../c-lang-deps -I../c-bin ../c-lang-deps/*.o obj/*.o  -o "+ ffilename +" "+ffilename+".run.c";
            code += "\nclang-format -style=file -i "+ffilename+".run.c";

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try (FileOutputStream out = new FileOutputStream(dirname +"/"+ffilename + ".run.c")) {

            String code = "#define DEBUG 1" 
            + "\n#include \""+ ctx.ff.filename +".h\"\n\nint main() { "
            + "int res = 0;"
            + "\nif (!setjmp(*catchException())) {"
            +ctx.ff.mainName() + ";"
            + "\n} else {\nafterCatchException(); res = 1; \n}"
            +"\n__onFinalExit();\n return res;}";


            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        

        super.exitProgram(ctx);

        try {
            if (ecOutputStream != null) {
                ecOutputStream.flush();
                ecOutputStream.close();
            }
        } catch (Exception e) {
            System.err.println("Error closing file.");
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void exitClass_definition(final ecParser.Class_definitionContext ctx) {
        // ctx.cd.name

        // ctx.cd.filename = ctx.cd.getClassFQN();
        ctx.cd.resolve_01();
        ctx.cd.validate_02();
        ctx.cd.prepare_03();
        System.out.println("#class Filename: " + ctx.cd.getFqn());

        if (!ctx.cd.is_signature) {
            try (FileOutputStream out = new FileOutputStream(dirname +"/"+ctx.cd.getFqn() + ".h")) {
                String header = ctx.cd.asHeader();

                out.write(header.getBytes());
                out.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            String header = ctx.cd.asSignature();

            try {
                if (ecOutputStream != null) {
                    ecOutputStream.write(header.getBytes());
                    ecOutputStream.flush();
                }
            } catch (Exception e) {
                System.err.println("Error writing to ecfile.");
                e.printStackTrace(System.err);
            }
        

            try (FileOutputStream out = new FileOutputStream(dirname +"/"+ctx.cd.getFqn()+ ".c")) {
                String code = ctx.cd.asCode();

                out.write(code.getBytes());
                out.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    // @after {$cd.prepare_03(); System.out.println($cd.asCode());}

}