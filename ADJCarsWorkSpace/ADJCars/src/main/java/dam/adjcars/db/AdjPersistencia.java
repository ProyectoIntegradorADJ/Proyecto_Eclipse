package dam.adjcars.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dam.adjcars.model.Cliente;
import dam.adjcars.model.Empleado;
import dam.adjcars.model.Vehiculo;

public class AdjPersistencia {
	private AccesoDB adb;

	public AdjPersistencia() {
		adb = new AccesoDB();
	}

	public Empleado comprobarCrendecialesEmpleado(String nombreEmpleado) {
		Empleado empleado = null;

		String query = "SELECT NOMBRE, PSWD_EMPLE FROM CONC_EMPLE WHERE NOMBRE = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			con = adb.getConexion();

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, nombreEmpleado);

			rslt = pstmt.executeQuery();

			String nombreEmple;
			String contrasenaEmple;

			while (rslt.next()) {
				nombreEmple = rslt.getString(1);
				contrasenaEmple = rslt.getString(2);

				empleado = new Empleado(contrasenaEmple, nombreEmple);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empleado;
	}

	public Cliente comprobarCrendecialesCliente(String nombreCliente) {
		Cliente cliente = null;

		String query = "SELECT NOMBRE, PSWD_CLI FROM CONC_CLIENTES WHERE NOMBRE = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			con = adb.getConexion();

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, nombreCliente);

			rslt = pstmt.executeQuery();

			String nombreCli;
			String contrasenaCli;

			while (rslt.next()) {
				nombreCli = rslt.getString(1);
				contrasenaCli = rslt.getString(2);

				cliente = new Cliente(contrasenaCli, nombreCli);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null)
					rslt.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}

	public int insertVehiculo(Vehiculo vehReg) {
		String query = "INSERT INTO CONC_VEHICULOS (MARCA, MODELO, POTENCIA, TIPO_VEH, TIPO_MOTOR, COLOR, MATRICULA, NUM_BASTIDOR, FECHA_FAB)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vehReg.getMarca());
			pstmt.setString(2, vehReg.getModelo());
			pstmt.setInt(3, vehReg.getPotencia());
			pstmt.setString(4, vehReg.getTipoVeh());
			pstmt.setString(5, vehReg.getTipoMotor());
			pstmt.setString(6, vehReg.getColor());
			pstmt.setString(7, vehReg.getMatricula());
			pstmt.setString(8, vehReg.getNumBastidor());
			pstmt.setString(9, vehReg.getFecha_fab());
					
			res = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;	
	}

	public Vehiculo selectMatVeh(String matricula) {
		Vehiculo veh = null;
		
		String query = "SELECT MATRICULA, POTENCIA, TIPO_MOTOR, COLOR FROM CONC_VEHICULOS WHERE MATRICULA = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, matricula);
			rslt = pstmt.executeQuery();
			
			String mat;
			int pot;
			String tMotor;
			String color;
			
			while (rslt.next()) {
				mat = rslt.getString(1);
				pot = rslt.getInt(2);
				tMotor = rslt.getString(3);
				color = rslt.getString(4);
				
				veh = new Vehiculo(pot, tMotor, color, mat);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return veh;
	}

	public int updateVehiculo(Vehiculo vehiculo) {
		String query = "UPDATE CONC_VEHICULOS SET POTENCIA = ?, TIPO_MOTOR = ?, COLOR = ? WHERE MATRICULA = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, vehiculo.getPotencia());
			pstmt.setString(2, vehiculo.getTipoMotor());
			pstmt.setString(3, vehiculo.getColor());
			pstmt.setString(4, vehiculo.getMatricula());
			
			res = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			res = -1;
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
}
