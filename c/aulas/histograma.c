#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N_LADOS 10
#define N_DADOS 3

int main()
{
    srand(time(NULL));

    int num_rolagens, tamanho_histograma = N_LADOS * N_DADOS - (N_DADOS - 1);
    float hist[tamanho_histograma] = {};

    do {
        printf("Entre com o número de rolagens: ");
        scanf("%d", &num_rolagens);
    } while (num_rolagens <= 0);

    for (int i = 0; i < num_rolagens; i++) {
        hist[N_DADOS * (rand() % N_LADOS)] += 1;
    }

    for (int i = 0; i < tamanho_histograma; i++) {
        printf("%d : %.2f%%\n", i + N_DADOS, 100 * hist[i] / num_rolagens);
    }
    return EXIT_SUCCESS;
}