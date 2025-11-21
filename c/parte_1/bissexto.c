#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int ano;
    printf("Entre com um ano: ");
    scanf("%d", &ano);
    bool bissexto = ((ano % 4 == 0) && ( (ano % 100 != 0) || (ano % 400 == 0) ));
    printf("Ano bissexto: %d", bissexto);
    return EXIT_SUCCESS;
}