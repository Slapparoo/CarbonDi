package ec.lang.defs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is variable type / cast type / Parameter type
 * 
 */
public class TypeIdDef extends BaseDef {
    private String name;
    private boolean is_array = false;
    private boolean is_boxed = false;
    private String objectType;

    private static Set<String> PRIMATIVES = new HashSet<>();

    static {
        // All ref objects become i64
        PRIMATIVES.addAll(Arrays.asList(new String[] { "i64", "u64", "u32", "i32", "u16", "i16", "b8", "i8", "u8", "f32",
                "f64", "f128", "f80", "boolean", "num", "int", "pointer", "function"
        }));
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
    }

    public TypeIdDef() {
    }

    public TypeIdDef(String name) {
        this.name = name;
    }

    public TypeIdDef(String line, String name) {
        this.name = name;
        setLine(line);
    }

    public String asHeader() {
        return "";
    }

    private String getMappedType(String type) {
        if (is_array) {
            return "num";
        }
        return PRIMATIVES.contains(type) ? type : "num";
    }

    public String asCode() {
        return getMappedType(name);
    }

    @Override
    public String asSignature() {
        return name;
    }

	public static boolean isPrimative(String name) {
		return PRIMATIVES.contains(name);
    }

	public boolean isPrimative() {
		return PRIMATIVES.contains(name);
    }

    @Override
    public String toString() {
        return "TypeIdDef  ["+name+ " ObjectType=" + objectType + " array=" + is_array + ", boxed=" + is_boxed + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_array() {
        return is_array;
    }

    public void setIs_array(boolean is_array) {
        this.is_array = is_array;
    }

    public boolean isIs_boxed() {
        return is_boxed;
    }

    public void setIs_boxed(boolean is_boxed) {
        this.is_boxed = is_boxed;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public boolean isFunction() {
        return name.equals("function");
    }

	public boolean isVoid() {
        if (name == null || objectType == null) {
            return false;
        }
		return name.equals("void") || objectType.equals("void");
	}
}
