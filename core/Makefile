# anything with a name main*.c will be compiled and run with valgrind

# compile all build a dynamic shared lib and object files by default
# so you can choose how to link the runtime

# there are some fancy bits in here the common uses will be:
# make
# make compile // differencial build
# make clean // clean
# make clean all // clean build


CC		 	 := clang
VALGRIND     := valgrind  --track-origins=yes --leak-check=full --error-exitcode=2
SRCDIR 	     := .
SRC          := $(shell find $(SRCDIR) -maxdepth 1 -name "*.c" -not -name "main*.c" )
SRCMAIN      := $(shell find $(SRCDIR) -name "main*.c")
MAINS        := $(shell find $(OBJDIR) -name "main*.e")
GENDIR	     := gen
INCLUDEDIR   := include
OBJDIR       := obj
LIBDIR       := lib
OPTIMISATION := -O3
PARAMS       := -Wall -Wno-format -Wno-unused-variable -std=gnu17 -I$(INCLUDEDIR)

OBJ 		:= $(SRC:%.c=$(OBJDIR)/%.o)
MAIN 		:= $(SRCMAIN:%.c=$(OBJDIR)/%.e)
RUNMAINS 	:= $(MAINS:%.e=$(OBJDIR)/%.e)
LIB 		:= $(SRC:%.c=$(LIBDIR)/libec.so)

all 	: compile test
compile : include/eccore.h.gch lib obj $(MAIN)

printdebug 	: CC += -g -DPRINT_DEBUG=1
printdebug 	: OPTIMISATION = -O0
printdebug 	: clean all

debug 	: CC += -g
debug 	: clean all

quadmath : CC += -D__SUPPORT_QUADMATH_
quadmath : clean all

quadmathd : debug quadmath

test : $(RUNMAINS)

createdirs :
	@mkdir -p obj
	@mkdir -p obj/test
	@mkdir -p lib

obj : createdirs $(OBJ)

lib : createdirs $(LIB)

include/eccore.h.gch :
	@echo "create a single header include/eccore.h"
	$(CC) include/Core.Core_main.h -E -dD > include/eccore.h
	$(CC)  $(OPTIMISATION) $(PARAMS) include/eccore.h

cleanobj:
	rm -fr obj 

cleanlib:
	rm -fr lib

clean : cleanobj cleanlib
	rm -f include/eccore.h
	rm -f include/eccore.h.gch 

$(OBJDIR)/%.o : %.c 
	@echo "COMPILING SOURCE $< INTO OBJECT $@ with $(CC) $(PARAMS)"
	@$(CC)  $(OPTIMISATION) -c $(PARAMS) $< -o $@

$(OBJDIR)/%.e : %.c 
	@echo "COMPILING SOURCE $< INTO MAIN $@"
	$(CC)  $(OPTIMISATION) $(PARAMS) $(LIBDIR)/*.so $< -o $@	
	# resample the newly compiled mains
	$(call MAIN)

$(LIBDIR)/libec.so: 
	@echo "COMPILING SOURCE $< INTO Dynamic Lib $@"
	@$(CC)  $(OPTIMISATION) -shared -fpic $(PARAMS) $(SRC) $< -o $@	

$(OBJDIR)/%.e : %.e
	@echo "valgrind $<"
	$(VALGRIND) $<
