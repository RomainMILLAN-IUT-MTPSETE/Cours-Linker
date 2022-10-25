
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
    mkfifo(FIFO_SERVEUR, 0777);
}

int fifo_me;
struct requete_client_serveur requete;

void recevoir_requete(){
    if((fifo_me = open(FIFO_SERVEUR, O_RDONLY)) < 0){
        printf("RecevoirRequete - OPEN");
        exit(1);
    }
    if(read(fifo_me, &requete, sizeof(struct requete_client_serveur)) < 0){
        printf("RecevoirRequete - READ");
        exit(1);
    }

    close(fifo_me);
    //DEBUG
    //printf("Sever: %s\n", requete.expression);
}

void envoyer_resultat(){
    char reponse[100];
    FILE *fp = popen(requete.expression, "r");
    fscanf(fp, "%100s", reponse);
    pclose(fp);

    char pathnameClient[80];
    sprintf(pathnameClient,PATH_FORMAT,requete.client_pid);

    if((fifo_me = open(pathnameClient, O_WRONLY)) == -1){
        printf("EnvoyerResultat - OPEN");
        exit(1);
    }

    if(write(fifo_me, reponse, sizeof(reponse)) == -1){
        printf("EnvoyerResultat - WRITE");
        exit(1);
    }

    close(fifo_me);
}

void terminer(){
    remove(FIFO_SERVEUR);
}

int main(int argc, char** argv){

    creation_tube_nomme();

    while(1){
        recevoir_requete();
        envoyer_resultat();
    }

    terminer();
    
}
