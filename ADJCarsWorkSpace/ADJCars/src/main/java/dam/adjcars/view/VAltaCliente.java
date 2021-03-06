package dam.adjcars.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dam.adjcars.control.AdjListener;

public class VAltaCliente extends JFrame {
	public static final String MNTM_SALIR_ALTA_CLIENTE = "Salir";
	private JMenuItem mntmSalirAltaNuevoCliente;

	public VAltaCliente() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(VPrincipal.ANCHO + 200, VPrincipal.ALTO + 200);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VPrincipal.ANCHO + 200, VPrincipal.ALTO + 200);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(null);

		JLabel lblAltaNuevoCliente = new JLabel("Alta nuevo cliente");
		lblAltaNuevoCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		lblAltaNuevoCliente.setBounds(268, 55, 377, 75);
		getContentPane().add(lblAltaNuevoCliente);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mntmSalirAltaNuevoCliente = new JMenuItem(MNTM_SALIR_ALTA_CLIENTE);
		menuBar.add(mntmSalirAltaNuevoCliente);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(AdjListener listener) {
		mntmSalirAltaNuevoCliente.addActionListener(listener);

	}

}
