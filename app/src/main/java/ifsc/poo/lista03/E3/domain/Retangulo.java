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

    public double getArea() {
        double[] lados = this.getLados();
        return lados[0] * lados[2];
    }

    public double getPerimetro() {
        return Arrays.stream(this.getLados()).sum();
    }

    public double[] getLados() {
        double[] lados = new double[4];
        lados[0] = Math.abs(verticeI.x() - this.verticeF.x());
        lados[1] = Math.abs(verticeI.x() - this.verticeF.x());
        lados[2] = Math.abs(verticeI.y() - this.verticeF.y());
        lados[3] = Math.abs(verticeI.y() - this.verticeF.y());
        return lados;
    }
}
