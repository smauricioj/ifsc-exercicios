#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct
{
    float x;
    float y;
} Ponto;

int quadrante(Ponto p)
{
    if (p.x == 0 || p.y == 0) {
        return 0;
    } else if (p.y > 0 && p.x > 0) {
        return 1;
    } else if (p.y > 0 && p.x < 0) {
        return 2;
    } else if (p.y < 0 && p.x < 0) {
        return 3;
    } else {
        return 4;
    }
}

float distancia(Ponto p1, Ponto p2)
{
    float dx = p1.x - p2.x;
    float dy = p1.y - p2.y;
    return sqrtf((dx * dx) + (dy * dy));
}

Ponto ponto_medio(Ponto p1, Ponto p2)
{
    Ponto medio = {.x = (p1.x + p2.x) / 2, .y = (p1.y + p2.y) / 2};
    return medio;
}

int main()
{
    float x, y;
    printf("Entre com o ponto 1: ");
    scanf("%f %f", &x, &y);
    Ponto a = {.x = x, .y = y};
    printf("Entre com o ponto 2: ");
    scanf("%f %f", &x, &y);
    Ponto b = {.x = x, .y = y};
    printf("Quadrante do ponto 1: %d\n", quadrante(a));
    printf("Quadrante do ponto 2: %d\n", quadrante(b));
    printf("Distância: %g\n", distancia(a, b));
    Ponto c = ponto_medio(a, b);
    printf("Ponto médio: (%g, %g)\n", c.x, c.y);
    return EXIT_SUCCESS;
}