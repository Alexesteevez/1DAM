import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Direccion {

	private int numero,cp;
	private String tipoCalle,piso, letra, provincia, calle, ciudad;
	private static String[] provincias = { "A Coru�a", "�lava","Albacete","Alicante","Almer�a","Asturias","�vila","Badajoz","Baleares","Barcelona","C�ceres","C�diz","Cantabria","Castell�n","Ciudad Real","C�rdoba","Cuenca","Girona","Granada","Guadalajara","Gipuzkoa","Huelva","Huesca","Ja�n","La Rioja","Las Palmas","Le�n","L�rida","Lugo","Madrid","M�laga","Murcia","Navarra","Ourense","Palencia","Pontevedra","Salamanca","Segovia","Sevilla","Soria","Tarragona","Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
	private static final List<String> listaProvincias = Arrays.asList(provincias);
	private static Scanner scan = new Scanner(System.in);
	
	public Direccion() {
		this.provincia = "Pontevedra";
		this.tipoCalle= "";
		this.piso = "";
		this.letra = "";
		this.calle = "";
		this.ciudad = "";
		this.numero = 0;
		this.cp= 36380;
		
	}
	
	public Direccion(int numero, int cp, String tipoCalle, String piso, String letra, String provincia, String calle,
			String ciudad) {

		this.numero = numero;
		this.cp = cp;
		this.tipoCalle = tipoCalle;
		this.piso = piso;
		this.letra = letra;
		this.provincia = provincia;
		this.calle = calle;
		this.ciudad = ciudad;
	}
	public boolean goodProvincia(String provincia) {
		provincia = provincia.toLowerCase();
		if (listaProvincias.contains(provincia)) {
			return true;
		} else {
			return false;
		}
	}

	public String getTipoCalle() {
		return tipoCalle;
	}

	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		cp = cp;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String toString() {
		String toret = getTipoCalle().toUpperCase() + " " + getCalle().toUpperCase() + " " + getNumero() + " ";
		if (getPiso() != null) {
			toret += getPiso() + "�";
		}
		if (getLetra() != null) {
			toret += getLetra().toUpperCase();
		}
		toret += "\n" + getCp() + " " + getCiudad().toUpperCase() + "\n" + getProvincia().toUpperCase();
		return toret;
	}
	
	}
	

