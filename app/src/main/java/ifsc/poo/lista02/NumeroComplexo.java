package ifsc.poo.lista02;

import java.text.DecimalFormat;
import java.util.Objects;

public class NumeroComplexo {
    // Estáticos
    // Para mostrar até 4 casas decimais sempre significativas
    static private final DecimalFormat df = new DecimalFormat("0.####");

    // Atributos
    private double real, imag;

    // Construtores
    public NumeroComplexo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Acessos
    public double getImag() {
        return imag;
    }
    public void setImag(double imag) {
        this.imag = imag;
    }
    public double getReal() {
        return real;
    }
    public void setReal(double real) {
        this.real = real;
    }

    // Representação
    @Override
    public String toString() {
        return String.format("(%s%s%si)", df.format(this.real),(this.imag>=0)?"+":"",df.format(this.imag));
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumeroComplexo outro)) return false;
        return Double.compare(real, outro.real) == 0
            && Double.compare(imag, outro.imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    // Métodos
    public void somar(NumeroComplexo outro) {
        if (Objects.isNull(outro)) return;
        this.real += outro.real;
        this.imag += outro.imag;
    }

    public void subtrair(NumeroComplexo outro) {
        if (Objects.isNull(outro)) return;
        this.real -= outro.real;
        this.imag -= outro.imag;
    }

    public void multiplicar(NumeroComplexo outro) {
        if (Objects.isNull(outro)) return;
        double orig_real = this.real;
        this.real = (this.real * outro.real) - (this.imag * outro.imag);
        this.imag = (orig_real * outro.imag) + (this.imag * outro.real);
    }

    public void dividir(NumeroComplexo outro) {
        if (Objects.isNull(outro)) return;
        double divisor = (Math.pow(outro.real, 2) + Math.pow(outro.imag, 2));
        double this_real = this.real;
        this.real = ((this.real * outro.real) + (this.imag * outro.imag))/divisor;
        this.imag = ((this.imag * outro.real) - (this_real * outro.imag))/divisor;
    }

    public NumeroComplexo conjugado() {
        return new NumeroComplexo(this.real, this.imag*(-1));
    }

    public double modulo() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public static void main(String[] args) {
        // Crie dois números complexos, n = (5 + 4i) e m = (7 − 3i);
        NumeroComplexo n = new NumeroComplexo(5,4);
        NumeroComplexo m = new NumeroComplexo(7,-3);

        // Adicione m a n e mostre que o resultado é (12 + i);
        n.somar(m);
        System.out.println(n);
        n.subtrair(m);          // Pra retornar n ao valor inicial

        // Divida n por m e mostre que o resultado é (0.39 + 0.74i)
        n.dividir(m);
        System.out.println(n);
        n.multiplicar(m);       // Pra retornar n ao valor inicial

        // Mostre que o módulo de n é 6.4
        System.out.println(n.modulo());
    }
}
