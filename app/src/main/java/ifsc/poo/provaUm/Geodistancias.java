package ifsc.poo.provaUm;

import java.util.Scanner;

public class Geodistancias {
    public static double grau_para_rad(double grau) {
        return grau*Math.PI/180;
    }
    public static double sin2dif2(double x, double y){
        return Math.pow(Math.sin((x-y)/2), 2);
    }
    public static double haverseno(double r, double lat1, double lat2, double long1, double long2){
        return 2*r*Math.asin(Math.sqrt(
                sin2dif2(lat2, lat1)+(sin2dif2(long2, long1)*Math.cos(lat1)*Math.cos(lat2))
        ));
    }
    public static void main(String[] args) {
        double RAIO_TERRA = 6367.4445;
        int N_CIDADES = 234, COL_NOME = 1, COL_LAT = 2, COL_LON = 3;
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // remove linha do cabeçalho
        String[] nomes = new String[N_CIDADES];
        double[][] coord = new double[N_CIDADES][2];
        for (int i = 0; i < N_CIDADES && sc.hasNext(); i++) {
            String[] partes = sc.nextLine().split(",");
            nomes[i] = String.valueOf(partes[COL_NOME]);
            coord[i] = new double[]{
                    grau_para_rad(Double.parseDouble(partes[COL_LAT])),
                    grau_para_rad(Double.parseDouble(partes[COL_LON]))
            };
        }
        double dist, max_dist = Double.MIN_VALUE;
        int cidade_i = -1, cidade_j = -1;
        for (int i = 0; i < N_CIDADES; i++) {
            for (int j = 0; j <= i; j++) {
                dist = haverseno(RAIO_TERRA, coord[i][0], coord[j][0], coord[i][1], coord[j][1]);
                if (dist > max_dist) {
                    max_dist = dist;
                    cidade_i = i;
                    cidade_j = j;
                }
            }
        }
        System.out.printf("As capitais mais distantes são: %s e %s, com distância de %.2f km\n",
                nomes[cidade_i], nomes[cidade_j], max_dist);
        sc.close();
    }
}