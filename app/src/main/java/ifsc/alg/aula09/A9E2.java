/*
Elabore um programa Java que LÊ uma expressão aritmética composta um
por um número real, um caractere representando uma operação matemática
e outro número real (nesta ordem), e ESCREVE o resultado da operação.

Operações possíveis: adição (+), subtração (-), multiplicação (*) e divisão (/)

Em caso de operação inválida ou divisão por zero, o programa deve
reportar um erro.
*/

package ifsc.alg.aula09;

import java.util.Scanner;

public class A9E2 {
    public static void main(String[] args) {
        // Variáveis
        Scanner sc = new Scanner(System.in);
        double operando1, operando2;
        char operador;

        // Início
        System.out.println("Entre com a expressão: ");
        operando1 = sc.nextDouble();
        operador = sc.next().charAt(0);
        operando2 = sc.nextDouble();

        switch (operador) {
            case '+' -> System.out.printf("%.2f", operando1 + operando2);
            case '-' -> System.out.printf("%.2f", operando1 - operando2);
            case '*' -> System.out.printf("%.2f", operando1 * operando2);
            case '/' -> {
                if (operando2 == 0) {
                    System.out.println("Erro: divisão por zero");
                } else {
                    System.out.printf("%.2f", operando1 / operando2);
                }
            }
            default -> System.out.println("Erro: oepração inválida");
        }

        sc.close();
        // Fim
    }
}
