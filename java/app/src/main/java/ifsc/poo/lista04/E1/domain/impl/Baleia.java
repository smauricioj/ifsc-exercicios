package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Comunicador;
import ifsc.poo.lista04.E1.domain.api.Nadador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Baleia extends Animal implements Comunicador, Nadador {
    public Baleia(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.comunicar(), this.nadar()
        );
    }

    @Override
    public String comunicar() {
        return "me comunico (canto)";
    }

    @Override
    public String nadar() {
        return "nado";
    }
}
