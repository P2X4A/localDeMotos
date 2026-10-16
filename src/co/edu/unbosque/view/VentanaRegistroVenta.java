package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class VentanaRegistroVenta extends JDialog {

	private JTextField txtIdCliente;
	private JTextField txtIdVendedor;
	private JTextField txtReferenciaMoto;
	private JTextField txtCantidad;
	private JButton btnRegistrarVenta;

	public VentanaRegistroVenta(ActionListener listener) {
		setTitle("Registrar Venta de Moto");
		setModal(true);
		setSize(350, 230);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

		panel.add(new JLabel("ID Cliente:"));
		txtIdCliente = new JTextField();
		panel.add(txtIdCliente);

		panel.add(new JLabel("ID Vendedor:"));
		txtIdVendedor = new JTextField();
		panel.add(txtIdVendedor);

		panel.add(new JLabel("Referencia Moto:"));
		txtReferenciaMoto = new JTextField();
		panel.add(txtReferenciaMoto);

		panel.add(new JLabel("Cantidad:"));
		txtCantidad = new JTextField();
		panel.add(txtCantidad);

		btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.setActionCommand("CMD_REGISTRAR_VENTA_CONFIRMAR");
		btnRegistrarVenta.addActionListener(listener);

		panel.add(new JLabel()); // Vaciar espacio
		panel.add(btnRegistrarVenta);

		add(panel);
	}

	public String getIdCliente() {
		return txtIdCliente.getText().trim();
	}

	public String getIdVendedor() {
		return txtIdVendedor.getText().trim();
	}

	public String getReferenciaMoto() {
		return txtReferenciaMoto.getText().trim();
	}

	public String getCantidad() {
		return txtCantidad.getText().trim();
	}
}
