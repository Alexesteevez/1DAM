import java.util.Scanner;

public class Menú {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Agencia agencia = new Agencia("Fotocasa");
		String op = "";

		while (!op.equals("salir")) {
			System.out.println(
					"Introduzca la opción que deseé dentro de nuestra página." + "\n1. Lista de pisos disponibles."
							+ "\n2. Añadir pisos a la lista." + "\n3. Modificar información del psio."
							+ "\n4. Sacar pisos de la lista." + "\n5. Ver pisos según sus metros cuadrados."
							+ "\n6. Ver pisos según su precio de venta ." + "\n7.Ver pisos según su precio de alquiler"
							+"\nPara salir del programa pon 'salir'.");

			op = scan.nextLine();
			switch (op) {
			case "1":
				agencia.showPisos();
				break;
			case "2":
				agencia.addPiso();
				break;
			case "3":
				agencia.showPisos();

			case "4":
				agencia.showPisos();
				agencia.deletePiso();
				break;
			case"5":
				agencia.showPisos();
				agencia.filtroByArea();
			case "6":
				agencia.showPisos();
				agencia.filtroByPrecioVenta();
			case "7":
				agencia.showPisos();
				agencia.filtroByPrecioAlquiler();
			case "salir":
				System.out.println("El programa se ha cerrado correctamente.");
				break;
			}
		}
		scan.close();
	}

}
