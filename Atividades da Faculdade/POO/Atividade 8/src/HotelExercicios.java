import java.util.*;

class Hospede {
    private String nome;
    private String cpf;
    public Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public Hospede(String nome) {
        this(nome, "CPF não informado");
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Hóspede: " + nome + " | CPF: " + cpf;
    }
}
class ServicoHotel {
    public double calcularPreco() {
        return 0.0;
    }
}
class CafeDaManha extends ServicoHotel {
    @Override
    public double calcularPreco() {
        return 25.0;
    }
}
class Pagamento {
    public void processar() {
        System.out.println("Processando pagamento genérico.");
    }
}
class PagamentoCartao extends Pagamento {
    @Override
    public void processar() {
        System.out.println("Processando pagamento no cartão de crédito/débito.");
    }
}
// Ex.5: Sobrecarga (overload) - mesmo nome "reservar", parâmetros diferentes.
class BuscaQuarto {
    public String buscarQuarto(int numero) {
        return "Buscando quarto pelo número: " + numero;
    }
    public String buscarQuarto(String tipo) {
        return "Buscando quarto pelo tipo: " + tipo;
    }
    public String buscarQuarto(int numero, boolean disponivel) {
        return "Buscando quarto " + numero + " com disponibilidade = " + disponivel;
    }
}
class Funcionario {
    protected String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }
    public void atender() {
        System.out.println(nome + " está atendendo um hóspede.");
    }
    public void atender(String assunto) {
        System.out.println(nome + " está atendendo sobre: " + assunto);
    }
}
// Ex.6: Sobrescrita (override) - Hospede redefine o método identificar() de Pessoa.
class Recepcionista extends Funcionario {
    public Recepcionista(String nome) {
        super(nome);
    }
    @Override
    public void atender() {
        System.out.println(nome + " (recepcionista) fez o check-in do hóspede.");
    }
}
class Quarto {
    private int numero;
    private String tipo;
    private double valorDiaria;
    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
    }
    public int getNumero() {
        return numero;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
    @Override
    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - R$" + valorDiaria;
    }
}
enum StatusReserva {
    PENDENTE, CONFIRMADA, CANCELADA, FINALIZADA
}
enum FormaPagamento {
    DINHEIRO, PIX, CARTAO_CREDITO, CARTAO_DEBITO
}
enum CategoriaHospede {
    NORMAL(0.0),
    VIP(10.0),
    PREMIUM(20.0);
    private final double percentualDesconto;
    CategoriaHospede(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }
    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}
class Reserva {
    private Hospede hospede;
    private StatusReserva status;

    public Reserva(Hospede hospede, StatusReserva status) {
        this.hospede = hospede;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Reserva de " + hospede.getNome() + " - Status: " + status;
    }
}
class ComparadorPorNumero implements Comparator<Quarto> {
    @Override
    public int compare(Quarto q1, Quarto q2) {
        return Integer.compare(q1.getNumero(), q2.getNumero());
    }
}
// Ex.24: compare<0 = q1 antes de q2; ==0 = iguais; >0 = q1 depois de q2.
// Comparator só define a regra; quem ordena de fato é o sort().
class ComparadorPorPreco implements Comparator<Quarto> {
    private boolean decrescente;

