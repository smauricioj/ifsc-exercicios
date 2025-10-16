/*
Escreva um programa que LÊ do teclado um inteiro positivo n e ESCREVE na tela o triângulo de
Floyd com n linhas.
 */

package ifsc.alg.lista07;

import java.util.Scanner;

public class L7E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o número de linhas: ");
        int n = sc.nextInt(), saida = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", saida);
                saida++;
            }
            System.out.println();
        }
        sc.close();
    }
}
