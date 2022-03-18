import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	// Primera parte
	public static void Algoritmo1() {

		int año;
		String mes;
		System.out.println("Introduce el año");
		año = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce el mes");
		mes = scan.nextLine();
		dia(mes, año);
		System.out.println("El mes " + mes + " del año " + año + " tiene " + dia(mes, año) + " días");
	}

	public static boolean bisiesto(int año) {

		if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0))) {

			return true;
		} else {
			return false;
		}
	}

	public static int dia(String mes, int año) {

		mes = mes.toLowerCase();
		mes.trim();
		switch (mes) {
		case "1":
		case "enero":
			return 31;
		case "2":
		case "febrero":
			if (bisiesto(año)) {
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

		System.out.println("Introduce un número 'm' :");
		m = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce un número 'n' :");
		n = Integer.parseInt(scan.nextLine());
		if (m > n) {
			a = factorial(m);
			b = factorial(n);
			c = factorial(m - n);
			d = a / (b * c);
			System.out.println("El resultado de " + m + " sobre " + n + " es :" + d);
		} else {
			System.out.println(
					"Introduce primero el numero más grande y despúes el más pequeño, ambos han de ser enteros positivos.");
		}

	}

	// Tercera parte
	public static void Algoritmo3() {
		int n, m;
		System.out.println("Introduce el número más pequeño.");
		n = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce el número más grande.");
		m = Integer.parseInt(scan.nextLine());
		if (m > n) {
			for (int i = n; i < m; i++) {
				if (perfecto(i) == true) {
					System.out.println(i);
				}
			}
		} else {
			System.out.println(
					"Solo son válidos númeoros enteros positivos, mete primero el número mas pequeño y luego el mayor.");
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
			System.out.println("1.Opción 1");
			System.out.println("2.Opción 2");
			System.out.println("3.Opción 3");
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
				System.out.println("Solo números entre 1 y 4");
			}
		}
	}
}



