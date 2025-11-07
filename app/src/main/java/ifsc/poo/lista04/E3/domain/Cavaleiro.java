package ifsc.poo.lista04.E3.domain;

import ifsc.poo.lista03.E2.consts.Constantes;

public class Cavaleiro extends Personagem implements Guerreiro, ComMontaria {
    private boolean montado;

    public Cavaleiro() {
        super(Constantes.CAVALEIRO_VIDA_INICIAL,
              Constantes.CAVALEIRO_ATAQUE,
              Constantes.CAVALEIRO_VELOCIDADE
        );
        this.montado = true;
    }

    @Override
    public void alternarMontado() {
        this.montado = !this.montado;
        this.velocidade = this.montado
                ? Constantes.CAVALEIRO_VELOCIDADE
                : Constantes.CAVALEIRO_VELOCIDADE / 2.0;
    }

    @Override
    public String atacar(Personagem alvo) {
        return String.format(
                "O Cavaleiro ataca com %d de força.%n\tResultado: %s%n",
                this.ataque,
                alvo.sofrerDano(this.ataque)
        );
    }
}
