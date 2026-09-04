import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Quarto q1 = new Quarto(
                101,
                180.0,
                Tipo.SIMPLES,
                Disponibilidade.DISPONIVEL
        );

        Quarto q2 = new Quarto(
                102,
                110.0,
                Tipo.DUPLO,
                Disponibilidade.OCUPADO
        );

        Quarto q3 = new Quarto(
                103,
                500.0,
                Tipo.COBERTURA,
                Disponibilidade.DISPONIVEL
        );

        Hotel hotel = new Hotel();

        hotel.adicionarQuarto(q1);
        hotel.adicionarQuarto(q2);
        hotel.adicionarQuarto(q3);

        System.out.println("===== EXERCÍCIO 1 =====");

        Predicate<Quarto> estaDisponivel =
                quarto -> quarto.getDisponibilidade() == Disponibilidade.DISPONIVEL;

        System.out.println("q1 -> " + estaDisponivel.test(q1));
        System.out.println("q2 -> " + estaDisponivel.test(q2));
        System.out.println("q3 -> " + estaDisponivel.test(q3));

        System.out.println("\n===== EXERCÍCIO 2 =====");

        Predicate<Quarto> diariaBarata =
                quarto -> quarto.getValorDiaria() < 200.0;

        System.out.println(
                "Quarto 101 -> " + diariaBarata.test(q1)
        );

        System.out.println(
                "Quarto 102 -> " + diariaBarata.test(q2)
        );

        System.out.println(
                "Quarto 103 -> " + diariaBarata.test(q3)
        );

        System.out.println("\n===== EXERCÍCIO 3 =====");

        for (Quarto quarto : hotel.getQuartos()) {

            if (estaDisponivel.test(quarto)) {

                System.out.println("Quarto " + quarto.getNumero());

            }
        }

        System.out.println("\n===== EXERCÍCIO 4 =====");

        Predicate<Quarto> disponivelEBarato =
                estaDisponivel.and(diariaBarata);

        System.out.println(
                "Quarto 101 -> " + disponivelEBarato.test(q1)
        );

        System.out.println(
                "Quarto 102 -> " + disponivelEBarato.test(q2)
        );

        System.out.println(
                "Quarto 103 -> " + disponivelEBarato.test(q3)
        );

        System.out.println("\n--- Disponível OU barato ---");

        Predicate<Quarto> disponivelOuBarato =
                estaDisponivel.or(diariaBarata);

        System.out.println(
                "Quarto 101 -> " + disponivelOuBarato.test(q1)
        );

        System.out.println(
                "Quarto 102 -> " + disponivelOuBarato.test(q2)
        );

        System.out.println(
                "Quarto 103 -> " + disponivelOuBarato.test(q3)
        );

        System.out.println("\n===== EXERCÍCIO 5 =====");

        Function<Quarto, Integer> obterNumero =
                quarto -> quarto.getNumero();

        System.out.println(obterNumero.apply(q1));
        System.out.println(obterNumero.apply(q2));
        System.out.println(obterNumero.apply(q3));

        System.out.println("\n===== EXERCÍCIO 6 =====");

        Function<Quarto, Double> obterValorDiaria =
                quarto -> quarto.getValorDiaria();

        for (Quarto quarto : hotel.getQuartos()) {

            System.out.println(
                    obterValorDiaria.apply(quarto)
            );

        }

        System.out.println("\n===== EXERCÍCIO 7 =====");

        Function<Quarto, String> descricaoQuarto =
                quarto -> "Quarto " + quarto.getNumero()
                        + " - Diária: R$ "
                        + quarto.getValorDiaria();

        for (Quarto quarto : hotel.getQuartos()) {

            System.out.println(
                    descricaoQuarto.apply(quarto)
            );

        }

        System.out.println("\n===== EXERCÍCIO 8 =====");

        Function<Quarto, Double> valorTresDiarias =
                quarto -> quarto.getValorDiaria() * 3;

        System.out.println(
                "Quarto 101 - 3 diárias: R$ "
                        + valorTresDiarias.apply(q1)
        );

        System.out.println(
                "Quarto 102 - 3 diárias: R$ "
                        + valorTresDiarias.apply(q2)
        );

        System.out.println(
                "Quarto 103 - 3 diárias: R$ "
                        + valorTresDiarias.apply(q3)
        );

        System.out.println("\n--- 3 diárias + 10% de taxa ---");

        Function<Quarto, Double> valorTresDiariasComTaxa =
                quarto -> quarto.getValorDiaria() * 3 * 1.10;

        System.out.println(
                "Quarto 101: R$ "
                        + valorTresDiariasComTaxa.apply(q1)
        );

        System.out.println(
                "Quarto 102: R$ "
                        + valorTresDiariasComTaxa.apply(q2)
        );

        System.out.println(
                "Quarto 103: R$ "
                        + valorTresDiariasComTaxa.apply(q3)
        );

        System.out.println("\n===== EXERCÍCIO 9 =====");

        for (Quarto quarto : hotel.getQuartos()) {

            if (estaDisponivel.test(quarto)) {

                System.out.println(
                        descricaoQuarto.apply(quarto)
                );

            }

        }

        System.out.println("\n===== EXERCÍCIO 10 =====");

        System.out.println("--- Quartos disponíveis ---");

        List<Quarto> disponiveis =
                hotel.filtrar(
                        quarto -> quarto.getDisponibilidade()
                                == Disponibilidade.DISPONIVEL
                );

        for (Quarto quarto : disponiveis) {

            System.out.println(
                    "Quarto " + quarto.getNumero()
            );

        }

        System.out.println("--- Quartos abaixo de R$ 300 ---");

        List<Quarto> abaixo300 =
                hotel.filtrar(
                        quarto -> quarto.getValorDiaria() < 300.0
                );

        for (Quarto quarto : abaixo300) {

            System.out.println(
                    "Quarto " + quarto.getNumero()
            );

        }

        System.out.println("--- Quartos acima de R$ 150 ---");

        List<Quarto> acima150 =
                hotel.filtrar(
                        quarto -> quarto.getValorDiaria() > 150.0
                );

        for (Quarto quarto : acima150) {

            System.out.println(
                    "Quarto " + quarto.getNumero()
            );

        }

        System.out.println("\n===== EXERCÍCIO 11 =====");

        List<Integer> numeros =
                hotel.transformar(
                        quarto -> quarto.getNumero()
                );

        System.out.println("--- Números ---");

        for (Integer numero : numeros) {

            System.out.println(numero);

        }

        List<Double> valores =
                hotel.transformar(
                        quarto -> quarto.getValorDiaria()
                );

        System.out.println("--- Valores ---");

        for (Double valor : valores) {

            System.out.println(valor);

        }

        List<String> descricoes =
                hotel.transformar(
                        quarto -> "Quarto "
                                + quarto.getNumero()
                                + " - Diária: R$ "
                                + quarto.getValorDiaria()
                );

        System.out.println("--- Descrições ---");

        for (String descricao : descricoes) {

            System.out.println(descricao);

        }

        System.out.println("\n===== EXERCÍCIO 12 =====");

        Predicate<Quarto> disponivel =
                quarto -> quarto.getDisponibilidade()
                        == Disponibilidade.DISPONIVEL;

        Predicate<Quarto> ate300 =
                quarto -> quarto.getValorDiaria() <= 300.0;

        Predicate<Quarto> criterio =
                disponivel.and(ate300);

        List<Quarto> quartosEncontrados =
                hotel.filtrar(criterio);

        Function<Quarto, String> formatar =
                quarto -> "Quarto "
                        + quarto.getNumero()
                        + " disponível por R$ "
                        + quarto.getValorDiaria();

        for (Quarto quarto : quartosEncontrados) {

            System.out.println(
                    formatar.apply(quarto)
            );

        }

    }

}
