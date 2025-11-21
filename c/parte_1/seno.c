#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define PI 3.14159253

float eq(float x)
{
    return (4 * x * (180 - x)) / (40500 - (x * (180 - x)));
}

float seno_bhaskara(float x)
{
    return (x <= 180) ? eq(x) : (-1) * eq(360 - x);
}

float seno_real(float x)
{
    return sin(PI * x / 180);
}

int main()
{
    float angulo;
    printf("Entre com o valor do ângulo em graus: ");
    scanf("%f", &angulo);
    printf("Valor aproximado do seno: %.4f\n", seno_bhaskara(angulo));
    printf("Valor real do seno: %.4f\n", seno_real(angulo));
    return EXIT_SUCCESS;
}