package ifsc.poo.lista03.E2.domain;

import ifsc.poo.lista03.E2.consts.Constantes;

public class Aldeao extends Personagem{
    public Aldeao() {
        super(Constantes.ALDEAO_VIDA_INICIAL,
              Constantes.ALDEAO_ATAQUE,
              Constantes.ALDEAO_VELOCIDADE
        );
    }

    public String colher() {
        return "O Aldeao colhe da platanção";
    }
}
