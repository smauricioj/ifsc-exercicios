package ifsc.alg.lista06;

import java.util.Scanner;

public class L6E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro de 1 a 99: ");
        int n = sc.nextInt();
        if (n < 1 || n > 99) {
            System.out.println("Valor inválido!");
            sc.close();
            return;
        }
        System.out.print("Número por extenso: ");
        
        int unidade = n % 10;
        int dezena = n / 10;

        if (dezena == 1) {
            // Casos especiais das dezenas
            switch (unidade) {
                case 0 -> System.out.println("dez");
                case 1 -> System.out.println("onze");
                case 2 -> System.out.println("doze");
                case 3 -> System.out.println("treze");
                case 4 -> System.out.println("quatorze");
                case 5 -> System.out.println("quinze");
                case 6 -> System.out.println("dezesseis");
                case 7 -> System.out.println("dezessete");
                case 8 -> System.out.println("dezoito");
                case 9 -> System.out.println("dezenove");
            }
            sc.close();
            return;
        }

        // Casos normais
        switch (dezena) {
            case 2 -> System.out.print("vinte");
            case 3 -> System.out.print("trinta");
            case 4 -> System.out.print("quarenta");
            case 5 -> System.out.print("cinquenta");
            case 6 -> System.out.print("sessenta");
            case 7 -> System.out.print("setenta");
            case 8 -> System.out.print("oitenta");
            case 9 -> System.out.print("noventa");
        }
        if (dezena != 0 && unidade != 0) {
            System.out.print(" e ");
        }
        switch (unidade) {
            case 1 -> System.out.print("um");
            case 2 -> System.out.print("dois");
            case 3 -> System.out.print("três");
            case 4 -> System.out.print("quatro");
            case 5 -> System.out.print("cinco");
            case 6 -> System.out.print("seis");
            case 7 -> System.out.print("sete");
            case 8 -> System.out.print("oito");
            case 9 -> System.out.print("nove");
        }
        sc.close();
    }
}
