package ifsc.poo.lista03.E3.domain;

import java.awt.*;

public class Circulo extends ObjetoDeDesenho{
    private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        super();
        this.centro = centro;
        this.raio = Math.max(raio, 0);
    }

    @Override
    public String desenhar() {
        return String.format("Circulo com centro em %s e raio %.3f", this.centro, this.raio);
    }


}
