
{ 
    i = 0; 
    loop(0..100) a {
        i+=a;
    }

    loop(0..i) {
        i+=$a;
    }


    loop('a'..'z') {
        i+=$a;
    }

    ['a'..'b'];
    ['A'..'Z'];
    ['a'..'b', 'A'..'Z'];


    loop(['a'..'z', 'A'..'Z']) {
        i+=$a;
    }


    loop(people) {
        print($a.name);
    }

    loop(people) person {
        print(person.name);
    }

    u64 a = 100_000_000;
    u64 b;
    u64 b;
    boolean c = true;
    boolean d = null;
    String e = 'hello';
    String f = 'there';
    u32 g = 1 + 2;
    u32 g = 1 + d.f;

    String f = 'there' + 'hi';
};

//float
// 1f;
// 1.0f;
// 0.1f;
// .1f;
//1.f;
100_000.000_001;
100_000_000;
// 1.1;
// 1.0;
// .1;
// 1.;

$a;
$b;

// binary
0b_1010_1010_1010;

u8 a = 0x34;
u8 a;
u8 a = 34;
@a = 0x34;
@a = b;
@a = '''
hello
''';


@a = [1, g()];
u64 a[] = [1, g()];
u64 a[] = [1, b, "3"];
u64 a[] = [1];
u64 a[] = [];
var a[] = [1];
var a[] = [];
u64[] a = [1];
u64[] a;
u64 a[10];
u64[10] a;

// substring
String[] a = names[0..names.length];

// array pointing to a specific address / direct memory access
u64 a[300] :0xA000000;
u64 a[] :0xA000000;
u64 a[buffer_length] : buffer;
u64 a[] : buffer;


// json
@a  = (Person){ 'firstname' : 'brook', 'lastname' : 'smith', 'things' : [1,2,3,4,5]};

/*
@a  => (u8, u8) {
    $a+$b;
}

@a = function(a, b) {
    return $a+$b;
}

class Array(array) {
    properties (private, private) {
        (public,) u64 length;
    }

    public {
        T get(u64 index);
        void set(u64 index, T value);
    }
}
*/

plan array {
    T get(u64 index);
    void set(u64 index, T value);
}


var a = [5];
@a = [5];
@name = 'brook';
@a[] = [];
@a = b();

@a = 1.5;
@a = .5;
@a = 1.;

u64 a[] = u();
u64[] a = b(a, a);
u64[] a = b(a);
u64 a = b(a);

c();
c(a, r.y(), a.h);
c(a, r(b));
c(a, 'r');
c([1,2,3]);
g.f.c(12);


void main(u64 a);
void main(f128 ab, i8 c);
void main();

void main(u64 a = null);
void main(u64 a = 20);
void main(u64 a = b);
void main(u64 a = '20');
void main(u64 a = "20");
void main(string a = "20");
void main(string a[]);
void main(&u64 a);


void main() {}
void main() {return null;}
void main() {return 1 + 1;}

public final void main() {return 1 + 1;}
public static final void main() {return 1 + 1;}
