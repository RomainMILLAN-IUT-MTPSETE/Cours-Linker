#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <strings.h>
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

    if(listen(sock, 3) == -1){ perror("listen"); exit(1);}
    //?? // mise a l ecoute

    // boucle sans fin pour la gestion des connexions
    while(1)
    { // attente connexion client
        printf("En attente d'un client\n");

        socket2 = accept(sock, (struct sockaddr *)&local, &lg);
        //??
        printf("Client connecté\n");
        strcpy(mess, "");
        while (strncmp(mess, "fin", 3) != 0) {
            read(socket2, mess, 80);
            printf("le client me dit: %s \n", mess);

            printf("Ma réponse: \n");
            gets(mess);

            write(socket2, mess, 80);
        }
        printf("Client déconnecté");
        //close(socket2); // on lui ferme la socket
    }
}