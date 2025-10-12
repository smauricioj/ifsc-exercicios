package ifsc.poo.lista02;

import java.util.Objects;

public class Circulo {
    // Estáticos
    private static int count;
    public static final double RAIO_PADRAO;

    static {
        count = 0;         // Contagem de quantos círculos foram criados
        RAIO_PADRAO = 1;   // Usado quando um objeto é criado com raio inválido
    }

    public static int totalCriados() {
        return count;
    }

    // Atributos
    Ponto2D centro;
    double raio;

    // Contrutores
    public Circulo() {
        this(new Ponto2D(), 1);
    }
    public Circulo(double raio) {
        this(new Ponto2D(), raio);
    }
    public Circulo(Ponto2D centro) {
        this(centro, 1);
    }
    public Circulo(Ponto2D centro, double raio) {
        if (Objects.isNull(centro)) centro = new Ponto2D();          // Centro não pode ser nulo
        if (raio < 0 || !Double.isFinite(raio)) raio = RAIO_PADRAO;  // Raio deve ser não negativo e finito
        this.centro = centro;
        this.raio = raio;
        count++;                                                     // Incrementa a contagem na construção
    }

    // Acessos
    public double getRaio() {
        return this.raio;
    }
    public Ponto2D getCentro() {
        return new Ponto2D(this.centro);
    }  // Retorna um novo ponto para manter encapsulamento

    // Representação
    @Override
    public String toString() {
        return "Circulo{" +
                "centro=" + this.centro +
                ", raio=" + this.raio +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                          // Se estamos no mesmo endereço de memória, somos iguais
        if (!(o instanceof Circulo outro)) return false;     // Se o objeto não é um Circulo, somos diferentes
        return Double.compare(this.raio, outro.raio) == 0    // Somos iguais se nosso raio é igual...
            && Objects.equals(this.centro, outro.centro);    // ... e nosso centro também
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.centro, this.raio);
    }

    // Métodos
    public double area() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * this.raio;
    }

    public void inflar() {
        this.inflar(1);
    }

    public void inflar(double aumento) {
        // Só infla se o aumento é finito
        if (Double.isFinite(aumento)) this.raio += aumento;
    }

    public void desinflar() {
        this.desinflar(1);
    }

    public void desinflar(double reducao) {
        // Só desinfla se a redução é finita e o resultado mantém o raio não negativo
        if (Double.isFinite(reducao)) this.raio = Math.max(this.raio - reducao, 0);
    }

    public void mover() {
        this.mover(0, 0);
    }

    public void mover(double dx, double dy) {
        // Os setters de Ponto2D cuidam dos casos onde o argumento não é finito
        this.centro.setX(this.centro.getX() + dx);
        this.centro.setY(this.centro.getY() + dy);
    }

    public void mover(Ponto2D ponto) {
        if (Objects.isNull(ponto)) return;
        this.centro.setX(ponto.getX());
        this.centro.setY(ponto.getY());
    }

    public boolean contem(Ponto2D ponto) {
        // O ponto está dentro do circulo se a distância entre o ponto e o centro é menor que o raio
        if (Objects.isNull(ponto)) return false;
        return Double.compare(this.raio, this.centro.distancia(ponto)) >= 0;
    }

    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo(new Ponto2D(1, 1), 1);
        Ponto2D p1 = new Ponto2D(0.5, 0.5);
        Ponto2D p2 = new Ponto2D(2, -2);
        if (c1.contem(p1) && c2.contem(p1)) System.out.println("p1 está dentro de c1 e c2");
        System.out.printf("Foram criados %d objetos Circulo\n", Circulo.totalCriados());
        c2.mover(p2);
        c2.inflar(5);
        if (c2.contem(p1)) System.out.println("p1 ainda está dentro de c2!");
    }
}
