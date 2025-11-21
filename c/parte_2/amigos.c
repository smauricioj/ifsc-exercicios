#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int soma_divisores(int n)
{
    int soma = 1;
    for (int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
            soma += i;
        }
    }
    return soma;
}

bool sao_amigos(int a, int b)
{
    return (b == soma_divisores(a) && a == soma_divisores(b));
}

int main()
{
    int x, y;
    printf("Entre com dois inteiros positivos: ");
    scanf("%d %d", &x, &y);
    printf("Os números %d e %d %ssão amigos", x, y, sao_amigos(x, y) ? "" : "não ");
    return EXIT_SUCCESS;
}