package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class VentanaRegistroMoto extends JDialog {

	private JTextField txtModelo;
	private JTextField txtReferencia;
	private JTextField txtCilindraje;
	private JTextField txtValorVenta;
	private JTextField txtStock;
	private JButton btnRegistrar;

	public VentanaRegistroMoto(ActionListener listener) {
		setTitle("Registrar Nueva Moto");
		setModal(true);
		setSize(350, 300);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

		panel.add(new JLabel("Modelo:"));
		txtModelo = new JTextField();
		panel.add(txtModelo);

		panel.add(new JLabel("Referencia (10 caracteres):"));
		txtReferencia = new JTextField();
		panel.add(txtReferencia);

		panel.add(new JLabel("Cilindraje (cc):"));
		txtCilindraje = new JTextField();
		panel.add(txtCilindraje);

		panel.add(new JLabel("Valor Venta (COP):"));
		txtValorVenta = new JTextField();
		panel.add(txtValorVenta);

		panel.add(new JLabel("Cantidad/Stock:"));
		txtStock = new JTextField();
		panel.add(txtStock);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setActionCommand("CMD_REGISTRAR_MOTO_CONFIRMAR");
		btnRegistrar.addActionListener(listener);

		panel.add(new JLabel()); // espacio vacio
		panel.add(btnRegistrar);

		add(panel);
	}

	public String getModelo() {
		return txtModelo.getText().trim();
	}

	public String getReferencia() {
		return txtReferencia.getText().trim();
	}

	public String getCilindraje() {
		return txtCilindraje.getText().trim();
	}

	public String getValorVenta() {
		return txtValorVenta.getText().trim();
	}

	public String getStock() {
		return txtStock.getText().trim();
	}
}
