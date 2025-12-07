/*
Escreva um programa que LÊ o nome número do mês (Janeiro = 1, Fevereiro = 2, etc...) e o dia
da semana no qual o mês inicia (Domingo = 1, Segunda = 2, etc...), e ESCREVE o calendário do
mês. O programa deve repetir a entrada se algum valor informado for inválido. Assuma que o
ano não é bissexto.
*/
package ifsc.alg.lista07;

import java.util.Scanner;

public class L7E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entradas
        int mes;
        do {
            System.out.print("Entre com o número do mês: ");
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);

        int diaDaSemana;
        do {
            System.out.print("Entre com o primeiro dia da semana: ");
            diaDaSemana = sc.nextInt();
        } while (diaDaSemana < 1 || diaDaSemana > 7);

        // Calculando quantos dias tem no mês
        int diasDoMes = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> 28; // Fevereiro
        };

        // Impressão do calendário
        System.out.printf("%n D  S  T  Q  Q  S  S%n%n");
        for (int i = 0; i < diaDaSemana - 1; i++) {
            System.out.print("   "); // Espaços em branco antes de começar a contagem
        }
        for (int dia = 1; dia <= diasDoMes; dia++) { // Para todos os dias do mês
            System.out.printf("%2d ", dia); // Imprime o número do dia
            if (diaDaSemana == 7) { // Se é sábado
                System.out.println(); // Quebra linha e
                diaDaSemana = 0; // volta pro começo da semana
            } //
            diaDaSemana++; // Incrementa o dia da semana
        }
        System.out.println();
        sc.close();
    }
}
