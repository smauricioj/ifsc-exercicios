#include <stdio.h>
#include <stdlib.h>

#define N 10

int main()
{
    int seq[N], a, b;
    printf("Entre com os termos iniciais: ");
    scanf("%d %d", &seq[0], &seq[1]);
    printf("Entre com os coeficientes: ");
    scanf("%d %d", &a, &b);
    printf("Sequência:");
    for (int i = 0; i < N; i++) {
        if (i > 1) {
            seq[i] = (a * seq[i - 1]) + (b * seq[i - 2]);
        }
        printf(" %d", seq[i]);
    }
    printf("\n");
    return EXIT_SUCCESS;
}