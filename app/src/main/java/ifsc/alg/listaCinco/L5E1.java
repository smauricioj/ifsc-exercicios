package ifsc.alg.listaCinco;

import java.util.Scanner;

public class L5E1 {
    public static void main(String[] args) {
        // Variáveis
        double tempC, tempF;

        // Início
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor da temperatura em Fahrenheit: ");
        tempF = sc.nextDouble();            // 'Leia tempF'
        tempC = (tempF - 32)*(5.0 / 9.0);   // Atenção para a divisão de doubles!
        System.out.printf("Temperatura em Celcius: %.3f%n", tempC);
        sc.close();
        // Fim
    }
}
