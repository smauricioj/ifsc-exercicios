package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Miador;
import ifsc.poo.lista04.E1.domain.api.Mordedor;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Leao extends Animal implements Mordedor, Miador {
    public Leao(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.morder(), this.miar()
        );
    }

    @Override
    public String morder() {
        return "mordo";
    }

    @Override
    public String miar() {
        return "mio (rujo)";
    }
}
