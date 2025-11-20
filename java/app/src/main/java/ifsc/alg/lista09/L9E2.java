package ifsc.alg.lista09;

import java.io.PrintStream;
import java.util.Scanner;

public class L9E2 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    static int contaPares(int[] vals) {
        int res = 0;
        for(int val : vals){
            if (val % 2 == 0){
                res++;
            }
        }
        return res;
    }

    static int comparaArranjos(int[] x, int[] y) {
        int paresX = contaPares(x), paresY = contaPares(y);
        if (paresX == paresY) {
            return 0;
        } else if (paresX > paresY) {
            return -1;
        } else {
            return 1;
        }
        // Equivalente à Integer.compare(paresX, paresY);
    }

    static int[] lerArranjo(int tam, String rotulo) {
        int[] arr = new int[tam];
        OUT.printf("Entre com os valores do %s arranjo: ", rotulo);
        for (int i = 0; i < tam; i++) {
            arr[i] = IN.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int tam;
        do {
            OUT.print("Entre com o tamanho dos arranjos: ");
            tam = IN.nextInt();
        } while (tam <= 0);

        int[] primeiro = lerArranjo(tam, "primeiro");
        int[] segundo = lerArranjo(tam, "segundo");

        switch (comparaArranjos(primeiro, segundo)){
            case -1 -> OUT.println("O primeiro arranjo possui mais pares");
            case  0 -> OUT.println("Os arranjos possuem o mesmo número de pares");
            case  1 -> OUT.println("O segundo arranjo possui mais pares");
        }
    }
}
