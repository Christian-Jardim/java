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
		case 1: descricao = Descricao.ARROZ; break;
		case 2: descricao = Descricao.FEIJAO; break;
		case 3: descricao = Descricao.FARINHA; break;
		case 4: descricao = Descricao.LEITE; break;
		}

		preco = v;
		quantidadeEstoque = q;
	}
	
	public String mostraProduto() {
		return "\n Item -> Tipo: " + descricao + "\n\t Quantidade: " + quantidade;
	}
}

class Item {
	public int quantidade;
	public Descricao descricao;

	public Item(int q, int t) {
		quantidade = q;

		switch(t) {
		case 1: descricao = Descricao.ARROZ; break;
		case 2: descricao = Descricao.FEIJAO; break;
		case 3: descricao = Descricao.FARINHA; break;
		case 4: descricao = Descricao.LEITE; break;
		}
	}

	public String mostraItem() {
		return "\n Item -> Tipo: " + descricao + "\n\t Quantidade: " + quantidade;
	}
}

class Pedido {
	private TipoPagamento pagamento;
	private LinkedList<Item> itens;

	public Pedido() {
		itens = new LinkedList<Item>();
	}

	public Pedido(int t) {
		switch(t) {
		case 1: pagamento = TipoPagamento.DINHEIRO; break;
		case 2: pagamento = TipoPagamento.CARTAO; break;
		case 3: pagamento = TipoPagamento.CHEQUE; break;
		}
	}

	public void preenche(Item item) {
		itens.add(item);
	}

	public void mostraPedido() {
		for (Item item : itens) {
			System.out.println(item.mostraItem());
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
		int op1,op2;
		Cliente cliente;
		Produto produto;
		Item item;
		Scanner input = new Scanner(System.in);
		Pedido pedido = new Pedido();
		LinkedList<Produto> estoque = new LinkedList<Produto>();

		do {
			op1 = menu1(input);
			switch(op1) {
			case 1:
				cliente = recebeCliente(input);
				System.out.println(cliente.seApresentar());
				recebePedido(input,pedido);
				pedido.mostraPedido();
				break;
			case 2:

			case 3:
				produto = recebeProduto(input);
				estoque.add(produto);
			}
		} while (op1 != 0);

		for (Produto p : estoque) {
			System.out.println(p.descricao);
			System.out.println(p.preco);
			System.out.println(p.quantidadeEstoque);
		}
	}

	public static int menu1(Scanner input) {
		int op;

		do {
			System.out.println("\n 1) Novo pedido\n 2) Realizar pagamento\n 3) Cadastrar um produto\n 0) Sair da aplicacao");
			System.out.print(" Escolha uma das opcoes: ");
			op = input.nextInt();
		} while(op<0 || op>4);

		input.nextLine();
		return op;
	}

	public static int menu2(Scanner input) {
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

	public static void recebePedido(Scanner input, Pedido pedido) {
		int i,x;
		i = x = 0;

		/*System.out.print(" Informe o modo de pagamento: ");
		x = input.nextInt();
		Pedido pedido = new Pedido(x);*/

		System.out.print("\n Informe a quantidade de itens do pedido: ");
		x = input.nextInt();

		while(i<x) {
			System.out.print("\n Digite o codigo do item (" + (i + 1) + ") (1-arroz 2-feijao 3-farinha 4-leite): ");
			int tipo = input.nextInt();
			System.out.print(" Digite a quantidade dele: ");
			int quantidade = input.nextInt();
			pedido.preenche(new Item(quantidade, tipo));
			i++;
		}
	}
}
