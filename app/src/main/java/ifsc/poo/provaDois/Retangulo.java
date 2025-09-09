package ifsc.poo.provaDois;

import java.util.Objects;

public class Retangulo {
    // Estáticos
    public static final byte LARGURA_PADRAO, ALTURA_PADRAO;
    public static final byte ORIGEM_X_PADRAO, ORIGEM_Y_PADRAO;
    public static final byte X_MIN, Y_MIN;
    public static final byte REPR_LADO_MIN, REPR_LADO_MAX;

    static {
        LARGURA_PADRAO = 1;
        ALTURA_PADRAO = 1;
        ORIGEM_X_PADRAO = 0;
        ORIGEM_Y_PADRAO = 0;
        X_MIN = 0;
        Y_MIN = 0;
        REPR_LADO_MAX = 20;
        REPR_LADO_MIN = 3;
    }

    // Atributos
    private final double largura, altura;
    private double x, y;

    // Construtores
    public Retangulo(){
        this(LARGURA_PADRAO, ALTURA_PADRAO, ORIGEM_X_PADRAO, ORIGEM_Y_PADRAO);
    }
    public Retangulo(double lado){
        this(lado, lado, ORIGEM_X_PADRAO, ORIGEM_Y_PADRAO);
    }
    public Retangulo(double largura, double altura){
        this(largura, altura, ORIGEM_X_PADRAO, ORIGEM_Y_PADRAO);
    }
    public Retangulo(double largura, double altura, double x, double y) {
        if (largura <= 0) largura = LARGURA_PADRAO;
        if (altura <= 0) altura = ALTURA_PADRAO;
        if (x < X_MIN) x = X_MIN;
        if (y < Y_MIN) y = Y_MIN;

        this.largura = largura;
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    // Acessos
    public double getLargura() {
        return largura;
    }
    public double getAltura() {
        return altura;
    }
    public double getEsquerda() {
        return this.x;
    }
    public double getBase() {
        return this.y;
    }
    public double getDireita() {
        return this.x + this.largura;
    }
    public double getTopo() {
        return this.y + this.altura;
    }

    // Representação
    private String desenhoASCII() {
        if(this.largura > REPR_LADO_MAX && this.largura < REPR_LADO_MIN
                && this.altura > REPR_LADO_MAX && this.altura < REPR_LADO_MIN) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat((int)this.largura)).append('\n');
        for (int i = 1; i < this.altura - 1; i++) {
            sb.append("*").append(" ".repeat((int) this.largura - 2)).append("*").append('\n');
        }
        sb.append("*".repeat((int)this.largura)).append('\n');
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Retangulo=(largura:%.4f; altura:%.4f; x:%.4f; y:%.4f",
                this.largura, this.altura, this.x, this.y
        );
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Retangulo retangulo)) return false;
        return (Double.compare(this.largura, retangulo.largura) == 0
               && Double.compare(this.altura, retangulo.altura) == 0
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(largura, altura);
    }

    // Métodos
    public void mover(double dx, double dy) {
        this.x = Math.max(this.x + dx, 0);
        this.y = Math.max(this.y + dy, 0);
    }

    public double area() {
        return this.altura*this.largura;
    }

    public double perimetro() {
        return 2*(this.altura+this.largura);
    }

    public Retangulo intersecao(Retangulo outro) {
        if (Objects.isNull(outro)) return null;
        double i_esquerda = Math.max(this.getEsquerda(), outro.getEsquerda());
        double i_base     = Math.max(this.getBase(),     outro.getBase());
        double i_direita  = Math.min(this.getDireita(),  outro.getDireita());
        double i_topo     = Math.min(this.getTopo(),     outro.getTopo());
        if (i_esquerda >= i_direita || i_base >= i_topo) return null;
        return new Retangulo(i_direita - i_esquerda, i_topo - i_base, i_esquerda, i_base);
    }

    public static void main(String[] args) {
        Retangulo ret1 = new Retangulo(5);
        Retangulo ret2 = new Retangulo(1, 1, 2, 2);
        System.out.println(ret1);
        System.out.println(ret1.intersecao(ret2));
    }
}
