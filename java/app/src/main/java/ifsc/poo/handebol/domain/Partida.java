package ifsc.poo.handebol.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Partida {
    // Estáticos
    public static final LocalDate DATA_PADRAO;
    private static int contagem;

    static {
        DATA_PADRAO = LocalDate.now();
        contagem = 0;
    }

    // Atributos
    private LocalDate data;
    private int id;

    // Utils
    private void checkInvariantes() {
        if (data.isBefore(LocalDate.now())) data = DATA_PADRAO;
    }

    // Construtor
    public Partida(LocalDate data) {
        this.data = data;
        this.id = ++contagem;
        this.checkInvariantes();
    }

    // Acessos
    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
        this.checkInvariantes();
    }

    // Representação
    @Override
    public String toString() {
        return "Partida{" +
                "data=" + data +
                ", id=" + id +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partida partida)) return false;
        return id == partida.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
