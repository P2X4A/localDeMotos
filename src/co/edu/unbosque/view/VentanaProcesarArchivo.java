package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaProcesarArchivo extends JDialog {

	private JTextField txtRutaArchivo;
	private JButton btnSeleccionar;
	private JButton btnProcesar;

	public VentanaProcesarArchivo(ActionListener listener) {
		setTitle("Procesar Archivo de Transacciones");
		setModal(true);
		setSize(500, 180);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

		JLabel lbl = new JLabel("Seleccione el archivo de transacciones a procesar:");
		panel.add(lbl);

		JPanel subPanel = new JPanel();
		txtRutaArchivo = new JTextField(28);
		txtRutaArchivo.setEditable(false);
		btnSeleccionar = new JButton("Seleccionar archivo...");
		subPanel.add(txtRutaArchivo);
		subPanel.add(btnSeleccionar);
		panel.add(subPanel);

		btnProcesar = new JButton("Procesar");
		btnProcesar.setActionCommand("CMD_PROCESAR_ARCHIVO_CONFIRMAR");
		btnProcesar.addActionListener(listener);
		panel.add(btnProcesar);

		btnSeleccionar.addActionListener(new ActionListener() {
			//Metodo para mostrar el GUI para seleccionar archivo
			@Override
			public void actionPerformed(ActionEvent e) {
			    // Se crea un selector de archivos (de la clase JFileChooser)
			    JFileChooser selector = new JFileChooser();

			    // Se muestra el cuadro de diálogo para abrir un archivo, en la ventana padre especificada
			    // Cuando el usuario selecciona un archivo y aprueba, el método devuelve JFileChooser.APPROVE_OPTION
			    int resultado = selector.showOpenDialog(VentanaProcesarArchivo.this);

			    // Si el usuario selecciona un archivo y presiona "Abrir"
			    if (resultado == JFileChooser.APPROVE_OPTION) {
			        // Se obtiene el archivo seleccionado y su ruta absoluta
			        // Se asigna esa ruta al TextField txtRutaArchivo para mostrarle al usuario
			        txtRutaArchivo.setText(selector.getSelectedFile().getAbsolutePath());
			    }
			}
		}
		);

		add(panel);
	}

	public String getRutaArchivo() {
		return txtRutaArchivo.getText().trim();
	}
}
