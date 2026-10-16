package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class VentanaVentasAnuales extends JDialog {

	private JTable tablaVentasAnuales;

	public VentanaVentasAnuales(String[][] datos, String[] columnas) {
		setTitle("Reporte de Ventas Anuales por Modelo y Mes");
		setSize(900, 400);
		setLocationRelativeTo(null);
		setModal(true);

		tablaVentasAnuales = new JTable(datos, columnas);
		JScrollPane scroll = new JScrollPane(tablaVentasAnuales);
		//Scroll pane permite ajustar la tabla a mostrar en caso de que la ventana
		//Sea mas pequeña que la ventana donde se muestra
		JPanel panel = new JPanel(new BorderLayout());
		JLabel lblTitulo = new JLabel("Ventas Anuales - Modelos y Meses");
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTitulo, BorderLayout.NORTH);
		panel.add(scroll, BorderLayout.CENTER);

		add(panel);
	}

	// Permite actualizar la tabla si se vuelve a cargar el reporte
	public void actualizarDatos(String[][] nuevosDatos, String[] columnas) {
		tablaVentasAnuales.setModel(new javax.swing.table.DefaultTableModel(nuevosDatos, columnas));
	}
}
