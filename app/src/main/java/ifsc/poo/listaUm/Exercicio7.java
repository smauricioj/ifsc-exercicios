package ifsc.poo.listaUm;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            System.out.print("Digite o valor de n: ");
            n = sc.nextInt();
        } while (n < 0);
        int[] linhaAtual = new int[n], linhaAnterior = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                linhaAtual[j] = (j == 0 || j == i) ? 1 : linhaAnterior[j - 1] + linhaAnterior[j];
                System.out.print(linhaAtual[j] + " ");
            }
            System.out.println();
            System.arraycopy(linhaAtual, 0, linhaAnterior, 0, i + 1);
        }
    }
}
