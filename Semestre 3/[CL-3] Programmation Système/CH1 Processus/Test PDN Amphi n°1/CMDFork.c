#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
int main(void)
{
   printf("pid du processus pere %d",getpid());
   pid_t pid;
   pid = fork();
   if (pid > 0)
   {
       printf(" pid du fils=%d!\n", pid);
   }
   else
   {
       if (!pid)
       {
           printf("\nOn est dans le pus enfant! .. %d, pid du new pus  %d\n",pid,getpid());
       }
       else
       {
           if (pid == -1)
           {
               printf("erreur fork");
               perror("erreur fork");
           }
       }
   }
}
