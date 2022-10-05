#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>
/* handler for SIGINT */
static void sigint_handler (int signo) {
    printf ("Capture de SIGINT!\n");
    exit (EXIT_SUCCESS);
}

static int rester = 1;
int main(int argc, char **argv) {
    while (rester) {
        printf("Je suis toujours la!\n");
        pause(); // pause permet d attendre les signaux }
        exit(0);
    }

    /** enregistement du gestionnaire pour SIGINT. */
    if (signal(SIGINT, sigint_handler) == SIG_ERR) {
        fprintf(stderr, "erreur du gestionnaire pour SIGINT!\n");
        exit(EXIT_FAILURE);
    }
    while (1) {
        pause();
    }
    return 0;
}