package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E3 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    static double deCparaF(double t) {
        return 1.8*t + 32;
    }

    static double deFparaC(double t) {
        return (t - 32)/1.8;
    }

    static double deCparaK(double t) {
        return t + 273.15;
    }

    static double deKparaC(double t) {
        return t - 273.15;
    }

    static double deFparaK(double t) {
        return deFparaC(deCparaK(t));
    }

    static double deKparaF(double t) {
        return deKparaC(deCparaF(t));
    }

    static double converteTemp(double t, char origem, char destino) {
        if (origem == 'C' && destino == 'K') {
            return deCparaK(t);
        } else if (origem == 'C' && destino == 'F') {
            return deCparaF(t);
        } else if (origem == 'F' && destino == 'K') {
            return deFparaK(t);
        } else if (origem == 'F' && destino == 'C') {
            return deFparaC(t);
        } else if (origem == 'K' && destino == 'C') {
            return deKparaC(t);
        } else if (origem == 'K' && destino == 'F') {
            return deKparaF(t);
        } else {
            return t;
        }
    }

    static char leiaEscala(String rotulo) {
        char escala;
        do {
            OUT.printf("Entre com a escala de %s (C, K ou F): ", rotulo);
            escala = IN.next().charAt(0);
        } while (escala != 'C' && escala != 'K' && escala != 'F');
        return escala;
    }

    public static void main(String[] args) {
        OUT.print("Entre com uma temperatura: ");
        double temperatura = IN.nextDouble();
        char origem = leiaEscala("origem");
        char destino = leiaEscala("destino");
        if (converteTemp(temperatura, origem, 'K') < 0) {
            OUT.printf("Temperatura %.2f inválida", temperatura);
            return;
        }
        OUT.printf("Temperatura convertida: %.2f%n", converteTemp(temperatura, origem, destino));
        IN.close();
    }
}
