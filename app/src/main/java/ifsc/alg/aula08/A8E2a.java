/*
Elabore um programa Java que LÊ a altura de uma pessoa em pés +
polegadas e ESCREVE a altura correspondente em metros, com duas casas
decimais
*/

package ifsc.alg.aula08;

import java.util.Scanner;

public class A8E2a {
    public static void main(String[] args) {
        // Variáveis
        int polegadas, pes;
        double metros;
        Scanner sc = new Scanner(System.in);

        // Início
        System.out.print("Entre com a altura em pés + polegadas: ");
        pes = sc.nextInt();
        polegadas = sc.nextInt();
        metros = ((polegadas + pes * 12) * 2.54) / 100.0;
        System.out.printf("Altura em metros: %.2f%n", metros);
        sc.close();
        // Fim
    }
}
