package ifsc.poo.lista04.E1.domain;

public class Morcego extends Animal implements Voador, Mordedor {
    public Morcego(String nome) {
        super(nome);
    }

    @Override
    public String habilidades() {
        return String.format("Olá, meu nome é %s e eu %s e %s%n",
                this.nome, this.voar(), this.morder()
        );
    }

    @Override
    public String voar() {
        return "voo";
    }

    @Override
    public String morder() {
        return "mordo";
    }
}
