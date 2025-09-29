package ifsc.poo.handebol.domain;

import java.util.Objects;

public class Campeonato {
    // Atributos
    private final int ano;

    // Construtor
    public Campeonato(int ano) {
        this.ano = ano;
    }

    // Acessos
    public int getAno() {
        return ano;
    }

    // Representação
    @Override
    public String toString() {
        return "Campeonato{" +
                "ano=" + ano +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campeonato that)) return false;
        return ano == that.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ano);
    }
}
