package com.dam.maven.GuiaMichelin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import com.dam.maven.GuiaMichelin.control.GMListener;
import com.dam.maven.GuiaMichelin.model.Restaurante;

public class PModificarRestaurante extends JPanel {
	public static final String BTN_GUARDAR_DAT = "Guardar";
	public static final String BTN_CANCELAR = "Cancelar";
	public static final String BTN_BUSCAR_DAT = "Buscar";

	
	private JTextField textNombre;
	private JTextField textCiudad;
	private JTextField textDireccion;
	private JTextField textMinimo;
	private JTextField textMaximo;
	private JTextField textTelefono;
	private JTextField textWeb;
	private JComboBox<String> cmbxCocina;
	private JComboBox<String> cmbxRegion;
	private JSpinner spnDistincion;
	private JButton btnGuardarDat;
	private JButton btnBuscar;
	private JButton btnCancelar;
	public PModificarRestaurante() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setSize(VPrincipalGuiaM.ANCHO - 30, VPrincipalGuiaM.ALTO -70);
		
		JLabel lblModificar = new JLabel("Modificar Restaurante");
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModificar.setBounds(10, 11, 201, 26);
		add(lblModificar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 63, 65, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(115, 60, 184, 20);
		add(textNombre);
		
		JLabel lblCocina = new JLabel("Cocina:");
		lblCocina.setBounds(330, 102, 49, 14);
		add(lblCocina);
		
		cmbxCocina = new JComboBox<String>();
		cmbxCocina.setEnabled(false);
		cmbxCocina.setModel(new DefaultComboBoxModel<String>(new String[] {"Creativa", "Moderna", "Tradicional", "Regional", "Fusión"}));
		cmbxCocina.setBounds(389, 98, 150, 22);
		add(cmbxCocina);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(40, 99, 49, 20);
		add(lblRegion);
		
		cmbxRegion = new JComboBox<String>();
		cmbxRegion.setEnabled(false);
		cmbxRegion.setModel(new DefaultComboBoxModel<String>(new String[] {"Andalucía", "Aragón", "Asturias", "Islas Baleares", "Cantabria", "Islas Canarias", "Castilla - La Mancha", "Castilla y León", "Cataluña", "Galicia", "Extremadura", "Madrid", "Murcia", "Navarra", "País Vasco", "La Rioja", "Comunidad Valenciana"}));
		cmbxRegion.setBounds(115, 95, 140, 22);
		add(cmbxRegion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(330, 138, 49, 14);
		add(lblCiudad);
		
		textCiudad = new JTextField();
		textCiudad.setEnabled(false);
		textCiudad.setColumns(10);
		textCiudad.setBounds(389, 135, 150, 20);
		add(textCiudad);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(40, 141, 61, 14);
		add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setEnabled(false);
		textDireccion.setColumns(10);
		textDireccion.setBounds(115, 138, 184, 20);
		add(textDireccion);
		
		JLabel lblDistincion = new JLabel("Distinción:");
		lblDistincion.setBounds(40, 191, 70, 14);
		add(lblDistincion);
		
		spnDistincion = new JSpinner();
		spnDistincion.setEnabled(false);
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
		textMinimo.setEnabled(false);
		textMinimo.setColumns(10);
		textMinimo.setBounds(330, 188, 61, 20);
		add(textMinimo);
		
		JLabel lblMaximo = new JLabel("Máximo:");
		lblMaximo.setBounds(409, 191, 59, 14);
		add(lblMaximo);
		
		textMaximo = new JTextField();
		textMaximo.setEnabled(false);
		textMaximo.setColumns(10);
		textMaximo.setBounds(478, 188, 61, 20);
		add(textMaximo);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(40, 236, 61, 14);
		add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setEnabled(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(115, 233, 118, 20);
		add(textTelefono);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(280, 236, 41, 14);
		add(lblWeb);
		
		textWeb = new JTextField();
		textWeb.setEnabled(false);
		textWeb.setColumns(10);
		textWeb.setBounds(330, 233, 209, 20);
		add(textWeb);
		
		btnGuardarDat = new JButton(BTN_GUARDAR_DAT);
		btnGuardarDat.setEnabled(false);
		btnGuardarDat.setBounds(421, 283, 118, 23);
		add(btnGuardarDat);
		
		btnCancelar = new JButton(BTN_CANCELAR);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(280, 283, 118, 23);
		add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(421, 59, 117, 23);
		add(btnBuscar);

	}

	public void setListener(GMListener listener) {
		btnBuscar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
		btnGuardarDat.addActionListener(listener);
		
	}

	public Restaurante getDatos() {
		Restaurante restIn = null;
		
		String ciudad = textCiudad.getText().trim();
		if (ciudad.isEmpty()) {
			mostrarError("Debe introducir el nombre de la ciudad");
		
		} else {
			try {
				String nombre = textNombre.getText();
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

				} else {
					restIn = new Restaurante(nombre, region, ciudad, distincion, direccion, precioMin, precioMax, cocina, telefono, web);
				}
			
			
			} catch (NumberFormatException e) {
				mostrarError("El precio mínimo y el máximo deben ser numéricos");
		
			}//TODO quiza otro catch
	
		}

		return restIn;
	}

	public void mostrarError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);		
		
	}

	public String getNomRestaurante() {
		String nomRest = textNombre.getText();

		return nomRest;	
	}

	public void cargarDatos(Restaurante restaurante) {
		textNombre.setText(restaurante.getNombre());
		cmbxRegion.setSelectedItem(restaurante.getRegion());
		textCiudad.setText(restaurante.getCiudad());
		spnDistincion.setValue(restaurante.getDistincion());
		textDireccion.setText(restaurante.getDireccion());
		textMinimo.setText(String.valueOf(restaurante.getPrecioMin()));
		textMaximo.setText(String.valueOf(restaurante.getPrecioMax()));
		cmbxCocina.setSelectedItem(restaurante.getCocina());
		textTelefono.setText(restaurante.getTelefono());
		textWeb.setText(restaurante.getWeb());
		
		enableComponents(true);
		
	}

	private void enableComponents(boolean b) {
		textNombre.setEnabled(!b);
		btnBuscar.setEnabled(!b);
		
		cmbxRegion.setEnabled(b);
		textCiudad.setEnabled(b);
		textDireccion.setEnabled(b);
		cmbxCocina.setEnabled(b);
		spnDistincion.setEnabled(b);
		textMinimo.setEnabled(b);
		textMaximo.setEnabled(b);
		textTelefono.setEnabled(b);
		textWeb.setEnabled(b);
		
		btnGuardarDat.setEnabled(b);
		btnCancelar.setEnabled(b);
		
	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Información de operación", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void limpiarComponentes() {
		textNombre.setText("");
		cmbxRegion.setSelectedIndex(0);
		textCiudad.setText("");
		textDireccion.setText("");
		textMinimo.setText("");
		textMaximo.setText("");
		cmbxCocina.setSelectedIndex(0);
		spnDistincion.setValue(1);
		textTelefono.setText("");
		textWeb.setText("");
		enableComponents(false);
		
	}

}
