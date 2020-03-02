imports {
    extern_c library.stdio;
}

plan Array {
    T geti(u64 index);
    void seti(u64 index, T value);
    u64 length();
}


private plan Array {
    T geti(u64 index);
    void seti(u64 index, T value);
    u64 length();
}

private stub Array {
    (public, protected) properties {
        (protected,) String firstname;
        (, private) String lastname;
    }


    public T geti(u64 index);
    private void seti(u64 index = (u64)10, T value);
    protected u64 length();


    get get {
        return 10;
    }

    public u8 getVal() {
        return 10;
    }
}


protected final plan Array<T>(Object) {
    T geti(u64 index);
    void seti(u64 index[], T value);
    u64 length();
    private void setLength(u64);
}


type somedata {
    u8[5] a;
    u64 b;
}

union types {
    u8[8];
    u16[4];
    u32[2];
    u64;
}

void get(u64 index);