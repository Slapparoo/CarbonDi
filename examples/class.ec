namespace std.library ;

imports {
    extern_c 'stdio.h' ;
    std.library;
}

public class Array(obj) {
    public Td getit(u64 index) {return 1;};
    void setit(u64 index, T value);
    u64 length();
}


private class Array {
    T getit(u64 index);
    void setit(u64 index, T value) throws AnException;
    u64 length();

    get count {}

}

protected final class Array<T>(Object) {
    (public, public) properties {
        (private, ) u64 count;
        (, ) u64 count;
        (,private) u64 count;
        (private, private) u64 count;
    }

    get count {
        return count;
    }

    set count { count = $a; }

    set count {
        if (count != $a) {
            countChanged = true;
        }
        count = $a;
    }

    T getit(u64 index);
    static void setit(u64 index = 1, T value[] = [1,2,3]);
    u64 length();
    public void setLength(u64);

    private void setLength(u64) {
        length = $a + 1 * 2;
    };


}
