#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(void){

    while(1){
        char command[300];
        char *args;
        char **cmd;
        printf("Commande: ");
        fgets(command, sizeof(command), stdin);  // read the command

        args = strtok (command, " "); //Get all arguments by the command
        while(args != NULL){
            char *cmdargs;
            printf("%s\n", &args[0]);
            args = strtok(NULL, " ");
        }

        execv("./" + &args[0], NULL);
        // example.out => ./example.out
        // example.out txt.txt => ./example.out

        execl("ps", "ps", "-l", NULL);

        
        return 0;
    }

    
}
