#include <stdio.h>

#define LEN 54

int main(int argc, char *argv[]) {

  unsigned char cle = 0b11001011;

  unsigned char msg[LEN] = { 233, 251, 74, 126, 207, 28, 145, 151, 174, 227, 3, 126, 223, 94, 151, 150, 191, 183, 94, 43, 155, 16, 158, 197, 165, 176, 86, 126, 221, 89, 147, 144, 168, 226, 65, 126, 213, 23, 149, 151, 174, 243, 70, 59, 210, 13, 210, 150, 174, 244, 93, 59, 200, 91 };

  for(int i=0;i<LEN;i++) {
    // décodage du i eme caractère
    unsigned char x = msg[i] ^ cle;
    printf("%c", x);

    // transformation de la clé (pour le décodage du caractère suivant)
    if (cle & 0b10000000) {
      // le bit le + à gauche de cle est à 1
      cle = (cle << 1) | 0b00000001;
    } else {
      // le bit le + à gauche de cle est à 0
      cle = cle << 1;
    }

  }
  printf("\n");

}
