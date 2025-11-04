package ifsc.poo.lista03.E1;

import ifsc.poo.lista03.E1.domain.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        int count;

        Conta c1 = new Conta();
        c1.deposito(BigDecimal.valueOf(100.0));
        System.out.println(c1);
        count = 0;
        while (c1.saque(BigDecimal.valueOf(1.0))) {
            count++;
        }
        System.out.printf("Após %d saques: %s%n", count, c1);

        ContaEspecial c2 = new ContaEspecial();
        c2.deposito(BigDecimal.valueOf(100.0));
        System.out.println(c2);
        count = 0;
        while (c2.saque(BigDecimal.valueOf(1.0))) {
            count++;
        }
        System.out.printf("Após %d saques: %s%n", count, c2);
    }
}
