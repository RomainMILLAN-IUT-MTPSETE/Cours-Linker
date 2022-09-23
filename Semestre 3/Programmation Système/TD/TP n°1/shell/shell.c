//INCLUDES
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>

int main(void){

    //While inifinity
    while(1){
        //VARIABLES
        char command[300];
        char *args;
        char *cmd[10] = {NULL};
        int dowait = 0;

        printf("Commande: "); //Print 'Commande:'
        fgets(command, sizeof(command), stdin);  // read the command of the user
        command[strcspn(command, "\n")] = 0; //remove /n at the end of the commande because the fgets function add an /n at the end of the character tab.
        args = strtok (command, " "); //Explode the use command into multiple arguments.

        //When args is not NULL
        int i=0;
        while(args != NULL){
            //Put the argument in progress on a string character.
            cmd[i] = args;
            i++;
            //Past to the next argument
            args = strtok(NULL, " ");
        }

        if(strcmp(cmd[i-1], "&") == 0){
            dowait = 1;
            cmd[i-1] = NULL;
        }

        //Child creation
        pid_t pid = fork();
        if(pid == 0){
            //Child
            //Execution of the command
            execvp(cmd[0], cmd);
        }

        //If I do wait the child
        if(dowait == 0){
            //I wait the child
            waitpid(pid, NULL, 0);
        }
    }

    
}
