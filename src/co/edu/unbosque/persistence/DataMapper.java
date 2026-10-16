package co.edu.unbosque.persistence;

import co.edu.unbosque.model.Moto;
import co.edu.unbosque.model.Venta;
import co.edu.unbosque.model.TransaccionArchivo;
import co.edu.unbosque.model.EstadisticaVentaMes;

public class DataMapper {

    // Moto <-> MotoDTO
    public static MotoDTO toMotoDTO(Moto moto) {
        return new MotoDTO(
            moto.getModelo(),
            moto.getReferencia(),
            moto.getCilindraje(),
            moto.getStock(),
            moto.getValorVenta()
        );
    }

    public static Moto toMotoEntity(MotoDTO dto) {
        return new Moto(
            dto.getModelo(),
            dto.getReferencia(),
            dto.getCilindraje(),
            dto.getStock(),
            dto.getValorVenta()
        );
    }

    // Venta <-> VentaDTO
    public static VentaDTO toVentaDTO(Venta venta) {
        return new VentaDTO(
            venta.getIdCliente(),
            venta.getIdVendedor(),
            venta.getReferenciaMoto(),
            venta.getFechaVenta(),
            venta.getCantidad(),
            venta.getImpuesto(),
            venta.getValorConImpuesto(),
            venta.getValorTotal()
        );
    }

    public static Venta toVentaEntity(VentaDTO dto) {
        // Usa el constructor estándar con todos los campos ya calculados
        return new Venta(
            dto.getIdCliente(),
            dto.getIdVendedor(),
            dto.getReferenciaMoto(),
            dto.getFechaVenta(),
            dto.getCantidad(),
            dto.getImpuesto(),
            dto.getValorConImpuesto(),
            dto.getValorTotal()
        );
    }

    // TransaccionArchivo <-> TransaccionArchivoDTO
    public static TransaccionArchivoDTO toTransaccionArchivoDTO(TransaccionArchivo transaccion) {
        if ("LLEGADA".equalsIgnoreCase(transaccion.getTipoTransaccion())) {
            return new TransaccionArchivoDTO(
                transaccion.getTipoTransaccion(),
                transaccion.getReferenciaMoto(),
                transaccion.getCantidadTransaccion(),
                transaccion.getFechaTransaccion()
            );
        } else {
            return new TransaccionArchivoDTO(
                transaccion.getTipoTransaccion(),
                transaccion.getReferenciaMoto(),
                transaccion.getCantidadTransaccion(),
                transaccion.getFechaHoraTransaccion(),
                transaccion.getIdCliente(),
                transaccion.getIdVendedor()
            );
        }
    }

    public static TransaccionArchivo toTransaccionArchivoEntity(TransaccionArchivoDTO dto) {
        if ("LLEGADA".equalsIgnoreCase(dto.getTipoTransaccion())) {
            return new TransaccionArchivo(
                dto.getTipoTransaccion(),
                dto.getReferenciaMoto(),
                dto.getCantidadTransaccion(),
                dto.getFechaTransaccion()
            );
        } else {
            return new TransaccionArchivo(
                dto.getTipoTransaccion(),
                dto.getReferenciaMoto(),
                dto.getCantidadTransaccion(),
                dto.getFechaHoraTransaccion(),
                dto.getIdCliente(),
                dto.getIdVendedor()
            );
        }
    }

    // EstadisticaVentaMes <-> EstadisticaVentaMesDTO
    public static EstadisticaVentaMesDTO toEstadisticaVentaMesDTO(EstadisticaVentaMes estadistica) {
        // Clona arreglos para no exponer referencias directas
        int[] cantidades = estadistica.getCantidadVendidasPorMes().clone();
        double[] montos = estadistica.getMontoVendidoPorMes().clone();
        return new EstadisticaVentaMesDTO(
            estadistica.getReferencia(),
            estadistica.getModelo(),
            cantidades,
            montos
        );
    }

    public static EstadisticaVentaMes toEstadisticaVentaMesEntity(EstadisticaVentaMesDTO dto) {
        EstadisticaVentaMes estadistica = new EstadisticaVentaMes(dto.getReferencia(), dto.getModelo());
        int[] cantidades = dto.getCantidadVendidasPorMes();
        double[] montos = dto.getMontoVendidoPorMes();
        for (int i = 0; i < cantidades.length; i++) {
            estadistica.sumarVenta(i, cantidades[i], montos[i]);
        }
        return estadistica;
    }
}
