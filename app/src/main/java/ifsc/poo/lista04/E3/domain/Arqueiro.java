package ifsc.poo.lista04.E3.domain;

import ifsc.poo.lista04.E3.consts.Constantes;
import ifsc.poo.lista04.E3.enums.Recurso;
import java.util.Set;

public class Arqueiro extends Personagem implements Coletador, Guerreiro {
    public static final Set<Recurso> COLETAVEIS;

    static {
        COLETAVEIS = Set.of(Recurso.COMIDA, Recurso.MADEIRA);
    }

    private int flechas;

    public Arqueiro() {
        super(Constantes.ARQUEIRO_VIDA_INICIAL,
              Constantes.ARQUEIRO_ATAQUE,
              Constantes.ARQUEIRO_VELOCIDADE);
        this.flechas = Constantes.ARQUEIRO_FLECHAS_INICIAL;
    }

    @Override
    public boolean coletar(Recurso recurso) {
        return COLETAVEIS.contains(recurso);
    }

    @Override
    public String atacar(Personagem alvo) {
        if (this.flechas-- <= 0) {
            return "O Arqueiro está sem flechas!";
        }
        return String.format(
                "O Arqueiro ataca com %d de força.%n\tResultado: %s%n",
                this.ataque,
                alvo.sofrerDano(this.ataque)
        );
    }
}
