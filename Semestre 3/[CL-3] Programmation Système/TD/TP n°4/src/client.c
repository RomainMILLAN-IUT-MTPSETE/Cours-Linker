#include "message.h"
#include <sys/types.h> 
#include <unistd.h>

#include <sys/stat.h>
#include<stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>


pid_t pid ;
char pathname[80];
int fifo_serveur_fd;
int fifo_me_fd;

void creation_tube_nomme() {
    pid = getpid(); 
    sprintf(pathname,PATH_FORMAT,pid);
    mkfifo(pathname, 0666);
}

void envoyer_expression(char* exp){
    struct requete_client_serveur rcs;
    rcs.client_pid = pid;
    strcpy(rcs.expression, exp);
    if((fifo_serveur_fd = open(FIFO_SERVEUR, O_WRONLY)) == -1){
        printf("EnvoyerExpression - OPEN");
        exit(1);
    }
    if(write(fifo_serveur_fd, &rcs, sizeof(struct requete_client_serveur)) == -1){
        printf("EnvoyerExpression - WRITE");
        exit(1);
    }
}

void recevoir_resultat(){
    if((fifo_me_fd = open(pathname, O_RDONLY)) == -1){
        printf("RecevoirResultat = OPEN");
        exit(1);
    }
    char bufferResultat[BUFFER_SIZE];
    if(read(fifo_me_fd, bufferResultat, sizeof(bufferResultat)) == -1){
        printf("RecevoirResultat - READ");
        exit(1);
    }
    printf("Clt: %s\n", bufferResultat);
}
    
void terminer(){
    remove( pathname );
}

int main(int argc, char** argv){
    creation_tube_nomme();
    envoyer_expression(argv[1]);
    //recevoir_resultat();
    terminer();   
    return 0;
}
