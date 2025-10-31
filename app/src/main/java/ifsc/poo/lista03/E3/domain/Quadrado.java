package ifsc.poo.lista03.E3.domain;

public class Quadrado extends Retangulo{
    public Quadrado(Ponto centro, double lado) {
        super(new Ponto(centro.x() - (lado/2), centro.y() - (lado/2)),
              new Ponto(centro.x() + (lado/2), centro.y() + (lado/2))
        );
    }
}
