package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Corredor;
import ifsc.poo.lista04.E1.domain.api.Uivador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Lobo extends Animal implements Corredor, Uivador {
    public Lobo(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.correr(), this.uivar()
        );
    }

    @Override
    public String correr() {
        return "corro";
    }

    @Override
    public String uivar() {
        return "uivo";
    }
}
