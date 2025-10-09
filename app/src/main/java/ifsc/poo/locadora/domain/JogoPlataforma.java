package ifsc.poo.locadora.domain;

import java.util.Objects;

public class JogoPlataforma {
    // Atributos
    private double precoDiaria;
    private int estoque, disponivel;

    // Classe de associação
    private final Jogo jogo;
    private final Plataforma plataforma;

    // Utils
    private void checkInvariants(){
        if (estoque < 0) estoque = 0;
        if (disponivel < 0) disponivel = 0;
        if (disponivel > estoque) disponivel = estoque;
        if (precoDiaria < 0) precoDiaria = 0;
    }

    // Construtor
    public JogoPlataforma(Jogo jogo, Plataforma plataforma) {
        this(jogo, plataforma, 0, 0, 0);
    }

    public JogoPlataforma(Jogo jogo, Plataforma plataforma, int disponivel, int estoque, double precoDiaria) {
        // Cláusulas guardiãs
        if (Objects.isNull(jogo)) jogo = new Jogo("");
        if (Objects.isNull(plataforma)) plataforma = new Plataforma("");

        // Inicializações
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.disponivel = disponivel;
        this.estoque = estoque;
        this.precoDiaria = precoDiaria;
        this.checkInvariants();
    }

    // Acessos
    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
        this.checkInvariants();
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
        this.checkInvariants();
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
        this.checkInvariants();
    }

    public Jogo getJogo() {
        return jogo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    // Representacao
    @Override
    public String toString() {
        return "JogoPlataforma{" +
                "jogo='" + jogo.getNome() +
                "', plataforma='" + plataforma.getNome() +
                "', precoDiaria=" + precoDiaria +
                ", estoque=" + estoque +
                ", disponivel=" + disponivel +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JogoPlataforma that)) return false;
        return Objects.equals(jogo, that.jogo)
                && Objects.equals(plataforma, that.plataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jogo, plataforma);
    }
}
