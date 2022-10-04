#include <sys/types.h>
#include <unistd.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

// taille du tableau de requêtes
#define TAILLE_FILE 20
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
//========Les activités========================
// structure pour les parametres d une activite de calcul
typedef struct argument_calcul_t
{
    int index_debut;
    int index_fin;
    int step;
} argument_calcul_t;
// activite de calcul
void *activite_calculateur(void *arg)
{
    printf("thread[%ld] lance\n", pthread_self());
    argument_calcul_t *data = (argument_calcul_t *)arg;
    for (int i = data->index_debut; i < data->index_fin; i = i +
                                                             data->step)
    {
        requetes_tab[i].resultat =
            simulateur_calcul(requetes_tab[i].operand1,
                              requetes_tab[i].operand2,
                              requetes_tab[i].operation);
    }
    printf("thread[%ld] fin\n", pthread_self());
}
// affichage des resultats
void *activite_affichage(void *arg)
{
    for (int i = 0; i < TAILLE_FILE; i = i + 1)
    {
        printf("%f %c %f = %f\n", requetes_tab[i].operand1,
               requetes_tab[i].operation,
               requetes_tab[i].operand2,
               requetes_tab[i].resultat);
    }
    fflush(stdout);
}
// affichage d une animation
void *activite_attente(void *arg)
{
    char anim[4] = {'/', '-', '\\', '|'};
    int i = 0;
    while (1)
    {
        printf("\033[1D"); // demande au terminal de deplacer le curseur une case a gauche
        printf("%c", anim[i]);
        i = (i + 1) % 4;
        fflush(stdout);
        sleep(1);
    }
}
//=============================================
int main(int argc, char **argv)
{
    initialisation();

    remplir_les_commandes();
    // traitement
    pthread_t thread_calcul_id;
    // calcul de 0 à TAILLE par pas de 1
    argument_calcul_t parametre_calcul;
    parametre_calcul.index_debut = 0;
    parametre_calcul.index_fin = TAILLE_FILE;
    parametre_calcul.step = 1;
    pthread_create(&thread_calcul_id, NULL,
                   activite_calculateur, &parametre_calcul);
    // une activite pour animer l'attente de l'utilisateur
    pthread_t thread_attente_id;
    pthread_create(&thread_attente_id, NULL, activite_attente, NULL);
    pthread_join(thread_calcul_id, NULL);
    // le calcul est pret nous devons annuler l affichage de l attente
    pthread_cancel(thread_attente_id);
    // affichage des résultats
    pthread_t thread_affichage_id;
    pthread_create(&thread_affichage_id, NULL,
                   activite_affichage, NULL);
    pthread_join(thread_affichage_id, NULL);
    exit(0);
}