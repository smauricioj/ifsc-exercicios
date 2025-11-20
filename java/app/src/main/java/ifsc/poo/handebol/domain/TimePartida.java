package ifsc.poo.handebol.domain;

public class TimePartida {
    // Atributos
    private int gols;

    // Util
    private void checkInvariantes() {
        if (this.gols < 0) this.gols = 0;
    }

    // Construtor
    public TimePartida(int gols) {
        this.gols = gols;
        checkInvariantes();
    }

    // Acessos
    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
        checkInvariantes();
    }

    // Representação
    // ?

    // Comparação
    // ?
}
