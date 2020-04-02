package ec.lang.defs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is variable type / cast type / Parameter type
 * 
 */
public class TypeIdDef extends BaseDef {

    public String name;
    public boolean is_array;

    private static Set<String> PRIMATIVES = new HashSet<>();

    static {
        // All ref objects become i64
        PRIMATIVES.addAll(Arrays.asList(new String[] { "i64", "u64", "u32", "i32", "u16", "i16", "i8", "u8", "f32",
                "f64", "f128", "f80", "boolean", "num"
        }));
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
        System.out.println("@@TypeIdDef.resolve " + name + ", is_array="+ is_array + ", isPrimative=" + isPrimative());
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
        return PRIMATIVES.contains(type) ? type : "num";
    }

    public String asCode() {
        // @TODO if it is a return type void is valid
        return getMappedType(name);
    }

    @Override
    public String toString() {
        return "TypeIdDef [is_array=" + is_array + ", name=" + name + "]";
    }


	public boolean isPrimative() {
		return PRIMATIVES.contains(name);
	}
}
