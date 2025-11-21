package ifsc.poo.lista04.E3.domain.impl;

import ifsc.poo.lista04.E3.domain.consts.Constantes;
import ifsc.poo.lista04.E3.domain.api.Coletador;
import ifsc.poo.lista04.E3.domain.api.Guerreiro;
import ifsc.poo.lista04.E3.domain.core.Personagem;
import ifsc.poo.lista04.E3.domain.enums.Recurso;

import java.util.Set;

public class Arqueiro extends Personagem implements Coletador, Guerreiro {
    public static final Set<Recurso> COLETAVEIS;

    static {
        COLETAVEIS = Set.of(Recurso.COMIDA, Recurso.MADEIRA);
    }

    private int flechas;
    private int madeiraColetada;

    public Arqueiro() {
        super(Constantes.ARQUEIRO_VIDA_INICIAL,
              Constantes.ARQUEIRO_ATAQUE,
              Constantes.ARQUEIRO_VELOCIDADE);
        this.flechas = Constantes.ARQUEIRO_FLECHAS_INICIAL;
        this.madeiraColetada = 0;
    }

    @Override
    public boolean coletar(Recurso recurso) {
        if (!COLETAVEIS.contains(recurso)) return false;
        if (recurso == Recurso.MADEIRA) this.madeiraColetada++;
        return true;
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

    public String produzirFlechas() {
        if (this.madeiraColetada == 0) return "Arqueiro sem madeira para produção!";
        this.madeiraColetada--;
        return this.recarregarFlechas(Constantes.ARQUEIRO_FLECHAS_PRODUCAO);
    }

    public String recarregarFlechas(int quant) {
        if (quant <= 0) return "Não é possível recarregar flechas negativas!";
        this.flechas +=  quant;
        return String.format("Arqueiro agora com %d flechas%n", quant);
    }
}
