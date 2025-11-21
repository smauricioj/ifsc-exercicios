package ifsc.alg.lista09;

import java.io.PrintStream;
import java.util.Scanner;

public class L9E4 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    static int[] somaColunas(int[][] m) {
        // Verificando se matriz faz sentido
        int nLinhas = m.length;
        if (nLinhas == 0) return new int[]{0};
        int nColunas = m[0].length;
        if (nColunas == 0) return new int[]{0};

        // Calculando soma
        int[] colunas = new int[nColunas];
        for (int j = 0; j < nColunas; j++) {
            for (int[] linha : m) {
                colunas[j] += linha[j];
            }
        }
        return colunas;
    }

    static int encontraIndiceMaiorValor(int[] arr) {
        // Verificando se arranjo faz sentido
        if (arr.length == 0) return 0;

        // Procurando maior valor
        int maior = arr[0], indiceMaior = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
                indiceMaior = i;
            }
        }
        return indiceMaior;
    }

    static int lerPositivo(String rotulo) {
        if (rotulo.isEmpty()) rotulo = "o número positivo";
        int res;
        do {
            OUT.printf("Entre com %s: ", rotulo);
            res = IN.nextInt();
        } while (res <= 0);
        return res;
    }

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
