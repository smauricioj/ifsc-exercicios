#include <stdio.h>
#include "funcoes.h"

int main()
{
    carregarDeArquivo();
    int opcao = 0;

    do {
        // Interface via terminal, Estruturas de repetição (do while)
        printf("\n1. Adicionar Aluno\n2. Listar Alunos\n3. Buscar Aluno\n4. Atualizar Notas\n5. Remover Aluno\n6. Sair\nEscolha: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1: adicionarAluno(); break;
            case 2: listarAlunos(); break;
            case 3: buscarAluno(); break;
            case 4: atualizarNotas(); break;
            case 5: removerAluno(); break;
            case 6: printf("Finalizando programa!\n"); break;
            default: printf("Opção invalida!\n");
        }
    } while (opcao != 6);

    return 0;
}