#include "stdio.h"


struct MyClassModel {
    void(*open)();
    void(*close)();
} MyClassModel;

void myOpen() { printf("open\n");}
void myClose() { printf("close\n");}


struct MyClassModel myCLassModel 
__attribute__((section(".class_model"))) 
// __attribute__((section(".rodata")))   // rodata apprears to be rw
= {
    .open = myOpen,
    .close = myClose
};

int main() {
    myCLassModel.open();
    myCLassModel.close();

    myCLassModel.open = myClose;

    myCLassModel.open();
}