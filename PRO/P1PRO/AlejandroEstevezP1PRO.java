import java.util.InputMismatchException;
import java.util.Scanner;
public class Project1 {

	public static void main(String[] args) {


Scanner scan = new Scanner(System.in);
boolean salir = false;
int opcion;
while(!salir) {
	System.out.println("1. Opci�n 1.");
	System.out.println("2. Opci�n 2.");
	System.out.println("3. Salir.");
	
	try {
		System.out.println("Introduzca una de las opciones: ");
		opcion = scan.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Has elegido la opci�n 1.");
			int i, suma = 0, x;
			System.out.println("Introduzca un n�mero: ");
			x = scan.nextInt();
			for (i = 1; i < x; i ++) {
				if (x % i == 0) {
					suma = suma + i;
				}
			}
			if(suma == x){
				System.out.println("Perfecto");
			}else {
				System.out.println("No es perfecto");
				
			}
			break;
		case 2:	
			System.out.println("Has elegido la opci�n 2.");
			Scanner scan=new Scanner(System.in);
			
			int num1; int num 2;
				System.out.println("Introduzca el primer n�mero entero: ");
				num1 = scan.nextInt();
				System.out.println("Introduzca el segundo n�mero entero: ");
				nume2 = scan.nextInt();
				if(i < 0) {
					System.out.println("El n�mero tiene que ser mmayor que cero.");
				}else {
					if(num1 > num2) {
						System.out.println("El primer n�mero es mayor que el segundo.");
					}else if(num1 < num2){
						System.out.println("El primer n�mero es menor que el segundo.");
					}else if (num1 == num2){
						System.out.println("El primer n�mero es igual que el segundo.");
					}else if(num1 == 0) {
						System.out.println("El programa ha terminado. ");
						break;
					}
				}
				num = scan.nextInt();
			}
			break;
		case 3:	
			salir = true;
			System.out.println("El progrma ha terminado.");
			break;
		default:
			System.out.println("Solo n�meros entre el uno y el tres.");
		}
	}catch (InputMismatchException e) {
		System.out.println("Debes insertar un n�mero.");
		scan.next();
	}
}

	}
}
