#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    unsigned long valor;
    printf("Entre com o termo inicial: ");
    scanf("%lu", &valor);
    if (valor == 0 || valor > 1000000) {
        return EXIT_SUCCESS;
    }
    printf("Sequência de Collatz: [%lu", valor);
    int count = 0;
    while (valor != 1) {
        count++;
        valor = (valor % 2 == 0) ? valor / 2 : (3 * valor) + 1;
        printf(", %lu", valor);
    }
    printf("]\n");
    printf("Número de passos: %d", count);
    return EXIT_SUCCESS;
}