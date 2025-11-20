package ifsc.alg.lista09;

import java.util.Scanner;

public class L9E3 {
    static double media(int[] vals) {
        double res = 0.0;
        for (int val : vals) {
            res += val;
        }
        return res / vals.length;
    }

    static double desvioPadrao(int[] vals) {
        double media = media(vals);
        double sum = 0;
        for (int val : vals) {
            sum += Math.pow((val - media), 2);
        }
        return Math.sqrt(sum / (vals.length - 1));
    }

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
    }
}
