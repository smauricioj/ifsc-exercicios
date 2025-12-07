/*
A temperatura, medida de energia cinética das moléculas de um corpo, pode ser expressa em
múltiplas escalas: Celsius, Kelvin e Fahrenheit são as mais comuns. A conversão entre essas
escalas é dada pelas seguintes equações:
• Para converter Celsius para Fahrenheit: TF = 1,8TC + 32
• Para converter Celsius para Kelvin: TK = TC + 273,15

Tarefa
Escreva um programa Java que LÊ um valor de temperatura, a escala de entrada e a escala
de saída, e ESCREVE o valor da temperatura convertida da escala de entrada para a escala de
saída. As unidades de temperatura são representadas pelos caracteres C (Celsius), K (Kelvin) e
F (Fahrenheit).

Para esse programa, implemente as seguintes funções:
• double deCparaK(double t): converte a temperatura t de Celsius para Kelvin
• double deCparaF(double t): converte a temperatura t de Celsius para Fahrenheit
• double deKparaC(double t): ...
• ... todas as 6 combinações possíveis!
• double converteTemp(double t, char origem, char destino): converte a tempera-
tura t da escala origem para a escala destino

Restrições
• Kelvin é uma escala absoluta de temperatura. Portanto, seu valor nunca é negativo. Caso a
temperatura informada seja inválida, é necessário informar o usuário e encerrar o programa
antes da conversão.
• As funções que envolvem graus Celsius (deCparaF, deFparaC, etc...) devem ser implemen-
tadas com base nas fórmulas apresentadas
• As funções que não envolvem graus Celsius (deFparaK e deKparaF) devem ser implemen-
tadas exclusivamente em termos das funções anteriores
• A função converteTemp deve ser implementada em termos das demais funções
*/

package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E3 {
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    /**
     * Converte de Celcius para Fahrenheit
     */
    static double deCparaF(double t) {
        return 1.8 * t + 32;
    }

    /**
     * Converte de Fahrenheit para Celcius
     */
    static double deFparaC(double t) {
        return (t - 32) / 1.8;
    }

    /**
     * Converte de Celcius para Kelvin
     */
    static double deCparaK(double t) {
        return t + 273.15;
    }

    /**
     * Converte de Kelvin para Celcius
     */
    static double deKparaC(double t) {
        return t - 273.15;
    }

    /**
     * Converte de Fahrenheit para Kelvin
     */
    static double deFparaK(double t) {
        return deFparaC(deCparaK(t));
    }

    /**
     * Converte de Kelvin para Fahrenheit
     */
    static double deKparaF(double t) {
        return deKparaC(deCparaF(t));
    }

    /**
     * Converte uma temperatura t da escala origem para a escala destino
     */
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

    /**
     * Exaustivamente lê uma escala da entrada padrão
     */
    static char leiaEscala(String rotulo) {
        char escala;
        do {
            OUT.printf("Entre com a escala de %s (C, K ou F): ", rotulo);
            escala = IN.next().charAt(0);
        } while (escala != 'C' && escala != 'K' && escala != 'F');
        return escala;
    }

    /**
     * Função principal do programa
     */
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
