# anything with a name main*.c will be compiled and run with valgrind

# compile all build a dynamic shared lib and object files by default
# so you can choose how to link the runtime

CCGCC    := gcc
CCCLANG  := clang 
CCAVR    := avr-gcc
CC		 := $(CCCLANG)
# CC		 := $(CCGCC)
# CC		 := $(CCAVR)

VALGRIND   := valgrind  --track-origins=yes --leak-check=full --error-exitcode=2
SRCDIR 	   := .
SRC        := $(shell find $(SRCDIR) -maxdepth 1 -name "*.c" -not -name "main*.c" )
SRCMAIN    := $(shell find $(SRCDIR) -name "main*.c")
MAINS      := $(shell find $(OBJDIR) -name "main*.e")
GENDIR	   := gen
INCLUDEDIR := include
OBJDIR     := obj
LIBDIR     := lib
PARAMS     := -Wall -Wno-format -Wno-unused-variable -std=gnu17 -g -O3 -I$(INCLUDEDIR)
# PARAMS := -std=gnu11 -g -O3 -I$(INCLUDEDIR) -I/mnt/e/earthquaketrigger/Arduino/hardware/tools/avr/avr/include

OBJ := $(SRC:%.c=$(OBJDIR)/%.o)
MAIN := $(SRCMAIN:%.c=$(OBJDIR)/%.e)
RUNMAINS := $(MAINS:%.e=$(OBJDIR)/%.e)
LIB := $(SRC:%.c=$(LIBDIR)/libec.so)

all : clean singleheader lib obj $(MAIN) $(RUNMAINS)

obj : $(OBJ)

lib : $(LIB)

singleheader :
	@echo "create a single header include/eccore.h"
	rm -f include/eccore.h.gch 
	clang include/Core.Core_main.h -E -dD > include/eccore.h
	$(CC) $(PARAMS) include/eccore.h

cleanobj:
	rm -f obj/*.o 

cleanlib:
	rm -f lib/*.so 

clean: cleanobj cleanlib
	rm -f obj/test/*.e 

$(OBJDIR)/%.o: %.c
	@echo "COMPILING SOURCE $< INTO OBJECT $@ with $(CC) $(PARAMS)"
	@mkdir -p '$(@D)'
	@$(CC) -c $(PARAMS) $< -o $@

$(OBJDIR)/%.e: %.c
	@echo "COMPILING SOURCE $< INTO MAIN $@"
	@mkdir -p '$(@D)'
	@$(CC) $(PARAMS) $(LIBDIR)/*.so $< -o $@	

$(LIBDIR)/libec.so: 
	@echo "COMPILING SOURCE $< INTO Dynamic Lib $@"
	@mkdir -p '$(@D)'
	@$(CC) -shared -fpic $(PARAMS) $(SRC) $< -o $@	


$(OBJDIR)/%.e: %.e
	@echo "valgrind $<"
	$(VALGRIND) $<


