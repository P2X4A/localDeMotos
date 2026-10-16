package co.edu.unbosque.persistence;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class InventarioImplIDAO implements IDAO<MotoDTO> {
    private String rutaArchivo;
    
    public InventarioImplIDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardar(MotoDTO moto) {
        String linea = String.format("%s,%s,%d,%d,%.2f",
            moto.getModelo(), moto.getReferencia(), moto.getCilindraje(), moto.getStock(), moto.getValorVenta());
        try {
            FileHandler.agregarLineaArchivo(rutaArchivo, linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(MotoDTO moto) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            List<String> resultado = new ArrayList<>();
            boolean actualizado = false;
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes[1].equals(moto.getReferencia())) {
                    resultado.add(String.format("%s,%s,%d,%d,%.2f",
                        moto.getModelo(), moto.getReferencia(), moto.getCilindraje(), moto.getStock(), moto.getValorVenta()));
                    actualizado = true;
                } else {
                    resultado.add(linea);
                }
            }
            if (!actualizado) {
                resultado.add(String.format("%s,%s,%d,%d,%.2f",
                    moto.getModelo(), moto.getReferencia(), moto.getCilindraje(), moto.getStock(), moto.getValorVenta()));
            }
            FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MotoDTO leer(MotoDTO moto) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes[1].equals(moto.getReferencia())) {
                    return new MotoDTO(partes[0], partes[1], Integer.parseInt(partes[2]),
                        Integer.parseInt(partes[3]), Double.parseDouble(partes[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // No encontrada
    }

    @Override
    public void eliminar(MotoDTO moto) {
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            List<String> resultado = new ArrayList<>();
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (!partes[1].equals(moto.getReferencia())) {
                    resultado.add(linea);
                }
            }
            FileHandler.escribirArchivoPlano(rutaArchivo, resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<MotoDTO> leerTodo() {
        List<MotoDTO> motos = new ArrayList<>();
        try {
            List<String> lineas = FileHandler.leerArchivoPlano(rutaArchivo);
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                motos.add(new MotoDTO(
                    partes[0],                                  // modelo
                    partes[1],                                  // referencia
                    Integer.parseInt(partes[2]),                // cilindraje
                    Integer.parseInt(partes[3]),                // stock
                    Double.parseDouble(partes[4])               // valorVenta
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return motos;
    }



}
