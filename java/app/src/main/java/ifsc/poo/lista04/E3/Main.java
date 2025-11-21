package ifsc.poo.lista04.E3;

import ifsc.poo.lista04.E3.domain.api.Coletador;
import ifsc.poo.lista04.E3.domain.api.ComMontaria;
import ifsc.poo.lista04.E3.domain.api.Guerreiro;
import ifsc.poo.lista04.E3.domain.core.Personagem;
import ifsc.poo.lista04.E3.domain.impl.Aldeao;
import ifsc.poo.lista04.E3.domain.impl.Arqueiro;
import ifsc.poo.lista04.E3.domain.impl.Cavaleiro;
import ifsc.poo.lista04.E3.domain.enums.Recurso;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Personagem alvoComum = new Aldeao();
        final List<Personagem> personagens = new ArrayList<>();
        personagens.add(new Aldeao());
        personagens.add(new Arqueiro());
        personagens.add(new Cavaleiro());

        for(Personagem personagem : personagens) {
            System.out.println("-".repeat(10)+personagem+"-".repeat(10));
            // Polimorfismo no invocar de mover()
            System.out.println(personagem.mover());
            // Polimorfismo no invocar de sofrerDano()
            System.out.println(personagem.sofrerDano(1));

            if(personagem instanceof Coletador) {
                for(Recurso r : Recurso.values()) {
                    // Polimorfismo no invocar de coletar()
                    boolean coletado = ((Coletador) personagem).coletar(r);
                    System.out.printf("Tentando coletar %s: %s%n", r, coletado ? "foi coletado" : "nao coletado");
                }
            }

            if(personagem instanceof Guerreiro) {
                // Polimorfismo no invocar de atacar()
                System.out.print(((Guerreiro) personagem).atacar(alvoComum));
            }

            if(personagem instanceof ComMontaria) {
                // Polimorfismo no invocar de alternarMontado()
                ((ComMontaria) personagem).alternarMontado();
                System.out.println(personagem.mover());
            }
        }
    }
}
