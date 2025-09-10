import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op,num;

		Progression atual = new Progression();

		do {
			op = menu(input);
			switch(op) {
			case 1:
				atual = progressaoArith(input);
				atual.nextValue();
				atual.printProgression();
				break;
			case 2:
				atual = progressaoGeom(input);
				atual.nextValue();
				atual.printProgression();
				break;
			/*case 3:
				System.out.print(" Digite o primeiro valor: ");
				num = input.nextInt();
				System.out.print(" Digite o primeiro valor: ");
				num = input.nextInt();
				GeomProgression pg = new GeomProgression(num);
				atual = pg;
				atual.nextValue();
				atual.printProgression();
				break;*/
			}
		} while (op != 0);
	}

	public static int menu(Scanner input) {
		int op;

		do {
			System.out.println("\n 1) Progressao aritmetica\n 2) Progressao geometrica\n 3) Progressao fibonacci\n 0) Sair da aplicacao");
			System.out.print(" Escolha uma das opcoes: ");
			op = input.nextInt();
		} while(op<0 || op>3);

		input.nextLine();
		return op;
	}

	public static ArithProgression progressaoArith(Scanner input) {
		System.out.print(" Digite o valor de incremento: ");
		int v = input.nextInt();
		return (new ArithProgression(v));
	}
	
	public static GeomProgression progressaoGeom(Scanner input) {
		System.out.print(" Digite o valor da base: ");
		int v = input.nextInt();
		return (new GeomProgression(v));
	}
}
