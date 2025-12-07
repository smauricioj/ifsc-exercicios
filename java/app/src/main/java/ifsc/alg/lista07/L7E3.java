/*
Em um determinado jogo de interpretação de papéis, a vitalidade de um personagem aumenta a
cada nível alcançado pelo mesmo, de acordo com sua classe; além disso, cada classe começa
(no nível 0) com um valor de vitalidade pré-estabelecido. A tabela abaixo traz as informações
relevantes.

Classe   Vitalidade inicial Incremento por nível
Arqueiro 150                10
Bárbaro  200                15
Druida   100                5
Mago     80                 4

Há também o seguinte fator complicador que deve ser levado em conta: se o nível recém
alcançado for um múltiplo de 5, então o incremento é dobrado, a título de bônus para o
personagem.

Escreva um programa que LÊ a classe do personagem (codificada da seguinte maneira: 1 –
arqueiro, 2 – bárbaro, 3 – druida, 4 – mago) e um valor de vitalidade desejado e ESCREVE o
nível mínimo necessário que fornece vitalidade maior ou igual a desejada para a classe em
questão.
Caso o usuário entre com um código de classe fora da faixa de 1 a 4, o programa deve exibir uma
mensagem informando que a classe é inválida e terminar imediatamente. Utilize os comandos
switch e while na sua solução.
*/

package ifsc.alg.lista07;

import java.util.Scanner;

public class L7E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com a classe (1-arqueiro, 2-bárbaro, 3-druida, 4-mago): ");
        int classe = sc.nextInt();

        if (classe < 1 || classe > 4) {
            System.out.println("Classe inválida");
            sc.close();
            return;
        }

        System.out.print("Entre com a vitalidade desejada: ");
        int vitalidadeDesejada = sc.nextInt();
        int vitalidade = 0, incremento = 0;

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

        int nivelNecessario = 0;

        while (vitalidade < vitalidadeDesejada) {
            // Em uma linha só:
            // vitalidade += incremento * (++nivelNecessario % 5 == 0 ? 2 : 1);
            // Em várias, priorizando legibilidade:
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
