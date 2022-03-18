import java.util.ArrayList;

public class Piso {

	private int id;
	private Direccion direccion;
	private double area, precio,precio_venta,precio_alquilar;
	private boolean vender, alquilar;

	public Piso() {
	this.id = 1;
	this.direccion = new Direccion();
	this.area = 0.0;
	this.precio = 0.0;
	this.precio_venta = 0.0;
	this.precio_alquilar = 0.0;
	this.vender = true;
	this.alquilar = false;
	
	
	}

	public Piso(int id, Direccion direccion, double area, double precio, double precio_venta, boolean vender, boolean alquilar) {
		this.id = id;
		this.direccion = direccion;
		this.area = area;
		this.precio = precio;
		this.precio_venta = precio_venta;
		this.precio_alquilar = precio_alquilar;
		this.vender = vender;
		this.alquilar = alquilar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isVender() {
		return vender;
	}

	public void setVender(boolean vender) {
		this.vender = vender;
	}

	public boolean isAlquilar() {
		return alquilar;
	}

	public void setAlquilar(boolean alquilar) {
		this.alquilar = alquilar;
	}
	
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
    public double getPrecio_alquilar() {
		return precio_alquilar;
	}

	public void setPrecio_alquilar(double precio_alquilar) {
		this.precio_alquilar = precio_alquilar;
	}

	public String toString() {
	
    String toret ="ID: "+ getId() + "\nDirección; " + getDireccion() + "\nÁrea: "+ getArea()+ " m²";
    
    if (vender) {
		toret = "\nPrecio a la venta: "+ getPrecio_venta() + "€";
	}
 if (alquilar) {
	toret = "\nPrecio para alquilar: "+ getPrecio_alquilar() + "€/mes";
}
 return toret;  	
    }
}
	
	
	
