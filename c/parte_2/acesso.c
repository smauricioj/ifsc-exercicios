#include <stdio.h>
#include <stdlib.h>

#define MAX_TENTATIVAS 3
#define SENHA 314159

int main()
{
    int n_tentativas = 0, senha_informada;
    do {
        n_tentativas++;
        printf("Entre com a senha: ");
        scanf("%d", &senha_informada);
        if (senha_informada == SENHA) {
            printf("Acesso autorizado\n");
            return EXIT_SUCCESS;
        }
        printf("Acesso negado (senha incorreta)\n");
    } while (n_tentativas < MAX_TENTATIVAS);
    printf("Sistema bloqueado\n");
    return EXIT_SUCCESS;
}