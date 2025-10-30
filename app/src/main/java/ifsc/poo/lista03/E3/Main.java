package ifsc.poo.lista03.E3;

import ifsc.poo.lista03.E3.domain.Linha;
import ifsc.poo.lista03.E3.domain.Ponto;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Linha l = new Linha(
                new Ponto(0.0, 0.0),
                new Ponto(0.0, -2.0)
        );
        System.out.println(l.desenhar());
        System.out.println(l.tamanho());
    }
}
