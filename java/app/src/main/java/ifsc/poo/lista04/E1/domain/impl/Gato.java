package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Escalador;
import ifsc.poo.lista04.E1.domain.api.Miador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Gato extends Animal implements Miador, Escalador {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.miar(), this.escalar()
        );
    }

    @Override
    public String miar() {
        return "mio";
    }

    @Override
    public String escalar() {
        return "escalo";
    }
}
