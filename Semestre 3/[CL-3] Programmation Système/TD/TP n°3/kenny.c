#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdbool.h>
#include <unistd.h>

int pv = 0;

void pertePV(int degats) {
    if (pv - degats > 0) {
        pv -= degats;
    }
    else {
        pv = 0;
    }
    printf("C'est pas juste ! %i\n", pv);
}

void invicible(int sig) {
    int delay = 10;
    while (delay--  > 0 ) {
        printf("Je suis invincible\n") ;
        sleep(1);
    }
}

int main(int argc, char** argv) {
    if (argc < 2) {
        printf("Nombre d'argument invalide");
        exit(1);
    }

    int* p = &pv;
    *p = atoi(argv[1]);

    for (int i = 1 ; i < 10 ; i++) {
        signal(i,&pertePV);
    }
    signal(10,&invicible);

    while (pv > 0) {
        sleep(1);
    }

    printf("Dead of KENNY !");
}