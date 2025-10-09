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
    private final Set<JogoLocado> jogos;
    private final Cliente cliente;
    private LocalDate data;

    // Utils
    private void checkInvariants() {
        if (Objects.isNull(this.data)) this.data = LocalDate.now();
    }

    // Construtor
    public Locacao(Cliente cliente, LocalDate data) {
        this.id = count++;
        this.cliente = cliente;
        this.data = data;
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

    public Cliente getCliente() {
        return cliente;
    }

    // Representação
    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", cliente.login=" + cliente.getLogin() +
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
