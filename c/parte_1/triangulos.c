#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    float l1, l2, l3;
    printf("Entre com os lados do triângulo: ");
    scanf("%f%f%f", &l1, &l2, &l3);
    printf("Triângulo ");
    if ( (l1+l2) <= l3 || (l2+l3) <= l1 || (l3+l1) <= l2 ) {
        printf("inválido\n");
    } else if ( l1 == l2 && l2 == l3 ) {
        printf("equilátero\n");
    } else if ( l1 == l2 || l2 == l3 || l3 == l1 ) {
        printf("isósceles\n");
    } else {
        printf("escaleno\n");
    }
    return EXIT_SUCCESS;
}