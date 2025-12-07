/*
Dois números inteiros positivos e diferentes a e b são amigos se a soma dos divisores de a (com
exceção do próprio a) é igual a b e a soma dos divisores de b (com exceção do próprio b) é igual
a a. Por exemplo, 220 e 284 são amigos, pois:
• os divisores de 220 são {1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110} e a soma deles é 284
• os divisores de 284 são {1, 2, 4, 71, 142} e a soma deles é 220

Tarefa
Escreva um programa Java que LÊ dois inteiros positivos e ESCREVE se os números fornecidos
são amigos ou não.
Para esse programa, implemente as seguintes funções:
• int somaDivisores(int n) : Calcula a soma dos divisores de n (com exceção do próprio n)
• boolean saoAmigos(int n1, int n2) : Retorna true se n1 e n2 são amigos, false caso contrário

Restrições
• A função somaDivisores deve ser implementada utilizando o comando for
• A função saoAmigos deve ser implementada usando a função somaDivisores e outros
operadores lógicos, sem o uso de comandos de decisão (if, switch ou operador ternário)
*/

package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E2 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    /**
     * Exaustivamente lê um inteiro positivo da entrada padrão do sistema
     */
    static int leiaPositivo() {
        int entrada;
        do {
            OUT.print("Entre com um inteiro positivo: ");
            entrada = IN.nextInt();
        } while (entrada < 0);
        return entrada;
    }

    /**
     * Calcula a soma dos divisores de um inteiro n
     */
    static int somaDivisores(int n) {
        int soma = 1;
        for (int i = 2; i <= n / 2; i++) { // Só até a metade
            if (n % i == 0) {
                soma = soma + i;
            }
        }
        return soma;
    }

    /**
     * Descobre se dois inteiros são amigos
     */
    static boolean saoAmigos(int n1, int n2) {
        return somaDivisores(n1) == n2 && somaDivisores(n2) == n1;
    }

    /**
     * Função principal do programa
     */
    public static void main(String[] args) {
        boolean amigos = saoAmigos(leiaPositivo(), leiaPositivo());
        OUT.printf("Os números%s são amigos%s%n", amigos ? "" : " não", amigos ? " :)" : "");
        IN.close();
        /*
         * Como encontrar amigos:
         * 
         * for (int i = 0; i < 3200; i++) { //
         * for (int j = 0; j < i; j++) { // Todas as combinações de (0, 0) até (3200,
         * 3200)
         * if (saoAmigos(i, j)) {
         * OUT.println(i + " " + j);
         * }
         * }
         * }
         */
    }
}
