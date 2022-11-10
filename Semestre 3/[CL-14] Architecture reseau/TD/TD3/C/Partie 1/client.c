#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <strings.h>
#include <netdb.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/types.h>
#include <unistd.h>

#define SERV "172.16.21.204"
#define PORT 12345

int port,sock;
char mess[80];

struct sockaddr_in serv_addr; // zone adresse
struct hostent *server; // nom serveur

void creer_socket() {
    port = PORT;
    server = gethostbyname(SERV);
    if(!server){
        fprintf(stderr, "Problème serveur \"%s\"\n", SERV);
        exit(1);
    }
    //creation socket locale
    sock = socket(AF_INET, SOCK_STREAM, 0);

    bzero(&serv_addr, sizeof (serv_addr));
    serv_addr.sin_family=AF_INET;
    bcopy(server->h_addr, &serv_addr.sin_addr.s_addr,server->h_length);
    serv_addr.sin_port= htons(port);
}

main() {
    // creation socket
    creer_socket();

    //connexion au serveur
    if(connect(sock, (struct sockaddr *)&serv_addr, sizeof (serv_addr)) < 0){
        perror("Connexion impossible:");
        exit(1);
    }
    printf("Connexion avec le serveur ok\n");
    //dialogue avec le serveur
    strcpy(mess, "");
    while(strncmp(mess, "fin", 3) != 0)
    { // attente connexion client
        printf("Question: \n");
        gets(mess);

        write(sock,mess,80);
        read(sock,mess,80);
        printf("Reponse: %s\n", mess);

    }
    close(sock); // on lui ferme la socket

}