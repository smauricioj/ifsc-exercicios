#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n_alunos, n_provas;
    float nota, media, media_turma;
    printf("Entre com o número de alunos: ");
    scanf("%d", &n_alunos);
    printf("Entre com o número de provas: ");
    scanf("%d", &n_provas);
    media_turma = 0;
    for (int aluno = 1; aluno <= n_alunos; aluno++) {
        printf("\nEntre com as notas do aluno %d: ", aluno);
        media = 0;
        for (int prova = 1; prova <= n_provas; prova++) {
            scanf("%f", &nota);
            media += nota;
        }
        media /= n_provas;
        media_turma += media;
        printf("Aluno %d %s com média %.1f\n", aluno, (media >= 6.0) ? "aprovado" : "reprovado", media);
    }
    media_turma /= n_alunos;
    printf("\nA média da turma foi %.1f", media_turma);
    return EXIT_SUCCESS;
}