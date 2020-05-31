
// class signature Core.Stdio {
//     static int printf(pointer str);
// }

// class signature Core.External {
//     properties {
//         static Stdio stdio;
//     }
// }

// function External.stdio.printf := int(pointer, ..);

public class Default.AsExternal (Core.Object) {"
    public void getSomeLength1(pointer p) { 
        int i = External.stdio.strlen(p);
    }
    
    public int getSomeLength2() { 
        pointer p; 
        return  External.stdio.strlen(p);
        // return 10;
    }
}

public class Default.AsExternal2 {"
    public void getSomeLength1(pointer p) { 
        int i = External.stdio.strlen(p);
    }
    
    public int getSomeLength2() { 
        pointer p; 
        return  External.stdio.strlen(p);
        // return 10;
    }
}

?asExternal = AsExternal();

// ?str = `a c string`;

?asExternal2 = AsExternal2();

// External.stdio.printf(str);
External.stdio.printf(`Hello World!\n`);