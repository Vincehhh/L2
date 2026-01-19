#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

const int nb_processus = 10;

int main() {

    for(int i=0;i<nb_processus;i++) {
        int pid=fork();
 
        if (pid==0) {

            // processus fils
            int borne1 = 1+i*100;
            int borne2 = (i+1)*100;

            // i=0 => 1 à 100
            // i=1 => 101 à 200  
            // i=2 => 201 à 300  
            //   ...
            // i=9 => 901 à 1000  

            int somme = 0;
            for(int j=borne1;j<=borne2;j++) somme = somme + j;
            printf("La somme de %d à %d est %d (pid=%d)\n", borne1, borne2, somme, getpid());

            sleep(3);

            exit(0);
        } else {
            printf("creation du processus %d\n", pid);
        }
    }

    for(int i=0;i<nb_processus;i++) {
        pid_t pid_fils = wait(NULL);
        printf("Terminaison du processus fils %d\n", pid_fils);
    }

    printf("Tous les processus fils sont terminés\n");
}
