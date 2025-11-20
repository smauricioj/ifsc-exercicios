package ifsc.poo.prova01;

import java.util.Scanner;

public class Geodistancias {

    /**
     * Função auxiliar que calcula o quadrado do seno da metade da diferença
     * entre dois ângulos (em radianos).
     * Equivale a sin²((x - y) / 2).
     */
    public static double sin2dif2(double x, double y) {
        return Math.pow(Math.sin((x - y) / 2), 2);
    }

    /**
     * Fórmula de Haverseno para calcular a distância entre dois pontos
     * na superfície de uma esfera de raio r, dados em coordenadas
     * (latitude e longitude em radianos).
     */
    public static double haverseno(double r, double lat1, double lat2, double long1, double long2) {
        return 2 * r * Math.asin(Math.sqrt(
                sin2dif2(lat2, lat1) + (sin2dif2(long2, long1) * Math.cos(lat1) * Math.cos(lat2))
        ));
    }

    public static void main(String[] args) {
        // Raio médio da Terra em km
        double RAIO_TERRA = 6378.13;

        // Número de capitais no arquivo (fixo para a prova)
        int N_CIDADES = 234;

        // Índices das colunas no arquivo CSV
        int COL_NOME = 1, COL_LAT = 3, COL_LON = 4;

        // Scanner para ler do redirecionamento de entrada (< capitais.csv)
        Scanner sc = new Scanner(System.in);

        // Descarta a primeira linha (cabeçalho do CSV)
        sc.nextLine();

        // Vetor com nomes das cidades
        String[] nomes = new String[N_CIDADES];

        // Matriz com coordenadas: [cidade][0=lat,1=lon]
        double[][] coord = new double[N_CIDADES][2];

        // Vetor auxiliar para separar cada linha do CSV
        String[] partes;

        // Leitura das capitais
        for (int i = 0; i < N_CIDADES && sc.hasNext(); i++) {
            partes = sc.nextLine().split(",");
            nomes[i] = partes[COL_NOME];
            coord[i] = new double[]{
                    Double.parseDouble(partes[COL_LAT]), // latitude
                    Double.parseDouble(partes[COL_LON])  // longitude
            };
        }

        // Variáveis de controle da maior distância
        double dist, max_dist = Double.MIN_VALUE;
        int cidade_i = -1, cidade_j = -1;

        // Calcula a distância entre todos os pares de capitais
        for (int i = 0; i < N_CIDADES; i++) {
            for (int j = 0; j < i; j++) {
                dist = haverseno(RAIO_TERRA,
                        coord[i][0], coord[j][0],
                        coord[i][1], coord[j][1]);
                if (dist > max_dist) {
                    max_dist = dist;
                    cidade_i = i;
                    cidade_j = j;
                }
            }
        }

        // Exibe resultado
        System.out.printf("As capitais mais distantes são: %s e %s, com distância de %.2f km\n",
                nomes[cidade_i], nomes[cidade_j], max_dist);
        sc.close();
    }
}
