/*
Um ano é bissexto se for divisível por 4. Mas essa regra tem uma exceção: os anos divisíveis por
100, apesar de serem divisíveis por 4, não são bissextos. Porém, há uma exceção à exceção:
os anos divisíveis por 400, apesar de serem divisíveis por 100, são sim bissextos. Escreva um
programa que LÊ do teclado um ano (d.C.) e ESCREVE na tela se ele é bissexto ou não.
 */

package ifsc.alg.lista05;

import java.util.Scanner;

public class L5E4 {
    public static void main(String[] args) {
        // Variáveis
        int ano;

        // Início
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o ano: ");
        ano = sc.nextInt();
        System.out.printf("%s bissexto.%n", (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) ? "É" : "Não é");

        sc.close();
        // Fim
    }
}
