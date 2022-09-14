#include <sys/types.h>
#include <unistd.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <signal.h>

pid_t getpid(void);

// les differents evenements pour terminer ce processus
#define NB_VALUES 4
enum naturel
{
    FIN_EXIT,
    FIN_RETURN,
    FIN_SIGNAL,
    FIN_ERREUR
};
enum naturel evenements_tab[NB_VALUES] = {FIN_EXIT, FIN_RETURN, FIN_SIGNAL, FIN_ERREUR};
// les differents signaux que nous allons nous envoyer.
#define NB_SIGNAUX 4
int signaux_tab[NB_SIGNAUX] =
    {
        SIGTSTP,
        SIGABRT,
        SIGQUIT,
        SIGINT};

// la fonction main du simulateur de terminaison du processus
int main(int argc, char **argv)
{
    srand(time(NULL));
    printf("Processus >>%jd<< est lance\n", (intmax_t)getpid());
    // tirage de l evenement
    enum naturel evenement = evenements_tab[rand() % NB_VALUES];
    printf("Processus[%jd] evenement = %d\n", (intmax_t)getpid(), evenement);

    // traitement de l evenement
    switch (evenement)
    {
    case FIN_EXIT:
    {
        int codeexit = rand() % 10;
        printf("Processus[%jd]: exit avec code %d\n", (intmax_t)getpid(), codeexit);
        exit(codeexit);
        break;
    }

    case FIN_SIGNAL:
    {
        int codesignal = signaux_tab[rand() % NB_SIGNAUX];
        printf("Processus[%jd]: signal numero %d\n", (intmax_t)getpid(), codesignal);
        kill(getpid(), codesignal); // envoie d un signal a nous meme
        break;
    }
    case FIN_RETURN:
    {
        int codereturn = rand() % 10;
        printf("Processus[%jd]: return (%d)\n", (intmax_t)getpid(), codereturn);
        return (codereturn);
        break;
    }
    case FIN_ERREUR:
    {
        printf("Processus[%jd]: fin sur erreur \n", (intmax_t)getpid());
        float infy = 1 / (1 - 1);//erreur
        break;
    }
    default:
        break;
    }
    printf("Processus >>%jd<< termine\n", (intmax_t)getpid()); // dead code
}