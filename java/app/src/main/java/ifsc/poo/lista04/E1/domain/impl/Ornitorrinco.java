package ifsc.poo.lista04.E1.domain.impl;

import ifsc.poo.lista04.E1.domain.api.Bicador;
import ifsc.poo.lista04.E1.domain.api.Envenenador;
import ifsc.poo.lista04.E1.domain.core.Animal;

public class Ornitorrinco extends Animal implements Envenenador, Bicador {
    public Ornitorrinco(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.envenenar(), this.bicar()
        );
    }

    @Override
    public String envenenar() {
        return "enveneno";
    }

    @Override
    public String bicar() {
        return "bico";
    }
}
