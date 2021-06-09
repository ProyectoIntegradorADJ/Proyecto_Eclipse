package com.dam.maven.GuiaMichelin.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dam.maven.GuiaMichelin.db.RestaurantePersistencia;
import com.dam.maven.GuiaMichelin.model.Restaurante;
import com.dam.maven.GuiaMichelin.view.PConsultaRestaurante;
import com.dam.maven.GuiaMichelin.view.PModificarRestaurante;
import com.dam.maven.GuiaMichelin.view.PRegistroRestaurante;
import com.dam.maven.GuiaMichelin.view.VPrincipalGuiaM;

public class GMListener implements ActionListener {

	//Persistencias:
	private RestaurantePersistencia model;
	
	//Ventanas y Paneles
	private VPrincipalGuiaM vPGM;
	private PConsultaRestaurante pConsulR;
	private PRegistroRestaurante pInsertR;
	private PModificarRestaurante pModifR;
	
	public GMListener(VPrincipalGuiaM vPGM, PConsultaRestaurante pConsultaR, PRegistroRestaurante pRegistroR, PModificarRestaurante pModifR) {
		this.vPGM = vPGM;
		this.pConsulR = pConsultaR;
		this.pInsertR = pRegistroR;
		this.pModifR = pModifR;
		model = new RestaurantePersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals(VPrincipalGuiaM.MNTM_CONSULTA)) {
				
				vPGM.cargarPanel(pConsulR);
				
				//Cargar los datos de la region, en el comboBox
				pConsulR.setRegion(model.selectDistinctRegion());
				ArrayList<String> listaRegiones = null;
				listaRegiones = model.selectDistinctRegion();
				
				if (listaRegiones != null) {
					pConsulR.setRegion(listaRegiones);
				}
				
				//Cargar los datos de la distincion, en el comboBox
				pConsulR.setDistincion(model.selectDistinctDistincion());
				ArrayList<String> listaDistincion = null;
				listaDistincion = model.selectDistinctDistincion();
				
				if (listaDistincion != null) {
					pConsulR.setDistincion(listaDistincion);
				}
			
			}else if (ev.getActionCommand().equals(VPrincipalGuiaM.MNTM_REGISTRO)) {
				//TODO
				vPGM.cargarPanel(pInsertR);
				
			}else if (ev.getActionCommand().equals(VPrincipalGuiaM.MNTM_MODIFICACION)) {
				//TODO
				vPGM.cargarPanel(pModifR);
				
			}else if (ev.getActionCommand().equals(VPrincipalGuiaM.MNTM_SALIR)) {
				vPGM.mostrarMsjConfirm();
			}
			
		}else if (ev.getSource() instanceof JButton) {

			if (ev.getActionCommand().equals(PConsultaRestaurante.BTN_CONSULTA)) {
				consultarRestaurante();	
			
			} else if (ev.getActionCommand().equals(PConsultaRestaurante.BTN_ELIMINAR)) {
				String nomRest = pConsulR.getRestSeleccionado();
				
				if (!nomRest.equals("")) {
					int opcion = JOptionPane.showConfirmDialog(pConsulR, "Se va a eliminar el registro "
							+ "seleccionado. ¿Desea continuar?", 
							"Confirmación de borrado", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					
					if (opcion == JOptionPane.YES_OPTION) {
						int res = model.deleteRestaurante(nomRest);
	
						if (res == 1) {
							pConsulR.mostrarMsjInfo("Se ha eliminado el restaurante con exito");
							consultarRestaurante();
						} else {
							pConsulR.mostrarMsjError("No se ha podido eliminar el piloto");
						}
					}
				}
				
			} else if (ev.getActionCommand().equals(PRegistroRestaurante.BTN_GUARDAR)) {
				Restaurante restIn = pInsertR.getDatos();
				
				if (restIn != null) {
					//TODO: Almacenar el restaurante en la bbdd.
					int res = model.insertRestaurante(restIn);

					if (res == 1) {
						pInsertR.setVisibleBtnLimpiar(true);
						pInsertR.mostrarInfo("Se ha registrado el restaurante con exito");
						
					} else if (res == -1) {
						pInsertR.mostrarError("Ya existe un restaurante con el nombre introducido");
				
					}else {
						pInsertR.mostrarError("No se ha podido guardar los datos. Consulte a su gestor de BBDD.");
					}
				}
			
			} else if (ev.getActionCommand().equals(PRegistroRestaurante.BTN_LIMPIAR_DATOS)) {
				pInsertR.limpiarComponentes();
				pInsertR.setVisibleBtnLimpiar(false);

			} else if (ev.getActionCommand().equals(PModificarRestaurante.BTN_BUSCAR_DAT)) {
				String nombre = pModifR.getNomRestaurante();
				
				Restaurante restaurante = model.selecNomRest(nombre);
				
				//El SELECT esta hecho para que devuelva solo un reultado
				//aunque se podria comprobar que hay mas de un restaurante que coincida con el nombre
				//Para hacerlo cargamos todos los resultados obtenidos en un array y luego informamos
				//al ususario de cual quiere elegir.
				
				//Restaurante restaurante = model.selectRestaurante(nomRestOk);
				if (nombre.isEmpty()) {
					pModifR.mostrarError("Debe introducir un nombre");
				}else if (restaurante != null) {
					//cargar los datos en el panel de modificacion
					pModifR.cargarDatos(restaurante);
				} else {
					pModifR.mostrarMsjInfo("No se ha encontrado ningun restaurante para el dato introducido");
				}
				
			} else if (ev.getActionCommand().equals(PModificarRestaurante.BTN_GUARDAR_DAT)) {
				Restaurante restaurante = pModifR.getDatos();
				int res = 0;
				if (restaurante != null) {
					res = model.updateRestaurante(restaurante);
				}				
				
				if (res == 1) {
					pModifR.mostrarMsjInfo("Se ha modificado el restaurante con éxito");
					//Limpiar la tabla de la consulta cuando elimine el piloto y ya
					//no exista esa nacionalidad
					pConsulR.cargarTabla(new ArrayList<Restaurante>());
					
				} else {
					pModifR.mostrarError("No se ha podido realizar modificación");
				}
				
				
			} else if (ev.getActionCommand().equals(PModificarRestaurante.BTN_CANCELAR)) {
				pModifR.limpiarComponentes();
			}
		} 

	}

	private void consultarRestaurante() {
		ArrayList<Restaurante> listaRestaurantes = null;

		String regionFiltro = pConsulR.getRegionFilter();//cmbx Region
		String distincionTodos = pConsulR.getDistincionFilter();//cmbx Distincion
		int distincionFiltroResto = pConsulR.getDistincionFilterResto();
						
		if (regionFiltro.equals(PConsultaRestaurante.OPT_TODAS) 
				&& distincionTodos.equals(PConsultaRestaurante.OPT_TODAS)) {
			listaRestaurantes = model.selectRestaurantes();
			pConsulR.cargarTabla(listaRestaurantes);
		
		}else if (regionFiltro.equals(PConsultaRestaurante.OPT_TODAS)) {
			listaRestaurantes = model.selectRestFiltroDisc(distincionFiltroResto);
			pConsulR.cargarTabla(listaRestaurantes);
			
		}else if (distincionTodos.equals(PConsultaRestaurante.OPT_TODAS)) {
			listaRestaurantes = model.selectRestFiltoRegion(regionFiltro);
			pConsulR.cargarTabla(listaRestaurantes);

		}else if (!regionFiltro.equals(PConsultaRestaurante.OPT_TODAS) 
				&& !distincionTodos.equals(PConsultaRestaurante.OPT_TODAS)) {
			
			listaRestaurantes = model.selectRestRegion(regionFiltro, distincionFiltroResto);	
			if (!listaRestaurantes.isEmpty()) {
				pConsulR.cargarTabla(listaRestaurantes);
			}else {
				pConsulR.mostrarMsjInfo("No se han encontrado datos para el filtro introducido");
			}
			pConsulR.cargarTabla(listaRestaurantes);

		}
		
		pConsulR.setVisibleBtnEliminar();
	}

}
