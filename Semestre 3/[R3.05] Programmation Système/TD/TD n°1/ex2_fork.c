#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main(){
    pid_t pid;
    pid = fork();
    if (pid > 0){
        printf("Je suis le parent[pid=%jd] => fils[pid=%jd] \n", (intmax_t)getpid(), (intmax_t)pid);
    }else{
        if (!pid)
        {
            printf("Je suis le fils[pid=%jd] <= mon parent[pid=%jd] \n", (intmax_t)getpid(), (intmax_t)getppid());
        }
        else
        {
            if (pid == -1)
            {
                perror("fork");
            }
        }
    }
}