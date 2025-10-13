/*
Elabore um programa Java que LÊ dois números reais representando o peso e
a altura de uma pessoa e ESCREVE o índice de massa corpórea (IMC) desta
pessoa, bem com a classificação do seu estado nutricional.
*/

package ifsc.alg.aula09;

import java.util.Scanner;

public class A9E1 {
    public static void main(String[] args) {
        // Variáveis
        Scanner sc = new Scanner(System.in);
        double peso, altura, imc;

        // Início
        System.out.print("Digite o peso: ");
        peso = sc.nextDouble();
        System.out.print("Digite a altura: ");
        altura = sc.nextDouble();

        if (peso < 0 || altura < 0) {
            System.out.println("Valor inválido!");
            sc.close();
            return;
        }

        imc = peso/(altura*altura);

        System.out.printf("IMC: %.2f, ", imc);
        if (imc >= 30) {
            System.out.println("Obesidade");
        } else if (imc >= 25) {
            System.out.println("Sobrepeso");
        } else if (imc >= 18.5) {
            System.out.println("Peso normal");
        } else {
            System.out.println("Abaixo do peso");
        }
        sc.close();
        // Fim
    }
}
