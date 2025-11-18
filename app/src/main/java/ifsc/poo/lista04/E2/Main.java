package ifsc.poo.lista04.E2;

/*
Em uma aplicação 'profissional', o pacote de domínio poderia ser
subdivido em pacotes menores para cada tipo de classe. Por exemplo:

domain
├── api
│   └── ComRendimento.java
├── core
│   └── Conta.java
└── impl
    ├── ContaComum.java
    ├── ContaPoupanca.java
    └── ContaEspecial.java
 */

import ifsc.poo.lista04.E2.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Criando várias contas aleatórias
        Random r =  new Random();
        r.setSeed(0);
        List<Conta> contas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            contas.add(
                switch (r.nextInt(3)) {
                    case 0 -> new ContaComum();
                    case 1 -> new ContaPoupanca();
                    default -> new ContaEspecial();
                }
            );
        }

        // Testando comportamentos
        for (Conta conta : contas) {
            System.out.println("-".repeat(40));

            conta.deposito(BigDecimal.valueOf(r.nextDouble(100.0)));
            System.out.println(conta);

            boolean saqueRealizado = conta.saque(BigDecimal.valueOf(r.nextDouble(100.0)));
            System.out.println(saqueRealizado ? "Saque realizado" : "Saque nao realizado" );
            System.out.println(conta);

            if (conta instanceof ComRendimento) {
                ((ComRendimento) conta).render();
                System.out.println("Após rendimento mensal:"+conta);
            }
        }
    }
}
