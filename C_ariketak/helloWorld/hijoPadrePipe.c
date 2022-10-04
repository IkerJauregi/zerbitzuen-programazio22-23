#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    int fd[2];
    pid_t pid;
    char saludoHijo[] = "Buenos dias padre";
    char buffer[80];
    // Creamos el pipe
    pipe(fd);
    // Creamos el proceso hijo
    pid = fork();

    switch (pid)
    {
    // En caso de error
    case -1:
        printf("No se a podido crear el hijo");
        exit(-1);
    // Aqui entrara el hijo
    case 0:
        close(fd[0]);
        //Escribimos en el pipe
        write(fd[1], saludoHijo, strlen(saludoHijo));
        printf("\t El HIJO envia algo al pipe.\n");
        break;
    default:
        // codigo
        close(fd[1]);
        // Esto lee el pipe
        read(fd[0], buffer, sizeof(buffer));
        printf("El padre recibe algo del pipe: %s \n", buffer);
        break;
    }
    return 0;
}