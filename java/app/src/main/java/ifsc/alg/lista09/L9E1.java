/*
Escreva um programa Java que LÊ um inteiro positivo entre 1 e 999999999 e ESCREVE uma
tabela mostrando quantas vezes cada dígito aparece no número fornecido. Utilize um arranjo
na sua solução.

Restrições
• Garanta que o número está na faixa válida
• Se dígito não estiver presente no número, não mostre-o na tabela
*/
package ifsc.alg.lista09;

import java.util.Scanner;

public class L9E1 {
    static final int MIN_VAL = 1;
    static final int MAX_VAL = 999999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Digite um número inteiro positivo: ");
            numero = sc.nextInt();
        } while (numero < MIN_VAL || numero > MAX_VAL);

        int[] count = new int[10];
        do {
            count[numero % 10]++;
            numero /= 10;
        } while (numero > 0);

        System.out.println("Quantidade de cada dígito:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            System.out.printf("%d: %d vez%s%n", i, count[i], count[i] > 1 ? "es" : "");
        }
        sc.close();
    }
}
