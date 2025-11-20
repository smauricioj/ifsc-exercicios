package ifsc.poo.prova01;

public class CalculadoraResistencia {
    // CONSTANTES ---------------------------------------------------------
    // Valor usado para indicar que o argumento informado está errado
    static byte VALUE_ERROR = -10;
    static byte UNDEFINED = -1;

    // MÈTODOS ------------------------------------------------------------
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
        // Log base 10 do multiplicador, para usar apenas um byte. Depois, basta calcular 10^log
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
        // VARIAVEIS ---------------------------------------------
        byte num_faixas = (byte) args.length;
        byte digito_centena, digito_dezena, digito_unidade, log_multi, coeficiente;
        float tolerancia, resistencia;

        // VALIDACAO --------------------------------------------
        if (num_faixas < 3 || num_faixas > 6) {
            System.out.printf("Argumentos inválidos: número total de faixas (%d) não é válido\n", num_faixas);
            return;
        }
        for (byte i = 1; i <= num_faixas; i++) {
            args[i] = args[i].toLowerCase();
            if (!validar(args[i], i, num_faixas)) {
                System.out.printf("Argumentos inválidos: cor (%s) não válida para sua posição (%d)\n", args[i], i);
                return;
            }
        }

        // CALCULO ----------------------------------------
        if (num_faixas <= 4) {
            digito_centena = 0;
            digito_dezena  = getDigito(args[0]);
            digito_unidade = getDigito(args[1]);
            log_multi      = getLogMultiplicador(args[2]);
            tolerancia     = (num_faixas == 3) ? -1 : getTolerancia(args[3]);
            coeficiente    = UNDEFINED;
        } else {
            digito_centena = getDigito(args[0]);
            digito_dezena  = getDigito(args[1]);
            digito_unidade = getDigito(args[2]);
            log_multi      = getLogMultiplicador(args[3]);
            tolerancia     = getTolerancia(args[4]);
            coeficiente    = (num_faixas == 6) ? getCoeficiente(args[5]) : UNDEFINED;
        }
        resistencia = (float) ((100*digito_centena + 10*digito_dezena + digito_unidade)*Math.pow(10, log_multi));

        char[] simbolos = {'m',' ','k','M','G','T'};  // ------------------------------------------------------ //
        byte simbolo_i = 1;                           //
        while(resistencia >= 1000){                   // Essa parte eu não cobrei na prova
            resistencia /= 1000;                      // mas está corretamente implementada
            simbolo_i++;                              //
        }                                             // Ela garante que o valor da resistência tenha
        while(resistencia < 1){                       // no máximo 3 dígitos significativos
            resistencia *= 1000;                      // e que o símbolo apresentado esteja correto
            simbolo_i--;                              //
        }                                             // ------------------------------------------------------ //

        // SAIDA -----------------------------------------
        String tolerancia_texto = (tolerancia != UNDEFINED) ? String.format(" (+- %.2f%%) ", tolerancia) : "";
        String coeficiente_texto = (coeficiente != UNDEFINED) ? String.format(" %d ppm / K ", coeficiente) : "";
        System.out.printf("Resistencia: %.2f %sOhm%s%s%s\n",
                resistencia,
                (simbolo_i == 1) ? "" : simbolos[simbolo_i],
                (resistencia == 1) ? "" : "s",
                tolerancia_texto,
                coeficiente_texto
        );
    }
}