package ifsc.poo.lista03.E3.domain;

import java.awt.Color;
import java.util.Objects;

public class ObjetoDeDesenho {
    protected static final Color COR_PADRAO;

    static {
        COR_PADRAO = Color.BLACK;
    }

    protected Color corDaLinha;

    public ObjetoDeDesenho() {
        this(COR_PADRAO);
    }

    public ObjetoDeDesenho(Color corDaLinha) {
        if (Objects.isNull(corDaLinha)) {
            corDaLinha = COR_PADRAO;
        }
        this.corDaLinha = corDaLinha;
    }

    public String desenhar() {
        return String.format("Figura genérica com cor da linha %s", this.corDaLinha);
    }
}
