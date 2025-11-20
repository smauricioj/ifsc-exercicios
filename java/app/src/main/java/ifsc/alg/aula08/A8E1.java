/*
Elabore um programa Java que LÊ três números reais representando as
dimensões de uma caixa (em m) e ESCREVE a área da superfície (em m2) e o
volume da caixa (em m3). Depois, LÊ a quantidade de caixas produzidas e o
preço do metro quadrado (em R$/m2) e ESCREVE o custo total de produção
das caixas.
*/

package ifsc.alg.aula08;

import java.util.Scanner;

public class A8E1 {
    public static void main(String[] args) {
        // Variáveis
        double altura, largura, produndidade, custo, area;
        int quantidade;
        Scanner sc = new Scanner(System.in);

        // Início
        System.out.print("Entre com a altura (m): ");
        altura = sc.nextDouble();
        System.out.print("Entre com a largura (m): ");
        largura = sc.nextDouble();
        System.out.print("Entre com a produndidade: ");
        produndidade = sc.nextDouble();

        area = 2 * (altura * largura + largura * produndidade + produndidade * altura);

        System.out.printf("A área é %.2f e o volume é %.2f%n", area, altura * largura * produndidade);

        System.out.print("Entre com a quantidade produzida: ");
        quantidade = sc.nextInt();
        System.out.print("Entre com o custo por m2: ");
        custo = sc.nextDouble();

        System.out.printf("O custo total de produção é %.2f R$%n", quantidade * custo * area );

        sc.close();
        // Fim
    }
}
