
#include "message.h"

#include <sys/types.h> 
#include <unistd.h>

#include <sys/stat.h>
#include<stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>

char pathname[80];

void creation_tube_nomme() {
    mkfifo(FIFO_SERVEUR, 0666);
}

int fifo_me;
struct requete_client_serveur requete;

void recevoir_requete(){
    if((fifo_me = open(FIFO_SERVEUR, O_RDONLY)) == -1){
        printf("RecevoirRequete - OPEN");
        exit(1);
    }
    if(read(fifo_me, &requete, sizeof(struct requete_client_serveur)) == -1){
        printf("RecevoirRequete - READ");
        exit(1);
    }
}

void envoyer_resultat(){
    char pathnameClient[80];
    sprintf(pathnameClient,PATH_FORMAT,requete.client_pid);
    printf("%s\n", pathnameClient);
    if((fifo_me = open(pathnameClient, O_WRONLY)) == -1){
        printf("EnvoyerResultat - OPEN");
        exit(1);
    }

    if(write(fifo_me, requete.expression, strlen(requete.expression)) == -1){
        printf("EnvoyerResultat - WRITE");
        exit(1);
    }
}

void terminer(){
    remove(FIFO_SERVEUR);
}

int main(int argc, char** argv){

    creation_tube_nomme();

    while(1){
        recevoir_requete();
        printf("Srv: %s\n", requete.expression);
        //envoyer_resultat();
    }

    terminer();
    
}
