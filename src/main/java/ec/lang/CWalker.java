package ec.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import ec.lang.defs.ClassDef;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.ProgramContext;

public class CWalker extends ecBaseListener {

    String dirname;
    String filename;
    FileOutputStream ecOutputStream;
    
    public List<String> tempFiles = new ArrayList<>();
    final Set<String> params;
    final String[] args;

    public CWalker(String[] args, final String dirname) throws Exception {
        this.dirname = dirname;
        this.filename = args[0];
        this.args = args;

        params = new HashSet<>(Arrays.asList(args));

        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);
        // String nsname = "";

        i = fName.lastIndexOf('.');
        if (i > 0) {
            // nsname = fName.substring(0, i);
            fName = fName.substring(i + 1);
        }

        String ffilename = fName + ".signature";

        if (!ffilename.equals("signature.signature")) {
            System.out.println("signature Filename: " + dirname + "/" + ffilename + ", " + dirname + "/" + filename);
            ecOutputStream = new FileOutputStream(dirname + "/" + ffilename + ".ec");
        }
    }

    class StreamGobbler extends Thread {
        InputStream is;
        String type;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null)
                    System.out.println(type + ">" + line);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void runScript(String dirname, String filename) throws IOException {
        File f = new File(dirname, filename);
        if (!f.exists()) {
            throw new IOException("Script not found "+ f.getAbsolutePath());
        }
        runCode(dirname, Arrays.asList("sh", "-c", "./" + filename));
    }

    public void runCode(String dirname, List<String> filename) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.directory(new File(dirname));
        processBuilder.command(filename);

        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader erreader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            if (line != null) { 
                System.out.println(line);
            }
        }

        String errline;
        while ((errline = erreader.readLine()) != null) {
            if (errline != null) { 
                System.err.println(errline);
            }
        }


        int exitCode = -1;
        try {
            exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Error running " + dirname + "/" + filename);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterProgram(ProgramContext ctx) {
        try {
            System.out.println("rm c-lang/*");
            // rm c-lang/*
            // echo "rm c-lang/obj/*"
            // rm c-lang/obj/*

            File f = new File("c-lang");
            if (f.exists() && f.isDirectory()) {
                FileUtils.cleanDirectory(f);
                
            }
            // f.mkdir();
            File fObj = new File(f, "obj");
            fObj.mkdirs();

        } catch (IOException e) {
            System.err.println("Error running. clean script ./clean-c-lang.sh");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        // ctx.
        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);
        // String nsname = "";

        i = fName.lastIndexOf('.');
        if (i > 0) {
            // nsname = fName.substring(0, i);
            fName = fName.substring(i + 1);
        }

        ctx.ff.name = fName;
        ctx.ff.filename = "" + (ctx.ff.namespace == null ? "Default" : ctx.ff.namespace) + "." + fName + "_main";
        // ctx.ff.filename = fName+ "_main";

        String ffilename = ctx.ff.filename;
        System.out.println("Filename: " + dirname + "/" + ffilename);

        ctx.ff.resolve_01();
        ctx.ff.validate_02();
        ctx.ff.prepare_03();

        // ctx.ff.prepare_03();

        try (FileOutputStream out = new FileOutputStream(dirname + "/" + ffilename + ".h")) {
            // tempFiles.add(dirname + "/" + ffilename + ".h");
            String header = ctx.ff.asHeader();

            out.write(header.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname + "/" + ffilename + ".c")) {
            tempFiles.add(dirname + "/" + ffilename + ".c");
            String code = ctx.ff.asCode();

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname + "/" + ffilename + ".compile")) {
            tempFiles.add(dirname + "/" + ffilename + ".compile");

            // String code = "echo starting compile..";
            String code = "";

            String params = "-std=gnu17 -O3 -g";

            for (ClassDef classDef : ctx.ff.getClasses()) {
                if (!classDef.is_signature) {
                    code += "\nclang " + params + " -c -I../c-bin/include -o obj/" + classDef.getFqn() + ".o "
                            + classDef.getFqn() + ".c";

                    // runCode(dirname, "clang " + params + " -c -I../c-bin/include -o obj/" + classDef.getFqn() + ".o " + classDef.getFqn() + ".c");
                    // code += "\nclang "+params+" -c -I../c-lang-deps -o obj/"+
                    // classDef.getClassFQN() +".o "+classDef.getClassFQN()+".c";
                    code += "\nclang-format -style=file -i " + classDef.getFqn() + ".c";
                }
            }
            code += "\nclang " + params + " -c -I../c-bin/include -o obj/" + ffilename + ".o " + ffilename + ".c";
            // code += "\nclang "+params+" -c -I../c-lang-deps -o obj/"+ ffilename +".o
            // "+ffilename+".c";
            code += "\nclang-format -style=file -i " + ffilename + ".c";

            code += "\nclang " + params + " -I../c-bin/include ../c-bin/obj/*.o obj/*.o  -o " + ffilename + " "
                    + ffilename + ".run.c";

            // code += "\necho $?\nenv";
            // code += "\nclang "+params+" -I../c-lang-deps -I../c-bin ../c-lang-deps/*.o
            // obj/*.o -o "+ ffilename +" "+ffilename+".run.c";
            code += "\nclang-format -style=file -i " + ffilename + ".run.c";

            out.write(code.getBytes());
            out.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream out = new FileOutputStream(dirname + "/" + ffilename + ".run.c")) {
            tempFiles.add(dirname + "/" + ffilename + ".run.c");

            String code = "#define DEBUG 1" + "\n#include \"" + ctx.ff.filename + ".h\"\n\nint main() { "
                    + "int res = 0;" + "\nif (!setjmp(*catchException())) {" + ctx.ff.mainName() + ";"
                    + "\n} else {\nafterCatchException(); res = 1; \n}" + "\n__onFinalExit();\n return res;}";

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

        try {
            runCode(dirname, Arrays.asList("sh", "./"+ffilename + ".compile"));
            runCode(dirname, Arrays.asList("./"+ ffilename));
        } catch (IOException e) {
            System.err.println("Error running. " + dirname + "/" + ffilename);
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        if (params.contains("-clean")) {
            for (String string : tempFiles) {
                System.out.println("delete " + string);
                FileUtils.deleteQuietly(new File(string));
            }
        }
    }

    @Override
    public void exitClass_definition(final ecParser.Class_definitionContext ctx) {
        ctx.cd.resolve_01();
        ctx.cd.validate_02();
        ctx.cd.prepare_03();
        System.out.println("#class Filename: " + ctx.cd.getFqn());

        if (!ctx.cd.is_signature) {
            try (FileOutputStream out = new FileOutputStream(dirname + "/" + ctx.cd.getFqn() + ".h")) {
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

            try (FileOutputStream out = new FileOutputStream(dirname + "/" + ctx.cd.getFqn() + ".c")) {
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