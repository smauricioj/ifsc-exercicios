#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n_resistencias;
    float resistencia, serie = 0, paralelo = 0;
    printf("Entre com a quantidade de resistências: ");
    scanf("%d", &n_resistencias);
    for (int i = 0; i < n_resistencias; i++) {
        printf("Entre com a resistência %d (ohm): ", i + 1);
        scanf("%f", &resistencia);
        serie += resistencia;
        paralelo += (1.0 / resistencia);
    }
    paralelo = 1.0 / paralelo;
    printf("Resistência série: %g ohm\n", serie);
    printf("Resistência paralelo: %g ohm\n", paralelo);
    return EXIT_SUCCESS;
}