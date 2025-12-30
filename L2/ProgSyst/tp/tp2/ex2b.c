/* Correction TP2 - exercice 2b */

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int nb_ligne;
    int nb_col;
    int **m;
} Matrice;

Matrice alloue_matrice(int nb_ligne, int nb_col) {
    Matrice mat;
    mat.nb_ligne = nb_ligne;
    mat.nb_col = nb_col;
    mat.m = malloc(nb_ligne * sizeof(int *)); // allocation de nb_ligne lignes
    for(int i=0;i<nb_ligne;i++) {
        mat.m[i] = malloc(nb_col * sizeof(int));  // allocation de nb_col entiers
        for(int j=0;j<nb_col;j++) {
            mat.m[i][j] = 0;
        }
    }
    return mat;
}

void libere_matrice(Matrice mat) {
    for(int i=0;i<mat.nb_ligne;i++) {
        free(mat.m[i]);
    }
    free(mat.m);
}

void affiche_matrice(Matrice mat) {
    for(int i=0;i<mat.nb_ligne;i++) {
        for(int j=0;j<mat.nb_col;j++) {
            printf("%d ", mat.m[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

Matrice multiplie_matrice(Matrice m1, Matrice m2) {
    Matrice resultat = alloue_matrice(m1.nb_ligne, m2.nb_col);
    for(int i=0;i<m1.nb_ligne;i++) {
        for(int j=0;j<m2.nb_col;j++) {
            int c = 0;
            for(int k=0;k<m1.nb_col;k++) {
                c = c + m1.m[i][k] * m2.m[k][j];
            }
            resultat.m[i][j] = c;
        }
    }
    return resultat;
}

int main() {

    for(int i=0;i<2000000;i++) {
        Matrice m = alloue_matrice(10, 10);
        libere_matrice(m);
    }

    printf("fin\n");
    getchar();
}
