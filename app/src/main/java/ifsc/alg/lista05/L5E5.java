package ifsc.alg.lista05;

import java.util.Scanner;

public class L5E5 {
    public static void main(String[] args) {
        // Variáveis
        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13;
        int segundaParte, terceiraParte;
        int somaA, somaB;

        // Início
        Scanner sc = new Scanner(System.in);

        // Entradas
        System.out.print("Entre com a primeira parte (1 dígito): ");
        d1 = sc.nextInt();
        System.out.print("Entre com a segunda parte (6 dígitos): ");
        segundaParte = sc.nextInt();
        System.out.print("Entre com a terceira parte (5 dígitos): ");
        terceiraParte = sc.nextInt();

        // Decifrando a terceira parte
        d12 = terceiraParte % 10;                // Extrai o último dígito
        d11 = terceiraParte % 100 / 10;          // Extrai os últimos 2 dígitos e divide por 10 para remover o último
        d10 = terceiraParte % 1000 / 100;        // Extrai os últimos 3 dígitos e divide por 100 para remover os 2 últimos
        d9 = terceiraParte % 10000 / 1000;       // E assim por diante...
        d8 = terceiraParte / 10000;

        // Decifrando a segunda parte
        d7 = segundaParte % 10;
        d6 = segundaParte % 100 / 10;
        d5 = segundaParte % 1000 / 100;
        d4 = segundaParte % 10000 / 1000;
        d3 = segundaParte % 100000 / 10000;
        d2 = segundaParte / 100000;

        // Algoritmo de verificação
        somaA = d1 + d3 + d5 + d7 + d9 + d11;
        somaB = d2 + d4 + d6 + d8 + d10 + d12;
        d13 = 9 - ((((somaB*3) + somaA) - 1) % 10);
        System.out.printf("Dígito verificador: %d%n", d13);
        sc.close();
        // Fim
    }
}
