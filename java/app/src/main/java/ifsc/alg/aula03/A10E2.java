/*
Elabore um programa Java que LÊ um inteiro positivo e ESCREVE todos os seus
divisores, bem como se o número informado é primo ou não. Lembre-se que
um número é primo quando ele é divisível apenas por 1 e por si mesmo.
Utilize o comando for na sua solução e apresente o conjunto de divisores
como nos exemplos abaixo. Não use arranjos.
 */

package ifsc.alg.aula03;

import java.util.Scanner;

public class A10E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com um inteiro positivo: ");
        int n = sc.nextInt();
        System.out.print("Divisores: [1, ");
        boolean ehPrimo = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                ehPrimo = false;
                System.out.printf("%d, ", i);
            }
        }
        System.out.printf("%d]%n%s primo%n", n, ehPrimo ? "É" : "Não é");
        sc.close();
    }
}
