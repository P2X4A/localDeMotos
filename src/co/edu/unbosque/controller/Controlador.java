package co.edu.unbosque.controller;

import co.edu.unbosque.model.SistemaLocal;
import co.edu.unbosque.model.Moto;
import co.edu.unbosque.util.Constant;
import co.edu.unbosque.view.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private SistemaLocal sistema;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaRegistroMoto ventanaRegistroMoto;
    private VentanaRegistroVenta ventanaRegistroVenta;
    private VentanaBuscarReferencia ventanaBuscarReferencia;
    private VentanaProcesarArchivo ventanaProcesarArchivo;
    private VentanaVentaPorReferencia ventanaVentaPorReferencia;
    private VentanaVentasAnuales ventanaVentasAnuales;

    public Controlador() {
        sistema = new SistemaLocal();
        ventanaPrincipal = new VentanaPrincipal(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        switch (comando) {
            case Constant.CMD_REGISTRAR_MOTO:
                ventanaRegistroMoto = new VentanaRegistroMoto(this);
                ventanaRegistroMoto.setVisible(true);
                break;

            case Constant.CMD_REGISTRAR_MOTO_CONFIRMAR:
                try {
                    Moto moto = new Moto(
                        ventanaRegistroMoto.getModelo(),
                        ventanaRegistroMoto.getReferencia(),
                        Integer.parseInt(ventanaRegistroMoto.getCilindraje()),
                        Integer.parseInt(ventanaRegistroMoto.getStock()),
                        Double.parseDouble(ventanaRegistroMoto.getValorVenta())
                    );
                    sistema.registrarMoto(moto);
                    JOptionPane.showMessageDialog(ventanaRegistroMoto, "Moto registrada con éxito.");
                    ventanaRegistroMoto.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ventanaRegistroMoto, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case Constant.CMD_REGISTRAR_VENTA:
                ventanaRegistroVenta = new VentanaRegistroVenta(this);
                ventanaRegistroVenta.setVisible(true);
                break;

            case Constant.CMD_REGISTRAR_VENTA_CONFIRMAR:
                try {
                    sistema.registrarVenta(
                        ventanaRegistroVenta.getIdCliente(),
                        ventanaRegistroVenta.getIdVendedor(),
                        ventanaRegistroVenta.getReferenciaMoto(),
                        Integer.parseInt(ventanaRegistroVenta.getCantidad())
                    );
                    JOptionPane.showMessageDialog(ventanaRegistroVenta, "Venta registrada con éxito.");
                    ventanaRegistroVenta.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ventanaRegistroVenta, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case Constant.CMD_BUSCAR_REFERENCIA:
                ventanaBuscarReferencia = new VentanaBuscarReferencia(this);
                ventanaBuscarReferencia.setVisible(true);
                break;

            case Constant.CMD_BUSCAR_REFERENCIA_CONFIRMAR:
                try {
                    Moto moto = sistema.buscarMotoPorReferencia(ventanaBuscarReferencia.getReferencia());
                    String resultado = "Modelo: " + moto.getModelo() + ", Cilindraje: " + moto.getCilindraje()
                                     + ", Valor: " + moto.getValorVenta() + ", Stock: " + moto.getStock();
                    ventanaBuscarReferencia.setResultado(resultado);
                } catch (Exception ex) {
                    ventanaBuscarReferencia.setResultado("No se encontró la moto.");
                }
                break;

            case Constant.CMD_PROCESAR_ARCHIVO:
                ventanaProcesarArchivo = new VentanaProcesarArchivo(this);
                ventanaProcesarArchivo.setVisible(true);
                break;

            case Constant.CMD_PROCESAR_ARCHIVO_CONFIRMAR:
                try {
                    sistema.procesarArchivoTransacciones(ventanaProcesarArchivo.getRutaArchivo());
                    JOptionPane.showMessageDialog(ventanaProcesarArchivo, "Archivo procesado correctamente.");
                    ventanaProcesarArchivo.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ventanaProcesarArchivo, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case Constant.CMD_VENTAS_REFERENCIA:
                ventanaVentaPorReferencia = new VentanaVentaPorReferencia(
                    this,
                    new String[0][0],
                    new String[]{"Referencia", "Cliente", "Vendedor", "Fecha", "Cantidad", "Valor Total", "Impuesto", "Valor con Impuesto"}
                );
                ventanaVentaPorReferencia.setVisible(true);
                break;

            case Constant.CMD_BUSCAR_REFERENCIA_VENTA:
                try {
                    String referencia = ventanaVentaPorReferencia.getReferenciaBuscada();
                    String[][] datos = sistema.getVentasPorReferencia(referencia);
                    ventanaVentaPorReferencia.actualizarTabla(datos);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ventanaVentaPorReferencia, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case Constant.CMD_VENTAS_ANUALES:
                String[] columnas = {"Referencia", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                     "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                String[][] datos = sistema.getTablaReporteAnual();
                ventanaVentasAnuales = new VentanaVentasAnuales(datos, columnas);
                ventanaVentasAnuales.setVisible(true);
                break;

            default:
                break;
        }
    }

    public void ejecutar() {
        ventanaPrincipal.setVisible(true);
    }
}
