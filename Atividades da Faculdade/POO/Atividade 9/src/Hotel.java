
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Hotel {

    private List<Quarto> quartos;

    public Hotel() {
        quartos = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    // Exercício 10
    public List<Quarto> filtrar(Predicate<Quarto> criterio) {

        List<Quarto> resultado = new ArrayList<>();

        for (Quarto quarto : quartos) {

            if (criterio.test(quarto)) {
                resultado.add(quarto);
            }

        }

        return resultado;
    }

    // Exercício 11
    public <R> List<R> transformar(Function<Quarto, R> funcao) {

        List<R> resultado = new ArrayList<>();

        for (Quarto quarto : quartos) {

            R valor = funcao.apply(quarto);

            resultado.add(valor);
        }

        return resultado;
    }

}
