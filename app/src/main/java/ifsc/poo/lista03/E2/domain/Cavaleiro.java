package ifsc.poo.lista03.E2.domain;

public class Cavaleiro extends Personagem{
    public static final int VIDA_INICIAL_PADRAO;
    public static final int ATAQUE_PADRAO;
    public static final double VELOCIDADE_PADRAO;

    static {
        VIDA_INICIAL_PADRAO = 50;
        ATAQUE_PADRAO = 3;
        VELOCIDADE_PADRAO = 2.0;
    }

    private boolean montado;

    public Cavaleiro() {
        super(VIDA_INICIAL_PADRAO, ATAQUE_PADRAO, VELOCIDADE_PADRAO);
        montado = true;
    }

    public void alternarMontado() {
        this.velocidade /= montado ? 2.0 : (1/2.0);
        this.montado = !this.montado;
    }

    public boolean estaMontado() {
        return montado;
    }
}
