@always = true;
@never = false;
@sometimes = 10;

if (always) {
    printf("always\n");
}

if (sometimes || always) {
    printf("sometimes\n");
}

if (never) {
    printf("never\n");
}

printf("end\n");