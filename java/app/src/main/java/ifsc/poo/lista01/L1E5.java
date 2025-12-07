package ifsc.poo.lista01;

import java.util.Scanner;

public class L1E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        char[] letras = texto.toCharArray();
        char[][] faixas = { { 'a', 'z' }, { 'A', 'Z' } };
        for (int i = 0; i < letras.length; i++) {
            for (char[] faixa : faixas) {
                if (letras[i] >= faixa[0] && letras[i] <= faixa[1]) {
                    letras[i] = (char) (((letras[i] - faixa[0] + 3) % 26) + faixa[0]);
                }
            }
        }
        System.out.println(new String(letras));
        sc.close();
    }
}
