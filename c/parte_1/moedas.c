#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int quant, moedas;
    printf("Entre com a quantidade de centavos: ");
    scanf("%d", &quant);
    moedas = quant / 50;
    quant = quant % 50;
    printf("Moedas de 50 centavos: %d\n", moedas);
    moedas = quant / 25;
    quant = quant % 25;
    printf("Moedas de 25 centavos: %d\n", moedas);
    moedas = quant / 10;
    quant = quant % 10;
    printf("Moedas de 10 centavos: %d\n", moedas);
    moedas = quant / 5;
    quant = quant % 5;
    printf("Moedas de 5 centavos: %d\n", moedas);
    printf("Moedas de 1 centavo: %d\n", quant);
    return EXIT_SUCCESS;
}