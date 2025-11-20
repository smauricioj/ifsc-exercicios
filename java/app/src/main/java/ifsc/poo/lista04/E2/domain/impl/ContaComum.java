package ifsc.poo.lista04.E2.domain.impl;

import ifsc.poo.lista04.E2.domain.core.Conta;

import java.math.BigDecimal;

public class ContaComum extends Conta {
    public static final BigDecimal CHEQUE_ZERO;
    public static final double TAXA_SAQUE;

    static {
        CHEQUE_ZERO = BigDecimal.ZERO;
        TAXA_SAQUE = 0.0;
    }

    public ContaComum(){
        super();
    }

    @Override
    public boolean saque(BigDecimal valor) {
        return super.saquePadrao(valor, TAXA_SAQUE, CHEQUE_ZERO);
    }

    public boolean deposito(BigDecimal valor) {
        return super.depositoPadrao(valor);
    }
}
