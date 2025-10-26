package ifsc.alg.aula11;

import java.util.Scanner;

public class MediaMenosUm {
    static double menor3(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    static double mediaMenosUm(double x1, double x2, double x3) {
        return (x1 + x2 + x3 - menor3(x1, x2, x3)) / 2;
    }

    public static void main(String[] args) {
        double mediaProvas, mediaTrabalhos;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com as notas das provas: ");
        mediaProvas = mediaMenosUm(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.print("Entre com as notas dos trabalhos: ");
        mediaTrabalhos = mediaMenosUm(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.printf("Média final: %.2f%n", 0.8 * mediaProvas + 0.2 * mediaTrabalhos);
        sc.close();
    }
}
