/*
Desenvolva um programa Java que LÊ os valores de uma matriz quadrada e ESCREVE o índice
da coluna com maior soma dos elementos. A leitura da matriz deve ser feita da seguinte forma:
primeiro será lido um valor inteiro positivo n que representa quantas linhas/colunas a matriz
possui (ela é quadrada), depois serão lidos os n2 valores inteiros da matriz, linha por linha, da
esquerda para direita.
*/

package ifsc.alg.lista09;

import java.io.PrintStream;
import java.util.Scanner;

public class L9E4 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    /**
     * Calcula as somas de cada coluna de uma matriz m
     */
    static int[] somaColunas(int[][] m) {
        // Verificando se matriz faz sentido
        if (m.length == 0)
            return new int[] { 0 };
        int nColunas = m[0].length;
        if (nColunas == 0)
            return new int[] { 0 };

        // Calculando soma
        int[] somas = new int[nColunas];
        for (int j = 0; j < nColunas; j++) {
            for (int[] linha : m) {
                somas[j] += linha[j];
            }
        }
        return somas;
    }

    /**
     * Encontra o índice do maior elemento de um arranjo
     */
    static int encontraIndiceMaiorValor(int[] arr) {
        // Verificando se arranjo faz sentido
        if (arr.length == 0)
            return 0;

        // Procurando maior valor
        int maior = arr[0], indiceMaior = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= maior)
                continue;
            maior = arr[i];
            indiceMaior = i;
        }
        return indiceMaior;
    }

    /**
     * Exaustivamente lê um inteiro positivo da entrada padrão
     */
    static int lerPositivo(String rotulo) {
        if (rotulo.isEmpty())
            rotulo = "o número positivo";
        int res;
        do {
            OUT.printf("Entre com %s: ", rotulo);
            res = IN.nextInt();
        } while (res <= 0);
        return res;
    }

    /**
     * Lê os elementos, na ordem de leitura, de uma matriz quadrada
     * de tamanho tam
     */
    static int[][] lerMatriz(int tam) {
        OUT.println("Entre com os valores:");
        int[][] matriz = new int[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = IN.nextInt();
            }
        }
        return matriz;
    }

    /**
     * Função principal do programa
     */
    public static void main(String[] args) {
        // Não é boa prática, mas eu achei divertido haha
        System.out.printf("O índice da coluna com maior valor é: %d%n",
                encontraIndiceMaiorValor(somaColunas(lerMatriz(lerPositivo("o tamanho da matriz quadrada")))));

        // Seria melhor assim:
        // int tam = lerPositivo("o tamanho da matriz quadrada");
        // int[][] matriz = lerMatriz(tam);
        // int[] somas = somaColunas(matriz);
        // int indiceMaior = encontraIndiceMaiorValor(somas);
        // System.out.printf("O índice da coluna com maior valor é: %d%n", indiceMaior);
    }
}
