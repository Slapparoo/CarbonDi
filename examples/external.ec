
// class signature Core.Stdio {
//     static int printf(pointer str);
// }

// class signature Core.External {
//     properties {
//         static Stdio stdio;
//     }
// }

// function External.stdio.printf := int(pointer, ..);

External.stdio.printf(`Hello World!\n`);