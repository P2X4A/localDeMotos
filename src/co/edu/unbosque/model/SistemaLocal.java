package co.edu.unbosque.model;

import co.edu.unbosque.persistence.InventarioImplIDAO;
import co.edu.unbosque.persistence.VentaImplIDAO;
import co.edu.unbosque.persistence.MotoDTO;
import co.edu.unbosque.persistence.VentaDTO;
import co.edu.unbosque.persistence.DataMapper;
import co.edu.unbosque.persistence.FileHandler;
import co.edu.unbosque.util.Constant;
import co.edu.unbosque.exceptions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaLocal {

    private InventarioImplIDAO inventarioDAO;
    private VentaImplIDAO ventaDAO;

    public SistemaLocal() {
        inventarioDAO = new InventarioImplIDAO(Constant.RUTA_INVENTARIO);
        ventaDAO = new VentaImplIDAO(Constant.RUTA_VENTAS);
    }

    public void registrarMoto(Moto moto) throws CampoInvalidoException {
        validarMoto(moto);
        MotoDTO dto = DataMapper.toMotoDTO(moto);
        inventarioDAO.guardar(dto);
    }

    public void actualizarMoto(Moto moto) throws CampoInvalidoException {
        validarMoto(moto);
        MotoDTO dto = DataMapper.toMotoDTO(moto);
        inventarioDAO.actualizar(dto);
    }

    public Moto buscarMotoPorReferencia(String referencia) throws MotoNoExisteException {
        MotoDTO dto = new MotoDTO(null, referencia, 0, 0, 0);
        MotoDTO motoDTO = inventarioDAO.leer(dto);
        if (motoDTO == null) {
            throw new MotoNoExisteException(referencia);
        }
        return DataMapper.toMotoEntity(motoDTO);
    }

    public void registrarVenta(String idCliente, String idVendedor, String referenciaMoto, int cantidad) throws Exception {
        Moto moto = buscarMotoPorReferencia(referenciaMoto);
        if (moto.getStock() < cantidad) {
            throw new InventarioInsuficienteException(referenciaMoto, cantidad, moto.getStock());
        }
        double impuestoPct = obtenerImpuestoDesdeProperties();
        Venta venta = new Venta(idCliente, idVendedor, referenciaMoto, LocalDateTime.now(), cantidad, moto.getValorVenta(), impuestoPct);
        VentaDTO dto = DataMapper.toVentaDTO(venta);
        ventaDAO.guardar(dto);

        moto.setStock(moto.getStock() - cantidad);
        actualizarMoto(moto);
    }

    private double obtenerImpuestoDesdeProperties() throws IOException {
        Properties properties = FileHandler.cargarProperties(Constant.RUTA_PROPERTIES);
        String imp = properties.getProperty(Constant.IMPUESTO_VENTA);
        return imp == null ? 0.19 : Double.parseDouble(imp);
    }

    private void validarMoto(Moto moto) throws CampoInvalidoException {
        if (moto == null) {
            throw new CampoInvalidoException("Moto vacía");
        }
        if (moto.getReferencia() == null || moto.getReferencia().length() != Constant.LONGITUD_REFERENCIA) {
            throw new CampoInvalidoException("Referencia inválida");
        }
        if (moto.getValorVenta() <= 0) {
            throw new CampoInvalidoException("Valor venta inválido, debe ser mayor a 0");
        }
    }

    public String[][] getTablaReporteAnual() {
        List<MotoDTO> motos = inventarioDAO.leerTodo();
        List<VentaDTO> ventas = ventaDAO.leerTodo();

        Map<String, String> referenciaModelo = new HashMap<>();
        for (MotoDTO mdto : motos) {
            referenciaModelo.put(mdto.getReferencia(), mdto.getModelo());
        }

        Map<String, int[]> ventasPorMes = new HashMap<>();
        for (MotoDTO mdto : motos) {
            ventasPorMes.put(mdto.getReferencia(), new int[12]);
        }
        for (VentaDTO vdto : ventas) {
            String ref = vdto.getReferenciaMoto();
            if (ventasPorMes.containsKey(ref)) {
                int mes = vdto.getFechaVenta().getMonthValue() - 1;
                ventasPorMes.get(ref)[mes] += vdto.getCantidad();
            }
        }

        String[][] datos = new String[motos.size()][13];
        for (int i = 0; i < motos.size(); i++) {
            MotoDTO mdto = motos.get(i);
            datos[i][0] = mdto.getReferencia();
            int[] cantidades = ventasPorMes.get(mdto.getReferencia());
            for (int j = 0; j < cantidades.length; j++) {
                datos[i][j+1] = Integer.toString(cantidades[j]);
            }
        }
        return datos;
    }


    public void procesarArchivoTransacciones(String rutaArchivo) {
    }
    
    public String[][] getVentasPorReferencia(String referencia) {
        List<VentaDTO> ventas = ventaDAO.leerTodo();
        List<String[]> resultado = new ArrayList<>();
        for (VentaDTO v : ventas) {
            if (v.getReferenciaMoto().equals(referencia)) {
                resultado.add(new String[] {
                    v.getReferenciaMoto(), v.getIdCliente(), v.getIdVendedor(),
                    v.getFechaVenta().toString(),
                    String.valueOf(v.getCantidad()),
                    String.valueOf(v.getValorTotal()),
                    String.valueOf(v.getImpuesto()),
                    String.valueOf(v.getValorConImpuesto())
                });
            }
        }
        String[][] datos = new String[resultado.size()][];
        return resultado.toArray(datos);
    }

}
