#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdbool.h>
#include <unistd.h>

int main(int argc, char** argv){

    if (argc < 3){
        printf("Erreur args");
        exit(1);
    }

    //KILL(
    pid_t pid = atoi(argv[1]);
    int sig = atoi(argv[2]);

    int k = kill(pid, sig);

    if(k == -1){
        perror("kill");
    }

    return 0;
}