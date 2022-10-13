#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdbool.h>
#include <unistd.h>

int pv = 0;
sigset_t mainset;

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
    sigset_t set, oset;
    sigemptyset(&set);
    for(int i=0; i<10; i++){
        sigaddset(&set, i);
    }

    if(sigprocmask(SIG_SETMASK, &set, &oset) != 0){
        perror("error 1");
    }

    int delay = 10;
    while (delay--  > 0 ) {
        printf("Je suis invincible\n") ;
        fflush(stdout);
        sleep(1);
    }

    if(sigprocmask(SIG_SETMASK, &oset, NULL) != 0){
        perror("Test");
    }
}

int main(int argc, char** argv) {
    if (argc < 2) {
        printf("Nombre d'argument invalide");
        exit(1);
    }

    int* p = &pv;
    *p = atoi(argv[1]);

    sigfillset(&mainset);
    for(int i=0; i<=10; i++){
        sigdelset(&mainset, i);
    }
    sigprocmask(SIG_BLOCK, &mainset, NULL);

    for (int i = 1 ; i < 10 ; i++) {
        signal(i,&pertePV);
    }
    signal(10,&invicible);

    while (pv > 0) {
        printf("Toujours en vie: %d\n", pv);
        sleep(1);
    }

    printf("Dead of KENNY !");
}