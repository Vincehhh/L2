#include <stdio.h>

// compter et afficher le nombre de caractère du premier argument en ligne de commande

int main(int argc, char *argv[]) {

    if (argc < 2) {
        printf("Pas d'argument en ligne de commande\n");
        return -1;
    }

    int len = 0;
    while(argv[1][len] != 0) {
        len++;
    }

    printf("longueur = %d\n", len);

    return 0;
}
