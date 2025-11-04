package ifsc.alg.projeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
