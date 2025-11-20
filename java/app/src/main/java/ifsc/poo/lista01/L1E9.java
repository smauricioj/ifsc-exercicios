package ifsc.poo.lista01;

public class L1E9 {
    public static void main(String[] args) {
        byte tam = 10;
        int[][] mat = new int[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (i < j) {
                    mat[i][j] = (2 * i) + (7 * j) - 2;
                }
                else if (i == j) {
                    mat[i][j] = (3 * i * i) - 1;
                } else {
                    mat[i][j] = (4 * i * i * i) - (5 * j * j);
                }
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
