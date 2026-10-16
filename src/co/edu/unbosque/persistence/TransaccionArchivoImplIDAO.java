package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransaccionArchivoImplIDAO implements IDAO<TransaccionArchivoDTO> {
    private String rutaArchivo;

    public TransaccionArchivoImplIDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardar(TransaccionArchivoDTO transaccion) {
        String linea;
        if ("LLEGADA".equalsIgnoreCase(transaccion.getTipoTransaccion())) {
            linea = String.format("%s,%s,%d,%s",
                transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                transaccion.getCantidadTransaccion(), transaccion.getFechaTransaccion().toString());
        } else {
            linea = String.format("%s,%s,%d,%s,%s,%s",
                transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                transaccion.getCantidadTransaccion(), transaccion.getFechaHoraTransaccion().toString(),
                transaccion.getIdCliente(), transaccion.getIdVendedor());
        }
        try {
            FileHandler.agregarLineaArchivo(rutaArchivo, linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(TransaccionArchivoDTO transaccion) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            List<String> resultado = new ArrayList<>();
            boolean actualizado = false;
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes[1].equals(transaccion.getReferenciaMoto())) {
                    if ("LLEGADA".equalsIgnoreCase(transaccion.getTipoTransaccion())) {
                        resultado.add(String.format("%s,%s,%d,%s",
                            transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                            transaccion.getCantidadTransaccion(), transaccion.getFechaTransaccion().toString()));
                    } else {
                        resultado.add(String.format("%s,%s,%d,%s,%s,%s",
                            transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                            transaccion.getCantidadTransaccion(), transaccion.getFechaHoraTransaccion().toString(),
                            transaccion.getIdCliente(), transaccion.getIdVendedor()));
                    }
                    actualizado = true;
                } else {
                    resultado.add(linea);
                }
            }
            if (!actualizado) {
                if ("LLEGADA".equalsIgnoreCase(transaccion.getTipoTransaccion())) {
                    resultado.add(String.format("%s,%s,%d,%s",
                        transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                        transaccion.getCantidadTransaccion(), transaccion.getFechaTransaccion().toString()));
                } else {
                    resultado.add(String.format("%s,%s,%d,%s,%s,%s",
                        transaccion.getTipoTransaccion(), transaccion.getReferenciaMoto(),
                        transaccion.getCantidadTransaccion(), transaccion.getFechaHoraTransaccion().toString(),
                        transaccion.getIdCliente(), transaccion.getIdVendedor()));
                }
            }
            FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TransaccionArchivoDTO leer(TransaccionArchivoDTO transaccion) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes[1].equals(transaccion.getReferenciaMoto())) {
                    if ("LLEGADA".equalsIgnoreCase(partes[0])) {
                        return new TransaccionArchivoDTO(partes[0], partes[1], Integer.parseInt(partes[2]),
                                LocalDate.parse(partes[3]));
                    } else {
                        return new TransaccionArchivoDTO(partes[0], partes[1], Integer.parseInt(partes[2]),
                                LocalDateTime.parse(partes[3]), partes[4], partes[5]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(TransaccionArchivoDTO transaccion) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            List<String> resultado = new ArrayList<>();
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (!partes[1].equals(transaccion.getReferenciaMoto())) {
                    resultado.add(linea);
                }
            }
            FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
