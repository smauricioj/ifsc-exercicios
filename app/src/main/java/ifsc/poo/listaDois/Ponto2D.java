package ifsc.poo.listaDois;

import java.text.DecimalFormat;
import java.util.Objects;

public class Ponto2D {
    // Estáticos
    // Para mostrar até 4 casas decimais sempre significativas
    static private final DecimalFormat df = new DecimalFormat("0.####");

    // Atributos
    private double x, y;

    // Construtores
    public Ponto2D() {
        this(0,0);
    }

    public Ponto2D(Ponto2D p) {
        this(p.getX(), p.getY());
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Acessos
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    // Representação
    @Override
    public String toString() {
        return String.format("(x=%s; y=%s)", df.format(this.x), df.format(this.y));
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ponto2D outro)) return false;
        return Double.compare(x, outro.x) == 0
            && Double.compare(y, outro.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Métodos
    public double distancia(Ponto2D outro) {
        return Math.sqrt(Math.pow(this.x - outro.x, 2) + Math.pow(this.y - outro.y, 2));
    }

    public static void main(String[] args) {
        // Crie dois pontos, um na origem do plano e outro em (3, 4);
        Ponto2D p1 = new Ponto2D();
        Ponto2D p2 = new Ponto2D(3, 4);

        // Mostre que a distância entre os pontos é 5;
        System.out.println(p1.distancia(p2));

        // Mostre que esses pontos são diferentes.
        System.out.println((p1 == p2) ? "São iguais" : "São diferentes");
    }
}
