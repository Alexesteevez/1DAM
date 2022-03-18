import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	private Scanner scan = new Scanner(System.in);
	private static int cont = 0;
	private String nombre;
	private ArrayList<Piso> pisos;

	public Agencia(String nombre, ArrayList<Piso> pisos) {

		this.nombre = nombre;
		this.pisos = pisos;

	}

	public Agencia(String nombre) {

		this.nombre = nombre;
		this.pisos = generatePisos();
	}

	public Agencia(Agencia objAgencia) {
		this.nombre = nombre;
		this.pisos = generatePisos();
	}

	private ArrayList<Piso> generatePisos() {
		ArrayList<Piso> toret = new ArrayList<Piso>();
		Direccion direccionAux;
		Piso aux;
		for (int i = 1; i < 6; i++) {
			direccionAux = new Direccion();
			aux = new Piso(i, direccionAux, 100 * i, 0, 10000 * i, false, true);
			toret.add(aux);
		}
		for (int i = 6; i < 11; i++) {
			direccionAux = new Direccion();
			aux = new Piso(i, direccionAux, 10 * i, 100 * i, 0, true, false);
			toret.add(aux);
		}
		cont = 11;
		return toret;
	}

	public void showPisos() {
		for (int i = 0; i < pisos.size(); i++) {
			System.out.println("\n" + pisos.get(i).toString());
		}
	}

