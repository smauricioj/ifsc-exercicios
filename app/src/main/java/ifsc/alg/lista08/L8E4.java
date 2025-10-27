package ifsc.alg.lista08;

import java.util.Scanner;

public class L8E4 {
    static final double RAIO_TERRA = 6378.13;

    static double hav(double theta) {
        return Math.pow(Math.sin(theta) / 2, 2);
    }

    static double distancia(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);
        return 2*RAIO_TERRA*Math.asin(
                Math.sqrt(hav(lat2 - lat1) +  hav(lon2 - lon1) * Math.cos(lat1) * Math.cos(lat2))
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com as coordenadas do primeiro ponto (em graus): ");
        double lat1 = sc.nextDouble();
        double lon1 = sc.nextDouble();
        if (lat1 < -90 || lat1 > 90 || lon1 < -180 || lon1 > 180) {
            System.out.println("Coordenadas inválidas");
            return;
        }
        System.out.print("Entre com as coordenadas do segundo ponto (em graus): ");
        double lat2 = sc.nextDouble();
        double lon2 = sc.nextDouble();
        if (lat2 < -90 || lat2 > 90 || lon2 < -180 || lon2 > 180) {
            System.out.println("Coordenadas inválidas");
            return;
        }
        System.out.printf("A distância entre os pontos é %.2f%n", distancia(lat1, lon1, lat2, lon2));
        sc.close();
    }
}
