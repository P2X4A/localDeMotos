package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class VentaImplIDAO implements IDAO<VentaDTO> {
	private String rutaArchivo;

	public VentaImplIDAO(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void guardar(VentaDTO venta) {
		String linea = String.format("%s,%s,%s,%s,%d,%.2f,%.2f,%.2f", venta.getIdCliente(), venta.getIdVendedor(),
				venta.getReferenciaMoto(), venta.getFechaVenta().toString(), venta.getCantidad(), venta.getValorTotal(),
				venta.getImpuesto(), venta.getValorConImpuesto());
		try {
			FileHandler.agregarLineaArchivo(rutaArchivo, linea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(VentaDTO venta) {
		try {
			List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
			List<String> resultado = new ArrayList<>();
			boolean actualizado = false;
			for (String linea : lineas) {
				String[] partes = linea.split(",");
				if (partes[2].equals(venta.getReferenciaMoto())) {
					resultado.add(
							String.format("%s,%s,%s,%s,%d,%.2f,%.2f,%.2f", venta.getIdCliente(), venta.getIdVendedor(),
									venta.getReferenciaMoto(), venta.getFechaVenta().toString(), venta.getCantidad(),
									venta.getValorTotal(), venta.getImpuesto(), venta.getValorConImpuesto()));
					actualizado = true;
				} else {
					resultado.add(linea);
				}
			}
			if (!actualizado) {
				resultado.add(String.format("%s,%s,%s,%s,%d,%.2f,%.2f,%.2f", venta.getIdCliente(),
						venta.getIdVendedor(), venta.getReferenciaMoto(), venta.getFechaVenta().toString(),
						venta.getCantidad(), venta.getValorTotal(), venta.getImpuesto(), venta.getValorConImpuesto()));
			}
			FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public VentaDTO leer(VentaDTO venta) {
		try {
			List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
			for (String linea : lineas) {
				String[] partes = linea.split(",");
				if (partes[2].equals(venta.getReferenciaMoto())) {
					return new VentaDTO(partes[0], partes[1], partes[2], LocalDateTime.parse(partes[3]),
							Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Double.parseDouble(partes[6]),
							Double.parseDouble(partes[7]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void eliminar(VentaDTO venta) {
		try {
			List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
			List<String> resultado = new ArrayList<>();
			for (String linea : lineas) {
				String[] partes = linea.split(",");
				if (!partes[2].equals(venta.getReferenciaMoto())) {
					resultado.add(linea);
				}
			}
			FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<VentaDTO> leerTodo() {
		List<VentaDTO> ventas = new ArrayList<>();
		try {
			List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
			for (String linea : lineas) {
				String[] partes = linea.split(",");
				ventas.add(new VentaDTO(partes[0], // idCliente
						partes[1], // idVendedor
						partes[2], // referenciaMoto
						LocalDateTime.parse(partes[3]), // fechaVenta
						Integer.parseInt(partes[4]), // cantidad
						Double.parseDouble(partes[5]), // valorTotal
						Double.parseDouble(partes[6]), // impuesto
						Double.parseDouble(partes[7]) // valorConImpuesto
				));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ventas;
	}

}
