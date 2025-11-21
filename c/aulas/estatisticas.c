#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX 100

typedef struct {
    float media, min, max;
} Estatisticas;

Estatisticas calcula_estatisticas(int n, float e[])
{
    Estatisticas stats = {0, INFINITY, -INFINITY};
    for (int i = 0; i < n; i++) {
        stats.media += e[i];
        if (e[i] < stats.min) {
            stats.min = e[i];
        }
        if (e[i] > stats.max) {
            stats.max = e[i];
        }
    }
    stats.media /= n;
    return stats;
}

int main()
{
    int numero;
    float elementos[MAX];

    do {
        printf("Entre com o número de elementos (máx %d): ", MAX);
        scanf("%d", &numero);
    } while (numero <= 0);

    printf("Entre com os elementos: ");
    for (int i = 0; i < numero; i++) {
        scanf("%f", &elementos[i]);
    }

    Estatisticas e = calcula_estatisticas(numero, elementos);
    printf("Média: %g\n", e.media);
    printf("Mínimo: %g\n", e.min);
    printf("Máximo: %g\n", e.max);
    return EXIT_SUCCESS;
}