package ifsc.alg.aula11;

import java.util.Scanner;

public class MediaMenosUm {
    static double menorDeTres(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    static double calcularMediaDosMaiores(double x1, double x2, double x3) {
        return (x1 + x2 + x3 - menorDeTres(x1, x2, x3)) / 2;
    }

    static double calcularMediaFinal(double p, double t) {
        return 0.8 * p + 0.2 * t;
    }

    public static void main(String[] args) {
        double mediaProvas, mediaTrabalhos;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com as notas das provas: ");
        mediaProvas = calcularMediaDosMaiores(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.print("Entre com as notas dos trabalhos: ");
        mediaTrabalhos = calcularMediaDosMaiores(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.printf("Média final: %.2f%n", calcularMediaFinal(mediaProvas, mediaTrabalhos));
        sc.close();
    }
}
