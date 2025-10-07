package ifsc.alg.listaCinco;

import java.util.Scanner;

public class L5E4 {
    public static void main(String[] args) {
        // Variáveis
        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13;
        int segundaParte, terceiraParte;
        int etapaA, etapaB;

        // Início
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com a primeira parte (1 dígito): ");
        d1 = sc.nextInt();
        System.out.print("Entre com a segunda parte (6 dígitos): ");
        segundaParte = sc.nextInt();
        System.out.print("Entre com a terceira parte (5 dígitos): ");
        terceiraParte = sc.nextInt();

        // Decifrando a segunda parte
        d7 = segundaParte % 10;
        segundaParte /= 10;
        d6 = segundaParte % 10;
        segundaParte /= 10;
        d5 = segundaParte % 10;
        segundaParte /= 10;
        d4 = segundaParte % 10;
        segundaParte /= 10;
        d3 = segundaParte % 10;
        segundaParte /= 10;
        d2 = segundaParte;

        // Decifrando a terceira parte
        d12 = terceiraParte % 10;
        terceiraParte /= 10;
        d11 = terceiraParte % 10;
        terceiraParte /= 10;
        d10 = terceiraParte % 10;
        terceiraParte /= 10;
        d9 = terceiraParte % 10;
        terceiraParte /= 10;
        d8 = terceiraParte;

        // Algoritmo de verificação
        etapaA = d1 + d3 + d5 + d7 + d9 + d11;
        etapaB = d2 + d4 + d6 + d8 + d10 + d12;
        d13 = 9 - ( ( (etapaA * 3) + etapaB - 1) % 10);
        System.out.printf("Dígito verificador: %d%n", d13);
        sc.close();
        // Fim
    }
}
