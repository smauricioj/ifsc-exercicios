package ifsc.poo.lista04.E1.domain;

import java.math.BigDecimal;

public class ContaComum extends Conta implements Corrente {
    public static final BigDecimal CHEQUE_ZERO;
    public static final double TAXA_OPERACAO;

    static {
        CHEQUE_ZERO = BigDecimal.ZERO;
        TAXA_OPERACAO = 0.5 / 100;
    }

    public ContaComum(){
        super();
    }

    @Override
    public boolean saque(BigDecimal valor) {
        return super.saquePadrao(valor, TAXA_OPERACAO, CHEQUE_ZERO);
    }
}
