package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Chocador;
import ifsc.poo.lista04.E1.domain.api.Nadador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Pinguim extends Animal implements Nadador, Chocador {
    public Pinguim(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.nadar(), this.chocar()
        );
    }

    @Override
    public String nadar() {
        return "nado";
    }

    @Override
    public String chocar() {
        return "choco ovos";
    }
}
