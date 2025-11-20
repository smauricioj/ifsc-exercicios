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

    // Acessos
    public BigDecimal getSaldo() {
        return saldo;
    }

    // Métodos
    public void deposito(BigDecimal valor) {
        this.saldo = saldo.add(valor);
    }

    public boolean saque(BigDecimal valor) {
        return this.saque(valor, TAXA_OPERACAO, CHEQUE_ZERO);
    }

    // Utilitários

    /**
     * Método protegido que implementa o saque de um valor em centavos com base na taxa de operação
     * e no valor do cheque especial. Assim, as subclasses só precisam informar esses parâmetros para
     * ter seu comportamento especializado, mas sem precisar reimplementar a lógica da operação
     *
     * @param valor ($) a ser sacado
     * @param taxa (%) taxa de operação
     * @param cheque ($) valor do cheque especial da conta
     * @return true se saque pode ser feito, false caso contrário
     */
    protected final boolean saque(BigDecimal valor, double taxa, BigDecimal cheque) {
        BigDecimal remocao = valor.multiply(BigDecimal.valueOf(1+taxa));
        if (this.saldo.add(cheque).compareTo(remocao) >= 0) {
            this.saldo = this.saldo.subtract(remocao);
            return true;
        }
        return false;
    }

    @Override
    public final String toString() {
        return String.format("%s{saldo=%.2f}%n", this.getClass().getSimpleName(), this.saldo.setScale(2, RoundingMode.HALF_EVEN));
    }
}
