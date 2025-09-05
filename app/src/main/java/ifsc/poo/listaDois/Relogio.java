package ifsc.poo.listaDois;

import java.util.Arrays;
import java.util.Objects;

public class Relogio {
    // Atributos
    byte hora, minuto, segundo;

    // Construtores
    public Relogio() {
        this((byte) 0, (byte) 0, (byte) 0);
    }

    public Relogio(String repr) {
        if (!repr.matches("^\\d{2}:\\d{2}:\\d{2}$")) repr = "00:00:00";
        String[] args = repr.split(":");
        this.hora = Byte.parseByte(args[0]);
        this.minuto = Byte.parseByte(args[1]);
        this.segundo = Byte.parseByte(args[2]);
    }

    public Relogio(byte hora, byte minuto, byte segundo) {
        if (naoValido(hora, 24)) hora = 0;
        if (naoValido(minuto, 59)) minuto = 0;
        if (naoValido(segundo, 59)) segundo = 0;
        this.setHMS(hora, minuto, segundo);
    }

    // Acessos
    public byte getHora() {
        return this.hora;
    }

    public byte getMinuto() {
        return this.minuto;
    }

    public byte getSegundo() {
        return this.segundo;
    }

    public void setHMS(byte hora, byte minuto, byte segundo) {
        if (this.naoValido(hora, 24)
                || this.naoValido(minuto, 59)
                || this.naoValido(segundo, 59)) return;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    // Representação
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Relogio relogio)) return false;
        return hora == relogio.hora && minuto == relogio.minuto && segundo == relogio.segundo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hora, minuto, segundo);
    }

    // Utilitários
    private boolean naoValido(byte valor, int max) {
        return (valor < 0 || valor > max);
    }

    // Métodos
    public void incHora() {
        if (++this.hora > 23) {
            this.hora = 0;
        }
    }

    public void incMinuto() {
        if (++this.minuto > 59) {
            this.minuto = 0;
            this.incHora();
        }
    }

    public void incSegundo() {
        if (++this.segundo > 59) {
            this.segundo = 0;
            this.incMinuto();
        }
    }

    public int tempoTotal() {
        return this.segundo + this.minuto*60 + this.hora*60*60;
    }

    public int tempoDiferenca(Relogio outro) {
        if (Objects.isNull(outro)) return 0;
        return outro.tempoTotal() - this.tempoTotal();
    }

    public void sincronizar(Relogio outro) {
        if (Objects.isNull(outro)) return;
        this.setHMS(outro.hora, outro.minuto, outro.segundo);
    }

    public static void main(String[] args) {
        Relogio relogio = new Relogio("14:58:32");
        relogio.incMinuto();
        relogio.incMinuto();
        System.out.println(relogio);
        Relogio relogio2 = new Relogio("23:59:59");
        relogio2.incSegundo();
        System.out.println(relogio2);
        relogio2.sincronizar(relogio);
        System.out.println(relogio2);
    }
}
