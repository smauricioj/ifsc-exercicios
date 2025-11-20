package ifsc.poo.lista03.E3;

import ifsc.poo.lista03.E3.domain.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Linha l = new Linha(
                new Ponto(0.0, 0.0),
                new Ponto(0.0, -2.0)
        );
        System.out.println(l.desenhar());
        System.out.println(l.tamanho());

        Circulo c = new Circulo(
                new Ponto(0.0, 0.0),
                5.0
        );
        System.out.println(c.desenhar());
        System.out.println(c.getArea());
        System.out.println(c.getPerimetro());

        Triangulo t = new Triangulo(
                new Ponto(0.0, 0.0),
                new Ponto(0.0, 3.0),
                new Ponto(4.0, 0.0)
        );
        System.out.println(t.desenhar());
        System.out.println(t.getArea());
        System.out.println(t.getPerimetro());

        Retangulo r = new Retangulo(
                new Ponto(0.0, 0.0),
                new Ponto(10., 10.)
        );
        System.out.println(r.desenhar());
        System.out.println(r.getArea());
        System.out.println(r.getPerimetro());

        Quadrado q = new Quadrado(
                new Ponto(0.0, 0.0),
                3.0
        );
        System.out.println(q.desenhar());
        System.out.println(q.getArea());
        System.out.println(q.getPerimetro());
    }
}
