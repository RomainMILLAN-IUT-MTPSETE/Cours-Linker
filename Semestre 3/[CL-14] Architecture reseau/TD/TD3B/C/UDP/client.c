// Client side implementation of UDP client-server model
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
    char mess[80];
	struct sockaddr_in	 servaddr;
	
	// Creating socket file descriptor
	if ((sockfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) {
		perror("Error lors de la création du SOCKET");
		exit(EXIT_FAILURE);
	}
	
	bzero(&servaddr, sizeof(servaddr));
		
	// Filling server information
	servaddr.sin_family = AF_INET;
	servaddr.sin_port = htons(PORT);
	servaddr.sin_addr.s_addr = INADDR_ANY;
		
	int n, len;
    while(strncmp(mess, "fin", 3) != 0)
    { 
        printf("Entre ton texte: \n");
        gets(mess);

        sendto(sockfd, (const char *)mess, strlen(mess), MSG_CONFIRM, (const struct sockaddr *) &servaddr,  sizeof(servaddr)); 
        printf("Message envoyé.\n");
                
        if(strncmp(mess, "fin", 3) != 0){
            n = recvfrom(sockfd, (char *)buffer, 80, 0, (struct sockaddr *) &servaddr, &len);
            buffer[n] = '\0';
            printf("Serveur : %s\n", buffer);
        }
    }
	
	close(sockfd);
	return 0;
}
