package ifsc.poo.lista03.E3.domain;

import java.awt.*;

public class Linha extends ObjetoDeDesenho {
    private final Ponto inicio;
    private final Ponto fim;

    public Linha(Ponto inicio, Ponto fim) {
        super();
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public String desenhar() {
        return String.format("Linha %s de %s para %s", this.corDaLinha, this.inicio, this.fim);
    }

    public double tamanho() {
        return this.inicio.distancia(this.fim);
    }
}
