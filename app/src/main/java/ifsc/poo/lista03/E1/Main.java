package ifsc.poo.lista03.E1;

import ifsc.poo.lista03.E1.domain.Conta;
import ifsc.poo.lista03.E1.domain.ContaEspecial;

public class Main {
    public static void main(String[] args) {
        Conta c1 = new ContaEspecial();
        System.out.println(c1);
        c1.deposito(10_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
        c1.saque(1_00);
        System.out.println(c1);
    }
}
