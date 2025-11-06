package ifsc.poo.lista04.E1.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaEspecial extends Conta implements Corrente, Poupanca{
    public static final BigDecimal CHEQUE_ESPECIAL;
    public static final double TAXA_OPERACAO;

    private final byte diaRendimento;

    static {
        CHEQUE_ESPECIAL = BigDecimal.valueOf(1_000.00);
        TAXA_OPERACAO = 0.1 / 100;
    }

    public ContaEspecial(){
        super();
        diaRendimento = (byte) LocalDate.now().getDayOfMonth();
    }

    @Override
    public boolean saque(BigDecimal valor) {
        return super.saquePadrao(valor, TAXA_OPERACAO, CHEQUE_ESPECIAL);
    }

    @Override
    public void render() {
        if (LocalDate.now().getDayOfMonth() == this.diaRendimento) {
            this.saldo = this.saldo.multiply(BigDecimal.valueOf(0.001));
        }
    }
}
