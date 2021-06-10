package dam.adjcars.model;

public class Vehiculo {

	private String marca;
	private String modelo;
	private int potencia;
	private String tipoVeh;
	private String tipoMotor;
	private String color;
	private String matricula;
	private String numBastidor;
	private String fecha_fab;

	// Constructor
	public Vehiculo(String marca, String modelo, int potencia, String tipoVeh, String tipoMotor, String color,
			String matricula, String numBastidor, String fecha_fab) {
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.tipoVeh = tipoVeh;
		this.tipoMotor = tipoMotor;
		this.color = color;
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.fecha_fab = fecha_fab;
	}

	// Panel Modificar
	public Vehiculo(int potencia, String tipoMotor, String color, String matricula) {
		this.potencia = potencia;
		this.tipoMotor = tipoMotor;
		this.color = color;
		this.matricula = matricula;
	}
	
	public Vehiculo(int potencia, String tipoMotor, String color) {
		this.potencia = potencia;
		this.tipoMotor = tipoMotor;
		this.color = color;
	}

	// Get y Set
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getTipoVeh() {
		return tipoVeh;
	}

	public void setTipoVeh(String tipoVeh) {
		this.tipoVeh = tipoVeh;
	}

	public String getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(String numBastidor) {
		this.numBastidor = numBastidor;
	}

	public String getFecha_fab() {
		return fecha_fab;
	}

	public void setFecha_fab(String fecha_fab) {
		this.fecha_fab = fecha_fab;
	}

}
