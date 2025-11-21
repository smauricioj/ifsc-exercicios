#include <stdio.h>
#include <stdlib.h>

float maximo(float x, float y)
{
    return (x > y) ? x : y;
}

float media(float x, float y, float z)
{
    return (x + y + z) / 3;
}

int arredonda(float x)
{
    return (int)(x + 0.5);
}

int main()
{
    float p1, r1;
    printf("Entre com P1 e R1: ");
    scanf("%f %f", &p1, &r1);
    float p2, r2;
    printf("Entre com P2 e R2: ");
    scanf("%f %f", &p2, &r2);
    float p3, r3;
    printf("Entre com P3 e R3: ");
    scanf("%f %f", &p3, &r3);
    float freq;
    printf("Entre com a frequência (%%): ");
    scanf("%f", &freq);
    int resultado = (freq >= 75) ? arredonda(media(
                                       maximo(p1, r1),
                                       maximo(p2, r2),
                                       maximo(p3, r3)))
                                 : 0;
    printf("Resultado final: %d\n", resultado);
    printf("Situação: %s\n", (resultado >= 6) ? "aprovado" : "reprovado");
    return EXIT_SUCCESS;
}