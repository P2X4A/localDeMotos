package co.edu.unbosque.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransaccionArchivoDTO {
    private String idCliente;
    private String idVendedor;
    private String referenciaMoto;
    private String tipoTransaccion;
    private LocalDate fechaTransaccion;
    private LocalDateTime fechaHoraTransaccion;
    private int cantidadTransaccion;

    // Constructor llegada
    public TransaccionArchivoDTO(String tipoTransaccion, String referenciaMoto, int cantidadTransaccion, LocalDate fechaTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
        this.referenciaMoto = referenciaMoto;
        this.cantidadTransaccion = cantidadTransaccion;
        this.fechaTransaccion = fechaTransaccion;
    }

    // Constructor venta
    public TransaccionArchivoDTO(String tipoTransaccion, String referenciaMoto, int cantidadTransaccion, LocalDateTime fechaHoraTransaccion,
                                 String idCliente, String idVendedor) {
        this.tipoTransaccion = tipoTransaccion;
        this.referenciaMoto = referenciaMoto;
        this.cantidadTransaccion = cantidadTransaccion;
        this.fechaHoraTransaccion = fechaHoraTransaccion;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
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

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public LocalDateTime getFechaHoraTransaccion() {
        return fechaHoraTransaccion;
    }

    public int getCantidadTransaccion() {
        return cantidadTransaccion;
    }
}
