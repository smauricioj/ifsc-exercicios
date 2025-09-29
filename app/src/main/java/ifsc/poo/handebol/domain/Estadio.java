package ifsc.poo.handebol.domain;

import java.util.Objects;

public class Estadio {
    // Estáticos
    public static final String NOME_PADRAO;
    public static final String ENDERECO_PADRAO;
    private static int contagem;

    static {
        NOME_PADRAO = "Estadio";
        ENDERECO_PADRAO = "Endereço";
        contagem = 0;
    }

    // Atributos
    private String nome, endereco;
    private int id;

    // Utils
    private void checkInvariantes() {
        if(nome.isEmpty()) nome = NOME_PADRAO;
        if(endereco.isEmpty()) endereco = ENDERECO_PADRAO;
    }

    // Construtor
    public Estadio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.id = ++contagem;
    }

    // Acessos
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
        checkInvariantes();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        checkInvariantes();
    }

    // Representação
    @Override
    public String toString() {
        return "Estadio{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", id=" + id +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Estadio estadio)) return false;
        return id == estadio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
