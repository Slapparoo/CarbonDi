
CC       := clang
VALGRIND := ../../../valgrind-3.15.0/coregrind/valgrind

all: valgrind

clean:
	rm -f *.o *.i *.bc *.s
	rm -f main_test

compile:
	$(CC) -std=gnu17 -O3 -g -c -I../c-lang-deps  *.c
	rm -f main_test.o


main_test: clean compile
	$(CC) -std=gnu17 -O3 -g -I../c-lang-deps ../c-lang-deps/*.o  main_test.c -o main_test
	$(CC) -std=gnu17 -O3 -g -I../c-lang-deps ../c-lang-deps/*.o  override_test.c -o override_test
	./main_test

override_test: clean compile
	$(CC) -std=gnu17 -O3 -g -I../c-lang-deps ../c-lang-deps/*.o  override_test.c -o override_test
	./override_test

valgrind: main_test
	$(VALGRIND) -s  --track-origins=yes ./main_test
	# time ./main_test > /dev/null
