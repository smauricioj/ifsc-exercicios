#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int horas, minutos, segundos;
    printf("Entre com a quantidade de segundos: ");
    scanf("%d", &segundos);

    horas = segundos / 3600;
    segundos = segundos % 3600;
    minutos = segundos / 60;
    segundos = segundos % 60;

    if (horas != 0) {
        printf("%d hora%s%s", horas, (horas > 1) ? "s" : "", (minutos != 0 || segundos != 0) ? ", " : "");
    }
    if (minutos != 0) {
        printf("%d minuto%s%s", minutos, (minutos > 1) ? "s" : "", (segundos != 0) ? ", " : "");
    }
    if (segundos != 0) {
        printf("%d segundo%s", segundos, (segundos > 1) ? "s" : "");
    }
    printf("\n");

    return EXIT_SUCCESS;
}