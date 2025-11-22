package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Envenenador;
import ifsc.poo.lista04.E1.domain.api.Predador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Cobra extends Animal implements Predador, Envenenador {
    public Cobra(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.predar(), this.envenenar()
        );
    }

    @Override
    public String predar() {
        return "caço";
    }

    @Override
    public String envenenar() {
        return "enveneno";
    }
}
