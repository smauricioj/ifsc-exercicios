package ifsc.poo.lista02;

import java.util.Objects;

public class Relogio {
    // Atributos
    // Escolhi bytes, pois esses valores são sempre menores que 127
    byte hora, minuto, segundo;

    // Construtores
    public Relogio() {
        this((byte) 0, (byte) 0, (byte) 0);
    }

    public Relogio(String repr) {
        // Esse construtor não foi exigido. eu fiz pq gosto da ideia de iniciar o relógio com uma string
        if (!repr.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")) repr = "00:00:00";
        String[] parts = repr.split(":");
        this.hora = Byte.parseByte(parts[0]);
        this.minuto = Byte.parseByte(parts[1]);
        this.segundo = Byte.parseByte(parts[2]);
    }

    public Relogio(byte hora, byte minuto, byte segundo) {
        // Se a hora informada for inválida, inicia em 00:00:00
        if (this.horaInvalida(hora, minuto, segundo)) {
            hora = 0;
            minuto = 0;
            segundo = 0;
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
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
        // Se a hora informada for inválida, não altera o estado
        if (this.horaInvalida(hora, minuto, segundo)) return;
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
        if (this == o) return true;
        if (!(o instanceof Relogio relogio)) return false;
        return hora == relogio.hora
                && minuto == relogio.minuto
                && segundo == relogio.segundo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hora, minuto, segundo);
    }

    // Utilitários
    private boolean naoValido(byte valor, int max) {
        return (valor < 0 || valor > max);
    }

    private boolean horaInvalida(byte hora, byte minuto, byte segundo) {
        return (this.naoValido(hora, 24)
                || this.naoValido(minuto, 59)
                || this.naoValido(segundo, 59));
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
        // Se for negativo, então quem recebeu a mensagem (this) está na frente
        // Se for positivo, então o outro Relogio está na frente!
        if (Objects.isNull(outro)) return 0;
        return outro.tempoTotal() - this.tempoTotal();
    }

    public void sincronizar(Relogio outro) {
        if (Objects.isNull(outro)) return;
        this.setHMS(outro.hora, outro.minuto, outro.segundo);
    }

    public static void main(String[] args) {
        // Crie um relógio e ajuste o seu valor para 14:58:32;
        Relogio relogio = new Relogio((byte) 14, (byte) 58, (byte) 32);

        // Incremente o valor do relógio em dois minutos. Que horas o relógio marca agora?
        relogio.incMinuto();
        relogio.incMinuto();
        System.out.println(relogio);

        // Crie um segundo relógio e ajuste seu valor para 23:59:59;
        Relogio relogio2 = new Relogio("23:59:59");

        // Incremente o valor do relógio em um segundo. Que horas o relógio marca agora?
        relogio2.incSegundo();
        System.out.println(relogio2);

        // Sincronize o segundo relógio com o primeiro. Que horas o relógio marca agora?
        relogio2.sincronizar(relogio);
        System.out.println(relogio2);
    }
}
