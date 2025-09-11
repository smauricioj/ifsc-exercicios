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
        //        a.x + a.largura > b.x &&
        //        a.y < b.y + b.altura &&
        //        a.y + a.altura > b.y;
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
        Random r = new Random();
        final int LARGURA_TELA = 50;
        final int ALTURA_TELA = 30;
        final int N_HITBOXES = 20;
        Hitbox[] hitboxes = new Hitbox[N_HITBOXES];
        for (int i = 0; i < N_HITBOXES; i++) {
            double x = r.nextDouble(LARGURA_TELA);
            double y = r.nextDouble(ALTURA_TELA);
            double largura = r.nextDouble(LARGURA_TELA - x);
            double altura = r.nextDouble(ALTURA_TELA - y);
            hitboxes[i] = new Hitbox(x, y, largura, altura);
        }
        int contagem = 0;
        for (int i = 0; i < N_HITBOXES; i++) {
            for (int j = i+1; j < N_HITBOXES; j++) {
                if (Hitbox.intersecta(hitboxes[i], hitboxes[j])) {
                    contagem++;
                }
            }
        }
        System.out.println("Numero de pares que estão sobrepostos: "+contagem);
    }
}