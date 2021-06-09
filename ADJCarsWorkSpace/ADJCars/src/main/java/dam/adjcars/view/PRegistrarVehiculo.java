package dam.adjcars.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class PRegistrarVehiculo extends JPanel {
	private JTextField txtMarcaVehiculoReg;
	private JTextField txtModeloVehiculoReg;
	private JComboBox cmbTiposVehiculosReg;
	private JComboBox cmbTipoMotorVehiculoReg;
	private JTextField txtColorVehiculoReg;
	private JTextField txtMatriculaVehiculoReg;
	private JTextField txtNumBastidorVehiculoReg;
	private JTextField txtFechaFabVehiculoReg;
	private JSpinner spinner;
	private JButton btncancelarReg;
	private JButton btnLimpiarDatosReg;
	public PRegistrarVehiculo() {
		initComponents();
	}

	private void initComponents() {
		setSize(VEmpleado.ANCHO_VENTANA_PANELES - 30, VEmpleado.ALTO_VENTANA_PANELES - 70);
		setLayout(null);
		
		JLabel lblRegistroNuevoVehiculo = new JLabel("Registrar nuevo vehículo");
		lblRegistroNuevoVehiculo.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblRegistroNuevoVehiculo.setBounds(47, 23, 344, 65);
		add(lblRegistroNuevoVehiculo);
		
		JLabel lblMarcaVehiculoReg = new JLabel("Marca");
		lblMarcaVehiculoReg.setBounds(57, 93, 46, 14);
		add(lblMarcaVehiculoReg);
		
		JLabel lblModeloVehiculoReg = new JLabel("Modelo");
		lblModeloVehiculoReg.setBounds(247, 93, 46, 14);
		add(lblModeloVehiculoReg);
		
		JLabel lblTipoVehiculoReg = new JLabel("Tipo de vehículo");
		lblTipoVehiculoReg.setBounds(57, 133, 97, 14);
		add(lblTipoVehiculoReg);
		
		JLabel lblColorVehiculoReg = new JLabel("Color");
		lblColorVehiculoReg.setBounds(57, 177, 46, 14);
		add(lblColorVehiculoReg);
		
		JLabel lblMatriculaVehiculoReg = new JLabel("Matrícula");
		lblMatriculaVehiculoReg.setBounds(247, 177, 63, 14);
		add(lblMatriculaVehiculoReg);
		
		JLabel lblPotenciaVehiculoReg = new JLabel("Potencia");
		lblPotenciaVehiculoReg.setBounds(451, 93, 46, 14);
		add(lblPotenciaVehiculoReg);
		
		JLabel lblTipoMotorVehiculoReg = new JLabel("Tipo de motor");
		lblTipoMotorVehiculoReg.setBounds(295, 133, 76, 14);
		add(lblTipoMotorVehiculoReg);
		
		JLabel lblNumBastidorVehiculoReg = new JLabel("Num. bastidor");
		lblNumBastidorVehiculoReg.setBounds(57, 219, 138, 14);
		add(lblNumBastidorVehiculoReg);
		
		JLabel lblFechaFabVehiculoReg = new JLabel("Fecha de fabricación");
		lblFechaFabVehiculoReg.setBounds(295, 219, 138, 14);
		add(lblFechaFabVehiculoReg);
		
		txtMarcaVehiculoReg = new JTextField();
		txtMarcaVehiculoReg.setBounds(99, 90, 138, 20);
		add(txtMarcaVehiculoReg);
		txtMarcaVehiculoReg.setColumns(10);
		
		txtModeloVehiculoReg = new JTextField();
		txtModeloVehiculoReg.setBounds(293, 90, 138, 20);
		add(txtModeloVehiculoReg);
		txtModeloVehiculoReg.setColumns(10);
		
		cmbTiposVehiculosReg = new JComboBox();
		cmbTiposVehiculosReg.setBounds(147, 129, 138, 22);
		add(cmbTiposVehiculosReg);
		
		cmbTipoMotorVehiculoReg = new JComboBox();
		cmbTipoMotorVehiculoReg.setBounds(381, 129, 139, 22);
		add(cmbTipoMotorVehiculoReg);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(65, 0, 720, 1));
		spinner.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		spinner.setBounds(507, 89, 71, 20);
		add(spinner);
		
		txtColorVehiculoReg = new JTextField();
		txtColorVehiculoReg.setBounds(99, 174, 130, 20);
		add(txtColorVehiculoReg);
		txtColorVehiculoReg.setColumns(10);
		
		txtMatriculaVehiculoReg = new JTextField();
		txtMatriculaVehiculoReg.setBounds(317, 174, 114, 20);
		add(txtMatriculaVehiculoReg);
		txtMatriculaVehiculoReg.setColumns(10);
		
		txtNumBastidorVehiculoReg = new JTextField();
		txtNumBastidorVehiculoReg.setBounds(135, 216, 130, 20);
		add(txtNumBastidorVehiculoReg);
		txtNumBastidorVehiculoReg.setColumns(10);
		
		txtFechaFabVehiculoReg = new JTextField();
		txtFechaFabVehiculoReg.setBounds(419, 216, 159, 20);
		add(txtFechaFabVehiculoReg);
		txtFechaFabVehiculoReg.setColumns(10);
		
		JButton btnGuardarVehiculoReg = new JButton("Guardar datos");
		btnGuardarVehiculoReg.setBounds(57, 259, 130, 23);
		add(btnGuardarVehiculoReg);
		
		btncancelarReg = new JButton("Cancelar");
		btncancelarReg.setBounds(497, 373, 130, 23);
		add(btncancelarReg);
		
		btnLimpiarDatosReg = new JButton("Limpiar datos");
		btnLimpiarDatosReg.setBounds(448, 259, 130, 23);
		add(btnLimpiarDatosReg);
	}
}