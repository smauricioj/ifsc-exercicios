#include <stdio.h>
#include <stdlib.h>

int v0(int classe)
{
    switch (classe) {
        case 1: return 150;
        case 2: return 200;
        case 3: return 100;
        case 4: return 100;
        default: return 0;
    }
}

int inc(int classe)
{
    switch (classe) {
        case 1: return 10;
        case 2: return 15;
        case 3: return 5;
        case 4: return 5;
        default: return 0;
    }
}

int nivel_minimo(int v0, int inc, int v)
{
    int nivel = 0, vit_atual = v0;
    while (vit_atual < v) {
        vit_atual += inc * ((++nivel % 5 == 0) ? 2 : 1);
    }
    return nivel;
}

int main()
{
    int classe, vit;
    printf("Entre com a classe (1-arqueiro, 2-bárbaro, 3-druida, 4-mago): ");
    scanf("%d", &classe);
    if (classe < 1 || classe > 4) {
        printf("Classe inválida");
        return EXIT_SUCCESS;
    }
    printf("Entre com a vitalidade desejada: ");
    scanf("%d", &vit);
    printf("Nível necessário: %d", nivel_minimo(v0(classe), inc(classe), vit));
    return EXIT_SUCCESS;
}