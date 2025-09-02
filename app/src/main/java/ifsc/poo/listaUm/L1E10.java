package ifsc.poo.listaUm;

import java.util.Scanner;

public class L1E10 {
    public static void main(String[] args) {
        // Entrada
        int tam = 20;
        int[][] matriz = new int[tam][tam];
        Scanner scan = new Scanner(System.in);

        // Ler a matriz
        int i = 0, j = 0;
        while(scan.hasNext()){
            matriz[i][j++] = scan.nextInt();
            if (j == tam) {
                j = 0;
                i++;
            }
        }

        // Buscar maior valor
        int maior = Integer.MIN_VALUE;
        for(i = 0; i < tam; i++){
            for(j = 0; j < tam; j++){
                maior = Math.max(maior, produto(matriz, i, j, 0, 1));
                maior = Math.max(maior, produto(matriz, i, j, 1, 0));
                maior = Math.max(maior, produto(matriz, i, j, 1, 1));
                maior = Math.max(maior, produto(matriz, i, j, 1, -1));
            }
        }

        // Saída
        System.out.println(maior);
    }

    static int produto(int[][] mat, int i, int j, int di, int dj) {
        int comp = 4, ci = i + (comp - 1)*di, cj = j + (comp - 1)*dj;
        if (ci >= mat.length || ci < 0 || cj >= mat[0].length || cj < 0) return Integer.MIN_VALUE;
        int valor = 1;
        for (int k = 0; k < comp; k++) valor *= mat[i + (k * di)][j + (k * dj)];
        return valor;
    }
}
