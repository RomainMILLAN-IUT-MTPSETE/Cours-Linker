#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>

int main(){
    char *b;
    int fd, sz;
    b = malloc(sizeof(char) * 11);
    fd = open("txt.txt", O_RDONLY);
    if (fd < 0) {
        exit(1);
    }
    do {
        sz = read(fd, b, 1);
        b[sz] = '\0';
        printf("lu: %s\n", b);
    } while (sz == 1);
    close(fd);
}