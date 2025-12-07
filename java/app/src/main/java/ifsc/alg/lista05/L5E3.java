/*
Escreva um programa que LÊ do teclado um valor em centavos e ESCREVE na tela a quantidade
de moedas necessárias para formar esse valor, dando preferência para as moedas de maior
valor. Não utilize mais do que duas variáveis de tipos primitivos no programa todo. As
moedas disponíveis são de 50, 25, 10, 5 e 1 centavo.
 */

package ifsc.alg.lista05;

import java.util.Scanner;

public class L5E3 {
    public static void main(String[] args) {
        // Variáveis
        int centavos, moedas;

        // Início
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com a quantidade de centavos: ");
        centavos = sc.nextInt();
        moedas = centavos / 50;
        centavos %= 50;
        System.out.printf("Moedas de 50 centavos: %d%n", moedas);
        moedas = centavos / 25;
        centavos %= 25;
        System.out.printf("Moedas de 25 centavos: %d%n", moedas);
        moedas = centavos / 10;
        centavos %= 10;
        System.out.printf("Moedas de 10 centavos: %d%n", moedas);
        moedas = centavos / 5;
        centavos %= 5;
        System.out.printf("Moedas de 05 centavos: %d%n", moedas);
        System.out.printf("Moedas de 01 centavo: %d%n", centavos);
        sc.close();
        // Fim
    }
}
