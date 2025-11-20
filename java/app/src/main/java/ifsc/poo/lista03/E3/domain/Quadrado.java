package ifsc.poo.lista03.E3.domain;

public class Quadrado extends Retangulo{
    public Quadrado(Ponto canto, double lado) {
        super(canto, new Ponto(canto.x() + lado, canto.y() + lado));
    }
}
