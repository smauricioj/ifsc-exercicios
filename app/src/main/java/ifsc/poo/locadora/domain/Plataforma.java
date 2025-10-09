package ifsc.poo.locadora.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plataforma {
    // Estáticos
    public static final String NOME_PADRAO;

    static {
        NOME_PADRAO = "Plataforma";
    }

    // Atributos
    private final String nome;
    private final Set<JogoPlataforma> jogos;

    // Construtor
    public Plataforma(String nome) {
        this.nome = nome;
        this.jogos = new HashSet<>();
    }

    // Acessos
    public String getNome() {
        return nome;
    }

    public Set<JogoPlataforma> getJogos() {
        return new HashSet<>(jogos);
    }

    public void addJogo(JogoPlataforma plataforma) {
        jogos.add(plataforma);
    }

    public void removeJogo(JogoPlataforma plataforma) {
        jogos.remove(plataforma);
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
