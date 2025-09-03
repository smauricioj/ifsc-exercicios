package ifsc.poo.provaUm;

public class CalculadoraResistencia {
    // CONSTANTES ---------------------------------------------------------
    // Valor usado para indicar que o argumento informado está errado
    static byte VALUE_ERROR = -10;

    // Métodos ------------------------------------------------------------
    static byte getDigito(String cor){
        return switch (cor) {
            case "preto"      -> 0;
            case "marrom"     -> 1;
            case "vermelho"   -> 2;
            case "laranja"    -> 3;
            case "amarelo"    -> 4;
            case "verde"      -> 5;
            case "azul"       -> 6;
            case "violeta"    -> 7;
            case "cinza"      -> 8;
            case "branco"     -> 9;
            default -> VALUE_ERROR;
        };
    }

    static byte getLogMultiplicador(String cor){
        return switch (cor) {
            case "prata"     -> -2;
            case "ouro"      -> -1;
            case "preto"      -> 0;
            case "marrom"     -> 1;
            case "vermelho"   -> 2;
            case "laranja"    -> 3;
            case "amarelo"    -> 4;
            case "verde"      -> 5;
            case "azul"       -> 6;
            case "violeta"    -> 7;
            default -> VALUE_ERROR;
        };
    }

    static float getTolerancia(String cor){
        return switch (cor) {
            case "preto"    ->  0.0f;
            case "marrom"   ->  1.0f;
            case "vermelho" ->  2.0f;
            case "verde"    ->  0.5f;
            case "azul"     ->  0.25f;
            case "violeta"  ->  0.1f;
            case "cinza"    ->  0.05f;
            case "ouro"     ->  5.0f;
            case "prata"    -> 10.0f;
            default  ->  VALUE_ERROR;
        };
    }

    static byte getCoeficiente(String cor){
        return switch (cor) {
            case "marrom"   -> 100;
            case "vermelho" -> 50;
            case "laranja"  -> 15;
            case "amarelo"  -> 25;
            default -> VALUE_ERROR;
        };
    }

    static boolean validar(String cor, byte posicao, byte total_faixas){
        return VALUE_ERROR != switch (posicao) {
            case 1, 2 -> getDigito(cor);
            case 3 -> ((total_faixas <= 4) ? getLogMultiplicador(cor) : getDigito(cor));
            case 4 -> ((total_faixas <= 4) ? getTolerancia(cor) : getLogMultiplicador(cor));
            case 5 -> getTolerancia(cor);
            case 6 -> getCoeficiente(cor);
            default -> VALUE_ERROR;
        };
    }

    public static void main(String[] args) {
        // VARS ---------------------------------------------
        byte digito_centena, digito_dezena, digito_unidade, log_multi, coef;
        float tol, resistencia;

        // VALIDACAO --------------------------------------------
        if (args.length < 3 || args.length > 6) {
            System.out.printf("Argumentos inválidos: número total de faixas (%d) não é válido\n", args.length);
            return;
        }
        for (byte i = 0; i < args.length; i++) {
            args[i] = args[i].toLowerCase();
            if (!validar(args[i], (byte) (i+1), (byte) args.length)) {
                System.out.printf("Argumentos inválidos: cor (%s) não válida para sua posição (%d)\n", args[i], i+1);
                return;
            }
        }

        // RESULTADO ----------------------------------------
        if (args.length <= 4) {
            digito_centena = 0;
            digito_dezena  = getDigito(args[0]);
            digito_unidade = getDigito(args[1]);
            log_multi      = getLogMultiplicador(args[2]);
            tol            = (args.length == 3) ? -1 : getTolerancia(args[3]);
            coef           = -1;
        } else {
            digito_centena = getDigito(args[0]);
            digito_dezena  = getDigito(args[1]);
            digito_unidade = getDigito(args[2]);
            log_multi      = getLogMultiplicador(args[3]);
            tol            = getTolerancia(args[4]);
            coef           = (args.length == 6 ) ? getCoeficiente(args[5]) : -1;
        }

        resistencia = (float) ((100*digito_centena + 10*digito_dezena + digito_unidade)*Math.pow(10, log_multi));
        // Define o valor para string e simbolo (ex: 65, K)
        byte simbolo_index = 1;
        char[] simbolos = {'m',' ','k','M','G','T'};
        while(resistencia >= 1000){
            resistencia /= 1000;
            simbolo_index++;
        }
        while(resistencia < 1){
            resistencia *= 1000;
            simbolo_index--;
        }
        // Retorna o valor formatado
        String tolerancia = (tol == -1) ? "" : String.format("(+- %.2f%%)", tol);
        String coeficiente = (coef == -1) ? "" : String.format("%d ppm / K", coef);
        System.out.printf("Resistencia: %.2f %sOhm%s %s %s\n", resistencia,
                (simbolo_index==1)?"":simbolos[simbolo_index], (resistencia==1)?"":"s", tolerancia, coeficiente
        );
    }
}