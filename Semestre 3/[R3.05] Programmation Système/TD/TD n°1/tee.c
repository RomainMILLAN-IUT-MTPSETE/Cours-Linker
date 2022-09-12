#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>


int main(int argc, char **argv){
    if(argc != 2){
        printf("Nombre d'argument invalide");
        //exit(1);
    }

    //int fdw;
    //fdw = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC);
    //fprintf(stdout, "Hello World");

    int fdw, szfdw, sz;
    fdw = open(argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0644);

    if(fdw < 0){
        if(errno = ENOENT){
            perror(argv[1]);
        }
        exit(1);
    }

    char d[100];
    printf("Entrez une valeur\n");
    gets(d);
    sz = sizeof(d);
    
    printf("Votre valeur est ");
    puts(d);

    szfdw = write(fdw, d, sz);

    close(fdw);


    return 0;
}