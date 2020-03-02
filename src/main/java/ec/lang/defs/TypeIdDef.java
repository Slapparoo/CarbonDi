package ec.lang.defs;

import java.util.HashMap;
import java.util.Map;

/**
 * This is variable type / cast type / Parameter type
 * 
 */
public class TypeIdDef extends BaseDef {

    public String name;
    public boolean is_array;

    private static Map<String, String> TYPE_MAPPING = new HashMap<>();

    static {
        TYPE_MAPPING.put("u8", "char");
        TYPE_MAPPING.put("u32", "unsigned int");
        TYPE_MAPPING.put("i32", "int");
        TYPE_MAPPING.put("u64", "unsigned long long");
        TYPE_MAPPING.put("i64", "long long");
    }


    public TypeIdDef() {
    }

    public TypeIdDef(String name) {
        this.name = name;
    }

    public String asHeader() {
        return "";
    }


    private String getMappedType(String type) {
        String res = TYPE_MAPPING.get(type);

        return res == null ? type : res;
    }


    public String asCode() {
        // if (is_array) {
        //     return getMappedType(name) + "[]";
        // }
        return getMappedType(name);
    }

    @Override
    public String toString() {
        return "TypeIdDef [is_array=" + is_array + ", name=" + name + "]";
    }
}
