
#include "message.h"

#include <sys/types.h> 
#include <unistd.h>

#include <sys/stat.h>
#include<stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>


void creation_tube_nomme() {
//TODO
}
int fifo_me;
struct requete_client_serveur* requete;

void recevoir_requete(){
//TODO
}

void envoyer_resultat(){
//TODO 
}

void terminer(){

}

int main(int argc, char** argv){

    creation_tube_nomme();
    
    while(1){
    recevoir_requete();
    envoyer_resultat();
    }

    terminer();
    
}
