import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	// Primera parte
	public static void Algoritmo1() {

		int a�o;
		String mes;
		System.out.println("Introduce el a�o");
		a�o = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce el mes");
		mes = scan.nextLine();
		dia(mes, a�o);
		System.out.println("El mes " + mes + " del a�o " + a�o + " tiene " + dia(mes, a�o) + " d�as");
	}

	public static boolean bisiesto(int a�o) {

		if ((a�o % 4 == 0) && ((a�o % 100 != 0) || (a�o % 400 == 0))) {

			return true;
		} else {
			return false;
		}
	}

	public static int dia(String mes, int a�o) {

		mes = mes.toLowerCase();
		mes.trim();
		switch (mes) {
		case "1":
		case "enero":
			return 31;
		case "2":
		case "febrero":
			if (bisiesto(a�o)) {
				return 29;
			} else {
				return 28;
			}
		case "3":
		case "marzo":
			return 31;
		case "4":
		case "abril":
			return 30;
		case "5":
		case "mayo":
			return 31;
		case "6":
		case "junio":
			return 30;
		case "7":
		case "julio":
			return 31;
		case "8":
		case "agosto":
			return 31;
		case "9":
		case "septiembre":
			return 30;
		case "10":
		case "octubre":
			return 31;
		case "11":
		case "noviembre":
			return 30;
		case "12":
		case "diciembre":
			return 31;
		default:
			return 50;
		}
	}

	// Segunda parte
	public static void Algoritmo2() {
		float a, b, c, d;
		int m, n;

		System.out.println("Introduce un n�mero 'm' :");
		m = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce un n�mero 'n' :");
		n = Integer.parseInt(scan.nextLine());
		if (m > n) {
			a = factorial(m);
			b = factorial(n);
			c = factorial(m - n);
			d = a / (b * c);
			System.out.println("El resultado de " + m + " sobre " + n + " es :" + d);
		} else {
			System.out.println(
					"Introduce primero el numero m�s grande y desp�es el m�s peque�o, ambos han de ser enteros positivos.");
		}

	}

	// Tercera parte
	public static void Algoritmo3() {
		int n, m;
		System.out.println("Introduce el n�mero m�s peque�o.");
		n = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce el n�mero m�s grande.");
		m = Integer.parseInt(scan.nextLine());
		if (m > n) {
			for (int i = n; i < m; i++) {
				if (perfecto(i) == true) {
					System.out.println(i);
				}
			}
		} else {
			System.out.println(
					"Solo son v�lidos n�meoros enteros positivos, mete primero el n�mero mas peque�o y luego el mayor.");
		}
	}

	// Funciones a parte
	public static float factorial(int m) {
		float fact = 1;
		int x = 0;
		do {
			x++;
			fact *= x;
		} while (x <= m);
		return fact;
	}

	public static boolean perfecto(int h) {
		boolean perf = false;
		int perfect = 0;
		for (int i = 1; i < h; i++) {
			if (h % i == 0) {
				perfect += i;
			}
		}
		if (perfect == h) {
			perf = true;
		}
		return perf;
	}

	public static void main(String[] args) {

		boolean salir = false;
		String opcion;

		while (!salir) {
			System.out.println("1.Opci�n 1");
			System.out.println("2.Opci�n 2");
			System.out.println("3.Opci�n 3");
			System.out.println("4.Salir");

			System.out.println("Elija una de las opciones anteriores:");
			opcion = scan.nextLine();

			switch (opcion) {
			case "1":
				System.out.println("Has seleccionado la opcion 1");
				Algoritmo1();
				break;
			case "2":
				System.out.println("Has seleccionado la opcion 2");
				Algoritmo2();
				break;
			case "3":
				System.out.println("Has seleccionado la opcion 3");
				Algoritmo3();
				break;
			case "4":
				System.out.println("Has selecionado acabar.");
				salir = true;
				break;
			default:
				System.out.println("Solo n�meros entre 1 y 4");
			}
		}
	}
}



