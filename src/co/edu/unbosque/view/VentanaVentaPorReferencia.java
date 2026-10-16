package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class VentanaVentaPorReferencia extends JDialog {

    private JTextField txtReferencia;
    private JButton btnBuscar;
    private JTable tablaVentasReferencia;
    private DefaultTableModel tableModel;
    private String[] columnas;

    public VentanaVentaPorReferencia(ActionListener listener, String[][] datos, String[] columnas) {
        setTitle("Reporte de Ventas por Referencia");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setModal(true);
        this.columnas = columnas;

        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Referencia Moto:"));
        txtReferencia = new JTextField(10);
        panelSuperior.add(txtReferencia);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("CMD_BUSCAR_REFERENCIA_VENTA");
        btnBuscar.addActionListener(listener);
        panelSuperior.add(btnBuscar);

        tableModel = new DefaultTableModel(datos, columnas);
        tablaVentasReferencia = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tablaVentasReferencia);

        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public String getReferenciaBuscada() {
        return txtReferencia.getText().trim();
    }

    //Metodo que actualiza y recarga todos los datos de la JTable que se está manejando
    //tableModel.setRowCount(0) Borra todas las filas previas de la tabla
    public void actualizarTabla(String[][] datos) {
        tableModel.setRowCount(0); // Limpia filas previas
        //Recorre cada fila de la matriz, cada fila es un String, donde cada String
        //Va a una celda de la tabla
        if (datos != null) {
            for (String[] fila : datos) {
            	//Inserta la fila en la tabla para que se muestre en pantalla
                tableModel.addRow(fila);
            }
        }
    }
}
