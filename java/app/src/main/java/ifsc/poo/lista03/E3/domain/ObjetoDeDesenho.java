package ifsc.poo.lista03.E3.domain;

import java.awt.Color;
import java.util.Objects;

public class ObjetoDeDesenho {
    public static final Color COR_PADRAO;
    public static final int ESPESSURA_PADRAO;

    static {
        COR_PADRAO = Color.BLACK;
        ESPESSURA_PADRAO = 1;
    }

    protected Color corDaLinha;
    protected int espessuraDaLinha;

    public ObjetoDeDesenho() {
        this(COR_PADRAO, ESPESSURA_PADRAO);
    }

    private void checkInvariants() {
        if (Objects.isNull(corDaLinha)) {
            corDaLinha = COR_PADRAO;
        }
        if (espessuraDaLinha <= 0) {
            espessuraDaLinha = ESPESSURA_PADRAO;
        }
    }

    public ObjetoDeDesenho(Color corDaLinha, int espessuraDaLinha) {
        this.corDaLinha = corDaLinha;
        this.espessuraDaLinha = espessuraDaLinha;
        checkInvariants();
    }

    public String desenhar() {
        return String.format("Figura genérica com linha cor %s e espessura %d", this.corDaLinha, this.espessuraDaLinha);
    }

    // Getters e setters

    public Color getCorDaLinha() {
        return corDaLinha;
    }

    public int getEspessuraDaLinha() {
        return espessuraDaLinha;
    }

    public void setCorDaLinha(Color corDaLinha) {
        this.corDaLinha = corDaLinha;
        this.checkInvariants();
    }

    public void setEspessuraDaLinha(int espessuraDaLinha) {
        this.espessuraDaLinha = espessuraDaLinha;
        this.checkInvariants();
    }
}
