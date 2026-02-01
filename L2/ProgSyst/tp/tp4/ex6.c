#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <sys/file.h>

char nom_fichier[] = "fic2";

int main() {

    int fd = open(
        nom_fichier,
        O_WRONLY | O_CREAT | O_EXCL,
        S_IRUSR | S_IWUSR | S_IRGRP
    );

    if (fd == - 1) {
        perror("Erreur à la création du fichier");
        exit(-1);
    }

    unsigned char c;
    int i;

    off_t pos = lseek(fd, 768, SEEK_SET);
    if (pos == -1) perror("lseek");

    for(i=0;i<256;i++) {
        c=(char)i;
        write(fd, &c, 1);
    }

    close(fd);
}
