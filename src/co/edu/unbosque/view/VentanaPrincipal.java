package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

	private JButton btnRegistrarMoto;
	private JButton btnRegistrarVenta;
	private JButton btnBuscarReferencia;
	private JButton btnProcesarArchivo;
	private JButton btnVentasPorReferencia;
	private JButton btnVentasAnuales;

	public VentanaPrincipal(ActionListener listener) {
		setTitle("Sistema de Gestión - Local de Motos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);

		// Panel central
		JPanel panelCentral = new JPanel(new FlowLayout());
		btnRegistrarMoto = new JButton("Registrar Moto");
		btnRegistrarVenta = new JButton("Registrar Venta");
		btnBuscarReferencia = new JButton("Buscar Referencia");
		btnProcesarArchivo = new JButton("Procesar Archivo de Transacciones");
		btnVentasPorReferencia = new JButton("Ventas por Referencia");
		btnVentasAnuales = new JButton("Ventas Anuales");

		// Acción de botones (MVC)
		btnRegistrarMoto.setActionCommand("CMD_REGISTRAR_MOTO");
		btnRegistrarVenta.setActionCommand("CMD_REGISTRAR_VENTA");
		btnBuscarReferencia.setActionCommand("CMD_BUSCAR_REFERENCIA");
		btnProcesarArchivo.setActionCommand("CMD_PROCESAR_ARCHIVO");
		btnVentasPorReferencia.setActionCommand("CMD_VENTAS_REFERENCIA");
		btnVentasAnuales.setActionCommand("CMD_VENTAS_ANUALES");

		btnRegistrarMoto.addActionListener(listener);
		btnRegistrarVenta.addActionListener(listener);
		btnBuscarReferencia.addActionListener(listener);
		btnProcesarArchivo.addActionListener(listener);
		btnVentasPorReferencia.addActionListener(listener);
		btnVentasAnuales.addActionListener(listener);

		panelCentral.add(btnRegistrarMoto);
		panelCentral.add(btnRegistrarVenta);
		panelCentral.add(btnBuscarReferencia);
		panelCentral.add(btnProcesarArchivo);
		panelCentral.add(btnVentasPorReferencia);
		panelCentral.add(btnVentasAnuales);

		// barra de menú para opción de salir
		JMenuBar barraMenu = new JMenuBar();
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(e -> System.exit(0));
		menuArchivo.add(itemSalir);
		barraMenu.add(menuArchivo);
		setJMenuBar(barraMenu);

		// Mensaje informativo arriba
		JLabel lblTitulo = new JLabel("Bienvenido al Sistema del Local de Motos");
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);

		// Layout principal
		setLayout(new BorderLayout());
		add(lblTitulo, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
	}
}
