package co.edu.unbosque.persistence;

public class MotoDTO {
	private String modelo;
	private String referencia;
	private int cilindraje;
	private int stock;
	private double valorVenta;

	public MotoDTO(String modelo, String referencia, int cilindraje, int stock, double valorVenta) {
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
}
