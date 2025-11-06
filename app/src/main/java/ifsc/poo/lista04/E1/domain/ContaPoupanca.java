package ifsc.poo.lista04.E1.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaPoupanca extends Conta implements Poupanca{

    private final byte diaRendimento;

    public ContaPoupanca() {
        super();
        diaRendimento = (byte) LocalDate.now().getDayOfMonth();
    }

    @Override
    public void render() {
        if (LocalDate.now().getDayOfMonth() == this.diaRendimento) {
            this.saldo = this.saldo.multiply(BigDecimal.valueOf(0.001));
        }
    }
}
