#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(void)
{
    int status;
    pid_t pid = fork();
    if (!pid){
        // fils ici
        char *const args[] = { "simulateurexit", NULL};
        int ret;
        ret = execv("./ simulateurexit", args);

        if (ret == -1)
        {
            perror("execv");
            exit(-1);
        }
    }

    //PAS SUR
    int pidfils = wait(status);
    //PAS SUR

    if (pidfils == -1){
        perror("wait");
    }

    printf("serveur[% d] en attente\n", getpid());

    if (WIFEXITED(status)){
        printf("serveur[% d] exit status = % d du processus % d\n", getpid(), WEXITSTATUS(status), pidfils);
    }

    if (WIFSIGNALED(status)){
        printf("serveur[% d] Terminaison par un signal = % d % s du processus % d\n",getpid(), WTERMSIG(status), WCOREDUMP(status) ? "(dumped core)" : " ", pidfils);
    }

    if (WIFSTOPPED(status)){
        printf("serveur[% d] Stope par un signal = % d du processus % d \n", getpid(), WSTOPSIG(status), pidfils);
    }

    return 0;
}