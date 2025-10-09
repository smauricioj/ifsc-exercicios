package ifsc.poo.locadora.domain;

import java.util.Objects;

public class Acessorio {
    // Estáticos
    public static final String NOME_PADRAO;
    private static int count;

    static {
        NOME_PADRAO = "Acessorio";
        count = 0;
    }

    // Atributos
    private int id;
    private String nome;
    private double preco;

    // Utils
    private void checkInvariants(){
        if (nome.isEmpty()) nome = NOME_PADRAO;
    }

    // Construtor
    public Acessorio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.checkInvariants();
        count++;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        this.checkInvariants();
    }

    // Representação
    @Override
    public String toString() {
        return "Acessorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acessorio acessorio)) return false;
        return id == acessorio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
