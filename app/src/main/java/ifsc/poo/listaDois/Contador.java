package ifsc.poo.listaDois;

import java.util.Objects;

public class Contador {
    // Atributos
    private int contagem;

    // Construtor
    public Contador() {
        // Sempre começa do 0
        this.contagem = 0;
    }

    // Acessos
    // Sem set, pois um contador deve contar de um em um!
    public int getContagem() {
        return this.contagem;
    }

    // Representação
    @Override
    public String toString() {
        return "Contador{" + "count=" + contagem + '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                        // Se eu ocupo o mesmo endereço de o, somos iguais
        if (!(o instanceof Contador outro)) return false;  // Se o não é um Contador, somos diferentes
        return this.contagem == outro.contagem;            // Somos iguais se nossa contagem é igual
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.contagem);
    }

    // Métodos
    public void incrementar() {
        this.contagem++;
    }
    public void zerar() {
        this.contagem = 0;
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
        for (int i = 0; i < contador.getContagem(); i++) {
            contador2.incrementar();
        }

        // Zere ambos os contadores.
        contador.zerar();
        contador2.zerar();
    }
}
