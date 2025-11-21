#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "funcoes.h"

// Variáveis -----------------------------------------------------------------------
Aluno alunos[MAX_ALUNOS];
int totalAlunos = 0;
char *caminhoArquivoAlunos = "resources/alunos.txt";

// Funções utilitárias -------------------------------------------------------------
void calculaMedia(Aluno *a)
{
    a->media = (a->notas[0] + a->notas[1] + a->notas[2]) / 3;
}

void stdinNome(char *mensagem, char *nome)
{
    puts(mensagem);
    getchar();
    fgets(nome, MAX_NOME, stdin);
    nome[strcspn(nome, "\n")] = 0;
}

int buscarIndexPorNome()
{
    char nomeBusca[MAX_NOME];
    stdinNome("Digite o nome do aluno para buscar: ", nomeBusca);

    for (int i = 0; i < totalAlunos; i++) {
        if (strcmp(alunos[i].nome, nomeBusca) == 0) {
            return i;
        }
    }

    puts("Aluno não encontrado.\n");
    return BUSCA_ERRO;
}

// Manipulação de arquivos ---------------------------------------------------------
void carregarDeArquivo()
{
    // Manipulação de arquivos; Uso de ponteiros
    FILE *arquivo = fopen(caminhoArquivoAlunos, "r");
    if (arquivo == NULL)
        return;

    totalAlunos = 0;
    char linha[MAX_NOME + 16];  // Maior nome possível + 3 notas no formato ' x.xx' + '\n'

    // Estruturas de repetição (while)
    while (fgets(linha, sizeof(linha), arquivo) != NULL) {
        Aluno temp;
        if (sscanf(linha, "%49[^0-9] %f %f %f", temp.nome,
                   &temp.notas[0], &temp.notas[1], &temp.notas[2]) == 4) {
            temp.nome[strlen(temp.nome) - 1] = '\0';
            calculaMedia(&temp);
            alunos[totalAlunos++] = temp;
        }
    }
    fclose(arquivo);
}

void salvarEmArquivo()
{
    // Manipulação de arquivos; Uso de ponteiros
    FILE *arquivo = fopen(caminhoArquivoAlunos, "w");
    if (arquivo == NULL)
        return;

    // Estruturas de repetição (for)
    for (int i = 0; i < totalAlunos; i++) {
        fprintf(arquivo, "%s %.2f %.2f %.2f\n",
                alunos[i].nome,
                alunos[i].notas[0],
                alunos[i].notas[1],
                alunos[i].notas[2]);
    }
    fclose(arquivo);
};

// Funções da interface ---------------------------------------------------------
void adicionarAluno()
{
    // Estruturas de decisão (if)
    if (totalAlunos >= MAX_ALUNOS) {
        puts("Capacidade máxima atingida!");
        return;
    }

    puts("Cadastro de novo aluno iniciado!");
    stdinNome("Nome do aluno: ", alunos[totalAlunos].nome);

    printf("Digite as três notas do aluno: ");
    scanf("%f %f %f", &alunos[totalAlunos].notas[0], &alunos[totalAlunos].notas[1], &alunos[totalAlunos].notas[2]);
    calculaMedia(&alunos[totalAlunos]);

    totalAlunos++;
    salvarEmArquivo();
    puts("Aluno cadastrado com sucesso!");
}

void listarAlunos()
{
    for (int i = 0; i < totalAlunos; i++) {
        printf("%d. %s - Média: %.2f\n", i + 1, alunos[i].nome, alunos[i].media);
    }
}

void buscarAluno()
{
    int i = buscarIndexPorNome();
    if (i != BUSCA_ERRO) {
        printf("Aluno encontrado: %s - Média: %.2f\n", alunos[i].nome, alunos[i].media);
    }
}

void atualizarNotas()
{
    int i = buscarIndexPorNome();
    if (i != BUSCA_ERRO) {
        printf("Digite as novas três notas do aluno: ");
        scanf("%f %f %f", &alunos[i].notas[0], &alunos[i].notas[1], &alunos[i].notas[2]);
        calculaMedia(&alunos[totalAlunos]);
        salvarEmArquivo();
        puts("Notas atualizadas!");
    }
}

void removerAluno()
{
    int i = buscarIndexPorNome();
    if (i != BUSCA_ERRO) {
        for (int j = i; j < totalAlunos - 1; j++) {
            alunos[j] = alunos[j + 1];
        }
        totalAlunos--;
        salvarEmArquivo();
        puts("Aluno removido!");
    }
}