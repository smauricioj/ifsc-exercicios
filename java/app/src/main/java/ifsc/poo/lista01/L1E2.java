package ifsc.poo.lista01;

import java.util.Scanner;

public class L1E2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        byte[] P  = lerValores((byte) 4, "prova");
        byte[] Pj = lerValores((byte) 2, "projeto");
        System.out.print("Digite a presença (em %): ");
        byte pre = sc.nextByte();
        double mediaP = media(P), mediaPj = media(Pj);
        byte R = (mediaP >= 6 && mediaPj >= 6) ? (byte) Math.round( (3 * mediaP + 2 * mediaPj) / 5 ) : 0;
        System.out.printf("R: %d | Situacao: %s", R, (R >= 6 && pre >= 75) ? "Aprovado" : "Reprovado");
    }

    static byte[] lerValores(byte tam, String nome) {
        byte[] valores = new byte[tam];
        for (byte i = 0; i < tam; i++) {
            System.out.printf("Digite o valor de %s %d: ", nome, i+1);
            valores[i] = sc.nextByte();
        }
        return valores;
    }

    static double media(byte[] arr) {
        double m = 0;
        for (byte b : arr) m += b;
        return m / arr.length;
    }
}
