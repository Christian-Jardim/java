import java.util.Scanner;

enum Descricao {
	ARROZ, FEIJAO, FARINHA, LEITE;
}

enum TipoPagamento {
	DINHEIRO, CHEQUE, CARTAO;
}

class Produto {
	private Descricao descricao;
	private int quantidadeEstoque;
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
	
	public Cliente {
	    nome = n;
	    CPF = cpf;
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
		            
		    }

		} while (op != 0);
	}

	public static int menu(Scanner input) {
		int op;
		
		do {
			System.out.println(" 1) Novo pedido\n 2) Realizar pagamento\n 0) Sair da aplicacao");
			System.out.print(" Escolha uma das opcoes: ");
			op = input.nextInt();
		} while(op<0 || op>3);
		
		input.nextLine();
		return op;
	}
}
