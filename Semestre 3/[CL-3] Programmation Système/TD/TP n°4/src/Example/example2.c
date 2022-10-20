#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <string.h>
int main(void)
{
    int childpid, pid_t, fd[2], nbytes;
    char string[] = "Hello, world!\n";
    char readbuffer[80];

    pipe(fd);

    if((childpid = fork()) == -1)
    {
        perror("fork");
        exit(1);
    }

    if(childpid == 0)
    {
        close(fd[0]);
        write(fd[1], string, (strlen(string)+1));
        exit(0);
    }
    else
    {
        close(fd[1]);
        nbytes = read(fd[0], readbuffer, sizeof(readbuffer));
        printf("Message recu: %s", readbuffer);
    }
    return(0);
}
