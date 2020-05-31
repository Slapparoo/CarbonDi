package ec.lang.defs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimativeTypes {
    // under gcc intel everything by default is 32bit
    public static Set<String> bits_8 = new HashSet<>(Arrays.asList("boolean", "b8", "i8", "u8"));
    public static Set<String> bits_16 = new HashSet<>(Arrays.asList("i16", "u16"));
    public static Set<String> bits_32 = new HashSet<>(Arrays.asList("i32", "u32", "f32", "int"));
    public static Set<String> bits_all32 = new HashSet<>(Arrays.asList("boolean", "b8", "i8", "u8", "i16", "u16", "i32", "u32", "f32", "int"));
    public static Set<String> bits_64 = new HashSet<>(Arrays.asList("i64", "u64", "f64", "pointer", "num"));
    
    
    public static boolean areCompatable(String a, String b) {
        if (bits_64.contains(a) && bits_64.contains(b)) {
            return true;
        }
        if (bits_32.contains(a) && bits_32.contains(b)) {
            return true;
        }
        if (bits_16.contains(a) && bits_16.contains(b)) {
            return true;
        }
        if (bits_8.contains(a) && bits_8.contains(b)) {
            return true;
        }
        return false;
    }

    public static boolean areCompatable32(String a, String b) {
        if (bits_64.contains(a) && bits_64.contains(b)) {
            return true;
        }
        if (bits_all32.contains(a) && bits_all32.contains(b)) {
            return true;
        }

        return false;

    }

}