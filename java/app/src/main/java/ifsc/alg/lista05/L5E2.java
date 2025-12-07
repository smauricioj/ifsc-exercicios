/*Considere uma disciplina onde o aluno deve alcançar média igual ou superior a 6 em quatro
avaliações e ter presença igual ou maior a 75% para ser aprovado. Elabore programa Java
que LÊ quatro número reais representando as notas do aluno, bem como um número inteiro
representando a frequência do aluno, para depois, ESCREVEr a média aritmética simples das
notas e “Aprovado”, caso ele possa ser aprovado, ou “Reprovado” caso contrário. Não
utilize mais do que duas variáveis de tipos primitivos no programa todo. */
package ifsc.alg.lista05;

import java.util.Scanner;

public class L5E2 {
    public static void main(String[] args) {
        // Variáveis
        float media;
        short presenca;

        // Início
        Scanner sc = new Scanner(System.in);
        media = 0.0f;
        System.out.print("Digite as notas do aluno: ");
        media += sc.nextFloat();
        media += sc.nextFloat();
        media += sc.nextFloat();
        media += sc.nextFloat();
        media /= 4;
        System.out.print("Digite a presenca do aluno: ");
        presenca = sc.nextShort();
        System.out.printf("Média: %.1f - %s%n", media, (media >= 6 && presenca >= 75) ? "Aprovado" : "Reprovado");
        sc.close();
        // Fim
    }
}
