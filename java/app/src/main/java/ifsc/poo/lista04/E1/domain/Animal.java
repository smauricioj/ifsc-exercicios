package ifsc.poo.lista04.E1.domain;

public abstract class Animal {
    protected String nome;

    protected Animal(String nome) {
        this.nome = nome;
    }

    public abstract String habilidades();
}