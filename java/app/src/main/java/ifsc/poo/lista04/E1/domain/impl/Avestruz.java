package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Bicador;
import ifsc.poo.lista04.E1.domain.api.Corredor;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Avestruz extends Animal implements Bicador, Corredor {
    public Avestruz(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.bicar(), this.correr()
        );
    }

    @Override
    public String bicar() {
        return "bico";
    }

    @Override
    public String correr() {
        return "corro";
    }
}
