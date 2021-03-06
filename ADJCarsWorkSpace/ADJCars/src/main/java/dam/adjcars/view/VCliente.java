package dam.adjcars.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import dam.adjcars.control.AdjListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VCliente extends JFrame {
	public static final String MNTM_CONSULTAR_VEHICULO = "Consultar vehículo";
	public static final String MNTM_PRESUPUESTO = "Ver Presupuestos";
	public static final String MNTM_SALIR_AREA_CLIENTE = "Salir área cliente";
	private JScrollPane scrpContenedorCliente;
	private JMenuItem mntmSalirAreaCliente;
	private JMenuItem mntmConsultarVehiculo;
	private JMenuItem mntmModificarInformacion;

	public VCliente() {

		initComponents();

		crearMenu();
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Consultar");
		menuBar.add(mnNewMenu);

		mntmConsultarVehiculo = new JMenuItem(MNTM_CONSULTAR_VEHICULO);
		mnNewMenu.add(mntmConsultarVehiculo);

		mntmModificarInformacion = new JMenuItem(MNTM_PRESUPUESTO);
		mnNewMenu.add(mntmModificarInformacion);

		mntmSalirAreaCliente = new JMenuItem(MNTM_SALIR_AREA_CLIENTE);
		menuBar.add(mntmSalirAreaCliente);
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(VPrincipal.ANCHO + 200, VPrincipal.ALTO + 200);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(VPrincipal.ANCHO + 200, VPrincipal.ALTO + 200);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

		scrpContenedorCliente = new JScrollPane();
		getContentPane().add(scrpContenedorCliente, BorderLayout.CENTER);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void cargarPanel(JPanel panel) {
		scrpContenedorCliente.setViewportView(panel);
	}

	public void setListener(AdjListener listener) {
		mntmConsultarVehiculo.addActionListener(listener);
		mntmModificarInformacion.addActionListener(listener);
		mntmSalirAreaCliente.addActionListener(listener);

	}

}
