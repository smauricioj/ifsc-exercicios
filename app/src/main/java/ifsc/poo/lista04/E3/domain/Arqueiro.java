package ifsc.poo.lista04.E3.domain;

import ifsc.poo.lista04.E3.consts.Constantes;
import ifsc.poo.lista04.E3.enums.Recurso;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Arqueiro extends Personagem implements Coletador, Guerreiro {
    public static final Set<Recurso> COLETAVEIS;

    static {
        COLETAVEIS = Set.of(Recurso.COMIDA, Recurso.MADEIRA);
    }

    private int flechas;
    private final Map<Recurso, Integer> recursos;

    public Arqueiro() {
        super(Constantes.ARQUEIRO_VIDA_INICIAL,
              Constantes.ARQUEIRO_ATAQUE,
              Constantes.ARQUEIRO_VELOCIDADE);
        this.flechas = Constantes.ARQUEIRO_FLECHAS_INICIAL;
        this.recursos = new HashMap<>();
        for (Recurso recurso : COLETAVEIS) {
            this.recursos.put(recurso, 0);
        }
    }

    @Override
    public boolean coletar(Recurso recurso) {
        if (!COLETAVEIS.contains(recurso)) return false;
        this.recursos.put(recurso, this.recursos.get(recurso) + 1);
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

    public String recarregarFlechas(int quant) {
        if (quant <= 0) return "Não é possível recarregar flechas negativas!";
        this.flechas +=  quant;
        return String.format("Arqueiro agora com %d flechas%n", quant);
    }

    public String produzirFlechas() {
        if (this.recursos.get(Recurso.MADEIRA) == 0) return "Arqueiro sem madeira para produção!";
        this.recursos.put(Recurso.MADEIRA, this.recursos.get(Recurso.MADEIRA) - 1);
        return this.recarregarFlechas(10);
    }
}
