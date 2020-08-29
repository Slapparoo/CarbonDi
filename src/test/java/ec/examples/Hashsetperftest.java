package ec.examples;

import java.util.HashSet;

// import org.junit.jupiter.api.Test;

public class Hashsetperftest {

    // @Test
    public void testperf() {
        HashSet<String> ar = new HashSet<>();

        String String1 = "String1";
        String String2 = "String2";
        String String3 = "String3";
        String String4 = "String4";
        String String5 = "String5";
        String String6 = "String6";
        String String7 = "String7";
        String su8 = "u8";
        String si8 = "i8";
        String su64 = "u64";
        String sswitch = "switch";
        String scase = "case";
        String sreturn = "return";
        String svoid = "void";
        String sloop = "loop";
        String selse = "else";


        for (int i = 0; i < 100000; i++) {
            ar.add(String1);
            ar.add(String1);
            ar.add(String1);
            ar.add(String1);
            ar.contains(String1);

            ar.contains(String2);
            ar.add(String2);
            ar.contains(String3);
            ar.add(String3);
            ar.add(String4);
            ar.contains(String4);
            ar.add(String5);
            ar.contains(String5);
            ar.contains(String6);
            ar.add(String6);
            ar.add(String7);
            ar.contains(String7);

            ar.contains(su8);
            ar.add(su8);
            ar.add(si8);
            ar.contains(si8);
            ar.contains(su64);
            ar.add(su64);
            ar.add(sswitch);
            ar.contains(sswitch);
            ar.contains(scase);
            ar.add(scase);
            ar.add(sreturn);
            ar.contains(sreturn);
            ar.contains(scase);
            ar.add(scase);
            ar.add(svoid);
            ar.contains(svoid);
            ar.contains(sloop);
            ar.add(sloop);
            ar.add(selse);
            ar.contains(selse);
        }

        System.out.println(ar.size());
    }

    public static void main(String[] args) {
        
        new Hashsetperftest().testperf();
    }
    
}