package dam.adjcars.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import dam.adjcars.control.AdjListener;
import dam.adjcars.model.Vehiculo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PModificarVehiculo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//CONSTANTES
	public static final String BTN_GUARDAR_MODIF= "Guardar Nuevos Datos";
	public static final String BTN_CANCELAR_MODIF = "Cancelar Operacion";
	public static final String BTN_BUSCAR_MODIF = "Buscar Matricula";
	
	//VARIABLES
	private JTextField txtMatricula;
	private JTextField txtColor;
	private JSpinner spnPotencia;
	private JComboBox<String> cmbTipoMotor;
	private JButton btnGuardarDatosModif;
	private JButton btnCancelar;
	private JButton btnBuscar;
	
	
	
	public PModificarVehiculo() {
		initComponents();
	}

	private void initComponents() {
		setSize(VEmpleado.ANCHO_VENTANA_PANELES - 30, VEmpleado.ALTO_VENTANA_PANELES - 70);
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Modificar Vehículo");
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblTitulo.setBounds(25, 29, 486, 58);
		add(lblTitulo);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(58, 114, 78, 13);
		add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(159, 111, 149, 19);
		add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblPotencia = new JLabel("Potencia");
		lblPotencia.setBounds(58, 166, 55, 13);
		add(lblPotencia);
		
		spnPotencia = new JSpinner();
		spnPotencia.setModel(new SpinnerNumberModel(65, 65, 720, 1));
		spnPotencia.setBounds(128, 163, 57, 20);
		add(spnPotencia);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(58, 221, 45, 13);
		add(lblColor);
		
		txtColor = new JTextField();
		txtColor.setBounds(128, 218, 130, 19);
		add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblTipoMotor = new JLabel("Tipo Motor");
		lblTipoMotor.setBounds(253, 166, 106, 13);
		add(lblTipoMotor);
		
		cmbTipoMotor = new JComboBox<String>();
		cmbTipoMotor.setModel(new DefaultComboBoxModel<String>(new String[] {"- ELEGIR -", "ECOBOOST TDI", "TDI", "TFSI", "TGI", "TSI"}));
		cmbTipoMotor.setBounds(351, 162, 160, 21);
		add(cmbTipoMotor);
		
		btnGuardarDatosModif = new JButton(BTN_GUARDAR_MODIF);
		btnGuardarDatosModif.setBounds(237, 286, 174, 21);
		add(btnGuardarDatosModif);
		
		btnCancelar = new JButton(BTN_CANCELAR_MODIF);
		btnCancelar.setBounds(438, 350, 174, 21);
		add(btnCancelar);
		
		btnBuscar = new JButton(BTN_BUSCAR_MODIF);
		btnBuscar.setBounds(362, 110, 149, 21);
		add(btnBuscar);
	}
	
	public void setListener(AdjListener listener) {
		btnBuscar.addActionListener(listener);
		btnGuardarDatosModif.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
	
	public void mostrarMsjError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);

	}

	public void mostrarMsjInfo(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Información de operación", JOptionPane.INFORMATION_MESSAGE);

	}

	
	public String getMatricula() {
		return txtMatricula.getText();
	}
	

	public void cargarDatos(Vehiculo vehiculo) {
		txtMatricula.setText(vehiculo.getMatricula());
		spnPotencia.setValue(vehiculo.getPotencia());
		cmbTipoMotor.setSelectedItem(vehiculo.getTipoMotor());
		txtColor.setText(vehiculo.getColor());
		
	}
	

	public Vehiculo getDatos() {
		Vehiculo vehiculo = null;
		
		String matricula = txtMatricula.getText().trim();
		int potencia = (int) spnPotencia.getValue();
		String tipoMotor = (String) cmbTipoMotor.getSelectedItem();
		String color = txtColor.getText().trim();
		
		vehiculo = new Vehiculo(potencia, tipoMotor, color, matricula);
		
		return vehiculo;
	}

	public void limpiarComponentes() {
		txtMatricula.setText("");
		spnPotencia.setValue(65);
		cmbTipoMotor.setSelectedIndex(0);
		txtColor.setText("");
		
	}
	
}
