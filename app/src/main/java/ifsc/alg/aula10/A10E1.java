/*
Elabore um programa Java que LÊ um inteiro não-negativo e ESCREVE a soma
dos seus dígitos. Por exemplo, se o usuário digitar 2024 , o programa deve
escrever na tela 8 (pois 2 + 0 + 2 + 4 = 8). Leia o número como inteiro, não
texto, e utilize o comando while na sua solução.
 */

package ifsc.alg.aula10;

import java.util.Scanner;

public class A10E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com um inteiro não-negativo: ");
        int soma = 0;
        int n = sc.nextInt();    // Transformado para for:
        while (n > 0) {          // for (int n = sc.nextInt(); n > 0; n /= 10) {
            soma += n % 10;      //     soma += n % 10;
            n /= 10;             // }
        }                        //
        System.out.printf("Soma dos dígitos: %d%n", soma);
        sc.close();
    }
}
