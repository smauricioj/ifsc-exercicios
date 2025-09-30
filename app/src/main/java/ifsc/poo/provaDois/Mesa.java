package ifsc.poo.provaDois;

import java.util.Objects;

public class Mesa {
    // Constantes
    // -- esses não são obrigatórios, mas é boa prática ---------
    public static final double LARG_MIN, COMP_MIN, ALT_MIN, ALT_MAX;
    public static final double PRECO_MADEIRA, PRECO_VIDRO;
    public static final int N_PERNAS_MIN, N_PERNAS_MAX, PERNA_LARGURA, GROSSURA_TAMPO, GROSSURA_VIDRO;
    // ------------------------------------------------------

    // Estáticos
    private static int contagem;

    static {
        LARG_MIN = 80;
        COMP_MIN = 80;
        ALT_MIN = 70;
        ALT_MAX = 150;
        PRECO_MADEIRA = 0.005;
        PRECO_VIDRO = 0.01;
        N_PERNAS_MIN = 4;
        N_PERNAS_MAX = 10;
        PERNA_LARGURA = 5;
        GROSSURA_TAMPO = 3;
        GROSSURA_VIDRO = 1;
        contagem = 0;
    }

    // Atributos
    private double largura;
    private double comprimento;
    private double altura;
    private boolean vidro;
    private int nPernas;

    // Invariantes
    private void checkInvariantes() {
        if (largura < LARG_MIN) largura = LARG_MIN;
        if (comprimento < COMP_MIN) comprimento = COMP_MIN;
        if (altura < ALT_MIN) altura = ALT_MIN;
        if (altura > ALT_MAX) altura = ALT_MAX;
        if (nPernas % 2 != 0) nPernas--;
        if (nPernas < N_PERNAS_MIN) nPernas = N_PERNAS_MIN;
        if (nPernas > N_PERNAS_MAX) nPernas = N_PERNAS_MAX;
    }

    // Construtor
    public Mesa(double largura, double comprimento, double altura, boolean vidro, int nPernas) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
        this.vidro = vidro;
        this.nPernas = nPernas;
        checkInvariantes();
    }

    public static int getContagem() {
        return contagem;
    }

    public static void zeraContagem() {
        contagem = 0;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
        this.checkInvariantes();
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
        this.checkInvariantes();
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        this.checkInvariantes();
    }

    public boolean isVidro() {
        return vidro;
    }

    public void setVidro(boolean vidro) {
        this.vidro = vidro;
    }

    public int getnPernas() {
        return nPernas;
    }

    public void setnPernas(int nPernas) {
        this.nPernas = nPernas;
        this.checkInvariantes();
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "largura=" + largura +
                ", comprimento=" + comprimento +
                ", altura=" + altura +
                ", vidro=" + vidro +
                ", nPernas=" + nPernas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Mesa mesa)) return false;
        return Double.compare(largura, mesa.largura) == 0
                && Double.compare(comprimento, mesa.comprimento) == 0
                && Double.compare(altura, mesa.altura) == 0
                && vidro == mesa.vidro
                && nPernas == mesa.nPernas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(largura, comprimento, altura, vidro, nPernas);
    }

    public double getAreaTampo() {
        return this.largura*this.comprimento;
    }

    public double getVolumePerna() {
        return this.altura*PERNA_LARGURA*PERNA_LARGURA;
    }

    public double getPrecoTotal() {
        double volumeMadeira = 0;
        volumeMadeira += this.getAreaTampo()*GROSSURA_TAMPO;
        for (int i = 0; i < this.nPernas; i++) {
            volumeMadeira += this.getVolumePerna() * this.altura;
        }
        double precoTotal = volumeMadeira * PRECO_MADEIRA;
        if (this.vidro) {
            precoTotal += this.getAreaTampo() * GROSSURA_VIDRO * PRECO_VIDRO;
        }
        return precoTotal;
    }
}
