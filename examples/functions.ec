
i64 getName() {
    return name; 
}

void setName(i64 name) {
    this.name = name; 
}

void updateName(&i64 name) {
    name = "my name"; 
}

void updateName(boolean always = true, &i64 name);

void updateName(boolean always = true, &i64 name) {
    if (always) {
        name = 100; 
    }
}