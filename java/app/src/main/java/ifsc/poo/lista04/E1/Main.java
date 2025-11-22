package ifsc.poo.lista04.E1;

import ifsc.poo.lista04.E1.domain.core.Animal;
import ifsc.poo.lista04.E1.domain.impl.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Animal> animais = Set.of(
            new Morcego("Batman"),
            new Leao("Simba"),
            new Gato("Garfield"),
            new Macaco("George"),
            new Cobra("Kaa"),
            new Ornitorrinco("Perry"),
            new Avestruz("Tico"),
            new Lobo("Balto"),
            new Cachorro("Rex"),
            new Baleia("Willy"),
            new Pinguim("Pingu"),
            new Arara("Blu")
        );

        for (Animal animal : animais) {
            // Polimorfismo ao invocar habilidades()
            System.out.print(animal.habilidades());
        }
    }
}