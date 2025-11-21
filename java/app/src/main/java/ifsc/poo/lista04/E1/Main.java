package ifsc.poo.lista04.E1;

import ifsc.poo.lista04.E1.domain.Animal;
import ifsc.poo.lista04.E1.domain.Morcego;
import ifsc.poo.lista04.E1.domain.Voador;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Animal> animais = new HashSet<>();

        animais.add(new Morcego("Vlad"));
        // outros
        for(Animal animal : animais) {
            // Polimorfismo
            System.out.println(animal.habilidades());
            if (animal instanceof Voador) {
                ((Voador) animal).voar();
            }
        }
    }
}
