package ifsc.poo.provaDois;
import java.util.Objects;
import java.util.Random;

public class Hitbox {
    // Estáticos
    public static int contagem;
    public static final byte LARGURA_PADRAO, ALTURA_PADRAO;
    public static final byte X_MIN, Y_MIN;

    static {
        LARGURA_PADRAO = 1;
        ALTURA_PADRAO = 1;
        X_MIN = 0;
        Y_MIN = 0;
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

        this.setX(x);
        this.setY(y);
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
        if (!Double.isFinite(x)) return;
        this.x = Math.max(x, X_MIN);
    }
    public void setY(double y) {
        if (!Double.isFinite(y)) return;
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
        //        a.x + a.largura > b.x &&
        //        a.y < b.y + b.altura &&
        //        a.y + a.altura > b.y;
        // Se a hitbox está implementada com atributos x e y dos cantos opostos, a solução seria
        // return a.getX1() < b.getX2() &&
        //        a.getX2() > b.getX1() &&
        //        a.getY1() < b.getY2() &&
        //        a.getY2() > b.getY1();
    }

    public double area() {
        return this.altura * this.altura;
    }

    public double perimetro() {
        return 2 * (this.altura + this.largura);
    }

    public void mover(double dx, double dy){
        if (!Double.isFinite(dx) || !Double.isFinite(dy)) return;
        this.setX(this.x + dx);
        this.setY(this.y + dy);
        // Também é possível:
        // this.setX(dx);
        // this.setY(dy);
        // Mas eu pensei primeiro em translado (mover de forma relativa) e não transposição (mover de forma absoluta)
    }

    public static void main(String[] args) {

    }
}
