package co.edu.unbosque.model;

public class EstadisticaVentaMes {
	private String modelo;
	private String referencia;
	private int[] cantidadVendidasPorMes;
	private double[] montoVendidoPorMes;

	public EstadisticaVentaMes(String referencia, String modelo) {
		this.referencia = referencia;
		this.modelo = modelo;
		this.cantidadVendidasPorMes = new int[12]; // 12 meses
		this.montoVendidoPorMes = new double[12];
	}

	public void sumarVenta(int mes, int cantidad, double monto) {
		cantidadVendidasPorMes[mes] += cantidad;
		montoVendidoPorMes[mes] += monto;
	}

	public String getModelo() {
		return modelo;
	}

	public String getReferencia() {
		return referencia;
	}

	public int[] getCantidadVendidasPorMes() {
		return cantidadVendidasPorMes;
	}

	public double[] getMontoVendidoPorMes() {
		return montoVendidoPorMes;
	}
}
