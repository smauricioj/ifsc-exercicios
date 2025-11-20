package ifsc.alg.lista08;

import java.io.PrintStream;
import java.util.Scanner;

public class L8E4 {
    // Raio médio da Terra em km
    static final double RAIO_TERRA = 6378.13;
    static final Scanner IN = new Scanner(System.in);
    static final PrintStream OUT = System.out;

    /**
     * Função auxiliar que calcula o haverseno de um angulo em radianos
     */
    static double hav(double theta) {
        return Math.pow(Math.sin(theta / 2), 2);
    }

    /**
     * Fórmula de Haverseno para calcular a distância entre dois pontos
     * na superfície de uma esfera de raio r, dados em coordenadas
     * (latitude e longitude em graus).
     */
    static double distancia(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        return 2 * RAIO_TERRA * Math.asin(Math.sqrt(
                hav(lat2 - lat1) + (hav(lon2 - lon1) * Math.cos(lat1) * Math.cos(lat2))
        ));
    }

    static double lerCoordenada(String rotulo, double min, double max) {
        double coordenada;
        do {
            OUT.printf("Entre com a %s (em graus): ", rotulo);
            coordenada = IN.nextDouble();
        } while (coordenada < min || coordenada > max);
        return coordenada;
    }

    public static void main(String[] args) {
        OUT.printf("A distância é: %.2f km%n", distancia(
                lerCoordenada("latitude do primeiro ponto", -90.0, 90.0),
                lerCoordenada("longitude do primeiro ponto", -180.0, 180.0),
                lerCoordenada("latitude do segundo ponto", -90.0, 90.0),
                lerCoordenada("longitude do segundo ponto", -180.0, 180.0)
        ));
        IN.close();
    }
}
