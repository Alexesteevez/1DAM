import java.util.Scanner;

public class Men� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Agencia agencia = new Agencia("Fotocasa");
		String op = "";

		while (!op.equals("salir")) {
			System.out.println(
					"Introduzca la opci�n que dese� dentro de nuestra p�gina." + "\n1. Lista de pisos disponibles."
							+ "\n2. A�adir pisos a la lista." + "\n3. Modificar informaci�n del psio."
							+ "\n4. Sacar pisos de la lista." + "\n5. Ver pisos seg�n sus metros cuadrados."
							+ "\n6. Ver pisos seg�n su precio de venta ." + "\n7.Ver pisos seg�n su precio de alquiler"
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
