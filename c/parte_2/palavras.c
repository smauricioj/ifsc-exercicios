#include <stdio.h>
#include <stdlib.h>

int main()
{
    char atual = ' ', anterior = ' ';
    int count = 0;
    printf("Entre com um texto: ");
    do {
        anterior = atual;
        scanf("%c", &atual);
        if (atual != ' ' && atual != '\n' && anterior == ' ') {
            count++;
        }
    } while (atual != '\n');
    printf("Número de palavras: %d\n", count);
    return EXIT_SUCCESS;
}