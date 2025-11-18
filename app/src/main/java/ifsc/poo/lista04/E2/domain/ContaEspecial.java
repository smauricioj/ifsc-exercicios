package ifsc.poo.lista04.E2.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaEspecial extends Conta implements ComRendimento {
    public static final BigDecimal CHEQUE_ESPECIAL;
    public static final double TAXA_SAQUE;
    public static final double RENDIMENTO;
    public static final double TAXA_SALDO_DEVEDOR;

    static {
        CHEQUE_ESPECIAL = BigDecimal.valueOf(1_000.00);
        TAXA_SAQUE = 0.1 / 100;
        RENDIMENTO = 0.2 / 100;
        TAXA_SALDO_DEVEDOR = 2.0 / 100;
    }

    private final byte diaRendimento;
    private boolean negligente;

    public ContaEspecial(){
        super();
        diaRendimento = (byte) LocalDate.now().getDayOfMonth();
        negligente = false;
    }

    @Override
    public boolean saque(BigDecimal valor) {
        if (negligente) return false;
        return super.saquePadrao(valor, TAXA_SAQUE, CHEQUE_ESPECIAL);
    }

    @Override
    public boolean deposito(BigDecimal valor) {
        if (negligente) return false;
        return super.depositoPadrao(valor);
    }

    @Override
    public void render() {
        if ((byte) LocalDate.now().getDayOfMonth() != this.diaRendimento || this.saldo.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        if (this.saldo.compareTo(BigDecimal.ZERO) > 0) {
            this.saldo = this.saldo.multiply(BigDecimal.valueOf(1 + RENDIMENTO));
            return;
        }
        this.saldo = this.saldo.multiply(BigDecimal.valueOf(1 + TAXA_SALDO_DEVEDOR));
        if (this.saldo.compareTo(CHEQUE_ESPECIAL) < 0) {
            this.negligente = true;
        }
    }
}
