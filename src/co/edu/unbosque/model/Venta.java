package co.edu.unbosque.model;

import java.time.LocalDateTime;

public class Venta {
	private String idCliente;
	private String idVendedor;
	private String referenciaMoto;
	private LocalDateTime fechaVenta;
	private int cantidad;
	private double impuesto;
	private double valorConImpuesto;
	private double valorTotal;

	// Constructor que calcula los campos a partir de datos base y porcentaje de
	// impuesto
	// O para registrar nueva venta en el sistema.
	public Venta(String idCliente, String idVendedor, String referenciaMoto, LocalDateTime fechaVenta, int cantidad,
			double valorUnitario, double impuestoPorcentaje) {
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.referenciaMoto = referenciaMoto;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.valorTotal = cantidad * valorUnitario;
		this.impuesto = valorTotal * impuestoPorcentaje;
		this.valorConImpuesto = valorTotal + impuesto;
	}

	// Constructor para conversión directa desde DTO o archivo, para cargar una
	// venta
	// que ya tiene todos sus valores calculados
	public Venta(String idCliente, String idVendedor, String referenciaMoto, LocalDateTime fechaVenta, int cantidad,
			double impuesto, double valorConImpuesto, double valorTotal) {
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.referenciaMoto = referenciaMoto;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.impuesto = impuesto;
		this.valorConImpuesto = valorConImpuesto;
		this.valorTotal = valorTotal;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public String getReferenciaMoto() {
		return referenciaMoto;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public double getValorConImpuesto() {
		return valorConImpuesto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	@Override
	public String toString() {
		return idCliente + "," + idVendedor + "," + referenciaMoto + "," + fechaVenta.toString() + "," + cantidad + ","
				+ String.format("%.2f", impuesto) + "," + String.format("%.2f", valorConImpuesto) + ","
				+ String.format("%.2f", valorTotal);
	}
}
