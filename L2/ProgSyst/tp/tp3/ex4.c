#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

static int total = 0;

struct sigaction act1;

void traiter_signal(int signum) {
    printf("Total = %d\n", total);
    exit(0);
}

int main() {
    sigemptyset(&(act1.sa_mask));
    act1.sa_flags = 0;
    act1.sa_handler = traiter_signal;
    sigaction(SIGINT, &act1, NULL);

    int x;
    while(1) {
        scanf("%d", &x);
        total = total + x;
    }
}
