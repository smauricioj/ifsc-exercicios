#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int n_dias, primeiro_dia;
    printf("Entre com o número de dias do mês (28, 30 ou 31): ");
    scanf("%d", &n_dias);
    printf("Entre com o primeiro dia da semana (1=Dom, 7=Sab): ");
    scanf("%d", &primeiro_dia);
    printf("\n D  S  T  Q  Q  S  S\n\n");
    int dia_atual = 1;
    while (dia_atual < primeiro_dia) {
        printf("   ");
        dia_atual++;
    }
    for (int dia_mes = 1; dia_mes <= n_dias; dia_mes++, dia_atual++) {
        if (dia_atual > 7) {
            dia_atual -= 7;
            printf("\n");
        }
        printf("%2d ", dia_mes);
    }
    printf("\n");
    return EXIT_SUCCESS;
}