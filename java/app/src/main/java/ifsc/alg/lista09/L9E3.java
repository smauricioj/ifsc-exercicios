/*
O desvio padrão δ de um vetor v é
δ = √ (1 / (n − 1)) × ∑^{n−1}_{i=0}(v[i] − v)²
onde n é o tamanho do vetor, v[i] é o i-ésimo valor de v e v é a média dos valores contidos em
v.

Tarefa
Implemente um programa Java que LÊ um arranjo de números inteiros e ESCREVE o desvio
padrão dos valores nele contidos. O arranjo deve ser lido da mesma forma que a apresentada
na questão 2.
Para resolver esse problema, implemente ao menos as seguintes funções (mas é possível que
outras também sejam necessárias):
• double media(int[] vals): retorna a média dos valores contidos em vals
• double desvioPadrao(int[] vals): retorna o desvio padrão dos valores contidos em vals
*/
package ifsc.alg.lista09;

import java.util.Scanner;

public class L9E3 {
    /**
     * Calcula a média de um arranjo de inteiros
     */
    static double media(int[] vals) {
        double res = 0.0;
        for (int val : vals) {
            res += val;
        }
        return res / vals.length;
    }

    /**
     * Calcula o desvio padrão de um arranjo de inteiros
     */
    static double desvioPadrao(int[] vals) {
        double media = media(vals);
        double sum = 0;
        for (int val : vals) {
            sum += Math.pow((val - media), 2);
        }
        return Math.sqrt(sum / (vals.length - 1));
    }

    /**
     * Função principal do programa
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam;
        do {
            System.out.print("Entre com o tamanho do arranjo: ");
            tam = sc.nextInt();
        } while (tam <= 0);
        int[] valores = new int[tam];
        System.out.print("Entre com os valores do arranjo: ");
        for (int i = 0; i < tam; i++) {
            valores[i] = sc.nextInt();
        }
        System.out.printf("O desvio padrão é %.4f%n", desvioPadrao(valores));
        sc.close();
    }
}
