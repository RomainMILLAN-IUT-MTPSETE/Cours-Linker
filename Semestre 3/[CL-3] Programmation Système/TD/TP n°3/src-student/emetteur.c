
#include <signal.h>
#include "morse.h"
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>

//une attente pour temporiser les envois de signaux
#define WAIT usleep(500)

//fonction pour affichaer l usage de ce programme
void usage();
//envoyer un point Morse
void point();

//envoyer un tiret Morse
void tiret();

//envoyer un separateur de lettre
void espace_lettre();
//envoyer un separateur de mot
void espace_mot();
//envoyer une fin de transmission
void fin_tramsmission();

//envoyer un separateur simple (un silence)
void espace_symbole();

//envoyer une seule lettre en morse
void envoyer_lettre(char l);

//envoyer un message en morse
void envoyer_message(const char *msg);

//gestion de la fin de la communication avant de quitter
static int transmission_terminee = 0;

//le pid du destinataire
static int pid_destination;

//le main...
void main(int argc, char **argv)
{

    if (argc < 3) // pas assez d arguments
    {
        usage();
        exit(0);
    }

    pid_destination = atoi(argv[1]); //decoder le PID

    //iteration sur les arguments restants qui sont le texte a transmettre
    for (int i = 2; i < argc; i++)
    {
        envoyer_message(argv[i]);
        WAIT;
        if (i < argc - 1) // si ce n est pas le dernier mot
        {
            espace_mot(); // envoyer un separateur de mots
        }
        WAIT;
    }

    if (transmission_terminee == 0) // cas ou l utilisateur a oublie le . pour terminer le message
    {
        espace_mot(); // terminer avec un separateur du mots pour assurer un dernier silence long.
        fin_tramsmission();
    }

    printf("Message transmis. Ctr^C pour terminer le programme.\n");
    pause();
}

void usage()
{
    printf("emetteur <PID> <mot 1> <mot 2> <mot n> .\n");
};

void envoyer_message(const char *msg)
{
    printf("mot a envoyer '%s'\n", msg);
    int length = strlen(msg);
    for (int i = 0; i < length; i++)
    {
        char lettre = msg[i];
        switch (lettre)
        {
        case ' ':
            espace_mot();
            WAIT;
            break;
        case '.':
            fin_tramsmission();
            return;
        default:
            envoyer_lettre(lettre);
            if (i < length - 1)
            {
                espace_lettre();
            }
            break;
        }
    }
};

void point()
{
    kill(pid_destination, SIGUSR2);
    WAIT;
};
void tiret()
{
    for (int i = 0; i < 3; i++)
    {
        kill(pid_destination, SIGUSR2);
        WAIT;
    }
};

void espace_symbole()
{
    kill(pid_destination, SIGUSR1);
    WAIT;
}

void espace_lettre()
{
    for (int i = 0; i < 3; i++)
    {
        kill(pid_destination, SIGUSR1);
        WAIT;
    };
}
void espace_mot()
{
    for (int i = 0; i < 7; i++)
    {
        kill(pid_destination, SIGUSR1);
        WAIT;
    }
};
void fin_tramsmission()
{

    if (transmission_terminee == 0)
    {
        transmission_terminee = 1;
        kill(pid_destination, SIGHUP);
        WAIT;
    }
};

void envoyer_lettre(char l)
{
    if (l >= 'a' && l <= 'z')
    {
        int position = l - 'a';
        const char *code = code_morse[position];
        int codelen = strlen(code);
        for (int i = 0; i < codelen; i++)
        {
            char symb = code[i];
            switch (symb)
            {
            case '.':
            {
                point();
                break;
            }
            case '-':
            {
                tiret();
                break;
            }
            }
            //si ce n est pas le dernier symbole il faut envoyer un separateur de symbole
            if (i < codelen - 1)
            {
                espace_symbole();
            }
        }
    }
    else
    {
        printf("Caractere %c non envoye.\n", l);
    }
};
