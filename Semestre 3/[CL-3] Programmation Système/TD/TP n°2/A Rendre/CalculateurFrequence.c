	#include <unistd.h>
	#include <stdio.h>
	#include <string.h>
	#include <stdint.h>
	#include <time.h>
	#include <stdlib.h>

	int main(void) {

		while(1) {
            char tabLettres[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			char command[30];
            char *args;
			char tabNbLt[26];

	      printf("Commande: "); //Printf "Commande: "
	      fgets(command, sizeof(command), stdin);  // récupère la ligne saisie par l'utilisateur
	      command[strcspn(command, "\n")] = 0; //annule le retour à la ligne automatique engendré par la fonction fgets()
	      args = strtok (command, " "); //récupère tous les arguments de listeArgument

          while(args != NULL){
              for(int i=0; i<sizeof(args); i++){
                  printf("%s\n", &args[i]);
              }
              /*for(int i=1; i<sizeof(args); i++){
                  for(int j=0; j<sizeof(tabLettres); j++){
                      if(strcmp(args[i], tabLettres[j]) == 0){
                          //tabNbLt[j]++;
                          printf("Oki");
                      }
                  }
              }*/


              args = strtok(NULL, " ");
          }

            /*for(int i=0; i<sizeof(tabNbLt); i++){
                printf("tabNbLt[%d]: %d", i, &tabNbLt[i]);
            }*/

	      /*int i = 0;

	      printf("%x", sizeof(listeArgument));

	      while (i <= sizeof(args)) {

	      	if (args[i]=='a') {
	      		tableauNbCaractere[0]++;
	      	}
	      	else if (args[i]=='b') {
	      		tableauNbCaractere[1]++;
	      	}
	      	else if (args[i]=='c') {
	      		tableauNbCaractere[2]++;
	      	}
	      	else if (args[i]=='d') {
	      		tableauNbCaractere[3]++;
	      	}
	      	else if (args[i]=='e') {
	      		tableauNbCaractere[4]++;
	      	}
	      	else if (args[i]=='f') {
	      		tableauNbCaractere[5]++;
	      	}
	      	else if (args[i]=='g') {
	      		tableauNbCaractere[6]++;
	      	}
	      	else if (args[i]=='h') {
	      		tableauNbCaractere[7]++;
	      	}
	      	else if (args[i]=='i') {
	      		tableauNbCaractere[8]++;
	      	}
	      	else if (args[i]=='j') {
	      		tableauNbCaractere[9]++;
	      	}
	      	else if (args[i]=='k') {
	      		tableauNbCaractere[10]++;
	      	}
	      	else if (args[i]=='l') {
	      		tableauNbCaractere[11]++;
	      	}
	      	else if (args[i]=='m') {
	      		tableauNbCaractere[12]++;
	      	}
	      	else if (args[i]=='n') {
	      		tableauNbCaractere[13]++;
	      	}
	      	else if (args[i]=='o') {
	      		tableauNbCaractere[14]++;
	      	}
	      	else if (args[i]=='p') {
	      		tableauNbCaractere[15]++;
	      	}
	      	else if (args[i]=='q') {
	      		tableauNbCaractere[16]++;
	      	}
	      	else if (args[i]=='r') {
	      		tableauNbCaractere[17]++;
	      	}
	      	else if (args[i]=='s') {
	      		tableauNbCaractere[18]++;
	      	}
	      	else if (args[i]=='t') {
	      		tableauNbCaractere[19]++;
	      	}
	      	else if (args[i]=='u') {
	      		tableauNbCaractere[20]++;
	      	}
	      	else if (args[i]=='v') {
	      		tableauNbCaractere[21]++;
	      	}
	      	else if (args[i]=='w') {
	      		tableauNbCaractere[22]++;
	      	}
	      	else if (args[i]=='x') {
	      		tableauNbCaractere[23]++;
	      	}
	      	else if (args[i]=='y') {
	      		tableauNbCaractere[24]++;
	      	}
	      	else if (args[i]=='z') {
	      		tableauNbCaractere[25]++;
	      	}

	      	i++;
	      }

	      i--;

	      int nbTot = i;

	      printf("nb total caracteres : %x", nbTot);

	      for (i = 0 ; i < sizeof(args) ; i++) {

	      	printf(" %s%x%d",tableauLettres[i], args[i], args[i]/nbTot + "%");

	      }
	       */

	  }

	}




