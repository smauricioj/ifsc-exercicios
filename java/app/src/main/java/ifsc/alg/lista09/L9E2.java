/*
Escreva um programa Java que LÊ dois arranjos de inteiros de mesmo tamanho e ESCREVE
qual dos dois arranjos possui a maior quantidade de números pares (ou se ambos possuem a
mesma quantidade). Os arranjos serão lidos da seguinte forma: primeiro será lido um inteiro
que representa o tamanho dos arranjos; em seguida, serão lidos os elementos dos dois arranjos,
um por linha, da esquerda para a direita.

Para resolver esse problema, implemente as seguintes funções:
• int contaPares(int[] vals): retorna a quantidade de valores pares no arranjo vals
• int comparaArranjos(int[] x, int[] y): retorna:
– 0, se as quantidades de números pares dos arranjos x e y forem iguais;
– -1, se a quantidade de números pares em x for maior que em y;
– 1, se a quantidade de números pares em y for maior que em x;

Restrições
• A função main deve usar apenas a função comparaArranjos
• A função comparaArranjos deve chamar a função contaPares
*/

package ifsc.alg.lista09;

import java.io.PrintStream;
import java.util.Scanner;

public class L9E2 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    /**
     * Conta quantos elementos de vals são pares
     */
    static int contaPares(int[] vals) {
        int res = 0;
        for (int val : vals) {
            if (val % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    /**
     * Compara dois arranjos e determina qual possui mais elementos pares
     */
    static int comparaArranjos(int[] x, int[] y) {
        // Equivalente à Integer.compare(paresX, paresY);
        int paresX = contaPares(x), paresY = contaPares(y);
        if (paresX == paresY) {
            return 0;
        } else if (paresX > paresY) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Lê um arranjo de inteiros de tamanho tam
     */
    static int[] lerArranjo(int tam, String rotulo) {
        int[] arr = new int[tam];
        OUT.printf("Entre com os valores do %s arranjo: ", rotulo);
        for (int i = 0; i < tam; i++) {
            arr[i] = IN.nextInt();
        }
        return arr;
    }

    /**
     * Função principal do programa
     */
    public static void main(String[] args) {
        int tam;
        do {
            OUT.print("Entre com o tamanho dos arranjos: ");
            tam = IN.nextInt();
        } while (tam <= 0);

        int[] primeiro = lerArranjo(tam, "primeiro");
        int[] segundo = lerArranjo(tam, "segundo");

        switch (comparaArranjos(primeiro, segundo)) {
            case -1 -> OUT.println("O primeiro arranjo possui mais pares");
            case 0 -> OUT.println("Os arranjos possuem o mesmo número de pares");
            case 1 -> OUT.println("O segundo arranjo possui mais pares");
        }
    }
}
