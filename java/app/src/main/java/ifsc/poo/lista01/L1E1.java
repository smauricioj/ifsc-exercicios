package ifsc.poo.lista01;

import java.util.Scanner;

public class L1E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a, b, c;
        System.out.print("Digite o valor de a: ");
        a = sc.nextFloat();
        System.out.print("Digite o valor de b: ");
        b = sc.nextFloat();
        System.out.print("Digite o valor de c: ");
        c = sc.nextFloat();
        System.out.printf("O valor do discriminante é %.2f\n", (b*b)-(4*a*c));
    }
}
