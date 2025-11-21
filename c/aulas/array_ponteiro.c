#include <stdio.h>

void alfa(int arranjo[])
{
    printf("Tamanho do arranjo: %zu\n", sizeof arranjo);  // Surpresa!
}

int main()
{
    int arranjo[6] = {4, 8, 15, 16, 23, 42};
    printf("Tamanho do arranjo: %zu\n", sizeof arranjo);  // 24, como esperado
    alfa(arranjo);
    return 0;
}