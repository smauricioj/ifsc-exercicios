package ifsc.poo.listaUm;

public class Exercicio3 {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Erro: não possui 5 argumentos.");
            return;
        }
        byte valor = 0;
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals("1") && !args[i].equals("0")) {
                System.out.printf("Erro: argumento '%s' nao é binário.\n", args[i]);
                return;
            }
            if (args[i].equals("1")) valor += (byte) Math.pow(2, 4-i);
        }
        System.out.printf("Valor: %d\n", valor);
    }
}
