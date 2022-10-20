#include <sys/types.h>
#include <unistd.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

#define NB_VALUES 10

pid_t getpid(void);

int sleep_times[NB_VALUES] = {1, 1, 1, 2, 2, 3, 3, 4, 5, 6};

int main(int argc, char **argv)
{
    time_t t;
    srand((unsigned)time(&t));

    printf("Processus >>%jd<< est lance\n", (intmax_t)getpid());
    int sleeptime = sleep_times[rand() % NB_VALUES];
    printf("Processus >>%jd<< dort pendant %d sec\n", (intmax_t)getpid(),sleeptime);
    sleep(sleeptime);
    printf("Processus >>%jd<< termine\n", (intmax_t)getpid());
    exit(0);
}