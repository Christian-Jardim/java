import java.util.Scanner;
import java.util.LinkedList;

enum Descricao {
	ARROZ, FEIJAO, FARINHA, LEITE;
}

enum TipoPagamento {
	DINHEIRO, CHEQUE, CARTAO;
}

class Produto {
	public Descricao descricao;
	public double preco;
	public int quantidadeEstoque;

	public Produto(int t, int v, int q) {
		switch(t) {
		case 1:
			descricao = Descricao.ARROZ;
			break;
		case 2:
			descricao = Descricao.FEIJAO;
			break;
		case 3:
			descricao = Descricao.FARINHA;
			break;
		case 4:
			descricao = Descricao.LEITE;
			break;
		}

		preco = v;
		quantidadeEstoque = q;
	}
}

class Item {
	public int quantidade;
	public Descricao descricao;

	public Item(int q, int t) {
		quantidade = q;

		switch(t) {
		case 1:
			descricao = Descricao.ARROZ;
			break;
		case 2:
			descricao = Descricao.FEIJAO;
			break;
		case 3:
			descricao = Descricao.FARINHA;
			break;
		case 4:
			descricao = Descricao.LEITE;
			break;
		}
	}
}

class Pedido {
	private TipoPagamento pagamento;
	private List<Item> itens;

	public Pedido(int t) {

		switch(t) {
		case 1:
			pagamento = TipoPagamento.DINHEIRO;
			break;
		case 2:
			pagamento = TipoPagamento.CARTAO;
			break;
		case 3:
			pagamento = TipoPagamento.CHEQUE;
			break;
		}
	}
}
class Cliente {
	private String nome;
	private String CPF;

	public Cliente(String n, String cpf) {
		nome = n;
		CPF = cpf;
	}

	public String seApresentar() {
		return "\n Cliente -> Nome: " + nome + "\n\t    CPF: " + CPF;
	}
}

public class Main {
	public static void main(String[] args) {
		int op,num,i;
		i = 0;
		Cliente c;
		Produto p;
		Item q;
		Scanner input = new Scanner(System.in);
		LinkedList<Produto> estoque = new LinkedList<Produto>();
		LinkedList<Item> pedido = new LinkedList<Item>();

		do {
			op = menu(input);
			switch(op) {
			case 1:
				c = recebeCliente(input);
				System.out.println(c.seApresentar());

				break;
			case 2:
				System.out.print(" Informe o tipo de pagamento: ");
				num = input.nextInt();
				Pedido pedi = new Pedido(num);
			case 3:
				p = recebeProduto(input);
				estoque.add(p);
			}
		} while (op != 0);

		for (Produto produto : estoque) {
			System.out.println(produto.descricao);
			System.out.println(produto.preco);
			System.out.println(produto.quantidadeEstoque);
		}
	}

	public static int menu(Scanner input) {
		int op;

		do {
			System.out.println("\n 1) Novo pedido\n 2) Realizar pagamento\n 3) Cadastrar um produto\n 0) Sair da aplicacao");
			System.out.print(" Escolha uma das opcoes: ");
			op = input.nextInt();
		} while(op<0 || op>4);

		input.nextLine();
		return op;
	}

	public static Cliente recebeCliente(Scanner input) {
		System.out.print("\n Cliente:\n Digite o nome do Cliente: ");
		String nome = input.nextLine();
		System.out.print(" Digite o CPF do cliente: ");
		String cpf = input.nextLine();
		return (new Cliente(nome, cpf));
	}

	public static Produto recebeProduto(Scanner input) {
		System.out.print(" Produto:\n Digite o valor do produto: ");
		int valor = input.nextInt();
		System.out.print("\n Digite o numero do produto (1-arroz 2-feijao 3-farinha 4-leite): ");
		int tipo = input.nextInt();
		System.out.print(" Digite a quantidade do produto: ");
		int quant = input.nextInt();
		return (new Produto(tipo, valor, quant));
	}

	public static Produto informaProduto(Scanner inpunt) {
	    int i,num;
	    Item item;
	    i = num = 0;
		System.out.print(" Informe a quantidade de tipos de itens do pedido: ");
		num = input.nextInt();

		while(i<num) {
			System.out.print(" Digite o numero do produto (1-arroz 2-feijao 3-farinha 4-leite): ");
			int tipo = input.nextInt();
			System.out.print(" Digite a quantidade dele: ");
			int quant = input.nextInt();
			item = new Item(quant, tipo);
			pedido.add(item);
			i++;
		}

		for (Item item : pedido) {
			System.out.println(item.descricao);
			System.out.println(item.quantidade);
		}
	}
}
