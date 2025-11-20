/*
Elabore um programa Java que LÊ a altura de uma pessoa em metros e
ESCREVE a altura correspondente em pés + polegadas.
*/

package ifsc.alg.aula08;

import java.util.Scanner;

public class A8E2b {
    public static void main(String[] args) {
        // Variáveis
        int polegadas, pes;
        double metros;
        Scanner sc = new Scanner(System.in);

        // Início
        System.out.print("Entre com a altura em metros: ");
        metros = sc.nextDouble();
        polegadas = (int) (metros * 100 / 2.54);
        pes = polegadas / 12;
        polegadas %= 12;
        System.out.printf("Altura em pés + polegadas: %d %d%n", pes, polegadas);
        sc.close();
        // Fim
    }
}
