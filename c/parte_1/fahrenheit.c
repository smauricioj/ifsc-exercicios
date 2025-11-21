#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    float fahr;
    printf("Entre com a temperatura em Fahrenheit: ");
    scanf("%f", &fahr);
    printf("Temperatura em Celsius: %.1f", (5*(fahr - 32))/9);
    return EXIT_SUCCESS;
}