package ifsc.poo.lista03.E2.domain;

public class Personagem {
    // Atributos
    protected int vida, ataque;
    protected double velocidade;

    // Construtor
    /**
     * Construtor protegido, para apenas as subclasses usarem (veremos um padrão mais adequado para
     * esse comportamento com classes abstratas)
     * @param vida a vida do personagem
     * @param ataque o seu ataque
     * @param velocidade sua velocidade
     */
    protected Personagem(int vida, int ataque, double velocidade) {
        this.vida = vida;
        this.ataque = ataque;
        this.velocidade = velocidade;
    }

    public String mover() {
        return String.format("O %s se move com velocidade %.2f", this.getClass().getSimpleName(), this.velocidade);
    }

    public String atacar() {
        return String.format("O %s ataca com ataque %d", this.getClass().getSimpleName(), this.ataque);
    }

    public String sofrerDano(int dano) {
        this.vida = Math.max(this.vida - dano, 0);
        return String.format("O %s sofre %d de dano e agora tem %d de vida",
                this.getClass().getSimpleName(), dano, this.vida
        );
    }
}
