package ifsc.poo.listaDois;

import java.util.Objects;

public class Contador {
    // Atributos
    private int count;

    // Construtor
    public Contador() {
        this.count = 0;
    }

    // Acessos
    public int getCount() {
        return this.count;
    }

    // Representação
    @Override
    public String toString() {
        return "Contador{" + "count=" + count + '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contador contador)) return false;
        return count == contador.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

    // Métodos
    public void incrementar() {
        this.count++;
    }
    public void zerar() {
        this.count = 0;
    }

    // Teste
    public static void main(String[] args) {
        // Crie um objeto contador e conte até 10;
        Contador contador = new Contador();
        for (int i = 0; i < 10; i++) {
            contador.incrementar();
        }

        // Crie um segundo objeto contador e conte até ele ter o valor do primeiro contador;
        Contador contador2 = new Contador();
        for (int i = 0; i < contador.getCount(); i++) {
            contador2.incrementar();
        }

        // Zere ambos os contadores.
        contador.zerar();
        contador2.zerar();
    }
}
