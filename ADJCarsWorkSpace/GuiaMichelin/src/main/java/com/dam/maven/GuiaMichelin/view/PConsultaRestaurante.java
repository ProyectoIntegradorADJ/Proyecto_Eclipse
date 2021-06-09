package com.dam.maven.GuiaMichelin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dam.maven.GuiaMichelin.control.GMListener;
import com.dam.maven.GuiaMichelin.model.Restaurante;


public class PConsultaRestaurante extends JPanel {
	
	private static final String CLM_NOMBRE = "NOMBRE";
	private static final String CLM_CIUDAD = "CIUDAD";
	private static final String CLM_DISTINCION = "DISTINCIÓN";
	private static final String CLM_COCINA = "COCINA";
	private static final String CLM_PRECIO = "PRECIO";
	
	public static final String BTN_CONSULTA = "Consultar";
	public static final String BTN_ELIMINAR = "Eliminar";
	public static final String OPT_TODAS = "TODAS";

	private JButton btnConsultar;
	private JButton btnEliminar;
	private JTable tblRestaurantes;
	private JComboBox<String> cmbRegion;
	private JComboBox<String> cmbDistincion;
	
	private DefaultTableModel tblModel;
	private DefaultComboBoxModel<String> cmbxModelRegion;
	private DefaultComboBoxModel<String> cmbxModelDistincion;
	
	public PConsultaRestaurante() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setSize(VPrincipalGuiaM.ANCHO - 30, VPrincipalGuiaM.ALTO -70);
		
		JLabel lblConsulta = new JLabel("Consulta de Restaurantes");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConsulta.setBounds(20, 11, 229, 19);
		add(lblConsulta);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setBounds(30, 41, 49, 14);
		add(lblFiltro);
		
		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(54, 60, 49, 14);
		add(lblRegion);
		
		//ComboBox Region
		cmbRegion = new JComboBox<String>();
		cmbxModelRegion = new DefaultComboBoxModel<String>();
		cmbRegion.setModel(cmbxModelRegion);
		
		cmbRegion.setBounds(121, 57, 142, 19);
		add(cmbRegion);
		
		JLabel lblDistincion = new JLabel("Distinción:");
		lblDistincion.setBounds(315, 59, 68, 14);
		add(lblDistincion);
		
		//ComboBox Distinción
		cmbDistincion = new JComboBox<String>();
		cmbxModelDistincion = new DefaultComboBoxModel<String>();
		cmbDistincion.setModel(cmbxModelDistincion);
		
		cmbDistincion.setBounds(407, 57, 149, 19);
		add(cmbDistincion);
		
		btnConsultar = new JButton(BTN_CONSULTA);
		btnConsultar.setBounds(453, 87, 103, 23);
		add(btnConsultar);
		
		JScrollPane scrollTablaRest = new JScrollPane();
		scrollTablaRest.setBounds(20, 121, 536, 187);
		add(scrollTablaRest);
		
		tblRestaurantes = new JTable();
		tblRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollTablaRest.setViewportView(tblRestaurantes);
		
		btnEliminar = new JButton(BTN_ELIMINAR);
		btnEliminar.setVisible(false);
		btnEliminar.setBounds(340, 87, 89, 23);
		add(btnEliminar);
	
		configurarTabla();
	}

	private void configurarTabla() {
		tblModel = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblModel.addColumn(CLM_NOMBRE);
		tblModel.addColumn(CLM_CIUDAD);
		tblModel.addColumn(CLM_DISTINCION);
		tblModel.addColumn(CLM_COCINA);
		tblModel.addColumn(CLM_PRECIO);
		
		tblRestaurantes.setModel(tblModel);
		
		tblRestaurantes.getColumn(CLM_NOMBRE).setPreferredWidth(100);
		tblRestaurantes.getColumn(CLM_CIUDAD).setPreferredWidth(150);
		tblRestaurantes.getColumn(CLM_DISTINCION).setPreferredWidth(100);
		tblRestaurantes.getColumn(CLM_COCINA).setPreferredWidth(100);
		tblRestaurantes.getColumn(CLM_PRECIO).setPreferredWidth(100);
	
	}
	
	public void cargarTabla(ArrayList<Restaurante> listaRestaurante) {
		tblModel.setRowCount(0);
		Object[] fila = new Object[5];
		String distinEstrellas;
		String precio;
		
		for (Restaurante restaurante : listaRestaurante) {
			distinEstrellas = "";
			precio = "";
			fila[0] = restaurante.getNombre();
			fila[1] = restaurante.getCiudad();
			
			//Asigna el caracter '*' en función del número devuelto por la bbdd 
			for (int i = 1; i <= restaurante.getDistincion(); i++) {
				distinEstrellas += "*";
			}
			fila[2] = distinEstrellas;
			
			fila[3] = restaurante.getCocina();
			
			if (restaurante.getPrecioMax() <= 0 ) {
				precio = String.valueOf(restaurante.getPrecioMin());
			}else {
				precio = String.valueOf(restaurante.getPrecioMin()) + " - " + String.valueOf(restaurante.getPrecioMax());
			}
			fila[4] = precio;	
			
			//añadimos las filas a la tabla.
			tblModel.addRow(fila);
		}	
	}
	
	public void setListener (GMListener listener) {
		btnConsultar.addActionListener(listener);
		btnEliminar.addActionListener(listener);
	}
	
	//Con los dos siguientes metodos cargamos la region obtenida de la bbdd 
	public String getRegionFilter() {
		return (String) cmbxModelRegion.getSelectedItem();
	}

	public void setRegion(ArrayList<String> listaRegiones) {
		cmbxModelRegion.removeAllElements();
		cmbxModelRegion.addElement(OPT_TODAS);
		for (String region : listaRegiones) {
			cmbxModelRegion.addElement(region);
		}
	}
	
	//Con los dos siguientes metodos cargamos la distincion obtenida de la bbdd 
		public String getDistincionFilter() {
			return (String) cmbxModelDistincion.getSelectedItem();
		}

		public void setDistincion(ArrayList<String> listaDistincion) {
			cmbxModelDistincion.removeAllElements();
			cmbxModelDistincion.addElement(OPT_TODAS);
			for (String distincion : listaDistincion) {
				cmbxModelDistincion.addElement(distincion + " estrellas");
			}
		}

		public int getDistincionFilterResto() {
			/*String estrellas = String.valueOf(tblModel.getValueAt(tblRestaurantes.getSelectedRow(), 2));
			int numDistincion = estrellas.length();
			return numDistincion;*/
			int numDist = -1;
			if (!cmbxModelDistincion.getSelectedItem().equals("TODAS")) {
				String distincion = String.valueOf(cmbxModelDistincion.getSelectedItem());
				numDist = Integer.parseInt(distincion.substring(0, 1));
			}		
				return numDist;
			
		}
		
		public void setVisibleBtnEliminar() {
			btnEliminar.setVisible(true);			
		}

		public String getRestSeleccionado() {
			String nomRest = "";
			if (tblRestaurantes.getSelectedRow() == -1) {
				mostrarMsjError("Debe selecionar el registro a eliminar");
			} else {
				nomRest = (String) tblModel.getValueAt(tblRestaurantes.getSelectedRow(), 0); 
			}
			return nomRest;
		}
		
		public void mostrarMsjError(String msj) {
			JOptionPane.showMessageDialog(this, msj, "Error de selección", JOptionPane.ERROR_MESSAGE);
			
		}

		public void mostrarMsjInfo(String msj) {
			JOptionPane.showMessageDialog(this, msj, "Información de operación", 
					JOptionPane.INFORMATION_MESSAGE);		
		}

		

}//final class
