package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Comunicador;
import ifsc.poo.lista04.E1.domain.api.Uivador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Cachorro extends Animal implements Uivador, Comunicador {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.uivar(), this.comunicar()
        );
    }

    @Override
    public String uivar() {
        return "uivo (lato)";
    }

    @Override
    public String comunicar() {
        return "me comunico";
    }
}
