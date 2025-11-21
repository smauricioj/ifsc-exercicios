#include <stdio.h>
#include <stdlib.h>

#define EPS 0.0001

double modulo(double a)
{
    return (a > 0) ? a : -a;
}

int main()
{
    double anterior, atual;
    printf("Entre com a aproximação inicial: ");
    scanf("%lf", &atual);
    do {
        anterior = atual;
        atual = (atual / 2.0) + (1.0 / atual);
        printf("%.9lf\n", atual);
    } while (modulo(atual - anterior) > EPS);
    return EXIT_SUCCESS;
}