package ifsc.alg.aula11;

import java.util.Scanner;

public class MediaMenosUmBase {

    static double menorDeTres(double a, double b, double c) {
        double menor = a;
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }
        return menor;
    }

    static double calcularMediaDasMaiores(double v1, double v2, double v3) {
        return (v1 + v2 + v3 - menorDeTres(v1, v2, v3)) / 2.0;
    }

    static double calcularMediaFinal(double provas, double trabalhos) {
        return 0.8 * provas + 0.2 * trabalhos;
    }

    public static void main(String[] args) {
        // Vars
        Scanner sc = new Scanner(System.in);

        // Início
        System.out.print("Entre com as notas das provas: ");
        double mediaProvas = calcularMediaDasMaiores(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.print("Entre com as notas dos trabalhos: ");
        double mediaTrabalhos = calcularMediaDasMaiores(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.printf("Média final: %.2f%n", calcularMediaFinal(mediaProvas, mediaTrabalhos));
        sc.close();
    }
}