public void addPiso() {
	Piso newPiso;
	System.out.println("El id del piso va a ser: "+ cont);
	System.out.println("Introduce la dirección de la nueva propiedad.");
	Direccion newDireccion = new Direccion();
	System.out.println("Introduzca el número.");
	int num = Integer.parseInt(scan.nextLine());
	System.out.println("Introduce el piso.");
	System.out.println("\nEn caso de no terner piso introduce 'no'");
	boolean bucle = true;
	
	do {
		String aux =scan.nextLine();
		aux = aux.toLowerCase();
		if(aux.equals("no")) {
			newDireccion.setPiso(null);
			bucle = true;
		}else {
			if(isNumero(aux)){
				newDireccion.setPiso(aux);
				bucle = true;
			}else {
			System.out.println("Error");
			System.out.println("\nVuelve a introducir el piso.");
			bucle = 0 > 1;
			}
			}
	}while(!bucle);
		System.out.println("Si el piso tiene letra en el número intodúcela.");
		System.out.println("\nEn caso de que no la tenga introduzca 'n'");
		do {
			String aux = scan.nextLine();
			aux = aux.toLowerCase();
			if(aux.equals("n")) {
				newDireccion.setLetra(null);
				bucle = true;
			}else {
				System.out.println("Error");
				System.out.println("\nIntroduzca de nuevo la letra.");
				bucle = 0>1;
			}
		}while(!bucle);
		System.out.println("Introduzca el código postal.");
	int cp = Integer.parseInt(scan.nextLine());
	do {
		if (cp < 01001 || cp>99999) {
		System.out.println("Error");
		System.out.println("\nIntroduzca de nuevo el código postal.");
		cp = Integer.parseInt(scan.nextLine());
		}
	}while(cp<01001 || cp >99999);
	System.out.println("Introduce la ciudad donde se encuentra el piso.");
	String ciudad = scan.nextLine();
	System.out.println("Introduce la provincia.");
	String provincia = scan.nextLine();
	do {
		if(!newDireccion.goodProvincia(provincia));
		System.out.println("Error");
		provincia = scan.nextLine();
	}while(!newDireccion.goodProvincia(provincia));
	System.out.println("Introduce el número de metros cuadrados.");
	double area = Double.parseDouble(scan.nextLine());
	do{
		if (!esPositivo(area)) {
			System.out.println("Error");
			area = Double.parseDouble(scan.nextLine());
		}
		}while(!esPositivo(area));
		boolean vender = false;
		double precio_venta = 0.0;
boolean alquilar = false;
double precio_alquilar = 0.0;

do {
	System.out.println("Introduzca el estado de la vivienda."
			+"\nEn venta 'si' o 'no'");
	String aux = scan.nextLine();
do {
	aux = aux.toLowerCase();
	if (aux.equals("si")) {
		vender= true;
		System.out.println("El precio de venta es:");
		precio_venta = Double.parseDouble(scan.nextLine());
	while(!esPositivo(precio_venta)) {
		System.out.println("Error");
	precio_venta= Double.parseDouble(scan.nextLine());
	}
		}else if(aux.equals("no")){
	vender = false;	
	}else {
System.out.println("Error");
aux = scan.nextLine();}
	}while(!aux.equals("si")&&!aux.equals("no"));
System.out.println("Si la vivienda está en alquiler introduce 'si' si no pon 'no'.");
String aux2 = scan.nextLine();
do {
	 aux2 = aux2.toLowerCase(); 
	if (aux2.equals("si")) {
		alquilar = true;
		System.out.println("El precio de alquiler es: ");
		precio_alquilar = Double.parseDouble(scan.nextLine());
		while(!esPositivo(precio_alquilar)) {
			System.out.println("Error.");
			precio_alquilar = Double.parseDouble(scan.nextLine());
		}
	}else if (aux2.equals("no")){
		alquilar = false;
	}else {
		System.out.println("Error.");
		aux = scan.nextLine();
	}
}while(!aux.equals("si") && !aux.equals("no"));
	if (alquilar==false && vender == false) {
		System.out.println("Error, el piso no puede estar en la pagina sin estar en alquiler y/o a la venta.");
	}
}while (alquilar == false && vender == false);

String tipoCalle = null;
int numero = 0;
String calle = null;
Direccion direccion = new Direccion(numero, cp,  ciudad, tipoCalle,  newDireccion.getPiso(),newDireccion.getLetra(),provincia, calle);
newPiso = new Piso(cont, direccion,precio_alquilar,precio_venta, area, vender, alquilar);
pisos.add(newPiso);
cont++;

System.out.println("Se ha añadido el piso correctamente."+ newPiso.toString());

}



	public void changePiso() {
		System.out.println("Introduce el Id del piso que deseé modificar:");
		int id = Integer.parseInt(scan.nextLine());
		boolean disponible = false;
		int posicion = 0;
		do {
			for (int i = 0; i < pisos.size(); i++) {
				if (pisos.get(i).getId() == id) {

					disponible = true;
					posicion = i;

				}
			}
			if (id == 0) {
				System.out.println("Menú principal.");
				break;
			}
			if (!disponible) {
				System.out.println("Error.");
				id = Integer.parseInt(scan.nextLine());
			}
		} while (!disponible);
		if (id != 0) {
			Piso auxPiso = pisos.get(posicion);
			System.out.println("Los datos del piso son: "+auxPiso.toString());
			String aux = "";
			while(!aux.equals("5")) {
				System.out.println("Introduce lo que queieres modificar del piso:"
						+ "\n1. Direccion."
						+ "\n2. Area."
						+ "\n3. Precio de venta."
						+ "\n4. Precio alquiler."
						+ "\n5. Menú principal.");
				
				aux = scan.nextLine();
				switch(aux) {
				case "1": 
					System.out.println("\nLa nueva direccion es: ");
					Direccion newDireccion = new Direccion();
					String tipoCalle = scan.nextLine();
					System.out.println("\nNombre de la calle: ");
					String calle = scan.nextLine();
					System.out.println("\nNúmero: ");
					int num = Integer.parseInt(scan.nextLine());
					System.out.println("\nSi la propiedad tiene piso indícalo. "
							+ "\nSino introduce 'no':");
					boolean bucle = true;
					do {
						String aux2 = scan.nextLine();
						aux2 = aux2.toLowerCase();
						if (aux2.equals("n")) {
							newDireccion.setPiso(null);
							bucle = true;
						} else {
							if (isNumero(aux2)) {
								newDireccion.setPiso(aux2);
								bucle = true;
							} else {
								System.out
								.println("\nError.");
								bucle = 0 > 1;
							}
						}
					} while (!bucle);
					System.out.println("\nSi propiedad tiene letra indícalo."
							+ " \nSino introduzca una 'n':");
					do {
						String aux3 = scan.nextLine();
						aux3 = aux3.toLowerCase();
						if (aux3.equals("0")) {
							newDireccion.setLetra(null);
							bucle = true;
						} else {
							if (aux3.length() == 1) {
								newDireccion.setLetra(aux3);
								bucle = true;
							} else {
								System.out
								.println("\nError.");
								bucle = 0 > 1;
							}
						}
					} while (!bucle);
					System.out.println("\nIndique el código postal: ");
					int cp = Integer.parseInt(scan.nextLine());
					do {
						if (cp < 1001 || cp > 99999) {
							System.out.println("\nError.");
							cp = Integer.parseInt(scan.nextLine());
						}
					} while (cp < 1001 || cp > 99999);

					System.out.println("\nIntroduce la ciudad:");
					String city = scan.nextLine();
					System.out.println(
							"\nIntroduce la provincia:");
					String provincia = scan.nextLine();
					do {
						if (!newDireccion.goodProvincia(provincia)) {
							System.out.println("\nError");
							provincia = scan.nextLine();
						}
					}  while (!newDireccion.goodProvincia(provincia));

					Direccion direccion = new Direccion();
					auxPiso.setDireccion(direccion);
					System.out.println("\nLos datos se han actualizado y han quedado:\n" + auxPiso.toString());
					break;
					
				case"2": 
					System.out.println("\nIntroduce el nuevo total de metros cuadrados: ");
					double area = Double.parseDouble(scan.nextLine());
					do {
						if (!esPositivo(area)) {
							System.out.println("\nError.");
							area = Double.parseDouble(scan.nextLine());
						}
					} while (!esPositivo(area));
					auxPiso.setArea(area);
					System.out.println("\nLos datos se han actualizado y han quedado:\n" + auxPiso.toString());					
					break;
				case "3":
					if (auxPiso.isVender()) {
						System.out.println("Si el piso ha dejado de estar a la venta pon 'si'."
								+ "\nSino pon 'no'.");
						String estadoV = scan.nextLine();
						estadoV = estadoV.toLowerCase();
						do {
							switch (estadoV) {
							case "no":
								System.out.println("Indica el nuevo precio de venta: ");
								double newPrecioVenta = Double.parseDouble(scan.nextLine());
								while (!esPositivo(newPrecioVenta)) {
									System.out.println("Error.");
									newPrecioVenta = Double.parseDouble(scan.nextLine());
								}
								auxPiso.setPrecio_venta(newPrecioVenta);
								break;
							case "si":
								if (!auxPiso.isAlquilar()) {
									System.out.println("Error.");
								} else {
									auxPiso.setVender(false);
									auxPiso.setPrecio_venta(0);
									System.out.println("No se puede vender.");
								}
								break;
							default:
								System.out.println("Error.");
								estadoV = scan.nextLine();
								break;
							}
						} while (!estadoV.equals("si") && !estadoV.equals("no"));
					} else {
						System.out.println("Si quieres añadir el piso a la venta pon 'si'"
								+ "\nSino pon 'no'.");
						String estadoV = scan.nextLine();
						estadoV = estadoV.toLowerCase();
						do {
							switch (estadoV) {
							case "no":
								System.out.println("Menú principal");
								break;
							case "si":
								auxPiso.setVender(true);
								System.out.println("Nuevo precio de venta: ");
								double newPrecio_venta = Double.parseDouble(scan.nextLine());
								while (!esPositivo(newPrecio_venta)) {
									System.out.println("Error.");
									newPrecio_venta = Double.parseDouble(scan.nextLine());
								}
								auxPiso.setPrecio_venta(newPrecio_venta);
								break;
							default:
								System.out.println("Error.");
								estadoV = scan.nextLine();
								break;
							}
						} while (!estadoV.equals("si") && !estadoV.equals("no"));
					}
					System.out.println("\nLos datos se han actualizado y han quedado:\n" + auxPiso.toString());					
					break;
				case "4":
					if (auxPiso.isAlquilar()) {
						System.out.println("Si el piso ha dejado de estar en alquiler pon 'si'."
								+ "\nSino pon 'no'.");
						String estadoA = scan.nextLine();
						estadoA = estadoA.toLowerCase();
						do {
							switch (estadoA) {
							case "n":
								System.out.println("Precio de alquiler:");
								double newPrecio_alquilar = Double.parseDouble(scan.nextLine());
								while (!esPositivo(newPrecio_alquilar)) {
									System.out.println("Error.");
									newPrecio_alquilar = Double.parseDouble(scan.nextLine());
								}
								auxPiso.setPrecio_alquilar(newPrecio_alquilar);
								break;
							case "si":
								if (!auxPiso.isAlquilar()) {
									System.out.println("Error.");
								} else {
									auxPiso.setAlquilar(false);
									auxPiso.setPrecio_alquilar(0);
									System.out.println("El piso no se puede alquilar");								}
								break;
							default:
								System.out.println("Error.");
								estadoA = scan.nextLine();
								break;
							}
						} while (!estadoA.equals("si") && !estadoA.equals("no"));
					} else {
						System.out.println("Vas a poner en alquiler el piso 'si' o 'no'?");
						String estadoA = scan.nextLine();
						estadoA = estadoA.toLowerCase();
						do {
							switch (estadoA) {
							case "no":
								System.out.println("Menú principal");
								break;
							case "si":
								auxPiso.setAlquilar(true);
								System.out.println("Nuevo precio de alquiler: ");
								double newPrecio_alquilar = Double.parseDouble(scan.nextLine());
								while (!esPositivo(newPrecio_alquilar)) {
									System.out.println("Errorr");
									newPrecio_alquilar = Double.parseDouble(scan.nextLine());
								}
								auxPiso.setPrecio_alquilar(newPrecio_alquilar);
								break;
							default:
								System.out.println("Error.");
								estadoA = scan.nextLine();
								break;
							}
						} while (!estadoA.equals("si") && !estadoA.equals("no"));
					}
					System.out.println("\nLos datos se han actualizado y han quedado:\n" + auxPiso.toString());					
					break;
				case "5":
					break;
				default:
					System.out.print("Error");
					break;
				}
			}
		}
	}
