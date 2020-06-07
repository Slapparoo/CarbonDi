package ec.lang.defs;

import java.util.List;

import org.antlr.v4.runtime.Token;

public class BaseDef {
    public BlockDef containedInBlock;
    public List<Token> comments;

    public String hasNot = "";

    private String line;
    
    private int resolveCount = 0;

    public void resetResolved() {
        resolveCount = 0;
    }

    public boolean isResolved() {
        return resolveCount > 0;
    }

    public BaseDef() {
        line = "";      
    }


    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }

    public String asDoc() {
        if (comments != null) {
            for (Token token : comments) {
                if (token.getText().startsWith("/**")) {
                    return token.getText().substring(3, token.getText().length() -3).trim();
                }
            }
        }

        return "";
    }

    public String asSignature() {
        return "";
    }


    public String asDebug() {
        return line;
    }

    /**
     * 
     */
    public void resolve_01() {
        resolveCount++;
    }

    /**
     * gets called after loadin and before validate();
     * used to create properties accessors and mutators
     * resolve annonyous names
     * point to properties methods etc.
     */
    public void prepare_03() {

    }

    public void optimise_04() {

    }


    /**
     * verify variables, functions, types exsit etc
     * @return
     */

    public boolean validate_02() {
        return true;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}