package ec.lang.defs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OperatorTypes {

    public static Set<String> COMPARATORS = new HashSet<>(Arrays.asList("<", ">", "==", ">=", "<=", "!=", "===", "&=", "~=", "||", "&&"));
    public static Set<String> ASSIGNEQUALS = new HashSet<>(Arrays.asList("+=", "-=", "*=", "/=", "%=", "|=", "&="));
    
}