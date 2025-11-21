#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define PI 3.14159253

float calc_area_circulo(float r)
{
    if (r < 0) {
        return 0;
    }
    return PI * r * r;
}

float calc_area_anel(float r_int, float r_ext)
{
    if (r_int >= r_ext) {
        return 0;
    }
    return calc_area_circulo(r_ext) - calc_area_circulo(r_int);
}

float calc_massa_arruela(float d1, float d2, float H, float rho)
{
    if (H < 0 || rho < 0) {
        return 0;
    }
    return calc_area_anel(d1 / 2, d2 / 2) * H * rho;
}

int main()
{
    float d1, d2, H, rho, N;
    printf("Entre com o diâmetro interno (cm): ");
    scanf("%f", &d1);
    printf("Entre com o diâmetro externo (cm): ");
    scanf("%f", &d2);
    printf("Entre com a espessura (cm): ");
    scanf("%f", &H);
    printf("Entre com a densidade (g/cm³): ");
    scanf("%f", &rho);
    printf("Entre com o número de arruelas: ");
    scanf("%f", &N);
    printf("Massa total: %.2f g", N * calc_massa_arruela(d1, d2, H, rho));
    return 0;
}