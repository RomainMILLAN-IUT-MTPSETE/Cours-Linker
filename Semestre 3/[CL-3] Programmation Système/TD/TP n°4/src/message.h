#include <sys/types.h> 
#include <unistd.h>

#define BUFFER_SIZE 20

#define PATH_FORMAT "/tmp/client_%d_fifo"
#define FIFO_SERVEUR "/tmp/serveur_fifo"
#define TEMPLATE_CMD "echo '%s' | bc"

struct requete_client_serveur {
pid_t client_pid; //PID du Client
char expression[BUFFER_SIZE - 1]; //text de l expression a evaluer.
};