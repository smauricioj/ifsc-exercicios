package ifsc.poo.lista03.E2.domain;

import ifsc.poo.lista03.E2.domain.consts.Constantes;

public class Cavaleiro extends Personagem{
    private boolean montado;

    public Cavaleiro() {
        super(Constantes.CAVALEIRO_VIDA_INICIAL,
              Constantes.CAVALEIRO_ATAQUE,
              Constantes.CAVALEIRO_VELOCIDADE
        );
        this.montado = true;
    }

    public void alternarMontado() {
        this.montado = !this.montado;
        this.velocidade = this.montado
                ? Constantes.CAVALEIRO_VELOCIDADE
                : Constantes.CAVALEIRO_VELOCIDADE / 2.0;
    }
}
