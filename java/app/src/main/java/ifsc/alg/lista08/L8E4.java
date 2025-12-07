/*
A posição de qualquer ponto sobre a superfície da Terra pode ser representada por meio de
coordenadas geográficas, que são compostas por latitude e longitude. A latitude indica a
distância angular em relação à linha do Equador, enquanto a longitude indica a distância angular
em relação ao meridiano de Greenwich. Essas medidas permitem identificar com precisão a
localização de cidades ou quaisquer outros pontos na superfície terrestre. A Figura abaixo
mostra as linhas de latitude e longitude equivalentes no globo terrestre. Perceba que os valores
máximo e mínimo das coordenadas são −90o e 90o para latitude, e −180o e 180o para longitude,
respectivamente.

Para calcular a distância entre dois pontos usando essas coordenadas, é necessário considerar
a curvatura da Terra. Um modelo simples e bastante usado em geoprocessamento é assumir
que a Terra tem o formato de uma esfera. Nesse caso, a Equação de Haverseno permite
calcular a distância entre dois pontos a partir de seus pares de latitude e longitude, levando
em conta a geometria esférica. Essa abordagem é amplamente aplicada em sistemas de
navegação e serviços de mapas digitais.

A fórmula da Equação de Haverseno é dada por:
d = 2R ∗ arcsin (√ hav(ϕ2 − ϕ1) + cos(ϕ1)cos(ϕ2)hav(λ2 − λ1))
onde:
• d é a distância entre os dois pontos
• R é o raio da Terra (≈ 6378,13 km)
• (ϕ1, λ1) e (ϕ2, λ2) são as coordenadas geográficas (latitude e longitude) dos dois pontos,
em radianos
• hav() é a função haverseno, definida como hav(θ) = sin2(θ/2)

Elabore um programa Java que LÊ as coordenadas geográficas (lat, lon) em graus de dois
pontos na superfície da Terra e ESCREVE a distância entre eles em quilômetros.
Para esse exercício, implemente as seguintes funções:
• double hav(double theta): Calcula o valor do haverseno de um ângulo em radianos
• double distancia(double lat1, double lon1, double lat2, double lon2): Calcula
a distância entre dois pontos na superfície da Terra, em km, dadas suas coordena-
das em graus

Restrições
• O programa só deve aceitar valores válidos para as coordenadas (latitude entre -90 e 90,
longitude entre -180 e 180)
• A função distancia deve ser expressa em termos da função hav
*/

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
                hav(lat2 - lat1) + (hav(lon2 - lon1) * Math.cos(lat1) * Math.cos(lat2))));
    }

    /**
     * Exaustivamente lê uma coordenada da entrada padrão do sistema até
     * que seja válida entre min (inclusive) e max (exclusive)
     */
    static double lerCoordenada(String rotulo, double min, double max) {
        double coordenada;
        do {
            OUT.printf("Entre com a %s (em graus): ", rotulo);
            coordenada = IN.nextDouble();
        } while (coordenada <= min || coordenada > max);
        return coordenada;
    }

    public static void main(String[] args) {
        OUT.printf("A distância é: %.2f km%n", distancia(
                lerCoordenada("latitude do primeiro ponto", -90.0, 90.0),
                lerCoordenada("longitude do primeiro ponto", -180.0, 180.0),
                lerCoordenada("latitude do segundo ponto", -90.0, 90.0),
                lerCoordenada("longitude do segundo ponto", -180.0, 180.0)));
        IN.close();
    }
}
