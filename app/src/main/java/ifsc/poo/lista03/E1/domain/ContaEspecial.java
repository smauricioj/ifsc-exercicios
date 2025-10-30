package ifsc.poo.lista03.E1.domain;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {
    public static final BigDecimal CHEQUE_ESPECIAL;
    public static final double TAXA_OPERACAO;

    static {
        CHEQUE_ESPECIAL = BigDecimal.valueOf(1_000.00);
        TAXA_OPERACAO = 0.001;
    }

    public ContaEspecial() {
        super();
    }

    @Override
    public void saque(int centavos) {
        this.saque(centavos, TAXA_OPERACAO, CHEQUE_ESPECIAL);
    }
}
