/*
Escreva um programa que LÊ um valor de transação e ESCREVE a comissão (taxa de correta-
gem) correspondente.

Valor da transação Comissão
Menor que R$2.500 R$30 + 1,7%
R$2.500 a R$.6250 R$56 + 0,66%
R$6.250 a R$20.000 R$76 + 0,34%
R$20.000 a R$50.000 R$100 + 0,22%
R$50.000 a R$500.000 R$155 + 0,11%
Maior que R$500.000 R$255 + 0,09%
 */

package ifsc.alg.lista06;

import java.util.Scanner;

public class L6E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o valor negociado: ");
        double val = sc.nextDouble();
        double taxa;
        if (val > 500_000) {
            taxa = 255 + (0.09 / 100) * val;
        } else if (val > 50_000) {
            taxa = 155 + (0.11 / 100) * val;
        } else if (val > 20_000) {
            taxa = 100 + (0.22 / 100) * val;
        } else if (val > 6_250) {
            taxa = 76 + (0.34 / 100) * val;
        } else if (val > 2_500) {
            taxa = 56 + (0.66 / 100) * val;
        } else if (val > 0) {
            taxa = Math.max(30 + (1.7 / 100) * val, 39);
        } else {
            System.out.println("Valor inválido");
            sc.close();
            return;
        }
        System.out.printf("Taxa de corretagem %.2f%n: ", taxa);
        sc.close();
    }
}
