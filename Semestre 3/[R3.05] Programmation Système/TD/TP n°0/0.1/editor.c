#include <sys/stat.h>
#include <fcntl.h>
#include <ctype.h>
#include "util.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
/*
 * Programme d editeur en ligne de fichier avec read, write et lseek
 * Ce programme est une adapattion du programme de Michaed KerrisK, "The Linux Programming inTerface"
 *
 */

int main(int argc, char *argv[]){
 size_t len;
 off_t offset;
 int fd, ap, j;
 char *buf;
 size_t numRead, numWritten;

 // affichier le manuel d utilisation
 if (argc < 3 || strcmp(argv[1], "--help") == 0){
    printf("%s fichier {r<length>|w<string>|s<offset>}...\n", argv[0]);
 }

 //ouverture du fichier passe en parametre et obtention du descripteur
 fd = open( argv[1],  O_RDWR | O_CREAT,  S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH); /* rw-rw-rw- */

 if (fd == -1){
    printf("erreur ... open"); //erreur d ouverture
    exit(1);
 }

//interpreter toutes les commandes passees en parametre
 for (ap = 2; ap < argc; ap++){
 switch (argv[ap][0]){
    case 'r': /* affichier les caracteres du fichier*/
    len = strtol(&argv[ap][1],NULL,10); //recuperer le nombre d octects a lire
    buf = malloc(len); //allocation dynamique d un tableau de longueur len

    if (buf == NULL){
        printf("erreur ... malloc"); //erreur avec la creation de malloc
        exit(2);
    }

    //lecture de len octects
    numRead = read(fd, buf, len);

    //verifier que tout ok avec la lecture
    if (numRead == -1) {
        printf("erreur ... read");
        exit(3);
    }


    if (numRead == 0){ //la fin du fichier est atteinte
     printf("%s: fin-de-fichier\n", argv[ap]);
    }else{//lecture effective
        printf("%s: ", argv[ap]);

        for (j = 0; j < numRead; j++){
            //verifier que le caractere est imprimable
            if(isprint((unsigned char) buf[j])){
                printf("%c",buf[j]);
            }else{
                //afficher le code hexa sur deux caracteres
                printf("%02x ", (unsigned int) buf[j]);
            }
        }
        printf("\n");
    }

    free(buf); //liberer la memoire buf
    break; //sortir du cas du switch

    case 'w': /* Ecriture a l offset courant */

    numWritten = write(
    fd, //descripteur
    &argv[ap][1], //addresse de debut
    strlen(&argv[ap][1]) //longueur de la chaine
    );

    if (numWritten == -1){
        printf("erreur ... write");
        exit(4);
    }

    printf("%s: ecriture de %ld bytes\n", argv[ap], (long) numWritten);

    break; // fin de traitement du cas w

    case 's': /* deplacement du curseur d'un offset */

    offset = strtol(&argv[ap][1],NULL,10);
    if (lseek(fd, offset, SEEK_SET) == -1){
        printf("erreur ... lseek");
        exit(5);
    }
    printf("%s: deplacement du curseur reussi\n", argv[ap]);

    break; // fin du traitement

    default:
    printf("Erreur de commande. La commande doit commencer avec [rws]: %s\n", argv[ap]);
 }

 }
 exit(0);
}