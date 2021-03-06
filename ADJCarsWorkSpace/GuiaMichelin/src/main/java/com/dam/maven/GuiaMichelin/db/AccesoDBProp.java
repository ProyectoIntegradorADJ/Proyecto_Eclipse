package com.dam.maven.GuiaMichelin.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

/*Clase que facilita el metodo para conectar la BBDD*/
public class AccesoDBProp {
	
	private String driver;
	private String url;
	
	public AccesoDBProp() {
		
		FileInputStream fis = null;
		//la creacion de este objeto Nos va a permitir cargar el fichero 
		Properties prop = new Properties();
		
		//Creamos una comunicacion con un fichero
		try {
			fis = new FileInputStream("config.properties");
			prop.load(fis);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		//Class.forName produce la excepcion 
		Class.forName(driver);
		
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		
		//Pasamos la url para que se conecte a la base de datos
		Connection con = DriverManager.getConnection(url, config.toProperties());
		System.out.println("Conexión establecida con la BBDD");
		
		return con;
	}
	
}
