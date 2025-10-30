package ifsc.poo.lista03.E1.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conta {
    public static final double TAXA_OPERACAO;

    static {
        TAXA_OPERACAO = 0.005;
    }

    protected BigDecimal saldo;

    public Conta() {
        this.saldo = BigDecimal.ZERO;
    }

    static private BigDecimal emReais(int centavos) {
        return BigDecimal.valueOf(centavos).divide(BigDecimal.valueOf(100.0), RoundingMode.HALF_EVEN);
    }

    public void deposito(int centavos) {
        this.saldo = saldo.add(emReais(centavos));
    }

    public void saque(int centavos) {
        this.saque(centavos, TAXA_OPERACAO, BigDecimal.ZERO);
    }

    protected void saque(int centavos, double taxa, BigDecimal cheque) {
        BigDecimal reais = emReais(centavos).multiply(BigDecimal.valueOf(1+taxa));
        if (reais.compareTo(this.saldo.add(cheque)) <= 0) {
            this.saldo = this.saldo.subtract(reais);
        }
    }

    @Override
    public String toString() {
        return String.format("Conta{saldo=%.2f}%n", this.saldo.setScale(2, RoundingMode.HALF_EVEN));
    }
}
