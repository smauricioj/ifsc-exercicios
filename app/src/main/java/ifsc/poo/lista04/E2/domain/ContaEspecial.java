package ifsc.poo.lista04.E2.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaEspecial extends Conta implements ComRendimento {
    public static final BigDecimal CHEQUE_ESPECIAL;
    public static final double TAXA_SAQUE;
    public static final double RENDIMENTO;

    static {
        CHEQUE_ESPECIAL = BigDecimal.valueOf(1_000.00);
        TAXA_SAQUE = 0.1 / 100;
        RENDIMENTO = 0.2 / 100;
    }

    private final byte diaRendimento;

    public ContaEspecial(){
        super();
        diaRendimento = (byte) LocalDate.now().getDayOfMonth();
    }

    @Override
    public boolean saque(BigDecimal valor) {
        return super.saquePadrao(valor, TAXA_SAQUE, CHEQUE_ESPECIAL);
    }

    @Override
    public void render(byte diaDoMes) {
        if (diaDoMes == this.diaRendimento
                && this.saldo.compareTo(BigDecimal.ZERO) >= 0) {
            this.saldo = this.saldo.multiply(BigDecimal.valueOf(1 + RENDIMENTO));
        }
    }
}
