package ifsc.poo.locadora.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Jogo {
    // Estáticos
    public static final String NOME_PADRAO;
    private static int count;

    static {
        NOME_PADRAO = "Jogo";
        count = 0;
    }

    // Atributos
    private final int id;
    private String nome;
    private final Set<JogoPlataforma> plataformas;

    // Utils
    private void checkInvariants(){
        if (nome.isEmpty()) nome = String.format("%s{%d}", NOME_PADRAO, this.id);
    }

    // Construtor
    public Jogo(String nome) {
        this.nome = nome;
        this.id = count++;
        plataformas = new HashSet<>();
        this.checkInvariants();
    }

    // Acessos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.checkInvariants();
    }

    public Set<JogoPlataforma> getPlataformas() {
        return new HashSet<>(plataformas);
    }

    public void addPlataforma(JogoPlataforma plataforma) {
        plataformas.add(plataforma);
    }

    public void removePlataforma(JogoPlataforma plataforma) {
        plataformas.remove(plataforma);
    }

    // Representação
    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogo jogo)) return false;
        return id == jogo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
