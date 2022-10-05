#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdbool.h>
#include <unistd.h>

void sigUp( int code ) {
    printf (">>> SIGUP received [%d]\n" , code ) ;
}

void sigInt ( int code ) {
    fprintf ( stderr , ">>> SIGINT received [%d]\n" , code ) ;
}

int main (int argc, char *argv[]) {
    // On enregistre les gestionnaires de signaux.
    signal ( SIGHUP, &sigUp ) ;
    signal ( SIGINT, &sigInt ) ;
    while( 30 ) {
        printf("I am still alive\n");
        sleep (1) ;
    }
}