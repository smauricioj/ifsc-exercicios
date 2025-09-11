package ifsc.poo.provaDois;
import java.util.Objects;

public class Hitbox {
    // Estáticos
    public static int contagem;
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
        contagem = 0;
    }

    // Atributos
    private double x;
    private double y;
    private final double largura;
    private final double altura;

    // Construtor
    public Hitbox(double x, double y, double largura, double altura) {
        if (largura <= 0) largura = LARGURA_PADRAO;
        if (altura <= 0) altura = ALTURA_PADRAO;
        if (x < X_MIN) x = X_MIN;
        if (y < Y_MIN) y = Y_MIN;

        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        contagem++;
    }

    // Acessos
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getLargura() {
        return largura;
    }
    public double getAltura() {
        return altura;
    }
    public void setX(double x) {
        this.x = Math.max(x, X_MIN);
    }
    public void setY(double y) {
        this.y = Math.max(y, Y_MIN);
    }

    // Representação
    @Override
    public String toString() {
        return "Hitbox[x=" + x + ", y=" + y +
                ", largura=" + largura + ", altura=" + altura + "]";
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hitbox outra)) return false;
        return x == outra.x &&
               y == outra.y &&
               largura == outra.largura &&
               altura == outra.altura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, largura, altura);
    }

    // Métodos
    public static int getContagem() {
        return contagem;
    }

    public static void zeraContagem() {
        contagem = 0;
    }

    public static boolean intersecta(Hitbox a, Hitbox b) {
        if (Objects.isNull(a) || Objects.isNull(b)) return false;
        return Math.max(a.x, b.x) < Math.min(a.x + a.largura, b.x + b.largura)
                && Math.max(a.y, b.y) < Math.min(a.y+a.altura, b.y+b.altura);
        // Também é possível:
        // return a.x < b.x + b.largura &&
        //       a.x + a.largura > b.x &&
        //       a.y < b.y + b.altura &&
        //       a.y + a.altura > b.y;
    }

    public double area() {
        return this.altura * this.altura;
    }

    public double perimetro() {
        return 2 * (this.altura + this.largura);
    }

    public void mover(double dx, double dy){
        this.setX(this.x + dx);
        this.setY(this.y + dy);
    }

    public static void main(String[] args) {

    }
}

