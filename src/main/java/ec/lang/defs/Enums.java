package ec.lang.defs;

import java.util.HashMap;
import java.util.Map;


public class Enums {
    public enum Accessor {HIDDEN("hidden"), PRIVATE("private"), PROTECTED("protected"), PUBLIC("public");
    
        public final String value;
 
        private Accessor(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    };
    public enum ClassType {CLASS, PLAN, STUB, TYPE};

    public static Map<String, Accessor> AccessorTypes = new HashMap<>();

    static {
        AccessorTypes.put(Accessor.PUBLIC.value, Accessor.PUBLIC);
        AccessorTypes.put(Accessor.PRIVATE.value, Accessor.PRIVATE);
        AccessorTypes.put(Accessor.PROTECTED.value, Accessor.PROTECTED);
        AccessorTypes.put(Accessor.HIDDEN.value, Accessor.HIDDEN);
    }
}