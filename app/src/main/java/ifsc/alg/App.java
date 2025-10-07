package ifsc.alg;

import ifsc.alg.listaCinco.L5E1;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) return;
        String pacote = String.valueOf(args[0]);
        byte qual = Byte.parseByte(args[1]);
        args =  Arrays.copyOfRange(args, 2, args.length);
        switch (pacote) {
            case "listaCinco" -> {
                switch (qual) {
                    case 1 -> L5E1.main(args);
                }
            }
        }
    }
}