public void deletePiso() {
	System.out.println("Introduce el Id del piso que deseé eliminar:");
	int id = Integer.parseInt(scan.nextLine());
	boolean disponible = false;
	int posicion = 0;
	do {
		for (int i = 0; i < pisos.size(); i++) {
			if (pisos.get(i).getId() == id) {

				disponible = true;
				posicion = i;

			}
		}
		if (id == 0) {
			System.out.println("Menú principal.");
			break;
		}
		if (!disponible) {
			System.out.println("Error.");
			id = Integer.parseInt(scan.nextLine());
		}
	} while (!disponible);
	if (id != 0) {
		Piso auxPiso = pisos.get(posicion);
		System.out.println("Los datos del piso son: "+auxPiso.toString()+ " \ndesea borrarlo?");
		String aux = scan.nextLine();
		aux = aux.toLowerCase();
		switch(aux) {
		case "no":
			System.out.println("Menu principal.");
			break;
		case "si":
			pisos.remove(posicion);
			System.out.println("Proceso realizado correctamente.");
			break;
			default: 
				break;
			}
	}	
}

public void filtroByArea() {
	System.out.println("Mínimo de metros cuadrados:");
	double min = Double.parseDouble(scan.nextLine()); 
	System.out.println("Máximo de metros cuadrados:");
	double max = Double.parseDouble(scan.nextLine());
	
	for (int i = 0; i < pisos.size(); i++) {
		if(pisos.get(i).getArea() >= min && pisos.get(i).getArea()<= max) {
			System.out.println("\n" + pisos.get(i).toString());
		}
	}
}

