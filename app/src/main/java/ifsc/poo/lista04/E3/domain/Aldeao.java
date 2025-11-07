package ifsc.poo.lista04.E3.domain;

import ifsc.poo.lista04.E3.consts.Constantes;
import ifsc.poo.lista04.E3.enums.Recurso;

import java.util.Set;

public class Aldeao extends Personagem implements Coletador {
    public static final Set<Recurso> COLETAVEIS;

    static {
        COLETAVEIS = Set.of(Recurso.COMIDA, Recurso.OURO);
    }

    public Aldeao() {
        super(Constantes.ALDEAO_VIDA_INICIAL,
              Constantes.ALDEAO_ATAQUE,
              Constantes.ALDEAO_VELOCIDADE);
    }

    @Override
    public boolean coletar(Recurso recurso) {
        return COLETAVEIS.contains(recurso);
    }
}
