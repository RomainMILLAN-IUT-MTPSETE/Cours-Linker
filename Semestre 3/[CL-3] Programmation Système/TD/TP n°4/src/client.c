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

void envoyer_expression(){
//TODO

}

void recevoir_resultat(){
 //TODO

};
    
void terminer()
{
    remove( pathname );
}

int main(int argc, char** argv){

    creation_tube_nomme();
    envoyer_expression();
    recevoir_resultat();
    terminer();   
    return 0;
}
