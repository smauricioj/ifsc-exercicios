#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define TAU (3.14159265 / 180)

typedef struct
{
    float x;
    float y;
} Vetor2D;

void rotaciona(Vetor2D *v, float a)
{
    float newX = v->x * cos(a * TAU) - v->y * sin(a * TAU);
    float newY = v->x * sin(a * TAU) + v->y * cos(a * TAU);
    v->x = newX;
    v->y = newY;
}

void escalona(Vetor2D *v, float k)
{
    v->x *= k;
    v->y *= k;
}

void translada(Vetor2D *v, float dx, float dy)
{
    v->x += dx;
    v->y += dy;
}

int main()
{
    Vetor2D vetor;
    printf("Entre com o vetor inicial (x y): ");
    scanf("%f %f", &vetor.x, &vetor.y);
    char arg1;
    float arg2, arg3;
    printf("Entre com as operações: ");
    do {
        scanf("%c", &arg1);
        switch (arg1) {
            case 'r':
                scanf("%f", &arg2);
                rotaciona(&vetor, arg2);
                break;
            case 's':
                scanf("%f", &arg2);
                escalona(&vetor, arg2);
                break;
            case 't':
                scanf("%f", &arg2);
                scanf("%f", &arg3);
                translada(&vetor, arg2, arg3);
                break;
            default:
                continue;
        }
    } while (arg1 != 'q');
    printf("Vetor final: (%g, %g)\n", vetor.x, vetor.y);
    return EXIT_SUCCESS;
}