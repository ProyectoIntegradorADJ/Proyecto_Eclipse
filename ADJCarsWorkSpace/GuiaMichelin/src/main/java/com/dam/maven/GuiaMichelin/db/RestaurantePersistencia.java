package com.dam.maven.GuiaMichelin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.maven.GuiaMichelin.model.Restaurante;


public class RestaurantePersistencia {
	
	private AccesoDBProp adb;//Clase definitiva para el acceso a BBDD

	public RestaurantePersistencia() {
		//Inicializamos el objeto con los atributos de AccesoDB
		adb = new AccesoDBProp();
	}
	//Metodo para mostrar la informacion de la base de datos.
	public ArrayList<Restaurante> selectRestaurantes(){
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			//Seleccionar el java.sql
			stmt = con.createStatement();
			String query = "SELECT NOMBRE, CIUDAD, DISTINCION, COCINA, PRECIO_MIN, PRECIO_MAX FROM RESTAURANTES";
			rslt = stmt.executeQuery(query);
			
			//Vamos a recuperar los registros que devuelve el executeQuery, recorriendo su contenido
			String nom;
			String ciu;
			int dis;
			String coc;
			double preMin;
			double preMax;
		
			while (rslt.next()) {
				nom = rslt.getString(1);
				ciu = rslt.getString(2);
				dis = rslt.getInt(3);
				coc = rslt.getString(4);
				preMin = rslt.getDouble(5);
				preMax = rslt.getDouble(6);
				
				listaRestaurantes.add(new Restaurante(nom, ciu, dis, coc, preMin, preMax));							
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rslt != null) rslt.close();	
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaRestaurantes;
	}
	
