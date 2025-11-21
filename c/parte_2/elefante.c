#include <stdio.h>
#include <stdlib.h>

#define MAX_ELEFANTES 10

void imprime(int n)
{
    switch (n) {
        case 1: printf("Um"); break;
        case 2: printf("Dois"); break;
        case 3: printf("Três"); break;
        case 4: printf("Quatro"); break;
        case 5: printf("Cinco"); break;
        case 6: printf("Seis"); break;
        case 7: printf("Sete"); break;
        case 8: printf("Oito"); break;
        case 9: printf("Nove"); break;
        case 10: printf("Dez"); break;
        default: break;
    }
}

int main()
{
    for (int n = 1; n <= MAX_ELEFANTES; n++) {
        if (n % 2 != 0) {
            imprime(n);
            printf(" elefante%s incomoda%s muita gente.\n", (n > 1) ? "s" : "", (n > 1) ? "m" : "");
            continue;
        }
        imprime(n);
        printf(" elefantes ");
        for (int i = 1; i <= n; i++) {
            printf("incomodam");
            if (i != n) {
                printf(", ");
            }
        }
        printf(" muito mais!\n");
    }
    for (int n = MAX_ELEFANTES; n >= 1; n--) {
        if (n % 2 == 0) {
            imprime(n);
            printf(" elefantes incomodam muita gente.\n");
            continue;
        }
        imprime(n);
        printf(" elefante%s ", (n > 1) ? "s" : "");
        for (int i = 1; i <= n; i++) {
            printf("incomoda%s", (n > 1) ? "m" : "");
            if (i != n) {
                printf(", ");
            }
        }
        printf(" muito menos!\n");
    }
    return EXIT_SUCCESS;
}