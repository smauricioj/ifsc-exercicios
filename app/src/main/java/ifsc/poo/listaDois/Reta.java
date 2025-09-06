package ifsc.poo.listaDois;

import java.text.DecimalFormat;
import java.util.Objects;

public class Reta {
    // Estáticos
    // Para mostrar até 4 casas decimais sempre significativas
    static private final DecimalFormat df = new DecimalFormat("0.####");

    // Atributos
    private double ang, lin;

    // Construtores
    public Reta(double ang, double lin){
        this.ang = ang;
        this.lin = lin;
    }

    public Reta(Ponto2D p1, Ponto2D p2){
        if (Objects.isNull(p1)) p1 = new Ponto2D();
        if (Objects.isNull(p2)) p2 = new Ponto2D();
        this.ang = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        this.lin = p1.getY() - this.ang*p1.getX();
    }

    // Representação
    @Override
    public String toString() {
        return String.format("y=%sx%s%s", df.format(this.ang), (this.lin>=0)?"+":"", df.format(this.lin));
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reta outra)) return false;
        return Double.compare(ang, outra.ang) == 0 && Double.compare(lin, outra.lin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ang, lin);
    }

    // Acesso
    public double getAng() {
        return ang;
    }
    public double getLin() {
        return lin;
    }
    public void setAng(double ang) {
        this.ang = ang;
    }
    public void setLin(double lin) {
        this.lin = lin;
    }

    // Métodos
    public double getY(double x) {
        return this.ang*x + this.lin;
    }

    public double getX(double y) {
        return Double.isInfinite(this.ang) ? Double.NaN : (y - this.lin)/this.ang;
    }

    public boolean fazParte(Ponto2D ponto) {
        if (Objects.isNull(ponto)) return false;
        return Double.compare(this.getY(ponto.getX()), ponto.getY()) == 0;
    }

    public Ponto2D intersecao(Reta outra) {
        if (Objects.isNull(outra) || Double.compare(this.ang, outra.ang) == 0) return null;
        double x = (this.lin - outra.lin) / (outra.ang - this.ang);
        return new Ponto2D(x, this.getY(x));
    }

    public static void main(String[] args) {
        Reta r1 = new Reta(0.5, 3);
        Reta r2 = new Reta(-2, 10);
        Ponto2D p1 = new Ponto2D(-6, 0);
        Ponto2D p2 = new Ponto2D(0, 3);
        Ponto2D p3 = new Ponto2D(1, 5);
        // Prove que o ponto (−6, 0) faz parte da reta y = 0.5x + 3
        System.out.println(r1.fazParte(p1) ? "O ponto faz parte" : "O ponto não faz parte");
        // Prove que o ponto (2.8, 4.4) é a interseção das retas y1 = 0.5x + 3 e y2 = 10 − 2x
        System.out.println(r1.intersecao(r2));
        // Prove que os pontos (0, 3) e (1, 5) formam a reta y = 2x + 3
        System.out.println(new Reta(p2, p3));
    }
}
