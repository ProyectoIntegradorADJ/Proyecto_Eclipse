package dam.adjcars.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dam.adjcars.control.AdjListener;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int ANCHO = 500;
	public static final int ALTO = 300;

	public static final String BTN_EMPLEADO = "Empleado";
	public static final String BTN_CLIENTE = "Cliente";
	private JButton btnEmpleado;
	private JButton btnCliente;
	private JScrollPane scrollPane;

	public VPrincipal() {
		super("Inicio - ADJ Cars Automotive");
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("ADJ Cars Automotive");
		lblNewLabel.setBounds(33, 32, 453, 100);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 45));

		btnEmpleado = new JButton(BTN_EMPLEADO);
		btnEmpleado.setBounds(165, 135, 141, 23);
		btnEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		btnCliente = new JButton(BTN_CLIENTE);
		btnCliente.setBounds(165, 169, 141, 23);
		btnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 145, 74);
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnEmpleado);
		getContentPane().add(btnCliente);
		getContentPane().add(scrollPane);

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

	public void cargarPanel(JPanel panel) {
		src
		
	}
}
