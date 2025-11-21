#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool calcula_prefixo(float x, char *prefixo, float *y)
{
    if (x < 1.0E-9 || x >= 1.0E12) {
        return false;
    }
    if (x < 1.0E-6) {
        *prefixo = 'n';
        *y = x * 1.0E9;

    } else if (x < 1.0E-3) {
        *prefixo = 'u';
        *y = x * 1.0E6;

    } else if (x < 1.0E0) {
        *prefixo = 'm';
        *y = x * 1.0E3;

    } else if (x < 1.0E3) {
        *prefixo = ' ';
        *y = x;

    } else if (x < 1.0E6) {
        *prefixo = 'k';
        *y = x * 1.0E-3;

    } else if (x < 1.0E9) {
        *prefixo = 'M';
        *y = x * 1.0E-6;

    } else if (x < 1.0E12) {
        *prefixo = 'G';
        *y = x * 1.0E-9;
    }
    return true;
}

int main()
{
    float x, y = 0;
    char prefixo = ' ';
    printf("Entre com um número real: ");
    scanf("%f", &x);
    if (!calcula_prefixo(x, &prefixo, &y)) {
        printf("Número fora do intervalo\n");
        return EXIT_SUCCESS;
    }
    printf("Representação com prefixo: %g%c", y, prefixo);
    return EXIT_SUCCESS;
}