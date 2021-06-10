package dam.adjcars.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import dam.adjcars.db.AdjPersistencia;
import dam.adjcars.model.Cliente;
import dam.adjcars.model.Empleado;
import dam.adjcars.model.Vehiculo;
import dam.adjcars.view.PModificarVehiculo;
import dam.adjcars.view.PRegistrarVehiculo;
import dam.adjcars.view.VAltaCliente;
import dam.adjcars.view.VCliente;
import dam.adjcars.view.VEmpleado;
import dam.adjcars.view.VLoginCliente;
import dam.adjcars.view.VLoginEmpleado;
import dam.adjcars.view.VPrincipal;

public class AdjListener implements ActionListener {

	private VPrincipal vp;
	private VLoginEmpleado vle;
	private VEmpleado ve;
	private VLoginCliente vlc;
	private VAltaCliente vac;
	private VCliente vc;
	private AdjPersistencia model;
	private PRegistrarVehiculo prv;
	private PModificarVehiculo pmv;
	
	public AdjListener(VPrincipal vp, VLoginEmpleado vle, VEmpleado ve, VLoginCliente vlc, VAltaCliente vac,
			VCliente vc, PRegistrarVehiculo prv, PModificarVehiculo pmv) {
		this.vp = vp;
		this.vle = vle;
		this.ve = ve;
		this.vlc = vlc;
		this.vac = vac;
		this.vc = vc;
		this.prv = prv;
		this.pmv = pmv;
		model = new AdjPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equalsIgnoreCase(VPrincipal.BTN_EMPLEADO)) {
				vp.dispose();
				vle.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VPrincipal.BTN_CLIENTE)) {
				vp.dispose();
				vlc.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VLoginEmpleado.BTN_ENTRAR_VLOGIN_EMPLEADO)) {
				comprobarCrendencialesEmpleado();
			} else if (ev.getActionCommand().equalsIgnoreCase(VLoginCliente.BTN_ENTRAR_VLOGIN_CLIENTE)) {
				comprobarCrendencialesCliente();
			} else if (ev.getActionCommand().equalsIgnoreCase(VLoginCliente.BTN_ALTA_NUEVO_CLIENTE)) {
				vlc.dispose();
				vac.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(PRegistrarVehiculo.BTN_GUARDAR_REG)) {
				Vehiculo vehReg = prv.getDatos();
				
				if (vehReg != null) {
					int veh = model.insertVehiculo(vehReg);
					
					if (veh == 1) {
						prv.mostrarMsjInfo("Se ha registrado correctamente el vehículo introducido");
					} else if (veh == -1) {
						prv.mostrarMsjError("Ya existe un vehículo con las características introducidas");
					} else {
						prv.mostrarMsjError("No se ha podido guardar los datos. Consulte con su administrador");
					}
				}
			} else if (ev.getActionCommand().equalsIgnoreCase(PRegistrarVehiculo.BTN_LIMPIAR_REG)) {
				prv.limpiarComponentes();
			} else if (ev.getActionCommand().equalsIgnoreCase(PRegistrarVehiculo.BTN_CANCELAR_REG)) {
				int opcion = JOptionPane.showConfirmDialog(prv, "Se va a cancelar el registro del vehículo." 
												+ "¿Desea continuar?", "Confirmación cancelación",
												JOptionPane.YES_NO_OPTION);
				
				if (opcion == JOptionPane.YES_OPTION) {
					prv.mostrarMsjInfo("Se ha cancelado la operación");
				}
				
				prv.limpiarComponentes();
			} else if (ev.getActionCommand().equalsIgnoreCase(PModificarVehiculo.BTN_BUSCAR_MODIF)) {
				String matricula = pmv.getMatricula();
				
				Vehiculo vehiculo = model.selectMatVeh(matricula);
				
				if (matricula.isEmpty()) {
					pmv.mostrarMsjError("Debe introducir la matrícula");
				} else if (vehiculo != null) {
					pmv.cargarDatos(vehiculo);
				} else {
					pmv.mostrarMsjInfo("No se ha encontrado ningún vehículo con esa matrícula");
				}
				
			} else if (ev.getActionCommand().equalsIgnoreCase(PModificarVehiculo.BTN_GUARDAR_MODIF)) {
				Vehiculo vehiculo = pmv.getDatos();
				int veh = 0;
				
				if (vehiculo != null) {
					veh = model.updateVehiculo(vehiculo);
				}
				
				if (veh == 1) {
					pmv.mostrarMsjInfo("Se ha modificado el vehículo con éxito");
				} else {
					pmv.mostrarMsjError("No se ha podido realizar modificación");
				}
				
			} else if (ev.getActionCommand().equalsIgnoreCase(PModificarVehiculo.BTN_CANCELAR_MODIF)) {
				pmv.limpiarComponentes();
			}
			
		} else if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equalsIgnoreCase(VLoginEmpleado.MNTM_ATRAS_VLOGIN_EMPLEADO)) {
				vle.dispose();
				vp.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VLoginCliente.MNTM_ATRAS_VLOGIN_CLIENTE)) {
				vlc.dispose();
				vp.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VEmpleado.MNTM_SALIR_AREA_EMPLEADO)) {
				ve.dispose();
				vle.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VCliente.MNTM_SALIR_AREA_CLIENTE)) {
				vc.dispose();
				vlc.hacerVisible();
			} else if (ev.getActionCommand().equalsIgnoreCase(VEmpleado.MNTM_REGISTRAR_VEHICULO)){
				ve.cargarPanel(prv);
			} else if (ev.getActionCommand().equalsIgnoreCase(VEmpleado.MNTM_MODIFICAR_VEHICULO)){
				ve.cargarPanel(pmv);
			}

		}

	}

	private void comprobarCrendencialesCliente() {
		String nombreCliente = vlc.getNombreCliente();
		String contrasenaCliente = vlc.getContrasenaCliente();

		Cliente cliente = model.comprobarCrendecialesCliente(nombreCliente);

		if (cliente != null) {
			if (nombreCliente.equals(cliente.getNombreCliente())
					&& contrasenaCliente.equals(cliente.getPasswordCliente())) {
				vc.hacerVisible();
				vlc.dispose();
			} else if (nombreCliente.equals(cliente.getNombreCliente())
					&& !contrasenaCliente.equals(cliente.getPasswordCliente())) {
				vle.mostrarMsjError("La contraseña introducida no es correcta");
			} 

		} else {
			vle.mostrarMsjError("El usuario no se encuentra en la base de datos");
		}

	
		

	}

	private void comprobarCrendencialesEmpleado() {
		String nombreEmpleado = vle.getNombreEmpleado();
		String contrasenaEmpleado = vle.getContrasenaEmpleado();

		Empleado empleado = model.comprobarCrendecialesEmpleado(nombreEmpleado);

		if (empleado != null) {
			if (nombreEmpleado.equals(empleado.getNombre())
					&& contrasenaEmpleado.equals(empleado.getPasswordEmpleado())) {
				ve.hacerVisible();
				vle.dispose();
			} else if (nombreEmpleado.equals(empleado.getNombre())
					&& !contrasenaEmpleado.equals(empleado.getPasswordEmpleado())) {
				vle.mostrarMsjError("La contraseña introducida no es correcta");
			} 

		} else {
			vle.mostrarMsjError("El usuario no se encuentra en la base de datos");
		}

	}

}
