#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>

int main(void){

    while(1){
        char command[300];
        char *args;
        char *cmd[10] = {NULL};
        int dowait = 0;

        printf("Commande: "); //Print 'Commande:'
        fgets(command, sizeof(command), stdin);  // read the command
        command[strcspn(command, "\n")] = 0; //remove /n at the end
        args = strtok (command, " "); //Get all arguments by the command

        //Tant que args et différent de NULL
        int i=0;
        while(args != NULL){
            //id args is '&'
            if(strcmp(&args[0], "&") == 0){
                //To dowait to 1
                dowait = 1;
            }else {
                //Put in cmd tab the args
                cmd[i] = args;
                i++;
            }
            //Pass to next argument
            args = strtok(NULL, " ");
        }

        //Child creation
        pid_t pid = fork();
        if(pid == 0){
            //Child
            execvp(cmd[0], cmd);
        }

        //if do wait
        if(dowait == 0){
            //Wait
            waitpid(pid, NULL, 0);
        }
    }

    
}
