package com.dam.maven.GuiaMichelin.model;

public class Restaurante {

	private String nombre;
	private String region;
	private String ciudad;
	private int distincion;
	private String direccion;
	private double precioMin;
	private double precioMax;
	private String cocina;
	private String telefono;
	private String web;
	
	public Restaurante(String nombre, String ciudad, int distincion, String cocina, double precioMin,
			double precioMax) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.distincion = distincion;
		this.cocina = cocina;
		this.precioMin = precioMin;
		this.precioMax = precioMax;

	}
	
	public Restaurante(String nombre, String region, String ciudad, int distincion, String direccion, double precioMin,
			double precioMax, String cocina, String telefono, String web) {
		this.nombre = nombre;
		this.region = region;
		this.ciudad = ciudad;
		this.distincion = distincion;
		this.direccion = direccion;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.cocina = cocina;
		this.telefono = telefono;
		this.web = web;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRegion() {
		return region;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getDistincion() {
		return distincion;
	}

	public String getDireccion() {
		return direccion;
	}

	public double getPrecioMin() {
		return precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public String getCocina() {
		return cocina;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getWeb() {
		return web;
	}

	
}
