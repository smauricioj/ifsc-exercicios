package ifsc.poo.lista04.E1;

import ifsc.poo.lista04.E1.domain.core.Animal;
import ifsc.poo.lista04.E1.domain.impl.Arara;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Testando zoológico de poo
        Set<Animal> animais = new HashSet<>();
        animais.add(new Arara("Iago"));
        // mais

        for (Animal a : animais) {
            System.out.println(a.habilidades());
        }
    }
}
