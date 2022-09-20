#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>


int main(int argc, char **argv){
    if(argc < 2){
        printf("Nombre d'argument invalide");
        exit(1);
    }

    //int fdw;
    //fdw = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC);
    //fprintf(stdout, "Hello World");

    int fd, szfd, sz;
    char *b;
    fd = open(argv[1], O_RDWR | O_APPEND | O_CREAT | O_TRUNC);

    if (fd < 0) {
        exit(1);
    }

    /*b = malloc(sizeof(char) * 11);
        
        do {
            sz = read(fd, b, 1);
            b[sz] = '\0';
            printf("lu: %s\n", b);
        } while (sz == 1);
*/
    char d[300];
    printf("Entrez une valeur\n");
    scanf("%s", d);
    printf("Result: %s", d);
    
    /*printf("Votre valeur est ");
    puts(d);*/

    if(argc > 2){
        b = malloc(sizeof(char) * 11);
        
        do {
            sz = read(fd, b, 1);
            b[sz] = '\0';
            printf("lu: %s\n", b);
        } while (sz == 1);

        write(fd, d, sizeof(d));
    }else {
        write(fd, d, 10);
    }

    close(fd);


    return 0;
}