package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Cantador;
import ifsc.poo.lista04.E1.domain.api.Voador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Arara extends Animal implements Cantador, Voador {
    public Arara(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Oi, eu sou a %s e eu %s e %s%n",
                this.nome, this.voar(), this.cantar()
        );
    }

    @Override
    public String voar() {
        return "voo";
    }

    @Override
    public String cantar() {
        return "canto";
    }
}
