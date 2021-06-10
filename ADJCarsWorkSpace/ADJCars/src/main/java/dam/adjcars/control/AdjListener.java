package dam.adjcars.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import dam.adjcars.db.AdjPersistencia;
import dam.adjcars.model.Cliente;
import dam.adjcars.model.Empleado;
import dam.adjcars.model.Vehiculo;
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
	
	public AdjListener(VPrincipal vp, VLoginEmpleado vle, VEmpleado ve, VLoginCliente vlc, VAltaCliente vac,
			VCliente vc, PRegistrarVehiculo prv) {
		this.vp = vp;
		this.vle = vle;
		this.ve = ve;
		this.vlc = vlc;
		this.vac = vac;
		this.vc = vc;
		this.prv = prv;
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
						prv.setVisibleBtnLimpiar(true);
						prv.mostrarMsjInfo("Se ha registrado correctamente el vehículo introducido");
					} else if (veh == -1) {
						prv.mostrarMsjError("Ya existe un vehívulo con las características introducidas");
					} else {
						prv.mostrarMsjError("No se ha podido guardar los datos. Consulte con su administrador");
					}
				}
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
			} else if (ev.getActionCommand().equalsIgnoreCase(VEmpleado.MNTM_REGISTRAR_VEHICULO){
				
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
