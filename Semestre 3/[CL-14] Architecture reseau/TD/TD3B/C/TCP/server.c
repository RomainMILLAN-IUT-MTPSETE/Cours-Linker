#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <strings.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <unistd.h>

#define PORT 12345
int sock, socket2, lg;
char mess[80];
struct sockaddr_in local; // champs d entete local
struct sockaddr_in distant; // champs d entete distant

void creer_socket() {
    // preparation des champs d entete
    bzero(&local, sizeof(local)); // mise a zero de la zone adresse
    local.sin_family = AF_INET; // famille d adresse internet
    local.sin_port = htons(PORT); // numero de port
    local.sin_addr.s_addr = INADDR_ANY; // types d adresses prises en charge
    bzero(&(local.sin_zero),8); // fin de remplissage


    lg = sizeof(struct sockaddr_in);
    if((sock = socket(local.sin_family, SOCK_STREAM, 0)) == -1){ perror("socket"); exit(1);}
    //?? // creation socket du serveur mode TCP/IP
    if(bind(sock, (struct sockaddr *)&local, sizeof(struct sockaddr)) == -1){ perror("bind"); exit(1);}
    //?? // nommage de la socket
}

main() {
    // creation socket
    creer_socket();

    if(listen(sock, 2) == -1){ perror("listen"); exit(1);}
    // mise a l ecoute

    // boucle sans fin pour la gestion des connexions
    while(1){ // attente connexion client
        printf("En attente d'un client\n");
        int clt = 0;

        socket2 = accept(sock, (struct sockaddr *)&local, &lg);
        clt++;
        int i = fork();
        if(i == 0){
            //FILS
            printf("Client n°%i connecté\n", clt);
            strcpy(mess, "");
            while (strncmp(mess, "fin", 3) != 0) {
                read(socket2, mess, 80);
                printf("le client n°%i me dit: %s \n", clt, mess);

                printf("Ma réponse au client n°%i: \n", clt);
                gets(mess);

                write(socket2, mess, 80);
            }
            printf("Client n°%i déconnecté", clt);
            clt--;
            close(socket2);
            exit(1);
        }else {
            clt--;
        }
        //close(socket2); // on lui ferme la socket
    }
}