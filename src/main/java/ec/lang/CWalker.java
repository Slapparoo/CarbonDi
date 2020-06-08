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

import ec.lang.compiler.Messages;
import ec.lang.defs.ClassDef;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.ProgramContext;

public class CWalker extends ecBaseListener {

    String dirname;
    String filename;
    String ecCoreDir;
    FileOutputStream ecOutputStream;
    
    public List<String> tempFiles = new ArrayList<>();
    final Set<String> params;
    final List<String> args;

    public CWalker(List<String> args, final String dirname, String ecCoreDir) throws Exception {
        this.dirname = dirname;
        this.filename = args.get(0);
        this.ecCoreDir = ecCoreDir;
        this.args = args;

        params = new HashSet<>(args);

        File f = new File(filename);
        int i = f.getName().lastIndexOf('.');
        String fName = f.getName().substring(0, i);

        i = fName.lastIndexOf('.');
        if (i > 0) {
            fName = fName.substring(i + 1);
        }

        try {
            File f2 = new File(dirname);
            if (f2.exists() && f.isDirectory()) {
                FileUtils.cleanDirectory(f2);
            }
            File fObj = new File(f2, "obj");
            fObj.mkdirs();

        } catch (IOException e) {
            System.err.println("Error running pre-clean " + dirname);
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        String ffilename = fName + ".signature";

        if (!ffilename.equals("signature.signature")) {
            // System.out.println("signature Filename: " + dirname + "/" + ffilename + ", " + filename);
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
        // System.out.println("Filename: " + dirname + "/" + ffilename);

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



            String compiler = "clang";
            for (String string : args) {
                if (string.startsWith("-CC")) {
                    compiler = string.substring(3);
                }
                if (string.startsWith("-CO")) {
                    params = string.substring(3);
                }

            }

            for (ClassDef classDef : ctx.ff.getClasses()) {
                if (!classDef.is_signature) {
                    code += "\n"+compiler+" " + params + " -c -I"+ecCoreDir+"core/include -o obj/" + classDef.getFqn() + ".o "
                            + classDef.getFqn() + ".c";

                    if (params.contains("-CF")) {
                        code += "\nclang-format -style=file -i " + classDef.getFqn() + ".c";
                    }
                }
            }
            code += "\n"+compiler+" " + params + " -c -I"+ecCoreDir+"core/include -o obj/" + ffilename + ".o " + ffilename + ".c";
            if (params.contains("-CF")) {
                code += "\nclang-format -style=file -i " + ffilename + ".c";
            }

            code += "\n"+compiler+" " + params + " -I"+ecCoreDir+"core/include "+ecCoreDir+"core/obj/*.o obj/*.o  -o " + ffilename + " "
                    + ffilename + ".run.c";

            if (params.contains("-CF")) {
                code += "\nclang-format -style=file -i " + ffilename + ".run.c";
            }

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

        Messages.MESSAGES.printMessages();

        try {
            if (!params.contains("-nogen")) {
                runCode(dirname, Arrays.asList("sh", "./"+ffilename + ".compile"));
                if (!params.contains("-norun")) {
                    runCode(dirname, Arrays.asList("./"+ ffilename));
                }
            }

        } catch (IOException e) {
            System.err.println("Error running. " + dirname + "/" + ffilename);
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        if (params.contains("-clean")) {
            for (String string : tempFiles) {
                // System.out.println("delete " + string);
                FileUtils.deleteQuietly(new File(string));
            }
        }
    }

    @Override
    public void exitClass_definition(final ecParser.Class_definitionContext ctx) {
        ctx.cd.resolve_01();
        ctx.cd.validate_02();
        ctx.cd.prepare_03();
        // System.out.println("#class Filename: " + ctx.cd.getFqn());


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

            if (params.contains("-OE")) {
                try (FileOutputStream out = new FileOutputStream(dirname + "/" + ctx.cd.getFqn() + ".ec")) {
                    String code = ctx.cd.asSignature();

                    out.write(code.getBytes());
                    out.flush();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


            try (FileOutputStream out = new FileOutputStream(dirname + "/" + ctx.cd.getFqn() + ".c")) {
                String code = ctx.cd.asCode();

                out.write(code.getBytes());
                out.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try (FileOutputStream out = new FileOutputStream(dirname + "/" + ctx.cd.getFqn() + ".md")) {
                String doc = ctx.cd.asDoc();

                out.write(doc.getBytes());
                out.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (params.contains("-incsig")) {
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
        }
    }
    // @after {$cd.prepare_03(); System.out.println($cd.asCode());}

}