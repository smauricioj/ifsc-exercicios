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
    // São quase todos finais para deixar o objeto bem consistente após a criação
    private final String nome, cod;
    private final int pop;
    private final double dim;

    // Lembrando que objetos finais (como o arranjo) podem ter seus membros alterados!
    private final String[] vizinhos = new String[MAX_VIZINHOS];

    // Contagem de quantos vizinhos o País tem
    private int n_vizinhos;


    // Construtor
    public Pais(String nome, String cod, int pop, double dim) {
        if (cod.length() != 3) cod = COD_INVALIDO;      // Códigos sempre têm 3 letras
        if (pop < 1) pop = 1;                           // Pelo menos um morador
        if (dim < 1) dim = 1;                           // Pelo menos um km quadrado
        this.nome = nome;
        this.cod = cod;
        this.pop = pop;
        this.dim = dim;

        // Inicializa os vizinhos todos como null
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
        return Arrays.copyOf(this.vizinhos, this.n_vizinhos); // Retorna uma cópia para não quebrar o encapsulamento
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                    // Se temos o mesmo endereço de memória, somos iguais
        if (!(o instanceof Pais outro)) return false;  // Se o objeto não é um Pais, somos diferentes
        return this.cod.equals(outro.cod);             // Somos iguais se nosso código é igual
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
        this.vizinhos[this.n_vizinhos++] = vizinho.cod;  // Salva o código e incrementa o contador!
    }

    public boolean ehVizinho(Pais vizinho) {
        // Dá para fazer assim...
        // return Arrays.stream(this.vizinhos).anyMatch(v -> v.equals(vizinho.cod));
        // Mas o de baixo também funciona
        for (int i = 0; i < this.n_vizinhos; i++) {
            if (this.vizinhos[i].equals(vizinho.cod)) {
                return true;
            }
        }
        return false;
    }

    public String[] vizinhosComuns(Pais outro) {
        if (Objects.isNull(outro)) return null;

        // Podemos ter, no máximo, 15 vizinhos em comum
        String[] vizinhos_comuns = new String[MAX_VIZINHOS];
        int n_vizinhos_comuns = 0;

        // Para cada vizinho meu
        for (String cod1 : this.vizinhos) {
            // Para cada vizinho do outro Pais
            for (String cod2 : outro.vizinhos) {
                // Se os códigos são iguais
                if (cod1.equals(cod2)) {
                    // Salva o vizinho
                    vizinhos_comuns[n_vizinhos_comuns++] = cod1;
                    // E pula para o meu próximo vizinho
                    break;
                }
            }
        }

        // Retorna apenas os vizinhos encontrados!
        return Arrays.copyOf(vizinhos_comuns, n_vizinhos_comuns);
    }
}