    public ComparadorPorPreco() {
        this(false);
    }
    public ComparadorPorPreco(boolean decrescente) {
        this.decrescente = decrescente;
    }
    @Override
    public int compare(Quarto q1, Quarto q2) {
        int resultado = Double.compare(q1.getValorDiaria(), q2.getValorDiaria());
        return decrescente ? -resultado : resultado;
    }
}
public class HotelExercicios {
    public static void main(String[] args) {

        System.out.println("PARTE A - SOBRECARGA E SOBRESCRITA");
        Hospede h1 = new Hospede("Maria Silva", "111.111.111-11");
        Hospede h2 = new Hospede("João Souza"); // usa o construtor sobrecarregado
        System.out.println(h1);
        System.out.println(h2);
        ServicoHotel servico = new CafeDaManha();
        System.out.println("Preço do café da manhã: R$" + servico.calcularPreco());
        Pagamento pagamento = new PagamentoCartao();
        pagamento.processar();
        BuscaQuarto busca = new BuscaQuarto();
        System.out.println(busca.buscarQuarto(101));
        System.out.println(busca.buscarQuarto("Suíte"));
        System.out.println(busca.buscarQuarto(101, true));
        Funcionario func = new Recepcionista("Carlos");
        func.atender();
        func.atender("troca de toalhas");
        System.out.println("\nPARTE B - COLLECTIONS");
        List<String> nomesHospedes = new ArrayList<>();
        nomesHospedes.add("Maria");
        nomesHospedes.add("João");
        nomesHospedes.add("Ana");
        nomesHospedes.add("Pedro");
        nomesHospedes.add("Lucas");
        System.out.println("Lista de hóspedes:");
        for (String nome : nomesHospedes) {
            System.out.println("- " + nome);
        }
        List<Quarto> quartos = new ArrayList<>();
        quartos.add(new Quarto(101, "Standard", 150.0));
        quartos.add(new Quarto(102, "Standard", 150.0));
        quartos.add(new Quarto(201, "Luxo", 300.0));
        quartos.add(new Quarto(202, "Luxo", 320.0));
        quartos.add(new Quarto(301, "Suíte", 500.0));
        System.out.println("\nLista de quartos:");
        for (Quarto q : quartos) {
            System.out.println(q);
        }
        List<Quarto> listaTemp = new ArrayList<>();
        listaTemp.add(new Quarto(1, "Standard", 100.0));
        listaTemp.add(new Quarto(2, "Standard", 110.0));
        listaTemp.add(new Quarto(3, "Luxo", 250.0));
        System.out.println("\nLista antes de remover: " + listaTemp);
        listaTemp.remove(1);
        System.out.println("Lista depois de remover: " + listaTemp);
        double soma = 0;
        for (Quarto q : quartos) {
            soma += q.getValorDiaria();
        }
        double media = soma / quartos.size();
        System.out.println("\nMédia das diárias: R$" + media);
        Set<String> servicos = new HashSet<>();
        servicos.add("Wi-Fi");
        servicos.add("Piscina");
        servicos.add("Academia");
        servicos.add("Wi-Fi");
        System.out.println("\nServiços (Set): " + servicos);
        System.out.println("Explicação: o Set não permite elementos duplicados, "
                + "então 'Wi-Fi' foi adicionado apenas uma vez.");
        Map<Integer, String> quartoHospede = new HashMap<>();
        quartoHospede.put(101, "Maria");
        quartoHospede.put(102, "João");
        quartoHospede.put(201, "Ana");
        System.out.println("\nMapa quarto -> hóspede: " + quartoHospede);
        Map<Integer, Quarto> mapaQuartos = new HashMap<>();
        for (Quarto q : quartos) {
            mapaQuartos.put(q.getNumero(), q);
        }
        int numeroBuscado = 202;
        Quarto encontrado = mapaQuartos.get(numeroBuscado);
        System.out.println("\nBusca pelo quarto " + numeroBuscado + ": " + encontrado);
        System.out.println("\nPARTE C - GENERICS");
        System.out.println("Ex.16: List sem tipo aceita qualquer objeto; List<Quarto> só aceita Quarto (Generics = mais segurança).");
        System.out.println("\nPARTE D - ENUM");
        Reserva reserva = new Reserva(h1, StatusReserva.CONFIRMADA);
        System.out.println(reserva);
        FormaPagamento forma = FormaPagamento.PIX;
        System.out.println("Forma de pagamento escolhida: " + forma);
        for (CategoriaHospede categoria : CategoriaHospede.values()) {
            System.out.println("Categoria " + categoria + " -> desconto de "
                    + categoria.getPercentualDesconto() + "%");
        }
        System.out.println("\nPARTE E - COMPARATOR");
        List<Quarto> ordenadoPorNumero = new ArrayList<>(quartos);
        Collections.sort(ordenadoPorNumero, new ComparadorPorNumero());
        System.out.println("Ordenado por número: " + ordenadoPorNumero);
        List<Quarto> ordenadoPorPrecoCrescente = new ArrayList<>(quartos);
        Collections.sort(ordenadoPorPrecoCrescente, new ComparadorPorPreco());
        System.out.println("Ordenado por preço (crescente): " + ordenadoPorPrecoCrescente);
        List<Quarto> ordenadoPorPrecoDecrescente = new ArrayList<>(quartos);
        Collections.sort(ordenadoPorPrecoDecrescente, new ComparadorPorPreco(true));
        System.out.println("Ordenado por preço (decrescente): " + ordenadoPorPrecoDecrescente);
        System.out.println("\nPARTE F - FUNÇÕES LAMBDA");
        List<Quarto> ordenadoComLambda = new ArrayList<>(quartos);
        ordenadoComLambda.sort((q1, q2) -> Integer.compare(q1.getNumero(), q2.getNumero()));
        System.out.println("Ordenado por número (lambda): " + ordenadoComLambda);
    }
}

//Observação não estava achando onde enviar por isso o atraso tava procurando no final da atividade 8 onde geralmente ficava o link de entrega.