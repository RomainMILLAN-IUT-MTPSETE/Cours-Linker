#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char* argv[]){
    if(argc != 2){
        printf("Erreur, nombre d'argument invalide");
        exit(1);
    }
    
    pid_t pid;
    pid = atoi(argv[1]);
    pid_t ppid;
    ppid = getppid(pid);

    printf("\nLe PID du père du PID=%d est PPID=%d", pid, ppid);

    exit(0);

}