public void filtroByPrecioVenta(){
	System.out.println("Precio mínimo:");
	double min = Double.parseDouble(scan.nextLine()); 
	System.out.println("Precio máximo:");
	double max = Double.parseDouble(scan.nextLine());
	
	for (int i = 0; i < pisos.size(); i++) {
		if(pisos.get(i).getPrecio_venta() >= min && pisos.get(i).getPrecio_venta()<= max) {
			System.out.println("\n" + pisos.get(i).toString());
		}
	}
}

public void filtroByPrecioAlquiler(){
	System.out.println("Precio mínimo:");
	double min = Double.parseDouble(scan.nextLine()); 
	System.out.println("Precio máximo:");
	double max = Double.parseDouble(scan.nextLine());
	
	for (int i = 0; i < pisos.size(); i++) {
		if(pisos.get(i).getPrecio_alquilar() >= min && pisos.get(i).getPrecio_alquilar()<= max) {
			System.out.println("\n" + pisos.get(i).toString());
		}
	}
}
	private boolean esPositivo(double num) {
		
		if(num<0) {
			return 0>1;
		}else
		return true;
	}

	private boolean isNumero(String str) {
		boolean isNumerico = true;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				isNumerico = false;
				break;
			}
		}
		// TODO Auto-generated method stub
		return isNumerico;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<Piso> pisos) {
		pisos = pisos;
	}

}
