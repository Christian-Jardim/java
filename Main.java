import java.util.Scanner;

enum Descricao {
	ARROZ, FEIJAO, FARINHA, LEITE;
}

enum TipoPagamento {
	DINHEIRO, CHEQUE, CARTAO;
}

class Produto {
	private Descricao descricao;
	private double preco;
	private int quantidadeEstoque;

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
	private int quantidade;
}

class Pedido {
	private TipoPagamento pagamento;
}

class Cliente {
	private String nome;
	private String CPF;

	public Cliente(String n, String cpf) {
		nome = n;
		CPF = cpf;
	}

	public String seApresentar () {
		return "\n Cliente -> Nome: " + nome + "\n\t    CPF: " + CPF;
	}
}

public class Main {
	public static void main(String[] args) {
		int op;
		Cliente c;
		Produto p;
		Item q;
		Scanner input = new Scanner(System.in);
        
		do {
			op = menu(input);
			switch(op) {
			case 1:
				c = recebeCliente(input);
				System.out.println(c.seApresentar());
				break;
			case 3:
			     p = recebeProduto(input);
			}
		} while (op != 0);
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
		System.out.print(" Digite o valor do produto: ");
		int valor = input.nextInt();
		System.out.print("\n Produto:\n Digite o numro do produto (1-arroz 2-feijao 3-farinha 4-leite): ");
		int tipo = input.nextInt();
		System.out.print(" Digite a quantidade do produto: ");
		int quant = input.nextInt();
		return (new Produto(tipo, valor, quant));
	}
}
