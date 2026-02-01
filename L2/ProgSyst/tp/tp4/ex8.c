#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/file.h>
#include <ctype.h>

#define BUF_SIZE 32

int main(int argc, char *argv[]) {

   if (argc != 2) {
       printf("Veuillez indiquer le nom du fichier à examiner\n");
       exit(-1);
   }

    int fd = open(argv[1], O_RDONLY);
    if (fd == - 1) {
        perror(argv[1]);
        exit(-1);
    }

    char buf[BUF_SIZE];

    int texteUniquement = 1;
    int nbLu;
    
    do {
        nbLu = read(fd, buf, BUF_SIZE);
        if (nbLu == -1) {
            perror("read");
        } else if (nbLu>0) {
            for(int i=0;i<nbLu;i++) {
                if (!isspace(buf[i]) && !isprint(buf[i])) {
                    texteUniquement = 0;
                    break;
                }
            }
        }
    } while (nbLu>0 && texteUniquement);

    close(fd);

    if (texteUniquement) {
        execlp("more", "more", argv[1], NULL);
    } else {
        execlp("xxd", "xxd", argv[1], NULL);
    }

}
