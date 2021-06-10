package dam.ajdcars.main;

import java.awt.EventQueue;

import dam.adjcars.control.AdjListener;
import dam.adjcars.view.PRegistrarVehiculo;
import dam.adjcars.view.VAltaCliente;
import dam.adjcars.view.VCliente;
import dam.adjcars.view.VEmpleado;
import dam.adjcars.view.VLoginCliente;
import dam.adjcars.view.VLoginEmpleado;
import dam.adjcars.view.VPrincipal;

public class InicioAdjCars {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				VPrincipal vp = new VPrincipal();
				VLoginEmpleado vle = new VLoginEmpleado();
				VLoginCliente vlc = new VLoginCliente();
				VAltaCliente vac = new VAltaCliente();
				VEmpleado ve = new VEmpleado();
				VCliente vc = new VCliente();
				PRegistrarVehiculo prv = new PRegistrarVehiculo();

				AdjListener listener = new AdjListener(vp, vle, ve, vlc, vac, vc, prv);

				vp.setListener(listener);
				vle.setListener(listener);
				vlc.setListener(listener);
				vac.setListener(listener);
				ve.setListener(listener);
				vc.setListener(listener);
				prv.setListener(listener);

				vp.hacerVisible();
			}
		});

	}

}
