package dam.adjcars.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PConsultarVehiculoVEmple extends JPanel {
	public static final String  CLM_ID_VEHICULO = "ID";;
	public static final String  CLM_MATRICULA_VEHICULO = "MATRÍCULA"; 
	public static final String  CLM_NUM_BAST_VEHICULO = "NUM. BASTIDOR";
	public static final String  CLM_MARCA_VEHICULO = "MARCA";
	public static final String  CLM_MODELO_VEHICULO = "MODELO";
	public static final String  CLM_MODELO_TIPO_MOTOR_VEHICULO = "TIPO MOTOR";
	public static final String  CLM_MODELO_FECHA_FAB_VEHICULO = "FECHA FAB";
	public static final String  CLM_MODELO_TIPO_VEHICULO = "TIPO VEHÍCULO";
	public static final String  CLM_MODELO_COLOR_VEHICULO = "COLOR";
	public static final String  CLM_MODELO_POTENCIA_VEHICULO = "POTENCIA";
	
	
	private JTextField txtMatriculaPConsultaEmple;
	private JScrollPane scrpListaVehiculosEmpleado;
	private JTable tblVehiculosConsultaEmpleado;
	private DefaultTableModel tblModel;
	
	public PConsultarVehiculoVEmple() {
		initComponents();
	}

	private void initComponents() {
		setSize(VEmpleado.ANCHO_VENTANA_PANELES - 30, VEmpleado.ALTO_VENTANA_PANELES - 70);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar vehículo");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel.setBounds(47, 23, 344, 65);
		add(lblNewLabel);
		
		txtMatriculaPConsultaEmple = new JTextField();
		txtMatriculaPConsultaEmple.setBounds(105, 99, 185, 20);
		add(txtMatriculaPConsultaEmple);
		txtMatriculaPConsultaEmple.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Matrícula");
		lblNewLabel_1.setBounds(47, 102, 61, 14);
		add(lblNewLabel_1);
		
		scrpListaVehiculosEmpleado = new JScrollPane();
		scrpListaVehiculosEmpleado.setBounds(47, 137, 573, 235);
		add(scrpListaVehiculosEmpleado);
		
		tblVehiculosConsultaEmpleado = new JTable();
		scrpListaVehiculosEmpleado.setViewportView(tblVehiculosConsultaEmpleado);
		
		configurarTabla();
	}

	private void configurarTabla() {
		tblModel = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblModel.addColumn(CLM_ID_VEHICULO);
		tblModel.addColumn(CLM_MATRICULA_VEHICULO);
		tblModel.addColumn(CLM_NUM_BAST_VEHICULO);
		tblModel.addColumn(CLM_MARCA_VEHICULO);
		tblModel.addColumn(CLM_MODELO_VEHICULO);
		tblModel.addColumn(CLM_MODELO_TIPO_MOTOR_VEHICULO);
		tblModel.addColumn(CLM_MODELO_FECHA_FAB_VEHICULO);
		tblModel.addColumn(CLM_MODELO_TIPO_VEHICULO);
		tblModel.addColumn(CLM_MODELO_COLOR_VEHICULO);
		tblModel.addColumn(CLM_MODELO_POTENCIA_VEHICULO);
		
		tblVehiculosConsultaEmpleado.setModel(tblModel);
		
		tblVehiculosConsultaEmpleado.getColumn(CLM_ID_VEHICULO).setPreferredWidth(30);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MATRICULA_VEHICULO).setPreferredWidth(75);
		tblVehiculosConsultaEmpleado.getColumn(CLM_NUM_BAST_VEHICULO).setPreferredWidth(75);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MARCA_VEHICULO).setPreferredWidth(100);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_VEHICULO).setPreferredWidth(100);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_TIPO_MOTOR_VEHICULO).setPreferredWidth(50);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_FECHA_FAB_VEHICULO).setPreferredWidth(75);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_TIPO_VEHICULO).setPreferredWidth(100);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_COLOR_VEHICULO).setPreferredWidth(75);
		tblVehiculosConsultaEmpleado.getColumn(CLM_MODELO_POTENCIA_VEHICULO).setPreferredWidth(50);
	
	}
}