	/* Metodo para seleccionar de la BBDD, un campo especifico por 
	 * medio de una sentencia SELECT DISTINCT
	 */
	public ArrayList<String> selectDistinctRegion(){
		ArrayList<String> listRegion = new ArrayList<String>();
			
		//Preparar
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			//Seleccionar el java.sql
			//Creo el statement para poder realizar la consulta
			stmt = con.createStatement();
			String query = "SELECT DISTINCT REGION FROM RESTAURANTES";
			//Ejecutar
			rslt = stmt.executeQuery(query);
			
			//Recuperar los registros que devuelve el executeQuery, recorriendo su contenido
			String region;
			while (rslt.next()) {
				region = rslt.getString(1);
				listRegion.add(region);				
			}			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Problemas con el driver");
		} catch (SQLException e) {
			System.out.println("Problemas con la BBDD");
		}finally {
			try {
				if (rslt != null) rslt.close();	
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listRegion;
	}
	
	/* Metodo para seleccionar de la BBDD, un campo especifico por 
	 * medio de una sentencia SELECT DISTINCT
	 */
	public ArrayList<String> selectDistinctDistincion(){
		ArrayList<String> listDistincion = new ArrayList<String>();
			
		//Preparar
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			//Seleccionar el java.sql
			//Creo el statement para poder realizar la consulta
			stmt = con.createStatement();
			String query = "SELECT DISTINCT DISTINCION FROM RESTAURANTES";
			//Ejecutar
			rslt = stmt.executeQuery(query);
			
			//Recuperar los registros que devuelve el executeQuery, recorriendo su contenido
			String distincion;
			while (rslt.next()) {
				distincion = rslt.getString(1);
				listDistincion.add(distincion);				
			}			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Problemas con el driver");
		} catch (SQLException e) {
			System.out.println("Problemas con la BBDD");
		}finally {
			try {
				if (rslt != null) rslt.close();	
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listDistincion;
	}
	
	/* Metodo para seleccionar de la BBDD, varios campos tomando en cuenta 
	 * una condición. En este caso no se utiliza Statement, si no,
	 * PreparedStatement porque el metodo recibe un parametro.
	 */
	public ArrayList<Restaurante> selectRestRegion(String regionFiltro, int distincionFiltro) {
		
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		String query = "SELECT NOMBRE, CIUDAD, DISTINCION, COCINA, PRECIO_MIN, PRECIO_MAX FROM RESTAURANTES " 
		+ "WHERE REGION = ? AND DISTINCION = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			//Ejecutar
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, regionFiltro);
			pstmt.setInt(2, distincionFiltro);
			rslt = pstmt.executeQuery();
			
			String nom;
			String ciu;
			int dis;
			String coc;
			double preMin;
			double preMax;
		
			while (rslt.next()) {
				nom = rslt.getString(1);
				ciu = rslt.getString(2);
				dis = rslt.getInt(3);
				coc = rslt.getString(4);
				preMin = rslt.getDouble(5);
				preMax = rslt.getDouble(6);
				
				listaRestaurantes.add(new Restaurante(nom, ciu, dis, coc, preMin, preMax));			
								
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
		
		return listaRestaurantes;
	}
	

	public int deleteRestaurante(String nomRest) {
		String query = "DELETE FROM RESTAURANTES WHERE NOMBRE = ?";
		int res = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//Se realiza la conexion a la db
			con = adb.getConexion();
			
			//Preparamos el statement a partir de la conexion pasandole la query
			pstmt = con.prepareStatement(query);
			
			//Configuramos el statement asignandole los valores para 
			//rellenar la interrogación
			pstmt.setString(1, nomRest);
			
			//Ejecutamos el statement y lo almacenaos en una variable 
			//res acumula el numero de registros modificados
			res = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	
	
	public ArrayList<Restaurante> selectRestFiltroDisc(int distincionFiltroResto) {

		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		String query = "SELECT NOMBRE, CIUDAD, DISTINCION, COCINA, PRECIO_MIN, PRECIO_MAX FROM RESTAURANTES " 
		+ "WHERE DISTINCION = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			//Ejecutar
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, distincionFiltroResto);
			rslt = pstmt.executeQuery();
			
			String nom;
			String ciu;
			int dis;
			String coc;
			double preMin;
			double preMax;
		
			while (rslt.next()) {
				nom = rslt.getString(1);
				ciu = rslt.getString(2);
				dis = rslt.getInt(3);
				coc = rslt.getString(4);
				preMin = rslt.getDouble(5);
				preMax = rslt.getDouble(6);
				
				listaRestaurantes.add(new Restaurante(nom, ciu, dis, coc, preMin, preMax));			
								
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
		
		return listaRestaurantes;
	}
	
	
	public ArrayList<Restaurante> selectRestFiltoRegion(String regionFiltro) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		String query = "SELECT NOMBRE, CIUDAD, DISTINCION, COCINA, PRECIO_MIN, PRECIO_MAX FROM RESTAURANTES " 
		+ "WHERE REGION = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			//Ejecutar
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, regionFiltro);
			rslt = pstmt.executeQuery();
			
			String nom;
			String ciu;
			int dis;
			String coc;
			double preMin;
			double preMax;
		
			while (rslt.next()) {
				nom = rslt.getString(1);
				ciu = rslt.getString(2);
				dis = rslt.getInt(3);
				coc = rslt.getString(4);
				preMin = rslt.getDouble(5);
				preMax = rslt.getDouble(6);
				
				listaRestaurantes.add(new Restaurante(nom, ciu, dis, coc, preMin, preMax));			
								
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
		
		return listaRestaurantes;
	}
	
	
	public int insertRestaurante(Restaurante restIn) {
		String query = "INSERT INTO RESTAURANTES (NOMBRE, REGION, CIUDAD, DISTINCION, DIRECCION, PRECIO_MIN, PRECIO_MAX, COCINA, TELEFONO, WEB)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, restIn.getNombre());
			pstmt.setString(2, restIn.getRegion());
			pstmt.setString(3, restIn.getCiudad());
			pstmt.setInt(4, restIn.getDistincion());
			pstmt.setString(5, restIn.getDireccion());
			pstmt.setDouble(6, restIn.getPrecioMin());
			pstmt.setDouble(7, restIn.getPrecioMax());
			pstmt.setString(8, restIn.getCocina());
			pstmt.setString(9, restIn.getTelefono());
			pstmt.setString(10, restIn.getWeb());
					
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
	public Restaurante selectRestaurante(String nombre) {
		Restaurante restaurante = null;
		
		String query = "SELECT NOMBRE, REGION, CIUDAD, DISTINCION, DIRECCION, PRECIO_MIN, "
				+ "PRECIO_MAX, COCINA, TELEFONO, WEB FROM RESTAURANTES "
				+ "WHERE NOMBRE = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		//resultset solo se usa cuando la query es una select.
		ResultSet rslt = null;
		
		try {
			//Ejecutar
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			rslt = pstmt.executeQuery();
			
			String nom;
			String reg;
			String ciu;
			int dis;
			String dir;
			double preMin;
			double preMax;
			String coc;
			String telef;
			String web;
			
			//Recuperar
			while (rslt.next()) {
				nom = rslt.getString(1);
				reg = rslt.getString(2);
				ciu = rslt.getString(3);
				dis = rslt.getInt(4);
				dir = rslt.getString(5);
				preMin = rslt.getDouble(6);
				preMax = rslt.getDouble(7);
				coc = rslt.getString(8);
				telef = rslt.getString(9);
				web = rslt.getString(10);
				
				restaurante = new Restaurante(nom, reg, ciu, dis, dir, preMin, preMax, coc, telef, web);
				
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
		
		return restaurante;
	}
	public Restaurante selecNomRest(String nombre) {
		Restaurante rest = null;
		
		String query = "SELECT NOMBRE, REGION, CIUDAD, DISTINCION, DIRECCION, PRECIO_MIN,"
				+ "PRECIO_MAX, COCINA, TELEFONO, WEB  FROM RESTAURANTES "
				+ "WHERE NOMBRE LIKE ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		//resultset solo se usa cuando la query es una select.
		ResultSet rslt = null;
		
		try {
			//Ejecutar
			con = adb.getConexion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + nombre + "%");
			rslt = pstmt.executeQuery();
			
			String nom;
			String reg;
			String ciu;
			int dis;
			String dir;
			double preMin;
			double preMax;
			String coc;
			String telef;
			String web;
			
			//Recuperar
			while (rslt.next()) {
				nom = rslt.getString(1);
				reg = rslt.getString(2);
				ciu = rslt.getString(3);
				dis = rslt.getInt(4);
				dir = rslt.getString(5);
				preMin = rslt.getDouble(6);
				preMax = rslt.getDouble(7);
				coc = rslt.getString(8);
				telef = rslt.getString(9);
				web = rslt.getString(10);			
			
				rest = new Restaurante(nom, reg, ciu, dis, dir, preMin, preMax, coc, telef, web);
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
		return rest;
	}
	public int updateRestaurante(Restaurante restaurante) {
		String query = "UPDATE RESTAURANTES SET REGION = ?, CIUDAD = ?, DISTINCION = ?, "
				+ "DIRECCION = ?, PRECIO_MIN = ?, PRECIO_MAX = ?, COCINA = ?, TELEFONO = ?, WEB = ? "
				+ "WHERE NOMBRE = ?";	
		
		Connection con = null;
		//El preparedStatement se usa cuando tenemos una interrogacion en la query.
		PreparedStatement pstmt = null;
		int res = 0;
		

		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			//Configuramos el prepareStatment
			
			pstmt.setString(1, restaurante.getRegion());
			pstmt.setString(2, restaurante.getCiudad());
			pstmt.setInt(3, restaurante.getDistincion());
			pstmt.setString(4, restaurante.getDireccion());
			pstmt.setDouble(5, restaurante.getPrecioMin());
			pstmt.setDouble(6, restaurante.getPrecioMax());
			pstmt.setString(7, restaurante.getCocina());
			pstmt.setString(8, restaurante.getTelefono());
			pstmt.setString(9, restaurante.getWeb());
			pstmt.setString(10, restaurante.getNombre());
			
			//res acumula el numero de registros modificados
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
	
}//FINAL CLASS
