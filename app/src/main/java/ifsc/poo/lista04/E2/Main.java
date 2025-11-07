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
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int count;

        ContaComum c1 = new ContaComum();
        c1.deposito(BigDecimal.valueOf(100.0));
        System.out.println(c1);
        count = 0;
        while (c1.saque(BigDecimal.valueOf(1.0))) {
            count++;
        }
        System.out.printf("Após %d saques de R$1: %s%n", count, c1);

        ContaPoupanca c2 = new ContaPoupanca();
        c2.deposito(BigDecimal.valueOf(100.0));
        System.out.println(c2);
        count = 0;
        while (c2.saque(BigDecimal.valueOf(1.0))) {
            count++;
        }
        System.out.printf("Após %d saques de R$1: %s%n", count, c2);
        c2.deposito(BigDecimal.valueOf(1000).subtract(c2.getSaldo()));
        c2.render((byte) LocalDate.now().getDayOfMonth());
        System.out.printf("Após render com R$1000: %s%n", c2);

        ContaEspecial c3 = new ContaEspecial();
        c3.deposito(BigDecimal.valueOf(100.0));
        System.out.println(c3);
        count = 0;
        while (c3.saque(BigDecimal.valueOf(1.0))) {
            count++;
        }
        System.out.printf("Após %d saques de R$1: %s%n", count, c3);
        c3.deposito(BigDecimal.valueOf(1000).subtract(c3.getSaldo()));
        c3.render((byte) LocalDate.now().getDayOfMonth());
        System.out.printf("Após render com R$1000: %s%n", c3);
    }
}
