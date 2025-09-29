package ifsc.poo.handebol.domain;

import ifsc.poo.handebol.enums.Genero;

import java.time.LocalDate;
import java.util.Objects;

public class Jogador {
    // Estáticos
    public static final String NOME_PADRAO;
    public static final LocalDate NASC_PADRAO;
    public static final Genero GENERO_PADRAO;
    public static final double ALTURA_PADRAO;
    private static int contagem;

    static {
        NOME_PADRAO = "Jogador";
        GENERO_PADRAO = Genero.NAO_INFORMADO;
        NASC_PADRAO = LocalDate.now();
        ALTURA_PADRAO = 0.0;
        contagem = 0;
    }

    // Atributos
    private final int id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;
    private double altura;

    private Time timeQueCapitaneia;
    private Time time;

    // Utils
    private void checkInvariantes(){
        if (nome.isEmpty()) nome = NOME_PADRAO;
        if (Objects.isNull(dataDeNascimento)
                || dataDeNascimento.isAfter(LocalDate.now())) dataDeNascimento = NASC_PADRAO;
        if (Objects.isNull(genero)) genero = GENERO_PADRAO;
        if (altura < 0.0) altura = ALTURA_PADRAO;
        if (Objects.isNull(time)) this.time = new Time("");
        if (!Objects.isNull(timeQueCapitaneia)
                && !time.equals(timeQueCapitaneia)) timeQueCapitaneia = null;
    }

    // Construtor
    public Jogador(Time time, String nome, LocalDate dataDeNascimento, Genero genero, double altura) {
        this.time = time;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.altura = altura;
        this.id = ++contagem;
        this.checkInvariantes();
    }

    // Acessos
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public double getAltura() {
        return altura;
    }
    public Genero getGenero() {
        return genero;
    }
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
    public Time getTimeQueCapitaneia() {
        return timeQueCapitaneia;
    }
    public Time getTime() {
        return time;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        this.checkInvariantes();
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        this.checkInvariantes();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
        this.checkInvariantes();
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.checkInvariantes();
    }

    public void addTimeQueCapitaneia(Time timeQueCapitaneia) {
        this.timeQueCapitaneia = timeQueCapitaneia;
        this.checkInvariantes();
    }

    public void removeTimeQueCapitaneia() {
        this.timeQueCapitaneia = null;
    }

    public void addTime(Time time) {
        this.time = time;
        this.checkInvariantes();
    }

    public void removeTime() {
        this.time = null;
    }

    // Representação
    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", altura=" + altura +
                '}';
    }

    // Comparação
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador jogador)) return false;
        return id == jogador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
