
CC       := clang
#VALGRIND := valgrind -s --track-origins=yes --leak-check=full --error-exitcode=2
VALGRIND := valgrind  --track-origins=yes --leak-check=full --error-exitcode=2
SRCDIR 	 := .
SRC      := $(shell find $(SRCDIR) -name "*.c" -not -name "main*.c" )
SRCMAIN  := $(shell find $(SRCDIR) -name "main*.c")
MAINS    := $(shell find $(OBJDIR) -name "main*.e")
GENDIR	   := gen
INCLUDEDIR := include
OBJDIR     := obj
PARAMS   := -std=gnu17 -O3 -I$(INCLUDEDIR) 

OBJ := $(SRC:%.c=$(OBJDIR)/%.o)
MAIN := $(SRCMAIN:%.c=$(OBJDIR)/%.e)
RUNMAINS := $(MAINS:%.e=$(OBJDIR)/%.e)

all : clean $(OBJ) $(MAIN) $(RUNMAINS)

clean: 
	rm -f obj/*.o 
	rm -f obj/test/*.e 

$(OBJDIR)/%.o: %.c
	@echo "COMPILING SOURCE $< INTO OBJECT $@"
	@mkdir -p '$(@D)'
	@$(CC) -c $(PARAMS) $< -o $@

$(OBJDIR)/%.e: %.c
	@echo "COMPILING SOURCE $< INTO MAIN $@"
	@mkdir -p '$(@D)'
	@$(CC) $(PARAMS) $(OBJDIR)/*.o $< -o $@	

$(OBJDIR)/%.e: %.e
	@echo "valgrind $<"
	$(VALGRIND) $<


