package ifsc.poo.lista03.E2;

import ifsc.poo.lista03.E2.domain.*;

public class Main {
    public static void main(String[] args) {
        Aldeao a = new Aldeao();
        System.out.println(a.mover());
        System.out.println(a.atacar());
        System.out.println(a.sofrerDano(3));
        System.out.println(a.colher()); //Só o aldeão colhe

        Arqueiro b = new Arqueiro();
        System.out.println(b.mover());
        System.out.println(b.atacar());
        System.out.println(b.atacar()); //Falha pois não tem flechas
        System.out.println(b.sofrerDano(3));

        Cavaleiro c = new Cavaleiro();
        System.out.println(c.mover());
        System.out.println(c.atacar());
        System.out.println(c.sofrerDano(3));
        c.alternarMontado();
        System.out.println(c.mover()); //Sem estar montado, anda menos
    }
}
