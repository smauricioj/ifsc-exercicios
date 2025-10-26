package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E2 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    static int leiaPositivo() {
        int entrada;
        do {
            OUT.print("Entre com um inteiro positivo: ");
            entrada = IN.nextInt();
        } while (entrada < 0);
        return entrada;
    }

    static int somaDivisores(int n) {
        int soma = 1;
        for (int i = 2; i <= n / 2; i++) {        // Só preciso verificar até a metade do número
            if (n % i == 0) {
                soma = soma + i;
            }
        }
        return soma;
    }

    static boolean saoAmigos(int n1, int n2) {
        return somaDivisores(n1) == n2 && somaDivisores(n2) == n1;
    }

    public static void main(String[] args) {
        OUT.printf("Os números%s são amigos%n", saoAmigos(leiaPositivo(), leiaPositivo()) ? "" : " não");
        IN.close();
        /*
        Como encontrar amigos:

        for (int i = 0; i < 3200; i++) {
            for (int j = 0; j < i; j++) {         // Todas as combinações de (0, 0) até (3200, 3200)
                if (saoAmigos(i, j)) {
                    OUT.println(i + " " + j);
                }
            }
        }
        */
    }
}
