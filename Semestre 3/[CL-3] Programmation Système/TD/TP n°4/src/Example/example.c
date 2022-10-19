#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <string.h>
#include <stdlib.h>

int main(void)
{
    int fd[2], nbytes, pid_t, childpid;
    char string[] = "4\n5\n3\n2\n1\n"; //observer l ordre des lignes

    pipe(fd);

    if((childpid = fork()) == -1)
    {
        perror("fork");
        exit(1);
    }

    if(childpid == 0)
    {
        close(fd[1]);
        dup2(fd[0],0);
        //echo '3+4' | bc
        execlp("sort", "sort", NULL);
        exit(0);
    }
    else
    {
        close(fd[0]);
        nbytes = write(fd[1], string, strlen(string));
    }
    return(0);
}
