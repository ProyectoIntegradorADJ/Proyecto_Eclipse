package dam.adjcars.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dam.adjcars.control.AdjListener;

import java.awt.Font;
import javax.swing.JButton;

public class VPrincipal extends JFrame {
	public static final int ANCHO = 500;
	public static final int ALTO = 300;

	public static final String BTN_EMPLEADO = "Empleado";
	public static final String BTN_CLIENTE = "Cliente";
	private JButton btnEmpleado;
	private JButton btnCliente;

	public VPrincipal() {
		super("Inicio - ADJ Cars Automotive");
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ADJ Cars Automotive");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 45));
		lblNewLabel.setBounds(33, 32, 453, 100);
		getContentPane().add(lblNewLabel);

		btnEmpleado = new JButton(BTN_EMPLEADO);
		btnEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnEmpleado.setBounds(165, 135, 141, 23);
		getContentPane().add(btnEmpleado);

		btnCliente = new JButton(BTN_CLIENTE);
		btnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnCliente.setBounds(165, 169, 141, 23);
		getContentPane().add(btnCliente);

		setSize(ANCHO, ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(AdjListener listener) {
		btnEmpleado.addActionListener(listener);
		btnCliente.addActionListener(listener);
	}
}
