#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(void){
    int pid = getpid();

    printf("\nMon PID est=%d", pid);

    sleep(10);

    exit(EXIT_SUCCESS);
}