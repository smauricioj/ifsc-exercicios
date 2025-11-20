package ifsc.poo.handebol.domain;

public class CampeonatoTime {
    // Atributos
    private int saldoVitorias;
    private int saldoGols;

    // Util
    private void checkInvariantes() {
        if (this.saldoGols < 0) this.saldoGols = 0;
        if (this.saldoVitorias < 0) this.saldoVitorias = 0;
    }

    // Construtor
    public CampeonatoTime(int saldoVitorias, int saldoGols) {
        this.saldoVitorias = saldoVitorias;
        this.saldoGols = saldoGols;
        checkInvariantes();
    }

    // Acessos
    public int getSaldoGols() {
        return saldoGols;
    }
    public int getSaldoVitorias() {
        return saldoVitorias;
    }
    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
        checkInvariantes();
    }

    public void setSaldoVitorias(int saldoVitorias) {
        this.saldoVitorias = saldoVitorias;
        checkInvariantes();
    }

    // Representação
    // ?

    // Comparação
    // ?
}
