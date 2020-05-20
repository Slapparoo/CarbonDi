/**

*/

public class Core.WriteFileArray (Core.DynamicArray) {

    properties {
        (public, private) pointer filename;
        (private, private) pointer filePointer;

    }

    public PersistedFileArray(=filename) {
        filePointer = External.stdio.fopen(filename, "w");
        if (filePointer == null) {
            throwException(`[PersistedFileArray] error opening file `);
        }
    }

    /**
    write the buffer to file.
    */
    void write() {
        int res = External.stdio.fwrite(values, 1, length, filePointer);
        if (res != length) {
            throwException(`[PersistedFileArray] error writing file `);
        }

        // reset array length = 0;
    }


    /**
    Make sure the file is closed on release
    */
    void release() {
        External.stdio.fclose(filePointer);
    }

}
