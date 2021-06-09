package com.dam.maven.GuiaMichelin.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dam.maven.GuiaMichelin.control.GMListener;

public class VPrincipalGuiaM extends JFrame {
	public static final int ANCHO = 610;
	public static final int ALTO = 405;
	public static final String MNTM_CONSULTA = "Consulta de Restaurantes";
	public static final String MNTM_REGISTRO = "Registro de Restaurantes";
	public static final String MNTM_MODIFICACION = "Modificación de Restaurantes";
	public static final String MNTM_SALIR = "Salir";

	private JMenuItem mntmConsulta;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmModificacion;
	private JMenuItem mntmSalir;
	private JScrollPane scrpContenedor;
	
	public VPrincipalGuiaM() {
		super("**GUIA MICHELIN**");
		initComponentes();
	}

	private void initComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();        
		// Se obtienen las dimensiones en pixels de la ventana.    
		Dimension ventana = new Dimension(ANCHO, ALTO);        
		// Una cuenta para situar la ventana en el centro de la pantalla.    
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		crearMenu();
	
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRestaurant = new JMenu("Mantenimiento Restaurantes");
		menuBar.add(mnRestaurant);
		
		mntmConsulta = new JMenuItem(MNTM_CONSULTA);
		mnRestaurant.add(mntmConsulta);
		
		mntmRegistro = new JMenuItem(MNTM_REGISTRO);
		mnRestaurant.add(mntmRegistro);
		
		mntmModificacion = new JMenuItem(MNTM_MODIFICACION);
		mnRestaurant.add(mntmModificacion);
		
		mntmSalir = new JMenuItem(MNTM_SALIR);
		menuBar.add(mntmSalir);
	}

	public void hacerVisible() {
		setVisible(true);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setListener(GMListener listener) {
		mntmConsulta.addActionListener(listener);
		mntmRegistro.addActionListener(listener);
		mntmModificacion.addActionListener(listener);
		mntmSalir.addActionListener(listener);
	}

	public void mostrarMsjConfirm() {
		int opcion = JOptionPane.showConfirmDialog(this, 
				"Seguro que desea abandonar la APP?", 
				"Confirmación de salida", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		
		if (opcion == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}		
	}


	
}//Final Class
