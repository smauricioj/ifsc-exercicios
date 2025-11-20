package ifsc.poo.lista03.E3.domain;

import java.util.Objects;

public class Linha extends ObjetoDeDesenho {
    private final Ponto inicio;
    private final Ponto fim;

    public Linha(Ponto inicio, Ponto fim) {
        super();
        Objects.requireNonNull(inicio, "O vértice deve ser informado");
        Objects.requireNonNull(fim, "O vértice deve ser informado");
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
