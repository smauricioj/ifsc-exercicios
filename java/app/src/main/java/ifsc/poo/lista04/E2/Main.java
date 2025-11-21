package ifsc.poo.lista04.E2;

import ifsc.poo.lista04.E2.domain.api.ComRendimento;
import ifsc.poo.lista04.E2.domain.core.Conta;
import ifsc.poo.lista04.E2.domain.impl.ContaComum;
import ifsc.poo.lista04.E2.domain.impl.ContaEspecial;
import ifsc.poo.lista04.E2.domain.impl.ContaPoupanca;

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

            // Polimorfismo no invocar de deposito()
            conta.deposito(BigDecimal.valueOf(r.nextDouble(100.0)));
            System.out.println(conta);

            // Polimorfismo no invocar de saque()
            boolean saqueRealizado = conta.saque(BigDecimal.valueOf(r.nextDouble(100.0)));
            System.out.println(saqueRealizado ? "Saque realizado" : "Saque nao realizado" );
            System.out.println(conta);

            if (conta instanceof ComRendimento) {
                // Polimorfismo no invocar de render()
                ((ComRendimento) conta).render();
                System.out.println("Após rendimento mensal:"+conta);
            }
        }
    }
}
