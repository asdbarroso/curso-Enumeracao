package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Clientes;
import entidades.ItemOrdem;
import entidades.Ordem;
import entidades.Produto;
import entidades.enumeradores.StatusOrdem;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println();

		System.out.println("Informe os dados do Cliente: ");
		System.out.print("Nome: ");
		String nome = in.nextLine();
		System.out.print("E-mail: ");
		String email = in.next();
		in.nextLine();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		Date dataNascimento = sdf.parse(in.nextLine());
		
		Clientes cliente = new Clientes(nome, email, dataNascimento);

		System.out.println("Informe os Dados da Ordem: ");
		System.out.print("Status: ");
		StatusOrdem statusOrdem = StatusOrdem.valueOf(in.next());
		
		Ordem ordem = new Ordem(new Date(), statusOrdem, cliente);

		System.out.print("Quantos itens terá a ordem? ");
		int n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("----------------------------------");
			System.out.println("Entre com o Item #" + i);
			System.out.print("Informe o nome do Produto: ");
			String nomeProduto = in.next();
			System.out.print("Informe o preço do produto: ");
			double precoProduto = in.nextDouble();

			System.out.print("Quantidade: ");
			int quantProduto = in.nextInt();

			ordem.adicionaItem(new ItemOrdem(quantProduto, precoProduto, new Produto(nomeProduto, precoProduto)));

		}

		System.out.println();
		System.out.println("<<<<<<<<<<>>>>>>>>>>");
		System.out.println("Dados da Ordem");
		System.out.println(ordem);
		/*
		 * System.out.println("Data da Odem: " + sdf2.format(ordem.getDataOrdem()));
		 * System.out.println("Status da Ordem: " + ordem.getStatusOrdem());
		 * System.out.println("Cliente: " + ordem.getCliente().getNome() + ", " +
		 * sdf.format(ordem.getCliente().getDataAniversario()) + ", " +
		 * ordem.getCliente().getEmail()); System.out.println();
		 * System.out.println("Itens da Ordem: ");
		 * 
		 * for (ItemOrdem o : ordem.getItens()) { System.out.println(o); }
		 * 
		 * System.out.printf("Total: R$ %.2f" , ordem.total());
		 */
		in.close();
	}
}