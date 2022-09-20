#include <sys/types.h>
#include <unistd.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

// taille du tableau de requêtes
#define TAILLE_FILE 10

// une structure pour la requete et le resultat
typedef struct
{
    float operand1;
    float operand2;
    float resultat;
    char operation; // '+' '*' '/' '-'
} requete_t;

// simulateur du calculateur
float simulateur_calcul(float op1, float op2, char operation)
{
    float result;
    switch (operation)
    {
    case '+':
        sleep(1);
        result = op1 + op2;
        break;
    case '-':
        sleep(1);
        result = op1 - op2;
        break;
    case '*':
        sleep(2);
        result = op1 * op2;
        break;
    case '/':
        sleep(3);
        result = op1 / op2;
        break;
    default:
        sleep(1);
        result = 0;
        break;
    }
    return result;
}

// les opérations arithmétiques
#define NUMBER_OPS 4
char operations[NUMBER_OPS] = {
    '+',
    '-',
    '*',
    '/',
};
// tableau des commandes à faire
requete_t requetes_tab[TAILLE_FILE];

void initialisation()
{
    srand((unsigned int)time(NULL));
}

// retourne un nombre float random entre 0 et a
float random_float(float a)
{
    return ((float)rand() / (float)(RAND_MAX)) * a;
}
// fonction pour remplir le tableau des opérations
int remplir_les_commandes()
{
    for (int i = 0; i < TAILLE_FILE; i++)
    {
        requetes_tab[i].operation = operations[rand() % NUMBER_OPS];
        requetes_tab[i].operand1 = random_float(1.0);
        requetes_tab[i].operand2 = random_float(1.0);
    }
}

int main(int argc, char **argv)
{
    initialisation();
    remplir_les_commandes();
    // traitement
    for (int i = 0; i < TAILLE_FILE; i++)
    {
        requetes_tab[i].resultat = simulateur_calcul(requetes_tab[i].operand1,
                                                     requetes_tab[i].operand2,
                                                     requetes_tab[i].operation);
    }

    // affichage des résultats
    for (int i = 0; i < TAILLE_FILE; i++)
    {
        printf("%f %c %f = %f\n", requetes_tab[i].operand1,
               requetes_tab[i].operation,
               requetes_tab[i].operand2,
               requetes_tab[i].resultat);
    }
    exit(0);
}