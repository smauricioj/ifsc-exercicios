package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Chocador;
import ifsc.poo.lista04.E1.domain.api.Voador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Arara extends Animal implements Chocador, Voador {
    public Arara(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.chocar(), this.voar()
        );
    }


    @Override
    public String chocar() {
        return "choco ovos";
    }

    @Override
    public String voar() {
        return "voo alto";
    }
}
