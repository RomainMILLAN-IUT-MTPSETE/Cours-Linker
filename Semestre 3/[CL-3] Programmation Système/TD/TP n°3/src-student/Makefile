

all : recepteur emetteur
	echo "construction des executables"

recepteur:	utile.o morse.o morse.h
	gcc -o recepteur morse.o utile.o

morse.o: morse.c morse.h
	gcc -c morse.c

emetteur: utile.o emetteur.o morse.h
	gcc -o emetteur emetteur.o utile.o

emeteur.o: emetteur.c morse.h
	gcc -c emetteur.c

utile.o: utile.c morse.h
	gcc -c utile.c
clean:
	rm *.o emetteur recepteur