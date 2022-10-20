#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main(){
    while(1){
        printf("millanr@terminalC: ");
        char passCmdTerm[300];
        scanf("%s", passCmdTerm);

        if(strcmp(passCmdTerm, "Casse") == 0){
            printf("Tete");
        }
        printf("\n");

    }
}