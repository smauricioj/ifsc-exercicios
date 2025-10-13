/*
Elabore um programa Java que LÊ os lados de um triângulo e ESCREVE a sua classificação
(equilátero, isósceles, escaleno ou inválido).
 */

package ifsc.alg.lista06;

import java.util.Scanner;

public class L6E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com os lados do triângulo: ");
        double ladoA = sc.nextDouble();
        double ladoB = sc.nextDouble();
        double ladoC = sc.nextDouble();

        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0 ) {
            System.out.println("Valor inválido!");
            sc.close();
            return;
        }

        System.out.print("Triângulo ");
        if (ladoA + ladoB <= ladoC || ladoB + ladoC <= ladoA || ladoC + ladoA <= ladoB) {
            System.out.println("inválido");
        } else if (ladoA == ladoB && ladoA == ladoC) {
            System.out.println("equilátero");
        } else if (ladoA == ladoB || ladoB == ladoC || ladoC == ladoA) {
            System.out.println("isósceles");
        } else {
            System.out.println("escaleno");
        }

        sc.close();
    }
}
