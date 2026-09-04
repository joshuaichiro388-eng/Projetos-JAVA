
public class Quarto {

    private int numero;
    private double valorDiaria;
    private Tipo tipo;
    private Disponibilidade disponibilidade;

    public Quarto(int numero, double valorDiaria, Tipo tipo, Disponibilidade disponibilidade) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

}
