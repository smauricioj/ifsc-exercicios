package ifsc.poo.provaUm;

public class Calendario {
    static final int VALUE_ERROR = -1;

    static int numeroMes(String mes){
        return switch (mes.toLowerCase()) {
            case "janeiro"   ->  1;
            case "fevereiro" ->  2;
            case "março"     ->  3;
            case "abril"     ->  4;
            case "maio"      ->  5;
            case "junho"     ->  6;
            case "julho"     ->  7;
            case "agosto"    ->  8;
            case "setembro"  ->  9;
            case "outubro"   -> 10;
            case "novembro"  -> 11;
            case "dezembro"  -> 12;
            default -> VALUE_ERROR;
        };
    }

    static boolean ehBisexto(int ano) {
        return ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0);
    }

    static int diasDoAno(int ano) {
        return ehBisexto(ano) ? 366 : 365;
    }

    static int diasDoMes(int mes, int ano){
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11           -> 30;
            case 2                     -> ehBisexto(ano) ? 29 : 28;
            default                    -> VALUE_ERROR;
        };
    }

    static int diasPercorridosNoAno(int dia, int mes, int ano) {
        int dias = dia;
        for (int mes_completo = 1; mes_completo < mes; mes_completo++) {
            dias += diasDoMes(mes_completo, ano);
        }
        return dias;
    }

    static int diasFaltandoNoAno(int dia, int mes, int ano) {
        return diasDoAno(ano) - diasPercorridosNoAno(dia, mes, ano);
    }

    public static void main(String[] args) {
        // Validadores
        // N de argumentos
        if (args.length != 2) {
            System.out.println("Não foram informadas duas datas");
            return;
        }
        // N de partes nas datas
        String[] textoData1 = args[0].split("/"), textoData2 = args[1].split("/");
        if (textoData1.length != 3 || textoData2.length != 3) {
            System.out.println("Data inválida");
            return;
        }
        // Nomes de meses
        int mes1 = numeroMes(textoData1[1]), mes2 = numeroMes(textoData2[1]);
        if (mes1 == VALUE_ERROR || mes2 == VALUE_ERROR) {
            System.out.println("Mês inválido");
            return;
        }
        // Anos
        int ano1 = Integer.parseInt(textoData1[2]), ano2 = Integer.parseInt(textoData2[2]);
        if (ano1 < 0 || ano2 < 0) {
            System.out.println("Ano inválido");
            return;
        }
        // Dias
        int dia1 = Integer.parseInt(textoData1[0]), dia2 = Integer.parseInt(textoData2[0]);
        if (dia1 < 1
                || dia2 < 1
                || dia1 > diasDoMes(mes1, ano1)
                || dia2 > diasDoMes(mes2, ano2)) {
            System.out.println("Dia inválido");
            return;
        }
        // Ordem
        if (ano2 < ano1
                || (ano2 == ano1 && mes2 < mes1)
                || (ano2 == ano1 && mes2 == mes1 && dia2 < dia1)) {
            System.out.println("A segunda data deve ser depois da primeira");
            return;
        }

        // Calculo da diferença
        int diff = 0;
        for (int ano = ano1; ano <= ano2; ano++) {
            diff += diasDoAno(ano);
        }
        diff -= diasPercorridosNoAno(dia1, mes1, ano1);
        diff -= diasFaltandoNoAno(dia2, mes2, ano2);

        // Saída
        System.out.printf("Dias percorridos: %d", diff);
    }
}
