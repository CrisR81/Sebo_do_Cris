import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Livros> listagemLivros = new ArrayList<>();

        System.out.print("Bem vindo ao Sebo do Cris!");

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Livro / 2 - Listar Livro / 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoLivro;
                    Livros novoLivro = new Livros();
                    //Pessoa novoAutor = new Pessoa();

                    System.out.println("Digite o título do livro: ");
                    novoLivro.titulo = scanner.next();

                    System.out.println("Digite o nome do autor: ");
                    novoLivro.nome = scanner.next();

                    System.out.println("Digite o valor: ");
                    novoLivro.preco = scanner.nextInt();

                    System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataNascimento = date;

                    if (periodo.getYears() >= 18) {
                        System.out.println("A pessoa tem mais de 18 anos");
                    } else {
                        System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");
                        break;
                    }

                    listagemLivros.add(novoLivro);

                    System.out.println("Cadastro realizado com sucesso!");
                    System.out.println("");
                    System.out.println("Obrigado por utilizar nosso sistema. Volte sempre! Sebo do Cris ®");
                    System.out.println("");

                    break;

                case 2:
                    if (listagemLivros.size() > 0) {
                        for (Livros cadaLivro : listagemLivros) {
                            System.out.println();
                            System.out.println("Título do livro: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.nome);
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println("Data de Nascimento: " + cadaLivro.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();

                        }
                        opcaoLivro = scanner.nextInt();

                    } else {
                        System.out.println("Lista vazia");
                    }

                    break;

                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema. Volte sempre! Sebo do Cris ®");
                    break;
                default:

                    System.out.println("Opção inválida, por favor digite uma opção válida!");
                    break;
            }

        } while (opcao != 0);
    }
}











