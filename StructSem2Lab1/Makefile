ifeq ($(OS), Windows_NT)
				OUT_FILE := program.exe
		else
				OUT_FILE := a.out
		endif

FILE = main.cpp \
				Tree.h \
				TreeNode.h
all:
		g++ $(FILE) -std=c++14 -Wwritable-strings
		rm -f *.gch
