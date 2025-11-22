package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Escalador;
import ifsc.poo.lista04.E1.domain.api.Predador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Macaco extends Animal implements Escalador, Predador {
    public Macaco(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.escalar(), this.predar()
        );
    }

    @Override
    public String escalar() {
        return "escalo";
    }

    @Override
    public String predar() {
        return "caço";
    }
}
