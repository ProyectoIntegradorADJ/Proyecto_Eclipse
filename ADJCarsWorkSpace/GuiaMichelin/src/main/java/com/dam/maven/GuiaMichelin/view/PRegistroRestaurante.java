package com.dam.maven.GuiaMichelin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.dam.maven.GuiaMichelin.control.GMListener;
import com.dam.maven.GuiaMichelin.model.Restaurante;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class PRegistroRestaurante extends JPanel {
	public static final String BTN_GUARDAR = "Guardar Datos";
	public static final String BTN_LIMPIAR_DATOS = "Limpiar Datos";
	
	private JTextField textNombre;
	private JComboBox<String> cmbxRegion;
	private JComboBox<String> cmbxCocina;
	private JTextField textCiudad;
	private JTextField textDireccion;
	private JSpinner spnDistincion;
	private JTextField textMinimo;
	private JTextField textMaximo;
	private JTextField textTelefono;
	private JTextField textWeb;
	private JButton btnGuardarDatos;
	private JButton btnLimpiarDatos;
	public PRegistroRestaurante() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setSize(VPrincipalGuiaM.ANCHO - 30, VPrincipalGuiaM.ALTO -70);
		
		JLabel lblRegistrar = new JLabel("Registrar Restaurante");
		lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistrar.setBounds(10, 11, 201, 26);
		add(lblRegistrar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 63, 65, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(115, 60, 184, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblCocina = new JLabel("Cocina:");
		lblCocina.setBounds(330, 63, 49, 14);
		add(lblCocina);
		
		cmbxCocina = new JComboBox<String>();
		cmbxCocina.setModel(new DefaultComboBoxModel<String>(new String[] {"Creativa", "Moderna", "Tradicional", "Regional", "Fusión"}));
		cmbxCocina.setBounds(389, 59, 150, 22);
		add(cmbxCocina);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(40, 99, 49, 20);
		add(lblRegion);
		
		cmbxRegion = new JComboBox<String>();
		cmbxRegion.setModel(new DefaultComboBoxModel<String>(new String[] {"Andalucía", "Aragón", "Asturias", "Islas Baleares", "Cantabria", "Islas Canarias", "Castilla - La Mancha", "Castilla y León", "Cataluña", "Galicia", "Extremadura", "Madrid", "Murcia", "Navarra", "País Vasco", "La Rioja", "Comunidad Valenciana"}));
		cmbxRegion.setBounds(115, 95, 140, 22);
		add(cmbxRegion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(330, 99, 49, 14);
		add(lblCiudad);
		
		textCiudad = new JTextField();
		textCiudad.setBounds(389, 96, 150, 20);
		add(textCiudad);
		textCiudad.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(40, 141, 61, 14);
		add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(115, 138, 424, 20);
		add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblDistincion = new JLabel("Distinción:");
		lblDistincion.setBounds(40, 191, 70, 14);
		add(lblDistincion);
		
		spnDistincion = new JSpinner();
		spnDistincion.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spnDistincion.setBounds(115, 188, 41, 20);
		add(spnDistincion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(250, 169, 49, 14);
		add(lblPrecio);
		
		JLabel lblMinimo = new JLabel("Mínimo:");
		lblMinimo.setBounds(280, 191, 49, 14);
		add(lblMinimo);
		
		textMinimo = new JTextField();
		textMinimo.setBounds(330, 188, 61, 20);
		add(textMinimo);
		textMinimo.setColumns(10);
		
		JLabel lblMaximo = new JLabel("Máximo:");
		lblMaximo.setBounds(409, 191, 59, 14);
		add(lblMaximo);
		
		textMaximo = new JTextField();
		textMaximo.setBounds(478, 188, 61, 20);
		add(textMaximo);
		textMaximo.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(40, 236, 61, 14);
		add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(115, 233, 118, 20);
		add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(280, 236, 41, 14);
		add(lblWeb);
		
		textWeb = new JTextField();
		textWeb.setBounds(330, 233, 209, 20);
		add(textWeb);
		textWeb.setColumns(10);
		
		btnGuardarDatos = new JButton(BTN_GUARDAR);
		btnGuardarDatos.setBounds(409, 282, 130, 23);
		add(btnGuardarDatos);
		
		btnLimpiarDatos = new JButton(BTN_LIMPIAR_DATOS);
		btnLimpiarDatos.setVisible(false);
		btnLimpiarDatos.setBounds(237, 282, 130, 23);
		add(btnLimpiarDatos);

	}
	
	public void setVisibleBtnLimpiar(boolean b) {
		btnLimpiarDatos.setVisible(b);
	}

	public void setListener(GMListener listener) {
		btnGuardarDatos.addActionListener(listener);
		btnLimpiarDatos.addActionListener(listener);		
	}

	public Restaurante getDatos() {
		Restaurante restIn = null;
		
		String nombre = textNombre.getText();

		if (nombre.isEmpty()) {
			mostrarError("Debe introducir el nombre del restaurante");
		
		} else {
			String ciudad = textCiudad.getText().trim();
			if (ciudad.isEmpty()) {
				mostrarError("Debe introducir el nombre de la ciudad");
			
			} else {
				try {
					int distincion = (int) spnDistincion.getValue();
					String cocina = cmbxCocina.getSelectedItem().toString();
					String region = cmbxRegion.getSelectedItem().toString();
					String direccion = textDireccion.getText();
					String telefono = textTelefono.getText();
					String web = textWeb.getText();
					double precioMax = Double.parseDouble(textMaximo.getText());
					double precioMin = Double.parseDouble(textMinimo.getText());
					
					if (precioMin > precioMax) {
						mostrarError("El precio mínimo no puede ser mayor que el máximo");
						
					}else {
						restIn = new Restaurante(nombre, region, ciudad, distincion, direccion, precioMin, precioMax, cocina, telefono, web);
					}
										
				} catch (NumberFormatException e) {
					mostrarError("El precio mínimo y el máximo deben ser numéricos");
			
				}//TODO quiza otro catch

			}
		}
		
		return restIn;
	}

	public void mostrarError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);		
		
	}

	public void mostrarInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Información de operación", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void limpiarComponentes() {
		textNombre.setText("");
		cmbxCocina.setSelectedIndex(0);
		cmbxRegion.setSelectedIndex(0);
		textCiudad.setText("");
		textDireccion.setText("");
		spnDistincion.setValue(1);
		textMaximo.setText("");
		textMinimo.setText("");
		textTelefono.setText("");
		textWeb.setText("");
		
	}
	
}
