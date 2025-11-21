// funcoes.h
#ifndef FUNCOES_H
#define FUNCOES_H

#define MAX_ALUNOS 100
#define MAX_NOME 50
#define BUSCA_ERRO -1

// Uso de estruturas e arranjos
typedef struct {
    char nome[MAX_NOME];
    float notas[3];
    float media;
} Aluno;

// Funções
void carregarDeArquivo();
void salvarEmArquivo();
void adicionarAluno();
void listarAlunos();
void buscarAluno();
void atualizarNotas();
void removerAluno();

#endif