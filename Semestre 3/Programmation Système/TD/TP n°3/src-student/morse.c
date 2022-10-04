#include "morse.h"
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

// TODO : Completer le code du serveur suivant
int main(int argc, char **argv)
{
    pid_t pid = getpid();
    printf("Voici mon PID %d\n", pid);
    while (1)
    {
        pause(); // pause permet d attendre les signaux
    }
}