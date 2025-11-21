#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    float valorNegociado, taxaCorretagem;
    printf("Entre com o valor negociado: ");
    scanf("%f", &valorNegociado);
    if (valorNegociado < 0) {
        taxaCorretagem = 0;
    } else if (valorNegociado < 2500) {
        taxaCorretagem = 30 + (valorNegociado * 1.7) / 100;
    } else if (valorNegociado < 6250) {
        taxaCorretagem = 56 + (valorNegociado * 0.66) / 100;
    } else if (valorNegociado < 20000) {
        taxaCorretagem = 76 + (valorNegociado * 0.34) / 100;
    } else if (valorNegociado < 50000) {
        taxaCorretagem = 100 + (valorNegociado * 0.22) / 100;
    } else if (valorNegociado < 500000) {
        taxaCorretagem = 155 + (valorNegociado * 0.11) / 100;
    } else {
        taxaCorretagem = 255 + (valorNegociado * 0.09) / 100;
    }
    taxaCorretagem = (taxaCorretagem < 39) ? 39 : taxaCorretagem;
    printf("Taxa de corretagem: $%.2f", taxaCorretagem);
    return EXIT_SUCCESS;
}