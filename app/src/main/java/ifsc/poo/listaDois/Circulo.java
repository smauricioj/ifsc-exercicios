package ifsc.poo.listaDois;

import java.util.Objects;

public class Circulo {
    // Estáticos
    private static int count;

    static {
        count = 0;
    }

    public static int totalCriados() {
        return count;
    }

    // Atributos
    Ponto2D centro;
    double raio;

    // Contrutores
    public Circulo() {
        this(new Ponto2D(), 1);
    }
    public Circulo(double raio) {
        this(new Ponto2D(), raio);
    }
    public Circulo(Ponto2D centro) {
        this(centro, 1);
    }
    public Circulo(Ponto2D centro, double raio) {
        if (Objects.isNull(centro)) centro = new Ponto2D();
        if (raio <= 0 || !Double.isFinite(raio)) raio = 1;
        this.centro = centro;
        this.raio = raio;
        count++;
    }

    // Acessos
    public double getRaio() {
        return this.raio;
    }
    public Ponto2D getCentro() {
        return new Ponto2D(this.centro);
    }

    // Representação
    @Override
    public String toString() {
        return "Circulo{" +
                "centro=" + this.centro +
                ", raio=" + this.raio +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circulo outro)) return false;
        return Double.compare(this.raio, outro.raio) == 0
            && Objects.equals(this.centro, outro.centro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.centro, this.raio);
    }

    // Métodos
    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * this.raio;
    }

    public void inflar() {
        this.inflar(1);
    }

    public void inflar(double aumento) {
        this.raio += aumento;
    }

    public void desinflar() {
        this.desinflar(1);
    }

    public void desinflar(double reducao) {
        this.raio -= reducao;
        if (this.raio < 0) this.raio = 0;
    }

    public void mover() {
        this.centro.setX(0);
        this.centro.setY(0);
    }

    public void mover(double dx, double dy) {
        this.centro.setX(this.centro.getX() + dx);
        this.centro.setY(this.centro.getY() + dy);
    }

    public void mover(Ponto2D ponto) {
        if (Objects.isNull(ponto)) return;
        this.centro = ponto;
    }

    public boolean contem(Ponto2D ponto) {
        return Double.compare(this.raio, this.centro.distancia(ponto)) >= 0;
    }

    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(new Ponto2D(1, 1), 1);
        Ponto2D p1 = new Ponto2D(0.5, 0.5);
        Ponto2D p2 = new Ponto2D(2, -2);
        if (c1.contem(p1) && c2.contem(p1)) System.out.println("p1 está dentro de c1 e c2");
        System.out.printf("Foram criados %d objetos Circulo\n", Circulo.totalCriados());
        c2.mover(p2);
        c2.inflar(5);
        if (c2.contem(p1)) System.out.println("p1 ainda está dentro de c2!");
    }
}
