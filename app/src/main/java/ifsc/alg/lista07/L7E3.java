package ifsc.alg.lista07;

import java.util.Scanner;

public class L7E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com a classe (1-arqueiro, 2-bárbaro, 3-druida, 4-mago): ");
        int classe = sc.nextInt();

        if (classe < 1 || classe > 4) {
            System.out.println("Classe inválida");
            return;
        }

        System.out.print("Entre com a vitalidade desejada: ");
        int vitalidadeDesejada = sc.nextInt();
        int vitalidade = 0, incremento = 0, nivelNecessario = 0;

        switch (classe) {
            case 1 -> {
                vitalidade = 150;
                incremento = 10;
            }
            case 2 -> {
                vitalidade = 200;
                incremento = 15;
            }
            case 3 -> {
                vitalidade = 100;
                incremento = 5;
            }
            case 4 -> {
                vitalidade = 80;
                incremento = 4;
            }
        }

        while (vitalidade < vitalidadeDesejada) {
            // vitalidade += incremento * (++nivelNecessario % 5 == 0 ? 2 : 1);
            nivelNecessario++;
            vitalidade += incremento;
            if (nivelNecessario % 5 == 0) {
                vitalidade += incremento;
            }
        }

        System.out.printf("Nível necessário: %d%n", nivelNecessario);
        sc.close();
    }
}
