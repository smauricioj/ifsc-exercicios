package ifsc.poo.prova01;

import java.util.Scanner;

public class Criptografador {
    public static int contaEspacos = 0;
    public static int passos = 5;
    public static int tamanhoAlfabeto = 26;

    public static char cifra(char in) {
        if (in >= 'a' & in <= 'z') {
            return (char) (in + passos - (in + passos > 'z' ? tamanhoAlfabeto : 0));
        }
        if (in >= 'A' & in <= 'Z') {
            return (char) (in + passos - (in + passos > 'Z' ? tamanhoAlfabeto : 0));
        }
        if (in >= '0' && in <= '9') {
            return (char) ('0'+'9'-in);
        }
        return switch (in) {
            case '.' -> ',';
            case ',' -> '.';
            case '!' -> '?';
            case '?' -> '!';
            case '/' -> '\\';
            case ' ' -> (contaEspacos++ % 2 == 0) ? '%' : '*';
            default -> in;
        };
    }

    public static char decifra(char in) {
        if (in >= 'a' & in <= 'z') {
            return (char) (in - passos + (in - passos < 'a' ? tamanhoAlfabeto : 0));
        }
        if (in >= 'A' & in <= 'Z') {
            return (char) (in - passos + (in - passos < 'A' ? tamanhoAlfabeto : 0));
        }
        if (in >= '0' && in <= '9') {
            return (char) ('0'+'9'-in);
        }
        return switch (in) {
            case '.' -> ',';
            case ',' -> '.';
            case '!' -> '?';
            case '?' -> '!';
            case '\\' -> '/';
            case '%', '*' -> ' ';
            default -> in;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte count = 0;
        while (scanner.hasNext()) {
            if (count++ > 0) System.out.println(); // Para começar em uma nova linha, não precisa na primeira
            for (char c :  scanner.nextLine().toCharArray()) {
                System.out.print( args[0].equals("criptografa") ? cifra(c) : decifra(c) );
            }
        }
    }
}