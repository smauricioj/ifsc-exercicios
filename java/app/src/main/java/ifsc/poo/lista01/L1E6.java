package ifsc.poo.lista01;

import java.util.Scanner;

public class L1E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] valoresTexto = sc.nextLine().split(";");
        int[] valores = new int[valoresTexto.length];
        for (int i = 0; i < valoresTexto.length; i++) {
            valores[i] = Integer.parseInt(valoresTexto[i]);
        }
        double m = media(valores), sum = 0;
        for (int valor : valores)
            sum += Math.pow((valor - m), 2);
        double dp = Math.sqrt(sum / (valores.length - 1));
        System.out.printf("%.2f\n", dp);
        sc.close();
    }

    static double media(int[] arr) {
        double m = 0.0;
        for (int v : arr)
            m += v;
        return m / arr.length;
    }
}
