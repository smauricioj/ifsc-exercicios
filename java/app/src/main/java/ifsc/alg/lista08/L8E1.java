package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E1 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

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

    static double lerNaFaixa(String msg, double min, double max) {
        double entrada;
        do{
            OUT.print(msg);
            entrada = IN.nextDouble();
        } while(entrada < min || entrada > max);
        return entrada;
    }

    public static void main(String[] args) {
        int nAlunos = (int) lerNaFaixa("Entre com o número de alunos: ", 1, Integer.MAX_VALUE);
        double mediaDisciplina = 0.0;
        for (int i = 1; i <= nAlunos; i++) {
            OUT.printf("Entre com as notas das provas do aluno %d:%n", i);
            double mediaProvas = mediaMenosUm(
                    lerNaFaixa("\tNota 1: ",  0.0, 10.0),
                    lerNaFaixa("\tNota 2: ",  0.0, 10.0),
                    lerNaFaixa("\tNota 3: ",  0.0, 10.0)
            );
            OUT.printf("Entre com as notas dos trabalhos do aluno %d:%n", i);
            double mediaTrabalhos = mediaMenosUm(
                    lerNaFaixa("\tNota 1: ",  0.0, 10.0),
                    lerNaFaixa("\tNota 2: ",  0.0, 10.0),
                    lerNaFaixa("\tNota 3: ",  0.0, 10.0)
            );
            double mediaAluno = 0.8 * mediaProvas + 0.2 * mediaTrabalhos;
            OUT.printf("Média final do aluno %d: %.2f%n", i, mediaAluno);
            mediaDisciplina += mediaAluno;
        }
        OUT.printf("Média da disciplina: %.2f%n", mediaDisciplina/nAlunos);
        IN.close();
    }
}

