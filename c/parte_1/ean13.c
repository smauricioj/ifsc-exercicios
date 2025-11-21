#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12;
    printf("Entre com a primeira parte (1 dígito): ");
    scanf("%1d", &d1);
    printf("Entre com a segunda parte (6 dígitos): ");
    scanf("%1d%1d%1d%1d%1d%1d", &d2, &d3, &d4, &d5, &d6, &d7);
    printf("Entre com a terceira parte, sem o dígito verificador (5 dígitos): ");
    scanf("%1d%1d%1d%1d%1d", &d8, &d9, &d10, &d11, &d12);

    int soma1 = d1 + d3 + d5 + d7 + d9 + d11;
    int soma2 = d2 + d4 + d6 + d8 + d10 + d12;
    int soma3 = (3*soma2) + soma1 - 1;
    int digito = soma3 % 10;
    int d13 = 9 - digito;

    printf("Dígito verificador: %d", d13);

    return EXIT_SUCCESS;
}