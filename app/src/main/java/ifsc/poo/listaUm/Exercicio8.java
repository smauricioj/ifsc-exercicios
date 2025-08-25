package ifsc.poo.listaUm;

public class Exercicio8 {
    public static void main(String[] args) {
        byte[][] mat = new byte[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = (byte) ((i == j) ? 1 : 0);
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
