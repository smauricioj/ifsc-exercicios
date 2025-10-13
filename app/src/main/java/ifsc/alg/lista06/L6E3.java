/*
Elabore um programa Java que LÊ o valor de um ângulo em graus (entre 0o e 360o) e ESCREVE
o valor aproximado do seno desse ângulo (calculado pela fórmula de Bh ¯askara I), bem como o
valor real do seno desse ângulo (calculado pelo métod sin da classe Math). Ambos os valores
devem ser escritos com 4 casas decimais.
 */

package ifsc.alg.lista06;

import java.util.Scanner;

public class L6E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o valor do ângulo em graus: ");
        double graus = sc.nextDouble();

        if (graus < 0 || graus > 360) {
            System.out.println("Valor inválido!");
            sc.close();
            return;
        }

        double senoReal = Math.sin(graus * Math.PI / 180);
        boolean acimaDe180 = graus > 180;
        if (acimaDe180) {
            graus = 360 - graus;
        }
        double senoAprox = (acimaDe180 ? -1 : 1) * (4.0 * graus * (180 - graus)) / (40500 - graus * (180 - graus));
        System.out.printf("Valor aproximado do seno: %.4f%n", senoAprox);
        System.out.printf("Valor real do seno: %.4f%n", senoReal);
        sc.close();
    }
}
