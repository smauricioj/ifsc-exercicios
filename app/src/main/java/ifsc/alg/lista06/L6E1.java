/*
Considere um vendedor cuja remuneração mensal é composta por um salário fixo de R$ 2000,00
mais uma comissão que depende do valor total de suas vendas. A comissão inicial é de 5%
sobre o valor total de vendas, mas se o valor total de vendas alcançar a meta de R$ 10000,00,
a comissão passa a ser de 7%. Além disso, quando a avaliação de desempenho do vendedor
for igual ou superior a 8, ele recebe um bônus de R$ 500,00.

Elabore um programa Java que LÊ o valor total de vendas e a avaliação de desempenho do
vendedor e ESCREVE o valor total da remuneração mensal.
*/

package ifsc.alg.lista06;

import java.util.Scanner;

public class L6E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o total de vendas (R$): ");
        double vendas = sc.nextDouble();
        System.out.print("Entre com a avaliação de desempenho (1-10): ");
        int aval = sc.nextInt();

        if (vendas < 0 || aval < 0 || aval > 10) {
            sc.close();
            return;
        }

        double remuneracao = 2_000;

        if (vendas >= 10_000) {
            remuneracao += vendas * 0.07;
        } else {
            remuneracao += vendas * 0.05;
        }

        if (aval >= 8) {
            remuneracao += 500;
        }

        // Com operador ternário:
        // double remuneracao = 2_000 + vendas * ((vendas >= 10_000) ? 0.07 : 0.05) + ((aval >= 8) ? 500 : 0);

        System.out.printf("Remuneração: R$%.2f%n", remuneracao);

        sc.close();
    }
}
