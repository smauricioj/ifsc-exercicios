package ifsc.poo.lista03.E3.domain;

import java.util.Arrays;
import java.util.Objects;

public class Retangulo extends ObjetoDeDesenho {
    private final Ponto verticeI, verticeF;

    public Retangulo(Ponto verticeI, Ponto verticeF) {
        super();
        Objects.requireNonNull(verticeI, "O vértice precisa ser informado");
        Objects.requireNonNull(verticeF, "O vértice precisa ser informado");
        this.verticeI = verticeI;
        this.verticeF = verticeF;
    }

    @Override
    public String desenhar() {
        return String.format("Um retângulo entre %s e %s, com espessura de linha %d e cor %s",
                this.verticeI, this.verticeF, this.espessuraDaLinha, this.corDaLinha
        );
    }

    public double getLargura() {
        return Math.abs(verticeI.x() - this.verticeF.x());
    }

    public double getAltura() {
        return Math.abs(verticeI.y() - this.verticeF.y());
    }

    public double[] getLados() {
        return new double[]{
                this.getLargura(), this.getAltura(),
                this.getLargura(), this.getAltura()
        };
    }

    public double getArea() {
        return this.getLargura() * this.getAltura();
    }

    public double getPerimetro() {
        return Arrays.stream(this.getLados()).sum();
    }
}
