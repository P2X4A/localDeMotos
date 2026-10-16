package co.edu.unbosque.model;

public class Moto {
	private String modelo;
	private String referencia;
	private int cilindraje;
	private int stock;
	private double valorVenta;

	public Moto(String modelo, String referencia, int cilindraje, int stock, double valorVenta) {
		this.modelo = modelo;
		this.referencia = referencia;
		this.cilindraje = cilindraje;
		this.stock = stock;
		this.valorVenta = valorVenta;
	}

	public String getModelo() {
		return modelo;
	}

	public String getReferencia() {
		return referencia;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public int getStock() {
		return stock;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// toString para mostrar datos formato requerido
	@Override
	public String toString() {
		return modelo + "," + referencia + "," + cilindraje + "," + stock + "," + String.format("%.2f", valorVenta);
	}
}
