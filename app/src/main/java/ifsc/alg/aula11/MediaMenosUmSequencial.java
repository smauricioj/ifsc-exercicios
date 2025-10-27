package ifsc.alg.aula11;

import java.util.Scanner;

public class MediaMenosUmSequencial {
    public static void main(String[] args) {
        double mediaProvas, mediaTrabalhos, nota1, nota2, nota3, notaMenor;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com as notas das provas: ");
        nota1 = sc.nextDouble();
        nota2 = sc.nextDouble();
        nota3 = sc.nextDouble();
        notaMenor = nota1;
        if (nota2 < notaMenor) {
            notaMenor = nota2;
        }
        if (nota3 < notaMenor) {
            notaMenor = nota3;
        }
        mediaProvas = (nota1 + nota2 + nota3 - notaMenor) / 3;
        System.out.print("Entre com as notas dos trabalhos: ");
        nota1 = sc.nextDouble();
        nota2 = sc.nextDouble();
        nota3 = sc.nextDouble();
        notaMenor = nota1;
        if (nota2 < notaMenor) {
            notaMenor = nota2;
        }
        if (nota3 < notaMenor) {
            notaMenor = nota3;
        }
        mediaTrabalhos = (nota1 + nota2 + nota3 - notaMenor) / 3;
        System.out.printf("Média final: %.2f%n", 0.8 * mediaProvas + 0.2 * mediaTrabalhos);
        sc.close();
    }
}
