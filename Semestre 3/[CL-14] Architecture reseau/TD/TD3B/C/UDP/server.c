// Server side implementation of UDP client-server model
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
	
#define PORT 12345
#define MSG_CONFIRM 0

	
// Driver code
int main() {
	int sockfd;
	char buffer[80];
	char *hello = "Salut du serveur";
    char mess[80];
	struct sockaddr_in servaddr, cliaddr;
		
	// Creating socket file descriptor
	if ( (sockfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) {
		perror("Erreur lors de la création du SOCKET");
		exit(EXIT_FAILURE);
	}
	
    bzero(&servaddr, sizeof(servaddr));
    bzero(&cliaddr, sizeof(cliaddr));
		
	// Filling server information
	servaddr.sin_family = AF_INET; // IPv4
	servaddr.sin_addr.s_addr = INADDR_ANY;
	servaddr.sin_port = htons(PORT);
		
	// Bind the socket with the server address
	if (bind(sockfd, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0 ){
		perror("Erreur BIND");
		exit(EXIT_FAILURE);
	}
	
    while(strncmp(mess, "fin", 3) != 0){
        int len = sizeof(cliaddr); //len is value/result
	
        int n = recvfrom(sockfd, (char *)buffer,80, 0, ( struct sockaddr *) &cliaddr,&len);
        buffer[n] = '\0';
        printf("Client : %s\n", buffer);

        printf("Entre ton texte: \n");
        gets(mess);
        sendto(sockfd, (const char *)mess, strlen(mess),MSG_CONFIRM, (const struct sockaddr *) &cliaddr,len);
        printf("Message Envoyé.\n");
    }
		
	return 0;
}
