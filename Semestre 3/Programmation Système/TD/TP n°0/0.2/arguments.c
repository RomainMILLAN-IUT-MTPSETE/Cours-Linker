#include <stdio.h>

int main(int argc, char* argv[]){
    int i=0;

    printf("\nLe nombre d'arguments est=%d", argc);

    /*Le 1er argument est le nom du programme*/
    printf("\nCet executable est=%s", argv[0]);

    for(i=1; i<argc; i++){
        printf("\nArgument %d=%s", i, argv[i]);
    }

    printf("\n");


}