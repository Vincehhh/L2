#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/file.h>

int main(int argc, char *argv[]) {

    if (argc!=3) {
        printf("Veuillez entrer un nom de fichier et le contenu à écrire\n");
        exit(-1);
    }

    /*

    - si existant : ouverture 
    - si inexistant : erreur 

    */

    int fd = open(
        argv[1],
        O_WRONLY | O_APPEND
    );

    if (fd == - 1) {
        perror("Ouverture du fichier");
        exit(-1);
    }

    // calcul de la longueur de la chaine argv[2]
    //(il est également possible d'utiliser strlen)
    int longueur = 0;
    while(argv[2][longueur]!=0) {
        longueur = longueur + 1;
    }

    // écriture d'argv[2] dans le fichier
    write(fd, argv[2], longueur);

    close(fd);
}
