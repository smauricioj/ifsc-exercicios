package ifsc.poo.lista03.E2.domain;

public class Arqueiro extends Personagem{
    public static final int VIDA_INICIAL_PADRAO;
    public static final int ATAQUE_PADRAO;
    public static final double VELOCIDADE_PADRAO;
    public static final int FLECHAS_INICIAL_PADRAO;

    static {
        VIDA_INICIAL_PADRAO = 35;
        ATAQUE_PADRAO = 2;
        VELOCIDADE_PADRAO = 1.0;
        FLECHAS_INICIAL_PADRAO = 1;
    }

    private int flechas;

    public Arqueiro() {
        super(VIDA_INICIAL_PADRAO, ATAQUE_PADRAO, VELOCIDADE_PADRAO);
        this.flechas = FLECHAS_INICIAL_PADRAO;
    }

    @Override
    public String atacar() {
        if (this.flechas-- > 0) {
            return super.atacar();
        }
        return "O Arqueiro está sem flechas!";
    }
}
