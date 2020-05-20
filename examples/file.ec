
u64 filesize(pointer fp){
    int prev = External.stdio.ftell(fp);
    External.stdio.fseek(fp, 0, External.stdio.SEEK_END);
    int sz = External.stdio.ftell(fp);
    External.stdio.fseek(fp, prev, External.stdio.SEEK_SET); //go back to where we were
    return sz;
}

i8[] fileread(String filename) {
    pointer fp = External.stdio.fopen(filename.asStr, `'r'`);
    if (fp == null) {
        External.core.throwException(`[openfile] error opening file.`);
    }
    u64 size = filesize(fp);
    ?szp1 = size+1;
    ?buffer = i8[szp1]; // +1 so we can have a null terminated str
    ?result = External.stdio.fread(buffer.values, 1, size, fp);

    External.stdio.fclose(fp);

    if (result != size) {
        External.core.throwException(`[readfile] error reading file.`);
    }

    return buffer;
}

?content = fileread("Default.file_main.c");

External.stdio.printf(`file read content\n %s\n`, content.values);

// loop (content) {
//     External.stdio.printf(`%c`, $a);
// }



