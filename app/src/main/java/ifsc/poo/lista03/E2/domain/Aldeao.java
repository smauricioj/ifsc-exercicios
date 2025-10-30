package ifsc.poo.lista03.E2.domain;

public class Aldeao extends Personagem{
    public static final int VIDA_INICIAL_PADRAO;
    public static final int ATAQUE_PADRAO;
    public static final double VELOCIDADE_PADRAO;

    static {
        VIDA_INICIAL_PADRAO = 25;
        ATAQUE_PADRAO = 1;
        VELOCIDADE_PADRAO = 0.8;
    }

    public Aldeao() {
        super(VIDA_INICIAL_PADRAO, ATAQUE_PADRAO, VELOCIDADE_PADRAO);
    }

    public String colher() {
        return "O Aldeao colhe da platanção";
    }
}
