package ifsc.poo.lista04.E3.domain.impl;

import ifsc.poo.lista04.E3.domain.consts.Constantes;
import ifsc.poo.lista04.E3.domain.api.Coletador;
import ifsc.poo.lista04.E3.domain.api.ComMontaria;
import ifsc.poo.lista04.E3.domain.core.Personagem;
import ifsc.poo.lista04.E3.domain.enums.Recurso;

import java.util.Set;

public class Aldeao extends Personagem implements Coletador, ComMontaria {
    public static final Set<Recurso> COLETAVEIS;

    static {
        COLETAVEIS = Set.of(Recurso.COMIDA, Recurso.OURO);
    }

    private boolean montado;

    public Aldeao() {
        super(Constantes.ALDEAO_VIDA_INICIAL,
              Constantes.ALDEAO_ATAQUE,
              Constantes.ALDEAO_VELOCIDADE);
    }

    @Override
    public boolean coletar(Recurso recurso) {
        return COLETAVEIS.contains(recurso);
    }

    @Override
    public void alternarMontado() {
        this.montado = !this.montado;
        this.velocidade = this.montado
                ? Constantes.ALDEAO_VELOCIDADE
                : Constantes.ALDEAO_VELOCIDADE / 2.0;

    }
}
