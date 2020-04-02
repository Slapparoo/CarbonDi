
CC       := clang
VALGRIND := ../../../valgrind-3.15.0/coregrind/valgrind

all: valgrind_array valgrind_boxing 

clean:
	rm -f *.o *.i *.bc *.s
	rm -f main_array

compile:
	$(CC) -std=gnu17 -O3 -g -c *.c
	rm -f main_array.o testhash.o main_boxing.o


main_array: clean compile
	$(CC) -std=gnu17 -O3 -g *.o main_array.c -o main_array
	./main_array

valgrind_array: main_array
	$(VALGRIND) -s  --track-origins=yes ./main_array
	time ./main_array > /dev/null

main_boxing: clean compile
	$(CC) -std=gnu17 -O3 -g *.o main_boxing.c -o main_boxing
	./main_boxing

valgrind_boxing: main_boxing
	$(VALGRIND) -s  --track-origins=yes ./main_boxing
	time ./main_boxing > /dev/null
