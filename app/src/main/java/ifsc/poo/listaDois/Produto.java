package ifsc.poo.listaDois;

import java.util.Arrays;
import java.util.Objects;

public class Produto {
    // Constantes
    public static final char DELIMITADOR = ';';
    public static final byte MAX_REGISTRO = 50;

    // Estáticos
    private static int count;
    private static final Produto[] registro;
    private static byte n_registros;

    static {
        count = 0;
        registro = new Produto[MAX_REGISTRO];
        for (int i = 0; i < MAX_REGISTRO; i++) {
            registro[i] = null;
        }
    }

    // Atributos
    private final String codigo;
    private String nome;
    private int preco;
    private float desconto;

    // Construtor
    public Produto(String nome, double preco) {
        this.setNome(nome);
        this.setPreco(preco);
        this.desconto = 0.0f;
        this.codigo = String.format("COD-%03d-%03d", count++/1000, count%1000);
        atualizaRegistro(this);
    }

    // Acessos
    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public float getDesconto() {
        return desconto;
    }
    public double getPrecoReal() {
        return this.preco/100.0;
    }
    public double getPrecoAplicado() {
        return this.desconto*preco/100.0;
    }
    public void setNome(String nome) {
        if (Objects.isNull(nome) || nome.isEmpty()) nome = "Produto";
        this.nome = nome;
    }
    public void setDesconto(float desconto) {
        this.desconto = Math.max(0, Math.min(100, desconto));
    }
    public void setPreco(double preco) {
        if (preco < 0) preco = 0;
        this.preco = (int) (Math.floor(100*preco));
    }

    // Representação
    @Override
    public String toString() {
        return String.format("%s%c%s%c%.2f%c%.2f",
                this.codigo,DELIMITADOR,this.nome,DELIMITADOR,this.getPrecoAplicado(),DELIMITADOR,this.desconto
            );
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto outro)) return false;
        return this.preco == outro.preco
            && Objects.equals(this.nome, outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.preco);
    }

    // Métodos
    private static void atualizaRegistro(Produto produto) {
        if (++n_registros == MAX_REGISTRO) {
            n_registros--;
            for (int i = 1; i < MAX_REGISTRO; i++) {
                registro[i - 1] = registro[i];
            }
        }
        registro[n_registros] = produto;
    }

    public static Produto[] totalCriados() {
        return Arrays.copyOf(registro, n_registros);
    }

    public static String[] exportarCSV() {
        String[] csv = new String[n_registros+1];
        csv[0] = "Código;Nome;Preço;Desconto";
        for (int i = 1; i <= n_registros; i++) {
            csv[i] = registro[i-1].toString();
        }
        return csv;
    }
}
