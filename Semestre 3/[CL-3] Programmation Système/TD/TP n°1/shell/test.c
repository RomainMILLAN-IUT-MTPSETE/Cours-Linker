#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

int main()
{

    char command[300];
    char *args;
    char *cmd[10] = {NULL};
    int dowait = 0;

    printf("Commande: ");
    //scanf("%s", command);
    fgets(command, sizeof(command), stdin);  // read the command
    command[strcspn(command, "\n")] = 0; //remove /n at the end
    args = strtok (command, " "); //Get all arguments by the command

    //Tant que args et différent de NULL
    int i=0;
    while(args != NULL){
        if(strcmp(&args[0], "&") == 0){
            dowait = 1;
        }else {
            printf("%d = %s", i, args);
            cmd[i] = args;
            i++;
        }
        args = strtok(NULL, " ");
    }

}