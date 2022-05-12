import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class NotLogger {
	static Scanner scan = new Scanner(System.in);

	private static void crearDirectorio(String ruta, File directorio) throws IOException{
		try {
			if (!directorio.exists()) {
				directorio.mkdir();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void archivoLogeo(String ruta) throws NullPointerException, IOException {

		System.out.println(
				"En la creación del documento, podrás ponerle el nombre del sistema o ponerle uno manualmente. Escoja una opción:"
						+ "\n 1º Nombre del sistema " + new com.sun.security.auth.module.NTSystem().getName()
						+ "\n 2º Introduccir nombre manualmente.");

		try {
			String ans = "";
			File f = null;
			while (!ans.equals("1") && !ans.equals("2")) {
				ans = scan.nextLine();
				switch (ans) {
				case "1":
					f = new File(ruta + "\\" + new com.sun.security.auth.module.NTSystem().getName() + ".log");
					break;

				case "2":
					System.out.println("Introduzca un nombre:");
					String nombre = scan.nextLine();
					f = new File(ruta + "\\" + nombre + ".log");
					break;

				default:
					System.err.println("Error en los datos introducidos. Repítelos correctamente:");
					break;
				}
			}
			if (f.createNewFile())
				System.out.println("Archivo creado");
			else
				System.out.println("Archivo ya existe");

			registroUsuarioLog(f);

		} catch (NullPointerException npe) {
			System.err.println("Archivo no inicializado.");
		} catch (IOException ioe) {
			System.err.println(ioe);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static String getTimeStamp() {
		DateFormat fFecha = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		Calendar calendario = Calendar.getInstance();
		String fecha = fFecha.format(calendario.getTime());
		return fecha;
	}

	public static void registroUsuarioLog(File f) throws IOException{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
			bw.write(getTimeStamp());
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			System.err.println("Error de E/S con " + ioe);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
private static void netStatFile(String ruta) throws IOException, Exception{
	
	File f = new File(ruta + "\\netstat.log");
	Process p = Runtime.getRuntime().exec("netstat.log");
	InputStream i = p.getInputStream();
	InputStreamReader isr = new InputStreamReader(i);
	BufferedReader br = new BufferedReader(isr);
	FileWriter fw = new FileWriter(f, true);
	BufferedWriter bw = new BufferedWriter(fw);
	ArrayList<String> lineas = new ArrayList<String>();
	lineas.add(getTimeStamp());
	while (br.readLine() != null) {
		lineas.add(br.readLine());
	}
int lineasCorrect = (200 - contLineasBufferedReader(f));
if (lineas.size() <= lineasCorrect) {
	for (int j = 0; j < lineas.size(); j++) {
		bw.write(lineas.get(j));
		bw.newLine();
	}
}else {
	for (int j = 0; j < lineasCorrect; j++) {
		bw.write(lineas.get(j));
		bw.newLine();
	}
	File aux = new File(ruta + "\\netsatat" + (getLastNetStat() + 1) + ".log");
		aux.createNewFile();
		FileWriter fw2 = new FileWriter(aux, true);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		for (int j = lineasCorrect; j < lineas.size(); j++) {
			bw2.write(lineas.get(j));
			bw2.newLine();
		}
		bw2.flush();
		bw2.close();
		fw2.close();
}
bw.flush();
bw.close();
isr.close();
br.close();
fw.close();
}
private static int contLineasBufferedReader(File f ) {
	int lineas =0;
	try(BufferedReader br3 = new BufferedReader(new FileReader(f)) ) {
		while (br3.readLine() != null)  
			lineas ++;
	} catch (IOException ioe) {
		// TODO: handle exception
		ioe.printStackTrace();
		registErr(new File("err.log"), ioe.getMessage());
	}
	
	return lineas;
}

private static void registErr(File f, String aux) {
	
	try(BufferedWriter bw4 = new BufferedWriter(new FileWriter(f, true))) {
		bw4.write("Error(" + getTimeStamp() + " - " + aux +").");
		bw4.newLine();
		bw4.flush();
		
	} catch (IOException ioe) {
		// TODO: handle exception
		System.err.println("Error de E/S con " + ioe);
	}catch (Exception e) {
		// TODO: handle exception
		System.err.println(e.getMessage());
	}
}
private static int getLastNetStat() {
	
	File f = new File("net");
	String nombreArchivos[] = f.list();
	int maximo = 1;
	int actual;
	String numeros;
	for (String nombreArchivo : nombreArchivos) {
		numeros = "";
		if (nombreArchivo.toLowerCase().startsWith("netstat")) {
			for (int i = 7; i < nombreArchivo.length() - 4; i++) {
				numeros += nombreArchivo.charAt(i);
			}
			if (numeros.matches("[0-9]")) {
				actual = Integer.parseInt(numeros);
				if (actual > maximo) {
					maximo = actual;
				}
			}
		}
	}
	
	return maximo;
}
	public static void main(String[] args) {
		try {
			crearDirectorio(".", new File(".\\actividad"));
		crearDirectorio(".", new File(".\\net"));
		archivoLogeo("actividad");
		netStatFile("net");
		} catch (NullPointerException npe) {
			// TODO: handle exception
			System.err.println(npe.getMessage());
			registErr(new File("err.log"), "Error de E/S con " + npe);
		}catch (EOFException eofe) {
			// TODO: handle exception
			System.out.println("Fin");
		}catch (IOException ioe) {
			// TODO: handle exception
			System.err.println("Error de E/S con " + ioe);
			registErr(new File("err.log"), "Error de E/S con " + ioe);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			registErr(new File("err.log"), e.getMessage());
		}
		

	}
}
