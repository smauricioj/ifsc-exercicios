package ifsc.poo.locadora.domain;

import java.time.LocalDate;
import java.util.Objects;

public class JogoLocado {
    // Estáticos

    // Atributos
    private int dias;

    // Classe de associação
    private final JogoPlataforma jogo;
    private final Locacao locacao;

    // Utils
    private void chechInvariants(){
        if (dias < 1) dias = 1;
    }

    // Construtor
    public JogoLocado(JogoPlataforma jogo, Locacao locacao, int dias) {
        // Inicializações
        this.jogo = jogo;
        this.locacao = locacao;
        this.dias = dias;
        this.chechInvariants();
    }

    // Acessos
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
        this.chechInvariants();
    }

    public JogoPlataforma getJogo() {
        return jogo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    // Representação
    @Override
    public String toString() {
        return "JogoLocado{" +
                "dias=" + dias +
                ", jogo=" + jogo.getJogo().getId() +
                ", locacao=" + locacao.getId() +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof JogoLocado that)) return false;
        return Objects.equals(jogo, that.jogo)
                && Objects.equals(locacao, that.locacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jogo, locacao);
    }
}
