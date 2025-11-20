package ifsc.poo.lista03.E3.domain;

import java.util.Arrays;
import java.util.Objects;

public class Triangulo extends ObjetoDeDesenho{
    private final Ponto v1, v2, v3;

    public Triangulo(Ponto v1, Ponto v2, Ponto v3) {
        super();
        Objects.requireNonNull(v1, "O vértice deve ser informado");
        Objects.requireNonNull(v2, "O vértice deve ser informado");
        Objects.requireNonNull(v3, "O vértice deve ser informado");
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String desenhar() {
        return String.format("Um triângulo com vértices %s, %s e %s, espessura de linha %d e cor %s",
                v1, v2, v3, this.espessuraDaLinha, this.corDaLinha
        );
    }

    static private double xVezesDeltaY(Ponto p1, Ponto p2, Ponto p3) {
        return p1.x() * (p2.y() - p3.y());
    }

    public double[] getLados() {
        return new double[]{v1.distancia(v2), v2.distancia(v3), v3.distancia(v1)};
    }

    public double getArea() {
        return Math.abs(xVezesDeltaY(v1, v2, v3) + xVezesDeltaY(v2, v3, v1) + xVezesDeltaY(v3, v1, v2)) / 2;
    }

    public double getPerimetro() {
        return Arrays.stream(this.getLados()).sum();
    }
}
