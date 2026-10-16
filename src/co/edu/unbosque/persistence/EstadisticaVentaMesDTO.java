package co.edu.unbosque.persistence;

public class EstadisticaVentaMesDTO {
	private String modelo;
	private String referencia;
	private int[] cantidadVendidasPorMes;
	private double[] montoVendidoPorMes;

	public EstadisticaVentaMesDTO(String referencia, String modelo, int[] cantidadVendidasPorMes,
			double[] montoVendidoPorMes) {
		this.referencia = referencia;
		this.modelo = modelo;
		this.cantidadVendidasPorMes = cantidadVendidasPorMes;
		this.montoVendidoPorMes = montoVendidoPorMes;
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
