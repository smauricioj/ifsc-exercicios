/*
Considere uma disciplina que possui três provas e três trabalhos. A média
final da disciplina é calculada considerando ponderações de:
80% para a média das duas maiores notas provas (a menor nota das
provas é descartada);
20% para a média das duas maiores notas trabalhos (a menor nota dos
trabalhos é descartada).
Por exemplo, um aluno que tirou 7, 2 e 9 nas provas, e 10, 8 e 8 nos trabalhos,
terá média final
MF = 0.8 × ((7 + 9) / 2) + 0.2 × ((10 + 8) / 2) = 8.2
Elabore um programa que LÊ as três notas das provas, seguidas as três notas
dos trabalhos, e ESCREVE a média final do aluno
*/

package ifsc.alg.aula04;

import java.util.Scanner;

public class A11E1 {
    /**
     * Calcula o menor de três valores do domínio Real
     */
    static double menorDeTres(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    /**
     * Calcula a média dos dois maiores valores dentre três
     */
    static double calcularMediaDosMaiores(double x1, double x2, double x3) {
        return (x1 + x2 + x3 - menorDeTres(x1, x2, x3)) / 2;
    }

    /**
     * Calcula a média final do aluno, seguindo as regras do enunciado
     */
    static double calcularMediaFinal(double p, double t) {
        return 0.8 * p + 0.2 * t;
    }

    /**
     * Função principal do programa
     */
    public static void main(String[] args) {
        double mediaProvas, mediaTrabalhos;
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com as notas das provas: ");
        mediaProvas = calcularMediaDosMaiores(
                sc.nextDouble(),
                sc.nextDouble(),
                sc.nextDouble());

        System.out.print("Entre com as notas dos trabalhos: ");
        mediaTrabalhos = calcularMediaDosMaiores(
                sc.nextDouble(),
                sc.nextDouble(),
                sc.nextDouble());

        System.out.printf("Média final: %.2f%n", calcularMediaFinal(mediaProvas, mediaTrabalhos));
        sc.close();
    }
}
