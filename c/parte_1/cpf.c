#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool eh_cpf_valido(int d1, int d2, int d3,
                   int d4, int d5, int d6,
                   int d7, int d8, int d9,
                   int d10, int d11)
{
    int a = (10 * d1) + (9 * d2) + (8 * d3) + (7 * d4) + (6 * d5) + (5 * d6) + (4 * d7) + (3 * d8) + (2 * d9);
    bool x = (((10 * a) % 11) % 10 == d10);
    int b = (11 * d1) + (10 * d2) + (9 * d3) + (8 * d4) + (7 * d5) + (6 * d6) + (5 * d7) + (4 * d8) + (3 * d9) + (2 * d10);
    bool y = (((10 * b) % 11) % 10 == d11);
    return (x && y);
}

void imprime_cpf(int d1, int d2, int d3,
                 int d4, int d5, int d6,
                 int d7, int d8, int d9,
                 int d10, int d11)
{
    printf("Formato padrão: %d%d%d.%d%d%d.%d%d%d-%d%d\n", d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11);
}

void imprime_uf(int num_regiao)
{
    printf("Unidades federativas: ");
    switch (num_regiao) {
        case 1: printf("DF, GO, MT, MS, TO"); break;
        case 2: printf("AC, AP, AM, PA, RO, RR"); break;
        case 3: printf("CE, MA, PI"); break;
        case 4: printf("AL, PB, PE, RN"); break;
        case 5: printf("BA, SE"); break;
        case 6: printf("MG"); break;
        case 7: printf("ES, RJ"); break;
        case 8: printf("SP"); break;
        case 9: printf("PR, SC"); break;
        case 0: printf("RS");
    }
    printf("\n");
}

int main()
{
    int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11;
    printf("Entre com o CPF (somente números): ");
    scanf("%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d%1d",
          &d1, &d2, &d3, &d4, &d5, &d6, &d7, &d8, &d9, &d10, &d11);
    if (!eh_cpf_valido(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11)) {
        printf("CPF inválido");
        return EXIT_SUCCESS;
    }
    printf("CPF válido\n");
    imprime_cpf(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11);
    imprime_uf(d9);
    return EXIT_SUCCESS;
}