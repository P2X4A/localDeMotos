package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class VentanaBuscarReferencia extends JDialog {

    private JTextField txtReferencia;
    private JButton btnBuscar;
    private JLabel lblResultado;

    public VentanaBuscarReferencia(ActionListener listener) {
        setTitle("Buscar Motocicleta por Referencia");
        setModal(true);
        setSize(350, 180);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

        txtReferencia = new JTextField();
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand("CMD_BUSCAR_REFERENCIA_CONFIRMAR");
        btnBuscar.addActionListener(listener);
        lblResultado = new JLabel(" ");

        panel.add(new JLabel("Referencia Moto:"));
        panel.add(txtReferencia);
        panel.add(btnBuscar);
        panel.add(lblResultado);

        add(panel);
    }

    public String getReferencia() {
        return txtReferencia.getText().trim();
    }

    // Método para mostrar el resultado de la búsqueda (modelo, cilindraje, valor, stock)
    public void setResultado(String resultado) {
        lblResultado.setText(resultado);
    }
}
