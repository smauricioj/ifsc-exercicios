package ifsc.poo.lista03.E2.domain;

import ifsc.poo.lista03.E2.consts.Constantes;

public class Arqueiro extends Personagem{
    private int flechas;

    public Arqueiro() {
        super(Constantes.ARQUEIRO_VIDA_INICIAL,
              Constantes.ARQUEIRO_ATAQUE,
              Constantes.ARQUEIRO_VELOCIDADE
        );
        this.flechas = Constantes.ARQUEIRO_FLECHAS_INICIAL;
    }

    @Override
    public String atacar() {
        if (this.flechas-- > 0) {
            return super.atacar();
        }
        return "O Arqueiro está sem flechas!";
    }
}
