package ifsc.poo.lista03.E1.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Conta {
    // Estáticos
    public static final BigDecimal CHEQUE_ZERO;
    public static final double TAXA_OPERACAO;

    static {
        CHEQUE_ZERO = BigDecimal.ZERO;
        TAXA_OPERACAO = 0.5 / 100;
    }

    // Atributos
    protected BigDecimal saldo;

    // Construtor
    public Conta() {
        this.saldo = BigDecimal.ZERO;
    }

    // Métodos
    public void deposito(int centavos) {
        this.saldo = saldo.add(emReais(centavos));
    }

    public void saque(int centavos) {
        this.saque(centavos, TAXA_OPERACAO, CHEQUE_ZERO);
    }

    // Utilitários

    /**
     * Method protegido que implementa o saque de um valor em centavos com base na taxa de operação
     * e no valor do cheque especial. Assim, as subclasses só precisam informar esses parâmetros para
     * ter seu comportamento especializado, mas sem precisar reimplementar a lógica da operação
     *
     * @param centavos (de $) valor a ser sacado
     * @param taxa (%) taxa de operação
     * @param cheque ($) valor do cheque especial da conta
     */
    protected void saque(int centavos, double taxa, BigDecimal cheque) {
        BigDecimal reais = emReais(centavos).multiply(BigDecimal.valueOf(1+taxa));
        if (reais.compareTo(this.saldo.add(cheque)) <= 0) {
            this.saldo = this.saldo.subtract(reais);
        }
    }

    /**
     * Transforma um valor de centavos para reais
     */
    static private BigDecimal emReais(int centavos) {
        return BigDecimal.valueOf(centavos).divide(BigDecimal.valueOf(100.0), RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return String.format("Conta{saldo=%.2f}%n", this.saldo.setScale(2, RoundingMode.HALF_EVEN));
    }
}
