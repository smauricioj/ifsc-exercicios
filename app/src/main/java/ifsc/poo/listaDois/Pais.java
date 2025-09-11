package ifsc.poo.listaDois;

import java.util.Arrays;
import java.util.Objects;

public class Pais {
    // Estáticos
    public static final int MAX_VIZINHOS;
    public static final String COD_INVALIDO;

    static {
        MAX_VIZINHOS = 15;
        COD_INVALIDO = "NNN";
    }

    // Atributos
    private final String nome, cod;
    private final int pop;
    private final double dim;
    private final String[] vizinhos = new String[MAX_VIZINHOS];
    private int n_vizinhos;

    // Construtor
    public Pais(String nome, String cod, int pop, double dim) {
        if (cod.length() != 3) cod = COD_INVALIDO;
        if (pop < 1) pop = 1;
        if (dim < 1) dim = 1;
        this.nome = nome;
        this.cod = cod;
        this.pop = pop;
        this.dim = dim;
        for (int i = 0; i < MAX_VIZINHOS; i++) this.vizinhos[i] = null;
        this.n_vizinhos = 0;
    }

    // Representação
    @Override
    public String toString() {
        return String.format("%s: %s", this.cod, this.nome);
    }

    // Acesso
    public String getNome() {
        return this.nome;
    }
    public String getCod() {
        return this.cod;
    }
    public int getPop() {
        return this.pop;
    }
    public double getDim() {
        return this.dim;
    }
    public int getN_vizinhos() {
        return this.n_vizinhos;
    }
    public String[] getVizinhos() {
        return Arrays.copyOf(this.vizinhos, this.n_vizinhos);
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais outro)) return false;
        return this.cod.equals(outro.cod);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    // Métodos
    public double densidade() {
        return this.pop/this.dim;
    }

    public void adiciona(Pais vizinho) {
        this.vizinhos[this.n_vizinhos++] = vizinho.cod;
    }

    public boolean ehVizinho(Pais vizinho) {
//        return Arrays.stream(this.vizinhos).anyMatch(v -> v.equals(vizinho.cod));
        for (int i = 0; i < this.n_vizinhos; i++) {
            if (this.vizinhos[i].equals(vizinho.cod)) {
                return true;
            }
        }
        return false;
    }

    public String[] vizinhosComuns(Pais outro) {
        String[] vizinhos_comuns = new String[MAX_VIZINHOS];
        int n_vizinhos_comuns = 0;
        for (String cod1 : this.vizinhos) {
            for (String cod2 : outro.vizinhos) {
                if (cod1.equals(cod2)) {
                    vizinhos_comuns[n_vizinhos_comuns++] = cod1;
                    break;
                }
            }
        }
        return Arrays.copyOf(vizinhos_comuns, n_vizinhos_comuns);
    }
}
