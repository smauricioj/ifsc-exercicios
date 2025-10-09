package ifsc.poo.locadora.domain;

import java.util.Objects;

public class Plataforma {
    // Estáticos
    public static final String NOME_PADRAO;

    static {
        NOME_PADRAO = "Plataforma";
    }

    // Atributos
    private final String nome;

    // Construtor

    public Plataforma(String nome) {
        this.nome = nome;
    }

    // Acessos
    public String getNome() {
        return nome;
    }

    // Representação    @Override
    public String toString() {
        return "Plataforma{" +
                "nome='" + nome + '\'' +
                '}';
    }

    // Comparação Semântica
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Plataforma that)) return false;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
