package ifsc.poo.lista03.E3.domain;

public record Ponto(double x, double y) {
    public double distancia(Ponto p) {
        return Math.hypot(this.x - p.x, this.y - p.y);
    }
}
