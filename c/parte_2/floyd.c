#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n_linhas, n = 1;
    printf("Entre com o número de linhas: ");
    scanf("%d", &n_linhas);
    for (int linha = 1; linha <= n_linhas; linha++) {
        printf("\n");
        for (int i = 0; i < linha; i++, n++) {
            printf("%d ", n);
        }
    }
    return EXIT_SUCCESS;
}