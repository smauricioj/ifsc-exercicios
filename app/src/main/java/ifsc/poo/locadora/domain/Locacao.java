package ifsc.poo.locadora.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Locacao {
    // Estáticos
    private static int count;

    static {
        count = 0;
    }

    // Atributos
    private final int id;
    private LocalDate data;
    private final Set<JogoLocado> jogos;

    // Utils
    private void checkInvariants() {
        if (Objects.isNull(this.data)) this.data = LocalDate.now();
    }

    // Construtor
    public Locacao(LocalDate data) {
        this.data = data;
        this.id = count++;
        this.jogos = new HashSet<>();
        this.checkInvariants();
    }

    // Acessos
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
        this.checkInvariants();
    }

    public Set<JogoLocado> getJogos() {
        return jogos;
    }

    public int getId() {
        return id;
    }

    public void addJogoLocado(JogoLocado jogoLocado) {
        this.jogos.add(jogoLocado);
    }

    public void removeJogoLocado(JogoLocado jogoLocado) {
        this.jogos.remove(jogoLocado);
    }

    // Representação
    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Locacao locacao)) return false;
        return id == locacao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
