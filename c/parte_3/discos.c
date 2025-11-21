#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

typedef struct
{
    float x;
    float y;
} Ponto;

typedef struct {
    Ponto centro;
    float raio;
} Disco;

float distancia(Ponto p1, Ponto p2)
{
    float dx = p1.x - p2.x;
    float dy = p1.y - p2.y;
    return sqrtf((dx * dx) + (dy * dy));
}

bool sobrepoem(Disco c1, Disco c2)
{
    return distancia(c1.centro, c2.centro) < (c1.raio + c2.raio);
}

int main()
{
    Disco c1, c2;
    printf("Entre com o centro do disco 1: ");
    scanf("%f %f", &c1.centro.x, &c1.centro.y);
    printf("Entre com o raio do disco 1: ");
    scanf("%f", &c1.raio);
    printf("Entre com o centro do disco 2: ");
    scanf("%f %f", &c2.centro.x, &c2.centro.y);
    printf("Entre com o raio do disco 2: ");
    scanf("%f", &c2.raio);
    printf("Os discos %sse sobrepõem", sobrepoem(c1, c2) ? "" : "não ");
    return EXIT_SUCCESS;
}