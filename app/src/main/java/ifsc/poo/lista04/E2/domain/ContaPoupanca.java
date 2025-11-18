package ifsc.poo.lista04.E2.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPoupanca extends Conta implements ComRendimento {
    public static final BigDecimal CHEQUE_ESPECIAL;
    public static final double TAXA_SAQUE;
    public static final double RENDIMENTO;

    static {
        CHEQUE_ESPECIAL = BigDecimal.valueOf(0.0);
        TAXA_SAQUE = 0.5 / 100;
        RENDIMENTO = 0.1 / 100;
    }

    private final byte diaRendimento;

    public ContaPoupanca() {
        super();
        diaRendimento = (byte) LocalDate.now().getDayOfMonth();
    }

    @Override
    public boolean saque(BigDecimal valor) {
        return super.saquePadrao(valor, TAXA_SAQUE, CHEQUE_ESPECIAL);
    }

    @Override
    public boolean deposito(BigDecimal valor) {
        return super.depositoPadrao(valor);
    }

    @Override
    public void render() {
        if ((byte) LocalDate.now().getDayOfMonth() != this.diaRendimento || this.saldo.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        this.saldo = this.saldo.multiply(BigDecimal.valueOf(1 + RENDIMENTO));
    }
}
