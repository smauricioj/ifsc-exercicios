package ifsc.poo.lista04.E1.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Conta {
    protected BigDecimal saldo;

    protected Conta() {
        saldo = BigDecimal.ZERO;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public final void deposito(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public abstract boolean saque(BigDecimal valor);

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
    protected final boolean saquePadrao(BigDecimal valor, double taxa, BigDecimal cheque) {
        BigDecimal remocao = valor.multiply(BigDecimal.valueOf(1.0+taxa));
        if (this.saldo.add(cheque).compareTo(remocao) >= 0) {
            this.saldo = this.saldo.subtract(remocao);
            return true;
        }
        return false;
    }

    @Override
    public final String toString() {
        return String.format("%s{saldo=%.2f}%n",
                this.getClass().getSimpleName(),
                this.saldo.setScale(2, RoundingMode.HALF_EVEN)
        );
    }
}
