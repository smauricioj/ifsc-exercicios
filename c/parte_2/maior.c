#include <stdio.h>
#include <stdlib.h>

int main()
{
    int maior = -1, n_vezes = 0, valor;
    printf("Entre com inteiros positivos. Entre com 0 ou um inteiro negativo para terminar.\n");
    do {
        printf("> ");
        scanf("%d", &valor);
        if (valor > maior) {
            maior = valor;
            n_vezes = 1;
        } else if (valor == maior) {
            n_vezes++;
        }
    } while (valor > 0);
    printf("O maior inteiro foi %d, que ocorreu ", maior);
    if (n_vezes == 1) {
        printf("apenas uma vez.\n");
        return EXIT_SUCCESS;
    }
    printf("%d vezes.\n", n_vezes);
    return EXIT_SUCCESS;
}