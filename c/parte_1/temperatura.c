#include <stdio.h>
#include <stdlib.h>

float converte_c_para_f(float t)
{
    return (1.8 * t) + 32;
}

float converte_f_para_c(float t)
{
    return (t - 32) / 1.8;
}

float converte_c_para_k(float t)
{
    return t + 273.15;
}

float converte_k_para_c(float t)
{
    return t - 273.15;
}

float converte_f_para_k(float t)
{
    return converte_c_para_k(converte_f_para_c(t));
}

float converte_k_para_f(float t)
{
    return converte_c_para_f(converte_k_para_c(t));
}

float converte_temperatura(float t, char origem, char destino)
{
    if (origem == destino) {
        return t;
    }
    if (origem == 'C') {
        switch (destino) {
            case 'F': return converte_c_para_f(t);
            case 'K': return converte_c_para_k(t);
        }
    } else if (origem == 'F') {
        switch (destino) {
            case 'C': return converte_f_para_c(t);
            case 'K': return converte_f_para_k(t);
        }
    } else if (origem == 'K') {
        switch (destino) {
            case 'C': return converte_k_para_c(t);
            case 'F': return converte_k_para_f(t);
        }
    }
    return 0;
}

int main()
{
    float temp;
    char origem, destino;
    printf("Entre com o valor da temperatura: ");
    scanf("%f", &temp);
    printf("Entre com a escala de origem (C, F, K): ");
    scanf(" %c", &origem);
    printf("Entre com a escala de destino (C, F, K): ");
    scanf(" %c", &destino);
    if (origem == 'K' && temp < 0) {
        return EXIT_FAILURE;
    }
    printf("Temperatura convertida: %.2f\n", converte_temperatura(temp, origem, destino));
    return EXIT_SUCCESS;
}