package ifsc.poo.handebol.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Time {
    // Atributos
    private final String nome;
    private Jogador capitao;
    private final Set<Jogador> jogadores;

    // Construtor
    public Time(String nome) {
        this.nome = nome;
        this.capitao = null;
        this.jogadores = new LinkedHashSet<>();
    }

    // Acessos
    public String getNome() {
        return nome;
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void addCapitao(Jogador capitao) {
        if (!this.jogadores.contains(capitao)) return;
        this.capitao = capitao;
    }

    public void removeCapitao(Jogador capitao) {
        this.capitao = null;
    }

    public Jogador[] getJogadores() {
        return jogadores.toArray(new Jogador[0]);
    }

    public void addJogador(Jogador jogador) {
        if (Objects.isNull(jogador)) return;
        this.jogadores.add(jogador);
    }

    public void removeJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }

    // Representação
    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time)) return false;
        return Objects.equals(nome, time.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
