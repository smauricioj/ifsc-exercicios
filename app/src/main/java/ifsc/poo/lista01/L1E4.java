package ifsc.poo.lista01;

import java.util.Scanner;

public class L1E4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Erro: não possui 1 argumento.");
            return;
        }
        int chave = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        String[] valoresTexto = sc.nextLine().split(";");
        int[] valores = new int[valoresTexto.length];
        for (int i = 0; i < valoresTexto.length; i++) {
            valores[i] = Integer.parseInt(valoresTexto[i]);
        }
        int index = buscaBinaria(valores, chave);
        System.out.println("Index: "+((index != -1) ? index : "ausente"));
    }

    static int buscaBinaria(int[] V, int chave) {
        int L = 0, R = V.length, M;
        do {
            M = (L + R) / 2;
            if (V[M] == chave) {
                return M;
            } else if (V[M] > chave) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        } while(L <= R);
        return -1;
    }
}
