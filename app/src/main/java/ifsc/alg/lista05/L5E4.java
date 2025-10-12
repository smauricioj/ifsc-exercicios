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
